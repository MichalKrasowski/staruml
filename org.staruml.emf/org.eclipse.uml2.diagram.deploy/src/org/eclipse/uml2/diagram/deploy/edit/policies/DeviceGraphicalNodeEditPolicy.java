package org.eclipse.uml2.diagram.deploy.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.diagram.deploy.edit.commands.UMLReorientConnectionViewCommand;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;

/**
 * @generated
 */
public class DeviceGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * @generated
	 */
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		IElementType elementType = getElementType(request);
		if (UMLElementTypes.Deployment_4001 == elementType) {
			if (request.getSourceEditPart() != getHost()) {
				return getConnectionWithReorientedViewCompleteCommand(request);
			}
		}
		return super.getConnectionCompleteCommand(request);
	}

	/**
	 * @generated
	 */
	protected IElementType getElementType(CreateConnectionRequest request) {
		if (request instanceof CreateConnectionViewAndElementRequest) {
			CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest) request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
			return (IElementType) requestAdapter.getAdapter(IElementType.class);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConnectionWithReorientedViewCompleteCommand(CreateConnectionRequest request) {
		ICommandProxy c = (ICommandProxy) super.getConnectionCompleteCommand(request);
		CompositeCommand cc = (CompositeCommand) c.getICommand();
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		UMLReorientConnectionViewCommand rcvCommand = new UMLReorientConnectionViewCommand(editingDomain, null);
		rcvCommand.setEdgeAdaptor(getViewAdapter());
		cc.compose(rcvCommand);
		return c;
	}
}
