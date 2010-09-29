package org.eclipse.uml2.diagram.statemachine.providers;

import java.util.HashMap;
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
import org.eclipse.uml2.diagram.statemachine.edit.parts.CompositeStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.DeepHistoryPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.DoActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryConnectionPointReferenceEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryPointPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitConnectionPointReferenceEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitPointPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ForkPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.InitialPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.InternalTransitionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.JoinPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.JunctionPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ShallowHistoryPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SimpleStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine_RegionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.State_RegionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SubmachineStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TerminatePseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ChoicePseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramEditorPlugin;
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
	 * @NOT generated
	 */
	private static Map<IElementType, ImageDescriptor> pseudostateDescriptors;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

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
	 * @generated NOT
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		IElementType type = (IElementType) hint.getAdapter(IElementType.class);
		if (type != null) {
			ImageDescriptor imageDescriptor = getPseudostateImageDescriptor(type);
			if (imageDescriptor != null) {
				return imageDescriptor;
			}
		}
		return getImageDescriptorGen(hint);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptorGen(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated NOT
	 */
	public static Image getImage(IAdaptable hint) {
		IElementType type = (IElementType) hint.getAdapter(IElementType.class);
		if (type != null && getPseudostateImageDescriptors().containsKey(type)) {
			String key = type.getId();
			Image image = getImageRegistry().get(key);
			if (image == null) {
				ImageDescriptor imageDescriptor = getPseudostateImageDescriptor(type);
				if (imageDescriptor != null) {
					getImageRegistry().put(key, imageDescriptor);
					image = getImageRegistry().get(key);
				}
			}
			return image;
		}
		return getImageGen(hint);
	}

	/**
	 * @generated
	 */
	public static Image getImageGen(IAdaptable hint) {
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

			elements.put(StateMachine_2005, UMLPackage.eINSTANCE.getStateMachine());

			elements.put(Region_3013, UMLPackage.eINSTANCE.getRegion());

			elements.put(State_3001, UMLPackage.eINSTANCE.getState());

			elements.put(Behavior_3019, UMLPackage.eINSTANCE.getBehavior());

			elements.put(Behavior_3020, UMLPackage.eINSTANCE.getBehavior());

			elements.put(Behavior_3021, UMLPackage.eINSTANCE.getBehavior());

			elements.put(State_3012, UMLPackage.eINSTANCE.getState());

			elements.put(Region_3002, UMLPackage.eINSTANCE.getRegion());

			elements.put(State_3016, UMLPackage.eINSTANCE.getState());

			elements.put(ConnectionPointReference_3017, UMLPackage.eINSTANCE.getConnectionPointReference());

			elements.put(ConnectionPointReference_3018, UMLPackage.eINSTANCE.getConnectionPointReference());

			elements.put(Transition_3022, UMLPackage.eINSTANCE.getTransition());

			elements.put(FinalState_3003, UMLPackage.eINSTANCE.getFinalState());

			elements.put(Pseudostate_3004, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3005, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3006, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3007, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3008, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3009, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3010, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3011, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3014, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Pseudostate_3015, UMLPackage.eINSTANCE.getPseudostate());

			elements.put(Transition_4001, UMLPackage.eINSTANCE.getTransition());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @NOT generated
	 */
	private static Map<IElementType, ImageDescriptor> getPseudostateImageDescriptors() {
		if (pseudostateDescriptors == null) {
			pseudostateDescriptors = new HashMap<IElementType, ImageDescriptor>();
			pseudostateDescriptors.put(Pseudostate_3004, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_initial.gif")); //$NON-NLS-1$
			pseudostateDescriptors.put(Pseudostate_3005, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_shallowHistory.gif")); //$NON-NLS-1$
			pseudostateDescriptors.put(Pseudostate_3006, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_deepHistory.gif")); //$NON-NLS-1$
			pseudostateDescriptors.put(Pseudostate_3007, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_fork.gif")); //$NON-NLS-1$
			pseudostateDescriptors.put(Pseudostate_3008, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_join.gif")); //$NON-NLS-1$
			pseudostateDescriptors.put(Pseudostate_3009, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_junction.gif")); //$NON-NLS-1$
			pseudostateDescriptors.put(Pseudostate_3010, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_choice.gif")); //$NON-NLS-1$
			pseudostateDescriptors.put(Pseudostate_3011, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_terminate.gif")); //$NON-NLS-1$

			pseudostateDescriptors.put(Pseudostate_3014, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_entryPoint.gif")); //$NON-NLS-1$
			pseudostateDescriptors.put(Pseudostate_3015, UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_exitPoint.gif")); //$NON-NLS-1$
		}
		return pseudostateDescriptors;
	}

	/**
	 * @NOT generated
	 */
	private static ImageDescriptor getPseudostateImageDescriptor(IElementType hint) {
		return getPseudostateImageDescriptors().get(hint);
	}

	/**
	 * @generated
	 */
	public static final IHintedType Region_3013 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Region_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType State_3001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.State_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Behavior_3019 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Behavior_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Behavior_3020 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Behavior_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Behavior_3021 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Behavior_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType State_3012 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.State_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Region_3002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Region_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType State_3016 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.State_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConnectionPointReference_3017 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.ConnectionPointReference_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConnectionPointReference_3018 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.ConnectionPointReference_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType FinalState_3003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.FinalState_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Transition_3022 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Transition_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3014 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pseudostate_3015 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Pseudostate_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Transition_4001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Transition_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IHintedType Package_1000 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType StateMachine_2005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.statemachine.StateMachine_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(StateMachine_2005);
			KNOWN_ELEMENT_TYPES.add(Region_3013);
			KNOWN_ELEMENT_TYPES.add(State_3001);
			KNOWN_ELEMENT_TYPES.add(Behavior_3019);
			KNOWN_ELEMENT_TYPES.add(Behavior_3020);
			KNOWN_ELEMENT_TYPES.add(Behavior_3021);
			KNOWN_ELEMENT_TYPES.add(State_3012);
			KNOWN_ELEMENT_TYPES.add(Region_3002);
			KNOWN_ELEMENT_TYPES.add(State_3016);
			KNOWN_ELEMENT_TYPES.add(ConnectionPointReference_3017);
			KNOWN_ELEMENT_TYPES.add(ConnectionPointReference_3018);
			KNOWN_ELEMENT_TYPES.add(Transition_3022);
			KNOWN_ELEMENT_TYPES.add(FinalState_3003);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3004);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3005);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3006);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3007);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3008);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3009);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3010);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3011);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3014);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3015);
			KNOWN_ELEMENT_TYPES.add(Transition_4001);
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
		case StateMachineEditPart.VISUAL_ID:
			return StateMachine_2005;
		case StateMachine_RegionEditPart.VISUAL_ID:
			return Region_3013;
		case SimpleStateEditPart.VISUAL_ID:
			return State_3001;
		case EntryActivityEditPart.VISUAL_ID:
			return Behavior_3019;
		case ExitActivityEditPart.VISUAL_ID:
			return Behavior_3020;
		case DoActivityEditPart.VISUAL_ID:
			return Behavior_3021;
		case CompositeStateEditPart.VISUAL_ID:
			return State_3012;
		case State_RegionEditPart.VISUAL_ID:
			return Region_3002;
		case SubmachineStateEditPart.VISUAL_ID:
			return State_3016;
		case EntryConnectionPointReferenceEditPart.VISUAL_ID:
			return ConnectionPointReference_3017;
		case ExitConnectionPointReferenceEditPart.VISUAL_ID:
			return ConnectionPointReference_3018;
		case InternalTransitionEditPart.VISUAL_ID:
			return Transition_3022;
		case FinalStateEditPart.VISUAL_ID:
			return FinalState_3003;
		case InitialPseudostateEditPart.VISUAL_ID:
			return Pseudostate_3004;
		case ShallowHistoryPseudostateEditPart.VISUAL_ID:
			return Pseudostate_3005;
		case DeepHistoryPseudostateEditPart.VISUAL_ID:
			return Pseudostate_3006;
		case ForkPseudostateEditPart.VISUAL_ID:
			return Pseudostate_3007;
		case JoinPseudostateEditPart.VISUAL_ID:
			return Pseudostate_3008;
		case JunctionPseudostateEditPart.VISUAL_ID:
			return Pseudostate_3009;
		case ChoicePseudostateEditPart.VISUAL_ID:
			return Pseudostate_3010;
		case TerminatePseudostateEditPart.VISUAL_ID:
			return Pseudostate_3011;
		case EntryPointPseudostateEditPart.VISUAL_ID:
			return Pseudostate_3014;
		case ExitPointPseudostateEditPart.VISUAL_ID:
			return Pseudostate_3015;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
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
