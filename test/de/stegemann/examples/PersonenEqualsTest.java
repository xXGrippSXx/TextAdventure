
package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PersonenEqualsTest {
	private final static Straﬂen DEFAULT_STRASSE = new Straﬂen("Test");

	@Test
	public void personenMitEqualsVergleichen() throws Exception {
		Person person1 = new Person("Jan", DEFAULT_STRASSE);
		Person person2 = new Person("Arne", DEFAULT_STRASSE);

		assertNotEquals(person1, person2);
	}

	@Test
	public void identischePersonenSindEqual() throws Exception {
		Person person1 = new Person("Jan", DEFAULT_STRASSE);
		Person person2 = new Person("Jan", DEFAULT_STRASSE);

		assertEquals(person1, person2);
	}

	@Test
	public void filternVonPersonen() throws Exception {
		Person person1 = new Person("Arne", DEFAULT_STRASSE);
		Person person2 = new Person("Jan", DEFAULT_STRASSE);
		Person person3 = new Person("Jan", DEFAULT_STRASSE);

		Set<Person> allePersonen = new HashSet<>();
		allePersonen.add(person1);
		allePersonen.add(person2);
		allePersonen.add(person3);

		assertEquals(2, allePersonen.size());
		assertTrue(allePersonen.contains(person1));
		assertTrue(allePersonen.contains(person2));
		assertTrue(allePersonen.contains(person3));
		assertTrue(allePersonen.contains(new Person("Arne", DEFAULT_STRASSE)));
		assertFalse(allePersonen.contains(new Person("Dieter", DEFAULT_STRASSE)));
	}

	@Test
	public void personHatDieKorrekteStrasse() throws Exception {
		Person testPerson = new Person("Jan", DEFAULT_STRASSE);

		assertEquals(DEFAULT_STRASSE, testPerson.getStrasse());
	}
}
