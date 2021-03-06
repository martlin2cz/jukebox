package cz.martlin.jukebox.mid.domains;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.domain.Domain;
import cz.martlin.jukebox.mid.types.TypeOfDomain;
import cz.martlin.jukebox.rest.GlobalSpecifications;
import cz.martlin.jukebox.rest.exceptions.InvalidSimpleValueException;

public class HumanName implements Domain<HumanName>, Comparable<HumanName> {
	private static final long serialVersionUID = 1428471049489308846L;
	public static final TypeOfDomain<HumanName> TYPE = new TypeOfDomain<>(HumanName.class, new HumanNameConverter());

	private final String name;

	public HumanName(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public TypeOfDomain<HumanName> getDomainType() {
		return TYPE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		HumanName other = (HumanName) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HumaName=" + name;
	}

	@Override
	public int compareTo(HumanName o) {
		return this.name.compareTo(o.name);
	}

	public static class HumanNameConverter implements SimpleValueConverter<HumanName> {

		@Override
		public String toHumanOutput(HumanName value) {
			return value.getName();
		}

		@Override
		public boolean isValidHumanOutput(String value) {
			return value.matches(GlobalSpecifications.HUMAN_NAME_REGEX);
		}

		@Override
		public HumanName fromHumanOutput(String value) throws InvalidSimpleValueException {
			if (isValidHumanOutput(value)) {
				return new HumanName(value);
			} else {
				throw new InvalidSimpleValueException(value);
			}
		}

		@Override
		public String toComputerOutput(HumanName value) {
			return toHumanOutput(value);
		}

		@Override
		public HumanName fromComputerOutput(String value) throws InvalidSimpleValueException {
			return fromHumanOutput(value);
		}

		@Override
		public boolean isValidComputerOutput(String value) {
			return isValidHumanOutput(value);
		}

	}

}
