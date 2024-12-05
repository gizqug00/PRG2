package es.unileon.prg2.patterns.composite;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.composite.*;
import es.unileon.prg2.patterns.handler.*;
import es.unileon.prg2.patterns.iterator.*;;

public class ElectoralCompositeTests {

	private ElectionsComponent spain, cyl, leon, zamora, benavente;
	private ElectionsComponent ana, juan, maria, pedro, eva, antonio;

	@BeforeEach
	public void setUp() throws CompositeException {
		//
		// Spain
		//   Castilla y León
		//     Leon
		//       Ana
		//       Juan
		//     Zamora
		//         Maria
		//         Pedro
		//       Benavente
		//         Eva
		//         Antonio
		//
		// initial composites
		this.spain = new Country(new GenericId("Spain"));
		this.cyl = new Region(new GenericId("Castilla y Leon"));
		this.leon = new Province(new GenericId("Leon"));
		this.zamora = new Province(new GenericId("Zamora"));
		this.benavente = new Munincipe(new GenericId("Benavente"));
		// initial leaves
		this.ana = new Citizen(new GenericId("Ana"));
		this.juan = new Citizen(new GenericId("Juan"));
		this.maria = new Citizen(new GenericId("Maria"));
		this.pedro = new Citizen(new GenericId("Pedro"));
		this.eva = new Citizen(new GenericId("Eva"));
		this.antonio = new Citizen(new GenericId("Antonio"));
		// building the tree
		this.spain.add(cyl);
		this.cyl.add(leon);
		this.cyl.add(zamora);
		this.zamora.add(benavente);
		// adding the leaves
		this.leon.add(ana);
		this.leon.add(juan);
		this.zamora.add(maria);
		this.zamora.add(pedro);
		this.benavente.add(eva);
		this.benavente.add(antonio);
	}

	@Test
	public void testGetIdOK() {
		assertNotEquals(new GenericId("Spai").toString(),
				this.spain.getId().toString());
		assertEquals(new GenericId("Spain").toString(),
				this.spain.getId().toString());
	}

	@Test
	public void testAddOK() throws CompositeException {
		CensusComponent rosa = new Citizen("Rosa");
		assertEquals(6, this.spain.size());
		this.spain.add(rosa);
		assertEquals(7, this.spain.size());
		assertSame(rosa, this.spain.search(rosa.getId()));
	}

	@Test
	public void testAddNotOKComposite() throws CompositeException {
		assertFalse(this.benavente.add(this.leon));
	}

	@Test
	public void testAddNotOKLeaf() throws CompositeException {
		Exception exception = assertThrows(CompositeException.class, () -> this.juan.add(ana));
		assertEquals("Nothing can be added to a leaf",
				exception.getMessage());
	}

	@Test
	public void testRemoveOK() {
		assertEquals(6, this.spain.size());
		assertTrue(this.spain.remove(this.ana));
		assertEquals(5, this.spain.size());
		assertNull(this.spain.search(this.ana.getId()));
	}

	@Test
	public void testRemoveNotOK() {
		CensusComponent rosa = new Citizen("Rosa");
		assertFalse(this.spain.remove(rosa));
	}

	@Test
	public void testSearchOk() {
		// it works for composites from several places
		assertSame(this.spain, this.spain.search(this.spain.getId()));
		assertSame(this.leon, this.cyl.search(this.leon.getId()));
		assertSame(this.benavente, this.cyl.search(this.benavente.getId()));
		// it works for leaves wherever they are
		assertSame(this.ana, this.spain.search(this.ana.getId()));
		assertSame(this.maria, this.spain.search(this.maria.getId()));
		assertSame(this.eva, this.spain.search(this.eva.getId()));
	}

	@Test
	public void testSearchNotOk() {
		assertNull(this.spain.search(new GenericId("Rosa")));
	}

	@Test
	public void testSize() throws CompositeException {
		// initial situation
		assertEquals(6, this.spain.size());
		assertEquals(6, this.cyl.size());
		assertEquals(2, this.leon.size());
		assertEquals(4, this.zamora.size());
		assertEquals(2, this.benavente.size());
		// adding a citizen to the root of the tree
		this.spain.add(new Citizen("Rosa"));
		assertEquals(7, this.spain.size());
		assertEquals(6, this.cyl.size());
		assertEquals(2, this.leon.size());
		assertEquals(4, this.zamora.size());
		assertEquals(2, this.benavente.size());
		// adding a citizen to a town (smallest composite)
		this.benavente.add(new Citizen("Alberto"));
		assertEquals(8, this.spain.size());
		assertEquals(7, this.cyl.size());
		assertEquals(2, this.leon.size());
		assertEquals(5, this.zamora.size());
		assertEquals(3, this.benavente.size());
	}

	@Test
	public void testToString() {
		assertEquals("	Country: Spain\n"
				+ "		Region: Castilla y Leon\n" + "			Province: Leon\n"
				+ "					Citizen: Ana\n" + "					Citizen: Juan\n"
				+ "			Province: Zamora\n" + "				Town: Benavente\n"
				+ "					Citizen: Eva\n" + "					Citizen: Antonio\n"
				+ "					Citizen: Maria\n" + "					Citizen: Pedro\n"
				,this.spain.toString());
	}

	@Test
	void testCreateIterator() {
		Iterator<CensusComponent> iterator = this.spain.createIterator();
		assertSame(this.cyl, iterator.currentElement());
	}

	@Test
	void testCreateIteratorString() {
		Iterator<CensusComponent> iterator = this.benavente.createIterator("whatever");
		assertSame(this.eva, iterator.currentElement());
		iterator = this.benavente.createIterator("queue");
		assertSame(this.antonio, iterator.currentElement());
	}

}