package cz.martlin.jukebox.mid.domains;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.domain.Domain;
import cz.martlin.jukebox.mid.types.TypeOfDomain;
import cz.martlin.jukebox.rest.Specifications;
import cz.martlin.jukebox.rest.exceptions.InvalidSimpleValueException;

public class Count implements Domain<Count> {

	public static final TypeOfDomain<Count> TYPE = //
			new TypeOfDomain<>(Count.class, new CountConverter());

	private final int value;

	public Count(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public TypeOfDomain<Count> getDomainType() {
		return TYPE;
	}

	public static class CountConverter implements SimpleValueConverter<Count> {

		@Override
		public String toHumanOutput(Count value) {
			return Integer.toString(value.getValue());
		}

		@Override
		public Count fromHumanOutput(String value) throws InvalidSimpleValueException {
			try {
				int num = Integer.parseInt(value);
				if (num < 0) {
					throw new InvalidSimpleValueException(value);
				}
				return new Count(num);
			} catch (Exception e) {
				throw new InvalidSimpleValueException(value);
			}
		}

		@Override
		public boolean isValidHumanOutput(String value) {
			return value.matches(Specifications.COUNT_REGEX);
		}

		@Override
		public String toComputerOutput(Count value) {
			return toHumanOutput(value);
		}

		@Override
		public Count fromComputerOutput(String value) throws InvalidSimpleValueException {
			return fromHumanOutput(value);
		}

		@Override
		public boolean isValidComputerOutput(String value) {
			return isValidHumanOutput(value);
		}

	}

}
