package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class GeneralizationGeneralItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public GeneralizationGeneralItemSemanticEditPolicy() {
		super(UMLElementTypes.GeneralizationGeneral_4012);
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return UnexecutableCommand.INSTANCE;
	}
}
