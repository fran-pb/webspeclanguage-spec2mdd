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
import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;
import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRDataModelPanelVisitor implements
		org.webspeclanguage.api.utils.WidgetVisitor {

	private WREntity entity;
	private WRDataModelFactory dataModel;

	public WRDataModelPanelVisitor(WREntity aEntity) {
		this.entity = aEntity;
		this.dataModel = WRDataModelFactory.getInstance();
	}

	@Override
	public void visit(TextField textField) {
		String type = "String";
		String name = textField.getName();

		this.dataModel.addAttributeToEntity(name, type, entity);
	}

	@Override
	public void visit(Button button) {

	}

	@Override
	public void visit(CheckBox checkBox) {
		String type = "Boolean";
		String name = checkBox.getName();

		this.dataModel.addAttributeToEntity(name, type, entity);
	}

	@Override
	public void visit(ComboBox comboBox) {
		String entityTo = comboBox.getName();

		this.dataModel.addRelationshipToEntity(entity, entityTo, "many", "one");
	}

	@Override
	public void visit(Link link) {

	}

	@Override
	public void visit(ListBox listBox) {

	}

	@Override
	public void visit(ListOfContainer listOfContainer) {

		/*
		 * The rule of inference in this case only makes sense if the container
		 * has at least 2 listOf child widgets and these are homogeneous
		 */

		if (listOfContainer.getWidgets().size() > 1) {

			Boolean homogeneousChildren = true;

			Widget firstWidget = listOfContainer.getWidgets().get(0);
			String widgetClass = firstWidget.getClass().getName();

			for (Widget widget : listOfContainer.getWidgets()) {
				homogeneousChildren = (homogeneousChildren && (widgetClass == widget
						.getClass().getName()));

				if (!homogeneousChildren)
					break;
			}

			if (homogeneousChildren) {
				WRDataModelListOfContainerVisitor visitor = new WRDataModelListOfContainerVisitor(
						this.entity, listOfContainer.getName());

				firstWidget.accept(visitor);
			}

		}

	}

	@Override
	public void visit(RadioButton radioButton) {
		String type = "Boolean";
		String name = radioButton.getName();

		this.dataModel.addAttributeToEntity(name, type, entity);
	}

	@Override
	public void visit(Label label) {
		String type = "Label";
		String name = label.getName();

		this.dataModel.addAttributeToEntity(name, type, entity);
	}

	@Override
	public void visit(Panel panel) {

	}

}
