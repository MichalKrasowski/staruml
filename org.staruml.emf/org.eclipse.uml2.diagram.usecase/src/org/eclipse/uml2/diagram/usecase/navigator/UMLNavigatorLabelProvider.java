package org.eclipse.uml2.diagram.usecase.navigator;

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
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorAsRectangleEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorName2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorName3EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.AssociationTargetMultiplicityEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.DiagramHeaderEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtendsLink_fixedEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.IncludeLink_fixedEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.InnerUseCaseEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.NestedPackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.NestedPackageNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.SubjectEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.SubjectNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseAsClassEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName3EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName4EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseinPackageEditPart;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.usecase.providers.UMLParserProvider;
import org.eclipse.uml2.uml.Generalization;
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
		case DiagramHeaderEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2001); //$NON-NLS-1$
		case ActorEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Actor", UMLElementTypes.Actor_2002); //$NON-NLS-1$
		case ActorAsRectangleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Actor", UMLElementTypes.Actor_2005); //$NON-NLS-1$
		case UseCaseEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?UseCase", UMLElementTypes.UseCase_2003); //$NON-NLS-1$
		case UseCaseAsClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?UseCase", UMLElementTypes.UseCase_2004); //$NON-NLS-1$
		case SubjectEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Component", UMLElementTypes.Component_2006); //$NON-NLS-1$
		case NestedPackageEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2007); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_2008); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Comment", UMLElementTypes.Comment_2009); //$NON-NLS-1$
		case ElementImportEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ElementImport", UMLElementTypes.ElementImport_3001); //$NON-NLS-1$
		case ExtensionPointEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ExtensionPoint", UMLElementTypes.ExtensionPoint_3002); //$NON-NLS-1$
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ExtensionPoint", UMLElementTypes.ExtensionPoint_3003); //$NON-NLS-1$
		case InnerUseCaseEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?UseCase", UMLElementTypes.UseCase_3004); //$NON-NLS-1$
		case ActorInPackageEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Actor", UMLElementTypes.Actor_3005); //$NON-NLS-1$
		case UseCaseinPackageEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?UseCase", UMLElementTypes.UseCase_3006); //$NON-NLS-1$
		case IncludeEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Include", UMLElementTypes.Include_4001); //$NON-NLS-1$
		case ExtendEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Extend", UMLElementTypes.Extend_4002); //$NON-NLS-1$
		case GeneralizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Generalization", UMLElementTypes.Generalization_4003); //$NON-NLS-1$
		case AssociationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Association", UMLElementTypes.Association_4004); //$NON-NLS-1$
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Constraint?constrainedElement", UMLElementTypes.ConstraintConstrainedElement_4005); //$NON-NLS-1$
		case DependencyEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Dependency", UMLElementTypes.Dependency_4006); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4007); //$NON-NLS-1$
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
		case DiagramHeaderEditPart.VISUAL_ID:
			return getPackage_2001Text(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2002Text(view);
		case ActorAsRectangleEditPart.VISUAL_ID:
			return getActor_2005Text(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2003Text(view);
		case UseCaseAsClassEditPart.VISUAL_ID:
			return getUseCase_2004Text(view);
		case SubjectEditPart.VISUAL_ID:
			return getComponent_2006Text(view);
		case NestedPackageEditPart.VISUAL_ID:
			return getPackage_2007Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2008Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2009Text(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3001Text(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3002Text(view);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3003Text(view);
		case InnerUseCaseEditPart.VISUAL_ID:
			return getUseCase_3004Text(view);
		case ActorInPackageEditPart.VISUAL_ID:
			return getActor_3005Text(view);
		case UseCaseinPackageEditPart.VISUAL_ID:
			return getUseCase_3006Text(view);
		case IncludeEditPart.VISUAL_ID:
			return getInclude_4001Text(view);
		case ExtendEditPart.VISUAL_ID:
			return getExtend_4002Text(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003Text(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4004Text(view);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getConstraintConstrainedElement_4005Text(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4006Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4007Text(view);
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
	private String getActor_2002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Actor_2002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActorNameEditPart.VISUAL_ID));
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
	private String getActor_2005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Actor_2005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActorName2EditPart.VISUAL_ID));
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
	private String getUseCase_2003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.UseCase_2003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UseCaseNameEditPart.VISUAL_ID));
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
	private String getUseCase_2004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.UseCase_2004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UseCaseName2EditPart.VISUAL_ID));
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
	private String getComponent_2006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Component_2006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(SubjectNameEditPart.VISUAL_ID));
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
	private String getPackage_2007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(NestedPackageNameEditPart.VISUAL_ID));
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
	private String getConstraint_2008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_2008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ConstraintNameEditPart.VISUAL_ID));
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
	private String getComment_2009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_2009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5015); //$NON-NLS-1$
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
	private String getExtensionPoint_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExtensionPoint_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExtensionPointEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtensionPoint_3003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExtensionPoint_3003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExtensionPoint2EditPart.VISUAL_ID));
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
	private String getUseCase_3004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.UseCase_3004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UseCaseName3EditPart.VISUAL_ID));
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
	private String getActor_3005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Actor_3005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActorName3EditPart.VISUAL_ID));
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
	private String getUseCase_3006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.UseCase_3006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UseCaseName4EditPart.VISUAL_ID));
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
	private String getInclude_4001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Include_4001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(IncludeLink_fixedEditPart.VISUAL_ID));
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
	private String getExtend_4002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Extend_4002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExtendsLink_fixedEditPart.VISUAL_ID));
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
	private String getGeneralization_4003Text(View view) {
		Generalization domainModelElement = (Generalization) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSubstitutable());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_4004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Association_4004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AssociationTargetMultiplicityEditPart.VISUAL_ID));
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
	private String getConstraintConstrainedElement_4005Text(View view) {
		return ""; //$NON-NLS-1$
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
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_4007Text(View view) {
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
