package es.unileon.prg2.patterns.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.composite.Citizen;
import es.unileon.prg2.patterns.composite.CensusComponent;
import es.unileon.prg2.patterns.handler.GenericId;

public class ListIteratorTests {

    private ListIterator<CensusComponent> listIterator;
    private Aggregate<CensusComponent> aggregate;
	private CensusComponent ana, juan, pedro, eva;

    @BeforeEach
	void setUp() throws Exception {
        // aggregate is not a composite pattern
        this.aggregate = new VectorAggregate<CensusComponent>();
		this.ana = new Citizen(new GenericId("Ana"));
		this.juan = new Citizen(new GenericId("Juan"));
		this.pedro = new Citizen(new GenericId("Pedro"));
		this.eva = new Citizen(new GenericId("Eva"));

		this.aggregate.add(ana);
		this.aggregate.add(juan);
		this.aggregate.add(pedro);
		this.aggregate.add(eva);
	
		this.listIterator = new ListIterator<CensusComponent>(this.aggregate);
	}

    @Test
    void testCurrentElement() {
        assertSame(ana, this.listIterator.currentElement());
        this.listIterator.nextElement();
        assertSame(juan, this.listIterator.currentElement());
    }

    @Test
    void testFirstElement() {
        assertSame(ana, this.listIterator.currentElement());
        this.listIterator.nextElement();
        assertSame(juan, this.listIterator.currentElement());
        this.listIterator.firstElement();
        assertSame(ana, this.listIterator.currentElement());
    }

    @Test
    void testHasMoreElements() {
        assertTrue(this.listIterator.hasMoreElements());
        this.listIterator.nextElement();
        assertTrue(this.listIterator.hasMoreElements());
        this.listIterator.nextElement();
        assertTrue(this.listIterator.hasMoreElements());
        this.listIterator.nextElement();
        assertTrue(this.listIterator.hasMoreElements());
        this.listIterator.nextElement();
        assertFalse(this.listIterator.hasMoreElements());
    }

    @Test
    void testNextElement() {
        assertSame(ana, this.listIterator.currentElement());
        this.listIterator.nextElement();
        assertSame(juan, this.listIterator.currentElement());
    }
}
