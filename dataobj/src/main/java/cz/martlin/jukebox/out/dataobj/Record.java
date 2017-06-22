package cz.martlin.jukebox.out.dataobj;

import cz.martlin.jukebox.mid.types.TypeOfRecord;
import cz.martlin.jukebox.mid.value.SimpleValue;
import cz.martlin.jukebox.mid.values.ValueOfRecord;

public abstract class Record<I extends SimpleValue, V extends Record<I, V>> //
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getIdentifier() == null) ? 0 : getIdentifier().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record<?, ?> other = (Record<?, ?>) obj;
		if (getIdentifier() == null) {
			if (other.getIdentifier() != null)
				return false;
		} else if (!getIdentifier().equals(other.getIdentifier()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Record [id=" + getIdentifier() + "]";
	}

}
