package org.eclipse.uml2.diagram.sequence.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;


public class LifeLineTailShape extends RectangleFigure {
    public LifeLineTailShape() {
        setOpaque(false);
        setFill(false);
        setLineStyle(Graphics.LINE_DASH);
        setMinimumSize(new Dimension());//to avoid head shrinking
    }
    
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        IFigure result = super.findFigureAt(x, y, search);
        if (result == this) {
            int distToLine = Math.abs(getLineAbsoluteX() - x);
            if (distToLine >= getLineWidth() + SELECTABLE_WIDTH) {
                result = null;
            } 
        } 
        return result;
    }

    protected void outlineShape(Graphics graphics) {
        Rectangle bounds = getBounds();
        graphics.drawLine(getLineAbsoluteX(),  bounds.y, getLineAbsoluteX(), bounds.y+bounds.height);
    }
    
    private int getLineAbsoluteX() {
        //return bounds.x + myLineRelativeX;//don't assume that line is always centered, SD layout should set this position 
    	return bounds.x + bounds.width / 2;//don't assume that line is always centered, SD layout should set this position
    }
    
    void setLineRelativeX(int x) {
        myLineRelativeX = x;
    }
    
    private int myLineRelativeX;
    private static final int SELECTABLE_WIDTH = 10;
}
