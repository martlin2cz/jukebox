package cz.martlin.jukebox.out.dataobj;

import cz.martlin.jukebox.mid.types.TypeOfRecord;
import cz.martlin.jukebox.mid.values.ValueOfRecord;

public abstract class Record<I, V extends Record<I, V>> //
		extends BaseStructure<V> implements ValueOfRecord<V> {

	public Record(TypeOfRecord<V> type) {
		super(type);
	}

	public abstract I getIdentifier();

	public TypeOfRecord<V> getRecordType() {
		return (TypeOfRecord<V>) type;
	}

	public TypeOfRecord<V> getType() {
		return getType();
	}

}
