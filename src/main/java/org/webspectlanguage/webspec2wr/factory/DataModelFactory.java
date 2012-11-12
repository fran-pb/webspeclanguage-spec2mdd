package org.webspectlanguage.webspec2wr.factory;

import org.webspectlanguage.webspec2wr.factory.datamodel.Entity;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public abstract class DataModelFactory {
	public abstract Boolean existsEntityWithName(String name);

	public abstract Entity getEntityWithName(String name);

	public abstract Entity createEntity(String name);

	public abstract Boolean addEntity(Entity entity);

	public abstract void addAttributeToEntity(String name, String type,
			Entity entity);

	public abstract void showOnConsole();
}
