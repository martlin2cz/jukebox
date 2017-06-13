package cz.martlin.jukebox.rest.exceptions;

import java.util.Objects;

public class UnknownRecordTypeException extends IllegalArgumentException {
	

	private static final long serialVersionUID = 6684040104197838639L;

	public UnknownRecordTypeException(Object object) {
		super(Objects.toString(object), new IllegalArgumentException("Unknown record type"));
	}

	public UnknownRecordTypeException(Object object, Exception e) {
		super(Objects.toString(object), e);
	}
}
