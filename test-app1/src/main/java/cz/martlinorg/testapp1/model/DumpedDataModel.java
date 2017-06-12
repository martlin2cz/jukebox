package cz.martlinorg.testapp1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.martlinorg.testapp1.impl.exceptions.UnknownRecordTypeException;
import cz.martlinorg.testapp1.impl.model.Attribute;
import cz.martlinorg.testapp1.impl.model.DataModel;
import cz.martlinorg.testapp1.impl.model.RecordModel;
import cz.martlinorg.testapp1.impl.model.RecordType;

public class DumpedDataModel implements DataModel {

	private static final RecordModel MODEL_OF_PERSON = createModelOfPerson();

	public DumpedDataModel() {
	}

	@Override
	public RecordModel getModelOf(RecordType type) {
		switch (type) {
		case PERSON:
			return MODEL_OF_PERSON;
		default:
			throw new UnknownRecordTypeException(type);
		}
	}

	private static RecordModel createModelOfPerson() {
		String name = "Person";
		Attribute identifierAttribute = new Attribute("login", String.class);

		List<Attribute> primaryAttributes = Arrays.asList(new Attribute("name", String.class));
		List<Attribute> ternaryAttributes = new ArrayList<>();
		List<Attribute> secondaryAttributes = new ArrayList<>();

		return new RecordModel(name, identifierAttribute, primaryAttributes, secondaryAttributes, ternaryAttributes);
	}

}
