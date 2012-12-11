package org.webspectlanguage.webspec2wr.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 *
 */
public class WRDataModelFactoryTest {

	private WRDataModelFactory tester;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.tester = WRDataModelFactory.getInstance();
		this.tester.cleanUpForTesting();
	}
	
	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		WRDataModelFactory otherTester = WRDataModelFactory.getInstance();
		assertEquals(tester, otherTester);
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#existsEntityWithName(java.lang.String)}.
	 */
	@Test
	public void testExistsEntityWithName() {
		assertFalse(this.tester.existsEntityWithName("City"));
		this.tester.createEntity("City");
		assertTrue(this.tester.existsEntityWithName("City"));
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#getEntityWithName(java.lang.String)}.
	 */
	@Test
	public void testGetEntityWithName() {
		assertNull(this.tester.getEntityWithName("City"));
		this.tester.createEntity("City");
		assertNotNull(this.tester.getEntityWithName("City"));
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#createEntity(java.lang.String)}.
	 */
	@Test
	public void testCreateEntity() {
		assertNull(this.tester.getEntityWithName("City"));
		
		WREntity tmpEntity = (WREntity) this.tester.createEntity("City"); 
		
		assertNotNull(tmpEntity);
		assertEquals("City", tmpEntity.getName());
		assertEquals(1, tmpEntity.getAttributes().size());
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#addAttributeToEntity(java.lang.String, java.lang.String, org.webspectlanguage.webspec2wr.factory.datamodel.Entity)}.
	 */
	@Test
	public void testAddAttributeToEntity() {
		assertNull(this.tester.getEntityWithName("City"));
		
		WREntity tmpEntity = (WREntity) this.tester.createEntity("City"); 
		this.tester.addAttributeToEntity("name", "String", tmpEntity);
		assertEquals(2, tmpEntity.getAttributes().size());
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#addRelationshipToEntity(org.webspectlanguage.webspec2wr.factory.datamodel.WREntity, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddRelationshipToEntity() {
		assertNull(this.tester.getEntityWithName("City"));
		
		WREntity cityEntity = (WREntity) this.tester.createEntity("City");
		this.tester.createEntity("Country");
		
		this.tester.addRelationshipToEntity(cityEntity, "Country", "Many", "One");
		assertEquals(1, cityEntity.getRelationships().size());
		
		this.tester.addRelationshipToEntity(cityEntity, "Intendente", "Many", "One");
		assertEquals(3, this.tester.getEntities().size());
		assertEquals(2, cityEntity.getRelationships().size());
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#someEntityHasRelationshipTo(org.webspectlanguage.webspec2wr.factory.datamodel.WREntity)}.
	 */
	@Test
	public void testSomeEntityHasRelationshipTo() {
		WREntity cityEntity = (WREntity) this.tester.createEntity("City");
		WREntity countryEntity = (WREntity) this.tester.createEntity("Country");
		
		assertFalse(this.tester.someEntityHasRelationshipTo(cityEntity));
		assertFalse(this.tester.someEntityHasRelationshipTo(countryEntity));
		
		this.tester.addRelationshipToEntity(cityEntity, "Country", "Many", "One");
		assertFalse(this.tester.someEntityHasRelationshipTo(cityEntity));
		assertTrue(this.tester.someEntityHasRelationshipTo(countryEntity));
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#entityHasRelationshipTo(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testEntityHasRelationshipTo() {
		WREntity cityEntity = (WREntity) this.tester.createEntity("City");
		
		assertFalse(this.tester.entityHasRelationshipTo("City", "Country"));
		assertFalse(this.tester.entityHasRelationshipTo("Country", "City"));
		
		this.tester.addRelationshipToEntity(cityEntity, "Country", "Many", "One");
		assertTrue(this.tester.entityHasRelationshipTo("City", "Country"));
		assertFalse(this.tester.entityHasRelationshipTo("Country", "City"));
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRDataModelFactory#cleanUnnecessaryEntities()}.
	 */
	@Test
	public void testCleanUnnecessaryEntities() {
		WREntity cityEntity = (WREntity) this.tester.createEntity("City");
		this.tester.createEntity("Country");
		
		this.tester.cleanUnnecessaryEntities();
		assertEquals(0, this.tester.getEntities().size());
		
		cityEntity = (WREntity) this.tester.createEntity("City");
		this.tester.createEntity("Country");
		this.tester.addAttributeToEntity("name", "String", cityEntity);
		this.tester.cleanUnnecessaryEntities();
		assertEquals(1, this.tester.getEntities().size());
		assertNotNull(this.tester.getEntityWithName("City"));
		assertNull(this.tester.getEntityWithName("Country"));

		// Agrego una relacion
		this.tester.addRelationshipToEntity(cityEntity, "Country", "Many", "One");
		cityEntity = null;
		assertNotNull(this.tester.getEntityWithName("Country"));

		// Limpio
		this.tester.cleanUnnecessaryEntities();
		assertNotNull(this.tester.getEntityWithName("City"));
		assertNotNull(this.tester.getEntityWithName("Country"));

		// Testeo
		assertEquals(2, this.tester.getEntities().size());
	}

}
