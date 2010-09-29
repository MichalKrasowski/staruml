package org.eclipse.uml2.diagram.sequence.model;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle;


class InvalidateSDModelCommand extends AbstractTransactionalCommand {
	private final View myView;

	public InvalidateSDModelCommand(View view){
		this(TransactionUtil.getEditingDomain(view), view);
	}
	
	public InvalidateSDModelCommand(IGraphicalEditPart editPart){
		this(editPart.getEditingDomain(), editPart.getNotationView());
	}

	public InvalidateSDModelCommand(TransactionalEditingDomain domain, View view){
		super(domain, StringStatics.BLANK, getWorkspaceFiles(view));
		myView = view;
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		doInvalidateModel();
		return CommandResult.newOKCommandResult();
	}
	
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus result = super.doRedo(monitor, info);
		doInvalidateModel();
		return result;
	}
	
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus result = super.doUndo(monitor, info);
		doInvalidateModel();
		return result;
	}
	
	private void doInvalidateModel(){
		if (myView.getDiagram() != null){
			SDModelStorageStyle accessor = SDModelAccess.findSDModelAccessor(myView);
			if (accessor != null){
				accessor.invalidateModel();
			}
		}
		//System.out.println("SDModel invalidated");
	}
	
}
