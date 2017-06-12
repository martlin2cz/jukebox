package cz.martlinorg.testapp1.impl.model;

import cz.martlinorg.testapp1.dataobj.Person;

public enum RecordType implements GeneralType {
	PERSON(Person.class);
	
	private RecordType(Class<?> clazz) {
	}
	
	
}
