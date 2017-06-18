package cz.martlinorg.testapp1.gui.swing.frames.detail;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import cz.martlin.jukebox.mid.domains.Count;
import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.domains.Identificator;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.out.gui.swing.frames.BaseStructureFrame;
import cz.martlin.jukebox.out.gui.swing.validation.ValidationReport;
import cz.martlinorg.testapp1.dataobj.Person;

public class JPersonFrame extends BaseStructureFrame<Person> {

	private static final long serialVersionUID = 8747209565544234088L;

	private JLabel lblLogin;
	private JTextField txtName;
	private JSpinner spinChildren;

	public JPersonFrame(BaseFrame owner, TypeOfStructure<Person> type, Person person) {
		super(owner, type, person);

		initialize();
	}

	@Override
	protected JPanel createCenterPane() {
		JPanel pane = new JPanel(new GridLayout(3, 2)); // TODO count of attrs

		JLabel lblToLogin = new JLabel("Login");
		pane.add(lblToLogin);

		lblLogin = new JLabel();
		pane.add(lblLogin);

		JLabel lblToName = new JLabel("Name");
		pane.add(lblToName);

		txtName = new JTextField();
		pane.add(txtName);

		JLabel lblToChildren = new JLabel("Children");
		pane.add(lblToChildren);

		SpinnerModel spinChildrenModel = new SpinnerNumberModel(0, 0, 100, 1); // TODO
																				// max
																				// value
																				// of
																				// attr,
																				// where
																				// to
																				// infer?
		spinChildren = new JSpinner(spinChildrenModel);
		pane.add(spinChildren);

		return pane;
	}

	@Override
	protected void structureToForm(Person person) {
		this.lblLogin.setText(Identificator.TYPE.getConverter().toHumanOutput(person.getLogin()));
		this.txtName.setText(HumanName.TYPE.getConverter().toHumanOutput(person.getName()));
		this.spinChildren.setValue(person.getChildren().getValue());
	}

	@Override
	protected void defaultsToForm() {
		this.lblLogin.setText("login");
		this.txtName.setText("(Specify name here)");
		this.spinChildren.setValue(0);

		// TODO use particular attribute's default value
	}

	@Override
	protected void formToStructure(Person person) {
		person.setLogin(Identificator.TYPE.getConverter().fromHumanOutput(this.lblLogin.getText()));
		person.setName(HumanName.TYPE.getConverter().fromHumanOutput(this.txtName.getText()));
		person.setChildren(Count.TYPE.getConverter().fromHumanOutput(this.spinChildren.getValue().toString()));
	}

	@Override
	protected ValidationReport runValidation() {
		ValidationReport report = new ValidationReport();

		check(report, "login", this.lblLogin, "Required field");
		check(report, "name", this.txtName, "Required field");
		check(report, "children", this.spinChildren, "Invalid value"); // TODO
																		// test
																		// range

		return report;
	}

}
