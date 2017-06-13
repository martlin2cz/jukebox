package cz.martlin.jukebox.out.gui.provider;

import java.util.List;

import cz.martlin.jukebox.mid.model.type.DomainTypeDescriptor;
import cz.martlin.jukebox.mid.type.TypeOfRecord;
import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.out.gui.swing.frames.BaseRecordFrame;

public interface GUIProvider<C> {

	//TODO things like initialize component ?
	
	public C getComponentFor(DomainTypeDescriptor<?> type);
	
	public String getValueOf(C component);

	public void setValueOf(C component, String value);

	public BaseRecordFrame getFrameForRecord(BaseFrame owner, TypeOfRecord type, Record recordOrNull);
	
	public BaseRecordFrame getFrameFor(BaseFrame owner, TypeOfRecord type, List<Record> records);
}
