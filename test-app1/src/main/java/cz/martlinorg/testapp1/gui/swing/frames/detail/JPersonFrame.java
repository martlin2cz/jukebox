package cz.martlinorg.testapp1.gui.swing.frames.detail;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.impl.db.Database;
import cz.martlinorg.testapp1.impl.gui.swing.frames.BaseFrame;
import cz.martlinorg.testapp1.impl.gui.swing.util.UIUtils;
import cz.martlinorg.testapp1.impl.gui.swing.validation.ValidationReport;
import cz.martlinorg.testapp1.impl.model.Attribute;
import cz.martlinorg.testapp1.impl.model.RecordType;
import cz.martlinorg.testapp1.rest.ProjectConfiguration;

public class JPersonFrame extends BaseFrame {

	public class CancelButtActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			close();
		}

	}

	public class SaveButtActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			save();
		}

	}

	private static final long serialVersionUID = 8747209565544234088L;

	private final Database database = ProjectConfiguration.get().getDatabase();
	private final Person person;

	private JTextField txtName;

	public JPersonFrame(BaseFrame owner, Person person) {
		super(owner, UIUtils.getFrameTitle(RecordType.PERSON));

		this.person = person;

		initialize();

	}

//	protected void initialize() {
//
//		initializeContent();
//
//		updateData();
//
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		pack();
//	}

	protected void initializeContent() {
		JPanel topPane = createTopPane();
		getContentPane().add(topPane, BorderLayout.NORTH);

		JPanel centerPane = createCenterPane();
		getContentPane().add(centerPane, BorderLayout.CENTER);

		JPanel bottomPane = createBottomPane();
		getContentPane().add(bottomPane, BorderLayout.SOUTH);

	}

	private JPanel createTopPane() {
		JPanel pane = new JPanel();

		JButton removeButt = new JButton("Delete");
		pane.add(removeButt);

		return pane;
	}

	private JPanel createCenterPane() {
		JPanel pane = new JPanel();

		JLabel lblName = new JLabel("Name");
		pane.add(lblName);

		txtName = new JTextField();
		pane.add(txtName);

		return pane;
	}

	private JPanel createBottomPane() {
		JPanel pane = new JPanel(new GridLayout(1, 2));

		JButton saveButt = new JButton("Save");
		saveButt.addActionListener(new SaveButtActionListener());
		pane.add(saveButt);

		JButton cancelButt = new JButton("Cancel");
		cancelButt.addActionListener(new CancelButtActionListener());
		pane.add(cancelButt);

		return pane;
	}

	protected void doUpdateData() {
		if (person != null) {
			recordToForm(person);
		} else {
			defaultsToForm();
		}

	}

	private void recordToForm(Person person) {
		this.txtName.setText(person.getName());
	}

	private void defaultsToForm() {
		this.txtName.setText("(Specify name here)");
	}

	private void formToRecord(Person person) {
		person.setName(this.txtName.getText());
	}

	private void close() {
		// TODO confirm before close?
		dispose();
	}

	private void save() {
		ValidationReport report = runValidation();
		if (report.hasSomeFailure()) {
			reportValidationFailures(report);
			return;
		}

		if (person == null) {
			Person person = new Person();
			formToRecord(person);
			database.create(person);
		} else {
			formToRecord(person);
			database.update(person);
		}
		
		fireDataChanged(this);
		dispose();
	}

	private ValidationReport runValidation() {
		ValidationReport report = new ValidationReport();
		
		if (this.txtName.getText().isEmpty()) {
			Attribute attribute = new Attribute("Name", String.class);	//TODO infer from model? :-O
			report.add(attribute, this.txtName.getText(), "Required field");	//TODO make from domain validator
		}

		return report;
	}

	private void reportValidationFailures(ValidationReport report) {
		JOptionPane.showMessageDialog(this, "Errors: " + report.getFailures().size());
	}

}
