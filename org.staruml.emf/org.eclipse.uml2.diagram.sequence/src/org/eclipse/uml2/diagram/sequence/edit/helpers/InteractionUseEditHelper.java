package org.eclipse.uml2.diagram.sequence.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */

public class InteractionUseEditHelper extends UMLBaseEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest request) {
		//CompositeCommand result = new CompositeCommand(request.getLabel());
		//result.add(CoveredLifelineConfigurer.configure(request));
		return CoveredLifelineConfigurer.configure(request);
	}
}
