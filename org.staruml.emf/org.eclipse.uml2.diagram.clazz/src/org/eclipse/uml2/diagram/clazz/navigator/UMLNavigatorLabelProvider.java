package org.eclipse.uml2.diagram.clazz.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
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
import org.eclipse.uml2.diagram.clazz.edit.parts.*;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClass2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassConnectorEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassRhombEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationInstanceEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationInstanceSourceEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataType2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataType3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyClientEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencySupplierEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Enumeration2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Enumeration3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ExpressionEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Generalization2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationGeneralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetIsCoveringIsDisjointEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.LiteralIntegerEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.LiteralStringEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageAsFrameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageName4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveType2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveType3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property7EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.TemplateSignatureNode_signatureEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.clazz.providers.UMLParserProvider;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Generalization;
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
		case Package2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2002); //$NON-NLS-1$
		case Class2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_2001); //$NON-NLS-1$
		case AssociationClass2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?AssociationClass", UMLElementTypes.AssociationClass_2007); //$NON-NLS-1$
		case DataType2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?DataType", UMLElementTypes.DataType_2004); //$NON-NLS-1$
		case PrimitiveType2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?PrimitiveType", UMLElementTypes.PrimitiveType_2005); //$NON-NLS-1$
		case Enumeration2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Enumeration", UMLElementTypes.Enumeration_2003); //$NON-NLS-1$
		case InterfaceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Interface", UMLElementTypes.Interface_2010); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_2006); //$NON-NLS-1$
		case InstanceSpecification2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?InstanceSpecification", UMLElementTypes.InstanceSpecification_2008); //$NON-NLS-1$
		case DependencyEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Dependency", UMLElementTypes.Dependency_2009); //$NON-NLS-1$
		case GeneralizationSetEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?GeneralizationSet", UMLElementTypes.GeneralizationSet_2012); //$NON-NLS-1$
		case Interface2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Interface", UMLElementTypes.Interface_2013); //$NON-NLS-1$
		case Package4EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2014); //$NON-NLS-1$
		case AssociationClassRhombEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?AssociationClass", UMLElementTypes.AssociationClass_2015); //$NON-NLS-1$
		case PackageAsFrameEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_2016); //$NON-NLS-1$
		case InstanceSpecification4EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?InstanceSpecification", UMLElementTypes.InstanceSpecification_2017); //$NON-NLS-1$
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Comment", UMLElementTypes.Comment_2018); //$NON-NLS-1$
		case Package3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_3006); //$NON-NLS-1$
		case ClassEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_3007); //$NON-NLS-1$
		case DataTypeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DataType", UMLElementTypes.DataType_3008); //$NON-NLS-1$
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?PrimitiveType", UMLElementTypes.PrimitiveType_3009); //$NON-NLS-1$
		case EnumerationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Enumeration", UMLElementTypes.Enumeration_3011); //$NON-NLS-1$
		case AssociationClassEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AssociationClass", UMLElementTypes.AssociationClass_3012); //$NON-NLS-1$
		case Interface3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Interface", UMLElementTypes.Interface_3041); //$NON-NLS-1$
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InstanceSpecification", UMLElementTypes.InstanceSpecification_3013); //$NON-NLS-1$
		case PropertyEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3001); //$NON-NLS-1$
		case OperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", UMLElementTypes.Operation_3002); //$NON-NLS-1$
		case Class3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_3003); //$NON-NLS-1$
		case PortEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Port", UMLElementTypes.Port_3025); //$NON-NLS-1$
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?RedefinableTemplateSignature", UMLElementTypes.RedefinableTemplateSignature_3027); //$NON-NLS-1$
		case Property2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3019); //$NON-NLS-1$
		case Operation2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", UMLElementTypes.Operation_3020); //$NON-NLS-1$
		case Property3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3014); //$NON-NLS-1$
		case Operation3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", UMLElementTypes.Operation_3015); //$NON-NLS-1$
		case Property4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3021); //$NON-NLS-1$
		case Operation4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", UMLElementTypes.Operation_3022); //$NON-NLS-1$
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?EnumerationLiteral", UMLElementTypes.EnumerationLiteral_3016); //$NON-NLS-1$
		case Property5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3023); //$NON-NLS-1$
		case Operation5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", UMLElementTypes.Operation_3024); //$NON-NLS-1$
		case SlotEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Slot", UMLElementTypes.Slot_3017); //$NON-NLS-1$
		case Property6EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_3028); //$NON-NLS-1$
		case Operation6EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", UMLElementTypes.Operation_3029); //$NON-NLS-1$
		case Class4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_3030); //$NON-NLS-1$
		case ElementImportEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ElementImport", UMLElementTypes.ElementImport_3031); //$NON-NLS-1$
		case Package6EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_3032); //$NON-NLS-1$
		case Class5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Class", UMLElementTypes.Class_3033); //$NON-NLS-1$
		case Enumeration3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Enumeration", UMLElementTypes.Enumeration_3034); //$NON-NLS-1$
		case InstanceSpecification3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InstanceSpecification", UMLElementTypes.InstanceSpecification_3035); //$NON-NLS-1$
		case DataType3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DataType", UMLElementTypes.DataType_3036); //$NON-NLS-1$
		case PrimitiveType3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?PrimitiveType", UMLElementTypes.PrimitiveType_3037); //$NON-NLS-1$
		case LiteralStringEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?LiteralString", UMLElementTypes.LiteralString_3038); //$NON-NLS-1$
		case LiteralIntegerEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?LiteralInteger", UMLElementTypes.LiteralInteger_3039); //$NON-NLS-1$
		case ExpressionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Expression", UMLElementTypes.Expression_3040); //$NON-NLS-1$
		case GeneralizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Generalization", UMLElementTypes.Generalization_4001); //$NON-NLS-1$
		case Dependency2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Dependency", UMLElementTypes.Dependency_4002); //$NON-NLS-1$
		case Property7EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Property", UMLElementTypes.Property_4003); //$NON-NLS-1$
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Constraint?constrainedElement", UMLElementTypes.ConstraintConstrainedElement_4004); //$NON-NLS-1$
		case AssociationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Association", UMLElementTypes.Association_4005); //$NON-NLS-1$
		case DependencySupplierEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Dependency?supplier", UMLElementTypes.DependencySupplier_4006); //$NON-NLS-1$
		case DependencyClientEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Dependency?client", UMLElementTypes.DependencyClient_4007); //$NON-NLS-1$
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?InterfaceRealization", UMLElementTypes.InterfaceRealization_4008); //$NON-NLS-1$
		case RealizationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Realization", UMLElementTypes.Realization_4010); //$NON-NLS-1$
		case Generalization2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Generalization", UMLElementTypes.Generalization_4011); //$NON-NLS-1$
		case GeneralizationGeneralEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Generalization?general", UMLElementTypes.GeneralizationGeneral_4012); //$NON-NLS-1$
		case UsageEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Usage", UMLElementTypes.Usage_4013); //$NON-NLS-1$
		case AssociationClassConnectorEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?AssociationClass", UMLElementTypes.AssociationClass_4014); //$NON-NLS-1$
		case AssociationInstanceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Slot", UMLElementTypes.Slot_4015); //$NON-NLS-1$
		case TemplateBindingEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?TemplateBinding", UMLElementTypes.TemplateBinding_4016); //$NON-NLS-1$
		case PortProvidedEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Port?provided", UMLElementTypes.PortProvided_4017); //$NON-NLS-1$
		case PortRequiredEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Port?required", UMLElementTypes.PortRequired_4018); //$NON-NLS-1$
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Comment?annotatedElement", UMLElementTypes.CommentAnnotatedElement_4019); //$NON-NLS-1$
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
			return getPackage_2002Text(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_2001Text(view);
		case AssociationClass2EditPart.VISUAL_ID:
			return getAssociationClass_2007Text(view);
		case DataType2EditPart.VISUAL_ID:
			return getDataType_2004Text(view);
		case PrimitiveType2EditPart.VISUAL_ID:
			return getPrimitiveType_2005Text(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_2003Text(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2010Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2006Text(view);
		case InstanceSpecification2EditPart.VISUAL_ID:
			return getInstanceSpecification_2008Text(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_2009Text(view);
		case GeneralizationSetEditPart.VISUAL_ID:
			return getGeneralizationSet_2012Text(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_2013Text(view);
		case Package4EditPart.VISUAL_ID:
			return getPackage_2014Text(view);
		case AssociationClassRhombEditPart.VISUAL_ID:
			return getAssociationClass_2015Text(view);
		case PackageAsFrameEditPart.VISUAL_ID:
			return getPackage_2016Text(view);
		case InstanceSpecification4EditPart.VISUAL_ID:
			return getInstanceSpecification_2017Text(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2018Text(view);
		case Package3EditPart.VISUAL_ID:
			return getPackage_3006Text(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3007Text(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_3008Text(view);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_3009Text(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3011Text(view);
		case AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_3012Text(view);
		case Interface3EditPart.VISUAL_ID:
			return getInterface_3041Text(view);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_3013Text(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001Text(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3002Text(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_3003Text(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3025Text(view);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_3027Text(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3019Text(view);
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3020Text(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3014Text(view);
		case Operation3EditPart.VISUAL_ID:
			return getOperation_3015Text(view);
		case Property4EditPart.VISUAL_ID:
			return getProperty_3021Text(view);
		case Operation4EditPart.VISUAL_ID:
			return getOperation_3022Text(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3016Text(view);
		case Property5EditPart.VISUAL_ID:
			return getProperty_3023Text(view);
		case Operation5EditPart.VISUAL_ID:
			return getOperation_3024Text(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3017Text(view);
		case Property6EditPart.VISUAL_ID:
			return getProperty_3028Text(view);
		case Operation6EditPart.VISUAL_ID:
			return getOperation_3029Text(view);
		case Class4EditPart.VISUAL_ID:
			return getClass_3030Text(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3031Text(view);
		case Package6EditPart.VISUAL_ID:
			return getPackage_3032Text(view);
		case Class5EditPart.VISUAL_ID:
			return getClass_3033Text(view);
		case Enumeration3EditPart.VISUAL_ID:
			return getEnumeration_3034Text(view);
		case InstanceSpecification3EditPart.VISUAL_ID:
			return getInstanceSpecification_3035Text(view);
		case DataType3EditPart.VISUAL_ID:
			return getDataType_3036Text(view);
		case PrimitiveType3EditPart.VISUAL_ID:
			return getPrimitiveType_3037Text(view);
		case LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_3038Text(view);
		case LiteralIntegerEditPart.VISUAL_ID:
			return getLiteralInteger_3039Text(view);
		case ExpressionEditPart.VISUAL_ID:
			return getExpression_3040Text(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4001Text(view);
		case Dependency2EditPart.VISUAL_ID:
			return getDependency_4002Text(view);
		case Property7EditPart.VISUAL_ID:
			return getProperty_4003Text(view);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getConstraintConstrainedElement_4004Text(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4005Text(view);
		case DependencySupplierEditPart.VISUAL_ID:
			return getDependencySupplier_4006Text(view);
		case DependencyClientEditPart.VISUAL_ID:
			return getDependencyClient_4007Text(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4008Text(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4010Text(view);
		case Generalization2EditPart.VISUAL_ID:
			return getGeneralization_4011Text(view);
		case GeneralizationGeneralEditPart.VISUAL_ID:
			return getGeneralizationGeneral_4012Text(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4013Text(view);
		case AssociationClassConnectorEditPart.VISUAL_ID:
			return getAssociationClass_4014Text(view);
		case AssociationInstanceEditPart.VISUAL_ID:
			return getSlot_4015Text(view);
		case TemplateBindingEditPart.VISUAL_ID:
			return getTemplateBinding_4016Text(view);
		case PortProvidedEditPart.VISUAL_ID:
			return getPortProvided_4017Text(view);
		case PortRequiredEditPart.VISUAL_ID:
			return getPortRequired_4018Text(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getCommentAnnotatedElement_4019Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_2002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
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
	private String getClass_2001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_2001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
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
	private String getAssociationClass_2007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AssociationClass_2007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AssociationClassNameEditPart.VISUAL_ID));
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
	private String getDataType_2004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DataType_2004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DataTypeNameEditPart.VISUAL_ID));
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
	private String getPrimitiveType_2005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.PrimitiveType_2005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(PrimitiveTypeNameEditPart.VISUAL_ID));
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
	private String getInterface_2010Text(View view) {
		IParser parser = UMLParserProvider
				.getParser(UMLElementTypes.Interface_2010, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
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
	private String getConstraint_2006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_2006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ConstraintNameEditPart.VISUAL_ID));
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
	private String getInstanceSpecification_2008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InstanceSpecification_2008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InstanceSpecificationNameEditPart.VISUAL_ID));
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
	private String getDependency_2009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Dependency_2009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(DependencyNameEditPart.VISUAL_ID));
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
	private String getGeneralizationSet_2012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.GeneralizationSet_2012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(GeneralizationSetIsCoveringIsDisjointEditPart.VISUAL_ID));
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
	private String getInterface_2013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Interface_2013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InterfaceName2EditPart.VISUAL_ID));
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
	private String getPackage_2014Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2014, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageName2EditPart.VISUAL_ID));
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
	private String getAssociationClass_2015Text(View view) {
		AssociationClass domainModelElement = (AssociationClass) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_2016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_2016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInstanceSpecification_2017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InstanceSpecification_2017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InstanceSpecificationName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5029); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_2018Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_2018, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_3006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_3006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
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
	private String getClass_3007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_3007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
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
	private String getDataType_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DataType_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DataTypeEditPart.VISUAL_ID));
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
	private String getPrimitiveType_3009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.PrimitiveType_3009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(PrimitiveTypeEditPart.VISUAL_ID));
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
	private String getEnumeration_3011Text(View view) {
		IParser parser = UMLParserProvider
				.getParser(UMLElementTypes.Enumeration_3011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(EnumerationEditPart.VISUAL_ID));
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
	private String getAssociationClass_3012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AssociationClass_3012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AssociationClassEditPart.VISUAL_ID));
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
	private String getInterface_3041Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Interface_3041, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Interface3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3041); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInstanceSpecification_3013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InstanceSpecification_3013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InstanceSpecificationEditPart.VISUAL_ID));
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
	private String getOperation_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Operation_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(OperationEditPart.VISUAL_ID));
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
	private String getClass_3003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_3003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
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
	private String getPort_3025Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Port_3025, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PortNameEditPart.VISUAL_ID));
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
	private String getRedefinableTemplateSignature_3027Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.RedefinableTemplateSignature_3027, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(TemplateSignatureNode_signatureEditPart.VISUAL_ID));
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
	private String getProperty_3019Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3019, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Property2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_3020Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Operation_3020, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Operation2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_3014Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3014, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Property3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_3015Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Operation_3015, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Operation3EditPart.VISUAL_ID));
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
	private String getProperty_3021Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3021, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Property4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_3022Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Operation_3022, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Operation4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEnumerationLiteral_3016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.EnumerationLiteral_3016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(EnumerationLiteralEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_3023Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3023, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Property5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_3024Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Operation_3024, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Operation5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSlot_3017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Slot_3017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(SlotEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_3028Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_3028, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Property6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_3029Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Operation_3029, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Operation6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3029); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_3030Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_3030, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(Class4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getElementImport_3031Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ElementImport_3031, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ElementImportEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_3032Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Package_3032, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PackageName4EditPart.VISUAL_ID));
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
	private String getClass_3033Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Class_3033, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ClassName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEnumeration_3034Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Enumeration_3034, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(EnumerationName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInstanceSpecification_3035Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InstanceSpecification_3035, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InstanceSpecificationName2EditPart.VISUAL_ID));
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
	private String getDataType_3036Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DataType_3036, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DataTypeName2EditPart.VISUAL_ID));
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
	private String getPrimitiveType_3037Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.PrimitiveType_3037, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(PrimitiveTypeName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLiteralString_3038Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.LiteralString_3038, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(LiteralStringEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3038); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLiteralInteger_3039Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.LiteralInteger_3039, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(LiteralIntegerEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3039); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExpression_3040Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Expression_3040, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ExpressionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
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
	private String getGeneralization_4001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Generalization_4001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(GeneralizationStereotypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependency_4002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Dependency_4002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(DependencyName2EditPart.VISUAL_ID));
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
	private String getProperty_4003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Property_4003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PropertyNameEditPart.VISUAL_ID));
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
	private String getConstraintConstrainedElement_4004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAssociation_4005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Association_4005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AssociationNameEditPart.VISUAL_ID));
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
	private String getDependencySupplier_4006Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDependencyClient_4007Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInterfaceRealization_4008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InterfaceRealization_4008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InterfaceRealizationStereotypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRealization_4010Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Realization_4010, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(RealizationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGeneralization_4011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Generalization_4011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(GeneralizationStereotype2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGeneralizationGeneral_4012Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUsage_4013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Usage_4013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(UsageStereotypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociationClass_4014Text(View view) {
		AssociationClass domainModelElement = (AssociationClass) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
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
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTemplateBinding_4016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.TemplateBinding_4016, view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPortProvided_4017Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPortRequired_4018Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommentAnnotatedElement_4019Text(View view) {
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
