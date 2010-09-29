package org.eclipse.uml2.diagram.deploy.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.deploy.edit.commands.ArtifactCreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.Device2CreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.ExecutionEnvironment2CreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.Node2CreateCommand;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class DeviceDevicecontentsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DeviceDevicecontentsItemSemanticEditPolicy() {
		super(UMLElementTypes.Device_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Device_3004 == req.getElementType()) {
			return getGEFWrapper(new Device2CreateCommand(req));
		}
		if (UMLElementTypes.Artifact_3002 == req.getElementType()) {
			return getGEFWrapper(new ArtifactCreateCommand(req));
		}
		if (UMLElementTypes.ExecutionEnvironment_3005 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEnvironment2CreateCommand(req));
		}
		if (UMLElementTypes.Node_3007 == req.getElementType()) {
			return getGEFWrapper(new Node2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
