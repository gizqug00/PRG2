package es.unileon.prg2.patterns.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenericIdTests {

	private GenericId id;

	@BeforeEach
	void setUp() throws Exception {
		this.id = new GenericId("Xfijgth");
	}
	
	@Test
	void testCompareToOk() {
		Handler same = new GenericId(this.id);
		assertEquals(0, this.id.compareTo(same)); 
	}

	@Test
	void testCompareToNotOk() {
		assertEquals(1, this.id.compareTo(new GenericId("Xfijgt"))); 
	}
	
	@Test
	void testToString() {
		assertEquals("Xfijgth", this.id.toString()); 
	}

}
