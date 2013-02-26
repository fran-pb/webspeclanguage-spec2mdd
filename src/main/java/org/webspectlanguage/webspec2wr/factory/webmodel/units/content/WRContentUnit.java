package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;

import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRLink;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.WRUnit;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */

public class WRContentUnit extends WRUnit {
	private String id;
	private String name;
	private WRPage parent;
	
	
	/*
	 * Constructor
	 */
	public WRContentUnit(String id, String name, WRPage page) {
		this.setId(id);
		this.setName(name);
		this.setParent(page);
	}

	/*
	 * Getter & Setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public WRPage getParent() {
		return parent;
	}

	public void setParent(WRPage page) {
		this.parent = page;
	}
	
	public void addLink() {
		// TODO
	}
}
