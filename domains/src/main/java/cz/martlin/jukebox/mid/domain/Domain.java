package cz.martlin.jukebox.mid.domain;

import cz.martlin.jukebox.mid.model.type.DomainTypeDescriptor;
import cz.martlin.jukebox.mid.value.SimpleValue;

public interface Domain extends SimpleValue {

	public <T extends Domain> DomainTypeDescriptor<T> getDescriptor();

}
