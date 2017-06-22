package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.type.CompositeType;
import cz.martlin.jukebox.mid.value.CompositeValue;

public abstract class TypeOfStructure<V extends CompositeValue> //
		extends CommonType<V> implements CompositeType {

	public TypeOfStructure(Class<V> clazz) {
		super(clazz);
	}

	@Override
	public String getName() {
		return clazz.getSimpleName();
	}

}
