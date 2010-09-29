package org.eclipse.uml2.diagram.clazz.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.clazz.edit.policies.GeneralizationSetItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class GeneralizationSetEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2012;

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
	public GeneralizationSetEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GeneralizationSetItemSemanticEditPolicy());
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
				case GeneralizationSetIsCoveringIsDisjointEditPart.VISUAL_ID:
				case GeneralizationSetNameEditPart.VISUAL_ID:
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
		return primaryShape = new DashedHorizontalLineFigure();
	}

	/**
	 * @generated
	 */
	public DashedHorizontalLineFigure getPrimaryShape() {
		return (DashedHorizontalLineFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof GeneralizationSetIsCoveringIsDisjointEditPart || borderItemEditPart instanceof GeneralizationSetNameEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(50, 4);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		// #265822 Improve appearance of selection feedback
		ResizableEditPolicy result = new U2TResizableShapeEditPolicy();
		result.setResizeDirections(PositionConstants.WEST | PositionConstants.EAST);
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(GeneralizationSetIsCoveringIsDisjointEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4002);
		types.add(UMLElementTypes.Realization_4010);
		types.add(UMLElementTypes.Usage_4013);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4004);
		types.add(UMLElementTypes.DependencySupplier_4006);
		types.add(UMLElementTypes.DependencyClient_4007);
		types.add(UMLElementTypes.Realization_4010);
		types.add(UMLElementTypes.Generalization_4011);
		types.add(UMLElementTypes.Usage_4013);
		types.add(UMLElementTypes.CommentAnnotatedElement_4019);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof DependencyEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof DependencyEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof DependencyEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4004) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.DependencySupplier_4006) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.DependencyClient_4007) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4019) {
			types.add(UMLElementTypes.Comment_2018);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.PrimitiveType_3037);
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
	}

}
