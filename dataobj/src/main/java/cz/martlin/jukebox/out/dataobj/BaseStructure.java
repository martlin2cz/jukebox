package cz.martlin.jukebox.out.dataobj;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;

public class BaseStructure<V extends BaseStructure<V>> implements ValueOfStructure<V> {

	protected final TypeOfStructure<V> type;

	public BaseStructure(TypeOfStructure<V> type) {
		super();
		this.type = type;
	}

	@Override
	public TypeOfStructure<V> getTypeOfStructure() {
		return type;
	}

}