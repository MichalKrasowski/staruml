package org.eclipse.uml2.diagram.statemachine.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CompositeStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.DeepHistoryPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryConnectionPointReferenceEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryPointPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitConnectionPointReferenceEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitPointPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ForkPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.InitialPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.JoinPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.JunctionPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ShallowHistoryPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SimpleStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine_RegionSubverticesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.State_RegionSubverticesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SubmachineStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TerminatePseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ChoicePseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.part.Messages;
import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated NOT
	 * #227133 Exception on Behavior creation
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof SimpleStateEditPart) {
			List types = new ArrayList();
			//			types.add(UMLElementTypes.Behavior_3019);
			//			types.add(UMLElementTypes.Behavior_3020);
			//			types.add(UMLElementTypes.Behavior_3021);
			return types;
		}
		if (editPart instanceof CompositeStateEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.Region_3002);
			//			types.add(UMLElementTypes.Behavior_3019);
			//			types.add(UMLElementTypes.Behavior_3020);
			//			types.add(UMLElementTypes.Behavior_3021);
			return types;
		}
		if (editPart instanceof SubmachineStateEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.Region_3002);
			types.add(UMLElementTypes.ConnectionPointReference_3017);
			types.add(UMLElementTypes.ConnectionPointReference_3018);
			//			types.add(UMLElementTypes.Behavior_3019);
			//			types.add(UMLElementTypes.Behavior_3020);
			//			types.add(UMLElementTypes.Behavior_3021);
			return types;
		}
		return getTypesForPopupBarGen(host);
	}

	/**
	 * @generated
	 */
	public List<?> getTypesForPopupBarGen(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof StateMachineEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Region_3013);
			types.add(UMLElementTypes.Pseudostate_3014);
			types.add(UMLElementTypes.Pseudostate_3015);
			return types;
		}

		if (editPart instanceof SimpleStateEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Behavior_3019);
			types.add(UMLElementTypes.Behavior_3020);
			types.add(UMLElementTypes.Behavior_3021);
			return types;
		}

		if (editPart instanceof CompositeStateEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Region_3002);
			types.add(UMLElementTypes.Behavior_3019);
			types.add(UMLElementTypes.Behavior_3020);
			types.add(UMLElementTypes.Behavior_3021);
			types.add(UMLElementTypes.Transition_3022);
			return types;
		}

		if (editPart instanceof SubmachineStateEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Region_3002);
			types.add(UMLElementTypes.ConnectionPointReference_3017);
			types.add(UMLElementTypes.ConnectionPointReference_3018);
			types.add(UMLElementTypes.Behavior_3019);
			types.add(UMLElementTypes.Behavior_3020);
			types.add(UMLElementTypes.Behavior_3021);
			types.add(UMLElementTypes.Transition_3022);
			return types;
		}

		if (editPart instanceof StateMachine_RegionSubverticesEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.State_3001);
			types.add(UMLElementTypes.State_3012);
			types.add(UMLElementTypes.State_3016);
			types.add(UMLElementTypes.FinalState_3003);
			types.add(UMLElementTypes.Pseudostate_3004);
			types.add(UMLElementTypes.Pseudostate_3005);
			types.add(UMLElementTypes.Pseudostate_3006);
			types.add(UMLElementTypes.Pseudostate_3007);
			types.add(UMLElementTypes.Pseudostate_3008);
			types.add(UMLElementTypes.Pseudostate_3009);
			types.add(UMLElementTypes.Pseudostate_3010);
			types.add(UMLElementTypes.Pseudostate_3011);
			return types;
		}

		if (editPart instanceof State_RegionSubverticesEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.State_3001);
			types.add(UMLElementTypes.State_3012);
			types.add(UMLElementTypes.State_3016);
			types.add(UMLElementTypes.FinalState_3003);
			types.add(UMLElementTypes.Pseudostate_3004);
			types.add(UMLElementTypes.Pseudostate_3005);
			types.add(UMLElementTypes.Pseudostate_3006);
			types.add(UMLElementTypes.Pseudostate_3007);
			types.add(UMLElementTypes.Pseudostate_3008);
			types.add(UMLElementTypes.Pseudostate_3009);
			types.add(UMLElementTypes.Pseudostate_3010);
			types.add(UMLElementTypes.Pseudostate_3011);
			return types;
		}

		if (editPart instanceof PackageEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.StateMachine_2005);
			return types;
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof SimpleStateEditPart) {
			return ((SimpleStateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CompositeStateEditPart) {
			return ((CompositeStateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SubmachineStateEditPart) {
			return ((SubmachineStateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EntryConnectionPointReferenceEditPart) {
			return ((EntryConnectionPointReferenceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ExitConnectionPointReferenceEditPart) {
			return ((ExitConnectionPointReferenceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InitialPseudostateEditPart) {
			return ((InitialPseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ShallowHistoryPseudostateEditPart) {
			return ((ShallowHistoryPseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DeepHistoryPseudostateEditPart) {
			return ((DeepHistoryPseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ForkPseudostateEditPart) {
			return ((ForkPseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof JoinPseudostateEditPart) {
			return ((JoinPseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof JunctionPseudostateEditPart) {
			return ((JunctionPseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ChoicePseudostateEditPart) {
			return ((ChoicePseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof TerminatePseudostateEditPart) {
			return ((TerminatePseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EntryPointPseudostateEditPart) {
			return ((EntryPointPseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ExitPointPseudostateEditPart) {
			return ((ExitPointPseudostateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof SimpleStateEditPart) {
			return ((SimpleStateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CompositeStateEditPart) {
			return ((CompositeStateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SubmachineStateEditPart) {
			return ((SubmachineStateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EntryConnectionPointReferenceEditPart) {
			return ((EntryConnectionPointReferenceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ExitConnectionPointReferenceEditPart) {
			return ((ExitConnectionPointReferenceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InitialPseudostateEditPart) {
			return ((InitialPseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ShallowHistoryPseudostateEditPart) {
			return ((ShallowHistoryPseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DeepHistoryPseudostateEditPart) {
			return ((DeepHistoryPseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ForkPseudostateEditPart) {
			return ((ForkPseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof JoinPseudostateEditPart) {
			return ((JoinPseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof JunctionPseudostateEditPart) {
			return ((JunctionPseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ChoicePseudostateEditPart) {
			return ((ChoicePseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof TerminatePseudostateEditPart) {
			return ((TerminatePseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EntryPointPseudostateEditPart) {
			return ((EntryPointPseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ExitPointPseudostateEditPart) {
			return ((ExitPointPseudostateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof SimpleStateEditPart) {
			return ((SimpleStateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CompositeStateEditPart) {
			return ((CompositeStateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SubmachineStateEditPart) {
			return ((SubmachineStateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EntryConnectionPointReferenceEditPart) {
			return ((EntryConnectionPointReferenceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ExitConnectionPointReferenceEditPart) {
			return ((ExitConnectionPointReferenceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InitialPseudostateEditPart) {
			return ((InitialPseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ShallowHistoryPseudostateEditPart) {
			return ((ShallowHistoryPseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DeepHistoryPseudostateEditPart) {
			return ((DeepHistoryPseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ForkPseudostateEditPart) {
			return ((ForkPseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof JoinPseudostateEditPart) {
			return ((JoinPseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof JunctionPseudostateEditPart) {
			return ((JunctionPseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ChoicePseudostateEditPart) {
			return ((ChoicePseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof TerminatePseudostateEditPart) {
			return ((TerminatePseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EntryPointPseudostateEditPart) {
			return ((EntryPointPseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ExitPointPseudostateEditPart) {
			return ((ExitPointPseudostateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof SimpleStateEditPart) {
			return ((SimpleStateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CompositeStateEditPart) {
			return ((CompositeStateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SubmachineStateEditPart) {
			return ((SubmachineStateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EntryConnectionPointReferenceEditPart) {
			return ((EntryConnectionPointReferenceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ExitConnectionPointReferenceEditPart) {
			return ((ExitConnectionPointReferenceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InitialPseudostateEditPart) {
			return ((InitialPseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ShallowHistoryPseudostateEditPart) {
			return ((ShallowHistoryPseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DeepHistoryPseudostateEditPart) {
			return ((DeepHistoryPseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ForkPseudostateEditPart) {
			return ((ForkPseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof JoinPseudostateEditPart) {
			return ((JoinPseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof JunctionPseudostateEditPart) {
			return ((JunctionPseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ChoicePseudostateEditPart) {
			return ((ChoicePseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof TerminatePseudostateEditPart) {
			return ((TerminatePseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EntryPointPseudostateEditPart) {
			return ((EntryPointPseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ExitPointPseudostateEditPart) {
			return ((ExitPointPseudostateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof SimpleStateEditPart) {
			return ((SimpleStateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CompositeStateEditPart) {
			return ((CompositeStateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SubmachineStateEditPart) {
			return ((SubmachineStateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EntryConnectionPointReferenceEditPart) {
			return ((EntryConnectionPointReferenceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ExitConnectionPointReferenceEditPart) {
			return ((ExitConnectionPointReferenceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InitialPseudostateEditPart) {
			return ((InitialPseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ShallowHistoryPseudostateEditPart) {
			return ((ShallowHistoryPseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DeepHistoryPseudostateEditPart) {
			return ((DeepHistoryPseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ForkPseudostateEditPart) {
			return ((ForkPseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof JoinPseudostateEditPart) {
			return ((JoinPseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof JunctionPseudostateEditPart) {
			return ((JunctionPseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ChoicePseudostateEditPart) {
			return ((ChoicePseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof TerminatePseudostateEditPart) {
			return ((TerminatePseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EntryPointPseudostateEditPart) {
			return ((EntryPointPseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ExitPointPseudostateEditPart) {
			return ((ExitPointPseudostateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
