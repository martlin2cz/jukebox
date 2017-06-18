package cz.martlin.jukebox.mid.model.model;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;

public interface DataModel {

	public <S extends ValueOfStructure<S>> StructureModel<S> getModelOf(TypeOfStructure<S> type);

}