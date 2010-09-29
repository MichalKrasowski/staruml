package org.eclipse.uml2.diagram.usecase.providers;

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
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorAsRectangleEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.DiagramHeaderEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.InnerUseCaseEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.NestedPackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.SubjectEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseAsClassEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseinPackageEditPart;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditorPlugin;
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
	public static final IHintedType Package_1000 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Package_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Actor_2002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Actor_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Actor_2005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Actor_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType UseCase_2003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.UseCase_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType UseCase_2004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.UseCase_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Component_2006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Component_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Package_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Constraint_2008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Constraint_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Comment_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementImport_3001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.ElementImport_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ExtensionPoint_3002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.ExtensionPoint_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ExtensionPoint_3003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.ExtensionPoint_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType UseCase_3004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.UseCase_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Actor_3005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Actor_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType UseCase_3006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.UseCase_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Include_4001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Include_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Extend_4002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Extend_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Generalization_4003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Generalization_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Association_4004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Association_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConstraintConstrainedElement_4005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.ConstraintConstrainedElement_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Dependency_4006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.Dependency_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_4007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.usecase.CommentAnnotatedElement_4007"); //$NON-NLS-1$

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

			elements.put(Package_2001, UMLPackage.eINSTANCE.getPackage());

			elements.put(Actor_2002, UMLPackage.eINSTANCE.getActor());

			elements.put(Actor_2005, UMLPackage.eINSTANCE.getActor());

			elements.put(UseCase_2003, UMLPackage.eINSTANCE.getUseCase());

			elements.put(UseCase_2004, UMLPackage.eINSTANCE.getUseCase());

			elements.put(Component_2006, UMLPackage.eINSTANCE.getComponent());

			elements.put(Package_2007, UMLPackage.eINSTANCE.getPackage());

			elements.put(Constraint_2008, UMLPackage.eINSTANCE.getConstraint());

			elements.put(Comment_2009, UMLPackage.eINSTANCE.getComment());

			elements.put(ElementImport_3001, UMLPackage.eINSTANCE.getElementImport());

			elements.put(ExtensionPoint_3002, UMLPackage.eINSTANCE.getExtensionPoint());

			elements.put(ExtensionPoint_3003, UMLPackage.eINSTANCE.getExtensionPoint());

			elements.put(UseCase_3004, UMLPackage.eINSTANCE.getUseCase());

			elements.put(Actor_3005, UMLPackage.eINSTANCE.getActor());

			elements.put(UseCase_3006, UMLPackage.eINSTANCE.getUseCase());

			elements.put(Include_4001, UMLPackage.eINSTANCE.getInclude());

			elements.put(Extend_4002, UMLPackage.eINSTANCE.getExtend());

			elements.put(Generalization_4003, UMLPackage.eINSTANCE.getGeneralization());

			elements.put(Association_4004, UMLPackage.eINSTANCE.getAssociation());

			elements.put(ConstraintConstrainedElement_4005, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());

			elements.put(Dependency_4006, UMLPackage.eINSTANCE.getDependency());

			elements.put(CommentAnnotatedElement_4007, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
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
			KNOWN_ELEMENT_TYPES.add(Package_2001);
			KNOWN_ELEMENT_TYPES.add(Actor_2002);
			KNOWN_ELEMENT_TYPES.add(Actor_2005);
			KNOWN_ELEMENT_TYPES.add(UseCase_2003);
			KNOWN_ELEMENT_TYPES.add(UseCase_2004);
			KNOWN_ELEMENT_TYPES.add(Component_2006);
			KNOWN_ELEMENT_TYPES.add(Package_2007);
			KNOWN_ELEMENT_TYPES.add(Constraint_2008);
			KNOWN_ELEMENT_TYPES.add(Comment_2009);
			KNOWN_ELEMENT_TYPES.add(ElementImport_3001);
			KNOWN_ELEMENT_TYPES.add(ExtensionPoint_3002);
			KNOWN_ELEMENT_TYPES.add(ExtensionPoint_3003);
			KNOWN_ELEMENT_TYPES.add(UseCase_3004);
			KNOWN_ELEMENT_TYPES.add(Actor_3005);
			KNOWN_ELEMENT_TYPES.add(UseCase_3006);
			KNOWN_ELEMENT_TYPES.add(Include_4001);
			KNOWN_ELEMENT_TYPES.add(Extend_4002);
			KNOWN_ELEMENT_TYPES.add(Generalization_4003);
			KNOWN_ELEMENT_TYPES.add(Association_4004);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4005);
			KNOWN_ELEMENT_TYPES.add(Dependency_4006);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4007);
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
		case DiagramHeaderEditPart.VISUAL_ID:
			return Package_2001;
		case ActorEditPart.VISUAL_ID:
			return Actor_2002;
		case ActorAsRectangleEditPart.VISUAL_ID:
			return Actor_2005;
		case UseCaseEditPart.VISUAL_ID:
			return UseCase_2003;
		case UseCaseAsClassEditPart.VISUAL_ID:
			return UseCase_2004;
		case SubjectEditPart.VISUAL_ID:
			return Component_2006;
		case NestedPackageEditPart.VISUAL_ID:
			return Package_2007;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_2008;
		case CommentEditPart.VISUAL_ID:
			return Comment_2009;
		case ElementImportEditPart.VISUAL_ID:
			return ElementImport_3001;
		case ExtensionPointEditPart.VISUAL_ID:
			return ExtensionPoint_3002;
		case ExtensionPoint2EditPart.VISUAL_ID:
			return ExtensionPoint_3003;
		case InnerUseCaseEditPart.VISUAL_ID:
			return UseCase_3004;
		case ActorInPackageEditPart.VISUAL_ID:
			return Actor_3005;
		case UseCaseinPackageEditPart.VISUAL_ID:
			return UseCase_3006;
		case IncludeEditPart.VISUAL_ID:
			return Include_4001;
		case ExtendEditPart.VISUAL_ID:
			return Extend_4002;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4003;
		case AssociationEditPart.VISUAL_ID:
			return Association_4004;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4005;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4006;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4007;
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
