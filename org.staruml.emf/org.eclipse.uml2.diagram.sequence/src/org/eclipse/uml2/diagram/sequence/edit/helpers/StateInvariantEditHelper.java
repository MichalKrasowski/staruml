package org.eclipse.uml2.diagram.sequence.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */

public class StateInvariantEditHelper extends UMLBaseEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		return CoveredLifelineConfigurer.configure(req);
	}
}
