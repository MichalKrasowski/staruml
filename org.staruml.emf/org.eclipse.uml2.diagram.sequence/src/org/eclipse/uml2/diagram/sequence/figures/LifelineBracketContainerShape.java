package org.eclipse.uml2.diagram.sequence.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class LifelineBracketContainerShape extends Shape {
    public LifelineBracketContainerShape () {
    	setLineWidthFloat(1.0f);
    	setLayoutManager(new XYLayout());
    }
    
    public void setPaintableWidth(int paintableWidth) {
        myPaintableWidth = paintableWidth;
    }
    
    protected void fillShape(Graphics graphics) {
        graphics.fillRectangle(getPaintableArea());
    }

    protected void outlineShape(Graphics graphics) {
        graphics.drawRectangle(getOutlineRectangle());
    }
    
    protected Rectangle getOutlineRectangle() {
        Rectangle b = getPaintableArea();
        final int lineWidth = getLineWidth();
        final int lineOffset = lineWidth / 2;
        b.x += lineOffset;
        b.y += lineOffset;
        b.width -= lineWidth;
        b.height -= lineWidth;
        return b;
    }
    
    protected Rectangle getPaintableArea() {
        Rectangle bounds = getBounds().getCopy();//XXX: use Rectangle.SINGLETON?
        bounds.width = myPaintableWidth;
        return bounds;
    }
    
    private int myPaintableWidth;
}
