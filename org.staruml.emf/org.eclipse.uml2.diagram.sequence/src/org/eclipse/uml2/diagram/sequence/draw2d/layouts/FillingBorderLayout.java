package org.eclipse.uml2.diagram.sequence.draw2d.layouts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Stretches central figure to fill all available space.
 * 
 * @author dstadnik
 */
public class FillingBorderLayout extends BorderLayout {

	private IFigure center, left, top, bottom, right;

	private int vGap = 0, hGap = 0;

	//TODO: mind minimum child size for left and right components
	public void layout(IFigure container) {
		Rectangle area = container.getClientArea();
		Rectangle rect = new Rectangle();

		Dimension childSize;
		if (top != null && top.isVisible()) {
			childSize = top.getPreferredSize(area.width, -1);
			rect.setLocation(area.x, area.y);
			rect.height = childSize.height;
			rect.width = area.width;
			top.setBounds(rect);
			area.y += rect.height + vGap;
			area.height -= rect.height + vGap;
		}
		if (bottom != null && bottom.isVisible()) {
			childSize = bottom.getPreferredSize(area.width, -1);
			rect.height = childSize.height;
			rect.width = area.width;
			rect.setLocation(area.x, area.y + area.height - rect.height);
			bottom.setBounds(rect);
			area.height -= rect.height + vGap;
		}
		if (left != null && left.isVisible()) {
			childSize = left.getPreferredSize(-1, Math.max(0, area.height));
			rect.setLocation(area.x, area.y);
			rect.width = childSize.width;
			rect.height = Math.max(0, area.height);
			left.setBounds(rect);
			area.x += rect.width + hGap;
			area.width -= rect.width + hGap;
		}
		if (right != null && right.isVisible()) {
			childSize = right.getPreferredSize(-1, Math.max(0, area.height));
			rect.width = childSize.width;
			rect.height = Math.max(0, area.height);
			rect.setLocation(area.x + area.width - rect.width, area.y);
			right.setBounds(rect);
			area.width -= rect.width + hGap;
		}
		if (center != null && center.isVisible()) {
			/*
			 * [dstadnik] this code is commented
			 * to allow central figure to stretch
			 * 
			childSize = center.getPreferredSize(
			        Math.max(0, area.width),
			        Math.max(0, area.height));
			if (childSize.height < area.height) {
			    area.y += (area.height - childSize.height) / 2;
			    area.height = childSize.height;
			}
			*/
			center.setBounds(area);
		}
	}

	public void remove(IFigure child) {
		super.remove(child);
		if (center == child) {
			center = null;
		} else if (top == child) {
			top = null;
		} else if (bottom == child) {
			bottom = null;
		} else if (right == child) {
			right = null;
		} else if (left == child) {
			left = null;
		}
	}

	public void setConstraint(IFigure child, Object constraint) {
		super.setConstraint(child, constraint);
		if (constraint == null) {
			return;
		}

		switch (((Integer) constraint).intValue()) {
		case PositionConstants.CENTER:
			center = child;
			break;
		case PositionConstants.TOP:
			top = child;
			break;
		case PositionConstants.BOTTOM:
			bottom = child;
			break;
		case PositionConstants.RIGHT:
			right = child;
			break;
		case PositionConstants.LEFT:
			left = child;
			break;
		default:
			break;
		}
	}

	public void setHorizontalSpacing(int gap) {
		super.setHorizontalSpacing(gap);
		hGap = gap;
	}

	public void setVerticalSpacing(int gap) {
		super.setVerticalSpacing(gap);
		vGap = gap;
	}
}