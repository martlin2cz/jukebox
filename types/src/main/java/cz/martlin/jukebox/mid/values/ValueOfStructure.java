package cz.martlin.jukebox.mid.values;

import cz.martlin.jukebox.mid.type.BaseType;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.value.CompositeValue;

public interface ValueOfStructure<V extends ValueOfStructure<V>> //
		extends CompositeValue {

	public TypeOfStructure<V> getTypeOfStructure();

	@Override
	public default BaseType getBaseType() {
		return getTypeOfStructure();
	}

}
