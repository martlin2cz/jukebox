package cz.martlinorg.testapp1.model;

public enum XXX_TypeOfSubrecord /*implements GeneralCompositeType */{
	;

	private final Class<?> clazz;

	private XXX_TypeOfSubrecord(Class<?> clazz) {
		this.clazz = clazz;
	}
/*
	@Override
	public String getName() {
		return clazz.getSimpleName();
	}
*/
}
