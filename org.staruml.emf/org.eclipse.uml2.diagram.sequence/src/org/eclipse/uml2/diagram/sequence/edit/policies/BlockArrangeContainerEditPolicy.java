package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;


public class BlockArrangeContainerEditPolicy extends ContainerEditPolicy {
	@Override
	protected Command getArrangeCommand(ArrangeRequest request) {
		return null;
	}
	
	
}
