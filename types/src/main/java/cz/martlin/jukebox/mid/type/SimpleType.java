package cz.martlin.jukebox.mid.type;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.value.SimpleValue;

public interface SimpleType<V extends SimpleValue> extends BaseType {

	public SimpleValueConverter<V> getConverter();
}
