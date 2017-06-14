package cz.martlin.jukebox.out.dataobj;

import cz.martlin.jukebox.mid.type.BaseType;
import cz.martlin.jukebox.mid.type.CompositeType;
import cz.martlin.jukebox.mid.value.CompositeValue;

public abstract class Structure implements CompositeValue {

	private final CompositeType type;

	public Structure(CompositeType type) {
		super();
		this.type = type;
	}

	@Override
	public BaseType getBaseType() {
		return type;
	}

}
