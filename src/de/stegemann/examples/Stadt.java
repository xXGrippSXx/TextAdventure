package de.stegemann.examples;

import java.util.HashSet;
import java.util.Set;

public class Stadt {

	private Set<Straßen> straßen = new HashSet<>();
	private String name;
	private Set<Person> personen = new HashSet<>();

	public Stadt(String name) {
		this.name = name;
	}

	public void neuenEinwohnerMelden(Person neueEinwohner) {
		this.personen.add(neueEinwohner);
	}

	public void neueStrasseBauen(Straßen neueStraße) {
		this.straßen.add(neueStraße);
	}

	public String getName() {
		return name;
	}

	public boolean istEinWohnerGemeldet(Person gemeldeteEinwohner) {
		return this.personen.contains(gemeldeteEinwohner);
	}

	public boolean gibtEsDieStraße(Straßen bestehendeStraße) {
		return this.straßen.contains(bestehendeStraße);
	}

	public int anzahlAnEinwohnern() {
		return this.personen.size();
	}

	public int anzahlDerStraßen() {
		return this.straßen.size();
	}
}
