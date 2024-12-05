package es.unileon.prg2.patterns.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.*;

public class NameTests {

	private Name id;

	@BeforeEach
	void setUp() throws Exception {
		this.id = new Name("Xfijgth");
	}
	
	@Test
	void testCompareToOk() {
		Handler same = new Name(this.id);
		assertEquals(0, this.id.compareTo(same)); 
	}

	@Test
	void testCompareToNotOk() {
		assertEquals(1, this.id.compareTo(new Name("Xfijgt"))); 
	}
	
	@Test
	void testToString() {
		assertEquals("Xfijgth", this.id.toString()); 
	}

}