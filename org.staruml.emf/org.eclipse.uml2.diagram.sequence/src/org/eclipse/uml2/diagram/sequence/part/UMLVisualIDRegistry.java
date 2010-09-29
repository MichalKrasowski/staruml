package org.eclipse.uml2.diagram.sequence.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.edit.parts.ActionExecutionLabelEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.CombinedFragmentInteractionOperatorEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.CombinedFragmentMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionOperandMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionUseMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionUseSignatureEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredCombinedFragmentEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredInteractionUseEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredOperandEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineRefLabelEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.StateInvariantLabelEditPart;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.uml2.diagram.sequence/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case InteractionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getGate().isSuperTypeOf(domainElement.eClass())) {
				return GateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInteractionUse().isSuperTypeOf(domainElement.eClass())) {
				return LayeredInteractionUseEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return LayeredCombinedFragmentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			break;
		case LayeredCombinedFragmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteractionOperand().isSuperTypeOf(domainElement.eClass())) {
				return LayeredOperandEditPart.VISUAL_ID;
			}
			break;
		case LifelineEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActionExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return ActionExecutionSpecificationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getStateInvariant().isSuperTypeOf(domainElement.eClass())) {
				return StateInvariantEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehaviorExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return BehaviorExecutionSpecificationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInteractionUse().isSuperTypeOf(domainElement.eClass())) {
				return InteractionUseMountingRegionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return CombinedFragmentMountingRegionEditPart.VISUAL_ID;
			}
			break;
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getBehaviorExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return BehaviorExecutionSpecificationEditPart.VISUAL_ID;
			}
			break;
		case CombinedFragmentMountingRegionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteractionOperand().isSuperTypeOf(domainElement.eClass())) {
				return InteractionOperandMountingRegionEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())) {
				return InteractionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case InteractionEditPart.VISUAL_ID:
			if (InteractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LayeredInteractionUseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LayeredCombinedFragmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LifelineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LayeredInteractionUseEditPart.VISUAL_ID:
			if (InteractionUseSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LayeredCombinedFragmentEditPart.VISUAL_ID:
			if (CombinedFragmentInteractionOperatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LayeredOperandEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LifelineEditPart.VISUAL_ID:
			if (LifelineNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LifelineRefLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActionExecutionSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateInvariantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BehaviorExecutionSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InteractionUseMountingRegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CombinedFragmentMountingRegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			if (ActionExecutionLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateInvariantEditPart.VISUAL_ID:
			if (StateInvariantLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			if (BehaviorExecutionSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CombinedFragmentMountingRegionEditPart.VISUAL_ID:
			if (InteractionOperandMountingRegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (InteractionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MessageEditPart.VISUAL_ID:
			if (MessageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass())) {
			return MessageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	protected static boolean hasViewChild(View containerView, EObject domainElement, int visualId) {
		if (containerView == null) {
			return false;
		}
		if (domainElement == null) {
			return false;
		}
		for (Object next : containerView.getChildren()) {
			View nextView = (View) next;
			if (domainElement.equals(nextView.getElement()) && getType(visualId).equals(nextView.getType())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getChildDescriptorVisualID(UMLNodeDescriptor container, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		switch (container.getVisualID()) {
		case InteractionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getGate().isSuperTypeOf(domainElement.eClass())) {
				return GateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInteractionUse().isSuperTypeOf(domainElement.eClass())) {
				return LayeredInteractionUseEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return LayeredCombinedFragmentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(domainElement.eClass())) {
				return LifelineEditPart.VISUAL_ID;
			}
			break;
		case LayeredCombinedFragmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteractionOperand().isSuperTypeOf(domainElement.eClass())) {
				return LayeredOperandEditPart.VISUAL_ID;
			}
			break;
		case LifelineEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActionExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return ActionExecutionSpecificationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getStateInvariant().isSuperTypeOf(domainElement.eClass())) {
				return StateInvariantEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehaviorExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return BehaviorExecutionSpecificationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInteractionUse().isSuperTypeOf(domainElement.eClass())) {
				return InteractionUseMountingRegionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCombinedFragment().isSuperTypeOf(domainElement.eClass())) {
				return CombinedFragmentMountingRegionEditPart.VISUAL_ID;
			}
			break;
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getBehaviorExecutionSpecification().isSuperTypeOf(domainElement.eClass())) {
				return BehaviorExecutionSpecificationEditPart.VISUAL_ID;
			}
			break;
		case CombinedFragmentMountingRegionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteractionOperand().isSuperTypeOf(domainElement.eClass())) {
				return InteractionOperandMountingRegionEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())) {
				return InteractionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	protected static boolean canSubstitute(int visualId, int substituteCandidate) {
		if (visualId == substituteCandidate) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate || canSubstitute(basic, candidate);
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case GateEditPart.VISUAL_ID:
		case LayeredInteractionUseEditPart.VISUAL_ID:
		case LayeredOperandEditPart.VISUAL_ID:
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
		case StateInvariantEditPart.VISUAL_ID:
		case InteractionUseMountingRegionEditPart.VISUAL_ID:
		case InteractionOperandMountingRegionEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final IVisualIDRegistry TYPED_ADAPTER = new IVisualIDRegistry() {

		/**
		 * @generated
		 */
		public String getModelID(View view) {
			return org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		public int getVisualID(View view) {
			return org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isShortcutDescendant(View view) {
			return org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry.isShortcutDescendant(view);
		}

	};

	/**
	 * @generated
	 */
	public static boolean isShortcutDescendant(View view) {
		View diagram = view.getDiagram();
		while (view != diagram && view != null) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return true;
			}
			view = (View) view.eContainer();
		}
		return false;
	}
}
