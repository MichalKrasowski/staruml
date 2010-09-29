package org.eclipse.uml2.diagram.sequence.draw2d.layouts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Children constraints are their absolute bounds.
 * 
 * @author dstadnik
 */
public class AbsoluteXYLayout extends XYLayout {

	public Point getOrigin(IFigure parent) {
		return new Point(0, 0);
	}

	public Dimension getPreferredSize(IFigure container, int wHint, int hHint) {
		return calculatePreferredSize(container, wHint, hHint);
	}

	/**
	 * Overridden to deal correctly with children that have
	 * negative coordinates.
	 */
	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		Point location = container.getClientArea().getLocation();
		Rectangle rect = new Rectangle();
		rect.setLocation(location);
		List<?> children = container.getChildren();
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			Rectangle constraint = (Rectangle) constraints.get(child);
			if (constraint == null) {
				continue;
			}

			// shift constraint so it won't overlap the top-left corner
			if (constraint.x < location.x) {
				constraint = constraint.getCopy();
				constraint.x = location.x;
			}
			if (constraint.y < location.y) {
				constraint = constraint.getCopy();
				constraint.y = location.y;
			}

			// set preferred size if not specified
			if (constraint.width == -1 || constraint.height == -1) {
				Dimension childPreferredSize = child.getPreferredSize(
						constraint.width, constraint.height);
				constraint = constraint.getCopy();
				if (constraint.width == -1) {
					constraint.width = childPreferredSize.width;
				}
				if (constraint.height == -1) {
					constraint.height = childPreferredSize.height;
				}
			}

			rect.union(constraint);
		}
		Dimension d = rect.getSize();
		Insets insets = container.getInsets();
		d.width += insets.getWidth();
		d.height += insets.getHeight();
		return d.union(getBorderPreferredSize(container));
	}
}