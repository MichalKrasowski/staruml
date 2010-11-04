package org.eclipse.uml2.diagram.profile.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.draw2d.NameAndStereotypeBlock;
import org.eclipse.uml2.diagram.common.draw2d.PartialRectangleFigure;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel2;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.profile.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.uml2.diagram.profile.edit.policies.Profile2ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class Profile2EditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2002;

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
	public Profile2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(UMLVisualIDRegistry.TYPED_ADAPTER));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Profile2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AsyncDiagramComponentEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
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
		ProfileFigure figure = new ProfileFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ProfileFigure getPrimaryShape() {
		return (ProfileFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ProfileNameEditPart) {
			((ProfileNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureProfileFigure_NameLabel());
			return true;
		}
		if (childEditPart instanceof ProfileStereoEditPart) {
			((ProfileStereoEditPart) childEditPart).setLabel(getPrimaryShape().getFigureProfileFigure_StereoLabel());
			return true;
		}
		if (childEditPart instanceof ProfileContentsEditPart) {
			IFigure pane = getPrimaryShape().getFigureProfileFigure_ContentsCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ProfileContentsEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ProfileContentsEditPart) {
			IFigure pane = getPrimaryShape().getFigureProfileFigure_ContentsCompartment();
			pane.remove(((ProfileContentsEditPart) childEditPart).getFigure());
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
		if (editPart instanceof ProfileContentsEditPart) {
			return getPrimaryShape().getFigureProfileFigure_ContentsCompartment();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 80);
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ProfileNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		types.add(UMLElementTypes.CommentAnnotatedElement_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4003) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4004) {
			types.add(UMLElementTypes.Comment_2009);
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
			if (type == UMLElementTypes.Stereotype_3003) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ProfileContentsEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
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
	public class ProfileFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fFigureProfileFigure_ContentsCompartment;

		/**
		 * @generated
		 */
		private NameAndStereotypeBlock fNameAndStereotypeBlock;

		/**
		 * @generated
		 */
		public ProfileFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.lightGray);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure profile_AuxTop0 = new RectangleFigure();
			profile_AuxTop0.setFill(false);
			profile_AuxTop0.setOutline(false);
			profile_AuxTop0.setLineWidth(1);

			this.add(profile_AuxTop0, BorderLayout.TOP);

			ConstrainedToolbarLayout layoutProfile_AuxTop0 = new ConstrainedToolbarLayout();

			layoutProfile_AuxTop0.setStretchMajorAxis(true);

			layoutProfile_AuxTop0.setVertical(false);

			profile_AuxTop0.setLayoutManager(layoutProfile_AuxTop0);

			PartialRectangleFigure profileFigure_AuxLeftTab1 = new PartialRectangleFigure();

			profileFigure_AuxLeftTab1.setBottomShown(false);

			profileFigure_AuxLeftTab1.setPreferredSize(new Dimension(getMapMode().DPtoLP(1), getMapMode().DPtoLP(30)));

			profile_AuxTop0.add(profileFigure_AuxLeftTab1);

			RectangleFigure profileFigure_AuxRightPadding1 = new RectangleFigure();
			profileFigure_AuxRightPadding1.setFill(false);
			profileFigure_AuxRightPadding1.setOutline(false);
			profileFigure_AuxRightPadding1.setLineWidth(1);
			profileFigure_AuxRightPadding1.setPreferredSize(new Dimension(getMapMode().DPtoLP(1), getMapMode().DPtoLP(30)));

			profile_AuxTop0.add(profileFigure_AuxRightPadding1);

			RectangleFigure profile_body0 = new RectangleFigure();
			profile_body0.setLineWidth(1);

			profile_body0.setBorder(new MarginBorder(getMapMode().DPtoLP(1), getMapMode().DPtoLP(1), getMapMode().DPtoLP(10), getMapMode().DPtoLP(1)));

			this.add(profile_body0, BorderLayout.CENTER);

			ToolbarLayout layoutProfile_body0 = new ToolbarLayout();
			layoutProfile_body0.setStretchMinorAxis(true);
			layoutProfile_body0.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutProfile_body0.setSpacing(0);
			layoutProfile_body0.setVertical(true);

			profile_body0.setLayoutManager(layoutProfile_body0);

			fNameAndStereotypeBlock = new NameAndStereotypeBlock();

			fNameAndStereotypeBlock.setBorder(new MarginBorder(getMapMode().DPtoLP(8), getMapMode().DPtoLP(5), getMapMode().DPtoLP(6), getMapMode().DPtoLP(5)));

			profile_body0.add(fNameAndStereotypeBlock);

			fFigureProfileFigure_ContentsCompartment = new RectangleFigure();
			fFigureProfileFigure_ContentsCompartment.setOutline(false);
			fFigureProfileFigure_ContentsCompartment.setLineWidth(1);

			profile_body0.add(fFigureProfileFigure_ContentsCompartment);

			StackLayout layoutFFigureProfileFigure_ContentsCompartment = new StackLayout();

			layoutFFigureProfileFigure_ContentsCompartment.setObserveVisibility(true);

			fFigureProfileFigure_ContentsCompartment.setLayoutManager(layoutFFigureProfileFigure_ContentsCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureProfileFigure_NameLabel() {
			return getNameAndStereotypeBlock().getNameLabel();
		}

		/**
		 * @generated
		 */
		public StereotypeLabel2 getFigureProfileFigure_StereoLabel() {
			return getNameAndStereotypeBlock().getStereotypeLabel();
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureProfileFigure_ContentsCompartment() {
			return fFigureProfileFigure_ContentsCompartment;
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

	}

}
