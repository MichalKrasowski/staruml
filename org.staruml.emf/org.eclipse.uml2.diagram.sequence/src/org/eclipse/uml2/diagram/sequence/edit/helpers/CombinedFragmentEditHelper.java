package org.eclipse.uml2.diagram.sequence.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */

public class CombinedFragmentEditHelper extends UMLBaseEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		ICommand coveredLifeLine = CoveredLifelineConfigurer.configure(req);
		ICommand kind = InteractionOperatorKindConfigurer.configure(req);

		if (coveredLifeLine == null && kind == null) {
			return null;
		}

		CompositeCommand result = new CompositeCommand(req.getLabel());
		if (coveredLifeLine != null) {
			result.add(coveredLifeLine);
		}
		if (kind != null) {
			result.add(kind);
		}
		return result.reduce();
	}
}
