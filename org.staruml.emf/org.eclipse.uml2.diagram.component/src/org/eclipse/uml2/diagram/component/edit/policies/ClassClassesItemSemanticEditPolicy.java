package org.eclipse.uml2.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.component.edit.commands.ClassDiagramNotationInnerClassCreateCommand;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ClassClassesItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassClassesItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Class_3013 == req.getElementType()) {
			return getGEFWrapper(new ClassDiagramNotationInnerClassCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
