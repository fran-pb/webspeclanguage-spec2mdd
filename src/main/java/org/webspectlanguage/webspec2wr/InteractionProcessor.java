package org.webspectlanguage.webspec2wr;

import java.util.Iterator;
import java.util.List;

import org.webspeclanguage.api.Interaction;
import org.webspeclanguage.impl.widget.Widget;
import org.webspectlanguage.webspec2wr.factory.DataModelFactory;
import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;
import org.webspectlanguage.webspec2wr.factory.WRWebModelFactory;
import org.webspectlanguage.webspec2wr.factory.WebModelFactory;
import org.webspectlanguage.webspec2wr.factory.datamodel.visitor.WRDataModelWidgetVisitor;
import org.webspectlanguage.webspec2wr.factory.datamodel.visitor.WRWebModelWidgetVisitor;
import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class InteractionProcessor {

	private DataModelFactory dataModel;
	private WebModelFactory webModel;
	private Interaction interaction;
	private TransitionProcessor transitionProcessor;

	public InteractionProcessor() {
		dataModel = null;
		webModel = null;
		interaction = null;
		transitionProcessor = new TransitionProcessor();
	}

	public void setDataModel(DataModelFactory newDataModel) {
		dataModel = newDataModel;
	}

	public DataModelFactory getDataModel() {
		return dataModel;
	}

	public void setWebModel(WebModelFactory newWebModel) {
		webModel = newWebModel;
	}

	public WebModelFactory getWebModel() {
		return webModel;
	}

	public void setInteraction(Interaction newInteraction) {
		interaction = newInteraction;
	}

	public Interaction getInteraction() {
		return interaction;
	}

	/*
	 * DataModel Process
	 */
	public List<Widget> getWidgetsFromInteraction() {
		return this.getInteraction().getRoot().getWidgets();
	}

	public void process(WRDataModelFactory dataModel) {

		this.setDataModel(dataModel);

		WRDataModelWidgetVisitor visitor = new WRDataModelWidgetVisitor();
		Iterator<Widget> itrWidgets = this.getWidgetsFromInteraction()
				.iterator();

		while (itrWidgets.hasNext()) {
			Widget widget = itrWidgets.next();

			widget.accept(visitor);
		}

	}

	/*
	 * WebModel Process
	 */
	public void process(WRWebModelFactory webModel) {

		this.setWebModel(webModel);

		String name = this.getInteraction().getName();
		WRPage page = (WRPage) ((WRWebModelFactory) this.getWebModel())
				.createPage(name);

		processPages(page);
	}

	private void processPages(WRPage aPage) {
		// TODO revisar que una unica interaccion tenga marca de Starting

		WRWebModelWidgetVisitor visitor = new WRWebModelWidgetVisitor(aPage);
		Iterator<Widget> itrWidgets = this.getInteraction().getRoot()
				.getWidgets().iterator();

		while (itrWidgets.hasNext()) {
			Widget widget = itrWidgets.next();

			widget.accept(visitor);
		}
	}

}
