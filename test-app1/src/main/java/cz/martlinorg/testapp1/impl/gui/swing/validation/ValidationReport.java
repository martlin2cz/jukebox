package cz.martlinorg.testapp1.impl.gui.swing.validation;

import java.util.ArrayList;
import java.util.List;

import cz.martlinorg.testapp1.impl.model.Attribute;

public class ValidationReport {
	private final List<ValidationFailure> failures;

	public ValidationReport() {
		this.failures = new ArrayList<>();
	}

	public boolean isValid() {
		return failures.isEmpty();
	}

	public boolean hasSomeFailure() {
		return !failures.isEmpty();
	}

	public List<ValidationFailure> getFailures() {
		return failures;
	}

	public void add(Attribute attribute, Object value, String description) {
		ValidationFailure failure = new ValidationFailure(attribute, value, description);
		failures.add(failure);
	}

}
