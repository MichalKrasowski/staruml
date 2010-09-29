package org.eclipse.uml2.diagram.clazz.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.uml2.diagram.common.commands.ChangeAssociationKindCommand;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;

/**
 * @generated
 */
public class AssociationEditHelper extends UMLBaseEditHelper {

	/**
	 * @NOT-generated
	 */
	public static final String PARAMETER_CONFIGURE_AGGREGATION_KIND = AssociationEditHelper.class.getName() + ":ConfigureAggregationKind"; //$NON-NLS-1$

	/**
	 * @NOT-generated
	 */
	public static final String PARAMETER_SET_TARGET_NAVIGABILITY = AssociationEditHelper.class.getName() + ":ConfigureTargetNavigability"; //$NON-NLS-1$

	/**
	 * @NOT-generated
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest req) {
		if (req.getElementToConfigure() instanceof Association && req.getParameter(PARAMETER_CONFIGURE_AGGREGATION_KIND) instanceof AggregationKind) {
			ChangeAssociationKindCommand changeAssociation = new ChangeAssociationKindCommand( //
					(Association) req.getElementToConfigure(), (AggregationKind) req.getParameter(PARAMETER_CONFIGURE_AGGREGATION_KIND));
			return changeAssociation;
		}
		return null;
	}

}