package org.webspectlanguage.webspec2wr.factory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.webspectlanguage.webspec2wr.factory.datamodel.WREntity;
import org.webspectlanguage.webspec2wr.factory.webmodel.containers.Page;
import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRKOLink;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRLink;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WRLinkParameter;
import org.webspectlanguage.webspec2wr.factory.webmodel.links.WROKLink;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRAbstractField;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRContentUnit;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRDataUnit;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WREntryUnit;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRField;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRIndexUnit;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRMultiMessageUnit;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.content.WRSelectionField;
import org.webspectlanguage.webspec2wr.factory.webmodel.units.operation.WRCreateUnit;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRWebModelFactory extends WebModelFactory {
	private WRDataModelFactory dataModel;
	private Set<WRPage> pages;
	private Integer idPage;
	private Integer idDataUnit;
	private Integer idEntryUnit;
	private Integer idIndexUnit;
	private Integer idMultiMessageUnit;
	private Integer idCreateUnit;
	private Integer idDeleteUnit;
	private Integer idModifyUnit;
	private Integer idLink;
	private Integer idOKLink;
	private Integer idLinkKO;
	private Integer idLinkParameter;
	private Integer idField;
	private Integer idSelectionField;

	/*
	 * Constructor
	 */
	private static WRWebModelFactory INSTANCE = null;
	
	private WRWebModelFactory() {
		this.dataModel = WRDataModelFactory.getInstance();
		this.pages = new HashSet<WRPage>();
		this.idPage = 0;
		this.idDataUnit = 0;
		this.idEntryUnit = 0;
		this.idIndexUnit = 0;
		this.idMultiMessageUnit = 0;
		this.idCreateUnit = 0;
		this.idDeleteUnit = 0;
		this.idModifyUnit = 0;
		this.idLink = 0;
		this.idOKLink = 0;
		this.idLinkKO = 0;
		this.idLinkParameter = 0;
		this.idField = 0;
		this.idSelectionField = 0;
	}
	
	private static void createInstance() {
        if (INSTANCE == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
            synchronized(WRDataModelFactory.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCE == null) { 
                    INSTANCE = new WRWebModelFactory();
                }
            }
        }
    }
	
    public static WRWebModelFactory getInstance() {
        createInstance();
        return INSTANCE;
    }
	
	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}
	
	/*
	 * Debugger
	 */
	public void showOnConsole() {
		System.out.println("+--------------------------------------+");
		System.out.println("|   WebModel                           |");
		System.out.println("+--------------------------------------+");
		System.out.println();

		// iterate through the entities
		Iterator<WRPage> itr = pages.iterator();

		while (itr.hasNext()) {
			WRPage page = itr.next();

			// process an entity
			page.showOnConsole();
		}
	}
	
	public void cleanUpForTesting() {
		this.dataModel.cleanUpForTesting();
		this.pages = new HashSet<WRPage>();
		this.idPage = 0;
		this.idDataUnit = 0;
		this.idEntryUnit = 0;
		this.idIndexUnit = 0;
		this.idMultiMessageUnit = 0;
		this.idCreateUnit = 0;
		this.idDeleteUnit = 0;
		this.idModifyUnit = 0;
		this.idLink = 0;
		this.idOKLink = 0;
		this.idLinkKO = 0;
		this.idLinkParameter = 0;
		this.idField = 0;
		this.idSelectionField = 0;
	}

	/*
	 * Getter & Setters
	 */
	private WRDataModelFactory getDataModel() {
		return dataModel;
	}

	private void setDataModel(WRDataModelFactory dataModel) {
		this.dataModel = dataModel;
	}

	public Set<WRPage> getPages() {
		return pages;
	}

	private Integer getIdPage() {
		return ++idPage;
	}

	private Integer getIdDataUnit() {
		return ++idDataUnit;
	}

	private Integer getIdEntryUnit() {
		return ++idEntryUnit;
	}

	private Integer getIdIndexUnit() {
		return ++idIndexUnit;
	}

	private Integer getIdMultiMessageUnit() {
		return ++idMultiMessageUnit;
	}
	
	private Integer getIdCreateUnit() {
		return ++idCreateUnit;
	}
	
	private Integer getIdDeleteUnit() {
		return ++idDeleteUnit;
	}
	
	private Integer getIdModifyUnit() {
		return ++idModifyUnit;
	}
	
	private Integer getIdLink() {
		return ++idLink;
	}

	private Integer getIdOKLink() {
		return ++idOKLink;
	}

	private Integer getIdKOLink() {
		return ++idLinkKO;
	}

	private Integer getIdLinkParameter() {
		return ++idLinkParameter;
	}
	
	private Integer getIdField() {
		return ++idField;
	}
	
	private Integer getIdSelectionField() {
		return ++idSelectionField;
	}

	/*
	 * Domain specific methods
	 */

	/*
	 * return true if there is a WRPage with the name given, in otherwise false
	 */
	public Boolean existsPageWithName(String name) {
		Iterator<WRPage> itr = this.getPages().iterator();

		while (itr.hasNext()) {
			WRPage page = itr.next();

			if (page.getName().equals(name))
				return true;
		}

		return false;
	}

	/*
	 * return a WRPage with the name given if exists , in otherwise null
	 */
	public WRPage getPageWithName(String name) {
		Iterator<WRPage> itr = this.getPages().iterator();

		while (itr.hasNext()) {
			WRPage page = itr.next();

			if (page.getName().equals(name))
				return page;
		}

		return null;
	}

	@Override
	public WRPage createPage(String name) {

		String id = "Page" + this.getIdPage();
		WRPage page = new WRPage(this, name, id);
		this.addPage(page);

		return page;
	}

	public Boolean addPage(WRPage page) {
		if (!this.getPages().add((WRPage) page))
			System.out.println("Duplicate detected: " + page);
		else
			return false;

		return true;
	}

	public void addContentUnitToPage(WRPage page, WRContentUnit unit) {
		page.addContentUnit(unit);
	}

	/*
	 * Content Unit
	 */
	public WRDataUnit addDataUnitToPage(WRPage page, String name, String entityName) {
		String id = "dau" + this.getIdDataUnit();
		WREntity wrEntity = (WREntity) this.getDataModel().getEntityWithName(
				entityName);
		WRDataUnit dau = new WRDataUnit(id, name, wrEntity, page);

		this.addContentUnitToPage(page, dau);
		
		return dau;
	}

	public WRIndexUnit addIndexUnitToPage(WRPage page, String name, String entityName) {
		String id = "inu" + this.getIdIndexUnit();
		WREntity wrEntity = (WREntity) this.getDataModel().getEntityWithName(
				entityName);
		WRIndexUnit inu = new WRIndexUnit(id, name, wrEntity, page);

		this.addContentUnitToPage(page, inu);
		
		return inu;
	}

	public WREntryUnit addEntryUnitToPage(WRPage page, String name) {
		String id = "enu" + this.getIdEntryUnit();
		WREntryUnit enu = new WREntryUnit(id, name, page);

		this.addContentUnitToPage(page, enu);
		
		return enu;
	}
	
	public void createFieldInEntryUnit(WREntryUnit enu, String name, String type, String modifiable) {
		String id = "fld" + this.getIdField();
		
		WRField field = new WRField(id, name, type, modifiable);
		enu.addField(field);
	}
	
	public void createSelectionFieldInEntryUnit(WREntryUnit enu, String name,
			String type) {
		// TODO Auto-generated method stub
		
		/*
		 * Crear un WRSelectionField
		 */
		String id = "sfld" + this.getIdSelectionField();
		
		WRSelectionField sfield = new WRSelectionField(id, name, type);
		enu.addField(sfield);
	}

	public WRMultiMessageUnit addMultiMessageUnitToPage(WRPage page, String name, String text) {
		String id = "mssu" + this.getIdEntryUnit();
		WRMultiMessageUnit mssu = new WRMultiMessageUnit(id, name, text, page);

		this.addContentUnitToPage(page, mssu);
		
		return mssu;
	}

	/*
	 * Operation Unit
	 */
	public WRCreateUnit addCreateUnit(WREntity entity, WREntryUnit target) {
		// TODO
		String id = "cru" + this.getIdCreateUnit();
		String name = "Create" + entity.getName();
		
		WRCreateUnit cru = new WRCreateUnit(id, name, entity, target.getId());
		
		cru.setOkLink(this.createOKLink(cru.getId(), target.getId()));
		cru.setKoLink(this.createKOLink(cru.getId(), target.getId()));
		
		/*
		 * Creo el link que transportara la informacion desde target hacia la nueva CreationUnit
		 */
		
		WRLink link = this.createLink(target.getId(), cru.getId());
		// iterate through the fields
		Iterator<WRAbstractField> itr = target.getFields().iterator();

		while (itr.hasNext()) {
			WRAbstractField field = itr.next();

			// process a field: create a link parameter for every field in the entry unit
			// Warning : no siempre el target respeta el formado id_entyunit.name_field
			this.addParameterToLink(link, field.getName(), field.getId(), target.getId()+"."+field.getName());
		}
		
		return cru;
	}

	public void addDeleteUnit() {
		// TODO

	}

	public void addModifyUnit() {
		// TODO

	}
	
	public void addSelectorGroupToEntryUnit() {
		// TODO
	}

	/*
	 * Link
	 */
	public void addLink() {
		// TODO

	}
	
	public WRLink createLink(String source, String target) {
		String id = "ln" + this.getIdLink();
		String name = "Link" + id;
		WRLink link = new WRLink(id, name, source, target);

		return link;
	}


	public WROKLink createOKLink(String source, String target) {
		String id = "ol" + this.getIdOKLink();
		String name = "OKLink" + id;
		WROKLink okLink = new WROKLink(id, name, source, target);

		return okLink;
	}

	public WRKOLink createKOLink(String source, String target) {
		String id = "ol" + this.getIdKOLink();
		String name = "OKLink" + id;
		WRKOLink koLink = new WRKOLink(id, name, source, target);

		return koLink;
	}
	
	public void addParameterToLink(WRLink link, String name, String source, String target) {
		String id = "par" + this.getIdLinkParameter();
		
		WRLinkParameter parm = new WRLinkParameter(id, name, source, target);
		link.addParameter(parm);
	}
	
	/*
	 * Override
	 */
	
	@Override
	public Boolean addPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addWidgetToPage(String name, String type, Page page) {
		// TODO Auto-generated method stub
		
	}

}
