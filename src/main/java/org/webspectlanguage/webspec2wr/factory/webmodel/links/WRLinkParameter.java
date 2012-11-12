package org.webspectlanguage.webspec2wr.factory.webmodel.links;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRLinkParameter {

	private String id;
	private String name;
	private String source;
	private String target;

	/*
	 * Constructor
	 */
	public WRLinkParameter(String id, String name, String source, String target) {
		super();

		this.setId(id);
		this.setName(name);
		this.setSource(source);
		this.setTarget(target);
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

}
