package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;


public class SDXYLayoutEditPolicy extends XYLayoutEditPolicy implements OrderedLayoutEditPolicy {
	
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child instanceof IBorderItemEditPart) {
			return new BorderItemSelectionEditPolicy();
		}
		EditPolicy result = super.createChildEditPolicy(child);
		if (result == null) {
			return new ResizableShapeEditPolicy();
		}
		return result;
	}
	
	public AnchoredSibling findAnchoredSibling(Point relativeLocation) {
		AnchoredSibling result = findAnchorAbove(relativeLocation);
		if (result == null){
			result = findAnchorBelow(relativeLocation);
		}
		return result;
	}
	
	private AnchoredSibling findAnchorAbove(Point relativeLocation) {
		View hostView = getHostImpl().getNotationView();
		View result = null;
		int maxFoundPositionBefore = Integer.MIN_VALUE;
		for (Object next : hostView.getChildren()){
			if (false == next instanceof Node){
				continue;	
			}
			Node nextChild = (Node)next;
			if (!isConsiderableNode(nextChild)){
				continue;
			}
			if (false == nextChild.getLayoutConstraint() instanceof Bounds){
				continue;
			}
			Bounds bounds = (Bounds) nextChild.getLayoutConstraint();
			if (!bounds.eIsSet(NotationPackage.eINSTANCE.getLocation_Y())){
				continue;
			}
			if (!bounds.eIsSet(NotationPackage.eINSTANCE.getSize_Height())){
				continue;
			}
			int nextMaxY = bounds.getY() + bounds.getHeight();
			if (nextMaxY > maxFoundPositionBefore && nextMaxY < relativeLocation.y){
				maxFoundPositionBefore = nextMaxY;
				result = nextChild;
			}
		}	
		return result == null ? null : new AnchoredSibling(result, false);
	}
	
	private AnchoredSibling findAnchorBelow(Point relativeLocation) {
		View hostView = getHostImpl().getNotationView();
		View result = null;
		int minFoundPositionAfter = Integer.MAX_VALUE;
		for (Object next : hostView.getChildren()){
			if (false == next instanceof Node){
				continue;	
			}
			Node nextChild = (Node)next;
			if (!isConsiderableNode(nextChild)){
				continue;
			}
			if (false == nextChild.getLayoutConstraint() instanceof Bounds){
				continue;
			}
			Bounds bounds = (Bounds) nextChild.getLayoutConstraint();
			if (!bounds.eIsSet(NotationPackage.eINSTANCE.getLocation_Y())){
				continue;
			}
			if (!bounds.eIsSet(NotationPackage.eINSTANCE.getSize_Height())){
				continue;
			}
			int nextY = bounds.getY();
			if (nextY < minFoundPositionAfter && nextY > relativeLocation.y){
				minFoundPositionAfter = nextY;
				result = nextChild;
			}
		}	
		return result == null ? null : new AnchoredSibling(result, true);
	}
	
	private IGraphicalEditPart getHostImpl(){
		return (IGraphicalEditPart) getHost();
	}
	
	private static boolean isConsiderableNode(Node node){
		int vid = UMLVisualIDRegistry.getVisualID(node);
		if (vid == -1){
			return false;
		}
		if (UMLVisualIDRegistry.isCompartmentVisualID(vid)){
			return false;
		}
		//XXX: introduce generated method for labels in VIDRegistry 
		if (vid > 5000){
			return false;
		}
		return true;
	}
}
