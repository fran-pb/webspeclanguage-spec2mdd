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
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRDataUnit;

public class WRWebModelEntryUnitVisitor implements WidgetVisitor {
	
	private WRDataUnit dau;

	public WRWebModelEntryUnitVisitor(WRDataUnit dau) {
		this.dau = dau;
	}

	@Override
	public void visit(TextField textField) {
		System.out.println(" " + textField.getName()+": ["+textField.getClass().getName()+"]");

	}

	@Override
	public void visit(Button button) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CheckBox checkBox) {
		System.out.println(" " + checkBox.getName()+": ["+checkBox.getClass().getName()+"]");

	}

	@Override
	public void visit(ComboBox comboBox) {
		System.out.println(" " + comboBox.getName()+": ["+comboBox.getClass().getName()+"]");

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

	}

	@Override
	public void visit(Label label) { return; }

	@Override
	public void visit(Panel panel) { return; }

}
