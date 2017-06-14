package cz.martlin.jukebox.out.gui.swing.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.out.dataobj.Structure;
import cz.martlin.jukebox.out.gui.provider.GUIProvider;
import cz.martlin.jukebox.out.gui.swing.util.RecordsTableModel;
import cz.martlin.jukebox.out.gui.swing.util.UIUtils;
import cz.martlin.jukebox.rest.ProjectConfiguration;


public class BaseObjectsTableFrame<S extends Structure> extends BaseFrame {

	private static final long serialVersionUID = -5502445028485072857L;

	private final TypeOfStructure type;
	private final GUIProvider<JComponent, BaseFrame> provider;
	
	protected final List<S> records;

	private AbstractTableModel model;
	private JLabel lblCount;
	
	public BaseObjectsTableFrame(BaseFrame owner, TypeOfStructure type, List<S> records) {
		super(owner, UIUtils.getFrameTitle(type));

		this.type = type;
		this.provider = (GUIProvider<JComponent, BaseFrame>) ProjectConfiguration.get().getGuiProvider();
		
		this.records = records;

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
		buttAdd.addActionListener(new ButtAddActionListener(this));
		pane.add(buttAdd);

		return pane;
	}

	private JTable createTable() {
		model = new RecordsTableModel<S>(type, records);

		JTable table = new JTable(model);

		return table;
	}

	@Override
	protected void doUpdateData() {
		String text = "Count: " + records.size();
		lblCount.setText(text);
		
		model.fireTableDataChanged();
	}

	public class ButtAddActionListener implements ActionListener {

		private final BaseFrame owner;

		public ButtAddActionListener(BaseFrame owner) {
			this.owner = owner;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			BaseFrame frame = provider.getFrameForRecord(owner, type, null);
			frame.openFrame();
		}

	}

}