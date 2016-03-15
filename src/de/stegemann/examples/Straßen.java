package de.stegemann.examples;

public class Stra�en {
	private String stra�e;

	public Stra�en(String stra�e) {
		this.stra�e = stra�e;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stra�e == null) ? 0 : stra�e.hashCode());
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
		Stra�en other = (Stra�en) obj;
		if (stra�e == null) {
			if (other.stra�e != null)
				return false;
		} else if (!stra�e.equals(other.stra�e))
			return false;
		return true;
	}

}
