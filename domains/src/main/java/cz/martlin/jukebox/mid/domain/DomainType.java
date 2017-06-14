package cz.martlin.jukebox.mid.domain;

public class DomainType<D extends Domain<D>> {
	// TODO inherit some general base type or what

	private final Class<D> clazz;

	public DomainType(Class<D> clazz) {
		super();
		this.clazz = clazz;
	}

	public Class<D> getClazz() {
		return clazz;
	}
}
