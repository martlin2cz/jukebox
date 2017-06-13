package cz.martlin.jukebox.mid.domain;

import cz.martlin.jukebox.rest.exceptions.NotDomainValueException;

public interface DomainConverter<T extends Domain> {

	public String toHumanOutput(T value);

	public T fromHumanOutput(String value) throws NotDomainValueException;
	
	public boolean isValidHumanOutput(String value);

	public String toComputerOutput(T value);

	public T fromComputerOutput(String value) throws NotDomainValueException;
	
	public boolean isValidComputerOutput(String value);
}
