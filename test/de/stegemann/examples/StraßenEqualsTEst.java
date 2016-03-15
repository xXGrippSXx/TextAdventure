package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Stra�enEqualsTEst {
	@Test
	public void Stra�ennMitEqualsVergleichen() throws Exception {
		Stra�en stra�e1 = new Stra�en("AlsterBurgwall");
		Stra�en stra�e2 = new Stra�en("Heinrich-Sch�neberger");

		assertNotEquals(stra�e1, stra�e2);
	}

	@Test
	public void identischeStra�ennSindEqual() throws Exception {
		Stra�en stra�e1 = new Stra�en("AlterBurgwall");
		Stra�en stra�e2 = new Stra�en("AlterBurgwall");

		assertEquals(stra�e1, stra�e2);
	}

	@Test
	public void filternVonStra�enen() throws Exception {
		Stra�en stra�e1 = new Stra�en("Heinrich-Sch�neberger");
		Stra�en stra�e2 = new Stra�en("AlterBurgwall");
		Stra�en stra�e3 = new Stra�en("AlterBurgwall");

		Set<Stra�en> alleStra�enen = new HashSet<>();
		alleStra�enen.add(stra�e1);
		alleStra�enen.add(stra�e2);
		alleStra�enen.add(stra�e3);

		assertEquals(2, alleStra�enen.size());
		assertTrue(alleStra�enen.contains(stra�e1));
		assertTrue(alleStra�enen.contains(stra�e2));
		assertTrue(alleStra�enen.contains(stra�e3));
		assertTrue(alleStra�enen.contains(new Stra�en("Heinrich-Sch�neberger")));
		assertFalse(alleStra�enen.contains(new Stra�en("Hamburger Stra�en")));
	}
}
