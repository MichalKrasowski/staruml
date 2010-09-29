package org.eclipse.uml2.diagram.csd.providers;

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
import org.eclipse.uml2.diagram.csd.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassClass_contentsEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationContentsEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUse2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.csd.part.Messages;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List<?> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof ClassEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3011);
			types.add(UMLElementTypes.Property_3008);
			types.add(UMLElementTypes.Operation_3009);
			types.add(UMLElementTypes.Class_3010);
			return types;
		}

		if (editPart instanceof Package2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ElementImport_3004);
			return types;
		}

		if (editPart instanceof Class3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3017);
			return types;
		}

		if (editPart instanceof InstanceSpecificationEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Slot_3015);
			return types;
		}

		if (editPart instanceof Property3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3016);
			return types;
		}

		if (editPart instanceof CollaborationContentsEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.CollaborationUse_3002);
			types.add(UMLElementTypes.Property_3007);
			return types;
		}

		if (editPart instanceof ClassClass_contentsEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Property_3014);
			return types;
		}

		if (editPart instanceof PackageEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.InstanceSpecification_2011);
			types.add(UMLElementTypes.Constraint_2012);
			types.add(UMLElementTypes.Comment_2013);
			return types;
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CollaborationEditPart) {
			return ((CollaborationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Class3EditPart) {
			return ((Class3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CollaborationUse2EditPart) {
			return ((CollaborationUse2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Property3EditPart) {
			return ((Property3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Port2EditPart) {
			return ((Port2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Port3EditPart) {
			return ((Port3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof CollaborationEditPart) {
			return ((CollaborationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Class3EditPart) {
			return ((Class3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CollaborationUse2EditPart) {
			return ((CollaborationUse2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PortEditPart) {
			return ((PortEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Property3EditPart) {
			return ((Property3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Port2EditPart) {
			return ((Port2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Port3EditPart) {
			return ((Port3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CollaborationEditPart) {
			return ((CollaborationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Class3EditPart) {
			return ((Class3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CollaborationUse2EditPart) {
			return ((CollaborationUse2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Property3EditPart) {
			return ((Property3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Port2EditPart) {
			return ((Port2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Port3EditPart) {
			return ((Port3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof CollaborationEditPart) {
			return ((CollaborationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Class3EditPart) {
			return ((Class3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CollaborationUse2EditPart) {
			return ((CollaborationUse2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PortEditPart) {
			return ((PortEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Property3EditPart) {
			return ((Property3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Port2EditPart) {
			return ((Port2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Port3EditPart) {
			return ((Port3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CollaborationEditPart) {
			return ((CollaborationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Class3EditPart) {
			return ((Class3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InstanceSpecificationEditPart) {
			return ((InstanceSpecificationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CollaborationUse2EditPart) {
			return ((CollaborationUse2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Property3EditPart) {
			return ((Property3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Port2EditPart) {
			return ((Port2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Port3EditPart) {
			return ((Port3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
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
