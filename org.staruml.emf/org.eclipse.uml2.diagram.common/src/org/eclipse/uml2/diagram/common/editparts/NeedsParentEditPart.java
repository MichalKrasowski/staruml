package org.eclipse.uml2.diagram.common.editparts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

/**
 * This primary figure editpart requires to be informed about the parent editpart 
 * immediately after creation.
 */
public interface NeedsParentEditPart {
	public void hookParentEditPart(GraphicalEditPart parentEditPart);
}
