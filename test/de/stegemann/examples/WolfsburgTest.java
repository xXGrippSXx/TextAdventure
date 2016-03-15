package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	private final static Stra�en DEFAULT_STRASSE = new Stra�en("Test");
	private final static Stra�en ModersohnBeckerRing = new Stra�en("Modersohn-Becker-Ring");

	@Test
	public void stra�enUndNamenInWolfsburg() throws Exception {
		Stadt wolfsburg = new Stadt("Wolfsburg");

		assertEquals("Wolfsburg", wolfsburg.getName());

		wolfsburg.neuenEinwohnerMelden(new Person("Erik", DEFAULT_STRASSE));
		wolfsburg.neuenEinwohnerMelden(new Person("Jana", DEFAULT_STRASSE));
		wolfsburg.neuenEinwohnerMelden(new Person("Jana", DEFAULT_STRASSE));
		wolfsburg.neuenEinwohnerMelden(new Person("Jana", DEFAULT_STRASSE));
		wolfsburg.neuenEinwohnerMelden(new Person("Ralph", ModersohnBeckerRing));
		wolfsburg.neuenEinwohnerMelden(new Person("Margit", ModersohnBeckerRing));
		wolfsburg.neuenEinwohnerMelden(new Person("Dieter", DEFAULT_STRASSE));
		wolfsburg.neuenEinwohnerMelden(new Person("Lutz", DEFAULT_STRASSE));
		wolfsburg.neuenEinwohnerMelden(new Person("Mike", DEFAULT_STRASSE));

		assertEquals(7, wolfsburg.anzahlAnEinwohnern());

		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Erik", DEFAULT_STRASSE)));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Jana", DEFAULT_STRASSE)));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Ralph", ModersohnBeckerRing)));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Margit", ModersohnBeckerRing)));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Dieter", DEFAULT_STRASSE)));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Lutz", DEFAULT_STRASSE)));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Mike", DEFAULT_STRASSE)));

		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Janina", DEFAULT_STRASSE)));
		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Arne", DEFAULT_STRASSE)));

		wolfsburg.neueStrasseBauen(new Stra�en("Major-Hirst-Stra�e"));
		wolfsburg.neueStrasseBauen(new Stra�en("Heinrich-Nordhoff-Stra�e"));
		wolfsburg.neueStrasseBauen(new Stra�en("Schillerstra�e"));
		wolfsburg.neueStrasseBauen(new Stra�en("Schillerstra�e"));
		wolfsburg.neueStrasseBauen(new Stra�en("Celler-Stra�e"));
		wolfsburg.neueStrasseBauen(new Stra�en("Querbrakenring"));

		assertTrue(wolfsburg.gibtEsDieStra�e(new Stra�en("Major-Hirst-Stra�e")));
		assertTrue(wolfsburg.gibtEsDieStra�e(new Stra�en("Heinrich-Nordhoff-Stra�e")));
		assertTrue(wolfsburg.gibtEsDieStra�e(new Stra�en("Schillerstra�e")));
		assertTrue(wolfsburg.gibtEsDieStra�e(new Stra�en("Celler-Stra�e")));
		assertTrue(wolfsburg.gibtEsDieStra�e(new Stra�en("Querbrakenring")));

		assertFalse(wolfsburg.gibtEsDieStra�e(new Stra�en("Am S�dhang")));

		assertEquals(5, wolfsburg.anzahlDerStra�en());
		assertEquals(2, wolfsburg.anzahlAnEinwohnernInStrasse(ModersohnBeckerRing));
		assertEquals(5, wolfsburg.anzahlAnEinwohnernInStrasse(DEFAULT_STRASSE));
	}

}
