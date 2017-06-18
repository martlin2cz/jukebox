package cz.martlin.jukebox.out.gui.swing.validation;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.value.SimpleValue;

public class ValidationFailure<V extends SimpleValue> {

	private final Attribute<V> attribute;
	private final String value;
	private final String description;

	public ValidationFailure(Attribute<V> attribute, String value, String description) {
		super();
		this.attribute = attribute;
		this.value = value;
		this.description = description;
	}

	public Attribute<V> getAttribute() {
		return attribute;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

}
