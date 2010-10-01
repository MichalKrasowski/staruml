package org.eclipse.uml2.diagram.clazz.edit.parts;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;


public class DashedHorizontalLineFigure extends Figure {
	@Override
	protected void paintFigure(Graphics graphics) {
		graphics.pushState();
		graphics.setLineStyle(Graphics.LINE_DASH);
		graphics.setLineWidth(5);
		Rectangle rec = getBounds().getCopy();
		graphics.drawLine(rec.getLeft(), rec.getRight());
		graphics.popState();
	}
}
