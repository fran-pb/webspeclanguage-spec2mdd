package org.webspectlanguage.webspec2wr.factory.datamodel;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRRelationship implements Relationship {
	
	private WREntity from;
	private WREntity to;
	private String cardinalityFrom;
	private String cardinalityTo;
	
	public WRRelationship(WREntity eFrom, WREntity eTo, String cardFrom, String cardTo) {
		this.from = eFrom;
		this.to = eTo;
		this.cardinalityFrom = cardFrom;
		this.cardinalityTo = cardTo;
	}
	
	/*
	 * hashCode & equal
	 */	
	
	@Override
	public int hashCode() {
		// TODO review... mal funcionamiento
		
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardinalityFrom == null) ? 0 : cardinalityFrom.hashCode());
		result = prime * result
				+ ((cardinalityTo == null) ? 0 : cardinalityTo.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof WRRelationship))
			return false;
		WRRelationship other = (WRRelationship) obj;
		if (cardinalityFrom == null) {
			if (other.cardinalityFrom != null)
				return false;
		} else if (!cardinalityFrom.equals(other.cardinalityFrom))
			return false;
		if (cardinalityTo == null) {
			if (other.cardinalityTo != null)
				return false;
		} else if (!cardinalityTo.equals(other.cardinalityTo))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	
	/*
	 * Getter & Setters
	 */	

	public WREntity getFrom() {
		return from;
	}

	public void setFrom(Entity from) {
		this.from = (WREntity) from;
	}

	public WREntity getTo() {
		return to;
	}

	public void setTo(Entity to) {
		this.to = (WREntity) to;
	}

	public String getCardinalityFrom() {
		return cardinalityFrom;
	}

	public void setCardinalityFrom(String cardinalityFrom) {
		this.cardinalityFrom = cardinalityFrom;
	}

	public String getCardinalityTo() {
		return cardinalityTo;
	}

	public void setCardinalityTo(String cardinalityTo) {
		this.cardinalityTo = cardinalityTo;
	}

}
