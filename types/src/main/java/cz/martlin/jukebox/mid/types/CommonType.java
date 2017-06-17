package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.type.BaseType;

public abstract class CommonType<T> implements BaseType {

	protected final Class<T> clazz;

	public CommonType(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	public Class<T> getTypeClazz() {
		return clazz;
	}

}