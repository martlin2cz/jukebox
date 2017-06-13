package cz.martlinorg.testapp1.dataobj;

import cz.martlin.jukebox.mid.model.type.GeneralType;
import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlinorg.testapp1.model.TypeOfRecord;

public class Person implements Record {

	private String name;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object getIdentifier() {
		return name;
	}

	@Override
	public GeneralType getType() {
		return TypeOfRecord.PERSON;
	}
}
