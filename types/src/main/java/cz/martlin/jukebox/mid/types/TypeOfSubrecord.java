package cz.martlin.jukebox.mid.types;

public class TypeOfSubrecord implements TypeOfStructure {
	private final Class<?> clazz;

	public TypeOfSubrecord(Class<?> clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public Class<?> getClazz() {
		return clazz;
	}

	@Override
	public String getName() {
		return clazz.getSimpleName();
	}
}
