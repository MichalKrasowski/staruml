package org.eclipse.uml2.diagram.common.editpolicies;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IInsertableEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;


public class InsertingComponentEditPolicy extends ComponentEditPolicy {
	/**
	 * This is to combine the default GMF ComponentEditPolicy and ListItemComponentEditPolicy 
	 * into single U2T wrapper.
	 * 
	 * It affects the way how this editpolicy search for the insertableEditPart only in response to 
	 * semantic insert requests 
	 * @see getInsertableEditPart
	 */
	private boolean myForListItem;
	
	public InsertingComponentEditPolicy(boolean forListItem){
		myForListItem = forListItem;
	}
	
	public InsertingComponentEditPolicy(){
		this(false);
	}
	
	public void setForListItem(boolean forListItem) {
		myForListItem = forListItem;
	}
	
	protected IInsertableEditPart getInsertableEditPart() {
		if (myForListItem){
			// get the container of the host list item
			EditPart container = getHost().getParent();
			return (container instanceof IInsertableEditPart) ? (IInsertableEditPart)container : null; 
		}
		return super.getInsertableEditPart();
	}
	
	protected Command getInsertCommand(GroupRequest insertRequest) {
		IInsertableEditPart insertEP = getInsertableEditPart();
		if (null == insertEP) {
			return null;
		}

		EObject hostElement = ViewUtil.resolveSemanticElement((View) insertEP.getModel());
		if (hostElement != null) {
			TransactionalEditingDomain editingDomain = getHostImpl().getEditingDomain();
			if (editingDomain == null) {
				return null;
			}

			CreateUnspecifiedTypeRequest createReq = new CreateUnspecifiedTypeRequest( //
					Collections.singletonList(insertEP.getElementType()), getHostImpl().getDiagramPreferencesHint());
			
			Command result = insertEP.getCommand(createReq);
			if (result != null && result.canExecute()){
				result = new ICommandProxy(new ExecuteCreationAndReturnEObjectCommand(editingDomain, createReq, result));
			}
			return result;
		}

		return null;
	}
	
	protected IGraphicalEditPart getHostImpl(){
		return (IGraphicalEditPart) getHost();
	}
	
	/**
	 * InsertAction expects semantic EObject as a result of getInsertCommand(). 
	 * Unfortunately, what we have is the command that returns org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter  
	 */
	private static class ExecuteCreationAndReturnEObjectCommand extends AbstractTransactionalCommand {
		private final Command myActualCommand;
		private final CreateRequest myRequest;

		public ExecuteCreationAndReturnEObjectCommand(TransactionalEditingDomain domain, CreateRequest request, Command actualCommand){
			super(domain, actualCommand.getLabel(), null);
			myRequest = request;
			myActualCommand = actualCommand;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			myActualCommand.execute();
			EObject createdSemantic = unwrapToSemantic(myRequest);
			return CommandResult.newOKCommandResult(createdSemantic); 
		}
		
		@SuppressWarnings("unchecked")
		private EObject unwrapToSemantic(CreateRequest request){
			Object creationResult = request.getNewObject();
			if (creationResult instanceof List){
				creationResult = ((List)creationResult).get(0);
			}
			View createdView = null;
			if (creationResult instanceof IAdaptable){
				createdView = (View) ((IAdaptable)creationResult).getAdapter(View.class);
			}
			return createdView == null ? null : createdView.getElement();
		}
	}
	
}
