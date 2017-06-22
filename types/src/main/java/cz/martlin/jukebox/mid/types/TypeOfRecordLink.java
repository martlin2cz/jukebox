package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.value.SimpleValue;

public class TypeOfRecordLink<T extends SimpleValue> //
		extends CommonType<T> implements SimpleType<T> {

	private final SimpleValueConverter<T> converter;

	public TypeOfRecordLink(Class<T> clazz, SimpleValueConverter<T> converter) {
		super(clazz);
		this.converter = converter;
	}

	@Override
	public SimpleValueConverter<T> getConverter() {
		return converter;
	}

	@Override
	public String getName() {
		return "link to " + clazz.getSimpleName();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
