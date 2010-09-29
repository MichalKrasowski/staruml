package org.eclipse.uml2.diagram.sequence.frame;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.uml2.diagram.common.editparts.NeedsParentEditPart;
import org.eclipse.uml2.diagram.common.layered.MultilayeredFigure;
import org.eclipse.uml2.diagram.common.layered.MultilayeredSupport;
import org.eclipse.uml2.diagram.common.layered.MultilayeredSupportImpl;
import org.eclipse.uml2.diagram.sequence.draw2d.shadow.ShadowStealth;


public class Frame extends RectangleFigure implements MultilayeredFigure, ShadowStealth, NeedsParentEditPart {
    private final MultilayeredSupportImpl myMultilayeredSupport;
    private static final int HOLE_INSETS = 5;

    public Frame() {
        setOpaque(false);
        setFill(false);
        myMultilayeredSupport = new MultilayeredSupportImpl();
    }
    
    public MultilayeredSupport getMultilayeredSupport() {
        return getMultilayeredSupportImpl();
    }
    
    protected MultilayeredSupportImpl getMultilayeredSupportImpl() {
        return myMultilayeredSupport;
    }
    
    public void hookParentEditPart(GraphicalEditPart parentEditPart) {
    	myMultilayeredSupport.setParentFromParentEditPart(parentEditPart);
    }
    
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        if (!getBounds().contains(x, y)) {
            return null;
        }
        if (search.prune(this)) {
            return null;
        }
        IFigure child = findDescendantAtExcluding(x, y, search);
        if (child != null) {
            return child;
        }
        if (search.accept(this) && !isInHole(x, y)) {
            return this;
        }
        return null;
    }
    
    protected boolean isInHole(int x, int y) {
        Rectangle bounds = getBounds();
        int topLeftX = bounds.x+HOLE_INSETS;
        int topLeftY = bounds.y+HOLE_INSETS;
        int bottomRightX = bounds.x + bounds.width - HOLE_INSETS;
        int bottomRightY = bounds.y + bounds.height - HOLE_INSETS;
        return x >= topLeftX
            && y >= topLeftY
            && x < bottomRightX
            && y < bottomRightY;
    }
    
}
