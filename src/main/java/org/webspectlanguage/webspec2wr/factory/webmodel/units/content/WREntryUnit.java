package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;

import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRLink;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WREntryUnit extends WRContentUnit {

	private Set<WRField> fields;
	private Set<WRLink> links;

	/*
	 * Constructor
	 */
	public WREntryUnit(String id, String name, WRPage page) {
		super(id, name, page);
	}
	
	/*
	 * Getter & Setters
	 */
	public Set<WRField> getFields() {
		return fields;
	}

	public void setFields(Set<WRField> fields) {
		this.fields = fields;
	}

	public Set<WRLink> getLinks() {
		return links;
	}

	public void setLinks(Set<WRLink> links) {
		this.links = links;
	}

}
