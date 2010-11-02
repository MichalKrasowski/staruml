package org.eclipse.uml2.diagram.common.stereo;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.stereo.ProfileRegistry.ProfileInfo;
import org.eclipse.uml2.uml.Profile;

public class ApplyProfileInfoAction extends ApplyProfileAction {
	private ProfileInfo myProfileInfo;

	public ApplyProfileInfoAction(IWorkbenchPage workbenchPage, org.eclipse.uml2.uml.Package package_, ProfileInfo profileInfo) {
		super(workbenchPage, package_, null);
		myProfileInfo = profileInfo;
	}

	@Override
	protected String calculateText() {
		String name = myProfileInfo.name;
		return name != null ? name : EMPTY_NAME;
	}

	@Override
	protected boolean calculateChecked() {
		return false;
	}
	
	@Override
	public boolean isEnabled() {
		return !myProfileInfo.isBroken;
	}

	@Override
	protected ApplyProfileCommand getApplyProfileCommand(IEditCommandRequest request) {
		return new ApplyProfileInfoCommand(Messages.ApplyProfileAction_apply_profile_command, myPackage, myProfileInfo, request);
	}

	private class ApplyProfileInfoCommand extends ApplyProfileCommand {
		
		org.eclipse.uml2.uml.Package myPackage;
		private ProfileInfo myProfileInfo;

		protected ApplyProfileInfoCommand(String label, org.eclipse.uml2.uml.Package package_, ProfileInfo profileinfo, IEditCommandRequest request) {
			super(label, package_, null, request);
			myPackage = package_;
			myProfileInfo = profileinfo;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			Profile profile = getProfile();
			if (profile == null) {
				return CommandResult.newErrorCommandResult(Messages.ApplyProfileInfoAction_command_result_could_note_load_profile + myProfileInfo.uri);
			}
			myPackage.applyProfile(profile);
			return CommandResult.newOKCommandResult(profile);
		}

		private Profile getProfile() {
			return myProfileInfo.getProfile(myPackage.eResource());
		}
		
	}
}
