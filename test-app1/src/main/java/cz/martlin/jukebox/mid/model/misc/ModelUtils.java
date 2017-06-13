package cz.martlin.jukebox.mid.model.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlin.jukebox.rest.exceptions.UnknownRecordTypeException;
import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.model.TypeOfRecord;

public class ModelUtils {

	public static Object getAt(Record record, Attribute attr) {

		if (record.getType() == TypeOfRecord.PERSON && attr.getName().equals("name")) {
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

	@SafeVarargs
	public static Map<String, Attribute> toMap(List<Attribute> ... lists) {
		Map<String, Attribute> map = new HashMap<>();
		
		Arrays.stream(lists) //
		.forEach((l) -> l.forEach( //
				(a) -> map.put(a.getName(), a) //
				));
		
		return map;
	}

}
