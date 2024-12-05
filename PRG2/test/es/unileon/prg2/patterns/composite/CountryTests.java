package es.unileon.prg2.patterns.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.handler.Name;

public class CountryTests {

    private Country country;

    @BeforeEach
    public void setUp() throws Exception {
        this.country = new Country(new Name("Spain"));
    }

    @Test
    void testGetLevel() {
        assertEquals(Level.COUNTRY, this.country.getLevel());
    }

    @Test
    public void testToStrig() {
        assertEquals("\tCountry: Spain\n", this.country.toString());
    }

}
