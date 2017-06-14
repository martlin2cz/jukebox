package cz.martlin.jukebox.out.dataobj;

import cz.martlin.jukebox.mid.types.TypeOfRecord;

public abstract class Record<I> extends Structure {

	public Record(TypeOfRecord type) {
		super(type);
	}

	public abstract I getIdentifier();

}
