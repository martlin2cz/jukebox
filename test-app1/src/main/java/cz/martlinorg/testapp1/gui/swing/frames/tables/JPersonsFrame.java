package cz.martlinorg.testapp1.gui.swing.frames.tables;

import java.util.List;

import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.out.gui.swing.frames.BaseObjectsTableFrame;
import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.model.TypeOfRecord;

public class JPersonsFrame extends BaseObjectsTableFrame<Person> {

	private static final long serialVersionUID = 2614671060570352658L;

	public JPersonsFrame(BaseFrame owner, List<Person> persons) {
		super(owner, TypeOfRecord.PERSON, persons);
	}
}
