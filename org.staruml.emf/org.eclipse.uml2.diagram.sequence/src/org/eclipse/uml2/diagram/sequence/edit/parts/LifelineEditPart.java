package org.eclipse.uml2.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.editparts.NeedsParentEditPart;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.layered.MultiLayeredContainer;
import org.eclipse.uml2.diagram.common.layered.MultilayeredFigure;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateCombinedFragmentEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateInteractionUseEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateStateInvariantEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.create.TieInteractionUseToLifeLineEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.LifelineCanonicalEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.LifelineItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDCreationEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDXYLayoutEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.TieFrameTargetEditPolicy;
import org.eclipse.uml2.diagram.sequence.figures.LifelineViewMap;
import org.eclipse.uml2.diagram.sequence.frame.Frame;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class LifelineEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

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
	public LifelineEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, true));
		}
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new SDCreationEditPolicy(UMLVisualIDRegistry.TYPED_ADAPTER));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LifelineItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SDGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new LifelineCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SDGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new SDCreationEditPolicy());
		installEditPolicy("SD-Create-InteractionUse", new CreateInteractionUseEditPolicy()); //$NON-NLS-1$
		installEditPolicy("SD-Create-CombinedFragment", new CreateCombinedFragmentEditPolicy()); //$NON-NLS-1$
		installEditPolicy("SD-Create-StateInvariant", new CreateStateInvariantEditPolicy()); //$NON-NLS-1$
		installEditPolicy(TieFrameTargetEditPolicy.ROLE, new TieFrameTargetEditPolicy());
		installEditPolicy(TieFrameTargetEditPolicy.ROLE + "-InteractionUse", new TieInteractionUseToLifeLineEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated NOT
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		return new SDXYLayoutEditPolicy();
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		CustomLifeLineFigure figure = new CustomLifeLineFigure();
		if (figure instanceof NeedsParentEditPart) {
			((NeedsParentEditPart) figure).hookParentEditPart((GraphicalEditPart) getParent());
		}
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public CustomLifeLineFigure getPrimaryShape() {
		return (CustomLifeLineFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		return new SDResizableShapeEditPolicy();
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LifelineNameEditPart) {
			((LifelineNameEditPart) childEditPart).setLabel(getPrimaryShape().getLifelineIdentLabel());
			return true;
		}
		if (childEditPart instanceof LifelineRefLabelEditPart) {
			((LifelineRefLabelEditPart) childEditPart).setLabel(getPrimaryShape().getLifelineDecomposedAsLabel());
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
		if (addMultiLayeredChildVisual(childEditPart)) {
			return;
		}
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	private boolean addMultiLayeredChildVisual(EditPart childEditPart) {
		if (false == childEditPart instanceof PrimaryShapeEditPart) {
			return false;
		}
		PrimaryShapeEditPart childImpl = (PrimaryShapeEditPart) childEditPart;
		childImpl.getFigure(); //activates viewmap
		if (childImpl.getPrimaryShape() instanceof MultilayeredFigure) {
			MultiLayeredContainer multiLayeredContainer = getMultiLayeredContainer(this);
			if (multiLayeredContainer != null) {
				((MultilayeredFigure) childImpl.getPrimaryShape()).getMultilayeredSupport().addToLayers(multiLayeredContainer);
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static MultiLayeredContainer getMultiLayeredContainer(PrimaryShapeEditPart editPart) {
		if (editPart.getPrimaryShape() instanceof MultiLayeredContainer) {
			return (MultiLayeredContainer) editPart.getPrimaryShape();
		}
		EditPart parentEP = editPart.getParent();
		if (false == parentEP instanceof PrimaryShapeEditPart) {
			//throw new IllegalStateException("PrimaryShapeEditPart expected: " + parentEP);
			return null;
		}
		return getMultiLayeredContainer((PrimaryShapeEditPart) parentEP);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeMultiLayeredChildVisual(childEditPart)) {
			return;
		}
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	private boolean removeMultiLayeredChildVisual(EditPart childEditPart) {
		if (false == childEditPart instanceof PrimaryShapeEditPart) {
			return false;
		}
		PrimaryShapeEditPart childImpl = (PrimaryShapeEditPart) childEditPart;
		childImpl.getFigure(); //activates viewmap
		if (childImpl.getPrimaryShape() instanceof MultilayeredFigure) {
			MultiLayeredContainer multiLayeredContainer = getMultiLayeredContainer(this);
			if (multiLayeredContainer != null) {
				((MultilayeredFigure) childImpl.getPrimaryShape()).getMultilayeredSupport().removeFromLayers(multiLayeredContainer);
				return true;
			}
		}
		return false;
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
		DefaultSizeNodeFigure result;
		if (primaryShape instanceof Frame) {
			result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(60), getMapMode().DPtoLP(120)) {

				@Override
				public IFigure findFigureAt(int x, int y, TreeSearch search) {
					IFigure f = super.findFigureAt(x, y, search);
					if (f == this) {
						return null;
					}
					return f;
				}
			};
		} else {
			result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(60), getMapMode().DPtoLP(120));
		}
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
		IFigure shape = createNodeShape();
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * 
	 * @generated NOT
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return ((CustomLifeLineFigure) nodeShape).getTail();
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Message_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof GateEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof LayeredInteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof LayeredCombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof LayeredOperandEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof InteractionUseMountingRegionEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof CombinedFragmentMountingRegionEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		if (targetEditPart instanceof InteractionOperandMountingRegionEditPart) {
			types.add(UMLElementTypes.Message_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.Gate_3005);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.InteractionUse_3007);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.CombinedFragment_3008);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.InteractionOperand_3009);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3002);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.StateInvariant_3003);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3004);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.InteractionUse_3006);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.CombinedFragment_3010);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.InteractionOperand_3011);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Message_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.Gate_3005);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.InteractionUse_3007);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.CombinedFragment_3008);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.InteractionOperand_3009);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3002);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.StateInvariant_3003);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3004);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.InteractionUse_3006);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.CombinedFragment_3010);
		}
		if (relationshipType == UMLElementTypes.Message_4001) {
			types.add(UMLElementTypes.InteractionOperand_3011);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	public class CustomLifeLineFigure extends LifelineViewMap.LifelineShape {

		/**
		 * @generated
		 */
		public CustomLifeLineFigure() {

			this.setDecomposedAsBlockVisible(false);

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
		public LifelineViewMap.LifelineHeadShape getLifelineHead() {
			return getHead();
		}

		/**
		 * @generated
		 */
		public LifelineViewMap.LifelineTailShape getLifelineTail() {
			return getTail();
		}

		/**
		 * @generated
		 */
		public Label getLifelineIdentLabel() {
			return super.getLifelineIdentLabel();
		}

		/**
		 * @generated
		 */
		public Label getLifelineStereotypesLabel() {
			return super.getLifelineStereotypesLabel();
		}

		/**
		 * @generated
		 */
		public Label getLifelineDecomposedAsLabel() {
			return super.getLifelineDecomposedAsLabel();
		}

		/**
		 * @generated
		 */
		public Label getLifelineRefLabel() {
			return super.getLifelineRefLabel();
		}

	}

}
