package org.eclipse.uml2.diagram.sequence.draw2d;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.uml2.diagram.common.draw2d.BisectionBorderItemLocator;

public class GateLocator extends BisectionBorderItemLocator {

	public GateLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	public GateLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	public GateLocator(IFigure parentFigure) {
		super(parentFigure);
	}
	
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		int side = findClosestVerticalSideOfParent(proposedLocation, getParentBorder());
		return getBisectionLocation(super.getValidLocation(proposedLocation, borderItem), side);
	}

	public static int findClosestVerticalSideOfParent(Rectangle proposedLocation, Rectangle parentBorder) {
		Point parentCenter = parentBorder.getCenter();
		Point childCenter = proposedLocation.getCenter();
		if (childCenter.x < parentCenter.x) 
		{
			/*
			if (childCenter.y < parentCenter.y) // west or north
			{
				// closer to west or north?
				Point parentTopLeft = parentBorder.getTopLeft();
				if ((childCenter.x - parentTopLeft.x) <= (childCenter.y - parentTopLeft.y)) {
					return PositionConstants.WEST;
				} else {
					return PositionConstants.NORTH;
				}
			} else { // west or south
				Point parentBottomLeft = parentBorder.getBottomLeft();
				if ((childCenter.x - parentBottomLeft.x) <= (parentBottomLeft.y - childCenter.y)) {
					return PositionConstants.WEST;
				} else {
					return PositionConstants.SOUTH;
				}
			}
			*/
			return PositionConstants.WEST;
		} else { // EAST, NORTH or SOUTH
			/*
			if (childCenter.y < parentCenter.y) // north or east
			{
				Point parentTopRight = parentBorder.getTopRight();
				if ((parentTopRight.x - childCenter.x) <= (childCenter.y - parentTopRight.y)) {
					return PositionConstants.EAST;
				} else {
					return PositionConstants.NORTH;
				}
			} else { // south or east.
				Point parentBottomRight = parentBorder.getBottomRight();
				if ((parentBottomRight.x - childCenter.x) <= (parentBottomRight.y - childCenter.y)) {
					return PositionConstants.EAST;
				} else {
					return PositionConstants.SOUTH;
				}
			}
			*/
			return PositionConstants.SOUTH;
		}
	}

}
