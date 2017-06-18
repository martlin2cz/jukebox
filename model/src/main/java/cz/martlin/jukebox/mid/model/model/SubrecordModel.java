package cz.martlin.jukebox.mid.model.model;

import java.util.List;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.types.TypeOfSubrecord;
import cz.martlin.jukebox.out.dataobj.Subrecord;

public class SubrecordModel<S extends Subrecord<S>> extends StructureModel<S> {

	public SubrecordModel(String name, TypeOfSubrecord<S> type, List<Attribute<?>> onlyPrimaryAttributes,
			List<Attribute<?>> onlySecondaryAttributes, List<Attribute<?>> onlyTernaryAttributes) {
		super(name, type, onlyPrimaryAttributes, onlySecondaryAttributes, onlyTernaryAttributes);
		// TODO Auto-generated constructor stub
	}

}
