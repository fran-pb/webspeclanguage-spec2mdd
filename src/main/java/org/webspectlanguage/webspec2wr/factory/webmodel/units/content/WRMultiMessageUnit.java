package org.webspectlanguage.webspec2wr.factory.webmodel.units.content;

import org.webspectlanguage.webspec2wr.factory.webmodel.containers.WRPage;

/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class WRMultiMessageUnit extends WRContentUnit {

	private String text;

	/*
	 * Constructor
	 */
	public WRMultiMessageUnit(String id, String name, String text, WRPage page) {
		super(id, name, page);

		this.setText(text);
	}

	/*
	 * Getter & Setters
	 */
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
