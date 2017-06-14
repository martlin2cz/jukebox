package cz.martlinorg.testapp1.db;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.out.dataobj.Structure;
import cz.martlin.jukebox.out.db.Database;
import cz.martlinorg.testapp1.dataobj.Person;

public class SomeDatabase implements Database {

	private List<Person> persons;

	
	public SomeDatabase() {
		persons = new LinkedList<>(Arrays.asList(new Person("Lorem"), new Person("Ipsum")));
	}

	public <S extends Structure> List<S> list(TypeOfStructure type) {
		return (List<S>) persons;
	}

	public <S extends Structure, I> S get(TypeOfStructure type, I identifier) {
		return (S) persons.stream().filter((p) -> p.getIdentifier().equals(identifier)).findAny().get();
	}

	public <S extends Structure> void create(Structure structure) {
		persons.add((Person) structure);
	}

	public <S extends Structure> void update(Structure structure) {
		//okay
	}

	public <S extends Structure> void delete(Structure structure) {
		persons.remove((Person) structure);
	}

}
