package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.values.ValueOfRecord;

public class TypeOfRecord<V extends ValueOfRecord<V>> extends TypeOfStructure<V> {

	public TypeOfRecord(Class<V> clazz) {
		super(clazz);
	}

}
