package cz.martlin.jukebox.mid.model.model;

import java.util.List;
import java.util.Map;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.misc.ModelUtils;

public class RecordModel {	//TODO RecordModel? And what about Subrecord model (each should have parent(s))? And whre is da class?
	private final String name;
	private final Attribute identifierAttribute;
	//TODO has ordering? is ordered? order attributes?

	private final List<Attribute> onlyPrimaryAttributes;
	private final List<Attribute> onlySecondaryAttributes;
	private final List<Attribute> onlyTernaryAttributes;
	private final Map<String, Attribute> allAttributes;

	public RecordModel(String name, Attribute identifierAttribute, List<Attribute> onlyPrimaryAttributes,
			List<Attribute> onlySecondaryAttributes, List<Attribute> onlyTernaryAttributes) {
		super();
		this.name = name;
		this.identifierAttribute = identifierAttribute;
		this.onlyPrimaryAttributes = onlyPrimaryAttributes;
		this.onlySecondaryAttributes = onlySecondaryAttributes;
		this.onlyTernaryAttributes = onlyTernaryAttributes;
		
		this.allAttributes = ModelUtils.toMap(onlyPrimaryAttributes, onlySecondaryAttributes, onlyTernaryAttributes);
	}

	public String getName() {
		return name;
	}

	public Attribute getIdentifierAttribute() {
		return identifierAttribute;
	}

	public List<Attribute> getPrimaryAttributes() {
		return onlyPrimaryAttributes;
	}

	public List<Attribute> getSecondaryAttributes() {
		return ModelUtils.merge(onlyPrimaryAttributes, onlySecondaryAttributes);
	}

	public List<Attribute> getTernaryAttributes() {
		return ModelUtils.merge(onlyPrimaryAttributes, onlySecondaryAttributes, onlyTernaryAttributes);
	}

	public Attribute getAttribute(String name) {
		return allAttributes.get(name);
	}

}
