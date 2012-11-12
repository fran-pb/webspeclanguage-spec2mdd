package org.webspectlanguage.webspec2wr.factory.datamodel;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public abstract interface Relationship {

	public Entity getFrom();

	public void setFrom(Entity from);

	public Entity getTo();

	public void setTo(Entity to);

	public String getCardinalityFrom();

	public void setCardinalityFrom(String cardinalityFrom);

	public String getCardinalityTo();

	public void setCardinalityTo(String cardinalityTo);
}
