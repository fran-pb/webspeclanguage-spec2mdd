package org.webspectlanguage.webspec2wr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;
import org.webspectlanguage.webspec2wr.factory.WRWebModelFactory;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 * 
 */
public class DiagramProcessorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		WRDataModelFactory tester = WRDataModelFactory.getInstance();
		tester.cleanUpForTesting();
	}
	
	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.DiagramProcessor#addDiagramFilePath(java.lang.String)}
	 * .
	 */
	@Test
	public void testAddDiagramFilePath() {
		DiagramProcessor tester = new DiagramProcessor();

		assertEquals("Result", 0, tester.getDiagrams().size());

		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/register.xml");
		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/registerAgain.xml");

		assertEquals("Result", 2, tester.getDiagrams().size());
	}

	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.DiagramProcessor#processDiagramsForDataModel()}
	 * .
	 */
	@Test
	public void testProcessDiagramsForDataModel() {
		DiagramProcessor tester = new DiagramProcessor();
		WRDataModelFactory testerDataModel = tester.getDataModel();

		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/register.xml");
		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/registerAgain.xml");

		assertEquals("# Entities Pre Process: ", 0, testerDataModel
				.getEntities().size());

		tester.processDiagramsForDataModel();

		assertEquals("# Entities Post Process: ", 3, testerDataModel
				.getEntities().size());

		assertTrue("[E: User]", testerDataModel.existsEntityWithName("User"));
		assertTrue("[E: Post]", testerDataModel.existsEntityWithName("Post"));
		assertTrue("[E: Country]",
				testerDataModel.existsEntityWithName("Country"));
		assertFalse("[E: PanelWithOutItems]",
				testerDataModel.existsEntityWithName("PanelWithOutItems"));

		assertTrue("[E: User] -> [E: Country]",
				testerDataModel.entityHasRelationshipTo("User", "Country"));
		assertTrue("[E: User] -> [E: Post]",
				testerDataModel.entityHasRelationshipTo("User", "Post"));
		assertFalse("[E: Country] -> [E: Post]",
				testerDataModel.entityHasRelationshipTo("Country", "Post"));
	}
	
	/**
	 * Test method for
	 * {@link org.webspectlanguage.webspec2wr.DiagramProcessor#processDiagramsForWebModel()}
	 * .
	 */
	@Test
	public void testProcessDiagramsForWebModel() {
		DiagramProcessor tester = new DiagramProcessor();
		WRWebModelFactory testerWebModel = tester.getWebModel();

		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/register.xml");
		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/registerAgain.xml");

		assertEquals("# Pages Pre Process: ", 0, testerWebModel
				.getPages().size());

		tester.processDiagramsForWebModel();

		assertEquals("# Pages Post Process: ", 6, testerWebModel
				.getPages().size());

		assertTrue("[P: Login]", testerWebModel.existsPageWithName("Home"));
		assertTrue("[P: Login]", testerWebModel.existsPageWithName("Login"));
		assertTrue("[P: Register]", testerWebModel.existsPageWithName("Register"));
		assertTrue("[P: Home]", testerWebModel.existsPageWithName("Home"));
		assertTrue("[P: Country Detail]", testerWebModel.existsPageWithName("CountryDetail"));
		assertFalse("[P: City]", testerWebModel.existsPageWithName("City"));

	}

}
