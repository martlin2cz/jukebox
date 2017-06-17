package cz.martlin.jukebox.out.dataobj;

import cz.martlin.jukebox.mid.types.TypeOfInformation;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfInformation;

public class Information<V extends Information<V>> //
		extends BaseStructure<V> implements ValueOfInformation<V> {

	public Information(TypeOfStructure<V> type) {
		super(type);
	}

	public TypeOfInformation<V> getInformationType() {
		return (TypeOfInformation<V>) type;
	}

}
