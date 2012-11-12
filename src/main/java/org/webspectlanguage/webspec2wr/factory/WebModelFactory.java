package org.webspectlanguage.webspec2wr.factory;

import org.webspectlanguage.webspec2wr.factory.webmodel.containers.Page;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public abstract class WebModelFactory {
	public abstract Boolean existsPageWithName(String name);

	public abstract Page getPageWithName(String name);

	public abstract Page createPage(String name);

	public abstract Boolean addPage(Page page);

	public abstract void addWidgetToPage(String name, String type, Page page);

	public abstract void showOnConsole();
}
