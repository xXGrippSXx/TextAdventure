package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class StraﬂenEqualsTEst {
	@Test
	public void StraﬂennMitEqualsVergleichen() throws Exception {
		Straﬂen straﬂe1 = new Straﬂen("AlsterBurgwall");
		Straﬂen straﬂe2 = new Straﬂen("Heinrich-Schˆneberger");

		assertNotEquals(straﬂe1, straﬂe2);
	}

	@Test
	public void identischeStraﬂennSindEqual() throws Exception {
		Straﬂen straﬂe1 = new Straﬂen("AlterBurgwall");
		Straﬂen straﬂe2 = new Straﬂen("AlterBurgwall");

		assertEquals(straﬂe1, straﬂe2);
	}

	@Test
	public void filternVonStraﬂenen() throws Exception {
		Straﬂen straﬂe1 = new Straﬂen("Heinrich-Schˆneberger");
		Straﬂen straﬂe2 = new Straﬂen("AlterBurgwall");
		Straﬂen straﬂe3 = new Straﬂen("AlterBurgwall");

		Set<Straﬂen> alleStraﬂenen = new HashSet<>();
		alleStraﬂenen.add(straﬂe1);
		alleStraﬂenen.add(straﬂe2);
		alleStraﬂenen.add(straﬂe3);

		assertEquals(2, alleStraﬂenen.size());
		assertTrue(alleStraﬂenen.contains(straﬂe1));
		assertTrue(alleStraﬂenen.contains(straﬂe2));
		assertTrue(alleStraﬂenen.contains(straﬂe3));
		assertTrue(alleStraﬂenen.contains(new Straﬂen("Heinrich-Schˆneberger")));
		assertFalse(alleStraﬂenen.contains(new Straﬂen("Hamburger Straﬂen")));
	}
}
