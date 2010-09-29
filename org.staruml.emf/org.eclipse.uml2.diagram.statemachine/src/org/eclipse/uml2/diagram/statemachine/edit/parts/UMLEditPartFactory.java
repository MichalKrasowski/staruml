package org.eclipse.uml2.diagram.statemachine.edit.parts;

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
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;

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

			case StateMachineEditPart.VISUAL_ID:
				return new StateMachineEditPart(view);

			case StateMachineNameEditPart.VISUAL_ID:
				return new StateMachineNameEditPart(view);

			case StateMachineStereotypeEditPart.VISUAL_ID:
				return new StateMachineStereotypeEditPart(view);

			case StateMachine_RegionEditPart.VISUAL_ID:
				return new StateMachine_RegionEditPart(view);

			case SimpleStateEditPart.VISUAL_ID:
				return new SimpleStateEditPart(view);

			case SimpleStateNameEditPart.VISUAL_ID:
				return new SimpleStateNameEditPart(view);

			case SimpleStateStereotypeEditPart.VISUAL_ID:
				return new SimpleStateStereotypeEditPart(view);

			case EntryActivityEditPart.VISUAL_ID:
				return new EntryActivityEditPart(view);

			case ExitActivityEditPart.VISUAL_ID:
				return new ExitActivityEditPart(view);

			case DoActivityEditPart.VISUAL_ID:
				return new DoActivityEditPart(view);

			case CompositeStateEditPart.VISUAL_ID:
				return new CompositeStateEditPart(view);

			case CompositeStateNameEditPart.VISUAL_ID:
				return new CompositeStateNameEditPart(view);

			case CompositeStateStereotypeEditPart.VISUAL_ID:
				return new CompositeStateStereotypeEditPart(view);

			case State_RegionEditPart.VISUAL_ID:
				return new State_RegionEditPart(view);

			case SubmachineStateEditPart.VISUAL_ID:
				return new SubmachineStateEditPart(view);

			case SubmachineStateNameEditPart.VISUAL_ID:
				return new SubmachineStateNameEditPart(view);

			case SubmachineStateStereotypeEditPart.VISUAL_ID:
				return new SubmachineStateStereotypeEditPart(view);

			case EntryConnectionPointReferenceEditPart.VISUAL_ID:
				return new EntryConnectionPointReferenceEditPart(view);

			case EntryConnectionPointReferenceNameEditPart.VISUAL_ID:
				return new EntryConnectionPointReferenceNameEditPart(view);

			case ExitConnectionPointReferenceEditPart.VISUAL_ID:
				return new ExitConnectionPointReferenceEditPart(view);

			case ExitConnectionPointReferenceNameEditPart.VISUAL_ID:
				return new ExitConnectionPointReferenceNameEditPart(view);

			case InternalTransitionEditPart.VISUAL_ID:
				return new InternalTransitionEditPart(view);

			case FinalStateEditPart.VISUAL_ID:
				return new FinalStateEditPart(view);

			case InitialPseudostateEditPart.VISUAL_ID:
				return new InitialPseudostateEditPart(view);

			case ShallowHistoryPseudostateEditPart.VISUAL_ID:
				return new ShallowHistoryPseudostateEditPart(view);

			case DeepHistoryPseudostateEditPart.VISUAL_ID:
				return new DeepHistoryPseudostateEditPart(view);

			case ForkPseudostateEditPart.VISUAL_ID:
				return new ForkPseudostateEditPart(view);

			case JoinPseudostateEditPart.VISUAL_ID:
				return new JoinPseudostateEditPart(view);

			case JunctionPseudostateEditPart.VISUAL_ID:
				return new JunctionPseudostateEditPart(view);

			case ChoicePseudostateEditPart.VISUAL_ID:
				return new ChoicePseudostateEditPart(view);

			case TerminatePseudostateEditPart.VISUAL_ID:
				return new TerminatePseudostateEditPart(view);

			case EntryPointPseudostateEditPart.VISUAL_ID:
				return new EntryPointPseudostateEditPart(view);

			case EntryPointPseudostateNameEditPart.VISUAL_ID:
				return new EntryPointPseudostateNameEditPart(view);

			case ExitPointPseudostateEditPart.VISUAL_ID:
				return new ExitPointPseudostateEditPart(view);

			case ExitPointPseudostateNameEditPart.VISUAL_ID:
				return new ExitPointPseudostateNameEditPart(view);

			case StateMachine_RegionSubverticesEditPart.VISUAL_ID:
				return new StateMachine_RegionSubverticesEditPart(view);

			case SimpleState_InternalActivitiesEditPart.VISUAL_ID:
				return new SimpleState_InternalActivitiesEditPart(view);

			case CompositeState_InternalActivitiesEditPart.VISUAL_ID:
				return new CompositeState_InternalActivitiesEditPart(view);

			case CompositeState_InternalTransitionsEditPart.VISUAL_ID:
				return new CompositeState_InternalTransitionsEditPart(view);

			case State_RegionSubverticesEditPart.VISUAL_ID:
				return new State_RegionSubverticesEditPart(view);

			case SubmachineState_InternalActivitiesEditPart.VISUAL_ID:
				return new SubmachineState_InternalActivitiesEditPart(view);

			case SubmachineState_InternalTransitionsEditPart.VISUAL_ID:
				return new SubmachineState_InternalTransitionsEditPart(view);

			case TransitionEditPart.VISUAL_ID:
				return new TransitionEditPart(view);

			case TransitionNameEditPart.VISUAL_ID:
				return new TransitionNameEditPart(view);
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
