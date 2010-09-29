package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateParametersImpl;
import org.eclipse.uml2.diagram.common.editpolicies.U2TGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;


public class SDGraphicalNodeEditPolicy extends U2TGraphicalNodeEditPolicy {
	
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
		ICommandProxy result = (ICommandProxy)super.getConnectionAndRelationshipCompleteCommand(request);
		if (result == null){
			return result;
		}
		InteractionEditPart interactionEP = findInteractionEditPart(getHost());
		if (interactionEP == null){
			return result;
		}
		CompoundCommand withLayout = new CompoundCommand();
		withLayout.add(result);
		withLayout.add(interactionEP.getCommand(new InteractionNestedLayoutRequest()));
		return withLayout.unwrap();
	}
	
	protected InteractionEditPart findInteractionEditPart(EditPart ep){
		RootEditPart root = ep.getRoot();
		while (ep != root && ep != null){
			if (ep instanceof InteractionEditPart){
				return (InteractionEditPart)ep;
			}
			ep = ep.getParent();
		}
		return null;
	}
	
	@Override
	protected U2TCreateParametersImpl computeParameters(CreateConnectionRequest request) {
		U2TCreateParametersImpl result = super.computeParameters(request);
		Point relativeLocation = result.getRelativeLocation();
		if (relativeLocation != null && getHost().getEditPolicy(EditPolicy.LAYOUT_ROLE) instanceof OrderedLayoutEditPolicy){
			OrderedLayoutEditPolicy layout = (OrderedLayoutEditPolicy)getHost().getEditPolicy(EditPolicy.LAYOUT_ROLE);
			OrderedLayoutEditPolicy.AnchoredSibling anchor = layout.findAnchoredSibling(relativeLocation);
			if (anchor != null){
				result.setAnchorSibling(anchor.getSiblingView());
				result.setBeforeNotAfterAnchor(anchor.isBeforeNotAfterAnchor());
			}
		}
		return result;
	}
	
	@Override
	protected ConnectionAnchor getSourceConnectionAnchor(CreateConnectionRequest request) {
		return new XYAnchor(request.getLocation());
	}
	
	@Override
	protected ConnectionAnchor getTargetConnectionAnchor(CreateConnectionRequest request) {
		return new XYAnchor(request.getLocation());
	}


	
}
