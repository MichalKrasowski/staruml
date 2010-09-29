package org.eclipse.uml2.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.editparts.NeedsParentEditPart;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.GateItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.sequence.frame.Frame;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */

public class GateEditPart extends AbstractBorderItemEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3005;

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
	public GateEditPart(View view) {
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
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GateItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SDGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
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
		GateFigure figure = new GateFigure();
		if (figure instanceof NeedsParentEditPart) {
			((NeedsParentEditPart) figure).hookParentEditPart((GraphicalEditPart) getParent());
		}
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public GateFigure getPrimaryShape() {
		return (GateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result;
		if (primaryShape instanceof Frame) {
			result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)) {

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
			result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8));
		}

		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
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
	 * Make sure that createNodeShape() is called before createNodePlate()
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
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.sequence.edit.parts.GateEditPart) {
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
		if (targetEditPart instanceof LifelineEditPart) {
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
	public class GateFigure extends Ellipse {

		/**
		 * @generated
		 */
		public GateFigure() {
			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
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
