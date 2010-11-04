package org.eclipse.uml2.diagram.profile.navigator;

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
import org.eclipse.uml2.diagram.profile.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Constraint2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImport2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ExtensionLink_requiredEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ImageEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile3EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileName2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ReferencedMetaclassNode_classNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Stereotype2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeNameEditPart;
import org.eclipse.uml2.diagram.profile.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.profile.providers.UMLParserProvider;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Profile;

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
		case ProfileEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/3.0.0/UML?Profile", UMLElementTypes.Profile_1000); //$NON-NLS-1$
		case StereotypeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Stereotype", UMLElementTypes.Stereotype_2001); //$NON-NLS-1$
		case Profile2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Profile", UMLElementTypes.Profile_2002); //$NON-NLS-1$
		case EnumerationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Enumeration", UMLElementTypes.Enumeration_2003); //$NON-NLS-1$
		case ElementImportEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?ElementImport", UMLElementTypes.ElementImport_2006); //$NON-NLS-1$
		case Profile3EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Profile", UMLElementTypes.Profile_2007); //$NON-NLS-1$
		case Constraint2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_2008); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Comment", UMLElementTypes.Comment_2009); //$NON-NLS-1$
		case PropertyEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3001); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_3008); //$NON-NLS-1$
		case ImageEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Image", UMLElementTypes.Image_3010); //$NON-NLS-1$
		case Stereotype2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Stereotype", UMLElementTypes.Stereotype_3003); //$NON-NLS-1$
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?EnumerationLiteral", UMLElementTypes.EnumerationLiteral_3005); //$NON-NLS-1$
		case ElementImport2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ElementImport", UMLElementTypes.ElementImport_3009); //$NON-NLS-1$
		case GeneralizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Generalization", UMLElementTypes.Generalization_4001); //$NON-NLS-1$
		case ExtensionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Extension", UMLElementTypes.Extension_4002); //$NON-NLS-1$
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Constraint?constrainedElement", UMLElementTypes.ConstraintConstrainedElement_4003); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4004); //$NON-NLS-1$
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
		case ProfileEditPart.VISUAL_ID:
			return getProfile_1000Text(view);
		case StereotypeEditPart.VISUAL_ID:
			return getStereotype_2001Text(view);
		case Profile2EditPart.VISUAL_ID:
			return getProfile_2002Text(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2003Text(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_2006Text(view);
		case Profile3EditPart.VISUAL_ID:
			return getProfile_2007Text(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_2008Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2009Text(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008Text(view);
		case ImageEditPart.VISUAL_ID:
			return getImage_3010Text(view);
		case Stereotype2EditPart.VISUAL_ID:
			return getStereotype_3003Text(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3005Text(view);
		case ElementImport2EditPart.VISUAL_ID:
			return getElementImport_3009Text(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4001Text(view);
		case ExtensionEditPart.VISUAL_ID:
			return getExtension_4002Text(view);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getConstraintConstrainedElement_4003Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4004Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getProfile_1000Text(View view) {
		Profile domainModelElement = (Profile) view.getElement();
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
	private String getStereotype_2001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Stereotype_2001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StereotypeNameEditPart.VISUAL_ID));
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
	private String getProfile_2002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Profile_2002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ProfileNameEditPart.VISUAL_ID));
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
	private String getEnumeration_2003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Enumeration_2003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(EnumerationNameEditPart.VISUAL_ID));
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
	private String getElementImport_2006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ElementImport_2006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ReferencedMetaclassNode_classNameEditPart.VISUAL_ID));
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
	private String getProfile_2007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Profile_2007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ProfileName2EditPart.VISUAL_ID));
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
	private String getConstraint_2008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_2008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ConstraintNameEditPart.VISUAL_ID));
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
	private String getComment_2009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_2009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
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
	private String getProperty_3001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
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
	private String getConstraint_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
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
	private String getImage_3010Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Image_3010, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ImageEditPart.VISUAL_ID));
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
	private String getStereotype_3003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Stereotype_3003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Stereotype2EditPart.VISUAL_ID));
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
	private String getEnumerationLiteral_3005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.EnumerationLiteral_3005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(EnumerationLiteralEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getElementImport_3009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ElementImport_3009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ElementImport2EditPart.VISUAL_ID));
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
	private String getGeneralization_4001Text(View view) {
		Generalization domainModelElement = (Generalization) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSubstitutable());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtension_4002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Extension_4002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExtensionLink_requiredEditPart.VISUAL_ID));
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
	private String getConstraintConstrainedElement_4003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_4004Text(View view) {
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
		return ProfileEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

}
