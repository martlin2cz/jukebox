package cz.martlinorg.testapp1.model;

import cz.martlinorg.testapp1.dataobj.Person;

public enum XXX_TypeOfRecord /*implements GeneralCompositeType */{
	PERSON(Person.class);
	
	
	private final Class<?> clazz;
	
	private XXX_TypeOfRecord(Class<?> clazz) {
		this.clazz = clazz;
	}
/*
	@Override
	public String getName() {
		return clazz.getSimpleName();
	}
*/

	
	
}
