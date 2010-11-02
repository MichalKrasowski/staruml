package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;


/**
 * Workaround for #214160 and #209802 -- in some cases SWT fails to paint Images correctly. 
 * Until its fixed, we are going to show draw2d polyline based decorations instead of image-based 
 */
public class ManuallyDrawnShortcutDecorator extends AbstractDecorator {
	
	public ManuallyDrawnShortcutDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	public void activate() {
		refresh();
	}

	public void refresh() {
		removeDecoration();
		EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
		if (editPart instanceof ShapeEditPart) {
			setDecoration(getDecoratorTarget().addShapeDecoration(new ManuallyDrawnShortcutDecorationFigure(), IDecoratorTarget.Direction.SOUTH_WEST, 0, false));
		} else if (editPart instanceof ConnectionEditPart) {
			setDecoration(getDecoratorTarget().addConnectionDecoration(new ManuallyDrawnShortcutDecorationFigure(), 50, false));
		}
	}

}
