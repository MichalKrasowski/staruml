package org.eclipse.uml2.diagram.csd.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.csd.edit.policies.Class3CanonicalEditPolicy;
import org.eclipse.uml2.diagram.csd.edit.policies.Class3ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class Class3EditPart extends AbstractBorderedShapeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2007;

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
	public Class3EditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Class3ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new Class3CanonicalEditPolicy());
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
				case Port3EditPart.VISUAL_ID:
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
	protected IFigure createNodeShape() {
		ExpandedClassFigure figure = new ExpandedClassFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ExpandedClassFigure getPrimaryShape() {
		return (ExpandedClassFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ClassName2EditPart) {
			((ClassName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureExpandedClassFigure_name());
			return true;
		}
		if (childEditPart instanceof ClassClass_contentsEditPart) {
			IFigure pane = getPrimaryShape().getFigureExpandedClassFigure_contents();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ClassClass_contentsEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof Port3EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((Port3EditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ClassClass_contentsEditPart) {
			IFigure pane = getPrimaryShape().getFigureExpandedClassFigure_contents();
			pane.remove(((ClassClass_contentsEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof Port3EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((Port3EditPart) childEditPart).getFigure());
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
		if (editPart instanceof ClassClass_contentsEditPart) {
			return getPrimaryShape().getFigureExpandedClassFigure_contents();
		}
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(80, 60);
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.InterfaceRealization_4007);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.Association_4011);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.Association_4011);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.Class3EditPart) {
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
		if (targetEditPart instanceof Property3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4007);
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.Class3EditPart) {
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
		if (targetEditPart instanceof Property3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof CollaborationEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.Class3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Association_4011);
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
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Collaboration_2005);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Class_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Class_2007);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Interface_2009);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Class_3010);
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
		if (relationshipType == UMLElementTypes.InterfaceRealization_4007) {
			types.add(UMLElementTypes.Interface_2009);
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
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Collaboration_2005);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Class_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Class_2007);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Interface_2009);
		}
		if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Class_3010);
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
	public class ExpandedClassFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureExpandedClassFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureExpandedClassFigure_contents;

		/**
		 * @generated
		 */
		public ExpandedClassFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureExpandedClassFigure_name = new Label();
			fFigureExpandedClassFigure_name.setText("");

			this.add(fFigureExpandedClassFigure_name, BorderLayout.TOP);

			fFigureExpandedClassFigure_contents = new RectangleFigure();
			fFigureExpandedClassFigure_contents.setOutline(false);
			fFigureExpandedClassFigure_contents.setLineWidth(1);

			this.add(fFigureExpandedClassFigure_contents, BorderLayout.CENTER);

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
		public Label getFigureExpandedClassFigure_name() {
			return fFigureExpandedClassFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureExpandedClassFigure_contents() {
			return fFigureExpandedClassFigure_contents;
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
			if (event.getFeature() == UMLPackage.eINSTANCE.getInterfaceRealization_Contract()) {
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
		for (IUpdaterNodeDescriptor next : getClass_2007ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case InterfaceRealizationEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
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
	private List<IUpdaterLinkDescriptor> getClass_2007ContainedLinks() {
		return UMLDiagramUpdater.getClass_2007ContainedLinks(getNotationView());
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
		if (event.getFeature() == UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof InterfaceRealization) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
				}
				if (link instanceof InterfaceRealization) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof InterfaceRealization) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
				}
				if (link instanceof InterfaceRealization) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof InterfaceRealization) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
					}
				}
				for (Object link : links) {
					if (link instanceof InterfaceRealization) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof InterfaceRealization) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
					}
				}
				for (Object link : links) {
					if (link instanceof InterfaceRealization) {
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
