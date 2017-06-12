package cz.martlinorg.testapp1.impl.gui.swing.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.gui.swing.frames.detail.JPersonFrame;
import cz.martlinorg.testapp1.impl.dataobj.GeneralObject;
import cz.martlinorg.testapp1.impl.gui.swing.util.RecordsTableModel;
import cz.martlinorg.testapp1.impl.gui.swing.util.UIUtils;
import cz.martlinorg.testapp1.impl.model.RecordType;

public class BaseObjectsTableFrame<T extends GeneralObject> extends BaseFrame {

	private static final long serialVersionUID = -5502445028485072857L;

	protected final List<Person> persons;
	private JLabel lblCount;
	private AbstractTableModel model;

	public BaseObjectsTableFrame(BaseFrame owner, RecordType person, List<Person> persons) {
		super(owner, UIUtils.getFrameTitle(RecordType.PERSON));

		this.persons = persons;

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
		model = new RecordsTableModel<>(RecordType.PERSON, persons);

		JTable table = new JTable(model);

		return table;
	}

	@Override
	protected void doUpdateData() {
		String text = "Count: " + persons.size();
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
			JPersonFrame frame = new JPersonFrame(owner, null);
			frame.openFrame();
		}

	}

}