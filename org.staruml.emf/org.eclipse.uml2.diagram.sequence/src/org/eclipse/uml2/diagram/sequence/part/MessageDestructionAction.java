package org.eclipse.uml2.diagram.sequence.part;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionNestedLayoutRequest;
import org.eclipse.uml2.diagram.sequence.model.SDModelAccess;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDTrace;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.UMLPackage;


public class MessageDestructionAction implements IObjectActionDelegate {
	private Context myContext;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		action.setText("Destruction");
	}

	public void selectionChanged(IAction action, ISelection selection) {
		myContext = null;
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection == false || selection.isEmpty()) {
			return;
		}
		MessageEditPart messageEP = (MessageEditPart) ((IStructuredSelection) selection).getFirstElement();
		myContext = createDestructionContext(messageEP);
		action.setEnabled(myContext != null && (myContext.isDestruction() || myContext.canBeDestruction()));
		action.setChecked(myContext != null && myContext.isDestruction());
	}
	
	public void run(IAction action) {
		if (myContext == null){
			return;
		}
		
		TransactionalEditingDomain domain = myContext.getMessageEP().getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(domain, "Toggle Destruction");
		SetRequest request = new SetRequest(myContext.getSdMessage().getUmlMessage(), UMLPackage.eINSTANCE.getMessage_MessageSort(), //
				myContext.isDestruction() ? MessageSort.SYNCH_CALL_LITERAL : MessageSort.DELETE_MESSAGE_LITERAL);
		cc.compose(new SetValueCommand(request));
		
		InteractionNestedLayoutRequest layoutRequest = new InteractionNestedLayoutRequest();
		layoutRequest.requestTotalLayout();
		Command geflayout = myContext.findInteractionEditPart().getCommand(layoutRequest);
		if (geflayout != null){
			cc.compose(new CommandProxy(geflayout));
		}
		
		if (cc.canExecute()){
			myContext.getMessageEP().getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(cc.reduce()));
		}
	}
	
	private Context createDestructionContext(MessageEditPart messageEP){
		if (false == messageEP.getTarget() instanceof BehaviorExecutionSpecificationEditPart){
			return null;
		}
		BehaviorExecutionSpecificationEditPart targetEP = (BehaviorExecutionSpecificationEditPart)messageEP.getTarget();
		View specView = targetEP.getNotationView();
		EObject entity = specView.getElement();
		if (false == entity instanceof ExecutionSpecification){
			return null;
		}
		SDModel sdModel = SDModelAccess.findSDModel(specView);
		if (sdModel == null){
			return null;
		}
		
		SDTrace tracing = sdModel.getUMLTracing();
		SDBehaviorSpec sdSpec = tracing.findBehaviorSpec((ExecutionSpecification)entity);
		if (false == sdSpec instanceof SDExecution){
			return null;
		}
		
		SDExecution sdExecution = (SDExecution)sdSpec;
		if (false == sdExecution.getBracketContainer() instanceof SDLifeLine){
			return null;
		}
		SDMessage incomingMessage = sdExecution.getIncomingMessage();
		if (incomingMessage == null){
			return null;
		}
		
		return new Context(messageEP, incomingMessage, sdExecution);
	}

	private static class Context {
		private final SDExecution mySdExecution;
		private final MessageEditPart myMessageEP;
		private final SDMessage mySdMessage;

		public Context(MessageEditPart messageEP, SDMessage sdMessage, SDExecution sdExecution){
			myMessageEP = messageEP;
			mySdMessage = sdMessage;
			mySdExecution = sdExecution;
		}
		
		public MessageEditPart getMessageEP() {
			return myMessageEP;
		}
		
		public SDExecution getSdExecution() {
			return mySdExecution;
		}
		
		public SDMessage getSdMessage() {
			return mySdMessage;
		}
		
		public boolean canBeDestruction(){
			List<SDBracket> brackets = mySdExecution.getBracketContainer().getBrackets(); 
			return brackets.indexOf(mySdExecution) == brackets.size() - 1; 
		}
		
		public boolean isDestruction(){
			return mySdMessage.getUmlMessage().getMessageSort() == MessageSort.DELETE_MESSAGE_LITERAL;
		}
		
		public InteractionEditPart findInteractionEditPart(){
			EditPart ep = myMessageEP.getTarget();
			RootEditPart root = ep.getRoot();
			while (ep != root && ep != null){
				if (ep instanceof InteractionEditPart){
					return (InteractionEditPart)ep;
				}
				ep = ep.getParent();
			}
			return null;
		}
		
		public LifelineEditPart findLifeLineEditpart(){
			EditPart ep = myMessageEP.getTarget();
			RootEditPart root = ep.getRoot();
			while (ep != root && ep != null){
				if (ep instanceof LifelineEditPart){
					return (LifelineEditPart)ep;
				}
				ep = ep.getParent();
			}
			return null;
		}
		
	}
	
	


}
