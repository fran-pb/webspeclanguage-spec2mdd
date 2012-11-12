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
import org.webspectlanguage.webspec2wr.factory.WRWebModelFactory;
import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRWebModelWidgetVisitor implements
		org.webspeclanguage.api.utils.WidgetVisitor {

	private WRPage page;
	private WRWebModelFactory webModel;

	/*
	 * Constructs
	 */
	public WRWebModelWidgetVisitor(WRPage aPage) {
		this.page = aPage;
		this.webModel = WRWebModelFactory.getInstance();
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

	}

}
