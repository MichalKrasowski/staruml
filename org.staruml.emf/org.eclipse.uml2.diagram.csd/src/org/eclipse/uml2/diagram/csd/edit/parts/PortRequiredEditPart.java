package org.eclipse.uml2.diagram.csd.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.draw2d.RequiredInterfaceDecoration;
import org.eclipse.uml2.diagram.csd.edit.policies.PortRequiredItemSemanticEditPolicy;

/**
 * @generated
 */
public class PortRequiredEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4014;

	/**
	 * @generated
	 */
	public PortRequiredEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PortRequiredItemSemanticEditPolicy());
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
		return new RequiredInterfaceConnectionFigure();
	}

	/**
	 * @generated
	 */
	public RequiredInterfaceConnectionFigure getPrimaryShape() {
		return (RequiredInterfaceConnectionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class RequiredInterfaceConnectionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public RequiredInterfaceConnectionFigure() {
			this.setLineWidth(1);

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			RequiredInterfaceDecoration df = new RequiredInterfaceDecoration();

			df.setRadius(10);

			return df;
		}

	}

}
