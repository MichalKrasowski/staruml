package org.eclipse.uml2.diagram.sequence.edit.policies;

import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;


public class AnchorUtil {
    public static IFigure findPrevFigure(GraphicalEditPart anchor) {
        IFigure anchorFigure = anchor.getFigure();
        if (toSearchAnchorInsideEditPart((GraphicalEditPart)anchor.getParent(), anchorFigure.getParent())) {
            GraphicalEditPart prevPart = findPrevPart(anchor);
            return prevPart == null ? null : prevPart.getFigure();
        }
        else {
            return findPrevFigure(anchorFigure);
        }
    }
    
    public static boolean toSearchAnchorInsideEditPart(GraphicalEditPart container, IFigure containerFigure) {
        return true;
    }

    public static IFigure findNextFigure(GraphicalEditPart anchor) {
        IFigure anchorFigure = anchor.getFigure();
        if (toSearchAnchorInsideEditPart((GraphicalEditPart)anchor.getParent(), anchorFigure.getParent())) {
            GraphicalEditPart nextPart = findNextPart(anchor);
            return nextPart == null ? null : nextPart.getFigure();
        }
        else {
            return findNextFigure(anchorFigure);
        }
    }

    private static IFigure findPrevFigure(IFigure figure) {
        IFigure prevChild = null;
        for (Iterator it = figure.getParent().getChildren().iterator(); it.hasNext();) {
            IFigure child = (IFigure) it.next();
            if (child == figure) {
                return prevChild;
            }
            prevChild = child;
        }
        return null;
    }

    private static IFigure findNextFigure(IFigure figure) {
        for (Iterator it = figure.getParent().getChildren().iterator(); it.hasNext();) {
            IFigure child = (IFigure) it.next();
            if (child == figure) {
                if (it.hasNext()) {
                    return (IFigure) it.next();
                }
                return null;
            }
        }
        return null;
    }

    public static GraphicalEditPart findPrevPart(GraphicalEditPart part) {
        EditPart prevChild = null;
        for (Iterator it = part.getParent().getChildren().iterator(); it.hasNext();) {
            EditPart child = (EditPart) it.next();
            if (child == part) {
                return (GraphicalEditPart) prevChild;
            }
            prevChild = child;
        }
        return null;
    }

    public static GraphicalEditPart findNextPart(GraphicalEditPart part) {
        for (Iterator it = part.getParent().getChildren().iterator(); it.hasNext();) {
            EditPart child = (EditPart) it.next();
            if (child == part) {
                if (it.hasNext()) {
                    return (GraphicalEditPart) it.next();
                }
            }
        }
        return null;
    }
	

}
