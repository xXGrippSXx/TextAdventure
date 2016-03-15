package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	@Test
	public void straßenUndNamenInWolfsburg() throws Exception {
		Stadt wolfsburg = new Stadt("Wolfsburg");

		assertEquals("Wolfsburg", wolfsburg.getName());

		wolfsburg.neuenEinwohnerMelden(new Person("Erik"));
		wolfsburg.neuenEinwohnerMelden(new Person("Jana"));
		wolfsburg.neuenEinwohnerMelden(new Person("Jana"));
		wolfsburg.neuenEinwohnerMelden(new Person("Jana"));
		wolfsburg.neuenEinwohnerMelden(new Person("Ralph"));
		wolfsburg.neuenEinwohnerMelden(new Person("Margit"));
		wolfsburg.neuenEinwohnerMelden(new Person("Dieter"));
		wolfsburg.neuenEinwohnerMelden(new Person("Lutz"));
		wolfsburg.neuenEinwohnerMelden(new Person("Mike"));

		assertEquals(7, wolfsburg.anzahlAnEinwohnern());

		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Erik")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Jana")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Ralph")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Margit")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Dieter")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Lutz")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Mike")));

		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Janina")));
		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Arne")));

		wolfsburg.neueStrasseBauen(new Straßen("Major-Hirst-Straße"));
		wolfsburg.neueStrasseBauen(new Straßen("Heinrich-Nordhoff-Straße"));
		wolfsburg.neueStrasseBauen(new Straßen("Schillerstraße"));
		wolfsburg.neueStrasseBauen(new Straßen("Schillerstraße"));
		wolfsburg.neueStrasseBauen(new Straßen("Celler-Straße"));
		wolfsburg.neueStrasseBauen(new Straßen("Querbrakenring"));

		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Major-Hirst-Straße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Heinrich-Nordhoff-Straße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Schillerstraße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Celler-Straße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Querbrakenring")));

		assertFalse(wolfsburg.gibtEsDieStraße(new Straßen("Am Südhang")));

		assertEquals(5, wolfsburg.anzahlDerStraßen());

	}
}
