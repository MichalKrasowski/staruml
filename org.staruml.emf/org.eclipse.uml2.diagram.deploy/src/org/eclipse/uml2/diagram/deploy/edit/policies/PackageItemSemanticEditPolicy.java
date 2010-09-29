package org.eclipse.uml2.diagram.deploy.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.uml2.diagram.deploy.edit.commands.Artifact2CreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.CommentCreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.DeploymentSpecificationCreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.DeviceCreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.ExecutionEnvironmentCreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.NodeCreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.PackageCreateCommand;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
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
			return getGEFWrapper(new PackageCreateCommand(req));
		}
		if (UMLElementTypes.Device_2003 == req.getElementType()) {
			return getGEFWrapper(new DeviceCreateCommand(req));
		}
		if (UMLElementTypes.Node_2004 == req.getElementType()) {
			return getGEFWrapper(new NodeCreateCommand(req));
		}
		if (UMLElementTypes.ExecutionEnvironment_2005 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEnvironmentCreateCommand(req));
		}
		if (UMLElementTypes.Artifact_2006 == req.getElementType()) {
			return getGEFWrapper(new Artifact2CreateCommand(req));
		}
		if (UMLElementTypes.DeploymentSpecification_2007 == req.getElementType()) {
			return getGEFWrapper(new DeploymentSpecificationCreateCommand(req));
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
