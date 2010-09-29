package org.eclipse.uml2.diagram.csd.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.uml2.diagram.csd.edit.commands.Class3CreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.ClassCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.CollaborationCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.CommentCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.ConstraintCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.InstanceSpecificationCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.InterfaceCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.PackageCreateCommand;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Collaboration_2005 == req.getElementType()) {
			return getGEFWrapper(new CollaborationCreateCommand(req));
		}
		if (UMLElementTypes.Class_2006 == req.getElementType()) {
			return getGEFWrapper(new ClassCreateCommand(req));
		}
		if (UMLElementTypes.Package_2003 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommand(req));
		}
		if (UMLElementTypes.Class_2007 == req.getElementType()) {
			return getGEFWrapper(new Class3CreateCommand(req));
		}
		if (UMLElementTypes.Interface_2009 == req.getElementType()) {
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if (UMLElementTypes.InstanceSpecification_2011 == req.getElementType()) {
			return getGEFWrapper(new InstanceSpecificationCreateCommand(req));
		}
		if (UMLElementTypes.Constraint_2012 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if (UMLElementTypes.Comment_2013 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
