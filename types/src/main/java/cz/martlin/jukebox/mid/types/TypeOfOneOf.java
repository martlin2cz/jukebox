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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((allPossibleValues == null) ? 0 : allPossibleValues.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeOfOneOf<?> other = (TypeOfOneOf<?>) obj;
		if (allPossibleValues == null) {
			if (other.allPossibleValues != null)
				return false;
		} else if (!allPossibleValues.equals(other.allPossibleValues))
			return false;
		return true;
	}

}
