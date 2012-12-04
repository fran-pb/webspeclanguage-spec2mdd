package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;


/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */

public class WRField extends WRAbstractField {
	
	private String modifiable;
	
	/*
	 * Constructor
	 */
	public WRField(String id, String name, String type, String modifiable) {
		super(id, name, type);
		this.modifiable = modifiable;
	}

	public String getModifiable() {
		return modifiable;
	}

	public void setModifiable(String modifiable) {
		this.modifiable = modifiable;
	}
	
}
