package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	private final static Straßen DEFAULT_STRASSE = new Straßen("Test");
	private final static Straßen ModersohnBeckerRing = new Straßen("Modersohn-Becker-Ring");

	@Test
	public void straßenUndNamenInWolfsburg() throws Exception {
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

		wolfsburg.neueStrasseBauen(new Straßen("Major-Hirst-Straße"));
		wolfsburg.neueStrasseBauen(new Straßen("Heinrich-Nordhoff-Straße"));
		wolfsburg.neueStrasseBauen(new Straßen("Schillerstraße"));
		wolfsburg.neueStrasseBauen(new Straßen("Schillerstraße"));
		wolfsburg.neueStrasseBauen(new Straßen("Celler-Straße"));
		wolfsburg.neueStrasseBauen(new Straßen("Musterstrasse"));
		wolfsburg.neueStrasseBauen(new Straßen("Querbrakenring"));

		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Major-Hirst-Straße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Musterstrasse")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Heinrich-Nordhoff-Straße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Schillerstraße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Celler-Straße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Querbrakenring")));

		assertFalse(wolfsburg.gibtEsDieStraße(new Straßen("Am Südhang")));

		assertEquals(6, wolfsburg.anzahlDerStraßen());
		assertEquals(2, wolfsburg.anzahlAnEinwohnernInStrasse(ModersohnBeckerRing));
		assertEquals(5, wolfsburg.anzahlAnEinwohnernInStrasse(DEFAULT_STRASSE));

		assertEquals(2, wolfsburg.anzahlStassenDieMitBuchstabeBeginnen("M"));

		wolfsburg.namenDerPersonen();

	}

}
