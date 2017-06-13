package cz.martlinorg.testapp1.model;

import cz.martlin.jukebox.mid.model.type.GeneralCompositeType;

public enum TypeOfSubrecord implements GeneralCompositeType {
	;

	private final Class<?> clazz;

	private TypeOfSubrecord(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public String getName() {
		return clazz.getSimpleName();
	}

}
