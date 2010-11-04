package org.eclipse.uml2.diagram.component.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.draw2d.decoration.AssemblyConnectorEndDecoration;
import org.eclipse.uml2.diagram.common.editpolicies.U2TGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.component.edit.policies.AssemblyConnectorEndRoleItemSemanticEditPolicy;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;

/**
 * @generated
 */
public class AssemblyConnectorEndRoleEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4010;

	/**
	 * @generated
	 */
	public AssemblyConnectorEndRoleEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AssemblyConnectorEndRoleItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new U2TGraphicalNodeEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigureGen() {
		return new AssemblyConnectorConnection();
	}

	/**
	 * @generated NOT
	 */
	protected Connection createConnectionFigure() {
		Connection result = createConnectionFigureGen();
		refreshDecorations(result);
		return result;
	}

	/**
	 * @generated
	 */
	public AssemblyConnectorConnection getPrimaryShape() {
		return (AssemblyConnectorConnection) getFigure();
	}

	/**
	 * @NOT-GENERATED
	 */
	private void refreshDecorations(Connection connection) {
		AssemblyConnectorConnection linkFigure = (AssemblyConnectorConnection) connection;
		Edge edge = getEdge();
		View sourceView = edge.getSource();
		View targetView = edge.getTarget();
		if (sourceView == null || targetView == null) {
			return;
		}

		EObject source = sourceView.getElement();
		EObject target = targetView.getElement();

		if (source instanceof Connector && target instanceof ConnectableElement) {
			linkFigure.getSourceDecorationImpl().updateWithEnd((Connector) source, (ConnectableElement) target);
		}
	}

	/**
	 * @generated
	 */
	public class AssemblyConnectorConnection extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public AssemblyConnectorConnection() {
			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.blue);

			setSourceDecoration(createSourceDecoration());
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createSourceDecoration() {
			AssemblyConnectorEndDecoration df = new AssemblyConnectorEndDecoration();

			df.setRadius(10);

			return df;
		}

		/**
		 * @NOT-GENERATED
		 */
		public AssemblyConnectorEndDecoration getSourceDecorationImpl() {
			return (AssemblyConnectorEndDecoration) getSourceDecoration();
		}

	}

}
