package es.unileon.prg2.patterns.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import es.unileon.prg2.patterns.handler.Name;

public class ProvinceTests {
	
	private Province province;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.province = new Province(new Name("Leon"));
	}

    @Test
    void testGetLevel() {
        assertEquals(Level.PROVINCE, this.province.getLevel());
    }	
	
	@Test
	public void testToStrig() {
		assertEquals("\t\t\tProvince: Leon\n", this.province.toString());
	}
	
}
