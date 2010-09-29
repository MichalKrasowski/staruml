package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;

/**
 * 
 */
public interface LmAlienElement {

	void dispose();
	
	interface Factory {
		LmAlienElement createAlienNode(AbsNode gdeNode);
		LmAlienElement createAlienLink(AbsLink gdeLink);
	}
}
