package org.eclipse.uml2.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.editparts.NeedsParentEditPart;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.common.layered.MultiLayeredContainer;
import org.eclipse.uml2.diagram.common.layered.MultilayeredFigure;
import org.eclipse.uml2.diagram.sequence.draw2d.GateLocator;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateLifeLineEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.BlockArrangeContainerEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionCanonicalEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionNestedLayoutEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDCreationEditPolicy;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.sequence.figures.InteractionShape;
import org.eclipse.uml2.diagram.sequence.figures.MultiLayeredContentPane;
import org.eclipse.uml2.diagram.sequence.frame.Frame;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class InteractionEditPart extends AbstractBorderedShapeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

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
	public InteractionEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InteractionItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SDGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new InteractionCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new BlockArrangeContainerEditPolicy());
		installEditPolicy("SequenceDiagramNestedLayout", new InteractionNestedLayoutEditPolicy()); //$NON-NLS-1$
		installEditPolicy("SD-Create-LifeLine", new CreateLifeLineEditPolicy()); //$NON-NLS-1$
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated NOT
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		XYLayoutEditPolicy lep = new XYLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child instanceof IBorderItemEditPart) {
					return new BorderItemSelectionEditPolicy();
				}
				EditPolicy result = super.createChildEditPolicy(child);
				if (result == null) {
					return new ResizableShapeEditPolicy();
				}
				return result;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		CustomInteractionFigure figure = new CustomInteractionFigure();
		if (figure instanceof NeedsParentEditPart) {
			((NeedsParentEditPart) figure).hookParentEditPart((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) getParent());
		}
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public CustomInteractionFigure getPrimaryShape() {
		return (CustomInteractionFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InteractionNameEditPart) {
			((InteractionNameEditPart) childEditPart).setLabel(getPrimaryShape().getInteractionNameLabel());
			return true;
		}
		if (childEditPart instanceof GateEditPart) {
			IBorderItemLocator locator = new GateLocator(getMainFigure());
			getBorderedFigure().getBorderItemContainer().add(((GateEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof GateEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((GateEditPart) childEditPart).getFigure());
			return true;
		}
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
	 * @generated NOT
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof GateEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		//<added>
		if (editPart instanceof LifelineEditPart) {
			return getPrimaryShape().getMultilayeredContentPane().getDefaultLayerContentPane();
		}
		if (editPart instanceof LayeredInteractionUseEditPart) {
			return getPrimaryShape().getMultilayeredContentPane().getLayerContentPane(MultiLayeredContentPane.FOREGROUND_LAYER);
		}
		if (editPart instanceof LayeredCombinedFragmentEditPart) {
			return getPrimaryShape().getMultilayeredContentPane().getLayerContentPane(MultiLayeredContentPane.FOREGROUND_LAYER);
		}

		//</added>
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result;
		if (primaryShape instanceof Frame) {
			result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(300), getMapMode().DPtoLP(200)) {

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
			result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(300), getMapMode().DPtoLP(200));
		}
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
	 * @generated NOT
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (Boolean.TRUE.booleanValue()) {
			return getPrimaryShape().getDefaultLayerContentPane();
		}
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InteractionNameEditPart.VISUAL_ID));
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart) {
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
		handleTypeLinkModification(event);
	}

	/**
	 * @generated
	 */
	public class CustomInteractionFigure extends InteractionShape {

		/**
		 * @generated
		 */
		public CustomInteractionFigure() {

			this.setIsFullScreen(false);

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
		public Label getInteractionNameLabel() {
			return super.getInteractionNameLabel();
		}

		/**
		 * @generated
		 */
		public MultiLayeredContentPane getMultilayeredContentPane() {
			return super.getMultilayeredContentPane();
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
			if (event.getFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
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
		for (IUpdaterNodeDescriptor next : getInteraction_2001ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case MessageEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
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
	private List<IUpdaterLinkDescriptor> getInteraction_2001ContainedLinks() {
		return UMLDiagramUpdater.getInteraction_2001ContainedLinks(getNotationView());
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
		if (event.getFeature() == UMLPackage.eINSTANCE.getInteraction_Message()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof Message) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
				}
				if (link instanceof Message) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof Message) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
				}
				if (link instanceof Message) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof Message) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
					}
				}
				for (Object link : links) {
					if (link instanceof Message) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof Message) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
					}
				}
				for (Object link : links) {
					if (link instanceof Message) {
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
}
