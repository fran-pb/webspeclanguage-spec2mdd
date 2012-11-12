package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;


/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */

public class WRField {
	
	private String id;
	private String name;
	private String type;
	private String modifiable;
	
	/*
	 * Constructor
	 */
	public WRField(String id, String name, String type, String modifiable) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.modifiable = modifiable;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModifiable() {
		return modifiable;
	}

	public void setModifiable(String modifiable) {
		this.modifiable = modifiable;
	}
	
}
