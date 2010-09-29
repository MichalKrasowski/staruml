package org.eclipse.uml2.diagram.usecase.edit.parts;

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
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;

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

			case DiagramHeaderEditPart.VISUAL_ID:
				return new DiagramHeaderEditPart(view);

			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);

			case PackageStereo2EditPart.VISUAL_ID:
				return new PackageStereo2EditPart(view);

			case ActorEditPart.VISUAL_ID:
				return new ActorEditPart(view);

			case ActorNameEditPart.VISUAL_ID:
				return new ActorNameEditPart(view);

			case ActorAsRectangleEditPart.VISUAL_ID:
				return new ActorAsRectangleEditPart(view);

			case ActorName2EditPart.VISUAL_ID:
				return new ActorName2EditPart(view);

			case ActorStereoEditPart.VISUAL_ID:
				return new ActorStereoEditPart(view);

			case UseCaseEditPart.VISUAL_ID:
				return new UseCaseEditPart(view);

			case UseCaseNameEditPart.VISUAL_ID:
				return new UseCaseNameEditPart(view);

			case UseCaseAsClassEditPart.VISUAL_ID:
				return new UseCaseAsClassEditPart(view);

			case UseCaseName2EditPart.VISUAL_ID:
				return new UseCaseName2EditPart(view);

			case UseCaseStereoEditPart.VISUAL_ID:
				return new UseCaseStereoEditPart(view);

			case SubjectEditPart.VISUAL_ID:
				return new SubjectEditPart(view);

			case SubjectNameEditPart.VISUAL_ID:
				return new SubjectNameEditPart(view);

			case ComponentStereoEditPart.VISUAL_ID:
				return new ComponentStereoEditPart(view);

			case NestedPackageEditPart.VISUAL_ID:
				return new NestedPackageEditPart(view);

			case NestedPackageNameEditPart.VISUAL_ID:
				return new NestedPackageNameEditPart(view);

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

			case ElementImportEditPart.VISUAL_ID:
				return new ElementImportEditPart(view);

			case ExtensionPointEditPart.VISUAL_ID:
				return new ExtensionPointEditPart(view);

			case ExtensionPoint2EditPart.VISUAL_ID:
				return new ExtensionPoint2EditPart(view);

			case InnerUseCaseEditPart.VISUAL_ID:
				return new InnerUseCaseEditPart(view);

			case UseCaseName3EditPart.VISUAL_ID:
				return new UseCaseName3EditPart(view);

			case ActorInPackageEditPart.VISUAL_ID:
				return new ActorInPackageEditPart(view);

			case ActorName3EditPart.VISUAL_ID:
				return new ActorName3EditPart(view);

			case UseCaseinPackageEditPart.VISUAL_ID:
				return new UseCaseinPackageEditPart(view);

			case UseCaseName4EditPart.VISUAL_ID:
				return new UseCaseName4EditPart(view);

			case PackageImportsEditPart.VISUAL_ID:
				return new PackageImportsEditPart(view);

			case UseCaseExtensionPointsEditPart.VISUAL_ID:
				return new UseCaseExtensionPointsEditPart(view);

			case UseCaseAsClassExtensionPointsEditPart.VISUAL_ID:
				return new UseCaseAsClassExtensionPointsEditPart(view);

			case SubjectUsecasesEditPart.VISUAL_ID:
				return new SubjectUsecasesEditPart(view);

			case InnerUseCaseExtensionPointsEditPart.VISUAL_ID:
				return new InnerUseCaseExtensionPointsEditPart(view);

			case PackageFramecontentsEditPart.VISUAL_ID:
				return new PackageFramecontentsEditPart(view);

			case UseCasePointsEditPart.VISUAL_ID:
				return new UseCasePointsEditPart(view);

			case IncludeEditPart.VISUAL_ID:
				return new IncludeEditPart(view);

			case IncludeLink_fixedEditPart.VISUAL_ID:
				return new IncludeLink_fixedEditPart(view);

			case ExtendEditPart.VISUAL_ID:
				return new ExtendEditPart(view);

			case ExtendsLink_fixedEditPart.VISUAL_ID:
				return new ExtendsLink_fixedEditPart(view);

			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);

			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);

			case AssociationTargetMultiplicityEditPart.VISUAL_ID:
				return new AssociationTargetMultiplicityEditPart(view);

			case AssociationSourceMultiplicityEditPart.VISUAL_ID:
				return new AssociationSourceMultiplicityEditPart(view);

			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);

			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);

			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);

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
