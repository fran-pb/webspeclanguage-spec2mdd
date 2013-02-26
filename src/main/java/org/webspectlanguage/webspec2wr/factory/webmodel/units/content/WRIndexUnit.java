package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;
import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */

public class WRIndexUnit extends WRContentUnit {

	private WREntity entity;
	private List<String> displayAttributes;

	/*
	 * Constructor
	 */
	public WRIndexUnit(String id, String name, WREntity entity, WRPage page) {
		super(id, name, page);
		this.setEntity(entity);
		this.displayAttributes = new ArrayList<String>();
	}

	/*
	 * Getter & Setters
	 */
	public WREntity getEntity() {
		return entity;
	}

	public void setEntity(WREntity entity) {
		this.entity = entity;
	}
	
	public List<String> getDisplayAttributes() {
		return displayAttributes;
	}

	public void setDisplayAttributes(List<String> diplayAttributes) {
		this.displayAttributes = diplayAttributes;
	}

	public void addDisplayAttribute(String attribute) {
		this.getDisplayAttributes().add(attribute);
	}

}
