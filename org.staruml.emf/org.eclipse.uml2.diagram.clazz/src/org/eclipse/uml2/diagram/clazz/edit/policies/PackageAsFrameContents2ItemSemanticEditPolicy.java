package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.clazz.edit.commands.Class5CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DataType3CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Enumeration3CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.InstanceSpecification3CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Package5CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PrimitiveType3CreateCommand;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageAsFrameContents2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageAsFrameContents2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_3032);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Package_3032 == req.getElementType()) {
			return getGEFWrapper(new Package5CreateCommand(req));
		}
		if (UMLElementTypes.Class_3033 == req.getElementType()) {
			return getGEFWrapper(new Class5CreateCommand(req));
		}
		if (UMLElementTypes.Enumeration_3034 == req.getElementType()) {
			return getGEFWrapper(new Enumeration3CreateCommand(req));
		}
		if (UMLElementTypes.InstanceSpecification_3035 == req.getElementType()) {
			return getGEFWrapper(new InstanceSpecification3CreateCommand(req));
		}
		if (UMLElementTypes.DataType_3036 == req.getElementType()) {
			return getGEFWrapper(new DataType3CreateCommand(req));
		}
		if (UMLElementTypes.PrimitiveType_3037 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveType3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
