package org.eclipse.uml2.diagram.profile.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.uml2.diagram.profile.edit.commands.CommentCreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.Constraint2CreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.ElementImportCreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.EnumerationCreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.Profile2CreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.ProfileCreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.StereotypeCreateCommand;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ProfileItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ProfileItemSemanticEditPolicy() {
		super(UMLElementTypes.Profile_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Stereotype_2001 == req.getElementType()) {
			return getGEFWrapper(new StereotypeCreateCommand(req));
		}
		if (UMLElementTypes.Profile_2002 == req.getElementType()) {
			return getGEFWrapper(new ProfileCreateCommand(req));
		}
		if (UMLElementTypes.Enumeration_2003 == req.getElementType()) {
			return getGEFWrapper(new EnumerationCreateCommand(req));
		}
		if (UMLElementTypes.ElementImport_2006 == req.getElementType()) {
			return getGEFWrapper(new ElementImportCreateCommand(req));
		}
		if (UMLElementTypes.Profile_2007 == req.getElementType()) {
			return getGEFWrapper(new Profile2CreateCommand(req));
		}
		if (UMLElementTypes.Constraint_2008 == req.getElementType()) {
			return getGEFWrapper(new Constraint2CreateCommand(req));
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
