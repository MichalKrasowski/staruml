package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.uml2.diagram.sequence.edit.create.arcas.AnchoredDiagramTarget;

/**
 * @autor: prepkin 
 * TODO: horizontal layout support
 */
public class TargetFeedbackHelper {

    public TargetFeedbackHelper(GraphicalEditPolicy policy) {
        myPolicy = policy;
    }
    
    private GraphicalEditPolicy myPolicy;
    private TargetFeedback myTargetFeedback;

    //ASSERT:myPolicy.getHost() is container, request contains ANCHOR
    public void showFeedback(Request request) {
        Command command = myPolicy.getCommand(request);
        if (command == null || !command.canExecute()) {
            return;
        }
        if (myPolicy.getHost() == myPolicy.getHost().getViewer().getContents()) {
            return;
        }
        if (request instanceof DropRequest) {
            AnchoredDiagramTarget target = new AnchoredDiagramTarget((GraphicalEditPart) myPolicy.getHost(), request);
            target = findVisibleTargetUptree(target);
            if (myTargetFeedback == null || !myTargetFeedback.getTarget().equals(target)) {
                if (myTargetFeedback != null) {
                    myAccess.removeFeedback(myTargetFeedback.getFigure());
                }
                if (target != null) {
                    myTargetFeedback = new TargetFeedback(target);
                    myAccess.addFeedback(myTargetFeedback.getFigure());
                }
            }
            Point diagramPoint = getDiagramPoint((DropRequest)request);            
            myTargetFeedback.layout(diagramPoint);
        }     
    }

    private AnchoredDiagramTarget findVisibleTargetUptree(AnchoredDiagramTarget target) {
        if (!isHidden(target.getContainer())) {
            return target;
        }
        if (false == target.getContainer().getParent() instanceof GraphicalEditPart){
        	return null;
        }
        
        GraphicalEditPart walker = (GraphicalEditPart)target.getContainer().getParent();
        while (walker != myPolicy.getHost().getViewer().getContents()) {
            if (!isHidden(walker)) {
                return new AnchoredDiagramTarget(walker);
            }            
            walker = (GraphicalEditPart)walker.getParent();
        }
        return null;
    }
    
    public void eraseFeedback() {
        if (myTargetFeedback != null) {
            myAccess.removeFeedback(myTargetFeedback.getFigure());
            myTargetFeedback = null;
        }
    }
    
    private Point getDiagramPoint(DropRequest request) {
        Point diagramPoint = new Point ((request).getLocation());
        ((GraphicalEditPart) myPolicy.getHost()).getFigure().translateToRelative(diagramPoint);
        return diagramPoint;
    }
    
//TODO [COPY/PASTE] from EditPartUtil    
    public static boolean isHidden(GraphicalEditPart editPart) {
        GraphicalViewer viewer = (GraphicalViewer) editPart.getViewer();
        if (viewer == null) {
            return true;
        }
        IFigure rootFigure = ((DiagramRootEditPart) viewer.getRootEditPart()).getFigure();
        for (IFigure figure = editPart.getFigure();; figure = figure.getParent()) {
            if (figure == null) {
                return true;
            } else if (figure == rootFigure) {
                return false;
            }
        }
    }

    private static class TargetFeedback{

        IFigure myFigure;
        AnchoredDiagramTarget myTarget;

        public TargetFeedback(AnchoredDiagramTarget target) {
            myTarget = target;
        }
        
        public IFigure getFigure() {
            if (myFigure == null) {
                if (myTarget.getAnchor() == null) {
                    if (myTarget.getContainer().getFigure() instanceof PolylineConnection) {
                        Polyline line = new Polyline();
                        line.setLineWidth(5);
                        line.setFill(false);
                        line.setPoints(((PolylineConnection) myTarget.getContainer().getFigure()).getPoints());
                        myFigure = line;
                    }
                    else {
                        RectangleFigure r= new RectangleFigure();
                        r.setFill(false);
                        r.setOutline(true);
                        r.setForegroundColor(ColorConstants.blue);
                        myFigure = r;
                    }
                }
                else {
                    RectangleFigure r= new RectangleFigure();
                    r.setFill(false);
                    r.setBackgroundColor(ColorConstants.black);//TODO: which color?
                    myFigure = r;
                }
            }
            return myFigure;
        }
        
        public void layout(Point diagramPoint) {
            IFigure containerFigure = myTarget.getContainer().getFigure();
            IFigure anchorFigure = myTarget.getAnchor() == null ? null : myTarget.getAnchor().getFigure();
            boolean isBefore = myTarget.isBeforeAnchor();
            if (anchorFigure == null) {
                myFigure.setBounds(containerFigure.getBounds().getExpanded(5, 5));
            }
            else {
                Rectangle ab = anchorFigure.getBounds();
                Rectangle pb = containerFigure.getBounds();
                Rectangle b = new Rectangle();
                
                b.x = pb.x;
                b.width = pb.width;
                
                int top;
                int bottom;
                if (isBefore) {
                    IFigure prevChild = AnchorUtil.findPrevFigure(myTarget.getAnchor());
                    if (prevChild == null) {
                        top = pb.y;
                    }
                    else {
                        Rectangle prevb = prevChild.getBounds(); 
                        top = prevb.y + prevb.height;
                    }                    
                    bottom = ab.y;
                }
                else {
                    top = ab.y + ab.height;
                    IFigure nextChild = AnchorUtil.findNextFigure(myTarget.getAnchor());
                    if (nextChild == null) {
                        bottom = pb.y + pb.height;
                    }
                    else {
                        bottom = nextChild.getBounds().y;
                    }                                        
                }
                                       
                b.y = diagramPoint.y;
                if (b.y < top) {
                    b.y = top;
                }                    
                else if (b.y > bottom) {
                    b.y = bottom;
                }
                b.height = 2;
                myFigure.setBounds(b);
            }
        }

//        private OrderedLayoutEditPolicy.AnchorFeedbackDetails getAnchorFeedbackDetails(GraphicalEditPart part) {
//            Object ob = part.getEditPolicy(EditPolicy.LAYOUT_ROLE);
//            if (ob instanceof OrderedLayoutEditPolicy) {
//                return ((OrderedLayoutEditPolicy)ob).getAnchorFeedbackDetails();
//            }
//            return null; 
//        }


        public AnchoredDiagramTarget getTarget() {
            return myTarget;
        }
    }
    private GraphicalEditPolicyAccess myAccess = new GraphicalEditPolicyAccess();
    private class GraphicalEditPolicyAccess extends GraphicalEditPolicy {
        public EditPart getHost() {
            return myPolicy.getHost();            
        }
        public void addFeedback(IFigure figure) {
            super.addFeedback(figure);
            System.err.println("Feedback added:" + figure + ": (" + (figure.getParent() != null ? " OK " : " BROKEN "));
        }
        public void removeFeedback(IFigure figure) {
        	System.err.println("Feedback removed:" + figure + ": (" + (figure.getParent() != null ? " OK " : " BROKEN "));
        	if (figure.getParent() != null){
        		super.removeFeedback(figure);	
        	}
        }
        
        protected IFigure getFeedbackLayer() {
            return getLayer(LayerConstants.FEEDBACK_LAYER);        
        }
    }
    
}