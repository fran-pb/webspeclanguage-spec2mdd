package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;

public class WRAbstractField {

	protected String id;
	protected String name;
	protected String type;

	public WRAbstractField() {
		super();
	}
	
	public WRAbstractField(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}