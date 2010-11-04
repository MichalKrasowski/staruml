package org.eclipse.uml2.diagram.component.edit.parts;

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
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;

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

			case ComponentEditPart.VISUAL_ID:
				return new ComponentEditPart(view);

			case ComponentName2EditPart.VISUAL_ID:
				return new ComponentName2EditPart(view);

			case ComponentStereoEditPart.VISUAL_ID:
				return new ComponentStereoEditPart(view);

			case Artifact2EditPart.VISUAL_ID:
				return new Artifact2EditPart(view);

			case ArtifactName2EditPart.VISUAL_ID:
				return new ArtifactName2EditPart(view);

			case ArtifactStereoEditPart.VISUAL_ID:
				return new ArtifactStereoEditPart(view);

			case Interface2EditPart.VISUAL_ID:
				return new Interface2EditPart(view);

			case InterfaceName2EditPart.VISUAL_ID:
				return new InterfaceName2EditPart(view);

			case Class2EditPart.VISUAL_ID:
				return new Class2EditPart(view);

			case ClassName2EditPart.VISUAL_ID:
				return new ClassName2EditPart(view);

			case Package2EditPart.VISUAL_ID:
				return new Package2EditPart(view);

			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);

			case PackageStereo2EditPart.VISUAL_ID:
				return new PackageStereo2EditPart(view);

			case Package3EditPart.VISUAL_ID:
				return new Package3EditPart(view);

			case PackageName2EditPart.VISUAL_ID:
				return new PackageName2EditPart(view);

			case ClassDiagramNotationClassEditPart.VISUAL_ID:
				return new ClassDiagramNotationClassEditPart(view);

			case ClassDiagramNotationClassNameEditPart.VISUAL_ID:
				return new ClassDiagramNotationClassNameEditPart(view);

			case ClassDiagramNotationClassStereotypeEditPart.VISUAL_ID:
				return new ClassDiagramNotationClassStereotypeEditPart(view);

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case Component2EditPart.VISUAL_ID:
				return new Component2EditPart(view);

			case ComponentNameEditPart.VISUAL_ID:
				return new ComponentNameEditPart(view);

			case ComponentStereo2EditPart.VISUAL_ID:
				return new ComponentStereo2EditPart(view);

			case PortEditPart.VISUAL_ID:
				return new PortEditPart(view);

			case PortNameEditPart.VISUAL_ID:
				return new PortNameEditPart(view);

			case ArtifactEditPart.VISUAL_ID:
				return new ArtifactEditPart(view);

			case ArtifactNameEditPart.VISUAL_ID:
				return new ArtifactNameEditPart(view);

			case ArtifactStereo2EditPart.VISUAL_ID:
				return new ArtifactStereo2EditPart(view);

			case Artifact3EditPart.VISUAL_ID:
				return new Artifact3EditPart(view);

			case ArtifactName3EditPart.VISUAL_ID:
				return new ArtifactName3EditPart(view);

			case ArtifactStereo3EditPart.VISUAL_ID:
				return new ArtifactStereo3EditPart(view);

			case ClassEditPart.VISUAL_ID:
				return new ClassEditPart(view);

			case ClassNameEditPart.VISUAL_ID:
				return new ClassNameEditPart(view);

			case InterfaceEditPart.VISUAL_ID:
				return new InterfaceEditPart(view);

			case InterfaceNameEditPart.VISUAL_ID:
				return new InterfaceNameEditPart(view);

			case PropertyEditPart.VISUAL_ID:
				return new PropertyEditPart(view);

			case PropertyNameEditPart.VISUAL_ID:
				return new PropertyNameEditPart(view);

			case AssemblyConnectorCircleEditPart.VISUAL_ID:
				return new AssemblyConnectorCircleEditPart(view);

			case ElementImportEditPart.VISUAL_ID:
				return new ElementImportEditPart(view);

			case Package4EditPart.VISUAL_ID:
				return new Package4EditPart(view);

			case Class3EditPart.VISUAL_ID:
				return new Class3EditPart(view);

			case Component3EditPart.VISUAL_ID:
				return new Component3EditPart(view);

			case ClassDiagramNotationPropertyEditPart.VISUAL_ID:
				return new ClassDiagramNotationPropertyEditPart(view);

			case ClassDiagramNotationOperationEditPart.VISUAL_ID:
				return new ClassDiagramNotationOperationEditPart(view);

			case ClassDiagramNotationInnerClassEditPart.VISUAL_ID:
				return new ClassDiagramNotationInnerClassEditPart(view);

			case PortOnClassEditPart.VISUAL_ID:
				return new PortOnClassEditPart(view);

			case PortName2EditPart.VISUAL_ID:
				return new PortName2EditPart(view);

			case ComponentContentsEditPart.VISUAL_ID:
				return new ComponentContentsEditPart(view);

			case ComponentContents2EditPart.VISUAL_ID:
				return new ComponentContents2EditPart(view);

			case ArtifactContentsEditPart.VISUAL_ID:
				return new ArtifactContentsEditPart(view);

			case ArtifactContents2EditPart.VISUAL_ID:
				return new ArtifactContents2EditPart(view);

			case ArtifactContents3EditPart.VISUAL_ID:
				return new ArtifactContents3EditPart(view);

			case PackageImportsEditPart.VISUAL_ID:
				return new PackageImportsEditPart(view);

			case PackagePackagesEditPart.VISUAL_ID:
				return new PackagePackagesEditPart(view);

			case PackageClassifiersEditPart.VISUAL_ID:
				return new PackageClassifiersEditPart(view);

			case ClassAttributesEditPart.VISUAL_ID:
				return new ClassAttributesEditPart(view);

			case ClassOperationsEditPart.VISUAL_ID:
				return new ClassOperationsEditPart(view);

			case ClassClassesEditPart.VISUAL_ID:
				return new ClassClassesEditPart(view);

			case InterfaceRealizationEditPart.VISUAL_ID:
				return new InterfaceRealizationEditPart(view);

			case PortProvidedEditPart.VISUAL_ID:
				return new PortProvidedEditPart(view);

			case PortRequiredEditPart.VISUAL_ID:
				return new PortRequiredEditPart(view);

			case ComponentRequiredEditPart.VISUAL_ID:
				return new ComponentRequiredEditPart(view);

			case ConnectorEditPart.VISUAL_ID:
				return new ConnectorEditPart(view);

			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);

			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);

			case AssemblyConnectorEndRoleEditPart.VISUAL_ID:
				return new AssemblyConnectorEndRoleEditPart(view);

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
