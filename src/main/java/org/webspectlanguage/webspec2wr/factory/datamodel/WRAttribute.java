package org.webspectlanguage.webspec2wr.factory.datamodel;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRAttribute {
	private String name;
	private String type;

	public WRAttribute(String n, String t) {
		name = n;
		type = t;
	}
	
	/*
	 * hashCode & equal
	 */	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof WRAttribute))
			return false;
		WRAttribute other = (WRAttribute) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	/*
	 * Getter & Setters
	 */

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
