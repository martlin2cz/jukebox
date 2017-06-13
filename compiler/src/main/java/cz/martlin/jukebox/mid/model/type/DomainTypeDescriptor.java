package cz.martlin.jukebox.mid.model.type;

import cz.martlin.jukebox.mid.domain.Domain;
import cz.martlin.jukebox.mid.domain.DomainConverter;

public abstract class DomainTypeDescriptor<T extends Domain> implements TypeOfAttribute, DomainConverter<T> {

	private final Class<T> domain;

	public DomainTypeDescriptor(Class<T> domain) {
		this.domain = domain;
	}

	@Override
	public String getName() {
		return domain.getName();
	}

}
