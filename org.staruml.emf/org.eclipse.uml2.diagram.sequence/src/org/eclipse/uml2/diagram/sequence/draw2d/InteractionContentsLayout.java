package org.eclipse.uml2.diagram.sequence.draw2d;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.layout.FreeFormLayoutEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;


public class InteractionContentsLayout extends FreeFormLayoutEx {
    public void layout(IFigure parent) {
        Iterator<?> children = parent.getChildren().iterator();
        Point offset = getOrigin(parent);
        IFigure f;
        
        List<IFigure> specifics = new LinkedList<IFigure>();
        
        while (children.hasNext()) {
            f = (IFigure)children.next();
            Class<?> specificLayoutKey = isSpecificLayout(f);
            if (specificLayoutKey != null){
            	specifics.add(f);
            	continue;
            }
            
            Rectangle bounds = (Rectangle)getConstraint(f);
            if (bounds == null) continue;

            int widthHint = bounds.width;
            int heightHint = bounds.height;
            if (widthHint == -1 || heightHint == -1) {
                Dimension _preferredSize = f.getPreferredSize(widthHint, heightHint);
                bounds = bounds.getCopy();
                if (widthHint == -1)
                    bounds.width = _preferredSize.width;
                if (heightHint == -1)
                    bounds.height = _preferredSize.height;
            }
            Dimension min = f.getMinimumSize(widthHint, heightHint);
            Dimension max = f.getMaximumSize();
            
            if (min.width>bounds.width)
                bounds.width = min.width;
            else if (max.width < bounds.width)
                bounds.width = max.width;
            
            if (min.height>bounds.height)
                bounds.height = min.height;
            else if (max.height < bounds.height)
                bounds.height = max.height;
            bounds = bounds.getTranslated(offset);
            f.setBounds(bounds);
        }
        
        if (specifics.isEmpty()){
        	return;
        }
        
        Dimension maxSize = new Dimension();
        int minY = Integer.MAX_VALUE;
        for (IFigure next : specifics){
            Rectangle bounds = calculateChildBounds(next);
            if (bounds == null) continue;
            maxSize.union(bounds.getSize());
            minY = Math.min(minY, bounds.y);
        }

        for (IFigure next : specifics){
            Rectangle bounds = calculateChildBounds(next);
            if (bounds == null) continue;
            bounds.height = maxSize.height;
            bounds.y = minY;
            next.setBounds(bounds);
        }
    
    }
    
    private Rectangle calculateChildBounds(IFigure next){
    	Point offset = getOrigin(next.getParent());    	
        Rectangle bounds = (Rectangle)getConstraint(next);
        if (bounds == null){
        	return null;
        }

        int widthHint = bounds.width;
        int heightHint = bounds.height;
        if (widthHint == -1 || heightHint == -1) {
            Dimension _preferredSize = next.getPreferredSize(widthHint, heightHint);
            bounds = bounds.getCopy();
            if (widthHint == -1)
                bounds.width = _preferredSize.width;
            if (heightHint == -1)
                bounds.height = _preferredSize.height;
        }
        Dimension min = next.getMinimumSize(widthHint, heightHint);
        Dimension max = next.getMaximumSize();
        
        if (min.width>bounds.width)
            bounds.width = min.width;
        else if (max.width < bounds.width)
            bounds.width = max.width;
        
        if (min.height>bounds.height)
            bounds.height = min.height;
        else if (max.height < bounds.height)
            bounds.height = max.height;
        bounds = bounds.getTranslated(offset);
    	return bounds;
    }
    
    private Class<?> isSpecificLayout(IFigure figure){
    	if (false == figure instanceof NodeFigure){
    		return null;
    	}
    	NodeFigure nodeFigure = (NodeFigure)figure;
    	if (nodeFigure.getChildren().isEmpty()){
    		return null;
    	}
    	for (Object nextChild : nodeFigure.getChildren()){
    		if (nextChild instanceof ISpecificLayoutFigure){
    			return nextChild.getClass();
    		}
    	}
    	
    	return null;
    }

}
