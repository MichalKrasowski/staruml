package org.eclipse.uml2.diagram.common.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * This editpart has primary shape decorated by the DefaultSizeNodeFigure or other GMF-runtime figures. 
 * Most of the generated node' editparts are PrimaryShapeEditPart's.
 */
public interface PrimaryShapeEditPart extends IGraphicalEditPart {
	public IFigure getPrimaryShape();
}
