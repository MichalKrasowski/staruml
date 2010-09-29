package org.eclipse.uml2.diagram.csd.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.draw2d.NameAndStereotypeBlock;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel2;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.csd.edit.policies.InstanceSpecificationItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.csd.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class InstanceSpecificationEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2011;

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
	public InstanceSpecificationEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InstanceSpecificationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AsyncDiagramComponentEditPolicy());
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
		InstanceNodeFigure figure = new InstanceNodeFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public InstanceNodeFigure getPrimaryShape() {
		return (InstanceNodeFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InstanceSpecificationNameEditPart) {
			((InstanceSpecificationNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureInstanceFigure_NameLabel());
			return true;
		}
		if (childEditPart instanceof InstanceSpecificationStereoEditPart) {
			((InstanceSpecificationStereoEditPart) childEditPart).setLabel(getPrimaryShape().getFigureInstanceFigure_StereoLabel());
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InstanceSpecificationNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.Slot_4015);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);
		types.add(UMLElementTypes.Slot_4015);
		types.add(UMLElementTypes.CommentAnnotatedElement_4016);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationEditPart) {
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
		if (targetEditPart instanceof Property3EditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationEditPart) {
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
		if (targetEditPart instanceof Property3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Slot_4015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
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
		if (relationshipType == UMLElementTypes.Slot_4015) {
			types.add(UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4016) {
			types.add(UMLElementTypes.Comment_2013);
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
			if (type == UMLElementTypes.Slot_3015) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(InstanceSpecificationSlotsEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
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
		if (relationshipType == UMLElementTypes.Slot_4015) {
			types.add(UMLElementTypes.InstanceSpecification_2011);
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
		handleTypeLinkModification(event);
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
			if (event.getFeature() == UMLPackage.eINSTANCE.getSlot_OwningInstance()) {
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
		for (IUpdaterNodeDescriptor next : getInstanceSpecification_2011ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case AssociationInstanceEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getSlot_OwningInstance());
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
	private List<IUpdaterLinkDescriptor> getInstanceSpecification_2011ContainedLinks() {
		return UMLDiagramUpdater.getInstanceSpecification_2011ContainedLinks(getNotationView());
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
		if (event.getFeature() == UMLPackage.eINSTANCE.getInstanceSpecification_Slot()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof Slot) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getSlot_OwningInstance());
				}
				if (link instanceof Slot) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof Slot) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getSlot_OwningInstance());
				}
				if (link instanceof Slot) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof Slot) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getSlot_OwningInstance());
					}
				}
				for (Object link : links) {
					if (link instanceof Slot) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof Slot) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getSlot_OwningInstance());
					}
				}
				for (Object link : links) {
					if (link instanceof Slot) {
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
				EditPart result = getChildBySemanticHint(UMLVisualIDRegistry.getType(InstanceSpecificationStereoEditPart.VISUAL_ID));
				if (result != null) {
					return result;
				}
			}
		}
		return getPrimaryChildEditPart();
	}

	/**
	 * @generated
	 */
	public class InstanceNodeFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fFigureInstanceNode_SlotsCompartmentFigure;

		/**
		 * @generated
		 */
		private NameAndStereotypeBlock fNameAndStereotypeBlock;

		/**
		 * @generated
		 */
		public InstanceNodeFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(1), getMapMode().DPtoLP(1), getMapMode().DPtoLP(1), getMapMode().DPtoLP(1)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fNameAndStereotypeBlock = new NameAndStereotypeBlock();

			fNameAndStereotypeBlock.setBorder(new MarginBorder(getMapMode().DPtoLP(8), getMapMode().DPtoLP(5), getMapMode().DPtoLP(6), getMapMode().DPtoLP(5)));

			this.add(fNameAndStereotypeBlock);

			fFigureInstanceNode_SlotsCompartmentFigure = new RectangleFigure();
			fFigureInstanceNode_SlotsCompartmentFigure.setOutline(false);
			fFigureInstanceNode_SlotsCompartmentFigure.setLineWidth(1);

			this.add(fFigureInstanceNode_SlotsCompartmentFigure);

		}

		private Border createBorder0() {
			OneLineBorder result = new OneLineBorder();

			result.setPosition(PositionConstants.BOTTOM);

			return result;
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
		public RectangleFigure getFigureInstanceNode_SlotsCompartmentFigure() {
			return fFigureInstanceNode_SlotsCompartmentFigure;
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
		public StereotypeLabel2 getFigureInstanceFigure_StereoLabel() {
			return getNameAndStereotypeBlock().getStereotypeLabel();
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureInstanceFigure_NameLabel() {
			return getNameAndStereotypeBlock().getNameLabel();
		}

	}

}
