package cz.martlin.jukebox.mid.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.values.ValueOfOneOf;

public class TypeOfOneOf<V extends ValueOfOneOf<V>> //
		extends CommonType<V> implements SimpleType<V> {

	private final List<V> allPossibleValues;
	private final SimpleValueConverter<V> converter;

	public TypeOfOneOf(Class<V> clazz, SimpleValueConverter<V> converter, List<V> allPossibleValues) {
		super(clazz);

		this.converter = converter;
		this.allPossibleValues = allPossibleValues;
	}

	@SafeVarargs
	public TypeOfOneOf(Class<V> clazz, SimpleValueConverter<V> converter, V... values) {
		super(clazz);

		this.converter = converter;
		this.allPossibleValues = new ArrayList<>(Arrays.asList(values));
	}

	@Override
	public SimpleValueConverter<V> getConverter() {
		return converter;
	}

	@Override
	public String getName() {
		return "one of following: " + allPossibleValues.stream() //
				.map((v) -> getConverter().toComputerOutput(v)) //
				.collect(Collectors.joining(", "));
	}

}
