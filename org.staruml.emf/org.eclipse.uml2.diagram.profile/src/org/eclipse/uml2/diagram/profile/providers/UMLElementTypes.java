package org.eclipse.uml2.diagram.profile.providers;

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
import org.eclipse.uml2.diagram.profile.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Constraint2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImport2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ImageEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile3EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Stereotype2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.uml2.diagram.profile.part.UMLDiagramEditorPlugin;
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
	public static final IHintedType Profile_1000 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Profile_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Stereotype_2001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Stereotype_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Profile_2002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Profile_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Enumeration_2003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Enumeration_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementImport_2006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.ElementImport_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Profile_2007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Profile_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Constraint_2008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Constraint_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Comment_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Property_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Constraint_3008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Constraint_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Image_3010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Image_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Stereotype_3003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Stereotype_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType EnumerationLiteral_3005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.EnumerationLiteral_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementImport_3009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.ElementImport_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Generalization_4001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Generalization_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Extension_4002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.Extension_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConstraintConstrainedElement_4003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.ConstraintConstrainedElement_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_4004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.profile.CommentAnnotatedElement_4004"); //$NON-NLS-1$

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

			elements.put(Profile_1000, UMLPackage.eINSTANCE.getProfile());

			elements.put(Stereotype_2001, UMLPackage.eINSTANCE.getStereotype());

			elements.put(Profile_2002, UMLPackage.eINSTANCE.getProfile());

			elements.put(Enumeration_2003, UMLPackage.eINSTANCE.getEnumeration());

			elements.put(ElementImport_2006, UMLPackage.eINSTANCE.getElementImport());

			elements.put(Profile_2007, UMLPackage.eINSTANCE.getProfile());

			elements.put(Constraint_2008, UMLPackage.eINSTANCE.getConstraint());

			elements.put(Comment_2009, UMLPackage.eINSTANCE.getComment());

			elements.put(Property_3001, UMLPackage.eINSTANCE.getProperty());

			elements.put(Constraint_3008, UMLPackage.eINSTANCE.getConstraint());

			elements.put(Image_3010, UMLPackage.eINSTANCE.getImage());

			elements.put(Stereotype_3003, UMLPackage.eINSTANCE.getStereotype());

			elements.put(EnumerationLiteral_3005, UMLPackage.eINSTANCE.getEnumerationLiteral());

			elements.put(ElementImport_3009, UMLPackage.eINSTANCE.getElementImport());

			elements.put(Generalization_4001, UMLPackage.eINSTANCE.getGeneralization());

			elements.put(Extension_4002, UMLPackage.eINSTANCE.getExtension());

			elements.put(ConstraintConstrainedElement_4003, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());

			elements.put(CommentAnnotatedElement_4004, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
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
			KNOWN_ELEMENT_TYPES.add(Profile_1000);
			KNOWN_ELEMENT_TYPES.add(Stereotype_2001);
			KNOWN_ELEMENT_TYPES.add(Profile_2002);
			KNOWN_ELEMENT_TYPES.add(Enumeration_2003);
			KNOWN_ELEMENT_TYPES.add(ElementImport_2006);
			KNOWN_ELEMENT_TYPES.add(Profile_2007);
			KNOWN_ELEMENT_TYPES.add(Constraint_2008);
			KNOWN_ELEMENT_TYPES.add(Comment_2009);
			KNOWN_ELEMENT_TYPES.add(Property_3001);
			KNOWN_ELEMENT_TYPES.add(Constraint_3008);
			KNOWN_ELEMENT_TYPES.add(Image_3010);
			KNOWN_ELEMENT_TYPES.add(Stereotype_3003);
			KNOWN_ELEMENT_TYPES.add(EnumerationLiteral_3005);
			KNOWN_ELEMENT_TYPES.add(ElementImport_3009);
			KNOWN_ELEMENT_TYPES.add(Generalization_4001);
			KNOWN_ELEMENT_TYPES.add(Extension_4002);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4003);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ProfileEditPart.VISUAL_ID:
			return Profile_1000;
		case StereotypeEditPart.VISUAL_ID:
			return Stereotype_2001;
		case Profile2EditPart.VISUAL_ID:
			return Profile_2002;
		case EnumerationEditPart.VISUAL_ID:
			return Enumeration_2003;
		case ElementImportEditPart.VISUAL_ID:
			return ElementImport_2006;
		case Profile3EditPart.VISUAL_ID:
			return Profile_2007;
		case Constraint2EditPart.VISUAL_ID:
			return Constraint_2008;
		case CommentEditPart.VISUAL_ID:
			return Comment_2009;
		case PropertyEditPart.VISUAL_ID:
			return Property_3001;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_3008;
		case ImageEditPart.VISUAL_ID:
			return Image_3010;
		case Stereotype2EditPart.VISUAL_ID:
			return Stereotype_3003;
		case EnumerationLiteralEditPart.VISUAL_ID:
			return EnumerationLiteral_3005;
		case ElementImport2EditPart.VISUAL_ID:
			return ElementImport_3009;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4001;
		case ExtensionEditPart.VISUAL_ID:
			return Extension_4002;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4003;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4004;
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
