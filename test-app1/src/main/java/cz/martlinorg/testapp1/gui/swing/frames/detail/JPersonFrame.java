package cz.martlinorg.testapp1.gui.swing.frames.detail;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.out.gui.swing.frames.BaseRecordFrame;
import cz.martlin.jukebox.out.gui.swing.validation.ValidationReport;
import cz.martlinorg.testapp1.dataobj.Person;

public class JPersonFrame extends BaseRecordFrame<Person> {

	private static final long serialVersionUID = 8747209565544234088L;

	JTextField txtName;

	public JPersonFrame(BaseFrame owner, TypeOfStructure<Person> type, Person person) {
		super(owner, type, person);

		initialize();
	}

	@Override
	protected JPanel createCenterPane() {
		JPanel pane = new JPanel();

		JLabel lblName = new JLabel("Name");
		pane.add(lblName);

		txtName = new JTextField();
		pane.add(txtName);

		return pane;
	}

	@Override
	protected void structureToForm(Person person) {
		this.txtName.setText(person.getName().getDomainType().getConverter().toHumanOutput(person.getName()));
	}

	@Override
	protected void defaultsToForm() {
		this.txtName.setText("(Specify name here)"); 
		// TODO use particular attribute's default value
	}

	@Override
	protected void formToStructure(Person person) {
		person.setName(person.getName().getDomainType().getConverter().fromHumanOutput(this.txtName.getText()));
	}

	@Override
	protected ValidationReport runValidation() {
		ValidationReport report = new ValidationReport();

		Attribute<?> attrName = model.getAttribute("name");
		if (!isValid(attrName, this.txtName)) {
			
			report.add(attrName, this.txtName.getText(), "Required field");
		}

		return report;
	}

}
