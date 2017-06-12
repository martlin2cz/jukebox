package cz.martlinorg.testapp1.impl.db;

import java.util.List;

import cz.martlinorg.testapp1.impl.dataobj.Record;
import cz.martlinorg.testapp1.impl.dataobj.Subrecord;
import cz.martlinorg.testapp1.impl.model.RecordType;

public interface Database {

	public <T extends Record> List<T> list(RecordType type);

	public <T extends Record> T get(RecordType type, Object identifier);

	public <T extends Record> void create(Record record);

	public <T extends Record> void update(Record record);

	public <T extends Record> void delete(Record record);

	public <T extends Subrecord> void create(Record owner, Subrecord record);

	public <T extends Subrecord> void update(Record owner, Subrecord record);

	public <T extends Subrecord> void delete(Record owner, Subrecord record);
}