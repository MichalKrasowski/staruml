package org.eclipse.uml2.diagram.sequence.providers;

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
import org.eclipse.uml2.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.CombinedFragmentMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InnerMountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionOperandMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionUseMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredCombinedFragmentEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredInteractionUseEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredOperandEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;
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
	public static final IHintedType Package_1000 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Interaction_2001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.Interaction_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Gate_3005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.Gate_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InteractionUse_3007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.InteractionUse_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CombinedFragment_3008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.CombinedFragment_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InteractionOperand_3009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.InteractionOperand_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Lifeline_3001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.Lifeline_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ActionExecutionSpecification_3002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.ActionExecutionSpecification_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType StateInvariant_3003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.StateInvariant_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType BehaviorExecutionSpecification_3004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.BehaviorExecutionSpecification_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InteractionUse_3006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.InteractionUse_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CombinedFragment_3010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.CombinedFragment_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InteractionOperand_3011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.InteractionOperand_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Message_4001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.sequence.Message_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_4002 = getElementType("org.eclipse.uml2.diagram.sequence.TopLevelMountingLink_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_4003 = getElementType("org.eclipse.uml2.diagram.sequence.InnerMountingLink_4003"); //$NON-NLS-1$

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

			elements.put(Interaction_2001, UMLPackage.eINSTANCE.getInteraction());

			elements.put(Gate_3005, UMLPackage.eINSTANCE.getGate());

			elements.put(InteractionUse_3007, UMLPackage.eINSTANCE.getInteractionUse());

			elements.put(CombinedFragment_3008, UMLPackage.eINSTANCE.getCombinedFragment());

			elements.put(InteractionOperand_3009, UMLPackage.eINSTANCE.getInteractionOperand());

			elements.put(Lifeline_3001, UMLPackage.eINSTANCE.getLifeline());

			elements.put(ActionExecutionSpecification_3002, UMLPackage.eINSTANCE.getActionExecutionSpecification());

			elements.put(StateInvariant_3003, UMLPackage.eINSTANCE.getStateInvariant());

			elements.put(BehaviorExecutionSpecification_3004, UMLPackage.eINSTANCE.getBehaviorExecutionSpecification());

			elements.put(InteractionUse_3006, UMLPackage.eINSTANCE.getInteractionUse());

			elements.put(CombinedFragment_3010, UMLPackage.eINSTANCE.getCombinedFragment());

			elements.put(InteractionOperand_3011, UMLPackage.eINSTANCE.getInteractionOperand());

			elements.put(Message_4001, UMLPackage.eINSTANCE.getMessage());
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
			KNOWN_ELEMENT_TYPES.add(Interaction_2001);
			KNOWN_ELEMENT_TYPES.add(Gate_3005);
			KNOWN_ELEMENT_TYPES.add(InteractionUse_3007);
			KNOWN_ELEMENT_TYPES.add(CombinedFragment_3008);
			KNOWN_ELEMENT_TYPES.add(InteractionOperand_3009);
			KNOWN_ELEMENT_TYPES.add(Lifeline_3001);
			KNOWN_ELEMENT_TYPES.add(ActionExecutionSpecification_3002);
			KNOWN_ELEMENT_TYPES.add(StateInvariant_3003);
			KNOWN_ELEMENT_TYPES.add(BehaviorExecutionSpecification_3004);
			KNOWN_ELEMENT_TYPES.add(InteractionUse_3006);
			KNOWN_ELEMENT_TYPES.add(CombinedFragment_3010);
			KNOWN_ELEMENT_TYPES.add(InteractionOperand_3011);
			KNOWN_ELEMENT_TYPES.add(Message_4001);
			KNOWN_ELEMENT_TYPES.add(Link_4002);
			KNOWN_ELEMENT_TYPES.add(Link_4003);
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
		case InteractionEditPart.VISUAL_ID:
			return Interaction_2001;
		case GateEditPart.VISUAL_ID:
			return Gate_3005;
		case LayeredInteractionUseEditPart.VISUAL_ID:
			return InteractionUse_3007;
		case LayeredCombinedFragmentEditPart.VISUAL_ID:
			return CombinedFragment_3008;
		case LayeredOperandEditPart.VISUAL_ID:
			return InteractionOperand_3009;
		case LifelineEditPart.VISUAL_ID:
			return Lifeline_3001;
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return ActionExecutionSpecification_3002;
		case StateInvariantEditPart.VISUAL_ID:
			return StateInvariant_3003;
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return BehaviorExecutionSpecification_3004;
		case InteractionUseMountingRegionEditPart.VISUAL_ID:
			return InteractionUse_3006;
		case CombinedFragmentMountingRegionEditPart.VISUAL_ID:
			return CombinedFragment_3010;
		case InteractionOperandMountingRegionEditPart.VISUAL_ID:
			return InteractionOperand_3011;
		case MessageEditPart.VISUAL_ID:
			return Message_4001;
		case MountingLinkEditPart.VISUAL_ID:
			return Link_4002;
		case InnerMountingLinkEditPart.VISUAL_ID:
			return Link_4003;
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
