package org.webspectlanguage.webspec2wr.factory.webmodel.units.operation;

import org.webspectlanguage.webspec2wr.factory.webmodel.units.WRUnit;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */

public class WROperationUnit extends WRUnit {
	private String id;
	private String name;
	
	public WROperationUnit(String id, String name) {
		this.setId(id);
		this.setName(name);
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

}
