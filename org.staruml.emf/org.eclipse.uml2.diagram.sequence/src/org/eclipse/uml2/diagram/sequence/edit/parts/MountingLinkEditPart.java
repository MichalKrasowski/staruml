package org.eclipse.uml2.diagram.sequence.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ViewComponentEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.draw2d.decoration.EllipseDecoration;
import org.eclipse.uml2.diagram.common.editpolicies.U2TGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDGraphicalNodeEditPolicy;

/**
 * @generated
 */

public class MountingLinkEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4002;

	/**
	 * @generated
	 */
	public MountingLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ViewComponentEditPolicy());
		removeEditPolicy(EditPolicyRoles.SEMANTIC_ROLE);
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SDGraphicalNodeEditPolicy());
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
		return new TopLevelMountingLinkFigure();
	}

	/**
	 * @generated
	 */
	public TopLevelMountingLinkFigure getPrimaryShape() {
		return (TopLevelMountingLinkFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class TopLevelMountingLinkFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public TopLevelMountingLinkFigure() {
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DASHDOT);
			this.setForegroundColor(ColorConstants.darkBlue);

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			EllipseDecoration df = new EllipseDecoration();

			df.setAlwaysFill(true);

			df.setPreferredSize(new Dimension(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			return df;
		}

	}

}
