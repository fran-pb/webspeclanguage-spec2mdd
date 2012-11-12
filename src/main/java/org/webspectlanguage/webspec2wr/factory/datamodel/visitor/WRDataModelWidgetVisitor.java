package org.webspectlanguage.webspec2wr.factory.datamodel.visitor;

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
import java.util.Iterator;

import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;
import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRDataModelWidgetVisitor implements
		org.webspeclanguage.api.utils.WidgetVisitor {

	private WRDataModelFactory dataModel;

	/*
	 * Constructs
	 */
	public WRDataModelWidgetVisitor() {
		this.dataModel = WRDataModelFactory.getInstance();
	}

	/*
	 * Setters and Getters
	 */
	public WRDataModelFactory getDataModel() {
		return this.dataModel;
	}

	public void setDataModel(WRDataModelFactory model) {
		this.dataModel = model;
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
		String name = panel.getName();
		WREntity entity;

		if (((WRDataModelFactory) this.getDataModel())
				.existsEntityWithName(name)) {
			entity = (WREntity) ((WRDataModelFactory) this.getDataModel())
					.getEntityWithName(name);
		} else {
			entity = (WREntity) ((WRDataModelFactory) this.getDataModel())
					.createEntity(name);
		}

		// iterate through the entities
		Iterator<Widget> itr = panel.getWidgets().iterator();

		WRDataModelPanelVisitor visitor = new WRDataModelPanelVisitor(entity);
		while (itr.hasNext()) {
			itr.next().accept(visitor);
		}
	}

}
