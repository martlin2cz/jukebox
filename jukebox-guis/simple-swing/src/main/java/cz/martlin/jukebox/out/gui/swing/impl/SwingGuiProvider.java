package cz.martlin.jukebox.out.gui.swing.impl;

import javax.swing.JComponent;

import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.out.gui.provider.GuiConfiguration;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;

public interface SwingGuiProvider extends GuiConfiguration {

	// TODO things like initialize component ?

	public JComponent getComponentFor(SimpleType<?> type);

	public String getValueOf(JComponent component);

	public void setValueOf(JComponent component, String value);

	public <V extends ValueOfStructure<V>> BaseFrame getFrameForRecord(BaseFrame owner, TypeOfStructure<V> type,
			V structureOrNull);

	public <V extends ValueOfStructure<V>> BaseFrame getFrameFor(BaseFrame owner, TypeOfStructure<V> type);
}
