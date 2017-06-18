package cz.martlin.jukebox.rest.exceptions;

public class ConfigurationException extends JukeboxException {

	private static final long serialVersionUID = -3271008245288253104L;

	public ConfigurationException(String message, Exception cause) {
		super(message, cause);
	}

}
