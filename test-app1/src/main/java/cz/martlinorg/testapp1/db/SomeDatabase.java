package cz.martlinorg.testapp1.db;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlin.jukebox.out.dataobj.Subrecord;
import cz.martlin.jukebox.out.db.Database;
import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.model.TypeOfRecord;

public class SomeDatabase implements Database {

	private List<Person> persons;

	
	public SomeDatabase() {
		persons = new LinkedList<>(Arrays.asList(new Person("Lorem"), new Person("Ipsum")));
	}

	@Override
	public <T extends Record> List<T> list(TypeOfRecord type) {
		return (List<T>) persons;
	}

	@Override
	public <T extends Record> T get(TypeOfRecord type, Object identifier) {
		return (T) persons.get(0);
	}

	@Override
	public <T extends Record> void create(Record record) {
		persons.add((Person) record);
	}

	@Override
	public <T extends Record> void update(Record record) {
		//okay
	}

	@Override
	public <T extends Record> void delete(Record record) {
		persons.remove(record);
	}

	@Override
	public <T extends Subrecord> void create(Record owner, Subrecord record) {
		// TODO add, update, delete subrecord
	}

	@Override
	public <T extends Subrecord> void update(Record owner, Subrecord record) {
		// TODO add, update, delete subrecord
	}

	@Override
	public <T extends Subrecord> void delete(Record owner, Subrecord record) {
		// TODO add, update, delete subrecord
	}

}
