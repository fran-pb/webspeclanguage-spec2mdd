package org.webspectlanguage.webspec2wr.factory.webmodel.links;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRLink {
	private String id;
	private String name;
	private String source;
	private String target;
	private Boolean automaticCoupling;
	private String type;
	private String validate;
	private Set<WRLinkParameter> parameters = new HashSet<WRLinkParameter>();

	/*
	 * Constructor
	 */
	
	public WRLink(String id, String name, String source, String target) {
		super();
		this.id = id;
		this.name = name;
		this.source = source;
		this.target = target;
		
		/*
		this.automaticCoupling = automaticCoupling;
		this.type = type;
		this.validate = validate;
		this.parameters = parameters;
		*/
		
	}

	/*
	 * Getter & Setters
	 */

	/*
	 * Domain specific methods
	 */

	public void addParameter(String name, String source, String target) {
		
		//this.getParameters().add();
	}

}
