package cz.martlinorg.testapp1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.martlin.jukebox.mid.domains.HumanName;
import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.attr.AttributeLevel;
import cz.martlin.jukebox.mid.model.model.DataModel;
import cz.martlin.jukebox.mid.model.model.RecordModel;
import cz.martlin.jukebox.mid.model.type.GeneralCompositeType;
import cz.martlin.jukebox.rest.exceptions.UnknownRecordTypeException;

public class DumpedDataModel implements DataModel {

	private static final RecordModel MODEL_OF_PERSON = createModelOfPerson();

	public DumpedDataModel() {
	}

	@Override
	public RecordModel getModelOf(GeneralCompositeType type) {
		
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

	private RecordModel getModelOfRecord(TypeOfRecord type) {
		switch (type) {
		case PERSON:
			return MODEL_OF_PERSON;
		default:
			throw new UnknownRecordTypeException(type);
		}
	}

	private RecordModel getModelOfSubrecord(TypeOfSubrecord type) {
		throw new UnknownRecordTypeException(type);
	}

	private static RecordModel createModelOfPerson() {
		String name = "Person";
		Attribute identifierAttribute = new Attribute("name", AttributeLevel.PRIMARY, HumanName.DESCRIPTOR, false);

		List<Attribute> primaryAttributes = Arrays.asList(new Attribute("name", AttributeLevel.PRIMARY, HumanName.DESCRIPTOR, false));
		List<Attribute> ternaryAttributes = new ArrayList<>();
		List<Attribute> secondaryAttributes = new ArrayList<>();

		return new RecordModel(name, identifierAttribute, primaryAttributes, secondaryAttributes, ternaryAttributes);
	}

}
