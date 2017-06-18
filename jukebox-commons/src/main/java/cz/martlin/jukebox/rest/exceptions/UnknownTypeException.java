package cz.martlin.jukebox.rest.exceptions;

import java.util.Objects;

public class UnknownTypeException extends IllegalArgumentException {
	

	private static final long serialVersionUID = 6684040104197838639L;

	public UnknownTypeException(Object object) {
		super(Objects.toString(object), new IllegalArgumentException("Unknown record type"));
	}

	public UnknownTypeException(Object object, Exception e) {
		super(Objects.toString(object), e);
	}
}
