package org.eclipse.uml2.diagram.profile.action;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.common.stereo.ProfileRegistry;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileEditPart;
import org.eclipse.uml2.diagram.profile.part.CustomMessages;
import org.eclipse.uml2.uml.Profile;

public class DefineProfileAction extends DiagramAction {
	private static final String UNDEFINED_LABEL = CustomMessages.DefineProfileAction_indefined;

	public DefineProfileAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		setText(calculateText());
	}

	@Override
	protected Command getCommand() {
		ProfileEditPart profileEditPart = getProfileEditPart();
		TransactionalEditingDomain editingDomain = profileEditPart.getEditingDomain();
		Profile profile = (Profile) profileEditPart.getNotationView().getElement();
		IEditCommandRequest request = new AbstractEditCommandRequest(editingDomain) {

			public Object getEditHelperContext() {
				// TODO Auto-generated method stub
				return null;
			}};
			
		Command command = new ICommandProxy(new DefineProfileCommand(CustomMessages.DefineProfileAction_define_profile_command, profile, request));
		return command;
	}


	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return getProfileEditPart() != null;
	}

	@Override
	public void refresh() {
		super.refresh();
		setText(calculateText());
	}
	
	private String calculateText() {
		ProfileEditPart profileEditPart = getProfileEditPart();
		if (profileEditPart == null) {
			return UNDEFINED_LABEL;
		}
		Profile profile = (Profile) profileEditPart.getNotationView().getElement();
		return (profile.isDefined())? CustomMessages.DefineProfileAction_redefine_action : CustomMessages.DefineProfileAction_define_action;
	}


	private ProfileEditPart getProfileEditPart() {
		for (Object next : getSelectedObjects()) {
			if (next instanceof ProfileEditPart) {
				ProfileEditPart profileEditPart = (ProfileEditPart)next;
				return profileEditPart;
			}
		}
		return null;
	}

	private class DefineProfileCommand extends EditElementCommand {
		
		Profile myProfile;

		protected DefineProfileCommand(String label, Profile elementToEdit, IEditCommandRequest request) {
			super(label, elementToEdit, request);
			myProfile = elementToEdit;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			myProfile.define();
			ProfileRegistry.getInstance().addProfile(myProfile);
			return CommandResult.newOKCommandResult(myProfile);
		}
		
	}

}
