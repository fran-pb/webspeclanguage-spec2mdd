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
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRIndexUnit;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRWebModelIndexUnitVisitor implements WidgetVisitor {

	private WRDataModelFactory dataModel;
	private WRWebModelFactory webModel;
	private WRIndexUnit inu;
	
	/*
	 * Constructs
	 */

	public WRWebModelIndexUnitVisitor(WRIndexUnit indexUnit) {
		this.dataModel = WRDataModelFactory.getInstance();
		this.webModel = WRWebModelFactory.getInstance();
		this.inu = indexUnit;
	}

	/*
	 * Setters and Getters
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

	public WRIndexUnit getInu() {
		return inu;
	}

	public void setInu(WRIndexUnit inu) {
		this.inu = inu;
	}

	/*
	 * Visitor Override
	 */

	@Override
	public void visit(TextField textField) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Button button) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CheckBox checkBox) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ComboBox comboBox) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Link link) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ListBox listBox) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ListOfContainer listOfContainer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(RadioButton radioButton) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Label label) {
		System.out.println(" " + label.getName() + ": ["
				+ label.getClass().getName() + "]");

		String name = label.getName();
		this.getInu().addDisplayAttribute(name);
	}

	@Override
	public void visit(Panel panel) {
		// TODO Auto-generated method stub

	}

}
