package org.eclipse.uml2.diagram.statemachine.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CompositeStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CompositeState_InternalActivitiesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CompositeState_InternalTransitionsEditPart;
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
import org.eclipse.uml2.diagram.statemachine.edit.parts.SimpleState_InternalActivitiesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine_RegionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine_RegionSubverticesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.State_RegionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.State_RegionSubverticesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SubmachineStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SubmachineState_InternalActivitiesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SubmachineState_InternalTransitionsEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TerminatePseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ChoicePseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * @generated
 */
@SuppressWarnings("unchecked")
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_2005SemanticChildren(view);
		case CompositeStateEditPart.VISUAL_ID:
			return getState_3012SemanticChildren(view);
		case SubmachineStateEditPart.VISUAL_ID:
			return getState_3016SemanticChildren(view);
		case StateMachine_RegionSubverticesEditPart.VISUAL_ID:
			return getRegionSubvertices_7004SemanticChildren(view);
		case SimpleState_InternalActivitiesEditPart.VISUAL_ID:
			return getStateSimpleState_InternalActivities_7005SemanticChildren(view);
		case CompositeState_InternalActivitiesEditPart.VISUAL_ID:
			return getStateCompositeState_InternalActivities_7006SemanticChildren(view);
		case CompositeState_InternalTransitionsEditPart.VISUAL_ID:
			return getStateCompositeState_InternalTransitions_7008SemanticChildren(view);
		case State_RegionSubverticesEditPart.VISUAL_ID:
			return getRegionSubvertices_7003SemanticChildren(view);
		case SubmachineState_InternalActivitiesEditPart.VISUAL_ID:
			return getStateCompositeState_InternalActivities_7007SemanticChildren(view);
		case SubmachineState_InternalTransitionsEditPart.VISUAL_ID:
			return getStateCompositeState_InternalTransitions_7009SemanticChildren(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStateMachine_2005SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		StateMachine modelElement = (StateMachine) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getRegions().iterator(); it.hasNext();) {
			Region childElement = (Region) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == StateMachine_RegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getConnectionPoints().iterator(); it.hasNext();) {
			Pseudostate childElement = (Pseudostate) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntryPointPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ExitPointPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_3012SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getRegions().iterator(); it.hasNext();) {
			Region childElement = (Region) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == State_RegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_3016SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getRegions().iterator(); it.hasNext();) {
			Region childElement = (Region) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == State_RegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getConnections().iterator(); it.hasNext();) {
			ConnectionPointReference childElement = (ConnectionPointReference) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntryConnectionPointReferenceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ExitConnectionPointReferenceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegionSubvertices_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Region modelElement = (Region) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSubvertices().iterator(); it.hasNext();) {
			Vertex childElement = (Vertex) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SimpleStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CompositeStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SubmachineStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FinalStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InitialPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ShallowHistoryPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DeepHistoryPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForkPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == JoinPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == JunctionPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ChoicePseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TerminatePseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateSimpleState_InternalActivities_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) containerView.getElement();
		List result = new LinkedList();
		{
			Behavior childElement = modelElement.getEntry();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntryActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			Behavior childElement = modelElement.getExit();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ExitActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			Behavior childElement = modelElement.getDoActivity();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DoActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateCompositeState_InternalActivities_7006SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) containerView.getElement();
		List result = new LinkedList();
		{
			Behavior childElement = modelElement.getEntry();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntryActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			Behavior childElement = modelElement.getExit();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ExitActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			Behavior childElement = modelElement.getDoActivity();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DoActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static List getStateCompositeState_InternalTransitions_7008SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = getInternalTransitions(modelElement).iterator(); it.hasNext();) {
			Transition childElement = (Transition) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InternalTransitionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegionSubvertices_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Region modelElement = (Region) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSubvertices().iterator(); it.hasNext();) {
			Vertex childElement = (Vertex) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SimpleStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CompositeStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SubmachineStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FinalStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InitialPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ShallowHistoryPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DeepHistoryPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForkPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == JoinPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == JunctionPseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ChoicePseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TerminatePseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateCompositeState_InternalActivities_7007SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) containerView.getElement();
		List result = new LinkedList();
		{
			Behavior childElement = modelElement.getEntry();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntryActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			Behavior childElement = modelElement.getExit();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ExitActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			Behavior childElement = modelElement.getDoActivity();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DoActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static List getStateCompositeState_InternalTransitions_7009SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = getInternalTransitions(modelElement).iterator(); it.hasNext();) {
			Transition childElement = (Transition) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InternalTransitionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == StateMachineEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_2005ContainedLinks(view);
		case StateMachine_RegionEditPart.VISUAL_ID:
			return getRegion_3013ContainedLinks(view);
		case SimpleStateEditPart.VISUAL_ID:
			return getState_3001ContainedLinks(view);
		case EntryActivityEditPart.VISUAL_ID:
			return getBehavior_3019ContainedLinks(view);
		case ExitActivityEditPart.VISUAL_ID:
			return getBehavior_3020ContainedLinks(view);
		case DoActivityEditPart.VISUAL_ID:
			return getBehavior_3021ContainedLinks(view);
		case CompositeStateEditPart.VISUAL_ID:
			return getState_3012ContainedLinks(view);
		case State_RegionEditPart.VISUAL_ID:
			return getRegion_3002ContainedLinks(view);
		case SubmachineStateEditPart.VISUAL_ID:
			return getState_3016ContainedLinks(view);
		case EntryConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3017ContainedLinks(view);
		case ExitConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3018ContainedLinks(view);
		case InternalTransitionEditPart.VISUAL_ID:
			return getTransition_3022ContainedLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3003ContainedLinks(view);
		case InitialPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3004ContainedLinks(view);
		case ShallowHistoryPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3005ContainedLinks(view);
		case DeepHistoryPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3006ContainedLinks(view);
		case ForkPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3007ContainedLinks(view);
		case JoinPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3008ContainedLinks(view);
		case JunctionPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3009ContainedLinks(view);
		case ChoicePseudostateEditPart.VISUAL_ID:
			return getPseudostate_3010ContainedLinks(view);
		case TerminatePseudostateEditPart.VISUAL_ID:
			return getPseudostate_3011ContainedLinks(view);
		case EntryPointPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3014ContainedLinks(view);
		case ExitPointPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3015ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_2005IncomingLinks(view);
		case StateMachine_RegionEditPart.VISUAL_ID:
			return getRegion_3013IncomingLinks(view);
		case SimpleStateEditPart.VISUAL_ID:
			return getState_3001IncomingLinks(view);
		case EntryActivityEditPart.VISUAL_ID:
			return getBehavior_3019IncomingLinks(view);
		case ExitActivityEditPart.VISUAL_ID:
			return getBehavior_3020IncomingLinks(view);
		case DoActivityEditPart.VISUAL_ID:
			return getBehavior_3021IncomingLinks(view);
		case CompositeStateEditPart.VISUAL_ID:
			return getState_3012IncomingLinks(view);
		case State_RegionEditPart.VISUAL_ID:
			return getRegion_3002IncomingLinks(view);
		case SubmachineStateEditPart.VISUAL_ID:
			return getState_3016IncomingLinks(view);
		case EntryConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3017IncomingLinks(view);
		case ExitConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3018IncomingLinks(view);
		case InternalTransitionEditPart.VISUAL_ID:
			return getTransition_3022IncomingLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3003IncomingLinks(view);
		case InitialPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3004IncomingLinks(view);
		case ShallowHistoryPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3005IncomingLinks(view);
		case DeepHistoryPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3006IncomingLinks(view);
		case ForkPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3007IncomingLinks(view);
		case JoinPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3008IncomingLinks(view);
		case JunctionPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3009IncomingLinks(view);
		case ChoicePseudostateEditPart.VISUAL_ID:
			return getPseudostate_3010IncomingLinks(view);
		case TerminatePseudostateEditPart.VISUAL_ID:
			return getPseudostate_3011IncomingLinks(view);
		case EntryPointPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3014IncomingLinks(view);
		case ExitPointPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3015IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_2005OutgoingLinks(view);
		case StateMachine_RegionEditPart.VISUAL_ID:
			return getRegion_3013OutgoingLinks(view);
		case SimpleStateEditPart.VISUAL_ID:
			return getState_3001OutgoingLinks(view);
		case EntryActivityEditPart.VISUAL_ID:
			return getBehavior_3019OutgoingLinks(view);
		case ExitActivityEditPart.VISUAL_ID:
			return getBehavior_3020OutgoingLinks(view);
		case DoActivityEditPart.VISUAL_ID:
			return getBehavior_3021OutgoingLinks(view);
		case CompositeStateEditPart.VISUAL_ID:
			return getState_3012OutgoingLinks(view);
		case State_RegionEditPart.VISUAL_ID:
			return getRegion_3002OutgoingLinks(view);
		case SubmachineStateEditPart.VISUAL_ID:
			return getState_3016OutgoingLinks(view);
		case EntryConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3017OutgoingLinks(view);
		case ExitConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3018OutgoingLinks(view);
		case InternalTransitionEditPart.VISUAL_ID:
			return getTransition_3022OutgoingLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3003OutgoingLinks(view);
		case InitialPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3004OutgoingLinks(view);
		case ShallowHistoryPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3005OutgoingLinks(view);
		case DeepHistoryPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3006OutgoingLinks(view);
		case ForkPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3007OutgoingLinks(view);
		case JoinPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3008OutgoingLinks(view);
		case JunctionPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3009OutgoingLinks(view);
		case ChoicePseudostateEditPart.VISUAL_ID:
			return getPseudostate_3010OutgoingLinks(view);
		case TerminatePseudostateEditPart.VISUAL_ID:
			return getPseudostate_3011OutgoingLinks(view);
		case EntryPointPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3014OutgoingLinks(view);
		case ExitPointPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3015OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStateMachine_2005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3013ContainedLinks(View view) {
		Region modelElement = (Region) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3019ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3020ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3021ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3012ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3002ContainedLinks(View view) {
		Region modelElement = (Region) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_3016ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_3017ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_3018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3011ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTransition_3022ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3014ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3015ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStateMachine_2005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3013IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3001IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3019IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3020IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3021IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3012IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3016IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_3017IncomingLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_3018IncomingLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_3003IncomingLinks(View view) {
		FinalState modelElement = (FinalState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3004IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3005IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3006IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3007IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3008IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3009IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3010IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3011IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_3022IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3014IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3015IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStateMachine_2005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3013OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3001OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3019OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3020OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBehavior_3021OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3012OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3016OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_3017OutgoingLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_3018OutgoingLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_3003OutgoingLinks(View view) {
		FinalState modelElement = (FinalState) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3004OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3005OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3006OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3007OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3008OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3009OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3010OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3011OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_3022OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3014OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3015OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Transition_4001(Region container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getTransitions().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Vertex dst = link.getTarget();
			Vertex src = link.getSource();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Transition_4001, TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Transition_4001(Vertex target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getTransition_Target() || false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Vertex src = link.getSource();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Transition_4001, TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Transition_4001(Vertex source) {
		Region container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Region) {
				container = (Region) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getTransitions().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Vertex dst = link.getTarget();
			Vertex src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Transition_4001, TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final IDiagramUpdater TYPED_ADAPTER = new IDiagramUpdater() {

		/**
		 * @generated
		 */
		public List<IUpdaterNodeDescriptor> getSemanticChildren(View view) {
			return org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getContainedLinks(View view) {
			return org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getIncomingLinks(View view) {
			return org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getOutgoingLinks(View view) {
			return org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater.getOutgoingLinks(view);
		}
	};

	/**
	 * NOT-generated
	 */
	private static List getInternalTransitions(State state) {
		List internalTransitions = new LinkedList();
		EList<Region> regions = state.getRegions();
		for (Iterator<Region> internalTransitionsIterator = regions.iterator(); internalTransitionsIterator.hasNext();) {
			Region region = internalTransitionsIterator.next();
			EList<Transition> transitions = region.getTransitions();
			for (Iterator<Transition> transitionsIterator = transitions.iterator(); transitionsIterator.hasNext();) {
				Transition transition = transitionsIterator.next();
				if (transition.getKind() == TransitionKind.INTERNAL_LITERAL) {
					internalTransitions.add(transition);
				}
			}
		}
		return internalTransitions;
	}
}
