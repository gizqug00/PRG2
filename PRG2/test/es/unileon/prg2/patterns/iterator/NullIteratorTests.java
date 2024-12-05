package es.unileon.prg2.patterns.iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.composite.CensusComponent;


public class NullIteratorTests {

    private NullIterator<CensusComponent> nullIterator;

    @BeforeEach
    void setUp() throws Exception{
        this.nullIterator = new NullIterator<CensusComponent>();
    }

    @Test
    void testCurrentElement() {
        assertNull(this.nullIterator.currentElement());
    }

    @Test
    void testFirstElement() {
        this.nullIterator.firstElement();
        assertNull(this.nullIterator.currentElement());
    }

    @Test
    void testHasMoreElements() {
        assertFalse(this.nullIterator.hasMoreElements());
    }

    @Test
    void testNextElement() {
        this.nullIterator.nextElement();
        assertNull(this.nullIterator.currentElement());
    }
}
