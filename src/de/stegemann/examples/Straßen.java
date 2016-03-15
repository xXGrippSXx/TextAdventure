package de.stegemann.examples;

public class Straﬂen {
	private String straﬂe;

	public Straﬂen(String straﬂe) {
		this.straﬂe = straﬂe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((straﬂe == null) ? 0 : straﬂe.hashCode());
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
		Straﬂen other = (Straﬂen) obj;
		if (straﬂe == null) {
			if (other.straﬂe != null)
				return false;
		} else if (!straﬂe.equals(other.straﬂe))
			return false;
		return true;
	}

}
