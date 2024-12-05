package es.unileon.prg2.patterns.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;

class LongNameTests {
	
	private LongName id;

	@BeforeEach
	void setUp() throws Exception {
		this.id = new LongName("Xfijgth");
	}
	
	@Test
	void testCompareToOk() {
		Handler same = new LongName(this.id);
		assertEquals(0, this.id.compareTo(same)); 
	}

	@Test
	void testCompareToNotOk() {
		assertEquals(1, this.id.compareTo(new LongName("Xfijgt"))); 
	}
	
	@Test
	void testToString() {
		assertEquals("Xfijgth", this.id.toString()); 
	}
	
}