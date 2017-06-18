package cz.martlin.jukebox.out.gui.provider;

import java.util.List;

import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;

public interface GUIProvider<C, F> {

	// TODO things like initialize component ?

	public C getComponentFor(SimpleType<?> type);

	public String getValueOf(C component);

	public void setValueOf(C component, String value);

	public <V extends ValueOfStructure<V>> F getFrameForRecord(F owner, TypeOfStructure<V> type, V structureOrNull);

	public <V extends ValueOfStructure<V>> F getFrameFor(F owner, TypeOfStructure<V> type, List<V> structure);
}
