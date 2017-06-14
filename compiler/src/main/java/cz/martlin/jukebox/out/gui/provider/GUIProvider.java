package cz.martlin.jukebox.out.gui.provider;

import java.util.List;

import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.out.dataobj.Record;

public interface GUIProvider<C, F> {

	//TODO things like initialize component ?
	
	public C getComponentFor(SimpleType type);
	
	public String getValueOf(C component);

	public void setValueOf(C component, String value);

	public F getFrameForRecord(F owner, TypeOfStructure type, Record<?> structureOrNull);
	
	public F getFrameFor(F owner, TypeOfStructure type, List<Record<?>> structure);
}
