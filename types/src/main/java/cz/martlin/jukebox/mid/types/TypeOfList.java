package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.value.SimpleValue;

public class TypeOfList<T extends SimpleValue> implements SimpleType<T> {

	private final SimpleType<T> typeOfItems;
	private final SimpleValueConverter<T> converter;

	public TypeOfList(SimpleType<T> typeOfItems, SimpleValueConverter<T> converter) {
		super();
		this.typeOfItems = typeOfItems;
		this.converter = converter;
	}

	public SimpleType<T> getTypeOfItems() {
		return typeOfItems;
	}

	@Override
	public String getName() {
		return "list of " + typeOfItems.getName();
	}

	@Override
	public SimpleValueConverter<T> getConverter() {
		return converter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeOfItems == null) ? 0 : typeOfItems.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeOfList<?> other = (TypeOfList<?>) obj;
		if (typeOfItems == null) {
			if (other.typeOfItems != null)
				return false;
		} else if (!typeOfItems.equals(other.typeOfItems))
			return false;
		return true;
	}

}
