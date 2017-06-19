package cz.martlin.jukebox.mid.value;

import cz.martlin.jukebox.mid.type.BaseType;
import cz.martlin.jukebox.mid.type.SimpleType;

public interface SimpleValue extends BaseValue {
	public <V extends SimpleValue> SimpleType<V> getSimpleType();

	@Override
	public default BaseType getBaseType() {
		return getSimpleType();
	}
}
