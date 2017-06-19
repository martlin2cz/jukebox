package cz.martlin.jukebox.mid.values;

import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.types.TypeOfDomain;
import cz.martlin.jukebox.mid.value.SimpleValue;

public interface ValueOfDomain<V extends ValueOfDomain<V>> extends SimpleValue {

	public TypeOfDomain<V> getDomainType();

	@SuppressWarnings("unchecked")
	@Override
	public default <W extends SimpleValue> SimpleType<W> getSimpleType() {
		return (SimpleType<W>) getDomainType();
	}
}
