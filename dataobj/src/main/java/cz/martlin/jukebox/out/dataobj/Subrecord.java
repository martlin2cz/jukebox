package cz.martlin.jukebox.out.dataobj;

import cz.martlin.jukebox.mid.types.TypeOfSubrecord;
import cz.martlin.jukebox.mid.values.ValueOfSubrecord;

public abstract class Subrecord<V extends Subrecord<V>> //
		extends BaseStructure<V> implements ValueOfSubrecord<V> {

	public Subrecord(TypeOfSubrecord<V> type) {
		super(type);
	}

	public TypeOfSubrecord<V> getSubrecordType() {
		return (TypeOfSubrecord<V>) type;
	}

}
