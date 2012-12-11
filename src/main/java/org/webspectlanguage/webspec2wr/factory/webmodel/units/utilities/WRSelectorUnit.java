package org.webspectlanguage.webspec2wr.factory.webmodel.units.utilities;

import java.util.HashSet;
import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRLink;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.WRUnit;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */

public class WRSelectorUnit extends WRUnit {
	private String id;
	private String name;
	private WREntity entity;
	private Set<WRLink> links;

	public WRSelectorUnit(String id, String name, WREntity entity) {
		this.setId(id);
		this.setName(name);
		this.setEntity(entity);

		this.links = new HashSet<WRLink>();
	}

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

	public WREntity getEntity() {
		return entity;
	}

	public void setEntity(WREntity entity) {
		this.entity = entity;
	}

	public Set<WRLink> getLinks() {
		return links;
	}

	public void setLinks(Set<WRLink> links) {
		this.links = links;
	}

	public void addLink(WRLink link) {
		this.getLinks().add(link);
	}

}
