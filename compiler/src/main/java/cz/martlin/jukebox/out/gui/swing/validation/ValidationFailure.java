package cz.martlin.jukebox.out.gui.swing.validation;

import cz.martlin.jukebox.mid.model.attr.Attribute;

public class ValidationFailure {

	private final Attribute attribute;
	private final Object value;
	private final String description;

	public ValidationFailure(Attribute attribute, Object value, String description) {
		super();
		this.attribute = attribute;
		this.value = value;
		this.description = description;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public Object getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

}
