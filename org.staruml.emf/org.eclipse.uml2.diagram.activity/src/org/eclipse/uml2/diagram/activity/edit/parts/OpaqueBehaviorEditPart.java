package org.eclipse.uml2.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.activity.edit.policies.OpaqueBehaviorCanonicalEditPolicy;
import org.eclipse.uml2.diagram.activity.edit.policies.OpaqueBehaviorItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.activity.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.draw2d.ConstraintFigureBase;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;

/**
 * @generated
 */

public class OpaqueBehaviorEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3047;

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
	public OpaqueBehaviorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OpaqueBehaviorItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new OpaqueBehaviorCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new UMLTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		SelectionFigure figure = new SelectionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SelectionFigure getPrimaryShape() {
		return (SelectionFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof OpaqueBehaviorNameEditPart) {
			((OpaqueBehaviorNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureSelectionFigure_name());
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(OpaqueBehaviorNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ObjectNodeSelection_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.DataStoreNode_3036);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.CentralBufferNode_3037);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3001);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3094);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.Pin_3041);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3002);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3003);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3004);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3005);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3006);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3007);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3008);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.Pin_3017);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.DataStoreNode_3024);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.CentralBufferNode_3025);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3054);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3055);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.ActivityParameterNode_3052);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.DataStoreNode_3065);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.CentralBufferNode_3066);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.Pin_3071);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3080);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3081);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3090);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.ExpansionNode_3091);
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
	public class SelectionFigure extends ConstraintFigureBase {

		/**
		 * @generated
		 */
		private Label fFigureSelectionFigure_name;

		/**
		 * @generated
		 */
		public SelectionFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(false);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			Label selectionFigure_fixed_top0 = new Label();
			selectionFigure_fixed_top0.setText("\u00ABselection\u00BB");

			this.add(selectionFigure_fixed_top0);

			fFigureSelectionFigure_name = new Label();
			fFigureSelectionFigure_name.setText("");

			this.add(fFigureSelectionFigure_name);

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
		public Label getFigureSelectionFigure_name() {
			return fFigureSelectionFigure_name;
		}

	}

}
