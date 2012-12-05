package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;

import java.util.HashSet;
import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRLink;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WREntryUnit extends WRContentUnit {

	private Set<WRAbstractField> fields;
	private Set<WRLink> links;

	/*
	 * Constructor
	 */
	public WREntryUnit(String id, String name, WRPage page) {
		super(id, name, page);
		this.fields = new HashSet<WRAbstractField>();
		this.links = new HashSet<WRLink>();
	}
	
	/*
	 * Getter & Setters
	 */
	public Set<WRAbstractField> getFields() {
		return fields;
	}

	public void setFields(Set<WRAbstractField> fields) {
		this.fields = fields;
	}

	public Set<WRLink> getLinks() {
		return links;
	}

	public void setLinks(Set<WRLink> links) {
		this.links = links;
	}

	public void addField(WRAbstractField field) {
		this.getFields().add(field);
	}

}
