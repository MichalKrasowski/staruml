package org.eclipse.uml2.diagram.common.async;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

public class SwitchSyncModeCommand extends AbstractTransactionalCommand {
	private final List<View> myViews;
	private final boolean myEnableNotDisable;

	public SwitchSyncModeCommand(TransactionalEditingDomain domain, List<View> views, boolean enableNotDisable){
		super(domain, StringStatics.BLANK, getWorkspaceFiles(views));
		myViews = views;
		myEnableNotDisable = enableNotDisable;
	}
	
	public SwitchSyncModeCommand(TransactionalEditingDomain domain, View view, boolean enableNotDisable){
		this(domain, Collections.singletonList(view), enableNotDisable);
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		for (View next : myViews){
			ICanonicalHelper.IMPLEMENTATION.setAutoSynchronized(next, myEnableNotDisable);
		}
		return CommandResult.newOKCommandResult();
	}
}