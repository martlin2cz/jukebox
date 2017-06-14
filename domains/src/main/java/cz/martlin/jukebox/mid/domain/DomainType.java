package cz.martlin.jukebox.mid.domain;

import cz.martlin.jukebox.mid.type.SimpleType;

public class DomainType<D extends Domain<D>> implements SimpleType {

	private final Class<D> clazz;

	public DomainType(Class<D> clazz) {
		super();
		this.clazz = clazz;
	}

	public Class<D> getClazz() {
		return clazz;
	}

	@Override
	public String getName() {
		return clazz.getSimpleName();
	}
}
