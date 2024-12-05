package es.unileon.prg2.patterns.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.handler.Name;

public class RegionTests {

	private Region region;

	@BeforeEach
	public void setUp() throws Exception {
		this.region = new Region(new Name("CyL"));
	}

	@Test
	void testGetLevel() {
		assertEquals(Level.REGION, this.region.getLevel());
	}

	@Test
	public void testToStrig() {
		assertEquals("\t\tRegion: CyL\n", this.region.toString());
	}

}
