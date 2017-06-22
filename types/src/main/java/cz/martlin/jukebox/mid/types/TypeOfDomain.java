package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.values.ValueOfDomain;

public class TypeOfDomain<V extends ValueOfDomain<V>> //
		extends CommonType<V> implements SimpleType<V> {

	private final SimpleValueConverter<V> converter;

	public TypeOfDomain(Class<V> clazz, SimpleValueConverter<V> converter) {
		super(clazz);
		this.converter = converter;
	}

	public Class<V> getClazz() {
		return clazz;
	}

	@Override
	public SimpleValueConverter<V> getConverter() {
		return converter;
	}

	@Override
	public String getName() {
		return clazz.getSimpleName();
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
