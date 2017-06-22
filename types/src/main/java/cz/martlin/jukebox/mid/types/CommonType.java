package cz.martlin.jukebox.mid.types;

import cz.martlin.jukebox.mid.type.BaseType;

public abstract class CommonType<T> implements BaseType {

	protected final Class<T> clazz;

	public CommonType(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	public Class<T> getTypeClazz() {
		return clazz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommonType<?> other = (CommonType<?>) obj;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getName();
	}

}