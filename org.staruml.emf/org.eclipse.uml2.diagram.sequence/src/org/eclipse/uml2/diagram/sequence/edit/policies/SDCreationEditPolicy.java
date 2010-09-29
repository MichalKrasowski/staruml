package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateParametersImpl;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.model.SDModelAccess;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;


public class SDCreationEditPolicy extends CreationEditPolicyWithCustomReparent {
	public SDCreationEditPolicy(){
		this(UMLVisualIDRegistry.TYPED_ADAPTER);
	}
	
	public SDCreationEditPolicy(IVisualIDRegistry registry){
		super(registry);
		setProvideU2TParameters(true);
	}
	
	@Override
	protected U2TCreateParametersImpl computeCreateParameters(CreateRequest request) {
		U2TCreateParametersImpl result = super.computeCreateParameters(request);
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
	public Command getCommand(Request request) {
		Command result = super.getCommand(request);
		if (result == null || !result.canExecute()){
			return result;
		}
		ICommand invalidateSDModel = SDModelAccess.getInvalidateSDModelCommand(getHostImpl());
		if (invalidateSDModel == null || !invalidateSDModel.canExecute()){
			return result;
		}
		
		if (result instanceof ICommandProxy){
			ICommand wrapped = ((ICommandProxy)result).getICommand();
			CompositeCommand cc = new CompositeCommand(wrapped.getLabel());
			cc.add(wrapped);
			cc.add(invalidateSDModel);
			return new ICommandProxy(cc);
		}
		
		CompoundCommand cc = new CompoundCommand(result.getLabel());
		cc.add(result);
		cc.add(new ICommandProxy(invalidateSDModel));
		return cc;
	}
	


}
