package org.eclipse.uml2.diagram.csd.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
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
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceSourceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUse2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUseName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortName3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.csd.providers.UMLParserProvider;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Usage;

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
		case CollaborationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Collaboration", UMLElementTypes.Collaboration_2005); //$NON-NLS-1$
		case ClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_2006); //$NON-NLS-1$
		case Package2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2003); //$NON-NLS-1$
		case Class3EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_2007); //$NON-NLS-1$
		case InterfaceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Interface", UMLElementTypes.Interface_2009); //$NON-NLS-1$
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?InstanceSpecification", UMLElementTypes.InstanceSpecification_2011); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_2012); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Comment", UMLElementTypes.Comment_2013); //$NON-NLS-1$
		case CollaborationUse2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CollaborationUse", UMLElementTypes.CollaborationUse_3002); //$NON-NLS-1$
		case PropertyEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3007); //$NON-NLS-1$
		case Property2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3008); //$NON-NLS-1$
		case OperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", UMLElementTypes.Operation_3009); //$NON-NLS-1$
		case Class2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_3010); //$NON-NLS-1$
		case PortEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Port", UMLElementTypes.Port_3011); //$NON-NLS-1$
		case ElementImportEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ElementImport", UMLElementTypes.ElementImport_3004); //$NON-NLS-1$
		case Property3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3014); //$NON-NLS-1$
		case Port2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Port", UMLElementTypes.Port_3016); //$NON-NLS-1$
		case Port3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Port", UMLElementTypes.Port_3017); //$NON-NLS-1$
		case SlotEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Slot", UMLElementTypes.Slot_3015); //$NON-NLS-1$
		case ConnectorEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Connector", UMLElementTypes.Connector_4005); //$NON-NLS-1$
		case DependencyEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Dependency", UMLElementTypes.Dependency_4006); //$NON-NLS-1$
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?InterfaceRealization", UMLElementTypes.InterfaceRealization_4007); //$NON-NLS-1$
		case UsageEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Usage", UMLElementTypes.Usage_4008); //$NON-NLS-1$
		case PortProvidedEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Port?provided", UMLElementTypes.PortProvided_4010); //$NON-NLS-1$
		case AssociationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Association", UMLElementTypes.Association_4011); //$NON-NLS-1$
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Constraint?constrainedElement", UMLElementTypes.ConstraintConstrainedElement_4012); //$NON-NLS-1$
		case PortRequiredEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Port?required", UMLElementTypes.PortRequired_4014); //$NON-NLS-1$
		case AssociationInstanceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Slot", UMLElementTypes.Slot_4015); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4016); //$NON-NLS-1$
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
		case CollaborationEditPart.VISUAL_ID:
			return getCollaboration_2005Text(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2006Text(view);
		case Package2EditPart.VISUAL_ID:
			return getPackage_2003Text(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_2007Text(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2009Text(view);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_2011Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2012Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2013Text(view);
		case CollaborationUse2EditPart.VISUAL_ID:
			return getCollaborationUse_3002Text(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3007Text(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3008Text(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3009Text(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3010Text(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3011Text(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3004Text(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3014Text(view);
		case Port2EditPart.VISUAL_ID:
			return getPort_3016Text(view);
		case Port3EditPart.VISUAL_ID:
			return getPort_3017Text(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3015Text(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4005Text(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4006Text(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4007Text(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4008Text(view);
		case PortProvidedEditPart.VISUAL_ID:
			return getPortProvided_4010Text(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011Text(view);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getConstraintConstrainedElement_4012Text(view);
		case PortRequiredEditPart.VISUAL_ID:
			return getPortRequired_4014Text(view);
		case AssociationInstanceEditPart.VISUAL_ID:
			return getSlot_4015Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4016Text(view);
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
	private String getCollaboration_2005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Collaboration_2005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CollaborationNameEditPart.VISUAL_ID));
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
	private String getClass_2006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_2006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
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
	private String getPackage_2003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
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
	private String getClass_2007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_2007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ClassName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterface_2009Text(View view) {
		IParser parser = UMLParserProvider
				.getParser(UMLElementTypes.Interface_2009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInstanceSpecification_2011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InstanceSpecification_2011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InstanceSpecificationNameEditPart.VISUAL_ID));
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
	private String getConstraint_2012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_2012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ConstraintNameEditPart.VISUAL_ID));
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
	private String getComment_2013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_2013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCollaborationUse_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CollaborationUse_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CollaborationUseName2EditPart.VISUAL_ID));
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
	private String getProperty_3007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PropertyNameEditPart.VISUAL_ID));
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
	private String getProperty_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Property2EditPart.VISUAL_ID));
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
	private String getOperation_3009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Operation_3009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OperationEditPart.VISUAL_ID));
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
	private String getClass_3010Text(View view) {
		Class domainModelElement = (Class) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPort_3011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Port_3011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PortNameEditPart.VISUAL_ID));
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
	private String getElementImport_3004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ElementImport_3004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ElementImportEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_3014Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3014, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PropertyName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPort_3016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Port_3016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PortName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPort_3017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Port_3017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PortName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSlot_3015Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Slot_3015, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(SlotEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConnector_4005Text(View view) {
		IParser parser = UMLParserProvider
				.getParser(UMLElementTypes.Connector_4005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConnectorNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependency_4006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Dependency_4006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
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
	private String getInterfaceRealization_4007Text(View view) {
		InterfaceRealization domainModelElement = (InterfaceRealization) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUsage_4008Text(View view) {
		Usage domainModelElement = (Usage) view.getElement();
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
	private String getPortProvided_4010Text(View view) {
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
	private String getConstraintConstrainedElement_4012Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPortRequired_4014Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSlot_4015Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Slot_4015, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AssociationInstanceSourceEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_4016Text(View view) {
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
