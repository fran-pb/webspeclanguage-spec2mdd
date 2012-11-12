package org.webspectlanguage.webspec2wr.factory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.datamodel.Entity;
import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRDataModelFactory extends DataModelFactory {
	
	private Set<WREntity> entities;
	
	/*
	 * Constructor
	 */
	private static WRDataModelFactory INSTANCE = null;
	
	private WRDataModelFactory() {
		entities = new HashSet<WREntity>();
	}
	
	private static void createInstance() {
        if (INSTANCE == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
            synchronized(WRDataModelFactory.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCE == null) { 
                    INSTANCE = new WRDataModelFactory();
                }
            }
        }
    }
	
    public static WRDataModelFactory getInstance() {
        createInstance();
        return INSTANCE;
    }
	
	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}

	/*
	 * Getter & Setters
	 */
	public Set<WREntity> getEntities() {
		return entities;
	}

	public void setEntities(Set<WREntity> entities) {
		this.entities = entities;
	}

	public Boolean addEntity(Entity entity) {
		if (!this.getEntities().add((WREntity) entity))
			System.out.println("Duplicate detected: " + entity);

		return true;
	}

	/*
	 * return true if there is a WREntity with the name given, in otherwise
	 * false
	 */
	public Boolean existsEntityWithName(String name) {
		return (this.getEntityWithName(name) != null ? true : false);
	}

	/*
	 * return a WREntity with the name given
	 */
	public WREntity getEntityWithName(String name) {
		Iterator<WREntity> itr = this.getEntities().iterator();

		while (itr.hasNext()) {
			WREntity entity = itr.next();

			if (entity.getName().equals(name))
				return entity;
		}

		return null;
	}

	public WREntity createEntity(String name) {
		WREntity entity = new WREntity(name);
		this.addAttributeToEntity("oid", "integer", entity);
		this.addEntity(entity);
		return entity;
	}

	/*
	 * Add an attribute to an Entity with name and type given
	 */
	public void addAttributeToEntity(String name, String type, Entity entity) {
		entity.addAttribute(name, type);
	}

	/*
	 * Add a relationship to an Entity with name and type given
	 */
	public void addRelationshipToEntity(WREntity entity, String nameEntityTo,
			String cardinalityFrom, String cardinalityTo) {

		WREntity entityTo = (WREntity) this.getEntityWithName(nameEntityTo);
		if (entityTo == null) {
			entityTo = (WREntity) this.createEntity(nameEntityTo);
		}

		entity.addRelationship(entityTo, cardinalityFrom, cardinalityTo);
	}

	public boolean someEntityHasRelationshipTo(WREntity entityTo) {

		// iterate through the entities
		Iterator<WREntity> itr = this.getEntities().iterator();

		while (itr.hasNext()) {
			WREntity entity = itr.next();

			// process an entity
			if (entity.existsRelationshipTo(entityTo))
				return true;
		}

		return false;
	}

	public boolean entityHasRelationshipTo(String entityFrom, String entityTo) {

		WREntity eFrom = (WREntity) this.getEntityWithName(entityFrom);
		if (eFrom == null)
			return false;
		
		WREntity eTo = (WREntity) this.getEntityWithName(entityTo);
		if (eTo == null)
			return false;

		return eFrom.existsRelationshipTo(eTo);
	}

	/*
	 * Clean unnecessary Entities: empty attribute and relationships entities
	 */
	public void cleanUnnecessaryEntities() {

		// iterate through the entities
		Iterator<WREntity> itr = this.getEntities().iterator();

		// System.out.println("Entidades innecesarias");
		while (itr.hasNext()) {
			WREntity entity = itr.next();

			// process an entity
			if (entity.isUnnecessary()) {
				// System.out.println(entity.getName());
				itr.remove();
			}
		}

	}

	/*
	 * Debugger
	 */

	public void showOnConsole() {
		System.out.println("+--------------------------------------+");
		System.out.println("|   DataModel                          |");
		System.out.println("+--------------------------------------+");
		System.out.println();

		// iterate through the entities
		Iterator<WREntity> itr = this.getEntities().iterator();

		while (itr.hasNext()) {
			WREntity entity = itr.next();

			// process an entity
			entity.showOnConsole();
		}
	}

	public void cleanUpForTesting() {
		Set<WREntity> newEntities = new HashSet<WREntity>();
		this.setEntities(newEntities);
	}

}
