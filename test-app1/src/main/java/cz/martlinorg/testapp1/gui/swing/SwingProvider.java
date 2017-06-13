package cz.martlinorg.testapp1.gui.swing;

import javax.swing.JComponent;
import javax.swing.JTextField;

import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.model.type.DomainTypeDescriptor;
import cz.martlin.jukebox.out.gui.provider.GUIProvider;
import cz.martlin.jukebox.rest.exceptions.UnknownRecordTypeException;

public class SwingProvider implements GUIProvider<JComponent> {

	@Override
	public JComponent getComponentFor(DomainTypeDescriptor<?> type) {
		if (type.getName().equals(HumanName.DESCRIPTOR.getName())) {
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

}
