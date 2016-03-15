package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringEqualsTest {
	@Test
	public void stringsInEinerListe() throws Exception {
		List<String> strings = new ArrayList<>();
		strings.add("Jan");
		strings.add("Arne");
		strings.add("Jan");

		assertEquals(3, strings.size());
		assertTrue(strings.contains("Jan"));
		assertTrue(strings.contains("Arne"));
	}
}
