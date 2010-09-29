package org.eclipse.uml2.diagram.usecase.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IInsertableEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.compartments.U2TCompartmentFigure;
import org.eclipse.uml2.diagram.common.compartments.U2TResizableCompartmentEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.usecase.edit.policies.UseCaseAsClassExtensionPointsCanonicalEditPolicy;
import org.eclipse.uml2.diagram.usecase.edit.policies.UseCaseAsClassExtensionPointsItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.usecase.part.Messages;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class UseCaseAsClassExtensionPointsEditPart extends ListCompartmentEditPart implements IInsertableEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7003;

	/**
	 * @generated
	 */
	public UseCaseAsClassExtensionPointsEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.UseCaseAsClassExtensionPointsEditPart_title;
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure createFigure() {
		U2TCompartmentFigure result = new U2TCompartmentFigure(getCompartmentName(), getMapMode());

		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setStretchMajorAxis(false);
		layout.setStretchMinorAxis(false);
		layout.setMinorAlignment(ConstrainedToolbarLayout.ALIGN_TOPLEFT);
		result.getContentPane().setLayoutManager(layout);

		return result;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new U2TResizableCompartmentEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new UseCaseAsClassExtensionPointsItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(UMLVisualIDRegistry.TYPED_ADAPTER));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new UseCaseAsClassExtensionPointsCanonicalEditPolicy());
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, false));
		}

	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		// nothing to do -- parent layout does not accept Double constraints as ratio
		// super.setRatio(ratio); 
	}

	/**
	 * @generated
	 */
	public IElementType getElementType() {
		return UMLElementTypes.ExtensionPoint_3003;
	}

	/**
	 * @generated
	 */
	@Override
	protected void refreshVisibility() {
		boolean visibility = getNotationView().isVisible();
		if (visibility) {
			DrawerStyle style = (DrawerStyle) getNotationView().getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
			if (style != null && !style.isCollapsed()) {
				visibility &= !getChildren().isEmpty();
			}
		}
		setVisibility(visibility);
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		refreshVisibility();
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChild(EditPart child) {
		super.removeChild(child);
		if (isActive()) {
			refreshVisibility();
		}
	}

}
