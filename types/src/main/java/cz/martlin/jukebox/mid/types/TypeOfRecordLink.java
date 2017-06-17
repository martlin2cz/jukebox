package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.value.SimpleValue;

public class TypeOfRecordLink<T extends SimpleValue> implements SimpleType<T> {

	private final Class<?> clazz;
	private final SimpleValueConverter<T> converter;

	public TypeOfRecordLink(Class<?> clazz, SimpleValueConverter<T> converter) {
		super();
		this.clazz = clazz;
		this.converter = converter;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	@Override
	public SimpleValueConverter<T> getConverter() {
		return converter;
	}

	@Override
	public String getName() {
		return "link to " + clazz.getSimpleName();
	}
}
