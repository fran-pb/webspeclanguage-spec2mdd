package org.webspectlanguage.webspec2wr;

import org.webspeclanguage.api.Transition;


/**
 * @author Francisco Peña <tkd.inbox@gmail.com>
 */
public class TransitionProcessor {
	private Transition transition;

	public TransitionProcessor() {
		transition = null;
	}

	public TransitionProcessor(Transition aTransition) {
		transition = aTransition;
	}

	public void setTransition(Transition aTransition) {
		transition = aTransition;
	}

	public Transition getTransition() {
		return transition;
	}

	public void process() {
		System.out.println(" --> " + this.getTransition().getTarget());
	}
}
