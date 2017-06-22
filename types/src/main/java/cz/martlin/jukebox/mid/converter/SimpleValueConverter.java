package cz.martlin.jukebox.mid.converter;

import cz.martlin.jukebox.mid.value.SimpleValue;
import cz.martlin.jukebox.rest.exceptions.InvalidSimpleValueException;

public interface SimpleValueConverter<V extends SimpleValue> {
	public String toHumanOutput(V value);

	public V fromHumanOutput(String value) throws InvalidSimpleValueException;

	public boolean isValidHumanOutput(String value);

	public String toComputerOutput(V value);

	public V fromComputerOutput(String value) throws InvalidSimpleValueException;

	public boolean isValidComputerOutput(String value);
}
