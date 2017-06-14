package cz.martlin.jukebox.mid.domain;

public abstract class CommonDescriptor<D extends Domain<D>> implements DomainDescriptor<D>, DomainConverter<D> {

	private final DomainType<D> type;

	public CommonDescriptor(Class<D> type) {
		super();
		this.type = new DomainType<>(type);
	}

	@Override
	public DomainType<D> getType() {
		return type;
	}

	@Override
	public DomainConverter<D> getConverter() {
		return this;
	}

	// @Override
	// public String toHumanOutput(T value) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public T fromHumanOutput(String value) throws NotDomainValueException {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public boolean isValidHumanOutput(String value) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public String toComputerOutput(T value) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public T fromComputerOutput(String value) throws NotDomainValueException
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public boolean isValidComputerOutput(String value) {
	// // TODO Auto-generated method stub
	// return false;
	// }

}
