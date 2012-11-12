package org.webspectlanguage.webspec2wr.factory.datamodel;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public interface Entity {

	public String getName();

	public void setName(String name);

	public void addAttribute(String name, String type);

	public void showOnConsole();

}
