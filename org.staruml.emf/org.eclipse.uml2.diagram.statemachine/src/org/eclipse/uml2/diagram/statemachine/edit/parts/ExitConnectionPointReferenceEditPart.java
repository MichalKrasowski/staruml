package org.eclipse.uml2.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.statemachine.edit.policies.ExitConnectionPointReferenceItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class ExitConnectionPointReferenceEditPart extends BorderedBorderItemEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3018;

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
	public ExitConnectionPointReferenceEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ExitConnectionPointReferenceItemSemanticEditPolicy());
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
				case ExitConnectionPointReferenceNameEditPart.VISUAL_ID:
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
		ExitPointFigure figure = new ExitPointFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ExitPointFigure getPrimaryShape() {
		return (ExitPointFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof ExitConnectionPointReferenceNameEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(15, 15);

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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ExitConnectionPointReferenceNameEditPart.VISUAL_ID));
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
		if (targetEditPart instanceof SimpleStateEditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.statemachine.edit.parts.ExitConnectionPointReferenceEditPart) {
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
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	public class ExitPointFigure extends Ellipse {

		/**
		 * @generated
		 */
		public ExitPointFigure() {
			this.setLayoutManager(new StackLayout());
			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			class ExitPointFigure_Cross0Class extends Shape {

				/**
				 * @generated
				 */
				private final PointList myTemplate = new PointList();

				/**
				 * @generated
				 */
				private Rectangle myTemplateBounds;

				/**
				 * @generated
				 */
				public void addPoint(Point point) {
					myTemplate.addPoint(point);
					myTemplateBounds = null;
				}

				/**
				 * @generated
				 */
				protected void fillShape(Graphics graphics) {
					Rectangle bounds = getBounds();
					graphics.pushState();
					graphics.translate(bounds.x, bounds.y);
					graphics.fillPolygon(scalePointList());
					graphics.popState();
				}

				/**
				 * @generated
				 */
				protected void outlineShape(Graphics graphics) {
					Rectangle bounds = getBounds();
					graphics.pushState();
					graphics.translate(bounds.x, bounds.y);
					graphics.drawPolygon(scalePointList());
					graphics.popState();
				}

				/**
				 * @generated
				 */
				private Rectangle getTemplateBounds() {
					if (myTemplateBounds == null) {
						myTemplateBounds = myTemplate.getBounds().getCopy().union(0, 0);
						//just safety -- we are going to use this as divider 
						if (myTemplateBounds.width < 1) {
							myTemplateBounds.width = 1;
						}
						if (myTemplateBounds.height < 1) {
							myTemplateBounds.height = 1;
						}
					}
					return myTemplateBounds;
				}

				/**
				 * @generated
				 */
				private int[] scalePointList() {
					Rectangle pointsBounds = getTemplateBounds();
					Rectangle actualBounds = getBounds();

					float xScale = ((float) actualBounds.width) / pointsBounds.width;
					float yScale = ((float) actualBounds.height) / pointsBounds.height;

					if (xScale == 1 && yScale == 1) {
						return myTemplate.toIntArray();
					}
					int[] scaled = (int[]) myTemplate.toIntArray().clone();
					for (int i = 0; i < scaled.length; i += 2) {
						scaled[i] = (int) Math.floor(scaled[i] * xScale);
						scaled[i + 1] = (int) Math.floor(scaled[i + 1] * yScale);
					}
					return scaled;
				}
			}
			;
			ExitPointFigure_Cross0Class exitPointFigure_Cross0 = new ExitPointFigure_Cross0Class();

			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode().DPtoLP(20)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(0)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(40)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode().DPtoLP(20)));
			exitPointFigure_Cross0.setFill(true);
			exitPointFigure_Cross0.setLineWidth(1);

			this.add(exitPointFigure_Cross0);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

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
