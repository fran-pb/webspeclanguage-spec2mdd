package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;

import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;
import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */

public class WRIndexUnit extends WRContentUnit {

	private WREntity entity;

	// TODO display attributes? Lista de atributos a mostrar basada en spec o
	// por defecto muestro todos los atributos?

	/*
	 * Constructor
	 */
	public WRIndexUnit(String id, String name, WREntity entity, WRPage page) {
		super(id, name, page);
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

}
