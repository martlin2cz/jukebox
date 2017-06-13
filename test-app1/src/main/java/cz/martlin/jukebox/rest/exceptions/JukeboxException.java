package cz.martlin.jukebox.rest.exceptions;

public abstract class JukeboxException extends RuntimeException {

	private static final long serialVersionUID = 5179445609621434274L;

	public JukeboxException(String message, Exception cause) {
		super(message, cause);
	}
}
