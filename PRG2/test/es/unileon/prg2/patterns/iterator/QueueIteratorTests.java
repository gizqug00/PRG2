package es.unileon.prg2.patterns.iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.composite.Citizen;
import es.unileon.prg2.patterns.composite.CensusComponent;
import es.unileon.prg2.patterns.handler.GenericId;

public class QueueIteratorTests {

    private QueueIterator<CensusComponent> queueIterator;
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
	
		this.queueIterator = new QueueIterator<CensusComponent>(this.aggregate);
	}

    @Test
    void testCurrentElement() {
        assertSame(eva, this.queueIterator.currentElement());
        this.queueIterator.nextElement();
        assertSame(pedro, this.queueIterator.currentElement());
    }

    @Test
    void testFirstElement() {
        assertSame(eva, this.queueIterator.currentElement());
        this.queueIterator.nextElement();
        assertSame(pedro, this.queueIterator.currentElement());
        this.queueIterator.firstElement();
        assertSame(eva, this.queueIterator.currentElement());
    }

    @Test
    void testHasMoreElements() {
        assertTrue(this.queueIterator.hasMoreElements());
        this.queueIterator.nextElement();
        assertTrue(this.queueIterator.hasMoreElements());
        this.queueIterator.nextElement();
        assertTrue(this.queueIterator.hasMoreElements());
        this.queueIterator.nextElement();
        assertTrue(this.queueIterator.hasMoreElements());
        this.queueIterator.nextElement();
        assertFalse(this.queueIterator.hasMoreElements());
    }

    @Test
    void testNextElement() {
        assertSame(eva, this.queueIterator.currentElement());
        this.queueIterator.nextElement();
        assertSame(pedro, this.queueIterator.currentElement());
    }
}