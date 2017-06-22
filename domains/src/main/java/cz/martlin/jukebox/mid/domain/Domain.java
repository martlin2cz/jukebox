package cz.martlin.jukebox.mid.domain;

import java.io.Serializable;

import cz.martlin.jukebox.mid.values.ValueOfDomain;

public interface Domain<D extends Domain<D>> extends ValueOfDomain<D>, Serializable {

}
