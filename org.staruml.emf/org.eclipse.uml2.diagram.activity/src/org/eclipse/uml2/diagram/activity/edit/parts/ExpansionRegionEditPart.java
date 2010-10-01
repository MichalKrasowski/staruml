package org.eclipse.uml2.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.activity.edit.policies.ExpansionRegionCanonicalEditPolicy;
import org.eclipse.uml2.diagram.activity.edit.policies.ExpansionRegionItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class ExpansionRegionEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3084;

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
	private LinkTargetListener myLinkTargetListener;

	/**
	 * @generated
	 */
	public ExpansionRegionEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ExpansionRegionItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ExpansionRegionCanonicalEditPolicy());
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
		ExpansionRegionFigure figure = new ExpansionRegionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ExpansionRegionFigure getPrimaryShape() {
		return (ExpansionRegionFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ExpansionRegionModeEditPart) {
			((ExpansionRegionModeEditPart) childEditPart).setLabel(getPrimaryShape().getFigureExpansionRegionFigure_keyword());
			return true;
		}
		if (childEditPart instanceof ExpansionRegionNodeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureExpansionRegionFigure_ContentPane();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ExpansionRegionNodeCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ExpansionRegionNodeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureExpansionRegionFigure_ContentPane();
			pane.remove(((ExpansionRegionNodeCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
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
		if (editPart instanceof ExpansionRegionNodeCompartmentEditPart) {
			return getPrimaryShape().getFigureExpansionRegionFigure_ContentPane();
		}
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ExpansionRegionModeEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ControlFlow_4001);
		types.add(UMLElementTypes.ObjectFlow_4002);
		types.add(UMLElementTypes.ActionLocalPrecondition_4003);
		types.add(UMLElementTypes.ActionLocalPostcondition_4006);
		types.add(UMLElementTypes.ExceptionHandler_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof OpaqueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof OpaqueAction_OutputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof OpaqueAction_InputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof PinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof CreateObjectAction_OutputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_insertAt_InputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_value_InputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_object_InputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof CallAction_OutputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof CallAction_InputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof CallOperationAction_InputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_OpaqueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_DecisionNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_PinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_CallOperationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_ForkNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_JoinNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_InputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_OutputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_InitialNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof SendSignalActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_DecisionNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_MergeNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_InitialNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_OpaqueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_ForkNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_JoinNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_PinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_CallOperationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNode_InputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNode_OutputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_SendSignalActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_LoopNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ActivityPartition_ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ValueSpecificationAction_OutputPinEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof LoopNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.activity.edit.parts.ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ExpansionNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4001);
		}
		if (targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof OpaqueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof OpaqueAction_OutputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof OpaqueAction_InputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof PinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof CreateObjectAction_OutputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_insertAt_InputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_value_InputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_object_InputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof CallAction_OutputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof CallAction_InputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof CallOperationAction_InputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_OpaqueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_DecisionNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_PinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_CallOperationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_ForkNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_JoinNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_InputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_OutputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_InitialNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof SendSignalActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_DecisionNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_MergeNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_InitialNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_DataStoreNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_OpaqueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_ForkNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_JoinNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_PinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_CallOperationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNode_InputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNode_OutputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_SendSignalActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_LoopNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityPartition_ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ValueSpecificationAction_OutputPinEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof LoopNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.activity.edit.parts.ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ExpansionNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof LocalPreconditionEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4003);
		}
		if (targetEditPart instanceof LocalPostconditionEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4003);
		}
		if (targetEditPart instanceof LocalPreconditionEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4006);
		}
		if (targetEditPart instanceof LocalPostconditionEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4006);
		}
		if (targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof OpaqueActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_OpaqueActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_CallOperationActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof StructuredActivityNode_ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof SendSignalActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_OpaqueActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_CreateObjectActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_CallOperationActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_SendSignalActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_LoopNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ActivityPartition_ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof LoopNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ConditionalNodeEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.activity.edit.parts.ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		if (targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ExceptionHandler_4005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3030);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3031);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ActivityFinalNode_3032);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DecisionNode_3033);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.MergeNode_3034);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InitialNode_3035);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DataStoreNode_3036);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CentralBufferNode_3037);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OpaqueAction_3029);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3001);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3094);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.FlowFinalNode_3038);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ForkNode_3039);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.JoinNode_3040);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.Pin_3041);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CreateObjectAction_3042);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3002);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3043);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3003);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3004);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3005);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallBehaviorAction_3044);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3006);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3007);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallOperationAction_3045);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3008);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.StructuredActivityNode_3046);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.StructuredActivityNode_3009);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OpaqueAction_3011);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3012);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3013);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ActivityFinalNode_3014);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DecisionNode_3015);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.FlowFinalNode_3016);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.Pin_3017);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CreateObjectAction_3018);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallBehaviorAction_3019);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallOperationAction_3020);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ForkNode_3021);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.JoinNode_3022);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3023);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DataStoreNode_3024);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CentralBufferNode_3025);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3054);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3055);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ConditionalNode_3092);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InitialNode_3093);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ActivityParameterNode_3052);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.SendSignalAction_3053);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3059);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3060);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ActivityFinalNode_3061);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DecisionNode_3062);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.MergeNode_3063);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InitialNode_3064);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DataStoreNode_3065);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CentralBufferNode_3066);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OpaqueAction_3067);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.FlowFinalNode_3068);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ForkNode_3069);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.JoinNode_3070);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.Pin_3071);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CreateObjectAction_3072);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3073);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallBehaviorAction_3074);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallOperationAction_3075);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.StructuredActivityNode_3076);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.StructuredActivityNode_3079);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3080);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3081);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.SendSignalAction_3077);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.LoopNode_3078);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ConditionalNode_3083);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ExpansionRegion_3085);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3090);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.LoopNode_3058);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ConditionalNode_3082);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ExpansionRegion_3084);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ExpansionNode_3091);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ValueSpecificationAction_3089);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3030);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3031);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ActivityFinalNode_3032);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DecisionNode_3033);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.MergeNode_3034);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InitialNode_3035);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DataStoreNode_3036);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CentralBufferNode_3037);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OpaqueAction_3029);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3001);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3094);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.FlowFinalNode_3038);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ForkNode_3039);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.JoinNode_3040);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.Pin_3041);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CreateObjectAction_3042);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3002);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3043);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3003);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3004);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3005);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallBehaviorAction_3044);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3006);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3007);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallOperationAction_3045);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3008);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.StructuredActivityNode_3046);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.StructuredActivityNode_3009);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OpaqueAction_3011);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3012);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3013);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ActivityFinalNode_3014);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DecisionNode_3015);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.FlowFinalNode_3016);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.Pin_3017);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CreateObjectAction_3018);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallBehaviorAction_3019);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallOperationAction_3020);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ForkNode_3021);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.JoinNode_3022);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3023);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DataStoreNode_3024);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CentralBufferNode_3025);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3054);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3055);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ConditionalNode_3092);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InitialNode_3093);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ActivityParameterNode_3052);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.SendSignalAction_3053);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3059);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3060);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ActivityFinalNode_3061);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DecisionNode_3062);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.MergeNode_3063);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InitialNode_3064);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DataStoreNode_3065);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CentralBufferNode_3066);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OpaqueAction_3067);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.FlowFinalNode_3068);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ForkNode_3069);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.JoinNode_3070);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.Pin_3071);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CreateObjectAction_3072);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3073);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallBehaviorAction_3074);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallOperationAction_3075);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.StructuredActivityNode_3076);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.StructuredActivityNode_3079);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3080);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3081);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.SendSignalAction_3077);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.LoopNode_3078);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ConditionalNode_3083);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ExpansionRegion_3085);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3090);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.LoopNode_3058);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ConditionalNode_3082);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ExpansionRegion_3084);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ExpansionNode_3091);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ValueSpecificationAction_3089);
		}
		if (relationshipType == UMLElementTypes.ActionLocalPrecondition_4003) {
			types.add(UMLElementTypes.Constraint_2027);
		}
		if (relationshipType == UMLElementTypes.ActionLocalPrecondition_4003) {
			types.add(UMLElementTypes.Constraint_2028);
		}
		if (relationshipType == UMLElementTypes.ActionLocalPostcondition_4006) {
			types.add(UMLElementTypes.Constraint_2027);
		}
		if (relationshipType == UMLElementTypes.ActionLocalPostcondition_4006) {
			types.add(UMLElementTypes.Constraint_2028);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3030);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3031);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.OpaqueAction_3029);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CreateObjectAction_3042);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3043);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallBehaviorAction_3044);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallOperationAction_3045);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3046);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3009);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.OpaqueAction_3011);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3012);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3013);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CreateObjectAction_3018);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallBehaviorAction_3019);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallOperationAction_3020);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3023);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ConditionalNode_3092);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.SendSignalAction_3053);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3059);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3060);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.OpaqueAction_3067);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CreateObjectAction_3072);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3073);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallBehaviorAction_3074);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallOperationAction_3075);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3076);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3079);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.SendSignalAction_3077);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.LoopNode_3078);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ConditionalNode_3083);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ExpansionRegion_3085);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.LoopNode_3058);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ConditionalNode_3082);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ExpansionRegion_3084);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ValueSpecificationAction_3089);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ControlFlow_4001);
		types.add(UMLElementTypes.ObjectFlow_4002);
		types.add(UMLElementTypes.ExceptionHandler_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3030);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3031);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ActivityFinalNode_3032);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DecisionNode_3033);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.MergeNode_3034);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InitialNode_3035);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DataStoreNode_3036);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CentralBufferNode_3037);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OpaqueAction_3029);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3001);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3094);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.FlowFinalNode_3038);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ForkNode_3039);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.JoinNode_3040);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.Pin_3041);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CreateObjectAction_3042);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3002);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3043);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3003);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3004);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3005);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallBehaviorAction_3044);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3006);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3007);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallOperationAction_3045);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3008);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.StructuredActivityNode_3046);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.StructuredActivityNode_3009);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OpaqueAction_3011);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3012);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3013);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ActivityFinalNode_3014);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DecisionNode_3015);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.FlowFinalNode_3016);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.Pin_3017);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CreateObjectAction_3018);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallBehaviorAction_3019);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallOperationAction_3020);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ForkNode_3021);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.JoinNode_3022);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3023);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DataStoreNode_3024);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CentralBufferNode_3025);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3054);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3055);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ConditionalNode_3092);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InitialNode_3093);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ActivityParameterNode_3052);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.SendSignalAction_3053);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3059);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AcceptEventAction_3060);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ActivityFinalNode_3061);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DecisionNode_3062);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.MergeNode_3063);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InitialNode_3064);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.DataStoreNode_3065);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CentralBufferNode_3066);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OpaqueAction_3067);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.FlowFinalNode_3068);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ForkNode_3069);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.JoinNode_3070);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.Pin_3071);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CreateObjectAction_3072);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3073);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallBehaviorAction_3074);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.CallOperationAction_3075);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.StructuredActivityNode_3076);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.StructuredActivityNode_3079);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.InputPin_3080);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3081);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.SendSignalAction_3077);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.LoopNode_3078);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ConditionalNode_3083);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ExpansionRegion_3085);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.OutputPin_3090);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.LoopNode_3058);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ConditionalNode_3082);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ExpansionRegion_3084);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ExpansionNode_3091);
		}
		if (relationshipType == UMLElementTypes.ControlFlow_4001) {
			types.add(UMLElementTypes.ValueSpecificationAction_3089);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3030);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3031);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ActivityFinalNode_3032);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DecisionNode_3033);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.MergeNode_3034);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InitialNode_3035);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DataStoreNode_3036);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CentralBufferNode_3037);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OpaqueAction_3029);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3001);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3094);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.FlowFinalNode_3038);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ForkNode_3039);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.JoinNode_3040);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.Pin_3041);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CreateObjectAction_3042);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3002);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3043);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3003);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3004);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3005);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallBehaviorAction_3044);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3006);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3007);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallOperationAction_3045);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3008);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.StructuredActivityNode_3046);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.StructuredActivityNode_3009);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OpaqueAction_3011);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3012);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3013);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ActivityFinalNode_3014);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DecisionNode_3015);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.FlowFinalNode_3016);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.Pin_3017);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CreateObjectAction_3018);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallBehaviorAction_3019);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallOperationAction_3020);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ForkNode_3021);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.JoinNode_3022);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3023);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DataStoreNode_3024);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CentralBufferNode_3025);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3054);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3055);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ConditionalNode_3092);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InitialNode_3093);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ActivityParameterNode_3052);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.SendSignalAction_3053);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3059);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AcceptEventAction_3060);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ActivityFinalNode_3061);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DecisionNode_3062);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.MergeNode_3063);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InitialNode_3064);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.DataStoreNode_3065);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CentralBufferNode_3066);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OpaqueAction_3067);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.FlowFinalNode_3068);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ForkNode_3069);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.JoinNode_3070);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.Pin_3071);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CreateObjectAction_3072);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3073);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallBehaviorAction_3074);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.CallOperationAction_3075);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.StructuredActivityNode_3076);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.StructuredActivityNode_3079);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.InputPin_3080);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3081);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.SendSignalAction_3077);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.LoopNode_3078);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ConditionalNode_3083);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ExpansionRegion_3085);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.OutputPin_3090);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.LoopNode_3058);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ConditionalNode_3082);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ExpansionRegion_3084);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ExpansionNode_3091);
		}
		if (relationshipType == UMLElementTypes.ObjectFlow_4002) {
			types.add(UMLElementTypes.ValueSpecificationAction_3089);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3030);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3031);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.OpaqueAction_3029);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CreateObjectAction_3042);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3043);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallBehaviorAction_3044);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallOperationAction_3045);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3046);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3009);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.OpaqueAction_3011);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3012);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3013);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CreateObjectAction_3018);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallBehaviorAction_3019);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallOperationAction_3020);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3023);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ConditionalNode_3092);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.SendSignalAction_3053);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3059);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AcceptEventAction_3060);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.OpaqueAction_3067);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CreateObjectAction_3072);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3073);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallBehaviorAction_3074);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.CallOperationAction_3075);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3076);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.StructuredActivityNode_3079);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.SendSignalAction_3077);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.LoopNode_3078);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ConditionalNode_3083);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ExpansionRegion_3085);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.LoopNode_3058);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ConditionalNode_3082);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ExpansionRegion_3084);
		}
		if (relationshipType == UMLElementTypes.ExceptionHandler_4005) {
			types.add(UMLElementTypes.ValueSpecificationAction_3089);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		handleTypeLinkModification(event);
		handleFeatureLinkModification(event);
	}

	/**
	 * @generated
	 */
	public class ExpansionRegionFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private Label fFigureExpansionRegionFigure_keyword;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureExpansionRegionFigure_ContentPane;

		/**
		 * @generated
		 */
		public ExpansionRegionFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DASH);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureExpansionRegionFigure_ContentPane = new RectangleFigure();
			fFigureExpansionRegionFigure_ContentPane.setFill(false);
			fFigureExpansionRegionFigure_ContentPane.setOutline(false);
			fFigureExpansionRegionFigure_ContentPane.setLineWidth(1);

			this.add(fFigureExpansionRegionFigure_ContentPane, BorderLayout.CENTER);

			RectangleFigure expansionRegionFigure_LabelContainer0 = new RectangleFigure();
			expansionRegionFigure_LabelContainer0.setFill(false);
			expansionRegionFigure_LabelContainer0.setOutline(false);
			expansionRegionFigure_LabelContainer0.setLineWidth(1);

			expansionRegionFigure_LabelContainer0.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(0)));

			this.add(expansionRegionFigure_LabelContainer0, BorderLayout.TOP);

			BorderLayout layoutExpansionRegionFigure_LabelContainer0 = new BorderLayout();
			expansionRegionFigure_LabelContainer0.setLayoutManager(layoutExpansionRegionFigure_LabelContainer0);

			fFigureExpansionRegionFigure_keyword = new Label();
			fFigureExpansionRegionFigure_keyword.setText("");

			expansionRegionFigure_LabelContainer0.add(fFigureExpansionRegionFigure_keyword, BorderLayout.LEFT);

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
		public Label getFigureExpansionRegionFigure_keyword() {
			return fFigureExpansionRegionFigure_keyword;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureExpansionRegionFigure_ContentPane() {
			return fFigureExpansionRegionFigure_ContentPane;
		}

	}

	/**
	 * @generated
	 */
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private LinkTargetListener getLinkTargetListener() {
		if (myLinkTargetListener == null) {
			myLinkTargetListener = new LinkTargetListener();
		}
		return myLinkTargetListener;
	}

	/**
	 * @generated
	 */
	private class LinkTargetListener implements NotificationListener {

		/**
		 * @generated
		 */
		Map<EObject, Set<EStructuralFeature>> myNotifiers = new HashMap<EObject, Set<EStructuralFeature>>();

		/**
		 * @generated
		 */
		private void added(EObject link, EStructuralFeature feature) {
			if (!myNotifiers.containsKey(link)) {
				myNotifiers.put(link, new HashSet<EStructuralFeature>());
			}
			myNotifiers.get(link).add(feature);
		}

		/**
		 * @generated
		 */
		private void removed(EObject link, EStructuralFeature feature) {
			if (!myNotifiers.containsKey(link)) {
				return;
			}
			myNotifiers.get(link).remove(feature);
		}

		/**
		 * @generated
		 */
		public void dispose() {
			Set<Map.Entry<EObject, Set<EStructuralFeature>>> entrySet = myNotifiers.entrySet();
			for (Map.Entry<EObject, Set<EStructuralFeature>> entry : entrySet) {
				for (EStructuralFeature feature : entry.getValue()) {
					getDiagramEventBroker().removeNotificationListener(entry.getKey(), feature, this);
				}
			}
		}

		/**
		 * @generated
		 */
		private void removeReferenceListener(EObject link, EStructuralFeature feature) {
			getDiagramEventBroker().removeNotificationListener(link, feature, this);
			removed(link, feature);
		}

		/**
		 * @generated
		 */
		private void addReferenceListener(EObject link, EStructuralFeature feature) {
			getDiagramEventBroker().addNotificationListener(link, feature, this);
			added(link, feature);
		}

		/**
		 * @generated
		 */
		public void notifyChanged(Notification event) {
			if (event.getFeature() == UMLPackage.eINSTANCE.getExceptionHandler_HandlerBody()) {
				guardedRefreshDiagram();
				return;
			}
		}
	}

	/**
	 * @generated
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		for (IUpdaterNodeDescriptor next : getExpansionRegion_3084ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case ExceptionHandlerEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getExceptionHandler_HandlerBody());
				break;

			default:
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	private List<IUpdaterLinkDescriptor> getExpansionRegion_3084ContainedLinks() {
		return UMLDiagramUpdater.getExpansionRegion_3084ContainedLinks(getNotationView());
	}

	/**
	 * @generated
	 */
	protected void removeSemanticListeners() {
		super.removeSemanticListeners();
		getLinkTargetListener().dispose();
	}

	/**
	 * @generated
	 */
	private void handleTypeLinkModification(Notification event) {
		if (event.getFeature() == UMLPackage.eINSTANCE.getExecutableNode_Handler()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof ExceptionHandler) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getExceptionHandler_HandlerBody());
				}
				if (link instanceof ExceptionHandler) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof ExceptionHandler) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getExceptionHandler_HandlerBody());
				}
				if (link instanceof ExceptionHandler) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof ExceptionHandler) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getExceptionHandler_HandlerBody());
					}
				}
				for (Object link : links) {
					if (link instanceof ExceptionHandler) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof ExceptionHandler) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getExceptionHandler_HandlerBody());
					}
				}
				for (Object link : links) {
					if (link instanceof ExceptionHandler) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			}
		}
	}

	/**
	 * @generated
	 */
	private void handleFeatureLinkModification(Notification event) {
		if (event.getFeature() == UMLPackage.eINSTANCE.getAction_LocalPrecondition()) {
			guardedRefreshDiagram();
			return;
		}
		if (event.getFeature() == UMLPackage.eINSTANCE.getAction_LocalPostcondition()) {
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

}
