package cz.martlin.jukebox.mid.domain;

import cz.martlin.jukebox.mid.type.BaseType;
import cz.martlin.jukebox.mid.value.SimpleValue;

public interface Domain<D extends Domain<D>> extends SimpleValue {

	public DomainDescriptor<D> getDescriptor();

	public default BaseType getBaseType() {
		return getDescriptor().getType();
	}
}
