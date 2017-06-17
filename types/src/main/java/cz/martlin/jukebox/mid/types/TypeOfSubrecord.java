package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.values.ValueOfSubrecord;

public class TypeOfSubrecord<V extends ValueOfSubrecord<V>> extends TypeOfStructure<V> {

	public TypeOfSubrecord(Class<V> clazz) {
		super(clazz);
	}
}
