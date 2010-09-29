package org.eclipse.uml2.diagram.csd.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (UMLVisualIDRegistry.getVisualID(view)) {

			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);

			case CollaborationEditPart.VISUAL_ID:
				return new CollaborationEditPart(view);

			case CollaborationNameEditPart.VISUAL_ID:
				return new CollaborationNameEditPart(view);

			case CollaborationStereoEditPart.VISUAL_ID:
				return new CollaborationStereoEditPart(view);

			case ClassEditPart.VISUAL_ID:
				return new ClassEditPart(view);

			case ClassNameEditPart.VISUAL_ID:
				return new ClassNameEditPart(view);

			case ClassStereoEditPart.VISUAL_ID:
				return new ClassStereoEditPart(view);

			case Package2EditPart.VISUAL_ID:
				return new Package2EditPart(view);

			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);

			case PackageStereo2EditPart.VISUAL_ID:
				return new PackageStereo2EditPart(view);

			case Class3EditPart.VISUAL_ID:
				return new Class3EditPart(view);

			case ClassName2EditPart.VISUAL_ID:
				return new ClassName2EditPart(view);

			case InterfaceEditPart.VISUAL_ID:
				return new InterfaceEditPart(view);

			case InterfaceNameEditPart.VISUAL_ID:
				return new InterfaceNameEditPart(view);

			case InstanceSpecificationEditPart.VISUAL_ID:
				return new InstanceSpecificationEditPart(view);

			case InstanceSpecificationNameEditPart.VISUAL_ID:
				return new InstanceSpecificationNameEditPart(view);

			case InstanceSpecificationStereoEditPart.VISUAL_ID:
				return new InstanceSpecificationStereoEditPart(view);

			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);

			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);

			case ConstraintLanguageEditPart.VISUAL_ID:
				return new ConstraintLanguageEditPart(view);

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case CollaborationUse2EditPart.VISUAL_ID:
				return new CollaborationUse2EditPart(view);

			case CollaborationUseName2EditPart.VISUAL_ID:
				return new CollaborationUseName2EditPart(view);

			case CollaborationUseStereoEditPart.VISUAL_ID:
				return new CollaborationUseStereoEditPart(view);

			case PropertyEditPart.VISUAL_ID:
				return new PropertyEditPart(view);

			case PropertyNameEditPart.VISUAL_ID:
				return new PropertyNameEditPart(view);

			case Property2EditPart.VISUAL_ID:
				return new Property2EditPart(view);

			case OperationEditPart.VISUAL_ID:
				return new OperationEditPart(view);

			case Class2EditPart.VISUAL_ID:
				return new Class2EditPart(view);

			case PortEditPart.VISUAL_ID:
				return new PortEditPart(view);

			case PortNameEditPart.VISUAL_ID:
				return new PortNameEditPart(view);

			case PortIsBehaviorEditPart.VISUAL_ID:
				return new PortIsBehaviorEditPart(view);

			case ElementImportEditPart.VISUAL_ID:
				return new ElementImportEditPart(view);

			case Property3EditPart.VISUAL_ID:
				return new Property3EditPart(view);

			case PropertyName2EditPart.VISUAL_ID:
				return new PropertyName2EditPart(view);

			case Port2EditPart.VISUAL_ID:
				return new Port2EditPart(view);

			case PortName2EditPart.VISUAL_ID:
				return new PortName2EditPart(view);

			case Port3EditPart.VISUAL_ID:
				return new Port3EditPart(view);

			case PortName3EditPart.VISUAL_ID:
				return new PortName3EditPart(view);

			case PortIsBehavior2EditPart.VISUAL_ID:
				return new PortIsBehavior2EditPart(view);

			case SlotEditPart.VISUAL_ID:
				return new SlotEditPart(view);

			case CollaborationContentsEditPart.VISUAL_ID:
				return new CollaborationContentsEditPart(view);

			case ClassAttributesEditPart.VISUAL_ID:
				return new ClassAttributesEditPart(view);

			case ClassOperationsEditPart.VISUAL_ID:
				return new ClassOperationsEditPart(view);

			case ClassClassesEditPart.VISUAL_ID:
				return new ClassClassesEditPart(view);

			case PackageImportsEditPart.VISUAL_ID:
				return new PackageImportsEditPart(view);

			case ClassClass_contentsEditPart.VISUAL_ID:
				return new ClassClass_contentsEditPart(view);

			case InstanceSpecificationSlotsEditPart.VISUAL_ID:
				return new InstanceSpecificationSlotsEditPart(view);

			case ConnectorEditPart.VISUAL_ID:
				return new ConnectorEditPart(view);

			case ConnectorNameEditPart.VISUAL_ID:
				return new ConnectorNameEditPart(view);

			case ConnectorName2EditPart.VISUAL_ID:
				return new ConnectorName2EditPart(view);

			case ConnectorName3EditPart.VISUAL_ID:
				return new ConnectorName3EditPart(view);

			case ConnectorName4EditPart.VISUAL_ID:
				return new ConnectorName4EditPart(view);

			case ConnectorName5EditPart.VISUAL_ID:
				return new ConnectorName5EditPart(view);

			case ConnectorName6EditPart.VISUAL_ID:
				return new ConnectorName6EditPart(view);

			case ConnectorName7EditPart.VISUAL_ID:
				return new ConnectorName7EditPart(view);

			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);

			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);

			case InterfaceRealizationEditPart.VISUAL_ID:
				return new InterfaceRealizationEditPart(view);

			case UsageEditPart.VISUAL_ID:
				return new UsageEditPart(view);

			case PortProvidedEditPart.VISUAL_ID:
				return new PortProvidedEditPart(view);

			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);

			case AssociationNameEditPart.VISUAL_ID:
				return new AssociationNameEditPart(view);

			case AssociationName2EditPart.VISUAL_ID:
				return new AssociationName2EditPart(view);

			case AssociationName3EditPart.VISUAL_ID:
				return new AssociationName3EditPart(view);

			case AssociationName4EditPart.VISUAL_ID:
				return new AssociationName4EditPart(view);

			case AssociationName5EditPart.VISUAL_ID:
				return new AssociationName5EditPart(view);

			case AssociationName6EditPart.VISUAL_ID:
				return new AssociationName6EditPart(view);

			case AssociationName7EditPart.VISUAL_ID:
				return new AssociationName7EditPart(view);

			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);

			case PortRequiredEditPart.VISUAL_ID:
				return new PortRequiredEditPart(view);

			case AssociationInstanceEditPart.VISUAL_ID:
				return new AssociationInstanceEditPart(view);

			case AssociationInstanceSourceEditPart.VISUAL_ID:
				return new AssociationInstanceSourceEditPart(view);

			case AssociationInstanceTargetEditPart.VISUAL_ID:
				return new AssociationInstanceTargetEditPart(view);

			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel) {
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		} else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}

	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
