package de.stegemann.examples;

public class Person {
	private String name;
	private String stra�e;

	public Person(String name) {
		this.name = name;
		this.stra�e = name;
	}

	// Von eclipse generiert mit Source -> Generate hashCode() and equals() aus
	// Kontextmen�
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Object getStrasse() {

		return null;
	}
}
