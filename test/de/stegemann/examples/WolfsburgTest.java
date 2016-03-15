package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	@Test
	public void straﬂenUndNamenInWolfsburg() throws Exception {
		Stadt wolfsburg = new Stadt();

		assertEquals("Wolfsburg", wolfsburg.getName());

		assertEquals(7, wolfsburg.anzahlAnEinwohnern());

		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Jana")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Mike")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Ralph")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Margit")));

		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Janina")));
		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Arne")));

		assertTrue(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Major-Hirst-Straﬂe")));
		assertTrue(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Heinrich-Nordhoff-Straﬂe")));
		assertTrue(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Schillerstraﬂe")));

		assertFalse(wolfsburg.gibtEsDieStraﬂe(new Straﬂen("Am S¸dhang")));

		assertEquals(5, wolfsburg.anzahlDerStraﬂen());
	}
}
