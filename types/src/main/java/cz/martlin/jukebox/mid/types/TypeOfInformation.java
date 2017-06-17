package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.values.ValueOfInformation;

public class TypeOfInformation<V extends ValueOfInformation<V>> extends TypeOfStructure<V> {

	public TypeOfInformation(Class<V> clazz) {
		super(clazz);
	}

}
