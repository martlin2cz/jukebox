package cz.martlinorg.testapp1.dataobj;

import cz.martlin.jukebox.out.dataobj.Record;

public class Person extends Record<String> {

	private String name;

	public Person() {
		super(Person.class);
	}

	public Person(String name) {
		super(Person.class);

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getIdentifier() {
		return name;
	}
}
