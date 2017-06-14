package cz.martlin.jukebox.mid.model.model;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.out.dataobj.Structure;

public interface DataModel {

	public <S extends Structure> StructureModel<S> getModelOf(TypeOfStructure type);

}