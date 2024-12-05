package es.unileon.prg2.patterns.composite;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.handler.Name;

public class LevelTests {

    private Level level;
    private CensusComponent spain, cyl, leon, astorga, luis;

    @BeforeEach
    public void setUp() throws Exception { 
        this.level = Level.getInstancia();
        this.spain = new Country(new Name("Spain"));
        this.cyl = new Region(new Name("CyL"));
        this.leon = new Province(new Name("Leon"));
        this.astorga = new Town(new Name("Astorga"));
        this.luis = new Citizen(new Name("Luis"));
    } 

    @Test
    void testCanAddOk() {
        assertTrue(this.level.canAdd(spain, cyl));
        assertTrue(this.level.canAdd(spain, leon));
        assertTrue(this.level.canAdd(spain, astorga));
        assertTrue(this.level.canAdd(spain, luis));

        assertTrue(this.level.canAdd(cyl, leon));
        assertTrue(this.level.canAdd(cyl, astorga));
        assertTrue(this.level.canAdd(cyl, luis));

        assertTrue(this.level.canAdd(leon, astorga));
        assertTrue(this.level.canAdd(leon, luis));

        assertTrue(this.level.canAdd(astorga, luis));
    }

    @Test
    void testCanAddNotOk() {
        assertFalse(this.level.canAdd(luis, astorga));
        assertFalse(this.level.canAdd(luis, leon));
        assertFalse(this.level.canAdd(luis, cyl));
        assertFalse(this.level.canAdd(luis, spain));

        assertFalse(this.level.canAdd(astorga, leon));
        assertFalse(this.level.canAdd(astorga, cyl));
        assertFalse(this.level.canAdd(astorga, spain));

        assertFalse(this.level.canAdd(leon, cyl));
        assertFalse(this.level.canAdd(leon, spain));

        assertFalse(this.level.canAdd(cyl, spain));
    }

    @Test
    void testGetInstancia() {
        assertSame(this.level, Level.getInstancia());
    }

}
