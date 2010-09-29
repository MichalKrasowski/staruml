package org.eclipse.uml2.diagram.sequence.edit.create;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateParameters;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateParametersImpl;
import org.eclipse.uml2.diagram.sequence.anchor.SDModelUtil;
import org.eclipse.uml2.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.CombinedFragmentMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionOperandMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionUseMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredCombinedFragmentEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredOperandEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionNestedLayoutRequest;
import org.eclipse.uml2.diagram.sequence.edit.policies.OrderedLayoutEditPolicy;
import org.eclipse.uml2.diagram.sequence.model.SDModelAccess;
import org.eclipse.uml2.diagram.sequence.model.edit.CreateCombinedFragment;
import org.eclipse.uml2.diagram.sequence.model.edit.SDAnchor;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDCombinedFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;

public class CreateCombinedFragmentEditPolicy extends AbstractCreateSDElementEditPolicy {
	@Override
	public void activate() {
		super.activate();
	}
	
	@Override
	public boolean understandsRequest(Request req) {
		if (req instanceof CreateInteractionUseRequest){
			return true;
		}	
		return super.understandsRequest(req);
	}
	
	@Override
	public Command getCommand(Request request) {
		if (request instanceof CreateCombinedFragmentRequest){
			return createCombinedFragment((CreateCombinedFragmentRequest)request);
		}
		return super.getCommand(request);
	}
	
	private SDBracketContainer findHostBracketContainer(SDModel sdModel){
		Element umlHost = (Element) getHostImpl().getNotationView().getElement();
		if (umlHost instanceof BehaviorExecutionSpecification){
			return sdModel.getUMLTracing().findBehaviorSpec((BehaviorExecutionSpecification)umlHost);
		}
		if (umlHost instanceof Lifeline){
			return sdModel.getUMLTracing().findLifeLine((Lifeline)umlHost);
		}
		if (umlHost instanceof InteractionOperand){
			SDFrame sdFrame = sdModel.getUMLTracing().findInteractionOperand((InteractionOperand)umlHost);
			Lifeline onLifeline = (Lifeline) findLifeLineEditPart(getHostImpl()).resolveSemanticElement();
			return sdFrame.findRegionForUmlLifeLine(onLifeline);
		}
		
		throw new IllegalStateException("EditPolicy " + this + " is not expected to be registered for host : " + umlHost);
	}
	
