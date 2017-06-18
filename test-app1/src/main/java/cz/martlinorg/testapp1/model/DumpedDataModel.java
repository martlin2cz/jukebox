package cz.martlinorg.testapp1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.martlin.jukebox.mid.domains.Count;
import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.domains.Identificator;
import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.attr.AttributeLevel;
import cz.martlin.jukebox.mid.model.model.DataModel;
import cz.martlin.jukebox.mid.model.model.InformationModel;
import cz.martlin.jukebox.mid.model.model.RecordModel;
import cz.martlin.jukebox.mid.model.model.StructureModel;
import cz.martlin.jukebox.mid.model.model.SubrecordModel;
import cz.martlin.jukebox.mid.types.TypeOfInformation;
import cz.martlin.jukebox.mid.types.TypeOfRecord;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.types.TypeOfSubrecord;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.rest.exceptions.UnknownRecordTypeException;
import cz.martlinorg.testapp1.dataobj.Person;

public class DumpedDataModel implements DataModel {

	private static final RecordModel<Identificator, Person> MODEL_OF_PERSON = createModelOfPerson();

	public DumpedDataModel() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends ValueOfStructure<S>> StructureModel<S> getModelOf(TypeOfStructure<S> type) {

		if (type instanceof TypeOfRecord) {
			TypeOfRecord<?> record = (TypeOfRecord<?>) type;
			return (StructureModel<S>) getModelOfRecord(record);
		}

		if (type instanceof TypeOfSubrecord) {
			TypeOfSubrecord<?> subrecord = (TypeOfSubrecord<?>) type;
			return (StructureModel<S>) getModelOfSubrecord(subrecord);
		}

		if (type instanceof TypeOfInformation) {
			TypeOfInformation<?> information = (TypeOfInformation<?>) type;
			return (StructureModel<S>) getModelOfInformation(information);
		}

		throw new UnknownRecordTypeException(type);

	}

	private RecordModel<?, ?> getModelOfRecord(TypeOfRecord<?> type) {

		if (type.getName().equals(Person.class.getSimpleName())) {
			// TODO hack, Person.DESCRIPTOR does not exist, take a look at it
			// ...
			return MODEL_OF_PERSON;
		}

		throw new UnknownRecordTypeException(type);
	}

	private SubrecordModel<?> getModelOfSubrecord(TypeOfSubrecord<?> type) {
		throw new UnknownRecordTypeException(type);
	}

	private InformationModel<?> getModelOfInformation(TypeOfInformation<?> type) {
		throw new UnknownRecordTypeException(type);
	}

	private static RecordModel<Identificator, Person> createModelOfPerson() {
		String name = "Person";
		Attribute<Identificator> loginAttr = new Attribute<>("login", AttributeLevel.IDENTIFIER, Identificator.TYPE,
				false, new Identificator("---"));
		Attribute<HumanName> nameAttr = new Attribute<>("name", AttributeLevel.PRIMARY, HumanName.TYPE, false,
				new HumanName("John"));
		Attribute<Count> childrenAttr = new Attribute<>("children", AttributeLevel.TERNARY, Count.TYPE, false,
				new Count(0));

		Attribute<Identificator> identifierAttribute = loginAttr;

		List<Attribute<?>> primaryAttributes = Arrays.asList(loginAttr, nameAttr);
		List<Attribute<?>> secondaryAttributes = new ArrayList<>();
		List<Attribute<?>> ternaryAttributes = Arrays.asList(childrenAttr);

		return new RecordModel<>(name, identifierAttribute, primaryAttributes, secondaryAttributes, ternaryAttributes);
	}

}
