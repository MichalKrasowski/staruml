package org.eclipse.uml2.diagram.common.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;


public abstract class UMLDiagramAction2 extends UMLDiagramAction {

	@Override
	protected Command getCommand(IGraphicalEditPart ep) {
		final EObject element = ep.getNotationView().getElement();		
		AbstractTransactionalCommand c = new AbstractTransactionalCommand(ep.getEditingDomain(), getCommandLabel(), null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				run(element);
				return null;
			}};
		return new ICommandProxy(c);
	}
	
	protected abstract void run(EObject element);
	
	protected String getCommandLabel() {
		return StringStatics.BLANK;
	}

}
