package cz.martlinorg.testapp1.db;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cz.martlin.jukebox.mid.domains.Count;
import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.domains.Identificator;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.out.db.Database;
import cz.martlinorg.testapp1.dataobj.Person;

public class SomeDatabase implements Database {

	private List<Person> persons;

	public SomeDatabase() {
		persons = new LinkedList<>(Arrays.asList( //
				new Person(new Identificator("lorem"), new HumanName("Lorem"), new Count(4)), //
				new Person(new Identificator("ipsum"), new HumanName("Lorem"), new Count(0))) //
		);
	}

	@SuppressWarnings("unchecked")
	public <S extends ValueOfStructure<S>> List<S> list(TypeOfStructure<S> type) {
		return (List<S>) persons;
	}

	@SuppressWarnings("unchecked")
	public <S extends ValueOfStructure<S>, I> S get(TypeOfStructure<S> type, I identifier) {
		return (S) persons.stream() //
				.filter((p) -> p.getIdentifier().equals(identifier)) //
				.findAny().get();
	}

	public <S extends ValueOfStructure<S>> void create(S structure) {
		persons.add((Person) structure);
	}

	public <S extends ValueOfStructure<S>> void update(S structure) {
		// okay
	}

	public <S extends ValueOfStructure<S>> void delete(S structure) {
		persons.remove((Person) structure);
	}

}
