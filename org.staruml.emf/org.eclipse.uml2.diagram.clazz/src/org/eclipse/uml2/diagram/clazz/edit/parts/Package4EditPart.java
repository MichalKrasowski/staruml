package org.eclipse.uml2.diagram.clazz.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.clazz.edit.policies.Package4ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.clazz.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.DoNothingEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UnmovableUnselectableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;

/**
 * @generated
 */
public class Package4EditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2014;

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
	public Package4EditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Package4ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AsyncDiagramComponentEditPolicy());
		installEditPolicy("ConnectionHandlesPolicy", new DoNothingEditPolicy()); //$NON-NLS-1$
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
		SecondaryPackageFigure figure = new SecondaryPackageFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SecondaryPackageFigure getPrimaryShape() {
		return (SecondaryPackageFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PackageName2EditPart) {
			((PackageName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureSecondaryPackage_NameLabel());
			return true;
		}
		if (childEditPart instanceof PackageStereo2EditPart) {
			((PackageStereo2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureSecondaryPackage_PackageLabel());
			return true;
		}
		if (childEditPart instanceof PackageImportsEditPart) {
			IFigure pane = getPrimaryShape().getFigureSecondaryPackage_Imports();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((PackageImportsEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof PackageImportsEditPart) {
			IFigure pane = getPrimaryShape().getFigureSecondaryPackage_Imports();
			pane.remove(((PackageImportsEditPart) childEditPart).getFigure());
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
		if (editPart instanceof PackageImportsEditPart) {
			return getPrimaryShape().getFigureSecondaryPackage_Imports();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 60);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		return new UnmovableUnselectableShapeEditPolicy();
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(PackageName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4002);
		types.add(UMLElementTypes.Realization_4010);
		types.add(UMLElementTypes.Usage_4013);
		types.add(UMLElementTypes.TemplateBinding_4016);
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
		types.add(UMLElementTypes.Usage_4013);
		types.add(UMLElementTypes.TemplateBinding_4016);
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
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Package4EditPart) {
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
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Package4EditPart) {
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
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Package4EditPart) {
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
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Package4EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
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
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
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
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == UMLElementTypes.ElementImport_3031) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(PackageImportsEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
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
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
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

	/**
	 * @generated
	 */
	public class SecondaryPackageFigure extends Shape {

		/**
		 * @generated
		 */
		private Label fFigureSecondaryPackage_PackageLabel;

		/**
		 * @generated
		 */
		private Label fFigureSecondaryPackage_NameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureSecondaryPackage_Imports;

		/**
		 * @generated
		 */
		public SecondaryPackageFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(40)));
			this.addPoint(new Point(getMapMode().DPtoLP(35), getMapMode().DPtoLP(40)));
			this.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(35)));
			this.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(0)));
			this.setFill(true);
			this.setLineWidth(1);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(13), getMapMode().DPtoLP(10)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureSecondaryPackage_PackageLabel = new Label();
			fFigureSecondaryPackage_PackageLabel.setText("");

			this.add(fFigureSecondaryPackage_PackageLabel);

			fFigureSecondaryPackage_NameLabel = new Label();
			fFigureSecondaryPackage_NameLabel.setText("");

			this.add(fFigureSecondaryPackage_NameLabel);

			fFigureSecondaryPackage_Imports = new RectangleFigure();
			fFigureSecondaryPackage_Imports.setOutline(false);
			fFigureSecondaryPackage_Imports.setLineWidth(1);

			this.add(fFigureSecondaryPackage_Imports);

		}

		/**
		 * @generated
		 */
		public Label getFigureSecondaryPackage_PackageLabel() {
			return fFigureSecondaryPackage_PackageLabel;
		}

		/**
		 * @generated
		 */
		public Label getFigureSecondaryPackage_NameLabel() {
			return fFigureSecondaryPackage_NameLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureSecondaryPackage_Imports() {
			return fFigureSecondaryPackage_Imports;
		}

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

}
