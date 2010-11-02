package org.eclipse.uml2.diagram.common.async;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.editpolicies.InsertingComponentEditPolicy;

public class AsyncDiagramComponentEditPolicy extends InsertingComponentEditPolicy {

	public AsyncDiagramComponentEditPolicy(boolean forListItem){
		super(forListItem);
	}
	
	public AsyncDiagramComponentEditPolicy(){
		this(false);
	}

	@Override
	public Command getCommand(Request request) {
		if (!(request instanceof GroupRequest)) {
			return null;
		}
		if (request instanceof AsyncDiagramDeleteRequest) {
			AsyncDiagramDeleteRequest reqImpl = (AsyncDiagramDeleteRequest) request;
			switch (reqImpl.getKind()) {
			case LET_TARGET_DECIDE:
				return getDeleteCommand(reqImpl);
			case SEMANTIC_AND_NOTATION:
				return createDeleteSemanticCommand(reqImpl);
			case NOTATION_ONLY:
				return createSwitchSyncAndDeleteViewCommand(reqImpl);
			default:
				throw new IllegalArgumentException("Unknown kind: " + reqImpl.getKind()); //$NON-NLS-1$
			}
		}
		return super.getCommand(request);
	}
	

	private Command createSwitchSyncAndDeleteViewCommand(AsyncDiagramDeleteRequest req) {
		TransactionalEditingDomain editingDomain = getHostImpl().getEditingDomain();
		List<?> toDel = req.getEditParts();
		if (toDel == null || toDel.isEmpty()) {
			return new ICommandProxy(//
					doCreateSwitchSyncAndDeleteViewCommand(editingDomain, getHostImpl()));
		} 
		
		CompositeCommand cc = new CompositeCommand(StringStatics.BLANK);
		for (Object next : toDel) {
			IGraphicalEditPart nextEP = (IGraphicalEditPart) next;
			cc.compose(doCreateSwitchSyncAndDeleteViewCommand(editingDomain, nextEP));
		}
		return new ICommandProxy(cc.reduce());
	}
	
	private ICommand doCreateSwitchSyncAndDeleteViewCommand(TransactionalEditingDomain domain, IGraphicalEditPart editPart){
		EditPart parentEP = editPart.getParent();
		ICommand switchCommand = null;
		if (parentEP instanceof IGraphicalEditPart){
			View parentView = ((IGraphicalEditPart)parentEP).getNotationView();
			if (getCanonicalHelper().isAutoSynchronized(parentView)){
				switchCommand = new SwitchSyncModeCommand(domain, parentView, false);
			}
		}
		DeleteCommand deleteCommand = new DeleteCommand(domain, editPart.getNotationView());
		if (switchCommand == null){
			return deleteCommand;
		} 
		CompositeCommand result = new CompositeCommand(deleteCommand.getLabel());
		return result.compose(switchCommand).compose(deleteCommand);
	}
	
	private ICanonicalHelper getCanonicalHelper(){
		return ICanonicalHelper.IMPLEMENTATION;
	}
	
	
}
