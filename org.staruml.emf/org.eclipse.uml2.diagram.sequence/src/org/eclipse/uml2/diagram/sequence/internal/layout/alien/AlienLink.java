package org.eclipse.uml2.diagram.sequence.internal.layout.alien;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmAlienElement;


/**
 * 
 */
class AlienLink implements LmAlienElement {
	AlienLink(AbsLink gdeLink) {
		myGdeLink = gdeLink;
	}

	public void dispose() {
	}
	AbsLink getGdeLink() {
		return myGdeLink;
	}
	
	private final AbsLink myGdeLink;
}
