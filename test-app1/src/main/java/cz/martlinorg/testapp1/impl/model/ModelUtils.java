package cz.martlinorg.testapp1.impl.model;

import java.util.ArrayList;
import java.util.List;

import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.impl.dataobj.Record;
import cz.martlinorg.testapp1.impl.exceptions.UnknownRecordTypeException;

public class ModelUtils {

	public static Object getAt(Record record, Attribute attr) {

		if (record.getType() == RecordType.PERSON && attr.getName().equals("name")) {
			return ((Person) record).getName();
		} else {
			throw new UnknownRecordTypeException(record);
		}
	}

	public static <T> List<T> merge(List<T> first, List<T> second) {
		ArrayList<T> result = new ArrayList<>(first.size() + second.size());

		result.addAll(first);
		result.addAll(second);

		return result;
	}

	public static <T> List<T> merge(List<T> first, List<T> second, List<T> third) {
		ArrayList<T> result = new ArrayList<>(first.size() + second.size() + third.size());

		result.addAll(first);
		result.addAll(second);
		result.addAll(third);

		return result;
	}

}
