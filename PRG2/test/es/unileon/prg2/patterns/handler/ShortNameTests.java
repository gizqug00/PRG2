package es.unileon.prg2.patterns.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;

public class ShortNameTests {
	
	private ShortName id;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.id = new ShortName("LE");
	}
	
	@Test
	public void testCompareToOk() throws MalformedHandlerException{
		Handler same = new ShortName(this.id);
		assertEquals(0, this.id.compareTo(same)); 
	}

	@Test
	public void testCompareToNotOk() throws MalformedHandlerException{
		assertEquals(1, this.id.compareTo(new ShortName("L"))); 
	}
	
	@Test
	public void testToString() {
		assertEquals("LE", this.id.toString()); 
	}
	
	@Test
	public void testLongerName() {
		Exception exception = assertThrows(MalformedHandlerException.class, () ->
		new ShortName("LEON"));
		assertEquals("The length of the identifier should be less than 2.\n" + 
						"LEON is not valid.",
					exception.getMessage());
	}
	
	@Test
	public void testEmptyName() {
		Exception exception = assertThrows(MalformedHandlerException.class, () ->
		new ShortName(""));
		assertEquals("The identifier can not be an empty one.\n",
					exception.getMessage());
	}
	
	@Test
	public void testOneNoCharName() {
		Exception exception = assertThrows(MalformedHandlerException.class, () ->
		new ShortName("1"));
		assertEquals("The identifier can only include letters.\n" + //
						"1 is not valid.",
					exception.getMessage());
	}
	
	@Test
	public void testTwoNoCharName() {
		Exception exception = assertThrows(MalformedHandlerException.class, () ->
		new ShortName("L1"));
		assertEquals("The identifier can only include letters.\n" + //
						"L1 is not valid.",
					exception.getMessage());
					exception = assertThrows(MalformedHandlerException.class, () ->
		new ShortName("1L"));
		assertEquals("The identifier can only include letters.\n" + //
						"1L is not valid.",
					exception.getMessage());
	}
	
}