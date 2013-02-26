package org.webspectlanguage.webspec2wr.factory.webmodel.containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.WRWebModelFactory;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRLink;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.WRUnit;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRContentUnit;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRPage implements Page{
	private String id;
	private String name;
	
	private WRWebModelFactory webModel;
	private List<WRContentUnit> contentUnits = new ArrayList<WRContentUnit>();
	private List<WRLink> navigations = new ArrayList<WRLink>();


	/*
	 * Constructor
	 */
	public WRPage(String name) {
		this.webModel = null;
		this.name = name;
	}

	public WRPage(WRWebModelFactory webFactory, String name) {
		this.webModel = webFactory;
		this.name = name;
	}
	
	public WRPage(WRWebModelFactory webFactory, String name, String id) {
		this.webModel = webFactory;
		this.id = id;
		this.name = name;
	}

	
	/*
	 * Getter & Setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String identifier) {
		this.id = identifier;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public WRWebModelFactory getModel() {
		return webModel;
	}

	public void setModel(WRWebModelFactory model) {
		this.webModel = model;
	}

	public List<WRContentUnit> getContentUnits() {
		return contentUnits;
	}

	public void setUnits(List<WRContentUnit> units) {
		this.contentUnits = units;
	}

	public List<WRLink> getNavigations() {
		return navigations;
	}

	public void setNavigations(List<WRLink> navigations) {
		this.navigations = navigations;
	}


	/*
	 * Domain specific methods
	 */
	public void addContentUnit(WRContentUnit unit) {
		this.getContentUnits().add(unit);
	}

	public void addNavigation(WRLink linkTo) {
		this.getNavigations().add(linkTo);
	}


	/*
	 * Debugger
	 */
	public void showOnConsole() {

		System.out.println("[P: " + this.getName() + "]");

		// iterate through the widgets
		Iterator<WRContentUnit> itrWidgets = this.getContentUnits().iterator();

		while (itrWidgets.hasNext()) {
			WRUnit widget = itrWidgets.next();

			//System.out.println("  " + widget.getName() + ": "
			//		+ widget.getType());
		}

		// iterate through the navigations
		Iterator<WRLink> itrNav = this.getNavigations().iterator();

		while (itrNav.hasNext()) {
			WRLink navigation = itrNav.next();

			//System.out.println("  -> " + navigation.getTo().getName());
		}

		System.out.println();
	}

}
