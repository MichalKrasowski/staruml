package org.eclipse.uml2.diagram.csd.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.csd.edit.policies.Property3CanonicalEditPolicy;
import org.eclipse.uml2.diagram.csd.edit.policies.Property3ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class Property3EditPart extends AbstractBorderedShapeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3014;

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
	public Property3EditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Property3ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new Property3CanonicalEditPolicy());
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
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case Port2EditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
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
	protected IFigure createNodeShapeGen() {
		PartFigure figure = new PartFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		PartFigure figure = (PartFigure) createNodeShapeGen();
		refreshOutline(figure);
		return figure;
	}

	/**
	 * @generated
	 */
	public PartFigure getPrimaryShape() {
		return (PartFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PropertyName2EditPart) {
			((PropertyName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigure_PartFigure_name());
			return true;
		}
		if (childEditPart instanceof Port2EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((Port2EditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof Port2EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((Port2EditPart) childEditPart).getFigure());
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
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(PropertyName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Connector_4005);
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.Usage_4008);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Connector_4005);
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);
		types.add(UMLElementTypes.CommentAnnotatedElement_4016);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof PropertyEditPart) {
			types.add(UMLElementTypes.Connector_4005);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Connector_4005);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.Property3EditPart) {
			types.add(UMLElementTypes.Connector_4005);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Connector_4005);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Connector_4005);
		}
		if (targetEditPart instanceof CollaborationEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Class3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof CollaborationUse2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof PropertyEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.Property3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof CollaborationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Class3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof CollaborationUse2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof PropertyEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.Property3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Property_3007);
		}
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Port_3011);
		}
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Property_3014);
		}
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Port_3016);
		}
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Port_3017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Collaboration_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Class_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Package_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Class_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Interface_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Constraint_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.CollaborationUse_3002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Property_3007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Port_3011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Property_3014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Port_3016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Port_3017);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Collaboration_2005);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Class_2006);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Package_2003);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Class_2007);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Interface_2009);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Constraint_2012);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.CollaborationUse_3002);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Property_3007);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Port_3011);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Property_3014);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Port_3016);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Port_3017);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_2012);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4016) {
			types.add(UMLElementTypes.Comment_2013);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Property_3007);
		}
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Port_3011);
		}
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Property_3014);
		}
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Port_3016);
		}
		if (relationshipType == UMLElementTypes.Connector_4005) {
			types.add(UMLElementTypes.Port_3017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Collaboration_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Class_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Package_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Class_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Interface_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Constraint_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.CollaborationUse_3002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Property_3007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Port_3011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Property_3014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Port_3016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Port_3017);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Collaboration_2005);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Class_2006);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Package_2003);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Class_2007);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Interface_2009);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Constraint_2012);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.CollaborationUse_3002);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Property_3007);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Class_3010);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Port_3011);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Property_3014);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Port_3016);
		}
		if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Port_3017);
		}
		return types;
	}

	/**
	 * @NOT-GENERATED
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		Property part = (Property) resolveSemanticElement();
		addListenerFilter("SemanticModel_PartAggregationListener", this, part, UMLPackage.eINSTANCE.getProperty_Aggregation());
	}

	/**
	 * @NOT-GENERATED
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (UMLPackage.eINSTANCE.getProperty_Aggregation().equals(notification.getFeature())) {
			refreshOutline(getPrimaryShape());
		}
	}

	/**
	 * @NOT-GENERATED
	 */
	private void refreshOutline(PartFigure partFigure) {
		Property part = (Property) resolveSemanticElement();
		if (part == null) {
			return;
		}
		if (AggregationKind.COMPOSITE_LITERAL.equals(part.getAggregation())) {
			partFigure.setLineStyle(SWT.LINE_SOLID);
		} else {
			partFigure.setLineStyle(SWT.LINE_DASH);
		}
	}

	/**
	 * @generated
	 */
	public class PartFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigure_PartFigure_name;

		/**
		 * @generated
		 */
		public PartFigure() {

			CenterLayout layoutThis = new CenterLayout();

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigure_PartFigure_name = new Label();
			fFigure_PartFigure_name.setText("");

			this.add(fFigure_PartFigure_name);

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
		public Label getFigure_PartFigure_name() {
			return fFigure_PartFigure_name;
		}

	}

	/**
	 * @generated
	 */
	protected void reorderChild(EditPart child, int index) {
		// Save the constraint of the child so that it does not
		// get lost during the remove and re-add.
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		LayoutManager layout = getContentPaneFor((IGraphicalEditPart) child).getLayoutManager();
		Object constraint = null;
		if (layout != null) {
			constraint = layout.getConstraint(childFigure);
		}
		super.reorderChild(child, index);
		setLayoutConstraint(child, childFigure, constraint);
	}

}
