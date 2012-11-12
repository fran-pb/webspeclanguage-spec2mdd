package org.webspectlanguage.webspec2wr;

import java.util.ArrayList;
import java.util.Iterator;

import org.webspeclanguage.api.Interaction;
import org.webspeclanguage.impl.core.DiagramImpl;
import org.webspeclanguage.io.WebSpecParser;
import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;
import org.webspectlanguage.webspec2wr.factory.WRWebModelFactory;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class DiagramProcessor {

	// private static Set<DiagramImpl> diagrams = new HashSet<DiagramImpl>();
	private WRDataModelFactory dataModel = WRDataModelFactory.getInstance();
	private WRWebModelFactory webModel = WRWebModelFactory.getInstance();
	private ArrayList<DiagramImpl> diagrams = new ArrayList<DiagramImpl>();

	private DiagramImpl openDiagramFile(String filepath) {
		// Construct an instance of the parser and specify a file WebSpec
		WebSpecParser parser = new WebSpecParser();
		DiagramImpl diagram = (DiagramImpl) parser.parseFromFilePath(filepath);
		return diagram;
	}

	public void addDiagramFilePath(String filepath) {
		this.getDiagrams().add(openDiagramFile(filepath));
	}

	/*
	 * DataModel Process
	 */

	public void showDataModel() {
		this.getDataModel().showOnConsole();
	}

	public void processDiagramsForDataModel() {
		for (DiagramImpl diagram : this.getDiagrams())
			updateDataModel(diagram);

		this.cleanDataModel();
	}

	private void updateDataModel(DiagramImpl diagram) {
		// Build an instance of InteractionPartser
		InteractionProcessor interactionProcessor = new InteractionProcessor();

		// iterate through the interactions
		Iterator<Interaction> itrInteractions = diagram.getInteractions()
				.iterator();

		while (itrInteractions.hasNext()) {
			Interaction interaction = itrInteractions.next();

			// process an interaction
			interactionProcessor.setInteraction(interaction);
			interactionProcessor.process(this.getDataModel());
		}

	}

	private void cleanDataModel() {
		this.getDataModel().cleanUnnecessaryEntities();
	}

	/*
	 * WebModel Process
	 */

	private void showWebModel() {
		this.getWebModel().showOnConsole();
	}

	public void processDiagramsForWebModel() {
		for (DiagramImpl diagram : this.getDiagrams())
			updateWebModel(diagram);
	}

	private void updateWebModel(DiagramImpl diagram) {
		// Build an instance of InteractionPartser
		InteractionProcessor interactionProcessor = new InteractionProcessor();

		// iterate through the interactions
		Iterator<Interaction> itrInteractions = diagram.getInteractions()
				.iterator();

		while (itrInteractions.hasNext()) {
			Interaction interaction = itrInteractions.next();

			// process an interaction
			interactionProcessor.setInteraction(interaction);
			interactionProcessor.process(this.getWebModel());
		}

	}

	/*
	 * Getter & Setters
	 */

	public WRDataModelFactory getDataModel() {
		return dataModel;
	}

	public void setDataModel(WRDataModelFactory dataModel) {
		this.dataModel = dataModel;
	}

	public WRWebModelFactory getWebModel() {
		return webModel;
	}

	public void setWebModel(WRWebModelFactory webModel) {
		this.webModel = webModel;
	}

	public ArrayList<DiagramImpl> getDiagrams() {
		return diagrams;
	}

	public void setDiagrams(ArrayList<DiagramImpl> diagrams) {
		this.diagrams = diagrams;
	}

}
