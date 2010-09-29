package org.eclipse.uml2.diagram.csd.edit.parts;

import java.util.Iterator;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.diagram.common.draw2d.AssociationLinkFigureBase;
import org.eclipse.uml2.diagram.csd.edit.policies.AssociationItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class AssociationEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4011;

	/**
	 * @generated
	 */
	public AssociationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AssociationItemSemanticEditPolicy());
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

	protected Connection createConnectionFigureGen() {
		return new AssociationLinkFigure();
	}

	/**
	 * @generated NOT
	 */
	protected Connection createConnectionFigure() {
		Connection result = createConnectionFigureGen();
		refreshDecorations((AssociationLinkFigure) result);
		return result;
	}

	/**
	 * @generated
	 */
	public AssociationLinkFigure getPrimaryShape() {
		return (AssociationLinkFigure) getFigure();
	}

	/**
	 * @NOT-GENERATED
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		Association association = (Association) resolveSemanticElement();
		for (Iterator ends = association.getMemberEnds().iterator(); ends.hasNext();) {
			Property next = (Property) ends.next();
			addListenerFilter("SemanticModel", this, next);
		}
	}

	/**
	 * @NOT-GENERATED
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (notification.getNotifier() instanceof Property) {
			refreshDecorations((AssociationLinkFigure) getConnectionFigure());
		}
	}

	/**
	 * @NOT-GENERATED
	 */
	private void refreshDecorations(AssociationLinkFigure linkFigure) {
		Association association = (Association) resolveSemanticElement();
		if (association == null || !association.isBinary()) {
			return;
		}
		Property sourceEnd = AssociationEndConvention.getSourceEnd(association);
		Property targetEnd = AssociationEndConvention.getTargetEnd(association);

		IPreferenceStore store = (IPreferenceStore) getDiagramPreferencesHint().getPreferenceStore();

		linkFigure.getSourceDecorationImpl().update(association, sourceEnd, targetEnd, store);
		linkFigure.getTargetDecorationImpl().update(association, targetEnd, sourceEnd, store);
	}

	/**
	 * @generated
	 */
	public class AssociationLinkFigure extends AssociationLinkFigureBase {

		/**
		 * @generated
		 */
		public AssociationLinkFigure() {

			this.setForegroundColor(ColorConstants.blue);
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}
	}

}
