package org.eclipse.uml2.diagram.sequence.providers;

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
import org.eclipse.uml2.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.CombinedFragmentMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionOperandMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionUseMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredCombinedFragmentEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredInteractionUseEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredOperandEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.uml2.diagram.sequence.part.Messages;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */

public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List<?> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof InteractionEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Gate_3005);
			types.add(UMLElementTypes.InteractionUse_3007);
			types.add(UMLElementTypes.CombinedFragment_3008);
			types.add(UMLElementTypes.Lifeline_3001);
			return types;
		}

		if (editPart instanceof LayeredCombinedFragmentEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.InteractionOperand_3009);
			return types;
		}

		if (editPart instanceof LifelineEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ActionExecutionSpecification_3002);
			types.add(UMLElementTypes.StateInvariant_3003);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3004);
			types.add(UMLElementTypes.InteractionUse_3006);
			types.add(UMLElementTypes.CombinedFragment_3010);
			return types;
		}

		if (editPart instanceof BehaviorExecutionSpecificationEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3004);
			return types;
		}

		if (editPart instanceof CombinedFragmentMountingRegionEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.InteractionOperand_3011);
			return types;
		}

		if (editPart instanceof PackageEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Interaction_2001);
			return types;
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof GateEditPart) {
			return ((GateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LayeredInteractionUseEditPart) {
			return ((LayeredInteractionUseEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LayeredCombinedFragmentEditPart) {
			return ((LayeredCombinedFragmentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LayeredOperandEditPart) {
			return ((LayeredOperandEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InteractionUseMountingRegionEditPart) {
			return ((InteractionUseMountingRegionEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CombinedFragmentMountingRegionEditPart) {
			return ((CombinedFragmentMountingRegionEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InteractionOperandMountingRegionEditPart) {
			return ((InteractionOperandMountingRegionEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof GateEditPart) {
			return ((GateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LayeredInteractionUseEditPart) {
			return ((LayeredInteractionUseEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LayeredCombinedFragmentEditPart) {
			return ((LayeredCombinedFragmentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LayeredOperandEditPart) {
			return ((LayeredOperandEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InteractionUseMountingRegionEditPart) {
			return ((InteractionUseMountingRegionEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CombinedFragmentMountingRegionEditPart) {
			return ((CombinedFragmentMountingRegionEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InteractionOperandMountingRegionEditPart) {
			return ((InteractionOperandMountingRegionEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof GateEditPart) {
			return ((GateEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LayeredInteractionUseEditPart) {
			return ((LayeredInteractionUseEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LayeredCombinedFragmentEditPart) {
			return ((LayeredCombinedFragmentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LayeredOperandEditPart) {
			return ((LayeredOperandEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InteractionUseMountingRegionEditPart) {
			return ((InteractionUseMountingRegionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CombinedFragmentMountingRegionEditPart) {
			return ((CombinedFragmentMountingRegionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InteractionOperandMountingRegionEditPart) {
			return ((InteractionOperandMountingRegionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof GateEditPart) {
			return ((GateEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LayeredInteractionUseEditPart) {
			return ((LayeredInteractionUseEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LayeredCombinedFragmentEditPart) {
			return ((LayeredCombinedFragmentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LayeredOperandEditPart) {
			return ((LayeredOperandEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InteractionUseMountingRegionEditPart) {
			return ((InteractionUseMountingRegionEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CombinedFragmentMountingRegionEditPart) {
			return ((CombinedFragmentMountingRegionEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InteractionOperandMountingRegionEditPart) {
			return ((InteractionOperandMountingRegionEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof GateEditPart) {
			return ((GateEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LayeredInteractionUseEditPart) {
			return ((LayeredInteractionUseEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LayeredCombinedFragmentEditPart) {
			return ((LayeredCombinedFragmentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LayeredOperandEditPart) {
			return ((LayeredOperandEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InteractionUseMountingRegionEditPart) {
			return ((InteractionUseMountingRegionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CombinedFragmentMountingRegionEditPart) {
			return ((CombinedFragmentMountingRegionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InteractionOperandMountingRegionEditPart) {
			return ((InteractionOperandMountingRegionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
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
