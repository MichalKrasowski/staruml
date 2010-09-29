package org.eclipse.uml2.diagram.usecase.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.MultilineConstraintFigure;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.usecase.edit.policies.ConstraintItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ConstraintEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2008;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public ConstraintEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, true));
		}
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConstraintItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AsyncDiagramComponentEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ConstraintFigure figure = new ConstraintFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ConstraintFigure getPrimaryShape() {
		return (ConstraintFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ConstraintNameEditPart) {
			((ConstraintNameEditPart) childEditPart).setLabel(getPrimaryShape().getBodyLabel());
			return true;
		}
		if (childEditPart instanceof ConstraintLanguageEditPart) {
			((ConstraintLanguageEditPart) childEditPart).setLabel(getPrimaryShape().getLanguageLabel());
			return true;
		}
		return false;
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
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
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
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		// #265822 Improve appearance of selection feedback
		ResizableEditPolicy result = new U2TResizableShapeEditPolicy();
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		types.add(UMLElementTypes.Dependency_4006);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof DiagramHeaderEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof ActorAsRectangleEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof UseCaseAsClassEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof SubjectEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof NestedPackageEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof InnerUseCaseEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof ActorInPackageEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof UseCaseinPackageEditPart) {
			types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		}
		if (targetEditPart instanceof DiagramHeaderEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ActorAsRectangleEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof UseCaseAsClassEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof SubjectEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof NestedPackageEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof InnerUseCaseEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ActorInPackageEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof UseCaseinPackageEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4007) {
			types.add(UMLElementTypes.Comment_2009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Actor_2005);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.UseCase_2003);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Comment_2009);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Package_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel() && EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
		handleFeatureLinkModification(event);
	}

	/**
	 * @generated
	 */
	private void handleFeatureLinkModification(Notification event) {
		if (event.getFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
			guardedRefreshDiagram();
			return;
		}
	}

	/**
	 * @generated
	 */
	private boolean isCanonicalDisabled() {
		if (isCanonicalDisabled(getEditPolicy(EditPolicyRoles.CANONICAL_ROLE))) {
			return true;
		}
		if (getParent() != null && isCanonicalDisabled(getParent().getEditPolicy(EditPolicyRoles.CANONICAL_ROLE))) {
			return true;
		}
		//this particular edit part may not have editpolicy at all, 
		//but its compartments still may have it
		EObject semantic = resolveSemanticElement();
		if (semantic != null) {
			for (Object next : CanonicalEditPolicy.getRegisteredEditPolicies(semantic)) {
				if (next instanceof EditPolicy) {
					EditPolicy nextEP = (EditPolicy) next;
					if (isCanonicalDisabled(nextEP)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static boolean isCanonicalDisabled(EditPolicy editPolicy) {
		return editPolicy instanceof CanonicalEditPolicy && !((CanonicalEditPolicy) editPolicy).isEnabled();
	}

	/**
	 * @generated
	 */
	private void guardedRefreshDiagram() {
		if (!isCanonicalDisabled()) {
			UMLDiagramUpdateCommand.performCanonicalUpdate(getDiagramView().getElement());
		}
	}

	/**
	 * @generated
	 */
	public class ConstraintFigure extends MultilineConstraintFigure {

		/**
		 * @generated
		 */
		public ConstraintFigure() {

			this.setTextLabelWrap(true);

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

		/**
		 * @generated
		 */
		public WrappingLabel getBodyLabel() {
			return super.getBodyLabel();
		}

		/**
		 * @generated
		 */
		public WrappingLabel getLanguageLabel() {
			return super.getLanguageLabel();
		}

	}

}
