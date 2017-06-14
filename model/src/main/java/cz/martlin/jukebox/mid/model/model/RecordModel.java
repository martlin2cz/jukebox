package cz.martlin.jukebox.mid.model.model;

import java.util.List;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.out.dataobj.Record;

public class RecordModel<S extends Record<?>> extends StructureModel<S> {

	private final Attribute identifierAttribute;

	public RecordModel(String name, Attribute identifierAttribute, List<Attribute> onlyPrimaryAttributes,
			List<Attribute> onlySecondaryAttributes, List<Attribute> onlyTernaryAttributes) {
		super(name, onlyPrimaryAttributes, onlySecondaryAttributes, onlyTernaryAttributes);

		this.identifierAttribute = identifierAttribute;
	}

	public Attribute getIdentifierAttribute() {
		return identifierAttribute;
	}

}
