package cz.martlin.jukebox.mid.model.misc;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.value.SimpleValue;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.rest.exceptions.UnknownRecordTypeException;

public class ModelUtils {

	@SuppressWarnings("unchecked")
	public static <V extends SimpleValue> V getAt(ValueOfStructure<?> record, Attribute<V> attr) {
		/*
		 * if (record.getType() == TypeOfRecord.PERSON &&
		 * attr.getName().equals("name")) { return ((Person) record).getName();
		 * } else { throw new UnknownRecordTypeException(record); }
		 */
		try {
			String attrName = attr.getName();
			String getterName = "get" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1);
			Method getter = record.getClass().getDeclaredMethod(getterName);
			 
			return (V) getter.invoke(record);
		} catch (Exception e) {
			throw new UnknownRecordTypeException(attr, e); // TODO unknown
														// atttribute exception
														// ?
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
	public static Map<String, Attribute<?>> toMap(List<Attribute<?>>... lists) {
		Map<String, Attribute<?>> map = new HashMap<>();

		Arrays.stream(lists) //
				.forEach((l) -> l.forEach( //
						(a) -> map.put(a.getName(), a) //
		));

		return map;
	}

}
