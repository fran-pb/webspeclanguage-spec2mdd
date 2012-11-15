package org.webspectlanguage.webspec2wr.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 *
 */

public class WRWebModelFactoryTest {

	private WRWebModelFactory tester;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.tester = WRWebModelFactory.getInstance();
		this.tester.cleanUpForTesting();
	}
	
	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRWebModelFactory#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		WRWebModelFactory otherTester = WRWebModelFactory.getInstance();
		assertEquals(tester, otherTester);
	}
	
	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRWebModelFactory#existsPageWithName(java.lang.String)}.
	 */
	@Test
	public void testExistsPageWithName() {
		assertFalse(this.tester.existsPageWithName("UserList"));
		this.tester.createPage("UserList");
		assertTrue(this.tester.existsPageWithName("UserList"));
	}
	
	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRWebModelFactory#getPageWithName(java.lang.String)}.
	 */
	@Test
	public void testGetPageWithName() {
		assertNull(this.tester.getPageWithName("UserList"));
		this.tester.createPage("UserList");
		assertNotNull(this.tester.getPageWithName("UserList"));
	}
	
	/**
	 * Test method for {@link org.webspectlanguage.webspec2wr.factory.WRWebModelFactory#createPage(java.lang.String)}.
	 */
	@Test
	public void testCreatePage() {
		assertFalse(this.tester.existsPageWithName("CityList"));
		
		Integer pagesSizeBefore = this.tester.getPages().size();
		
		WRPage tmpPage = (WRPage) this.tester.createPage("CityList"); 
		
		assertNotNull(tmpPage);
		
		assertEquals("CityList", tmpPage.getName());
		assertEquals(pagesSizeBefore + 1, this.tester.getPages().size());
		assertTrue(this.tester.existsPageWithName("CityList"));
	}
	
	

}