	private Command createCombinedFragment(final CreateCombinedFragmentRequest request){
		LifelineEditPart lifeLineEP = findLifeLineEditPart(getHostImpl());
		final Lifeline umlLifeline = (Lifeline) lifeLineEP.resolveSemanticElement();
		final SDModel sdModel = SDModelAccess.findSDModel(getHostImpl().getNotationView());
		final SDBracketContainer sdHost = findHostBracketContainer(sdModel); 
		final IGraphicalEditPart frameContainerEP = findFrameContainerEditPart(sdHost);
		final U2TCreateParameters createParams = U2TCreateParametersImpl.createFor(getHostImpl(), request);
		final OrderedLayoutEditPolicy.AnchoredSibling diagramAnchor = computeAnchoredSibling(createParams);
		final SDAnchor sdAnchor;
		if (diagramAnchor == null || diagramAnchor.isBeforeNotAfterAnchor()){
			sdAnchor = SDAnchor.firstChildFor(sdHost);
		} else {
			sdAnchor = createSDAfterAnchor(diagramAnchor, sdModel, umlLifeline);
		}
		
		final Helper2 helper2 = new Helper2(request.getPreferencesHint());
		
		final ShowDialogCommand dialog = new ShowDialogCommand(getEditingDomain());
		AbstractTransactionalCommand doTheJob = new AbstractTransactionalCommand(getEditingDomain(), "", Collections.emptyList()){
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				ChooseOperatorDialog.OperatorProperties config = dialog.getOperatorProperties();
				if (config == null){
					return CommandResult.newCancelledCommandResult();
				}
				
				CreateCombinedFragment creator = new CreateCombinedFragment(sdModel);
				SDCombinedFragment result = creator.createCombinedFragment(sdHost, sdAnchor, config.getOperatorKind(), config.getNumberOfOperands());
				
				if (result == null){
					return CommandResult.newErrorCommandResult("Failed to created combined fragment in SDModel");
				}
				
				CombinedFragment umlResult = result.getUmlCombinedFragment();
				SDMountingRegion combinedMounter = result.findRegionForUmlLifeLine(umlLifeline);
				Node combinedMounterView = helper2.createNode(//
						getHostImpl().getNotationView(), umlResult, CombinedFragmentMountingRegionEditPart.VISUAL_ID, diagramAnchor);

				if (combinedMounterView == null){
					throw new IllegalStateException("Can't create combined mounter view for sd-mounter: " + combinedMounter);
				}
				
				if (createParams.getRelativeLocation() != null){
					Point relativeLocation = createParams.getRelativeLocation();
					//ViewUtil.setStructuralFeatureValue(combinedMounterView, NotationPackage.eINSTANCE.getLocation_X(), Integer.valueOf(relativeLocation.x));
					ViewUtil.setStructuralFeatureValue(combinedMounterView, NotationPackage.eINSTANCE.getLocation_Y(), Integer.valueOf(relativeLocation.y));
				}
				if (request.getSize() != null){
					ViewUtil.setStructuralFeatureValue(combinedMounterView, NotationPackage.eINSTANCE.getSize_Height(), Integer.valueOf(request.getSize().height));
					ViewUtil.setStructuralFeatureValue(combinedMounterView, NotationPackage.eINSTANCE.getSize_Width(), Integer.valueOf(request.getSize().width));
				}
				
				//XXX: consider frames anchor!
				View framesAnchor; 

				Node combinedFrameView = helper2.createNode(//
						frameContainerEP.getNotationView(), umlResult, LayeredCombinedFragmentEditPart.VISUAL_ID, null);

				Edge combinedMountingLink = helper2.createMountingLink(combinedMounterView, combinedFrameView);
				
				for (SDBracket nextOperandMounter : combinedMounter.getBrackets()){
					if (nextOperandMounter instanceof SDMountingRegion){
						Node nextOperandMounterView = helper2.createNode(//
								combinedMounterView, nextOperandMounter.getUmlFragment(), InteractionOperandMountingRegionEditPart.VISUAL_ID, null);
						
						if (nextOperandMounterView == null){
							throw new IllegalStateException("Can't create operand mounter view for sd-mounter: " + nextOperandMounter);
						}
						
						Node nextOperandFrameView = helper2.createNode(//
								combinedFrameView, nextOperandMounter.getUmlFragment(), LayeredOperandEditPart.VISUAL_ID, null);

						if (nextOperandFrameView == null){
							throw new IllegalStateException("Can't create operand frame view for sd-mounter: " + nextOperandMounter);
						}
						
						Edge operandMountingLink = helper2.createMountingLink(nextOperandMounterView, nextOperandFrameView);
					}
				}
				
				return CommandResult.newOKCommandResult();
			}
		};
		
