package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;


/**
 * 
 */
public class AbsLinkGef extends AbsElementGef implements AbsLink {
    AbsLinkGef(ConnectionEditPart modelLinkEditPart, AbsDiagramGef diagram) {
        super(modelLinkEditPart, diagram);
        myModelLinkEditPart = modelLinkEditPart;
    }
    
    public void setLinkPoints(Point[] points) {
        int size = points.length;
        
        org.eclipse.draw2d.geometry.Point sourcePoint = toGefPoint(points[0]); 
        List bendpoints;
        if (size>2) {
            bendpoints = new ArrayList(size-2);
            for (int i=1; i<size-1; i++ ) {
                bendpoints.add(toGefPoint(points[i]));
            }
        } else {
            bendpoints = Collections.EMPTY_LIST;
        }
        org.eclipse.draw2d.geometry.Point destinationPoint = toGefPoint(points[size-1]); 

        {
            if (!sourcePoint.equals(MissedMethods._connectionEditPart().getSourcePoint(myModelLinkEditPart)) ||
                !destinationPoint.equals(MissedMethods._connectionEditPart().getTargetPoint(myModelLinkEditPart)) ||
                !bendpoints.equals(MissedMethods._connectionEditPart().getBendpoints(myModelLinkEditPart))) {
                pointsAreChanged();
            }
        }
        
        MissedMethods._connectionEditPart().setupBendpoints(myModelLinkEditPart, sourcePoint, destinationPoint, bendpoints);
    }
    
    public void pointsAreChanged() {
        AbsDiagramGef.ChangePositionWatcher changePositionWatcher = getAbsDiagramGef().getChangePositionWatcher();
        changePositionWatcher.linkPointsAreChanged(this); 
    }
    
    public Point[] getLinkPoints() {
        List bendpoints = MissedMethods._connectionEditPart().getBendpoints(myModelLinkEditPart);
        int size = bendpoints.size()+2;
        Point[] result = new Point[size];
        
        result[0] = toAwtPoint(MissedMethods._connectionEditPart().getSourcePoint(myModelLinkEditPart));
        
        for (int j = 0; j < bendpoints.size(); j++) {
            result[j+1] = toAwtPoint((AbsoluteBendpoint) bendpoints.get(j));
        }
        
        result[size-1] = toAwtPoint(MissedMethods._connectionEditPart().getTargetPoint(myModelLinkEditPart));
        return result;
    }

    public AbsElement getSource() {
        if (mySource == null) {
            EditPart source = myModelLinkEditPart.getSource();
            if (source instanceof ConnectionEditPart) {
                mySource = getAbsElementFactory().createAbsLink((ConnectionEditPart)source);
            } else if (source instanceof GraphicalEditPart) {
                mySource = getAbsElementFactory().createAbsNode((GraphicalEditPart)source);
            }
        }
        return mySource;
    }

    public AbsElement getDestination() {
        if (myDestination == null) {
            EditPart destination = myModelLinkEditPart.getTarget();
            if (destination instanceof ConnectionEditPart) {
                myDestination = getAbsElementFactory().createAbsLink((ConnectionEditPart)destination);
            } else if (destination instanceof GraphicalEditPart) {
                myDestination = getAbsElementFactory().createAbsNode((GraphicalEditPart)destination);
            }
        }
        return myDestination;
    }
    
    private static Point toAwtPoint(org.eclipse.draw2d.geometry.Point gefPoint) {
        return new Point(gefPoint.x, gefPoint.y);
    }

    private static org.eclipse.draw2d.geometry.Point toGefPoint(Point awtPoint) {
        return new AbsoluteBendpoint(awtPoint.x, awtPoint.y);
    }
    
    private final ConnectionEditPart myModelLinkEditPart;
    private AbsElement mySource;
    private AbsElement myDestination;
} 
