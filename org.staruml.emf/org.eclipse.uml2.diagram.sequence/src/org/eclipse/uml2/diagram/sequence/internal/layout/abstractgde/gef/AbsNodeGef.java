package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNodeEnumeration;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;


/**
 * 
 */
public class AbsNodeGef extends AbsElementGef implements AbsNode {
    AbsNodeGef(GraphicalEditPart modelNodeEditPart, AbsDiagramGef diagram, boolean alterMinimumSize) {
        super(modelNodeEditPart, diagram);
        myModelNodeEditPart = modelNodeEditPart;
        myAlterMinimumSize = alterMinimumSize;
    }
    
    public EObject getModelEntity() {
    	return getEditPart().resolveSemanticElement();
    }

    private Rectangle getBounds(){
    	return MissedMethods._graphicalEditPart().getBounds(myModelNodeEditPart);
    }
    
    private void setBounds(Rectangle rectangle){
    	MissedMethods._graphicalEditPart().setBounds(myModelNodeEditPart, rectangle);
    }
    
    public int getX() {
        return getBounds().x;
    }
    
    public void setX(int x) {
        Rectangle rectangle = getBounds();
        boolean changed = rectangle.x != x; 
        if (changed) {
            rectangle.x = x;
            setBounds(rectangle);
            boundsAreChanged(AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.X);            
        }
    }
    public int getY() {
        return getBounds().y;
    }
    
    public void setY(int y) {
        Rectangle rectangle = getBounds();
        boolean changed = rectangle.y != y;
        if (changed) {
            rectangle.y = y;
            setBounds(rectangle);
            boundsAreChanged(AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.Y);            
        }
    }
    public int getWidth() {
        return getBounds().width;
    }
    
    public void setWidth(int width) {
        Rectangle rectangle = getBounds();
        boolean changed = rectangle.width != width;
        if (changed) {
            rectangle.width = width;
            setBounds(rectangle);
        }
        if (myAlterMinimumSize) {
            myModelNodeEditPart.getFigure().setMinimumSize(new org.eclipse.draw2d.geometry.Dimension(rectangle.width, rectangle.height));
        }
        if (changed) {
            boundsAreChanged(AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.WIDTH);            
        }
    }
    public int getHeight() {
        return getBounds().height;
    }
    
    public void setHeight(int height) {
        Rectangle rectangle = getBounds();
        boolean changed = rectangle.height != height;
        if (changed){
	        rectangle.height = height;
	        setBounds(rectangle);
        }
        if (myAlterMinimumSize) {
            myModelNodeEditPart.getFigure().setMinimumSize(new org.eclipse.draw2d.geometry.Dimension(rectangle.width, rectangle.height));
        }
        if (changed) {
            boundsAreChanged(AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.HEIGHT);            
        }
    }
    /**
     * public to allow access from AbsLayoutAccessGef 
     */
    public void boundsAreChanged(int coordCode) {
        AbsDiagramGef.ChangePositionWatcher changePositionWatcher = getAbsDiagramGef().getChangePositionWatcher();
        changePositionWatcher.nodeBoundsAreChanged(this, coordCode); 
    }

    public AbsElement getParentGdeElement() {
    	GraphicalEditPart parentNode = (GraphicalEditPart)myModelNodeEditPart.getParent();
        if (parentNode == null) {
            return null;
        }
        return getAbsElementFactory().createAbsNode(parentNode);
    }
    
	public AbsNodeEnumeration subnodes() {
		@SuppressWarnings("unchecked")
		List<EditPart> modelPartList = myModelNodeEditPart.getChildren();
        List<AbsNodeGef> resultList = new ArrayList<AbsNodeGef>(modelPartList.size());
        for (EditPart next : modelPartList){
        	if (next instanceof ITextAwareEditPart){
        		continue;
        	}
        	if (next instanceof ConnectionEditPart){
        		continue;
        	}
        	if (next instanceof GraphicalEditPart){
        		resultList.add(getAbsElementFactory().createAbsNode((GraphicalEditPart)next));
        	}
        }
        return new AbsNodeEnumerationImpl(resultList.iterator());
    }


    public Dimension getPreferredSize() {
        org.eclipse.draw2d.geometry.Dimension dimension = myModelNodeEditPart.getFigure().getPreferredSize();
        return new Dimension(dimension.width, dimension.height);
    }

    public boolean isUserResized() {
        return MissedMethods._graphicalEditPart().isUserResized(myModelNodeEditPart);
    }
    
    public void markUserResized() {
    	MissedMethods._graphicalEditPart().markUserResized(myModelNodeEditPart);
    }

    public boolean isExternal() {
    	return myModelNodeEditPart instanceof IBorderItemEditPart;
    }
    
    private final GraphicalEditPart myModelNodeEditPart;
    private final boolean myAlterMinimumSize;
    
    private static class AbsNodeEnumerationImpl implements AbsNodeEnumeration {
        AbsNodeEnumerationImpl(Iterator<?> iterator) {
            myIterator = iterator;
        }
        public AbsNode nextGdeNode() {
            return (AbsNode) myIterator.next();
        }
        public Object nextElement() {
            return nextGdeNode();
        }
        public boolean hasMoreElements() {
            return myIterator.hasNext();
        }

        private final Iterator<?> myIterator;
    }
}