		InteractionNestedLayoutRequest layoutRequest = new InteractionNestedLayoutRequest();
		layoutRequest.requestTotalLayout();
		Command layoutCommand = getLayoutCommand(layoutRequest);
		GEFAwareCompositeCommand result = new GEFAwareCompositeCommand(getHostImpl().getEditingDomain(), "Creating Combined Fragment");
		result.add(dialog);
		result.add(doTheJob);
		Command main = new ICommandProxy(result);
		return postScheduleLayout(main, layoutCommand);
	}
	
	private GraphicalEditPart findFrameContainerEditPart(SDBracketContainer sdHost){
		InteractionEditPart interactionEP = (InteractionEditPart) findLifeLineEditPart(getHostImpl()).getParent(); 
		if (sdHost instanceof SDLifeLine){
			return interactionEP;
		}
		if (sdHost instanceof SDMountingRegion){
			SDMountingRegion mounter = (SDMountingRegion)sdHost;
			SDFrame sdFrame = mounter.getFrame();
			return findFrameEditPart(interactionEP, sdFrame);
		}
		throw new IllegalStateException("Unknown SDBracketContainer: " + sdHost);
	}
	
	private static GraphicalEditPart findFrameEditPart(InteractionEditPart interactionEP, SDFrame sdFrame){
		if (sdFrame == null){
			return interactionEP;
		}
		GraphicalEditPart nextEP = interactionEP;
		List<SDFrame> frames;
		try {
			frames = SDModelUtil.collectEnclosingFrames(sdFrame, new ArrayList<SDFrame>());
			Collections.reverse(frames);
		} catch (SDModelUtil.AlienElementException e){
			throw new IllegalStateException(e);
		}
		for (SDFrame nextFrame : frames){
			nextEP = (GraphicalEditPart) nextEP.findEditPart(null, nextFrame.getUmlFragment());
			if (nextEP == null){
				throw new IllegalStateException(//
						"Can't find frame editpart for SDFrame: " + nextFrame + //
						", while searching for deep frame: " + sdFrame);
			}
		}

		return nextEP;
	}
	
	private static class ShowDialogCommand extends AbstractTransactionalCommand {
		private ChooseOperatorDialog.OperatorProperties myProperties;

		public ShowDialogCommand(TransactionalEditingDomain domain){
			super(domain, "Select", Collections.emptyList());
		}
		
		public ChooseOperatorDialog.OperatorProperties getOperatorProperties() {
			return myProperties;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	        ChooseOperatorDialog dialog = new ChooseOperatorDialog(Display.getCurrent().getActiveShell()); 
	        if (Window.OK == dialog.open()) {
	            myProperties = dialog.getResult();
	            return CommandResult.newOKCommandResult();
	        }
	        return CommandResult.newCancelledCommandResult();
		}
	}
	
	private OrderedLayoutEditPolicy.AnchoredSibling computeAnchoredSibling(U2TCreateParameters createParams){
		Point relativeLocation = createParams.getRelativeLocation();
		if (relativeLocation != null && getHost().getEditPolicy(EditPolicy.LAYOUT_ROLE) instanceof OrderedLayoutEditPolicy){
			OrderedLayoutEditPolicy layout = (OrderedLayoutEditPolicy)getHost().getEditPolicy(EditPolicy.LAYOUT_ROLE);
			return layout.findAnchoredSibling(relativeLocation);
		}
		return null;
	}
	
	private SDAnchor createSDAfterAnchor(OrderedLayoutEditPolicy.AnchoredSibling anchor, SDModel sdModel, Lifeline onUmlLifeline){
		if (anchor.isBeforeNotAfterAnchor()){
			throw new IllegalArgumentException("I am for 'after' anchors only");
		}
		View notationAnchor = anchor.getSiblingView();
		SDBracket sdAnchor;
		switch(UMLVisualIDRegistry.getVisualID(notationAnchor)){
			case BehaviorExecutionSpecificationEditPart.VISUAL_ID : 
			{
				BehaviorExecutionSpecification umlSpec = (BehaviorExecutionSpecification)notationAnchor.getElement();
				sdAnchor = sdModel.getUMLTracing().findBehaviorSpec(umlSpec);
				break;
			}
			case CombinedFragmentMountingRegionEditPart.VISUAL_ID:
			{
				CombinedFragment umlFrame = (CombinedFragment)notationAnchor.getElement();
				SDFrame sdFrame = sdModel.getUMLTracing().findCombinedFragment(umlFrame);
				sdAnchor = sdFrame.findRegionForUmlLifeLine(onUmlLifeline);
				break;
			}
			case StateInvariantEditPart.VISUAL_ID:
			case ActionExecutionSpecificationEditPart.VISUAL_ID:
			case InteractionUseMountingRegionEditPart.VISUAL_ID:
			{
				throw new UnsupportedOperationException("Not yet implemented");
			}
			default: {
				throw new IllegalStateException("Unknown/unexpected anchor view found: " + notationAnchor);
			}
		}
		return SDAnchor.after(sdAnchor);
	}
	
}
