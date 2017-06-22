package cz.martlin.jukebox.out.db;

import java.util.List;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;

public interface Database {

	public <S extends ValueOfStructure<S>> List<S> list(TypeOfStructure<S> type);

	public <S extends ValueOfStructure<S>, I> S get(TypeOfStructure<S> type, I identifier);

	/*
	 * public <T extends Record<I>, I> void create(Record<I> record);
	 * 
	 * public <T extends Record<I>, I> void update(Record<I> record);
	 * 
	 * public <T extends Record<I>, I> void delete(Record<I> record);
	 */
	public <S extends ValueOfStructure<S>> void create(S structure);

	public <S extends ValueOfStructure<S>> void update(S structure);

	public <S extends ValueOfStructure<S>> void delete(S structure);

	/*
	 * //TODO subrecords mechanism public <T extends Subrecord> void
	 * create(Record<I> owner, Subrecord record);
	 * 
	 * public <T extends Subrecord> void update(Record<I> owner, Subrecord
	 * record);
	 * 
	 * public <T extends Subrecord> void delete(Record<I> owner, Subrecord
	 * record);
	 */
}