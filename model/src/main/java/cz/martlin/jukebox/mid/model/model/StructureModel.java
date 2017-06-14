package cz.martlin.jukebox.mid.model.model;

import java.util.List;
import java.util.Map;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.misc.ModelUtils;
import cz.martlin.jukebox.out.dataobj.Structure;

public class StructureModel<S extends Structure> {

	private final String name;

	// TODO has ordering? is ordered? order attributes?
	private final List<Attribute> onlyPrimaryAttributes;
	private final List<Attribute> onlySecondaryAttributes;
	private final List<Attribute> onlyTernaryAttributes;
	private final Map<String, Attribute> allAttributes;
	private String description; // TODO make it final

	public StructureModel(String name, List<Attribute> onlyPrimaryAttributes, List<Attribute> onlySecondaryAttributes,
			List<Attribute> onlyTernaryAttributes) {
		super();
		this.name = name;
		this.onlyPrimaryAttributes = onlyPrimaryAttributes;
		this.onlySecondaryAttributes = onlySecondaryAttributes;
		this.onlyTernaryAttributes = onlyTernaryAttributes;

		this.allAttributes = ModelUtils.toMap(onlyPrimaryAttributes, onlySecondaryAttributes, onlyTernaryAttributes);
	}

	public String getName() {
		return name;
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

	public String getDescription() {
		return description;
	}

	public S getNewDataobjInstance() {
		return null;
	}

}
