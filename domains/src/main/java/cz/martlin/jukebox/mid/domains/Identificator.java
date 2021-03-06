package cz.martlin.jukebox.mid.domains;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.domain.Domain;
import cz.martlin.jukebox.mid.types.TypeOfDomain;
import cz.martlin.jukebox.rest.GlobalSpecifications;
import cz.martlin.jukebox.rest.exceptions.InvalidSimpleValueException;

public class Identificator implements Domain<Identificator> {
	private static final long serialVersionUID = -4317981800437200232L;
	public static final TypeOfDomain<Identificator> TYPE = //
			new TypeOfDomain<>(Identificator.class, new IdentificatorConverter());

	private final String value;

	public Identificator(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public TypeOfDomain<Identificator> getDomainType() {
		return TYPE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Identificator other = (Identificator) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Identificator=" + value;
	}

	public static class IdentificatorConverter implements SimpleValueConverter<Identificator> {

		@Override
		public String toHumanOutput(Identificator value) {
			return value.getValue();
		}

		@Override
		public Identificator fromHumanOutput(String value) throws InvalidSimpleValueException {
			if (isValidHumanOutput(value)) {
				return new Identificator(value);
			} else {
				throw new InvalidSimpleValueException(value);
			}
		}

		@Override
		public boolean isValidHumanOutput(String value) {
			return value.matches(GlobalSpecifications.IDENTIFICATOR_REGEX);
		}

		@Override
		public String toComputerOutput(Identificator value) {
			return toHumanOutput(value);
		}

		@Override
		public Identificator fromComputerOutput(String value) throws InvalidSimpleValueException {
			return fromHumanOutput(value);
		}

		@Override
		public boolean isValidComputerOutput(String value) {
			return isValidHumanOutput(value);
		}

	}

}
