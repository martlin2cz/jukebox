package cz.martlin.jukebox.out.db.inmem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.value.SimpleValue;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlin.jukebox.out.db.Database;
import cz.martlin.jukebox.rest.exceptions.UnknownTypeException;

public class InMemoryDatabase implements Database {

	private final Map<TypeOfStructure<?>, Map<SimpleValue, ValueOfStructure<?>>> data = new HashMap<>();

	public InMemoryDatabase() {
	}

	@Override
	public <S extends ValueOfStructure<S>> List<S> list(TypeOfStructure<S> type) {
		Map<SimpleValue, S> map = getOfType(type);

		return new ArrayList<>(map.values());
	}

	@Override
	public <S extends ValueOfStructure<S>, I> S get(TypeOfStructure<S> type, I identifier) {
		Map<SimpleValue, S> map = getOfType(type);

		return map.get(identifier);
	}

	@Override
	public <S extends ValueOfStructure<S>> void create(S structure) {
		TypeOfStructure<S> type = structure.getTypeOfStructure();
		Map<SimpleValue, S> map = getOfType(type);

		if (structure instanceof Record) {
			Record<?, ?> record = (Record<?, ?>) structure;
			map.put(record.getIdentifier(), structure);
		} else {
			throw new UnknownTypeException(structure);
		}
	}

	@Override
	public <S extends ValueOfStructure<S>> void update(S structure) {
		// okay
	}

	@Override
	public <S extends ValueOfStructure<S>> void delete(S structure) {
		TypeOfStructure<S> type = structure.getTypeOfStructure();
		Map<SimpleValue, S> map = getOfType(type);

		if (structure instanceof Record) {
			Record<?, ?> record = (Record<?, ?>) structure;
			map.remove(record.getIdentifier());
		} else {
			throw new UnknownTypeException(structure);
		}
	}

	@SuppressWarnings("unchecked")
	private <S extends ValueOfStructure<S>> Map<SimpleValue, S> getOfType(TypeOfStructure<S> type) {
		Map<SimpleValue, S> map = (Map<SimpleValue, S>) (Object) data.get(type);

		if (map == null) {
			map = new LinkedHashMap<>();
			data.put(type, (Map<SimpleValue, ValueOfStructure<?>>) (Object) map);
		}

		return map;
	}

}
