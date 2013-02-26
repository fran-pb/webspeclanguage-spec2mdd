package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRLink;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WREntryUnit extends WRContentUnit {

	private List<WRAbstractField> fields;
	private List<WRLink> links;

	/*
	 * Constructor
	 */
	public WREntryUnit(String id, String name, WRPage page) {
		super(id, name, page);
		this.fields = new ArrayList<WRAbstractField>();
		this.links = new ArrayList<WRLink>();
	}

	/*
	 * Getter & Setters
	 */
	public List<WRAbstractField> getFields() {
		return fields;
	}

	public void setFields(List<WRAbstractField> fields) {
		this.fields = fields;
	}

	public List<WRLink> getLinks() {
		return links;
	}

	public void setLinks(List<WRLink> links) {
		this.links = links;
	}

	public void addField(WRAbstractField field) {
		this.getFields().add(field);
	}

}
