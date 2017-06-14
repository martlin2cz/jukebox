package cz.martlin.jukebox.mid.domain;

public interface DomainDescriptor<D extends Domain<D>> {
	public DomainType<D> getType();

	public DomainConverter<D> getConverter();

}
