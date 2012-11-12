/**
 *
 */
package org.webspectlanguage.webspec2wr.factory.webmodel.units.operation;

import org.webspectlanguage.webspec2wr.factory.WRWebModelFactory;
import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRKOLink;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WROKLink;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRCreateUnit extends WROperationUnit {
	private WREntity entity;
	private WROKLink okLink;
	private WRKOLink koLink;
	
	/*
	 * Constructor
	 */
	public WRCreateUnit(String id, String name, WREntity entity, String targetId) {
		super(id, name);
		this.setEntity(entity);
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
	
	public WROKLink getOkLink() {
		return okLink;
	}

	public void setOkLink(WROKLink okLink) {
		this.okLink = okLink;
	}

	public WRKOLink getKoLink() {
		return koLink;
	}

	public void setKoLink(WRKOLink koLink) {
		this.koLink = koLink;
	}

}
