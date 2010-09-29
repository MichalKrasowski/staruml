package org.eclipse.uml2.diagram.deploy.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileName3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommunicationPathEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommunicationPathNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentConfigurationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecification2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Device2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironment2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ManifestationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ManifestationNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Node2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.deploy.providers.UMLParserProvider;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */
public class UMLNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof UMLNavigatorItem && !isOwnView(((UMLNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_1000); //$NON-NLS-1$
		case Package2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2001); //$NON-NLS-1$
		case DeviceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Device", UMLElementTypes.Device_2003); //$NON-NLS-1$
		case NodeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Node", UMLElementTypes.Node_2004); //$NON-NLS-1$
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?ExecutionEnvironment", UMLElementTypes.ExecutionEnvironment_2005); //$NON-NLS-1$
		case Artifact2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Artifact", UMLElementTypes.Artifact_2006); //$NON-NLS-1$
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?DeploymentSpecification", UMLElementTypes.DeploymentSpecification_2007); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Comment", UMLElementTypes.Comment_2008); //$NON-NLS-1$
		case ElementImportEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ElementImport", UMLElementTypes.ElementImport_3001); //$NON-NLS-1$
		case Device2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Device", UMLElementTypes.Device_3004); //$NON-NLS-1$
		case ArtifactEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Artifact", UMLElementTypes.Artifact_3002); //$NON-NLS-1$
		case Artifact4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Artifact", UMLElementTypes.Artifact_3008); //$NON-NLS-1$
		case DeploymentSpecification2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DeploymentSpecification", UMLElementTypes.DeploymentSpecification_3009); //$NON-NLS-1$
		case PropertyEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3003); //$NON-NLS-1$
		case ExecutionEnvironment2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ExecutionEnvironment", UMLElementTypes.ExecutionEnvironment_3005); //$NON-NLS-1$
		case Artifact3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Artifact", UMLElementTypes.Artifact_3006); //$NON-NLS-1$
		case Node2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Node", UMLElementTypes.Node_3007); //$NON-NLS-1$
		case DeploymentEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Deployment", UMLElementTypes.Deployment_4001); //$NON-NLS-1$
		case ManifestationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Manifestation", UMLElementTypes.Manifestation_4002); //$NON-NLS-1$
		case DeploymentConfigurationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Deployment?configuration", UMLElementTypes.DeploymentConfiguration_4003); //$NON-NLS-1$
		case CommunicationPathEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?CommunicationPath", UMLElementTypes.CommunicationPath_4004); //$NON-NLS-1$
		case DependencyEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Dependency", UMLElementTypes.Dependency_4005); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4006); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UMLDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && UMLElementTypes.isKnownElementType(elementType)) {
			image = UMLElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000Text(view);
		case Package2EditPart.VISUAL_ID:
			return getPackage_2001Text(view);
		case DeviceEditPart.VISUAL_ID:
			return getDevice_2003Text(view);
		case NodeEditPart.VISUAL_ID:
			return getNode_2004Text(view);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return getExecutionEnvironment_2005Text(view);
		case Artifact2EditPart.VISUAL_ID:
			return getArtifact_2006Text(view);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return getDeploymentSpecification_2007Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2008Text(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3001Text(view);
		case Device2EditPart.VISUAL_ID:
			return getDevice_3004Text(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_3002Text(view);
		case Artifact4EditPart.VISUAL_ID:
			return getArtifact_3008Text(view);
		case DeploymentSpecification2EditPart.VISUAL_ID:
			return getDeploymentSpecification_3009Text(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3003Text(view);
		case ExecutionEnvironment2EditPart.VISUAL_ID:
			return getExecutionEnvironment_3005Text(view);
		case Artifact3EditPart.VISUAL_ID:
			return getArtifact_3006Text(view);
		case Node2EditPart.VISUAL_ID:
			return getNode_3007Text(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4001Text(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4002Text(view);
		case DeploymentConfigurationEditPart.VISUAL_ID:
			return getDeploymentConfiguration_4003Text(view);
		case CommunicationPathEditPart.VISUAL_ID:
			return getCommunicationPath_4004Text(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4005Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4006Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_1000Text(View view) {
		Package domainModelElement = (Package) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_2001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDevice_2003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Device_2003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DeviceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNode_2004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Node_2004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(NodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExecutionEnvironment_2005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExecutionEnvironment_2005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExecutionEnvironmentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getArtifact_2006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Artifact_2006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ArtifactFileNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDeploymentSpecification_2007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DeploymentSpecification_2007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(DeploymentSpecificationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_2008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_2008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getElementImport_3001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ElementImport_3001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ElementImportEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDevice_3004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Device_3004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DeviceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getArtifact_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Artifact_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ArtifactFileName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getArtifact_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Artifact_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ArtifactFileName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDeploymentSpecification_3009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DeploymentSpecification_3009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(DeploymentSpecificationName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExecutionEnvironment_3005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExecutionEnvironment_3005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExecutionEnvironmentName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getArtifact_3006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Artifact_3006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNode_3007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Node_3007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(NodeName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_3003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDeployment_4001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Deployment_4001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(DeploymentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getManifestation_4002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Manifestation_4002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ManifestationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDeploymentConfiguration_4003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommunicationPath_4004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CommunicationPath_4004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CommunicationPathNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependency_4005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Dependency_4005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(DependencyNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_4006Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

}
