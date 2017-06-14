package cz.martlinorg.testapp1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.attr.AttributeLevel;
import cz.martlin.jukebox.mid.model.model.DataModel;
import cz.martlin.jukebox.mid.model.model.RecordModel;
import cz.martlin.jukebox.mid.types.TypeOfRecord;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.types.TypeOfSubrecord;
import cz.martlin.jukebox.rest.exceptions.UnknownRecordTypeException;
import cz.martlinorg.testapp1.dataobj.Person;

public class DumpedDataModel implements DataModel {

	private static final RecordModel<Person> MODEL_OF_PERSON = createModelOfPerson();

	public DumpedDataModel() {
	}

	@Override
	public RecordModel<?> getModelOf(TypeOfStructure type) {

		if (type instanceof TypeOfRecord) {
			TypeOfRecord record = (TypeOfRecord) type;
			return getModelOfRecord(record);
		}

		if (type instanceof TypeOfSubrecord) {
			TypeOfSubrecord subrecord = (TypeOfSubrecord) type;
			return getModelOfSubrecord(subrecord);
		}

		throw new UnknownRecordTypeException(type);

	}

	private RecordModel<?> getModelOfRecord(TypeOfRecord type) {

		if (type.getName().equals(Person.class.getSimpleName())) {
			// TODO hack, Person.DESCRIPTOR does not exist, take a look at it
			// ...
			return MODEL_OF_PERSON;
		}

		throw new UnknownRecordTypeException(type);
	}

	private RecordModel<?> getModelOfSubrecord(TypeOfSubrecord type) {
		throw new UnknownRecordTypeException(type);
	}

	private static RecordModel<Person> createModelOfPerson() {
		String name = "Person";
		Attribute identifierAttribute = new Attribute("name", AttributeLevel.PRIMARY, HumanName.DESCRIPTOR.getType(),
				false, "Hi");

		List<Attribute> primaryAttributes = Arrays
				.asList(new Attribute("name", AttributeLevel.PRIMARY, HumanName.DESCRIPTOR.getType(), false, "Hi"));
		List<Attribute> ternaryAttributes = new ArrayList<>();
		List<Attribute> secondaryAttributes = new ArrayList<>();

		return new RecordModel<>(name, identifierAttribute, primaryAttributes, secondaryAttributes, ternaryAttributes);
	}

}
