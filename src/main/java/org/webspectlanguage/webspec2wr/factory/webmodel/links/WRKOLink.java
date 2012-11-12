package org.webspectlanguage.webspec2wr.factory.webmodel.links;


/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRKOLink {
	private String id;
	private String name;
	private String source;
	private String target;
	private Boolean automaticCoupling;

	/*
	 * Constructor
	 */
	public WRKOLink(String id, String name, String source, String target) {
		super();
		this.id = id;
		this.name = name;
		this.source = source;
		this.target = target;
		this.automaticCoupling = true;
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

}
