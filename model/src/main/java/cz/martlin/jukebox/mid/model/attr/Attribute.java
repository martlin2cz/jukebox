package cz.martlin.jukebox.mid.model.attr;

import cz.martlin.jukebox.mid.model.type.TypeOfAttribute;
import cz.martlin.jukebox.mid.type.SimpleType;

public class Attribute {
	private final String name;
	private final AttributeLevel level;
	private final SimpleType type;
	private final boolean isEmptyable;

	public Attribute(String name, AttributeLevel level, SimpleType type, boolean isEmptyable) {
		super();
		this.name = name;
		this.level = level;
		this.type = type;
		this.isEmptyable = isEmptyable;
	}

	public String getName() {
		return name;
	}

	public AttributeLevel getLevel() {
		return level;
	}

	public TypeOfAttribute getType() {
		return type;
	}
	
	public boolean isEmptyable() {
		return isEmptyable;
	}
}
