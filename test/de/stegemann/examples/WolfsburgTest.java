package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	@Test
	public void straßenUndNamenInWolfsburg() throws Exception {
		Stadt wolfsburg = new Stadt();

		assertEquals("Wolfsburg", wolfsburg.getName());

		assertEquals(7, wolfsburg.anzahlAnEinwohnern());

		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Jana")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Mike")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Ralph")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Margit")));

		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Janina")));
		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Arne")));

		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Major-Hirst-Straße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Heinrich-Nordhoff-Straße")));
		assertTrue(wolfsburg.gibtEsDieStraße(new Straßen("Schillerstraße")));

		assertFalse(wolfsburg.gibtEsDieStraße(new Straßen("Am Südhang")));

		assertEquals(5, wolfsburg.anzahlDerStraßen());
	}
}
