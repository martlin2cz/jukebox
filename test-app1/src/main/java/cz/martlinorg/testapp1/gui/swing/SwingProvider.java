package cz.martlinorg.testapp1.gui.swing;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import cz.martlin.jukebox.mid.domains.Count;
import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.domains.Identificator;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.out.gui.provider.GUIProvider;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.rest.exceptions.UnknownRecordTypeException;
import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.gui.swing.frames.detail.JPersonFrame;
import cz.martlinorg.testapp1.gui.swing.frames.tables.JPersonsFrame;

public class SwingProvider implements GUIProvider<JComponent, BaseFrame> {

	@Override
	public JComponent getComponentFor(SimpleType<?> type) {
		if (type.equals(HumanName.TYPE)) {
			return new JTextField();
		}
		if (type.equals(Identificator.TYPE)) {
			return new JLabel();
		}
		if (type.equals(Count.TYPE)) {
			return new JSpinner();
		}

		throw new UnknownRecordTypeException(type);
	}

	// TODO value of component is ALLWAYS String? In spinner or color picker as
	// well? And FileUploader?
	@Override
	public String getValueOf(JComponent component) {
		if (component instanceof JTextField) {
			return ((JTextField) component).getText();
		}
		if (component instanceof JLabel) {
			return ((JLabel) component).getText();
		}
		if (component instanceof JSpinner) {
			return ((JSpinner) component).getValue().toString();
		}

		throw new UnknownRecordTypeException(component);
	}

	@Override
	public void setValueOf(JComponent component, String value) {
		if (component instanceof JTextField) {
			((JTextField) component).setText(value);
		}
		if (component instanceof JLabel) {
			((JLabel) component).setText(value);
		}
		if (component instanceof JSpinner) {
			((JSpinner) component).setValue(value); // TODO parseint? use
													// converter?
		}

		throw new UnknownRecordTypeException(component);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends ValueOfStructure<S>> BaseFrame //
			getFrameForRecord(BaseFrame owner, TypeOfStructure<S> type, S structureOrNull) {
		
		return new JPersonFrame(owner, (TypeOfStructure<Person>) type, (Person) structureOrNull);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends ValueOfStructure<S>> BaseFrame //
			getFrameFor(BaseFrame owner, TypeOfStructure<S> type, List<S> structures) {
		
		return new JPersonsFrame(owner, (List<Person>) structures);
	}

}
