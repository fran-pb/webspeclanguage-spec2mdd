package org.webspectlanguage.webspec2wr.factory.webmodel.visitor;

import org.webspeclanguage.api.utils.WidgetVisitor;
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
import org.webspectlanguage.webspec2wr.factory.WRWebModelFactory;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WREntryUnit;

public class WRWebModelEntryUnitVisitor implements WidgetVisitor {
	
	private WRDataModelFactory dataModel;
	private WRWebModelFactory webModel;
	private WREntryUnit enu;

	public WRWebModelEntryUnitVisitor(WREntryUnit entryUnit) {
		this.dataModel = WRDataModelFactory.getInstance();
		this.webModel = WRWebModelFactory.getInstance();
		this.enu = entryUnit;
	}

	@Override
	public void visit(TextField textField) {
		System.out.println(" " + textField.getName()+": ["+textField.getClass().getName()+"]");
		
		String name = textField.getName();
		this.webModel.createFieldInEntryUnit(enu, name, "string", "true");
	}

	@Override
	public void visit(Button button) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CheckBox checkBox) {
		System.out.println(" " + checkBox.getName()+": ["+checkBox.getClass().getName()+"]");

		String name = checkBox.getName();
		this.webModel.createFieldInEntryUnit(enu, name, "boolean", "true");
	}

	@Override
	public void visit(ComboBox comboBox) {
		String name = comboBox.getName();
		this.webModel.createSelectionFieldInEntryUnit(enu, name, "string");
	}

	@Override
	public void visit(Link link) { return; }

	@Override
	public void visit(ListBox listBox) { return; }

	@Override
	public void visit(ListOfContainer listOfContainer) { return; }

	@Override
	public void visit(RadioButton radioButton) {
		System.out.println(" " + radioButton.getName()+": ["+radioButton.getClass().getName()+"]");

		String name = radioButton.getName();
	}

	@Override
	public void visit(Label label) { return; }

	@Override
	public void visit(Panel panel) { return; }

}
