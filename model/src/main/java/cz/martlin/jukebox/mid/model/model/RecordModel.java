package cz.martlin.jukebox.mid.model.model;

import java.util.List;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.value.SimpleValue;
import cz.martlin.jukebox.out.dataobj.Record;

public class RecordModel<I extends SimpleValue, R extends Record<I, R>> //
		extends StructureModel<R> {

	private final Attribute<I> identifierAttribute;

	public RecordModel(String name, Attribute<I> identifierAttribute, List<Attribute<?>> onlyPrimaryAttributes,
			List<Attribute<?>> onlySecondaryAttributes, List<Attribute<?>> onlyTernaryAttributes) {
		super(name, onlyPrimaryAttributes, onlySecondaryAttributes, onlyTernaryAttributes);

		this.identifierAttribute = identifierAttribute;
	}

	public Attribute<I> getIdentifierAttribute() {
		return identifierAttribute;
	}

}
