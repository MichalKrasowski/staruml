package org.eclipse.uml2.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.draw2d.NameAndStereotypeBlock;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel2;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.statemachine.edit.policies.SimpleStateItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.statemachine.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class SimpleStateEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

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
	public SimpleStateEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, true));
		}
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(UMLVisualIDRegistry.TYPED_ADAPTER));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SimpleStateItemSemanticEditPolicy());
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
		SimpleStateFigure figure = new SimpleStateFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SimpleStateFigure getPrimaryShape() {
		return (SimpleStateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SimpleStateNameEditPart) {
			((SimpleStateNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureSimpleStateFigure_name());
			return true;
		}
		if (childEditPart instanceof SimpleStateStereotypeEditPart) {
			((SimpleStateStereotypeEditPart) childEditPart).setLabel(getPrimaryShape().getFigureSimpleStateFigure_stereo());
			return true;
		}
		if (childEditPart instanceof SimpleState_InternalActivitiesEditPart) {
			IFigure pane = getPrimaryShape().getFigureSimpleStateFigure_InternalActivitiesCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((SimpleState_InternalActivitiesEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof SimpleState_InternalActivitiesEditPart) {
			IFigure pane = getPrimaryShape().getFigureSimpleStateFigure_InternalActivitiesCompartment();
			pane.remove(((SimpleState_InternalActivitiesEditPart) childEditPart).getFigure());
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
		if (editPart instanceof SimpleState_InternalActivitiesEditPart) {
			return getPrimaryShape().getFigureSimpleStateFigure_InternalActivitiesCompartment();
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(SimpleStateNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof org.eclipse.uml2.diagram.statemachine.edit.parts.SimpleStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof CompositeStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof SubmachineStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof EntryConnectionPointReferenceEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ExitConnectionPointReferenceEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof FinalStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InitialPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ShallowHistoryPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof DeepHistoryPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ForkPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof JoinPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof JunctionPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ChoicePseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof TerminatePseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof EntryPointPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ExitPointPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3001);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3012);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3016);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.ConnectionPointReference_3017);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.ConnectionPointReference_3018);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.FinalState_3003);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3004);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3005);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3006);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3007);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3008);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3009);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3010);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3011);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3014);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3001);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3012);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3016);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.ConnectionPointReference_3017);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.ConnectionPointReference_3018);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.FinalState_3003);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3004);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3005);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3006);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3007);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3008);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3009);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3010);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3011);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3014);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == UMLElementTypes.Behavior_3019) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(SimpleState_InternalActivitiesEditPart.VISUAL_ID));
			}
			if (type == UMLElementTypes.Behavior_3020) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(SimpleState_InternalActivitiesEditPart.VISUAL_ID));
			}
			if (type == UMLElementTypes.Behavior_3021) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(SimpleState_InternalActivitiesEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
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
	public class SimpleStateFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private RectangleFigure fFigureSimpleStateFigure_InternalActivitiesCompartment;

		/**
		 * @generated
		 */
		private NameAndStereotypeBlock fNameAndStereotypeBlock;

		/**
		 * @generated
		 */
		public SimpleStateFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(18), getMapMode().DPtoLP(18)));
			this.setLineWidth(1);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(4), getMapMode().DPtoLP(4), getMapMode().DPtoLP(4), getMapMode().DPtoLP(4)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fNameAndStereotypeBlock = new NameAndStereotypeBlock();

			fNameAndStereotypeBlock.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(5), getMapMode().DPtoLP(2), getMapMode().DPtoLP(5)));

			this.add(fNameAndStereotypeBlock);

			fFigureSimpleStateFigure_InternalActivitiesCompartment = new RectangleFigure();
			fFigureSimpleStateFigure_InternalActivitiesCompartment.setOutline(false);
			fFigureSimpleStateFigure_InternalActivitiesCompartment.setLineWidth(1);

			this.add(fFigureSimpleStateFigure_InternalActivitiesCompartment);

			StackLayout layoutFFigureSimpleStateFigure_InternalActivitiesCompartment = new StackLayout();

			layoutFFigureSimpleStateFigure_InternalActivitiesCompartment.setObserveVisibility(true);

			fFigureSimpleStateFigure_InternalActivitiesCompartment.setLayoutManager(layoutFFigureSimpleStateFigure_InternalActivitiesCompartment);

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
		public RectangleFigure getFigureSimpleStateFigure_InternalActivitiesCompartment() {
			return fFigureSimpleStateFigure_InternalActivitiesCompartment;
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
		public StereotypeLabel2 getFigureSimpleStateFigure_stereo() {
			return getNameAndStereotypeBlock().getStereotypeLabel();
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSimpleStateFigure_name() {
			return getNameAndStereotypeBlock().getNameLabel();
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
				EditPart result = getChildBySemanticHint(UMLVisualIDRegistry.getType(SimpleStateStereotypeEditPart.VISUAL_ID));
				if (result != null) {
					return result;
				}
			}
		}
		return getPrimaryChildEditPart();
	}

}
