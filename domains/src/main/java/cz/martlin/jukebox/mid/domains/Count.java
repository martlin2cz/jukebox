package cz.martlin.jukebox.mid.domains;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.domain.Domain;
import cz.martlin.jukebox.mid.types.TypeOfDomain;
import cz.martlin.jukebox.rest.GlobalSpecifications;
import cz.martlin.jukebox.rest.exceptions.InvalidSimpleValueException;

public class Count implements Domain<Count>, Comparable<Count> {
	private static final long serialVersionUID = 8550436952938598517L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		Count other = (Count) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Count=" + value;
	}

	@Override
	public int compareTo(Count o) {
		return this.value - o.value;
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
			return value.matches(GlobalSpecifications.COUNT_REGEX);
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
