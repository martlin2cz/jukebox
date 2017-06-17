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

}
