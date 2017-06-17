package cz.martlin.jukebox.mid.domain;

import cz.martlin.jukebox.mid.type.BaseType;
import cz.martlin.jukebox.mid.types.TypeOfDomain;
import cz.martlin.jukebox.mid.values.ValueOfDomain;

public interface Domain<D extends Domain<D>> extends ValueOfDomain<D> {

	public TypeOfDomain<D> getDomainType();

	public default BaseType getBaseType() {
		return getDomainType();
	}
}
