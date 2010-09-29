package org.eclipse.uml2.diagram.sequence.edit.create;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.uml2.diagram.sequence.edit.helpers.CoveredLifelineConfigurer;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionNestedLayoutRequest;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;

public class CreateInteractionUseEditPolicy extends AbstractCreateSDElementEditPolicy {
	@Override
	public boolean understandsRequest(Request req) {
		if (req instanceof CreateInteractionUseRequest){
			return true;
		}	
		return super.understandsRequest(req);
	}
	
	@Override
	public Command getCommand(Request request) {
		if (request instanceof CreateInteractionUseRequest){
			return createInteractionUse((CreateInteractionUseRequest)request);
		}
		return super.getCommand(request);
	}
	
	protected Command createInteractionUse(CreateInteractionUseRequest request){
		//System.out.println("CreateInteractionUseEditPolicy.createInteractionUse()");
		GraphicalEditPart bracketEP = getHostImpl();
		GraphicalEditPart frameEP = findFrameEditPart(bracketEP);
		
		CoveredLifelineConfigurer.setCoveredLifeLines(request, findLifeLineEditPart(bracketEP));
		
		if (frameEP == null){
			//System.out.println("CreateInteractionUseEditPolicy.createInteractionUse() : NO-1");
			return UnexecutableCommand.INSTANCE;
		}
		
		Helper helper = getHelper(request);
		CreateViewAndElementRequest semanticAndNodeInFrameRequest = helper.createNodeAndElement(UMLElementTypes.InteractionUse_3007);
		Command semanticAndNodeInFrameCommand = frameEP.getCommand(semanticAndNodeInFrameRequest);
		if (!isValid(semanticAndNodeInFrameCommand)){
			//System.out.println("CreateInteractionUseEditPolicy.createInteractionUse() : NO-2");
			return UnexecutableCommand.INSTANCE;
		}
		
		CreateViewRequest mountingRegionRequest = helper.postCreateViewNode(UMLElementTypes.InteractionUse_3006, semanticAndNodeInFrameRequest);
		semanticAndNodeInFrameRequest.setExtendedData(request.getExtendedData());
		Command mountingRegionCommand = bracketEP.getCommand(mountingRegionRequest);
		
		if (!isValid(mountingRegionCommand)){
			//System.out.println("CreateInteractionUseEditPolicy.createInteractionUse() : NO-3");
			return UnexecutableCommand.INSTANCE;
		}
		
		CreateConnectionViewRequest mountingLinkRequest = createMountingLinkRequest();
		CompositeCommand mountingLinkCommand = createMountingLinkCommand((IAdaptable)mountingRegionRequest.getViewDescriptors().get(0), semanticAndNodeInFrameRequest.getViewAndElementDescriptor(), mountingLinkRequest);
		if (!mountingLinkCommand.canExecute()){
			System.out.println("CreateInteractionUseEditPolicy.createInteractionUse() : NO-4");
			return UnexecutableCommand.INSTANCE;
		}
		
		InteractionNestedLayoutRequest layoutRequest = new InteractionNestedLayoutRequest();
//		layoutRequest.addViewAdapter(semanticAndNodeInFrameRequest.getViewAndElementDescriptor());
//		layoutRequest.addViewAdapters(mountingRegionRequest.getViewDescriptors());
//		layoutRequest.addViewAdapter(mountingLinkRequest.getConnectionViewDescriptor());
		Command layoutCommand = getLayoutCommand(layoutRequest);
		
		GEFAwareCompositeCommand result = new GEFAwareCompositeCommand(bracketEP.getEditingDomain(), "Creating Interaction Use");
		result.add(semanticAndNodeInFrameCommand);
		result.add(mountingRegionCommand);
		result.add(mountingLinkCommand);
		Command main = new ICommandProxy(result);

		return postScheduleLayout(main, layoutCommand);
	}
	
	private GraphicalEditPart findFrameEditPart(GraphicalEditPart bracketEP){
		if (bracketEP instanceof LifelineEditPart){
			return (GraphicalEditPart)bracketEP.getParent();
		}
		return null;
	}
	
}
