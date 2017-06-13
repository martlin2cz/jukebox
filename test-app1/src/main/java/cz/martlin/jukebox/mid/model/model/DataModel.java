package cz.martlin.jukebox.mid.model.model;

import cz.martlin.jukebox.mid.model.type.GeneralCompositeType;
import cz.martlinorg.testapp1.model.TypeOfRecord;

public interface DataModel {

	public RecordModel getModelOf(GeneralCompositeType type);

}