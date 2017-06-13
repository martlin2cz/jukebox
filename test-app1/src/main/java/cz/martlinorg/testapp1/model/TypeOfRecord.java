package cz.martlinorg.testapp1.model;

import cz.martlin.jukebox.mid.model.type.GeneralCompositeType;
import cz.martlinorg.testapp1.dataobj.Person;

public enum TypeOfRecord implements GeneralCompositeType {
	PERSON(Person.class);
	
	private final Class<?> clazz;
	
	private TypeOfRecord(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public String getName() {
		return clazz.getSimpleName();
	}


	
	
}
