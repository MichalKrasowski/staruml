package org.eclipse.uml2.diagram.component.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.uml2.diagram.component.edit.commands.Artifact2CreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.Class2CreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.ClassDiagramNotationClassCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.CommentCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.ComponentCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.Interface2CreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.Package2CreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.PackageCreateCommand;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
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
		if (UMLElementTypes.Component_2001 == req.getElementType()) {
			return getGEFWrapper(new ComponentCreateCommand(req));
		}
		if (UMLElementTypes.Artifact_2002 == req.getElementType()) {
			return getGEFWrapper(new Artifact2CreateCommand(req));
		}
		if (UMLElementTypes.Interface_2003 == req.getElementType()) {
			return getGEFWrapper(new Interface2CreateCommand(req));
		}
		if (UMLElementTypes.Class_2004 == req.getElementType()) {
			return getGEFWrapper(new Class2CreateCommand(req));
		}
		if (UMLElementTypes.Package_2005 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommand(req));
		}
		if (UMLElementTypes.Package_2006 == req.getElementType()) {
			return getGEFWrapper(new Package2CreateCommand(req));
		}
		if (UMLElementTypes.Class_2007 == req.getElementType()) {
			return getGEFWrapper(new ClassDiagramNotationClassCreateCommand(req));
		}
		if (UMLElementTypes.Comment_2008 == req.getElementType()) {
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
