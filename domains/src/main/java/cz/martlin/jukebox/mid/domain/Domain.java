package cz.martlin.jukebox.mid.domain;


public interface Domain<D extends Domain<D>> /*extends SimpleValue */{

	//TODO extend SimpleValue from different module
	
	public DomainDescriptor<D> getDescriptor();

}
