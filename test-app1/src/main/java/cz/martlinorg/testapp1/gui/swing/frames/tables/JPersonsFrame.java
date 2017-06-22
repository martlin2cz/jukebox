package cz.martlinorg.testapp1.gui.swing.frames.tables;

import cz.martlin.jukebox.mid.types.TypeOfRecord;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.out.gui.swing.frames.BaseStructuresTableFrame;
import cz.martlinorg.testapp1.dataobj.Person;

public class JPersonsFrame extends BaseStructuresTableFrame<Person> {

	private static final long serialVersionUID = 2614671060570352658L;

	public JPersonsFrame(BaseFrame owner) {
		super(owner, new TypeOfRecord<>(Person.class));
	}
}
