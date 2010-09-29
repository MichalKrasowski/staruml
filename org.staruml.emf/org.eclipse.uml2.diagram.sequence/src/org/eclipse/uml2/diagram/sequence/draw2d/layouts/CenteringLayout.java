package org.eclipse.uml2.diagram.sequence.draw2d.layouts;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Places the first child in the center and shrinks it if necessary
 * to fit inside container bounds. Child bounds are not expanded to
 * match container bounds as it happens in BorderLayout with CENTER
 * hint. Child minimum size is ignored.
 * 
 * If positive scale level specified will always scale child bounds
 * correspondingly.
 * 
 * Designed for containers with exactly one child; other children
 * will be ignored.
 * 
 * @author dstadnik
 */
public class CenteringLayout extends AbstractLayout {

	protected static final int DEFAULT_WIDTH = 50;
	protected static final int DEFAULT_HEIGHT = 50;

	public CenteringLayout() {
	}

	public CenteringLayout(double scaleLevel) {
		setScale(scaleLevel);
	}

	/**
	 * Fixed child scale level. Should be within 0..1 range.
	 * Zero value means that child should not be scaled.
	 */
	public final double getScale() {
		return myScaleLevel;
	}

	public void setScale(double level) {
		if (level < 0 || level > 1) {
			throw new IllegalArgumentException();
		}
		myScaleLevel = level;
	}

	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		List<?> children = container.getChildren();
		if (children.isEmpty()) {
			return new Dimension(wHint < 0 ? DEFAULT_WIDTH : wHint, hHint < 0 ? DEFAULT_HEIGHT : hHint);
		}
		IFigure child = (IFigure) children.get(0);
		Dimension size = child.getPreferredSize(); // do not pass hints!
		if (size == null) {
			size = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		} else {
			size = size.getCopy();
			if (myScaleLevel > 0) {
				size.width /= myScaleLevel;
				size.height /= myScaleLevel;
			}
		}
		if (wHint >= 0) {
			size.width = wHint;
		}
		if (hHint >= 0) {
			size.height = hHint;
		}
		return size;
	}

	public void layout(IFigure container) {
		Rectangle bounds = container.getClientArea();
		List<?> children = container.getChildren();
		if (children.isEmpty()) {
			return;
		}
		IFigure child = (IFigure) children.get(0);
		Dimension size;
		if (myScaleLevel > 0) {
			size = bounds.getSize();
			size.width *= myScaleLevel;
			size.height *= myScaleLevel;
		} else {
			size = child.getPreferredSize(bounds.width, bounds.height);
			if (size == null) {
				size = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			}
			if (size.width > bounds.width) {
				size.width = bounds.width;
			}
			if (size.height > bounds.height) {
				size.height = bounds.height;
			}
		}
		int woff = bounds.x + (bounds.width - size.width) / 2;
		int hoff = bounds.y + (bounds.height - size.height) / 2;
		child.setBounds(new Rectangle(woff, hoff, size.width, size.height));
	}

	private double myScaleLevel;
}