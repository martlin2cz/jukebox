package cz.martlin.jukebox.mid.domains;

import cz.martlin.jukebox.mid.domain.CommonDescriptor;
import cz.martlin.jukebox.mid.domain.Domain;
import cz.martlin.jukebox.mid.domain.DomainDescriptor;
import cz.martlin.jukebox.rest.Specifications;
import cz.martlin.jukebox.rest.exceptions.NotDomainValueException;

public class HumanName implements Domain<HumanName> {

	public static final DomainDescriptor<HumanName> DESCRIPTOR = new HumanNameDescriptor();
	private final String name;

	public HumanName(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}


	@Override
	public DomainDescriptor<HumanName> getDescriptor() {
		return DESCRIPTOR;
	}
	

	public static class HumanNameDescriptor extends CommonDescriptor<HumanName> {

		public HumanNameDescriptor() {
			super(HumanName.class);
		}

		@Override
		public String toHumanOutput(HumanName value) {
			return value.getName();
		}

		@Override
		public boolean isValidHumanOutput(String value) {
			return value.matches(Specifications.HUMAN_NAME_REGEX);
		}

		@Override
		public HumanName fromHumanOutput(String value) throws NotDomainValueException {
			if (isValidHumanOutput(value)) {
				return new HumanName(value);
			} else {
				throw new NotDomainValueException(value);
			}
		}

		@Override
		public String toComputerOutput(HumanName value) {
			return toHumanOutput(value);
		}

		@Override
		public HumanName fromComputerOutput(String value) throws NotDomainValueException {
			return fromHumanOutput(value);
		}

		@Override
		public boolean isValidComputerOutput(String value) {
			return isValidHumanOutput(value);
		}

	}

}
