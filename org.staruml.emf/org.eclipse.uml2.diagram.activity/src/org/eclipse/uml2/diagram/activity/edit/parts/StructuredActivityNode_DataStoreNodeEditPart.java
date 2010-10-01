package org.eclipse.uml2.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.activity.edit.policies.StructuredActivityNode_DataStoreNodeCanonicalEditPolicy;
import org.eclipse.uml2.diagram.activity.edit.policies.StructuredActivityNode_DataStoreNodeItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.draw2d.NameAndStereotypeBlock;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel2;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class StructuredActivityNode_DataStoreNodeEditPart extends AbstractBorderedShapeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3024;

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
	public StructuredActivityNode_DataStoreNodeEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new StructuredActivityNode_DataStoreNodeItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new StructuredActivityNode_DataStoreNodeCanonicalEditPolicy());
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
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case StructuredActivityNode_DataStoreNodeOrderingEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
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
		DataStoreFigure figure = new DataStoreFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public DataStoreFigure getPrimaryShape() {
		return (DataStoreFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StructuredActivityNode_DataStoreNodeNameEditPart) {
			((StructuredActivityNode_DataStoreNodeNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureDataStoreFigure_name());
			return true;
		}
		if (childEditPart instanceof StructuredActivityNode_DataStoreNodeInStateEditPart) {
			((StructuredActivityNode_DataStoreNodeInStateEditPart) childEditPart).setLabel(getPrimaryShape().getFigureDataStoreFigure_states());
			return true;
		}
		if (childEditPart instanceof StructuredActivityNode_DataStoreNodeStereotypeEditPart) {
			((StructuredActivityNode_DataStoreNodeStereotypeEditPart) childEditPart).setLabel(getPrimaryShape().getFigureDataStoreFigure_stereo());
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
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof StructuredActivityNode_DataStoreNodeOrderingEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
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
	protected NodeFigure createMainFigure() {
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(StructuredActivityNode_DataStoreNodeNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ControlFlow_4001);
		types.add(UMLElementTypes.ObjectFlow_4002);
		types.add(UMLElementTypes.ObjectNodeSelection_4004);
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_DataStoreNodeEditPart) {
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
		if (targetEditPart instanceof ExpansionRegionEditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_DataStoreNodeEditPart) {
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
		if (targetEditPart instanceof ExpansionRegionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ExpansionNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4002);
		}
		if (targetEditPart instanceof ActivityEditPart) {
			types.add(UMLElementTypes.ObjectNodeSelection_4004);
		}
		if (targetEditPart instanceof OpaqueBehaviorEditPart) {
			types.add(UMLElementTypes.ObjectNodeSelection_4004);
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
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.Activity_2026);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OpaqueBehavior_3047);
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
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		handleFeatureLinkModification(event);
	}

	/**
	 * @generated
	 */
	public class DataStoreFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureDataStoreFigure_states;

		/**
		 * @generated
		 */
		private NameAndStereotypeBlock fNameAndStereotypeBlock;

		/**
		 * @generated
		 */
		public DataStoreFigure() {

			CenterLayout layoutThis = new CenterLayout();

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure dataStoreFigure_NameContainer0 = new RectangleFigure();
			dataStoreFigure_NameContainer0.setFill(false);
			dataStoreFigure_NameContainer0.setOutline(false);
			dataStoreFigure_NameContainer0.setLineWidth(1);

			dataStoreFigure_NameContainer0.setBorder(new MarginBorder(getMapMode().DPtoLP(6), getMapMode().DPtoLP(5), getMapMode().DPtoLP(3), getMapMode().DPtoLP(5)));

			this.add(dataStoreFigure_NameContainer0);

			ToolbarLayout layoutDataStoreFigure_NameContainer0 = new ToolbarLayout();
			layoutDataStoreFigure_NameContainer0.setStretchMinorAxis(false);
			layoutDataStoreFigure_NameContainer0.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutDataStoreFigure_NameContainer0.setSpacing(0);
			layoutDataStoreFigure_NameContainer0.setVertical(true);

			dataStoreFigure_NameContainer0.setLayoutManager(layoutDataStoreFigure_NameContainer0);

			Label dataStore_fixed_datastore1 = new Label();
			dataStore_fixed_datastore1.setText("\u00ABdatastore\u00BB");

			dataStoreFigure_NameContainer0.add(dataStore_fixed_datastore1);

			fNameAndStereotypeBlock = new NameAndStereotypeBlock();

			dataStoreFigure_NameContainer0.add(fNameAndStereotypeBlock);

			fFigureDataStoreFigure_states = new Label();
			fFigureDataStoreFigure_states.setText("");

			dataStoreFigure_NameContainer0.add(fFigureDataStoreFigure_states);

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
		public Label getFigureDataStoreFigure_states() {
			return fFigureDataStoreFigure_states;
		}

		/**
		 * @generated
		 */
		public NameAndStereotypeBlock getNameAndStereotypeBlock() {
			return fNameAndStereotypeBlock;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDataStoreFigure_name() {
			return getNameAndStereotypeBlock().getNameLabel();
		}

		/**
		 * @generated
		 */
		public StereotypeLabel2 getFigureDataStoreFigure_stereo() {
			return getNameAndStereotypeBlock().getStereotypeLabel();
		}

	}

	/**
	 * @generated
	 */
	private void handleFeatureLinkModification(Notification event) {
		if (event.getFeature() == UMLPackage.eINSTANCE.getObjectNode_Selection()) {
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
	protected void performDirectEditRequest(final Request request) {
		EditPart editPart = this;
		if (request instanceof DirectEditRequest) {
			Point p = new Point(((DirectEditRequest) request).getLocation());
			getFigure().translateToRelative(p);
			IFigure fig = getFigure().findFigureAt(p);
			editPart = (EditPart) getViewer().getVisualPartMap().get(fig);
		}
		if (editPart == this) {
			try {
				editPart = (EditPart) getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

					public void run() {
						setResult(chooseLabelEditPartForDirectEditRequest(request));
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (editPart != null && editPart != this) {
				editPart.performRequest(request);
			}
		}
	}

	/**
	 * @generated
	 */
	protected EditPart chooseLabelEditPartForDirectEditRequest(Request request) {
		if (request.getExtendedData().containsKey(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR)) {
			Character initialChar = (Character) request.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
			// '<' has special meaning, because we have both name- and stereo- inplaces for single node edit part
			// we want to activate stereotype inplace if user presses '<' (for "<< stereotype >>" 
			// notation, also we don't include '<' and '>' into actual inplace text).
			// If user presses any other alfanum key, we will activate name-inplace, as for all other figures

			if (initialChar.charValue() == '<') {
				EditPart result = getChildBySemanticHint(UMLVisualIDRegistry.getType(StructuredActivityNode_DataStoreNodeStereotypeEditPart.VISUAL_ID));
				if (result != null) {
					return result;
				}
			}
		}
		return getPrimaryChildEditPart();
	}

}
