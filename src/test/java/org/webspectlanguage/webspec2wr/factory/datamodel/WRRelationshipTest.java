package org.webspectlanguage.webspec2wr.factory.datamodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 *
 */
public class WRRelationshipTest {

	private WREntity entityFrom;
	private WREntity entityTo;
	private WRRelationship tester;
	
	@Before
	public void setUp() {
		this.entityFrom = new WREntity("User");
		this.entityTo = new WREntity("City");
		this.tester = new WRRelationship(this.entityFrom, this.entityTo, "many", "one");
	}
	
	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.datamodel.WRRelationship#WRRelationship(org.webspectlanguage.webspec2wr.factory.datamodel.WREntity, org.webspectlanguage.webspec2wr.factory.datamodel.WREntity, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testWRRelationship() {
		assertEquals(this.entityFrom, this.tester.getFrom());
		assertEquals(this.entityTo, this.tester.getTo());
		assertEquals("many", this.tester.getCardinalityFrom());
		assertEquals("one", this.tester.getCardinalityTo());
	}
	
	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.datamodel.WRRelationship#hashCode()}.
	 */
	@Test
	public void testHashCode() {

		// TODO revisar url=http://ignorante.wordpress.com/2007/10/11/calculo-correcto-del-hashcode-en-java/
		
		WREntity userEntity = new WREntity("User");
		WREntity cityEntity = new WREntity("City");
		WREntity countryEntity = new WREntity("Country");
		
		WRRelationship sameRelation = new WRRelationship(userEntity, cityEntity, "many", "one");
		WRRelationship diferentRelation = new WRRelationship(userEntity, countryEntity, "many", "one");
		
		assertTrue((sameRelation.hashCode() == this.tester.hashCode()));
		assertFalse((diferentRelation.hashCode() == this.tester.hashCode()));
	}

	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.datamodel.WRRelationship#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		WREntity userEntity = new WREntity("User");
		WREntity cityEntity = new WREntity("City");
		WREntity countryEntity = new WREntity("Country");
		
		WRRelationship sameRelation = new WRRelationship(userEntity, cityEntity, "many", "one");
		WRRelationship diferentRelation = new WRRelationship(userEntity, countryEntity, "many", "one");
		
		assertTrue(this.tester.equals(sameRelation));
		assertFalse(this.tester.equals(diferentRelation));
	}

}
