package cz.martlin.jukebox.out.gui.swing.validation;

import java.util.ArrayList;
import java.util.List;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.value.SimpleValue;

public class ValidationReport {
	private final List<ValidationFailure<?>> failures;

	public ValidationReport() {
		this.failures = new ArrayList<>();
	}

	public boolean isValid() {
		return failures.isEmpty();
	}

	public boolean hasSomeFailure() {
		return !failures.isEmpty();
	}

	public List<ValidationFailure<?>> getFailures() {
		return failures;
	}

	public <V extends SimpleValue> void add(Attribute<V> attribute, String value, String description) {
		ValidationFailure<V> failure = new ValidationFailure<>(attribute, value, description);
		failures.add(failure);
	}

}
