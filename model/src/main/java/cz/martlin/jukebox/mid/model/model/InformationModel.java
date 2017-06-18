package cz.martlin.jukebox.mid.model.model;

import java.util.List;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.out.dataobj.Information;

public class InformationModel<S extends Information<S>> extends StructureModel<S> {

	public InformationModel(String name, List<Attribute<?>> onlyPrimaryAttributes,
			List<Attribute<?>> onlySecondaryAttributes, List<Attribute<?>> onlyTernaryAttributes) {
		super(name, onlyPrimaryAttributes, onlySecondaryAttributes, onlyTernaryAttributes);
		// TODO Auto-generated constructor stub
	}

}
