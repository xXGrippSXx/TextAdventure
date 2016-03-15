package de.stegemann.examples;

import java.util.HashSet;
import java.util.Set;

public class Stadt {

	private Set<Stra�en> stra�en = new HashSet<>();
	private String name;
	private Set<Person> personen = new HashSet<>();

	public Stadt(String name) {
		this.name = name;
	}

	public void neuenEinwohnerMelden(Person neueEinwohner) {
		this.personen.add(neueEinwohner);
	}

	public void neueStrasseBauen(Stra�en neueStra�e) {
		this.stra�en.add(neueStra�e);
	}

	public String getName() {
		return name;
	}

	public boolean istEinWohnerGemeldet(Person gemeldeteEinwohner) {
		return this.personen.contains(gemeldeteEinwohner);
	}

	public boolean gibtEsDieStra�e(Stra�en bestehendeStra�e) {
		return this.stra�en.contains(bestehendeStra�e);
	}

	public int anzahlAnEinwohnern() {
		return this.personen.size();
	}

	public int anzahlDerStra�en() {
		return this.stra�en.size();
	}
}