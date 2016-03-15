package de.stegemann.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PersonenEqualsTest {
	@Test
	public void personenMitEqualsVergleichen() throws Exception {
		Person person1 = new Person("Jan");
		Person person2 = new Person("Arne");

		assertNotEquals(person1, person2);
	}

	@Test
	public void identischePersonenSindEqual() throws Exception {
		Person person1 = new Person("Jan");
		Person person2 = new Person("Jan");

		assertEquals(person1, person2);
	}
}
