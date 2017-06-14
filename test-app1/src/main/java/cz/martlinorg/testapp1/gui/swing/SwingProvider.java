package cz.martlinorg.testapp1.gui.swing;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextField;

import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlin.jukebox.out.gui.provider.GUIProvider;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.rest.exceptions.UnknownRecordTypeException;
import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.gui.swing.frames.detail.JPersonFrame;
import cz.martlinorg.testapp1.gui.swing.frames.tables.JPersonsFrame;

public class SwingProvider implements GUIProvider<JComponent, BaseFrame> {

	@Override
	public JComponent getComponentFor(SimpleType type) {
		if (type.equals(HumanName.DESCRIPTOR.getType())) {
			return new JTextField();
		} else {
			throw new UnknownRecordTypeException(type);
			// TODO UnknownDomainTypeExceptiun or what?
		}
	}

	// TODO value of component is ALLWAYS String? In spinner or color picker as
	// well? And FileUploader?
	@Override
	public String getValueOf(JComponent component) {
		return ((JTextField) component).getText();
	}

	@Override
	public void setValueOf(JComponent component, String value) {
		((JTextField) component).setText(value);
	}

	@Override
	public BaseFrame getFrameForRecord(BaseFrame owner, TypeOfStructure type, Record<?> structureOrNull) {
		return new JPersonFrame(owner, type, (Person) structureOrNull);
	}

	@Override
	public BaseFrame getFrameFor(BaseFrame owner, TypeOfStructure type, List<Record<?>> structures) {
		return new JPersonsFrame(owner, (List<Person>)(Object) structures);
	}

}
