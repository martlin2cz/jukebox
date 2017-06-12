package cz.martlinorg.testapp1.impl.model;

import java.util.List;

public class RecordModel {
	private final String name;
	private final Attribute identifierAttribute;

	private final List<Attribute> onlyPrimaryAttributes;
	private final List<Attribute> onlySecondaryAttributes;
	private final List<Attribute> onlyTernaryAttributes;

	public RecordModel(String name, Attribute identifierAttribute, List<Attribute> onlyPrimaryAttributes,
			List<Attribute> onlySecondaryAttributes, List<Attribute> onlyTernaryAttributes) {
		super();
		this.name = name;
		this.identifierAttribute = identifierAttribute;
		this.onlyPrimaryAttributes = onlyPrimaryAttributes;
		this.onlySecondaryAttributes = onlySecondaryAttributes;
		this.onlyTernaryAttributes = onlyTernaryAttributes;
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

}
