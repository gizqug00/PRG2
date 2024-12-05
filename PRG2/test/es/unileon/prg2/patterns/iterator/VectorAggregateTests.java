package es.unileon.prg2.patterns.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.composite.Citizen;
import es.unileon.prg2.patterns.composite.CensusComponent;
import es.unileon.prg2.patterns.handler.GenericId;

public class VectorAggregateTests {

    private VectorAggregate<CensusComponent> aggregate;
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

     }

    @Test
    void testCreateIterator() {
        Iterator<CensusComponent> listIterator;
        listIterator = this.aggregate.createIterator();
        assertSame(ana, listIterator.currentElement());
    }

    @Test
    void testCreateIterator2() {
        Iterator<CensusComponent> queueIterator;
        queueIterator = this.aggregate.createIterator("queue");
        assertSame(eva, queueIterator.currentElement());
    }

    @Test
    void testGetElement() {
        assertSame(ana, this.aggregate.get(0));
        this.aggregate.remove(0);
        assertSame(juan, this.aggregate.get(0));
    }

    @Test
    void testGetSize() {
        assertEquals(4, this.aggregate.getSize());
        this.aggregate.remove(0);
        assertEquals(3, this.aggregate.getSize());
    }

    @Test
    void testRemoveElement() {
        assertEquals(4, this.aggregate.getSize());
        assertSame(ana, this.aggregate.get(0));
        this.aggregate.remove(0);
        assertEquals(3, this.aggregate.getSize());
        assertSame(juan, this.aggregate.get(0));
    }

}
