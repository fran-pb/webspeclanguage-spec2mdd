package org.webspectlanguage.webspec2wr.factory.datamodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 * 
 */
public class WREntityTest {

	private WRDataModelFactory dataModel;
	private WREntity tester;
	
	@Before
	public void setUp() {
		this.dataModel = WRDataModelFactory.getInstance();
		this.dataModel.cleanUpForTesting();
		this.tester = (WREntity) this.dataModel.createEntity("User");
	}
	
	/**
	 * Test method for normal setup: Construct with name and dataModel
	 * {@link org.webspectlanguage.webspec2wr.factory.datamodel.WREntity#WREntity(org.webspectlanguage.webspec2wr.factory.WRDataModelFactory, java.lang.String)}
	 * .
	 */
	@Test
	public void testWREntity() {
		assertEquals("User", this.tester.getName());
		assertFalse(this.tester.getAttributes().isEmpty());
		assertTrue(this.tester.getRelationships().isEmpty());
	}
	
	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.factory.datamodel.WREntity#addAttribute(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testAddAttribute() {
		this.tester.addAttribute("firstName", "String");
		assertEquals(2, this.tester.getAttributes().size());
		
		this.tester.addAttribute("firstName", "String");
		assertEquals(2, this.tester.getAttributes().size());
		
		this.tester.addAttribute("lastName", "String");
		assertEquals(3, this.tester.getAttributes().size());
	}

	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.factory.datamodel.WREntity#addRelationship(org.webspectlanguage.webspec2wr.factory.datamodel.WREntity, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testAddRelationship() {
		WREntity cityOneEntity = new WREntity("City");
		WREntity cityTwoEntity = new WREntity("City");
		
		WREntity countryEntity = new WREntity("Country");
		
		/* Add a new relation */
		this.tester.addRelationship(cityOneEntity, "many", "one");
		assertEquals(1, this.tester.getRelationships().size());
		
		/* Try adding a relationship that currently exists and should have no effect */
		this.tester.addRelationship(cityOneEntity, "many", "one");
		assertEquals(1, this.tester.getRelationships().size());
		
		/* try adding a relationship that currently exists and should have no effect,
		 * even if the target entity is just another instance
		 */
		this.tester.addRelationship(cityTwoEntity, "many", "one");
		assertEquals(1, this.tester.getRelationships().size());
		
		/* try adding a relationship that currently exists, although this time differs in cardinality,
		 * should result in a new relationship
		 */
		this.tester.addRelationship(cityOneEntity, "one", "many");
		assertEquals(2, this.tester.getRelationships().size());
		
		/* Add a new relation */
		this.tester.addRelationship(countryEntity, "many", "one");
		assertEquals(3, this.tester.getRelationships().size());
	}

	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.factory.datamodel.WREntity#equals(java.lang.Object)}
	 * .
	 */
	@Test
	public void testEquals() {
		WREntity otherSameEntity = new WREntity("User");
		WREntity otherDiferentEntity = new WREntity("Country");
		assertEquals(this.tester, otherSameEntity);
		
		this.tester.addAttribute("firstName", "String");
		otherSameEntity.addAttribute("firstName", "String");
		assertEquals(this.tester, otherSameEntity);
		
		this.tester.addAttribute("secondName", "String");
		otherSameEntity.addAttribute("lastName", "String");
		assertEquals(this.tester, otherSameEntity);
		
		assertFalse(this.tester.equals(otherDiferentEntity));
	}
	
	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.factory.datamodel.WREntity#existsRelationshipTo(org.webspectlanguage.webspec2wr.factory.datamodel.WREntity)}
	 * .
	 */
	@Test
	public void testExistsRelationshipTo() {
		WREntity cityOneEntity = new WREntity("City");
		WREntity countryEntity = new WREntity("Country");
		
		assertFalse(this.tester.existsRelationshipTo(cityOneEntity));
		
		this.tester.addRelationship(cityOneEntity, "many", "one");
		assertTrue(this.tester.existsRelationshipTo(cityOneEntity));
		
		this.tester.addRelationship(cityOneEntity, "one", "many");
		assertTrue(this.tester.existsRelationshipTo(cityOneEntity));
		
		this.tester.addRelationship(countryEntity, "many", "one");
		assertTrue(this.tester.existsRelationshipTo(countryEntity));
	}

	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.factory.datamodel.WREntity#hasAttributes()}
	 * .
	 */
	@Test
	public void testHasAttributes() {
		
		assertFalse(this.tester.hasAttributes());
		
		this.tester.addAttribute("firstName", "String");
		assertTrue(this.tester.hasAttributes());
		
		this.tester.addAttribute("lastName", "String");
		assertTrue(this.tester.hasAttributes());
	}

	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.factory.datamodel.WREntity#hasRelationships()}
	 * .
	 */
	@Test
	public void testHasRelationships() {
		WREntity cityOneEntity = new WREntity("City");
		WREntity countryEntity = new WREntity("Country");
		
		assertFalse(this.tester.hasRelationships());
		
		this.tester.addRelationship(cityOneEntity, "many", "one");
		assertTrue(this.tester.hasRelationships());
		
		this.tester.addRelationship(countryEntity, "many", "one");
		assertTrue(this.tester.hasRelationships());
	}

	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.factory.datamodel.WREntity#isUnnecessary()}
	 * .
	 */
	@Test
	public void testIsUnnecessary() {
		WREntity cityEntity = (WREntity) this.dataModel.createEntity("City");
		
		assertTrue(this.tester.isUnnecessary());
		
		this.tester.addRelationship(cityEntity, "many", "one");
		
		assertFalse(this.tester.isUnnecessary());
		assertFalse(cityEntity.isUnnecessary());

		WREntity countryEntity = (WREntity) this.dataModel.createEntity("Country");
		assertTrue(countryEntity.isUnnecessary());
		
		countryEntity.addAttribute("name", "String");
		assertFalse(countryEntity.isUnnecessary());
	}

}
