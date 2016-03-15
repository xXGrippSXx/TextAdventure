package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WolfsburgTest {
	@Test
	public void stra�enUndNamenInWolfsburg() throws Exception {
		Stadt wolfsburg = new Stadt();

		assertEquals("Wolfsburg", wolfsburg.getName());

		assertEquals(7, wolfsburg.anzahlAnEinwohnern());

		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Jana")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Mike")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Ralph")));
		assertTrue(wolfsburg.istEinWohnerGemeldet(new Person("Margit")));

		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Janina")));
		assertFalse(wolfsburg.istEinWohnerGemeldet(new Person("Arne")));

		assertTrue(wolfsburg.gibtEsDieStra�e(new Stra�en("Major-Hirst-Stra�e")));
		assertTrue(wolfsburg.gibtEsDieStra�e(new Stra�en("Heinrich-Nordhoff-Stra�e")));
		assertTrue(wolfsburg.gibtEsDieStra�e(new Stra�en("Schillerstra�e")));

		assertFalse(wolfsburg.gibtEsDieStra�e(new Stra�en("Am S�dhang")));

		assertEquals(5, wolfsburg.anzahlDerStra�en());
	}
}
