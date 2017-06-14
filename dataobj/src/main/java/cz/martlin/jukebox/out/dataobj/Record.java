package cz.martlin.jukebox.out.dataobj;

import cz.martlin.jukebox.mid.types.TypeOfRecord;

public abstract class Record<I> extends Structure {

	public Record(Class<?> clazz) {
		super(new TypeOfRecord(clazz));
	}

	public abstract I getIdentifier();

	public TypeOfRecord getType() {
		return getType();
	}

}
