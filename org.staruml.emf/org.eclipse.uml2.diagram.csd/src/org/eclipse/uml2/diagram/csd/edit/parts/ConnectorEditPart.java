package org.eclipse.uml2.diagram.csd.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.csd.edit.policies.ConnectorItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ConnectorEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4005;

	/**
	 * @generated
	 */
	public ConnectorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConnectorItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new PolylineConnectionEx();
	}

	/**
	 * @generated
	 */
	public PolylineConnectionEx getPrimaryShape() {
		return (PolylineConnectionEx) getFigure();
	}

	/**
	 * @NOT-GENERATED
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		Connector c = (Connector) resolveSemanticElement();
		addListenerFilter("SemanticModel_TypeListener", this, c, UMLPackage.eINSTANCE.getConnector_Type());
	}

	/**
	 * @NOT-GENERATED
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (UMLPackage.eINSTANCE.getConnector_Type().equals(notification.getFeature())) {
			refreshConnectorTypeColor(getPrimaryShape());
		}
	}

	/**
	 * @NOT-GENERATED
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshConnectorTypeColor(getPrimaryShape());
	}

	/**
	 * @NOT-GENERATED
	 */
	private void refreshConnectorTypeColor(Connection connectorFigure) {
		Connector c = (Connector) resolveSemanticElement();
		if (c == null) {
			return;
		}
		if (c.getType() != null) {
			connectorFigure.setForegroundColor(ColorConstants.blue);
		} else {
			connectorFigure.setForegroundColor(ColorConstants.black);
		}
	}

}
