package de.stegemann.examples;

import java.util.HashSet;
import java.util.Set;

public class Stadt {

	private Set<Straﬂen> straﬂen = new HashSet<>();
	private String name;
	private Set<Person> personen = new HashSet<>();

	public Stadt(String name) {
		this.name = name;
	}

	public void neuenEinwohnerMelden(Person neueEinwohner) {
		this.personen.add(neueEinwohner);
	}

	public void neueStrasseBauen(Straﬂen neueStraﬂe) {
		this.straﬂen.add(neueStraﬂe);
	}

	public String getName() {
		return name;
	}

	public boolean istEinWohnerGemeldet(Person gemeldeteEinwohner) {
		return this.personen.contains(gemeldeteEinwohner);
	}

	public boolean gibtEsDieStraﬂe(Straﬂen bestehendeStraﬂe) {
		return this.straﬂen.contains(bestehendeStraﬂe);
	}

	public int anzahlAnEinwohnern() {
		return this.personen.size();
	}

	public int anzahlDerStraﬂen() {
		return this.straﬂen.size();
	}
}
