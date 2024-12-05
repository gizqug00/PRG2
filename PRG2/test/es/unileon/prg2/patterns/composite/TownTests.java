package es.unileon.prg2.patterns.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.handler.Name;

public class TownTests {

	private Town town;

	@BeforeEach
	public void setUp() throws Exception {
		this.town = new Town(new Name("Leon"));
	}

	@Test
	void testGetLevel() {
		assertEquals(Level.TOWN, this.town.getLevel());
	}

	@Test
	public void testToStrig() {
		assertEquals("\t\t\t\tTown: Leon\n", this.town.toString());
	}

}
