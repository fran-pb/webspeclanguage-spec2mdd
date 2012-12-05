package org.webspectlanguage.webspec2wr.factory.webmodel.visitor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.webspeclanguage.impl.widget.Button;
import org.webspeclanguage.impl.widget.CheckBox;
import org.webspeclanguage.impl.widget.ComboBox;
import org.webspeclanguage.impl.widget.Label;
import org.webspeclanguage.impl.widget.Link;
import org.webspeclanguage.impl.widget.ListBox;
import org.webspeclanguage.impl.widget.ListOfContainer;
import org.webspeclanguage.impl.widget.Panel;
import org.webspeclanguage.impl.widget.RadioButton;
import org.webspeclanguage.impl.widget.TextField;
import org.webspeclanguage.impl.widget.Widget;
import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;
import org.webspectlanguage.webspec2wr.factory.WRWebModelFactory;
import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRDataUnit;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WREntryUnit;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRWebModelWidgetVisitor implements
		org.webspeclanguage.api.utils.WidgetVisitor {

	private WRPage page;
	private WRDataModelFactory dataModel;
	private WRWebModelFactory webModel;

	private List<String> acceptableEntryUnitWidgets;
	private List<String> acceptableIndexUnitWidgets;

	/*
	 * Constructs
	 */
	public WRWebModelWidgetVisitor(WRPage aPage) {
		this.page = aPage;
		this.dataModel = WRDataModelFactory.getInstance();
		this.webModel = WRWebModelFactory.getInstance();

		this.acceptableEntryUnitWidgets = Arrays.asList(
				"org.webspeclanguage.impl.widget.TextField",
				"org.webspeclanguage.impl.widget.CheckBox",
				"org.webspeclanguage.impl.widget.ComboBox",
				"org.webspeclanguage.impl.widget.RadioButton");

		this.acceptableIndexUnitWidgets = Arrays
				.asList("org.webspeclanguage.impl.widget.TextField");
	}

	/*
	 * Setters and Getters
	 */
	public WRPage getPage() {
		return page;
	}

	public void setPage(WRPage page) {
		this.page = page;
	}

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

	public List<String> getAcceptableEntryUnitWidgets() {
		return acceptableEntryUnitWidgets;
	}

	public void setAcceptableEntryUnitWidgets(
			List<String> acceptableEntryUnitWidgets) {
		this.acceptableEntryUnitWidgets = acceptableEntryUnitWidgets;
	}

	public List<String> getAcceptableIndexUnitWidgets() {
		return acceptableIndexUnitWidgets;
	}

	public void setAcceptableIndexUnitWidgets(
			List<String> acceptableIndexUnitWidgets) {
		this.acceptableIndexUnitWidgets = acceptableIndexUnitWidgets;
	}

	/*
	 * Visitor Override
	 */
	@Override
	public void visit(TextField textField) {

	}

	@Override
	public void visit(Button button) {

	}

	@Override
	public void visit(CheckBox checkBox) {

	}

	@Override
	public void visit(ComboBox comboBox) {

	}

	@Override
	public void visit(Link link) {

	}

	@Override
	public void visit(ListBox listBox) {

	}

	@Override
	public void visit(ListOfContainer listOfContainer) {

	}

	@Override
	public void visit(RadioButton radioButton) {

	}

	@Override
	public void visit(Label label) {

	}

	@Override
	public void visit(Panel panel) {

		if (panel.getWidgets().size() > 0) {

			/*
			 * TODO Warning: Revisar bien como distinguir bien las distintas
			 * reglas de inferencia
			 */

			Widget firstWidget = panel.getWidgets().get(0);

			String widgetClass = firstWidget.getClass().getName();

			if (widgetClass == "org.webspeclanguage.impl.widget.Label") {
				this.inferDataUnit(panel);
			} else if (this.getAcceptableEntryUnitWidgets().contains(
					widgetClass)) {
				this.inferEntryUnit(panel);
			}

		}
	}

	private void inferDataUnit(Panel panel) {

		Widget firstWidget = panel.getWidgets().get(0);
		String widgetClass = firstWidget.getClass().getName();
		Boolean homogeneousChildren = true;

		for (Widget widget : panel.getWidgets()) {

			String actualWidgetClass = widget.getClass().getName();
			Boolean sameClassName = (widgetClass == actualWidgetClass);
			homogeneousChildren = (homogeneousChildren && sameClassName);

			if (!homogeneousChildren)
				break;
		}

		if (homogeneousChildren) {
			System.out.println();
			System.out.println(panel.getName()
					+ " [Panel] Será inferido a - DataUnit -");
			for (Widget widget : panel.getWidgets()) {
				System.out.println(" " + widget.getName() + ": ["
						+ widget.getClass().getName() + "]");
			}

			String name = panel.getName();
			WRDataUnit dau = this.getWebModel().addDataUnitToPage(page, name,
					name);
		}
	}

	private void inferEntryUnit(Panel panel) {

		Boolean acceptableStatus = true;

		// iterate through the entities
		Iterator<Widget> itr = panel.getWidgets().iterator();

		while (itr.hasNext()) {
			Widget widget = itr.next();

			String actualWidgetClass = widget.getClass().getName();

			Boolean acceptableWidget = this.getAcceptableEntryUnitWidgets()
					.contains(actualWidgetClass);

			acceptableStatus = acceptableStatus && acceptableWidget;

			if (!acceptableStatus)
				break;
		}

		if (acceptableStatus) {
			System.out.println();
			System.out.println(panel.getName()
					+ " [Panel] Será inferido a - EntryUnit -");

			String name = panel.getName();
			WREntryUnit enu = this.getWebModel().addEntryUnitToPage(page, name);

			// iterate through the entities
			itr = panel.getWidgets().iterator();

			WRWebModelEntryUnitVisitor visitor = new WRWebModelEntryUnitVisitor(
					enu);
			while (itr.hasNext()) {
				itr.next().accept(visitor);
			}
		}
	}

}
