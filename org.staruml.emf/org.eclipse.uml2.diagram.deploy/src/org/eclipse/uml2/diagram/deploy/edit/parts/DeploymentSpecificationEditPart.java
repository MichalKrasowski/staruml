package org.eclipse.uml2.diagram.deploy.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.deploy.edit.policies.DeploymentSpecificationCanonicalEditPolicy;
import org.eclipse.uml2.diagram.deploy.edit.policies.DeploymentSpecificationItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.deploy.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class DeploymentSpecificationEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

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
	public DeploymentSpecificationEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DeploymentSpecificationItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DeploymentSpecificationCanonicalEditPolicy());
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
		DeploymentSpecificationFigure figure = new DeploymentSpecificationFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public DeploymentSpecificationFigure getPrimaryShape() {
		return (DeploymentSpecificationFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DeploymentSpecificationNameEditPart) {
			((DeploymentSpecificationNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureDeploymentSpecificationFigure_name());
			return true;
		}
		if (childEditPart instanceof DeploymentSpecificationStereo3EditPart) {
			((DeploymentSpecificationStereo3EditPart) childEditPart).setLabel(getPrimaryShape().getFigureDeploymentSpecificationFigure_stereo());
			return true;
		}
		if (childEditPart instanceof DeploymentSpecificationPropertiesEditPart) {
			IFigure pane = getPrimaryShape().getFigureDeploymentSpecificationFigure_PropertiesCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((DeploymentSpecificationPropertiesEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof DeploymentSpecificationPropertiesEditPart) {
			IFigure pane = getPrimaryShape().getFigureDeploymentSpecificationFigure_PropertiesCompartment();
			pane.remove(((DeploymentSpecificationPropertiesEditPart) childEditPart).getFigure());
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
		if (editPart instanceof DeploymentSpecificationPropertiesEditPart) {
			return getPrimaryShape().getFigureDeploymentSpecificationFigure_PropertiesCompartment();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(160, 100);
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(DeploymentSpecificationNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Manifestation_4002);
		types.add(UMLElementTypes.CommunicationPath_4004);
		types.add(UMLElementTypes.Dependency_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Deployment_4001);
		types.add(UMLElementTypes.Manifestation_4002);
		types.add(UMLElementTypes.CommunicationPath_4004);
		types.add(UMLElementTypes.Dependency_4005);
		types.add(UMLElementTypes.CommentAnnotatedElement_4006);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof Device2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof Artifact4EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof ExecutionEnvironment2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof Node2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Device2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Artifact4EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof ExecutionEnvironment2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Node2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof Device2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof Artifact4EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof ExecutionEnvironment2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof Node2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4006) {
			types.add(UMLElementTypes.Comment_2008);
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
			if (type == UMLElementTypes.Property_3003) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(DeploymentSpecificationPropertiesEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Node_3007);
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
			if (event.getFeature() == UMLPackage.eINSTANCE.getManifestation_UtilizedElement()) {
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
		for (IUpdaterNodeDescriptor next : getDeploymentSpecification_2007ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case ManifestationEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
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
	private List<IUpdaterLinkDescriptor> getDeploymentSpecification_2007ContainedLinks() {
		return UMLDiagramUpdater.getDeploymentSpecification_2007ContainedLinks(getNotationView());
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
		if (event.getFeature() == UMLPackage.eINSTANCE.getArtifact_Manifestation()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof Manifestation) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
				}
				if (link instanceof Manifestation) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof Manifestation) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
				}
				if (link instanceof Manifestation) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof Manifestation) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
					}
				}
				for (Object link : links) {
					if (link instanceof Manifestation) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof Manifestation) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
					}
				}
				for (Object link : links) {
					if (link instanceof Manifestation) {
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
	public class DeploymentSpecificationFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private StereotypeLabel fFigureDeploymentSpecificationFigure_stereo;

		/**
		 * @generated
		 */
		private Label fFigureDeploymentSpecificationFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureDeploymentSpecificationFigure_PropertiesCompartment;

		/**
		 * @generated
		 */
		public DeploymentSpecificationFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(1), getMapMode().DPtoLP(1), getMapMode().DPtoLP(10), getMapMode().DPtoLP(1)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure deploymentSpecificationFigure_Header0 = new RectangleFigure();
			deploymentSpecificationFigure_Header0.setOutline(false);
			deploymentSpecificationFigure_Header0.setLineWidth(1);

			this.add(deploymentSpecificationFigure_Header0);

			ToolbarLayout layoutDeploymentSpecificationFigure_Header0 = new ToolbarLayout();
			layoutDeploymentSpecificationFigure_Header0.setStretchMinorAxis(true);
			layoutDeploymentSpecificationFigure_Header0.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutDeploymentSpecificationFigure_Header0.setSpacing(0);
			layoutDeploymentSpecificationFigure_Header0.setVertical(true);

			deploymentSpecificationFigure_Header0.setLayoutManager(layoutDeploymentSpecificationFigure_Header0);

			RectangleFigure deploymentSpecificationFigure_StereoContainer1 = new RectangleFigure();
			deploymentSpecificationFigure_StereoContainer1.setOutline(false);
			deploymentSpecificationFigure_StereoContainer1.setLineWidth(1);

			deploymentSpecificationFigure_Header0.add(deploymentSpecificationFigure_StereoContainer1);

			CenterLayout layoutDeploymentSpecificationFigure_StereoContainer1 = new CenterLayout();

			deploymentSpecificationFigure_StereoContainer1.setLayoutManager(layoutDeploymentSpecificationFigure_StereoContainer1);

			fFigureDeploymentSpecificationFigure_stereo = new StereotypeLabel();

			fFigureDeploymentSpecificationFigure_stereo.setFont(FFIGUREDEPLOYMENTSPECIFICATIONFIGURE_STEREO_FONT);

			fFigureDeploymentSpecificationFigure_stereo.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			deploymentSpecificationFigure_StereoContainer1.add(fFigureDeploymentSpecificationFigure_stereo);

			RectangleFigure deploymentSpecificationFigure_NameContainer1 = new RectangleFigure();
			deploymentSpecificationFigure_NameContainer1.setOutline(false);
			deploymentSpecificationFigure_NameContainer1.setLineWidth(1);

			deploymentSpecificationFigure_Header0.add(deploymentSpecificationFigure_NameContainer1);

			CenterLayout layoutDeploymentSpecificationFigure_NameContainer1 = new CenterLayout();

			deploymentSpecificationFigure_NameContainer1.setLayoutManager(layoutDeploymentSpecificationFigure_NameContainer1);

			fFigureDeploymentSpecificationFigure_name = new Label();
			fFigureDeploymentSpecificationFigure_name.setText("");

			fFigureDeploymentSpecificationFigure_name.setFont(FFIGUREDEPLOYMENTSPECIFICATIONFIGURE_NAME_FONT);

			fFigureDeploymentSpecificationFigure_name.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			deploymentSpecificationFigure_NameContainer1.add(fFigureDeploymentSpecificationFigure_name);

			fFigureDeploymentSpecificationFigure_PropertiesCompartment = new RectangleFigure();
			fFigureDeploymentSpecificationFigure_PropertiesCompartment.setOutline(false);
			fFigureDeploymentSpecificationFigure_PropertiesCompartment.setLineWidth(1);

			this.add(fFigureDeploymentSpecificationFigure_PropertiesCompartment);
			fFigureDeploymentSpecificationFigure_PropertiesCompartment.setLayoutManager(new StackLayout());

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
		public StereotypeLabel getFigureDeploymentSpecificationFigure_stereo() {
			return fFigureDeploymentSpecificationFigure_stereo;
		}

		/**
		 * @generated
		 */
		public Label getFigureDeploymentSpecificationFigure_name() {
			return fFigureDeploymentSpecificationFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureDeploymentSpecificationFigure_PropertiesCompartment() {
			return fFigureDeploymentSpecificationFigure_PropertiesCompartment;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREDEPLOYMENTSPECIFICATIONFIGURE_STEREO_FONT = new Font(Display.getCurrent(), Display.getDefault().getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREDEPLOYMENTSPECIFICATIONFIGURE_NAME_FONT = new Font(Display.getCurrent(), Display.getDefault().getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

}
