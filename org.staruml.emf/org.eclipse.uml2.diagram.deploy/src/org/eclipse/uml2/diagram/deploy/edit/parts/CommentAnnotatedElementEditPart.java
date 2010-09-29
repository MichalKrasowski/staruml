package org.eclipse.uml2.diagram.deploy.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.deploy.edit.policies.CommentAnnotatedElementItemSemanticEditPolicy;

/**
 * @generated
 */

public class CommentAnnotatedElementEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4006;

	/**
	 * @generated
	 */
	public CommentAnnotatedElementEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CommentAnnotatedElementItemSemanticEditPolicy());
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
		return new AnnotatedElementLinkFigure();
	}

	/**
	 * @generated
	 */
	public AnnotatedElementLinkFigure getPrimaryShape() {
		return (AnnotatedElementLinkFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class AnnotatedElementLinkFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public AnnotatedElementLinkFigure() {
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DOT);

		}

	}

}
