package cz.martlin.jukebox.mid.model.attr;

import cz.martlin.jukebox.mid.type.SimpleType;

public class Attribute {
	private final String name;
	private final AttributeLevel level;
	private final SimpleType type;
	private final boolean emptyable;
	private final Object defaultValue;

	public Attribute(String name, AttributeLevel level, SimpleType type, boolean emptyable, Object defaultValue) {
		super();
		this.name = name;
		this.level = level;
		this.type = type;
		this.emptyable = emptyable;
		this.defaultValue = defaultValue;
	}

	public String getName() {
		return name;
	}

	public AttributeLevel getLevel() {
		return level;
	}

	public SimpleType getType() {
		return type;
	}

	public boolean isEmptyable() {
		return emptyable;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}
}
