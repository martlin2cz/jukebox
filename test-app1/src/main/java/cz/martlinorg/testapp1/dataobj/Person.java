package cz.martlinorg.testapp1.dataobj;

import cz.martlin.jukebox.mid.domains.Count;
import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.domains.Identificator;
import cz.martlin.jukebox.mid.types.TypeOfRecord;
import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlin.jukebox.out.dataobj.misc.Validation;
import cz.martlinorg.testapp1.model.AppSpecifications;

public class Person extends Record<Identificator, Person> {
	public static final TypeOfRecord<Person> TYPE = new TypeOfRecord<>(Person.class);

	private Identificator login;
	private HumanName name;
	private Count children;

	public Person() {
		super(TYPE);
	}

	public Person(Identificator login, HumanName name, Count children) {
		super(TYPE);

		this.login = login;
		this.name = name;
		this.children = children;
	}

	public Identificator getLogin() {
		return login;
	}

	public void setLogin(Identificator login) {
		Validation.checkNotEmpty("login", login);
		this.login = login;
	}

	public HumanName getName() {
		return name;
	}

	public void setName(HumanName name) {
		Validation.checkNotEmpty("name", name);
		this.name = name;
	}

	public Count getChildren() {
		return children;
	}

	public void setChildren(Count children) {
		Validation.checkNotEmpty("children", children);
		Validation.checkMaximal("children", children, AppSpecifications.MAX_PERSON_CHILD);
		this.children = children;
	}

	@Override
	public Identificator getIdentifier() {
		return login;
	}
}
