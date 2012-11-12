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
import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;
import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRDataModelListOfContainerVisitor implements
		org.webspeclanguage.api.utils.WidgetVisitor {

	private WREntity entity;
	private String entityTo;
	private WRDataModelFactory dataModel;

	public WRDataModelListOfContainerVisitor(WREntity aEntity,
			String aEntityTo) {
		this.entity = aEntity;
		this.entityTo = aEntityTo;
		this.dataModel = WRDataModelFactory.getInstance();
	}

	@Override
	public void visit(TextField textField) {
		this.dataModel.addRelationshipToEntity(entity, entityTo, "many", "one");
	}

	@Override
	public void visit(Button button) {

	}

	@Override
	public void visit(CheckBox checkBox) {
		this.dataModel.addRelationshipToEntity(entity, entityTo, "many", "many");
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
		this.dataModel.addRelationshipToEntity(entity, entityTo, "many", "many");
	}

	@Override
	public void visit(Label label) {

	}

	@Override
	public void visit(Panel panel) {

	}

}
