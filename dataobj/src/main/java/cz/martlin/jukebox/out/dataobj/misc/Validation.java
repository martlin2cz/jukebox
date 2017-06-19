package cz.martlin.jukebox.out.dataobj.misc;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.value.SimpleValue;
import cz.martlin.jukebox.rest.exceptions.ValidationFailureException;

public class Validation {

	public static <V extends SimpleValue> void checkNotEmpty(String attribute, V value)
			throws ValidationFailureException {
		if (isEmpty(value)) {
			String reason = "must not be empty";
			throw new ValidationFailureException(attribute, reason);
		}
	}

	public static <V extends SimpleValue & Comparable<V>> void checkMinimal(String attribute, V value, V minValue)
			throws ValidationFailureException {

		if (value == null) {
			return;
		}

		if (!isMoreThanMinimal(value, minValue)) {
			SimpleType<V> type = value.getSimpleType();
			SimpleValueConverter<V> converter = type.getConverter();

			String reason = converter.toHumanOutput(value) + " is not greater than "
					+ converter.toComputerOutput(minValue);

			throw new ValidationFailureException(attribute, reason);
		}
	}

	public static <V extends SimpleValue & Comparable<V>> void checkMaximal(String attribute, V value, V maxValue)
			throws ValidationFailureException {

		if (value == null) {
			return;
		}

		if (!isLessThanMaximal(value, maxValue)) {
			SimpleType<V> type = value.getSimpleType();
			SimpleValueConverter<V> converter = type.getConverter();

			String reason = converter.toHumanOutput(value) + " is not lower than "
					+ converter.toComputerOutput(maxValue);

			throw new ValidationFailureException(attribute, reason);
		}
	}

	public static <V extends SimpleValue & Comparable<V>> boolean isMoreThanMinimal(V value, V minValue) {
		return value.compareTo(minValue) > 0;
	}

	public static <V extends SimpleValue & Comparable<V>> boolean isLessThanMaximal(V value, V maxValue) {
		return value.compareTo(maxValue) < 0;
	}

	public static <V extends SimpleValue> boolean isEmpty(V value) {
		return value == null;
	}

}
