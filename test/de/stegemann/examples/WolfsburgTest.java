package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	@Test
	public void straﬂenUndNamenInWolfsburg() throws Exception {
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

		assertEquals(2, wolfsburg.anzahlAnEinwohnernInStrasse(new Straﬂen("Modersohn-Becker-Ring")));
	}
}
