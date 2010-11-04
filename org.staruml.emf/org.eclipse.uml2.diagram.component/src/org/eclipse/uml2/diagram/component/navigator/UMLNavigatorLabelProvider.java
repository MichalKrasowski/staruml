package org.eclipse.uml2.diagram.component.navigator;

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
import org.eclipse.uml2.diagram.component.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactName3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssemblyConnectorCircleEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssemblyConnectorEndRoleEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationInnerClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationOperationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationPropertyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentRequiredEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package4EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortOnClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.component.providers.UMLParserProvider;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.InterfaceRealization;
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
		case ComponentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Component", UMLElementTypes.Component_2001); //$NON-NLS-1$
		case Artifact2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Artifact", UMLElementTypes.Artifact_2002); //$NON-NLS-1$
		case Interface2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Interface", UMLElementTypes.Interface_2003); //$NON-NLS-1$
		case Class2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_2004); //$NON-NLS-1$
		case Package2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2005); //$NON-NLS-1$
		case Package3EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2006); //$NON-NLS-1$
		case ClassDiagramNotationClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_2007); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Comment", UMLElementTypes.Comment_2008); //$NON-NLS-1$
		case Component2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Component", UMLElementTypes.Component_3001); //$NON-NLS-1$
		case PortEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Port", UMLElementTypes.Port_3002); //$NON-NLS-1$
		case ArtifactEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Artifact", UMLElementTypes.Artifact_3003); //$NON-NLS-1$
		case Artifact3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Artifact", UMLElementTypes.Artifact_3016); //$NON-NLS-1$
		case ClassEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_3004); //$NON-NLS-1$
		case InterfaceEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Interface", UMLElementTypes.Interface_3005); //$NON-NLS-1$
		case PropertyEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3006); //$NON-NLS-1$
		case AssemblyConnectorCircleEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Connector", UMLElementTypes.Connector_3015); //$NON-NLS-1$
		case ElementImportEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ElementImport", UMLElementTypes.ElementImport_3007); //$NON-NLS-1$
		case Package4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_3008); //$NON-NLS-1$
		case Class3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_3009); //$NON-NLS-1$
		case Component3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Component", UMLElementTypes.Component_3010); //$NON-NLS-1$
		case ClassDiagramNotationPropertyEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3011); //$NON-NLS-1$
		case ClassDiagramNotationOperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", UMLElementTypes.Operation_3012); //$NON-NLS-1$
		case ClassDiagramNotationInnerClassEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_3013); //$NON-NLS-1$
		case PortOnClassEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Port", UMLElementTypes.Port_3014); //$NON-NLS-1$
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?InterfaceRealization", UMLElementTypes.InterfaceRealization_4001); //$NON-NLS-1$
		case PortProvidedEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Port?provided", UMLElementTypes.PortProvided_4006); //$NON-NLS-1$
		case PortRequiredEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Port?required", UMLElementTypes.PortRequired_4004); //$NON-NLS-1$
		case ComponentRequiredEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Component?required", UMLElementTypes.ComponentRequired_4007); //$NON-NLS-1$
		case ConnectorEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Connector", UMLElementTypes.Connector_4008); //$NON-NLS-1$
		case DependencyEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Dependency", UMLElementTypes.Dependency_4009); //$NON-NLS-1$
		case AssemblyConnectorEndRoleEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?ConnectorEnd?role", UMLElementTypes.ConnectorEndRole_4010); //$NON-NLS-1$
		case AssociationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Association", UMLElementTypes.Association_4011); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4012); //$NON-NLS-1$
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
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2001Text(view);
		case Artifact2EditPart.VISUAL_ID:
			return getArtifact_2002Text(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_2003Text(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_2004Text(view);
		case Package2EditPart.VISUAL_ID:
			return getPackage_2005Text(view);
		case Package3EditPart.VISUAL_ID:
			return getPackage_2006Text(view);
		case ClassDiagramNotationClassEditPart.VISUAL_ID:
			return getClass_2007Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2008Text(view);
		case Component2EditPart.VISUAL_ID:
			return getComponent_3001Text(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3002Text(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_3003Text(view);
		case Artifact3EditPart.VISUAL_ID:
			return getArtifact_3016Text(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3004Text(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3005Text(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3006Text(view);
		case AssemblyConnectorCircleEditPart.VISUAL_ID:
			return getConnector_3015Text(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3007Text(view);
		case Package4EditPart.VISUAL_ID:
			return getPackage_3008Text(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_3009Text(view);
		case Component3EditPart.VISUAL_ID:
			return getComponent_3010Text(view);
		case ClassDiagramNotationPropertyEditPart.VISUAL_ID:
			return getProperty_3011Text(view);
		case ClassDiagramNotationOperationEditPart.VISUAL_ID:
			return getOperation_3012Text(view);
		case ClassDiagramNotationInnerClassEditPart.VISUAL_ID:
			return getClass_3013Text(view);
		case PortOnClassEditPart.VISUAL_ID:
			return getPort_3014Text(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4001Text(view);
		case PortProvidedEditPart.VISUAL_ID:
			return getPortProvided_4006Text(view);
		case PortRequiredEditPart.VISUAL_ID:
			return getPortRequired_4004Text(view);
		case ComponentRequiredEditPart.VISUAL_ID:
			return getComponentRequired_4007Text(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4008Text(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4009Text(view);
		case AssemblyConnectorEndRoleEditPart.VISUAL_ID:
			return getConnectorEndRole_4010Text(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4012Text(view);
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
	private String getComponent_2001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Component_2001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ComponentName2EditPart.VISUAL_ID));
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
	private String getArtifact_2002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Artifact_2002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ArtifactName2EditPart.VISUAL_ID));
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
	private String getInterface_2003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Interface_2003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InterfaceName2EditPart.VISUAL_ID));
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
	private String getClass_2004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_2004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ClassName2EditPart.VISUAL_ID));
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
	private String getPackage_2005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
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
	private String getPackage_2006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageName2EditPart.VISUAL_ID));
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
	private String getClass_2007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_2007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ClassDiagramNotationClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5014); //$NON-NLS-1$
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
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponent_3001Text(View view) {
		IParser parser = UMLParserProvider
				.getParser(UMLElementTypes.Component_3001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ComponentNameEditPart.VISUAL_ID));
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
	private String getPort_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Port_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PortNameEditPart.VISUAL_ID));
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
	private String getArtifact_3003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Artifact_3003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ArtifactNameEditPart.VISUAL_ID));
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
	private String getArtifact_3016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Artifact_3016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ArtifactName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_3004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_3004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
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
	private String getInterface_3005Text(View view) {
		IParser parser = UMLParserProvider
				.getParser(UMLElementTypes.Interface_3005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
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
	private String getProperty_3006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PropertyNameEditPart.VISUAL_ID));
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
	private String getConnector_3015Text(View view) {
		Connector domainModelElement = (Connector) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getElementImport_3007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ElementImport_3007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ElementImportEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Package4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_3009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_3009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponent_3010Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Component_3010, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_3011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ClassDiagramNotationPropertyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_3012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Operation_3012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ClassDiagramNotationOperationEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_3013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_3013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ClassDiagramNotationInnerClassEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPort_3014Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Port_3014, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PortName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterfaceRealization_4001Text(View view) {
		InterfaceRealization domainModelElement = (InterfaceRealization) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPortProvided_4006Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPortRequired_4004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getComponentRequired_4007Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getConnector_4008Text(View view) {
		Connector domainModelElement = (Connector) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependency_4009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Dependency_4009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(DependencyNameEditPart.VISUAL_ID));
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
	private String getConnectorEndRole_4010Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAssociation_4011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Association_4011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AssociationNameEditPart.VISUAL_ID));
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
	private String getCommentAnnotatedElement_4012Text(View view) {
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
