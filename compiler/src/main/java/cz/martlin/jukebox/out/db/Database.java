package cz.martlin.jukebox.out.db;

import java.util.List;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.out.dataobj.Structure;

public interface Database {

	public <S extends Structure> List<S> list(TypeOfStructure type);

	public <S extends Structure, I> S get(TypeOfStructure type, I identifier);
/*
	public <T extends Record<I>, I> void create(Record<I> record);

	public <T extends Record<I>, I> void update(Record<I> record);

	public <T extends Record<I>, I> void delete(Record<I> record);
*/
	public <S extends Structure> void create(Structure structure);

	public <S extends Structure> void update(Structure structure);

	public <S extends Structure> void delete(Structure structure);

	
	/*
  //TODO subrecords mechanism
	public <T extends Subrecord> void create(Record<I> owner, Subrecord record);

	public <T extends Subrecord> void update(Record<I> owner, Subrecord record);

	public <T extends Subrecord> void delete(Record<I> owner, Subrecord record);
*/
}