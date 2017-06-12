package cz.martlinorg.testapp1.impl.exceptions;

import java.util.Objects;

public class UnknownRecordTypeException extends IllegalArgumentException {
	
	public UnknownRecordTypeException(Object object) {
		super(Objects.toString(object));
	}

	public UnknownRecordTypeException(Object object, Exception e) {
		super(Objects.toString(object), e);
	}
}
