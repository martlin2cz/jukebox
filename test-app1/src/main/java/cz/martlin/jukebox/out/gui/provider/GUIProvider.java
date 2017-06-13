package cz.martlin.jukebox.out.gui.provider;

import cz.martlin.jukebox.mid.model.type.DomainTypeDescriptor;

public interface GUIProvider<C> {

	//TODO things like initialize component ?
	
	public C getComponentFor(DomainTypeDescriptor<?> type);
	
	public String getValueOf(C component);

	public void setValueOf(C component, String value);
}
