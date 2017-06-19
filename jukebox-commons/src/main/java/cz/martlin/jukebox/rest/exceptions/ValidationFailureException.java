package cz.martlin.jukebox.rest.exceptions;

public class ValidationFailureException extends JukeboxException {

	private static final long serialVersionUID = 7622621737174081296L;
	private final String attribute;
	private final String reason;

	public ValidationFailureException(String attribute, String reason, Exception cause) {
		super(attribute + ": " + reason, cause);

		this.attribute = attribute;
		this.reason = reason;
	}

	public ValidationFailureException(String attribute, String reason) {
		this(attribute, reason, null);
	}

	public String getAttribute() {
		return attribute;
	}

	public String getReason() {
		return reason;
	}

}
