package org.eclipse.uml2.diagram.clazz.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;


public class TemplateLocator implements IBorderItemLocator {
	private final IFigure myParentFigure;

	public TemplateLocator(IFigure parentFigure){
		myParentFigure = parentFigure;
	}

	public int getCurrentSideOfParent() {
		return PositionConstants.NORTH_EAST;
	}

	public void relocate(IFigure target) {
		Rectangle validLocation = getValidLocation(null, target);
		target.setLocation(validLocation.getTopLeft());
		target.setSize(validLocation.getSize());
	}

	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle parentBorder = getParentBorderUnsafe();
		
		Dimension validSize = parentBorder.getSize(); //new instance
		validSize.scale(0.8, 0.5);
		validSize.intersect(borderItem.getPreferredSize());
		
		Rectangle result = new Rectangle(parentBorder.getTopRight(), validSize);
		result.translate(- validSize.width / 2, - validSize.height / 2);
		
		return result;
	}

	public void setConstraint(Rectangle constraint) {
		//nothing to do		
	}

	private Rectangle getParentBorderUnsafe() {
		return myParentFigure instanceof NodeFigure ? 
				((NodeFigure)myParentFigure).getHandleBounds() : myParentFigure.getBounds();  
	}
	
}
