package cz.martlin.jukebox.mid.domain;

import cz.martlin.jukebox.mid.model.type.DomainTypeDescriptor;

public interface Domain {

	
	public <T extends Domain> DomainTypeDescriptor<T> getDescriptor();
	
}
