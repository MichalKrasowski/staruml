package org.eclipse.uml2.diagram.sequence.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.uml2.diagram.sequence.draw2d.layouts.AbsoluteXYLayout;


/**
 * Used specifically to host child figures.
 * 
 * Normally it is invisible, but it is possible
 * to turn on debug mode when children container
 * becomes visible so every client that use this
 * figure as a children container will have it
 * highlighted.
 * 
 * @author dstadnik
 */
public class ChildrenContainerFigure extends Layer {
    public ChildrenContainerFigure() {
        setOpaque(true);//Make containsPoint(...) and findFigureAt(...) take this Figure into account. 
    }
	/**
	 * Do not use outside of the class.
	 * In the future may be configurable.
	 */
	private static final boolean DEBUG = false;

	public void paint(Graphics graphics) {
		super.paint(graphics);
		if (!DEBUG) {
			return;
		}
		graphics.setForegroundColor(ColorConstants.cyan);
		graphics.setLineStyle(SWT.LINE_DOT);
		graphics.setLineWidth(1);
		Rectangle b = getClientArea();
		graphics.drawRectangle(b.x, b.y, b.width - 1, b.height - 1);
	}

	protected void primTranslate(int dx, int dy) {
		if (!myTranslateChildren) {
			bounds.x += dx;
			bounds.y += dy;
			return;
		}
		super.primTranslate(dx, dy);

		// we have to tweak children constraints since they are
		// absolute coordinates; this issue should be addressed
		// in a more general way
		LayoutManager layout = getLayoutManager();
		if (layout instanceof AbsoluteXYLayout) {
			List<?> children = getChildren();
			for (int i = 0; i < children.size(); i++) {
				IFigure child = (IFigure) children.get(i);
				Rectangle constraint = (Rectangle) layout.getConstraint(child);
				if (constraint == null) {
					continue;
				}
				constraint.translate(dx, dy);
			}
		}
	}

	protected void paintFigure(Graphics graphics) {}

	public void setTranslateChildren(boolean translate) {
		myTranslateChildren = translate;
	}

	private boolean myTranslateChildren = true;
}