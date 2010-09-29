package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.clazz.edit.commands.AssociationClassCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.ClassCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DataTypeCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.EnumerationCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Interface3CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PrimitiveTypeCreateCommand;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageClassifiersItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageClassifiersItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Class_3007 == req.getElementType()) {
			return getGEFWrapper(new ClassCreateCommand(req));
		}
		if (UMLElementTypes.DataType_3008 == req.getElementType()) {
			return getGEFWrapper(new DataTypeCreateCommand(req));
		}
		if (UMLElementTypes.PrimitiveType_3009 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveTypeCreateCommand(req));
		}
		if (UMLElementTypes.Enumeration_3011 == req.getElementType()) {
			return getGEFWrapper(new EnumerationCreateCommand(req));
		}
		if (UMLElementTypes.AssociationClass_3012 == req.getElementType()) {
			return getGEFWrapper(new AssociationClassCreateCommand(req));
		}
		if (UMLElementTypes.Interface_3041 == req.getElementType()) {
			return getGEFWrapper(new Interface3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
