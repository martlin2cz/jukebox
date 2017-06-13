package cz.martlin.jukebox.out.db;

import java.util.List;

import cz.martlin.jukebox.mid.type.TypeOfRecord;
import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlin.jukebox.out.dataobj.Subrecord;

public interface Database {

	public <T extends Record> List<T> list(TypeOfRecord type);

	public <T extends Record> T get(TypeOfRecord type, Object identifier);

	public <T extends Record> void create(Record record);

	public <T extends Record> void update(Record record);

	public <T extends Record> void delete(Record record);

	public <T extends Subrecord> void create(Record owner, Subrecord record);

	public <T extends Subrecord> void update(Record owner, Subrecord record);

	public <T extends Subrecord> void delete(Record owner, Subrecord record);
}