package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	private final static Straﬂen DEFAULT_STRASSE = new Straﬂen("Test");
	private final static Straﬂen ModersohnBeckerRing = new Straﬂen("Modersohn-Becker-Ring");

	@Test
	public void straﬂenUndNamenInWolfsburg() throws Exception {
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

		wolfsburg.neueStrasseBauen(new Straﬂen("Major-Hirst-Straﬂe"));
		wolfsburg.neueStrasseBauen(new Straﬂen("Heinrich-Nordhoff-Straﬂe"));
		wolfsburg.neueStrasseBauen(new Straﬂen("Schillerstraﬂe"));
		wolfsburg.neueStrasseBauen(new Straﬂen("Schillerstraﬂe"));
		wolfsburg.neueStrasseBauen(new Straﬂen("Celler-Straﬂe"));
		wolfsburg.neueStrasseBauen(new Straﬂen("Querbrakenring"));

		assertTrue(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Major-Hirst-Straﬂe")));
		assertTrue(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Heinrich-Nordhoff-Straﬂe")));
		assertTrue(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Schillerstraﬂe")));
		assertTrue(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Celler-Straﬂe")));
		assertTrue(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Querbrakenring")));

		assertFalse(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Am S¸dhang")));

		assertEquals(5, wolfsburg.anzahlDerStraﬂen());
		assertEquals(2, wolfsburg.anzahlAnEinwohnernInStrasse(ModersohnBeckerRing));
		assertEquals(5, wolfsburg.anzahlAnEinwohnernInStrasse(DEFAULT_STRASSE));
	}

}
