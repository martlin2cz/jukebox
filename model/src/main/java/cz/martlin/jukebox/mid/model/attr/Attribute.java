package cz.martlin.jukebox.mid.model.attr;

import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.value.SimpleValue;

public class Attribute<V extends SimpleValue> {
	private final String name;
	private final AttributeLevel level;
	private final SimpleType<V> type;
	private final boolean emptyable;
	private final V defaultValue;

	public Attribute(String name, AttributeLevel level, SimpleType<V> type, boolean emptyable, V defaultValue) {
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

	public SimpleType<V> getType() {
		return type;
	}

	public boolean isEmptyable() {
		return emptyable;
	}

	public V getDefaultValue() {
		return defaultValue;
	}
}
