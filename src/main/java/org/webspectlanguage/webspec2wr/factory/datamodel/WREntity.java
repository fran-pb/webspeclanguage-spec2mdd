package org.webspectlanguage.webspec2wr.factory.datamodel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.WRDataModelFactory;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WREntity implements Entity {
	private String name;
	private Set<WRAttribute> attributes = new HashSet<WRAttribute>();
	private Set<WRRelationship> relationships = new HashSet<WRRelationship>();
	private WRDataModelFactory dataModel;

	/*
	 * Constructor
	 */
	/*
	public WREntity(String name, WRDataModelFactory dm) {
		this.dataModel = dm;
		this.name = name;
	}
	*/
	
	public WREntity(String name) {
		this.dataModel = WRDataModelFactory.getInstance();
		this.name = name;
	}
	
	/*
	 * hashCode & equal
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		/*
		result = prime * result
				+ ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result
				+ ((dataModel == null) ? 0 : dataModel.hashCode());
		result = prime * result
				+ ((relationships == null) ? 0 : relationships.hashCode());
		*/
		
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof WREntity))
			return false;
		WREntity other = (WREntity) obj;
		
		/*
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (dataModel == null) {
			if (other.dataModel != null)
				return false;
		} else if (!dataModel.equals(other.dataModel))
			return false;
		if (relationships == null) {
			if (other.relationships != null)
				return false;
		} else if (!relationships.equals(other.relationships))
			return false;
		*/
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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

	public Set<WRAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<WRAttribute> attributes) {
		this.attributes = attributes;
	}

	public Set<WRRelationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(Set<WRRelationship> relationships) {
		this.relationships = relationships;
	}

	public WRDataModelFactory getModel() {
		return dataModel;
	}

	public void setModel(WRDataModelFactory model) {
		this.dataModel = model;
	}

	/*
	 * Domain specific methods
	 */

	public void addAttribute(String name, String type) {
		WRAttribute attr = new WRAttribute(name, type);
		this.getAttributes().add(attr);
	}

	public void addRelationship(WREntity entityTo, String cardinalityFrom,
			String cardinalityTo) {
		
		WRRelationship relation = new WRRelationship(this, entityTo, cardinalityFrom, cardinalityTo);
		this.addRelationship(relation);
	}
	
	public void addRelationship(WRRelationship relation) {

		this.getRelationships().add(relation);
	}

	/*
	 * return true if there is a WRRelationship with the entity given as
	 * destination To, in otherwise false
	 */
	public boolean existsRelationshipTo(WREntity entityTo) {
		Iterator<WRRelationship> itr = this.getRelationships().iterator();

		while (itr.hasNext()) {
			WRRelationship relation = itr.next();

			if (relation.getTo().getName().equals(entityTo.getName()))
				return true;
		}

		return false;
	}

	public boolean hasAttributes() {
		return (this.getAttributes().size() > 1);
	}

	public boolean hasRelationships() {
		return ((this.getRelationships().size() > 0) || this.dataModel
				.someEntityHasRelationshipTo(this));
	}

	public boolean isUnnecessary() {
		return ((this.hasAttributes() || this.hasRelationships()) ? false
				: true);
	}

	/*
	 * Debugger
	 */

	public void showOnConsole() {

		System.out.println("[E: " + this.getName() + "]");

		// iterate through the attributes
		Iterator<WRAttribute> itrAttr = this.getAttributes().iterator();

		while (itrAttr.hasNext()) {
			WRAttribute attr = itrAttr.next();

			System.out.println("  " + attr.getName() + ": " + attr.getType());
		}

		// iterate through the relationships
		Iterator<WRRelationship> itrRel = this.getRelationships().iterator();

		while (itrRel.hasNext()) {
			WRRelationship relation = itrRel.next();

			System.out.println("  -> " + relation.getTo().getName() + ": "
					+ relation.getCardinalityFrom() + " to "
					+ relation.getCardinalityTo());
		}

		System.out.println();
	}
}
