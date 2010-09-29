package org.eclipse.uml2.diagram.sequence.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class CrossFigure extends Shape {
    CrossFigure(LifelineBracketContainerShape execution) {
        myLocator = new CrossLocator(execution);
        myExecutionFigure = execution;
        setLineWidth(4);
    }
    
    protected void fillShape(Graphics graphics) {
    }

    protected void outlineShape(Graphics graphics) {
        graphics.drawLine(getBounds().getTopLeft().translate(OFFSET, OFFSET), getBounds().getBottomRight().translate(-OFFSET, -OFFSET));
        graphics.drawLine(getBounds().getBottomLeft().translate(OFFSET, -OFFSET), getBounds().getTopRight().translate(-OFFSET, OFFSET));
    }
    
    
    public void validate() {
        if (isValid())
            return;
        myLocator.relocate(this);
        super.validate();
    }
    
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        if (!containsPoint(x, y)) {
            return null;
        }
        if (search.prune(myExecutionFigure)) {
            return null;
        }
        if (! search.accept(myExecutionFigure)) {
            return null;
        }
        return myExecutionFigure;
    }
    
    private final IFigure myExecutionFigure;
    private final Locator myLocator;
    private static final int OFFSET = 3;
    
    private static class CrossLocator implements Locator {
        CrossLocator (LifelineBracketContainerShape bracketContainerShape) {
            myExecution = bracketContainerShape;
        }
        
        public void relocate(IFigure cross) {
            Point center = myExecution.getPaintableArea().getBottom();
            Rectangle newBounds = new Rectangle(center.x, center.y, 0, 0);
            newBounds.expand(10, 10);
            cross.setBounds(newBounds);
            
            LayoutManager layoutManager = cross.getParent().getLayoutManager();
            if (layoutManager instanceof XYLayout) {
            	Point origin = ((XYLayout)layoutManager).getOrigin(cross.getParent());
                ((XYLayout) layoutManager).setConstraint(cross, newBounds.getTranslated(origin.getNegated()));
            } else {
                assert false : "Parent figure is expected to be ChildrenContainerFigure with AbsoluteXYLayout layout"; //$NON-NLS-1$
            }
        }
        
        private final LifelineBracketContainerShape myExecution;
    }
    
}
