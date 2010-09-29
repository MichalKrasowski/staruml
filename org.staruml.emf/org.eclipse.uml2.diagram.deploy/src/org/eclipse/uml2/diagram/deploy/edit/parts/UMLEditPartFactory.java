package org.eclipse.uml2.diagram.deploy.edit.parts;

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
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;

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

			case Package2EditPart.VISUAL_ID:
				return new Package2EditPart(view);

			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);

			case PackageStereo2EditPart.VISUAL_ID:
				return new PackageStereo2EditPart(view);

			case DeviceEditPart.VISUAL_ID:
				return new DeviceEditPart(view);

			case DeviceNameEditPart.VISUAL_ID:
				return new DeviceNameEditPart(view);

			case DeviceStereoEditPart.VISUAL_ID:
				return new DeviceStereoEditPart(view);

			case NodeEditPart.VISUAL_ID:
				return new NodeEditPart(view);

			case NodeNameEditPart.VISUAL_ID:
				return new NodeNameEditPart(view);

			case NodeStereoEditPart.VISUAL_ID:
				return new NodeStereoEditPart(view);

			case ExecutionEnvironmentEditPart.VISUAL_ID:
				return new ExecutionEnvironmentEditPart(view);

			case ExecutionEnvironmentNameEditPart.VISUAL_ID:
				return new ExecutionEnvironmentNameEditPart(view);

			case ExecutionEnvironmentStereoEditPart.VISUAL_ID:
				return new ExecutionEnvironmentStereoEditPart(view);

			case Artifact2EditPart.VISUAL_ID:
				return new Artifact2EditPart(view);

			case ArtifactFileNameEditPart.VISUAL_ID:
				return new ArtifactFileNameEditPart(view);

			case ArtifactStereoEditPart.VISUAL_ID:
				return new ArtifactStereoEditPart(view);

			case DeploymentSpecificationEditPart.VISUAL_ID:
				return new DeploymentSpecificationEditPart(view);

			case DeploymentSpecificationNameEditPart.VISUAL_ID:
				return new DeploymentSpecificationNameEditPart(view);

			case DeploymentSpecificationStereo3EditPart.VISUAL_ID:
				return new DeploymentSpecificationStereo3EditPart(view);

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case ElementImportEditPart.VISUAL_ID:
				return new ElementImportEditPart(view);

			case Device2EditPart.VISUAL_ID:
				return new Device2EditPart(view);

			case DeviceName2EditPart.VISUAL_ID:
				return new DeviceName2EditPart(view);

			case DeviceStereo2EditPart.VISUAL_ID:
				return new DeviceStereo2EditPart(view);

			case ArtifactEditPart.VISUAL_ID:
				return new ArtifactEditPart(view);

			case ArtifactFileName2EditPart.VISUAL_ID:
				return new ArtifactFileName2EditPart(view);

			case ArtifactStereo2EditPart.VISUAL_ID:
				return new ArtifactStereo2EditPart(view);

			case Artifact4EditPart.VISUAL_ID:
				return new Artifact4EditPart(view);

			case ArtifactFileName3EditPart.VISUAL_ID:
				return new ArtifactFileName3EditPart(view);

			case ArtifactStereo3EditPart.VISUAL_ID:
				return new ArtifactStereo3EditPart(view);

			case DeploymentSpecification2EditPart.VISUAL_ID:
				return new DeploymentSpecification2EditPart(view);

			case DeploymentSpecificationName2EditPart.VISUAL_ID:
				return new DeploymentSpecificationName2EditPart(view);

			case DeploymentSpecificationStereo4EditPart.VISUAL_ID:
				return new DeploymentSpecificationStereo4EditPart(view);

			case PropertyEditPart.VISUAL_ID:
				return new PropertyEditPart(view);

			case ExecutionEnvironment2EditPart.VISUAL_ID:
				return new ExecutionEnvironment2EditPart(view);

			case ExecutionEnvironmentName2EditPart.VISUAL_ID:
				return new ExecutionEnvironmentName2EditPart(view);

			case ExecutionEnvironmentStereo2EditPart.VISUAL_ID:
				return new ExecutionEnvironmentStereo2EditPart(view);

			case Artifact3EditPart.VISUAL_ID:
				return new Artifact3EditPart(view);

			case Node2EditPart.VISUAL_ID:
				return new Node2EditPart(view);

			case NodeName2EditPart.VISUAL_ID:
				return new NodeName2EditPart(view);

			case NodeStereo2EditPart.VISUAL_ID:
				return new NodeStereo2EditPart(view);

			case PackageImportsEditPart.VISUAL_ID:
				return new PackageImportsEditPart(view);

			case DeviceDevicecontentsEditPart.VISUAL_ID:
				return new DeviceDevicecontentsEditPart(view);

			case DeviceDevicecontents2EditPart.VISUAL_ID:
				return new DeviceDevicecontents2EditPart(view);

			case ArtifactArtifactFigure_contentsEditPart.VISUAL_ID:
				return new ArtifactArtifactFigure_contentsEditPart(view);

			case ArtifactArtifactFigure_contents2EditPart.VISUAL_ID:
				return new ArtifactArtifactFigure_contents2EditPart(view);

			case DeploymentSpecificationProperties2EditPart.VISUAL_ID:
				return new DeploymentSpecificationProperties2EditPart(view);

			case ExecutionEnvironmentArtifacts2EditPart.VISUAL_ID:
				return new ExecutionEnvironmentArtifacts2EditPart(view);

			case ExecutionEnvironmentArtifactsEditPart.VISUAL_ID:
				return new ExecutionEnvironmentArtifactsEditPart(view);

			case ArtifactArtifactFigure_contents3EditPart.VISUAL_ID:
				return new ArtifactArtifactFigure_contents3EditPart(view);

			case DeploymentSpecificationPropertiesEditPart.VISUAL_ID:
				return new DeploymentSpecificationPropertiesEditPart(view);

			case DeploymentEditPart.VISUAL_ID:
				return new DeploymentEditPart(view);

			case DeploymentNameEditPart.VISUAL_ID:
				return new DeploymentNameEditPart(view);

			case ManifestationEditPart.VISUAL_ID:
				return new ManifestationEditPart(view);

			case ManifestationNameEditPart.VISUAL_ID:
				return new ManifestationNameEditPart(view);

			case DeploymentConfigurationEditPart.VISUAL_ID:
				return new DeploymentConfigurationEditPart(view);

			case CommunicationPathEditPart.VISUAL_ID:
				return new CommunicationPathEditPart(view);

			case CommunicationPathNameEditPart.VISUAL_ID:
				return new CommunicationPathNameEditPart(view);

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
