package org.eclipse.uml2.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.component.edit.commands.ClassDiagramNotationOperationCreateCommand;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ClassOperationsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassOperationsItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Operation_3012 == req.getElementType()) {
			return getGEFWrapper(new ClassDiagramNotationOperationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
