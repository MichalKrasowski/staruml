package org.eclipse.uml2.diagram.sequence.edit.create;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionNestedLayoutRequest;
import org.eclipse.uml2.diagram.sequence.edit.policies.TieFrameRequest;
import org.eclipse.uml2.diagram.sequence.edit.policies.TieFrameRequest.Completed;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;


public class TieInteractionUseToLifeLineEditPolicy extends AbstractCreateSDElementEditPolicy {
	@Override
	public boolean understandsRequest(Request req) {
		return req instanceof TieFrameRequest.Completed;
	}
	
	@Override
	public Command getCommand(Request request) {
		if (request instanceof TieFrameRequest.Completed){
			return getCompleteTieFrameCommand((TieFrameRequest.Completed)request);
		}
		return super.getCommand(request);
	}

	private Command getCompleteTieFrameCommand(Completed request) {
		GraphicalEditPart frameEP = request.getSubjectFrameEditPart();
		InteractionFragment frame = (InteractionFragment) frameEP.resolveSemanticElement();
		
		if (false == frame instanceof InteractionUse){
			//CombinedFragments???
			return UnexecutableCommand.INSTANCE;
		}
		
		GraphicalEditPart bracketEP = getHostImpl();
		GraphicalEditPart lifelineEP = findLifeLineEditPart(bracketEP);
		
		if (lifelineEP == null){
			return UnexecutableCommand.INSTANCE;
		}
		
		Lifeline lifeline = (Lifeline) lifelineEP.resolveSemanticElement();
		if (lifeline.getCoveredBys().contains(frame)){
			return UnexecutableCommand.INSTANCE;
		}
		
		Helper helper = new Helper(request);
		CreateViewRequest mountingRegionRequest = helper.postCreateViewNode(UMLElementTypes.InteractionUse_3006, new EObjectAdapter(frame));
		Command mountingRegionCommand = bracketEP.getCommand(mountingRegionRequest);
		
		if (!isValid(mountingRegionCommand)){
			return UnexecutableCommand.INSTANCE;
		}
		
		CreateConnectionViewRequest mountingLinkRequest = createMountingLinkRequest();
		CompositeCommand mountingLinkCommand = createMountingLinkCommand((IAdaptable)mountingRegionRequest.getViewDescriptors().get(0), new EObjectAdapter(frameEP.getNotationView()), mountingLinkRequest);
		if (!mountingLinkCommand.canExecute()){
			return UnexecutableCommand.INSTANCE;
		}
		
		InteractionNestedLayoutRequest layoutRequest = new InteractionNestedLayoutRequest();
		Command layoutCommand = getLayoutCommand(layoutRequest);
		
		GEFAwareCompositeCommand result = new GEFAwareCompositeCommand(bracketEP.getEditingDomain(), "Creating Interaction Use");
		result.add(new SetValueCommand(new SetRequest(frameEP.getEditingDomain(), frame, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), lifeline)));
		result.add(mountingRegionCommand);
		result.add(mountingLinkCommand);
		Command main = new ICommandProxy(result);

		return postScheduleLayout(main, layoutCommand);
	}

}
