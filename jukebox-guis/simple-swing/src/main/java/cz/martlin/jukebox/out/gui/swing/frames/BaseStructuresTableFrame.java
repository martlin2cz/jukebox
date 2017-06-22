package cz.martlin.jukebox.out.gui.swing.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.out.db.Database;
import cz.martlin.jukebox.out.gui.swing.impl.UIUtils;
import cz.martlin.jukebox.out.gui.swing.util.Actions;
import cz.martlin.jukebox.out.gui.swing.util.RecordsTableModel;
import cz.martlin.jukebox.out.gui.swing.util.StructuresTableRenderer;
import cz.martlin.jukebox.out.rest.ProjectConfiguration;

public class BaseStructuresTableFrame<S extends ValueOfStructure<S>> extends BaseFrame {

	private static final long serialVersionUID = -5502445028485072857L;

	private final TypeOfStructure<S> type;
	private final Database database;

	// protected final ;

	private RecordsTableModel<S> model;
	private JLabel lblCount;

	public BaseStructuresTableFrame(BaseFrame owner, TypeOfStructure<S> type) {
		super(owner, UIUtils.getFrameTitle(type));

		this.type = type;
		this.database = ProjectConfiguration.get().getDatabase();

		initialize();
	}

	@Override
	protected void initializeContent() {
		JPanel pane = createTopPanel();
		getContentPane().add(pane, BorderLayout.NORTH);

		JTable table = createTable();
		getContentPane().add(table, BorderLayout.CENTER);
	}

	private JPanel createTopPanel() {
		JPanel pane = new JPanel();

		lblCount = new JLabel("Count: ???");
		pane.add(lblCount);

		JButton buttAdd = new JButton("Add");
		buttAdd.setAction(new Actions.AddAction<>(this, type));
		pane.add(buttAdd);

		return pane;
	}

	private JTable createTable() {
		model = new RecordsTableModel<S>(this, type);

		JTable table = new JTable(model);

		StructuresTableRenderer renderer = new StructuresTableRenderer();
		table.setDefaultRenderer(Object.class, renderer);

		MouseListener listener = new TableMouseListener(table);
		table.addMouseListener(listener);

		return table;
	}

	@Override
	protected void doUpdateData() {
		List<S> records = database.list(type);

		String text = "Count: " + records.size();
		lblCount.setText(text);

		model.setRecords(records);
		model.fireTableDataChanged();
	}

	public class TableMouseListener extends MouseAdapter implements MouseListener {

		private final JTable table;

		public TableMouseListener(JTable table) {
			this.table = table;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			Action action = inferActionOrNot(e);
			if (action != null) {
				ActionEvent evt = new ActionEvent(e.getSource(), e.getID(), e.getClass().toString());
				action.actionPerformed(evt);
			}
		}

		private Action inferActionOrNot(MouseEvent e) {
			int column = table.getColumnModel().getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();

			if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
				Object value = table.getValueAt(row, column);
				if (value instanceof Action) {
					Action action = (Action) value;
					return action;
				}
			}

			return null;
		}
	}

}