package org.eclipse.uml2.diagram.sequence.edit.parts;

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
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;

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

			case InteractionEditPart.VISUAL_ID:
				return new InteractionEditPart(view);

			case InteractionNameEditPart.VISUAL_ID:
				return new InteractionNameEditPart(view);

			case GateEditPart.VISUAL_ID:
				return new GateEditPart(view);

			case LayeredInteractionUseEditPart.VISUAL_ID:
				return new LayeredInteractionUseEditPart(view);

			case InteractionUseSignatureEditPart.VISUAL_ID:
				return new InteractionUseSignatureEditPart(view);

			case LayeredCombinedFragmentEditPart.VISUAL_ID:
				return new LayeredCombinedFragmentEditPart(view);

			case CombinedFragmentInteractionOperatorEditPart.VISUAL_ID:
				return new CombinedFragmentInteractionOperatorEditPart(view);

			case LayeredOperandEditPart.VISUAL_ID:
				return new LayeredOperandEditPart(view);

			case LifelineEditPart.VISUAL_ID:
				return new LifelineEditPart(view);

			case LifelineNameEditPart.VISUAL_ID:
				return new LifelineNameEditPart(view);

			case LifelineRefLabelEditPart.VISUAL_ID:
				return new LifelineRefLabelEditPart(view);

			case ActionExecutionSpecificationEditPart.VISUAL_ID:
				return new ActionExecutionSpecificationEditPart(view);

			case ActionExecutionLabelEditPart.VISUAL_ID:
				return new ActionExecutionLabelEditPart(view);

			case StateInvariantEditPart.VISUAL_ID:
				return new StateInvariantEditPart(view);

			case StateInvariantLabelEditPart.VISUAL_ID:
				return new StateInvariantLabelEditPart(view);

			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
				return new BehaviorExecutionSpecificationEditPart(view);

			case InteractionUseMountingRegionEditPart.VISUAL_ID:
				return new InteractionUseMountingRegionEditPart(view);

			case CombinedFragmentMountingRegionEditPart.VISUAL_ID:
				return new CombinedFragmentMountingRegionEditPart(view);

			case InteractionOperandMountingRegionEditPart.VISUAL_ID:
				return new InteractionOperandMountingRegionEditPart(view);

			case MessageEditPart.VISUAL_ID:
				return new MessageEditPart(view);

			case MessageNameEditPart.VISUAL_ID:
				return new MessageNameEditPart(view);

			case MountingLinkEditPart.VISUAL_ID:
				return new MountingLinkEditPart(view);

			case InnerMountingLinkEditPart.VISUAL_ID:
				return new InnerMountingLinkEditPart(view);
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
