package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	@Test
	public void stra�enUndNamenInWolfsburg() throws Exception {
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

		assertEquals(2, wolfsburg.anzahlAnEinwohnernInStrasse(new Stra�en("Modersohn-Becker-Ring")));
	}
}
