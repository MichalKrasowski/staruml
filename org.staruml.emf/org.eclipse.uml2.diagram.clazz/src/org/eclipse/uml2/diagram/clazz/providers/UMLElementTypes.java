package org.eclipse.uml2.diagram.clazz.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClass2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassConnectorEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassRhombEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationInstanceEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataType2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataType3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyClientEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencySupplierEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Enumeration2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Enumeration3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ExpressionEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Generalization2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationGeneralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart;
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
import org.eclipse.uml2.diagram.clazz.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveType2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveType3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property7EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private UMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IHintedType Package_1000 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Package_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_2001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Class_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType AssociationClass_2007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.AssociationClass_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DataType_2004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.DataType_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PrimitiveType_2005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.PrimitiveType_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Enumeration_2003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Enumeration_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Interface_2010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Interface_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Constraint_2006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Constraint_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InstanceSpecification_2008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.InstanceSpecification_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Dependency_2009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Dependency_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType GeneralizationSet_2012 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.GeneralizationSet_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Interface_2013 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Interface_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2014 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Package_2014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType AssociationClass_2015 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.AssociationClass_2015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2016 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Package_2016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InstanceSpecification_2017 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.InstanceSpecification_2017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2018 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Comment_2018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_3006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Package_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_3007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Class_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DataType_3008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.DataType_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PrimitiveType_3009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.PrimitiveType_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Enumeration_3011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Enumeration_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType AssociationClass_3012 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.AssociationClass_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Interface_3041 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Interface_3041"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InstanceSpecification_3013 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.InstanceSpecification_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Property_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Operation_3002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Operation_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_3003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Class_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Port_3025 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Port_3025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType RedefinableTemplateSignature_3027 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.RedefinableTemplateSignature_3027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3019 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Property_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Operation_3020 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Operation_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3014 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Property_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Operation_3015 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Operation_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3021 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Property_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Operation_3022 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Operation_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType EnumerationLiteral_3016 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.EnumerationLiteral_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3023 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Property_3023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Operation_3024 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Operation_3024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Slot_3017 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Slot_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3028 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Property_3028"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Operation_3029 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Operation_3029"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_3030 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Class_3030"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementImport_3031 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.ElementImport_3031"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_3032 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Package_3032"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_3033 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Class_3033"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Enumeration_3034 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Enumeration_3034"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InstanceSpecification_3035 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.InstanceSpecification_3035"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DataType_3036 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.DataType_3036"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PrimitiveType_3037 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.PrimitiveType_3037"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType LiteralString_3038 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.LiteralString_3038"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType LiteralInteger_3039 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.LiteralInteger_3039"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Expression_3040 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Expression_3040"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Generalization_4001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Generalization_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Dependency_4002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Dependency_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_4003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Property_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConstraintConstrainedElement_4004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.ConstraintConstrainedElement_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Association_4005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Association_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DependencySupplier_4006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.DependencySupplier_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DependencyClient_4007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.DependencyClient_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InterfaceRealization_4008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.InterfaceRealization_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Realization_4010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Realization_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Generalization_4011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Generalization_4011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType GeneralizationGeneral_4012 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.GeneralizationGeneral_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Usage_4013 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Usage_4013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType AssociationClass_4014 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.AssociationClass_4014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Slot_4015 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.Slot_4015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType TemplateBinding_4016 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.TemplateBinding_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PortProvided_4017 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.PortProvided_4017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PortRequired_4018 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.PortRequired_4018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_4019 = (IHintedType) getElementType("org.eclipse.uml2.diagram.clazz.CommentAnnotatedElement_4019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return UMLDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());

			elements.put(Package_2002, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_2001, UMLPackage.eINSTANCE.getClass_());

			elements.put(AssociationClass_2007, UMLPackage.eINSTANCE.getAssociationClass());

			elements.put(DataType_2004, UMLPackage.eINSTANCE.getDataType());

			elements.put(PrimitiveType_2005, UMLPackage.eINSTANCE.getPrimitiveType());

			elements.put(Enumeration_2003, UMLPackage.eINSTANCE.getEnumeration());

			elements.put(Interface_2010, UMLPackage.eINSTANCE.getInterface());

			elements.put(Constraint_2006, UMLPackage.eINSTANCE.getConstraint());

			elements.put(InstanceSpecification_2008, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(Dependency_2009, UMLPackage.eINSTANCE.getDependency());

			elements.put(GeneralizationSet_2012, UMLPackage.eINSTANCE.getGeneralizationSet());

			elements.put(Interface_2013, UMLPackage.eINSTANCE.getInterface());

			elements.put(Package_2014, UMLPackage.eINSTANCE.getPackage());

			elements.put(AssociationClass_2015, UMLPackage.eINSTANCE.getAssociationClass());

			elements.put(Package_2016, UMLPackage.eINSTANCE.getPackage());

			elements.put(InstanceSpecification_2017, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(Comment_2018, UMLPackage.eINSTANCE.getComment());

			elements.put(Package_3006, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_3007, UMLPackage.eINSTANCE.getClass_());

			elements.put(DataType_3008, UMLPackage.eINSTANCE.getDataType());

			elements.put(PrimitiveType_3009, UMLPackage.eINSTANCE.getPrimitiveType());

			elements.put(Enumeration_3011, UMLPackage.eINSTANCE.getEnumeration());

			elements.put(AssociationClass_3012, UMLPackage.eINSTANCE.getAssociationClass());

			elements.put(Interface_3041, UMLPackage.eINSTANCE.getInterface());

			elements.put(InstanceSpecification_3013, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(Property_3001, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3002, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_3003, UMLPackage.eINSTANCE.getClass_());

			elements.put(Port_3025, UMLPackage.eINSTANCE.getPort());

			elements.put(RedefinableTemplateSignature_3027, UMLPackage.eINSTANCE.getRedefinableTemplateSignature());

			elements.put(Property_3019, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3020, UMLPackage.eINSTANCE.getOperation());

			elements.put(Property_3014, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3015, UMLPackage.eINSTANCE.getOperation());

			elements.put(Property_3021, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3022, UMLPackage.eINSTANCE.getOperation());

			elements.put(EnumerationLiteral_3016, UMLPackage.eINSTANCE.getEnumerationLiteral());

			elements.put(Property_3023, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3024, UMLPackage.eINSTANCE.getOperation());

			elements.put(Slot_3017, UMLPackage.eINSTANCE.getSlot());

			elements.put(Property_3028, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3029, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_3030, UMLPackage.eINSTANCE.getClass_());

			elements.put(ElementImport_3031, UMLPackage.eINSTANCE.getElementImport());

			elements.put(Package_3032, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_3033, UMLPackage.eINSTANCE.getClass_());

			elements.put(Enumeration_3034, UMLPackage.eINSTANCE.getEnumeration());

			elements.put(InstanceSpecification_3035, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(DataType_3036, UMLPackage.eINSTANCE.getDataType());

			elements.put(PrimitiveType_3037, UMLPackage.eINSTANCE.getPrimitiveType());

			elements.put(LiteralString_3038, UMLPackage.eINSTANCE.getLiteralString());

			elements.put(LiteralInteger_3039, UMLPackage.eINSTANCE.getLiteralInteger());

			elements.put(Expression_3040, UMLPackage.eINSTANCE.getExpression());

			elements.put(Generalization_4001, UMLPackage.eINSTANCE.getGeneralization());

			elements.put(Dependency_4002, UMLPackage.eINSTANCE.getDependency());

			elements.put(Property_4003, UMLPackage.eINSTANCE.getProperty());

			elements.put(ConstraintConstrainedElement_4004, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());

			elements.put(Association_4005, UMLPackage.eINSTANCE.getAssociation());

			elements.put(DependencySupplier_4006, UMLPackage.eINSTANCE.getDependency_Supplier());

			elements.put(DependencyClient_4007, UMLPackage.eINSTANCE.getDependency_Client());

			elements.put(InterfaceRealization_4008, UMLPackage.eINSTANCE.getInterfaceRealization());

			elements.put(Realization_4010, UMLPackage.eINSTANCE.getRealization());

			elements.put(Generalization_4011, UMLPackage.eINSTANCE.getGeneralization());

			elements.put(GeneralizationGeneral_4012, UMLPackage.eINSTANCE.getGeneralization_General());

			elements.put(Usage_4013, UMLPackage.eINSTANCE.getUsage());

			elements.put(AssociationClass_4014, UMLPackage.eINSTANCE.getAssociationClass());

			elements.put(Slot_4015, UMLPackage.eINSTANCE.getSlot());

			elements.put(TemplateBinding_4016, UMLPackage.eINSTANCE.getTemplateBinding());

			elements.put(PortProvided_4017, UMLPackage.eINSTANCE.getPort_Provided());

			elements.put(PortRequired_4018, UMLPackage.eINSTANCE.getPort_Required());

			elements.put(CommentAnnotatedElement_4019, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Package_2002);
			KNOWN_ELEMENT_TYPES.add(Class_2001);
			KNOWN_ELEMENT_TYPES.add(AssociationClass_2007);
			KNOWN_ELEMENT_TYPES.add(DataType_2004);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_2005);
			KNOWN_ELEMENT_TYPES.add(Enumeration_2003);
			KNOWN_ELEMENT_TYPES.add(Interface_2010);
			KNOWN_ELEMENT_TYPES.add(Constraint_2006);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_2008);
			KNOWN_ELEMENT_TYPES.add(Dependency_2009);
			KNOWN_ELEMENT_TYPES.add(GeneralizationSet_2012);
			KNOWN_ELEMENT_TYPES.add(Interface_2013);
			KNOWN_ELEMENT_TYPES.add(Package_2014);
			KNOWN_ELEMENT_TYPES.add(AssociationClass_2015);
			KNOWN_ELEMENT_TYPES.add(Package_2016);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_2017);
			KNOWN_ELEMENT_TYPES.add(Comment_2018);
			KNOWN_ELEMENT_TYPES.add(Package_3006);
			KNOWN_ELEMENT_TYPES.add(Class_3007);
			KNOWN_ELEMENT_TYPES.add(DataType_3008);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_3009);
			KNOWN_ELEMENT_TYPES.add(Enumeration_3011);
			KNOWN_ELEMENT_TYPES.add(AssociationClass_3012);
			KNOWN_ELEMENT_TYPES.add(Interface_3041);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_3013);
			KNOWN_ELEMENT_TYPES.add(Property_3001);
			KNOWN_ELEMENT_TYPES.add(Operation_3002);
			KNOWN_ELEMENT_TYPES.add(Class_3003);
			KNOWN_ELEMENT_TYPES.add(Port_3025);
			KNOWN_ELEMENT_TYPES.add(RedefinableTemplateSignature_3027);
			KNOWN_ELEMENT_TYPES.add(Property_3019);
			KNOWN_ELEMENT_TYPES.add(Operation_3020);
			KNOWN_ELEMENT_TYPES.add(Property_3014);
			KNOWN_ELEMENT_TYPES.add(Operation_3015);
			KNOWN_ELEMENT_TYPES.add(Property_3021);
			KNOWN_ELEMENT_TYPES.add(Operation_3022);
			KNOWN_ELEMENT_TYPES.add(EnumerationLiteral_3016);
			KNOWN_ELEMENT_TYPES.add(Property_3023);
			KNOWN_ELEMENT_TYPES.add(Operation_3024);
			KNOWN_ELEMENT_TYPES.add(Slot_3017);
			KNOWN_ELEMENT_TYPES.add(Property_3028);
			KNOWN_ELEMENT_TYPES.add(Operation_3029);
			KNOWN_ELEMENT_TYPES.add(Class_3030);
			KNOWN_ELEMENT_TYPES.add(ElementImport_3031);
			KNOWN_ELEMENT_TYPES.add(Package_3032);
			KNOWN_ELEMENT_TYPES.add(Class_3033);
			KNOWN_ELEMENT_TYPES.add(Enumeration_3034);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_3035);
			KNOWN_ELEMENT_TYPES.add(DataType_3036);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_3037);
			KNOWN_ELEMENT_TYPES.add(LiteralString_3038);
			KNOWN_ELEMENT_TYPES.add(LiteralInteger_3039);
			KNOWN_ELEMENT_TYPES.add(Expression_3040);
			KNOWN_ELEMENT_TYPES.add(Generalization_4001);
			KNOWN_ELEMENT_TYPES.add(Dependency_4002);
			KNOWN_ELEMENT_TYPES.add(Property_4003);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4004);
			KNOWN_ELEMENT_TYPES.add(Association_4005);
			KNOWN_ELEMENT_TYPES.add(DependencySupplier_4006);
			KNOWN_ELEMENT_TYPES.add(DependencyClient_4007);
			KNOWN_ELEMENT_TYPES.add(InterfaceRealization_4008);
			KNOWN_ELEMENT_TYPES.add(Realization_4010);
			KNOWN_ELEMENT_TYPES.add(Generalization_4011);
			KNOWN_ELEMENT_TYPES.add(GeneralizationGeneral_4012);
			KNOWN_ELEMENT_TYPES.add(Usage_4013);
			KNOWN_ELEMENT_TYPES.add(AssociationClass_4014);
			KNOWN_ELEMENT_TYPES.add(Slot_4015);
			KNOWN_ELEMENT_TYPES.add(TemplateBinding_4016);
			KNOWN_ELEMENT_TYPES.add(PortProvided_4017);
			KNOWN_ELEMENT_TYPES.add(PortRequired_4018);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4019);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case PackageEditPart.VISUAL_ID:
			return Package_1000;
		case Package2EditPart.VISUAL_ID:
			return Package_2002;
		case Class2EditPart.VISUAL_ID:
			return Class_2001;
		case AssociationClass2EditPart.VISUAL_ID:
			return AssociationClass_2007;
		case DataType2EditPart.VISUAL_ID:
			return DataType_2004;
		case PrimitiveType2EditPart.VISUAL_ID:
			return PrimitiveType_2005;
		case Enumeration2EditPart.VISUAL_ID:
			return Enumeration_2003;
		case InterfaceEditPart.VISUAL_ID:
			return Interface_2010;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_2006;
		case InstanceSpecification2EditPart.VISUAL_ID:
			return InstanceSpecification_2008;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_2009;
		case GeneralizationSetEditPart.VISUAL_ID:
			return GeneralizationSet_2012;
		case Interface2EditPart.VISUAL_ID:
			return Interface_2013;
		case Package4EditPart.VISUAL_ID:
			return Package_2014;
		case AssociationClassRhombEditPart.VISUAL_ID:
			return AssociationClass_2015;
		case PackageAsFrameEditPart.VISUAL_ID:
			return Package_2016;
		case InstanceSpecification4EditPart.VISUAL_ID:
			return InstanceSpecification_2017;
		case CommentEditPart.VISUAL_ID:
			return Comment_2018;
		case Package3EditPart.VISUAL_ID:
			return Package_3006;
		case ClassEditPart.VISUAL_ID:
			return Class_3007;
		case DataTypeEditPart.VISUAL_ID:
			return DataType_3008;
		case PrimitiveTypeEditPart.VISUAL_ID:
			return PrimitiveType_3009;
		case EnumerationEditPart.VISUAL_ID:
			return Enumeration_3011;
		case AssociationClassEditPart.VISUAL_ID:
			return AssociationClass_3012;
		case Interface3EditPart.VISUAL_ID:
			return Interface_3041;
		case InstanceSpecificationEditPart.VISUAL_ID:
			return InstanceSpecification_3013;
		case PropertyEditPart.VISUAL_ID:
			return Property_3001;
		case OperationEditPart.VISUAL_ID:
			return Operation_3002;
		case Class3EditPart.VISUAL_ID:
			return Class_3003;
		case PortEditPart.VISUAL_ID:
			return Port_3025;
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return RedefinableTemplateSignature_3027;
		case Property2EditPart.VISUAL_ID:
			return Property_3019;
		case Operation2EditPart.VISUAL_ID:
			return Operation_3020;
		case Property3EditPart.VISUAL_ID:
			return Property_3014;
		case Operation3EditPart.VISUAL_ID:
			return Operation_3015;
		case Property4EditPart.VISUAL_ID:
			return Property_3021;
		case Operation4EditPart.VISUAL_ID:
			return Operation_3022;
		case EnumerationLiteralEditPart.VISUAL_ID:
			return EnumerationLiteral_3016;
		case Property5EditPart.VISUAL_ID:
			return Property_3023;
		case Operation5EditPart.VISUAL_ID:
			return Operation_3024;
		case SlotEditPart.VISUAL_ID:
			return Slot_3017;
		case Property6EditPart.VISUAL_ID:
			return Property_3028;
		case Operation6EditPart.VISUAL_ID:
			return Operation_3029;
		case Class4EditPart.VISUAL_ID:
			return Class_3030;
		case ElementImportEditPart.VISUAL_ID:
			return ElementImport_3031;
		case Package6EditPart.VISUAL_ID:
			return Package_3032;
		case Class5EditPart.VISUAL_ID:
			return Class_3033;
		case Enumeration3EditPart.VISUAL_ID:
			return Enumeration_3034;
		case InstanceSpecification3EditPart.VISUAL_ID:
			return InstanceSpecification_3035;
		case DataType3EditPart.VISUAL_ID:
			return DataType_3036;
		case PrimitiveType3EditPart.VISUAL_ID:
			return PrimitiveType_3037;
		case LiteralStringEditPart.VISUAL_ID:
			return LiteralString_3038;
		case LiteralIntegerEditPart.VISUAL_ID:
			return LiteralInteger_3039;
		case ExpressionEditPart.VISUAL_ID:
			return Expression_3040;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4001;
		case Dependency2EditPart.VISUAL_ID:
			return Dependency_4002;
		case Property7EditPart.VISUAL_ID:
			return Property_4003;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4004;
		case AssociationEditPart.VISUAL_ID:
			return Association_4005;
		case DependencySupplierEditPart.VISUAL_ID:
			return DependencySupplier_4006;
		case DependencyClientEditPart.VISUAL_ID:
			return DependencyClient_4007;
		case InterfaceRealizationEditPart.VISUAL_ID:
			return InterfaceRealization_4008;
		case RealizationEditPart.VISUAL_ID:
			return Realization_4010;
		case Generalization2EditPart.VISUAL_ID:
			return Generalization_4011;
		case GeneralizationGeneralEditPart.VISUAL_ID:
			return GeneralizationGeneral_4012;
		case UsageEditPart.VISUAL_ID:
			return Usage_4013;
		case AssociationClassConnectorEditPart.VISUAL_ID:
			return AssociationClass_4014;
		case AssociationInstanceEditPart.VISUAL_ID:
			return Slot_4015;
		case TemplateBindingEditPart.VISUAL_ID:
			return TemplateBinding_4016;
		case PortProvidedEditPart.VISUAL_ID:
			return PortProvided_4017;
		case PortRequiredEditPart.VISUAL_ID:
			return PortRequired_4018;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4019;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static void refreshImageRegistry() {
		if (imageRegistry != null) {
			imageRegistry.dispose();
			imageRegistry = null;
		}
		imageRegistry = new ImageRegistry();
	}

}
