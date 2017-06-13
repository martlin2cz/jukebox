package cz.martlin.jukebox.rest.exceptions;

public class NotDomainValueException extends JukeboxException {


	private static final long serialVersionUID = 1744806326317628830L;

	public NotDomainValueException(String value) {
		super(value, new IllegalArgumentException("Invalid value"));
	}

	public NotDomainValueException(String value, Exception cause) {
		super(value, cause);
	}
	
}
