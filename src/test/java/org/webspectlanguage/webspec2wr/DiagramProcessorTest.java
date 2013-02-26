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

	WRDataModelFactory dataModelTester;
	WRWebModelFactory webModelTester;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.dataModelTester = WRDataModelFactory.getInstance();
		this.dataModelTester.cleanUpForTesting();

		this.webModelTester = WRWebModelFactory.getInstance();
		this.webModelTester.cleanUpForTesting();
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

		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/register.xml");
		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/registerAgain.xml");

		assertEquals("# Entities Pre Process: ", 0, this.dataModelTester
				.getEntities().size());

		tester.processDiagramsForDataModel();

		assertEquals("# Entities Post Process: ", 4, this.dataModelTester
				.getEntities().size());

		assertTrue("[E: User]",
				this.dataModelTester.existsEntityWithName("User"));
		assertTrue("[E: Post]",
				this.dataModelTester.existsEntityWithName("Post"));
		assertTrue("[E: Country]",
				this.dataModelTester.existsEntityWithName("Country"));
		assertFalse("[E: PanelWithOutItems]",
				this.dataModelTester.existsEntityWithName("PanelWithOutItems"));

		assertTrue("[E: User] -> [E: Country]",
				this.dataModelTester.entityHasRelationshipTo("User", "Country"));
		assertTrue("[E: User] -> [E: Post]",
				this.dataModelTester.entityHasRelationshipTo("User", "Post"));
		assertFalse("[E: Country] -> [E: Post]",
				this.dataModelTester.entityHasRelationshipTo("Country", "Post"));
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

		tester.addDiagramFilePath("/Users/kaki/Documents/LIFIA/spec2mdd/resources/careone.xml");

		assertEquals("# Pages Pre Process: ", 0, testerWebModel.getPages()
				.size());
 
		tester.processDiagramsForDataModel();
		tester.processDiagramsForWebModel();

		assertEquals("# Pages Post Process: ", 3, testerWebModel.getPages()
				.size());

		assertTrue("[P: Cars]", testerWebModel.existsPageWithName("Cars"));
		assertTrue("[P: NewCar]", testerWebModel.existsPageWithName("NewCar"));
		assertTrue("[P: NewBrand]",
				testerWebModel.existsPageWithName("NewBrand"));
		assertFalse("[P: City]", testerWebModel.existsPageWithName("City"));

	}

}
