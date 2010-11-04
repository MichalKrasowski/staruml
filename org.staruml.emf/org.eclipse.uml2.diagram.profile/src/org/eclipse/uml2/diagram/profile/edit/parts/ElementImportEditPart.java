package org.eclipse.uml2.diagram.profile.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
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
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.profile.edit.policies.ElementImportItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.profile.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * @generated
 */
public class ElementImportEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2006;

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
	public ElementImportEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ElementImportItemSemanticEditPolicy());
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
	protected IFigure createNodeShapeGen() {
		ReferencedMetaclassFigure figure = new ReferencedMetaclassFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		ReferencedMetaclassFigure result = (ReferencedMetaclassFigure) createNodeShapeGen();
		refreshHasImportedMetaclass(result);
		return result;
	}

	/**
	 * @generated
	 */
	public ReferencedMetaclassFigure getPrimaryShape() {
		return (ReferencedMetaclassFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ReferencedMetaclassNode_classNameEditPart) {
			((ReferencedMetaclassNode_classNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureReferencedMetaclassFigure_className());
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ReferencedMetaclassNode_classNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Extension_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		types.add(UMLElementTypes.CommentAnnotatedElement_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Extension_4002) {
			types.add(UMLElementTypes.Stereotype_2001);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4003) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4004) {
			types.add(UMLElementTypes.Comment_2009);
		}
		return types;
	}

	/**
	 * @NOT-GENERATED
	 * XXX: fix for #161545 should allow to generate this method  
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (notification.getNotifier() instanceof ElementImport) {
			refreshHasImportedMetaclass(getPrimaryShape());
		}
	}

	/**
	 * @NOT-GENERATED
	 * XXX: fix for #161545 should allow to generate this method  
	 */
	private void refreshHasImportedMetaclass(ReferencedMetaclassFigure figure) {
		ElementImport elementImport = (ElementImport) resolveSemanticElement();
		//OCL here (#161545)
		boolean hasMetaclass = false;
		if (elementImport != null) {
			PackageableElement imported = elementImport.getImportedElement();
			hasMetaclass = imported instanceof Class && ((Class) imported).isMetaclass();
		}
		figure.setHasActualMetaclassImport(hasMetaclass);
	}

	/**
	 * @generated
	 */
	public class ReferencedMetaclassFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureReferencedMetaclassFigure_className;

		/**
		 * @generated
		 */
		public ReferencedMetaclassFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.gray);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(1), getMapMode().DPtoLP(1), getMapMode().DPtoLP(1), getMapMode().DPtoLP(1)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure referencedMetaclassFigure_FixedLabelPane0 = new RectangleFigure();
			referencedMetaclassFigure_FixedLabelPane0.setFill(false);
			referencedMetaclassFigure_FixedLabelPane0.setOutline(false);
			referencedMetaclassFigure_FixedLabelPane0.setLineWidth(1);

			referencedMetaclassFigure_FixedLabelPane0.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			this.add(referencedMetaclassFigure_FixedLabelPane0);

			CenterLayout layoutReferencedMetaclassFigure_FixedLabelPane0 = new CenterLayout();

			referencedMetaclassFigure_FixedLabelPane0.setLayoutManager(layoutReferencedMetaclassFigure_FixedLabelPane0);

			Label referencedMetaclassFigure_fixed_metaclass1 = new Label();
			referencedMetaclassFigure_fixed_metaclass1.setText("\u00ABmetaclass\u00BB");

			referencedMetaclassFigure_FixedLabelPane0.add(referencedMetaclassFigure_fixed_metaclass1);

			RectangleFigure referencedMetaclassFigure_LabelPane0 = new RectangleFigure();
			referencedMetaclassFigure_LabelPane0.setFill(false);
			referencedMetaclassFigure_LabelPane0.setOutline(false);
			referencedMetaclassFigure_LabelPane0.setLineWidth(1);

			this.add(referencedMetaclassFigure_LabelPane0);

			CenterLayout layoutReferencedMetaclassFigure_LabelPane0 = new CenterLayout();

			referencedMetaclassFigure_LabelPane0.setLayoutManager(layoutReferencedMetaclassFigure_LabelPane0);

			fFigureReferencedMetaclassFigure_className = new Label();
			fFigureReferencedMetaclassFigure_className.setText("");

			referencedMetaclassFigure_LabelPane0.add(fFigureReferencedMetaclassFigure_className);

		}

		/**
		 * @generated
		 */
		public Label getFigureReferencedMetaclassFigure_className() {
			return fFigureReferencedMetaclassFigure_className;
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
		 * @NOT-GENERATED
		 */
		public void setHasActualMetaclassImport(boolean hasActualMetaclassImport) {
			setForegroundColor(hasActualMetaclassImport ? ColorConstants.gray : ColorConstants.red);
		}

	}

}
