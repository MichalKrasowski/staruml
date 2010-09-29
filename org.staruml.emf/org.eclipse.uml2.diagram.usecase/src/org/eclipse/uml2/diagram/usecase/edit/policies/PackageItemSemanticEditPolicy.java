package org.eclipse.uml2.diagram.usecase.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorAsRectangleCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.CommentCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.ConstraintCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.DiagramHeaderCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.NestedPackageCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.SubjectCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.UseCaseAsClassCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.UseCaseCreateCommand;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;
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
		if (UMLElementTypes.Package_2001 == req.getElementType()) {
			return getGEFWrapper(new DiagramHeaderCreateCommand(req));
		}
		if (UMLElementTypes.Actor_2002 == req.getElementType()) {
			return getGEFWrapper(new ActorCreateCommand(req));
		}
		if (UMLElementTypes.Actor_2005 == req.getElementType()) {
			return getGEFWrapper(new ActorAsRectangleCreateCommand(req));
		}
		if (UMLElementTypes.UseCase_2003 == req.getElementType()) {
			return getGEFWrapper(new UseCaseCreateCommand(req));
		}
		if (UMLElementTypes.UseCase_2004 == req.getElementType()) {
			return getGEFWrapper(new UseCaseAsClassCreateCommand(req));
		}
		if (UMLElementTypes.Component_2006 == req.getElementType()) {
			return getGEFWrapper(new SubjectCreateCommand(req));
		}
		if (UMLElementTypes.Package_2007 == req.getElementType()) {
			return getGEFWrapper(new NestedPackageCreateCommand(req));
		}
		if (UMLElementTypes.Constraint_2008 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if (UMLElementTypes.Comment_2009 == req.getElementType()) {
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
