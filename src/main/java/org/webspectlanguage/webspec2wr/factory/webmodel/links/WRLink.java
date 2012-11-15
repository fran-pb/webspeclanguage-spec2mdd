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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Boolean getAutomaticCoupling() {
		return automaticCoupling;
	}

	public void setAutomaticCoupling(Boolean automaticCoupling) {
		this.automaticCoupling = automaticCoupling;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public Set<WRLinkParameter> getParameters() {
		return parameters;
	}

	public void setParameters(Set<WRLinkParameter> parameters) {
		this.parameters = parameters;
	}
	
	/*
	 * Domain specific methods
	 */

	public void addParameter(WRLinkParameter parameter) {
		
		this.getParameters().add(parameter);
	}

}
