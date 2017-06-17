package cz.martlin.jukebox.rest.exceptions;

public class InvalidSimpleValueException extends JukeboxException {
	private static final long serialVersionUID = 1744806326317628830L;

	public InvalidSimpleValueException(String value) {
		super(value, new IllegalArgumentException("Invalid value"));
	}

	public InvalidSimpleValueException(String value, Exception cause) {
		super(value, cause);
	}

}
