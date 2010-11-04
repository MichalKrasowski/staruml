package org.eclipse.uml2.diagram.profile.edit.parts;

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
import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;

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

			case ProfileEditPart.VISUAL_ID:
				return new ProfileEditPart(view);

			case StereotypeEditPart.VISUAL_ID:
				return new StereotypeEditPart(view);

			case StereotypeNameEditPart.VISUAL_ID:
				return new StereotypeNameEditPart(view);

			case StereotypeStereoEditPart.VISUAL_ID:
				return new StereotypeStereoEditPart(view);

			case Profile2EditPart.VISUAL_ID:
				return new Profile2EditPart(view);

			case ProfileNameEditPart.VISUAL_ID:
				return new ProfileNameEditPart(view);

			case ProfileStereoEditPart.VISUAL_ID:
				return new ProfileStereoEditPart(view);

			case EnumerationEditPart.VISUAL_ID:
				return new EnumerationEditPart(view);

			case EnumerationNameEditPart.VISUAL_ID:
				return new EnumerationNameEditPart(view);

			case EnumerationQualifiedNameEditPart.VISUAL_ID:
				return new EnumerationQualifiedNameEditPart(view);

			case ElementImportEditPart.VISUAL_ID:
				return new ElementImportEditPart(view);

			case ReferencedMetaclassNode_classNameEditPart.VISUAL_ID:
				return new ReferencedMetaclassNode_classNameEditPart(view);

			case Profile3EditPart.VISUAL_ID:
				return new Profile3EditPart(view);

			case ProfileName2EditPart.VISUAL_ID:
				return new ProfileName2EditPart(view);

			case Constraint2EditPart.VISUAL_ID:
				return new Constraint2EditPart(view);

			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);

			case ConstraintLanguageEditPart.VISUAL_ID:
				return new ConstraintLanguageEditPart(view);

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case PropertyEditPart.VISUAL_ID:
				return new PropertyEditPart(view);

			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);

			case ImageEditPart.VISUAL_ID:
				return new ImageEditPart(view);

			case Stereotype2EditPart.VISUAL_ID:
				return new Stereotype2EditPart(view);

			case EnumerationLiteralEditPart.VISUAL_ID:
				return new EnumerationLiteralEditPart(view);

			case ElementImport2EditPart.VISUAL_ID:
				return new ElementImport2EditPart(view);

			case StereotypeAttributesEditPart.VISUAL_ID:
				return new StereotypeAttributesEditPart(view);

			case StereotypeConstraintsEditPart.VISUAL_ID:
				return new StereotypeConstraintsEditPart(view);

			case StereotypeImagesEditPart.VISUAL_ID:
				return new StereotypeImagesEditPart(view);

			case ProfileContentsEditPart.VISUAL_ID:
				return new ProfileContentsEditPart(view);

			case EnumerationLiteralsEditPart.VISUAL_ID:
				return new EnumerationLiteralsEditPart(view);

			case ProfileProfileLabelsEditPart.VISUAL_ID:
				return new ProfileProfileLabelsEditPart(view);

			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);

			case ExtensionEditPart.VISUAL_ID:
				return new ExtensionEditPart(view);

			case ExtensionLink_requiredEditPart.VISUAL_ID:
				return new ExtensionLink_requiredEditPart(view);

			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);

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
