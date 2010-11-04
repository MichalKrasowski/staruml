package org.eclipse.uml2.diagram.profile.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
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
import org.eclipse.uml2.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Constraint2EditPart;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImport2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile3EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Stereotype2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeEditPart;

import org.eclipse.uml2.diagram.profile.part.Messages;
import org.eclipse.uml2.diagram.profile.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List<?> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof StereotypeEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Property_3001);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Image_3010);
			return types;
		}

		if (editPart instanceof Profile2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Stereotype_3003);
			return types;
		}

		if (editPart instanceof EnumerationEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.EnumerationLiteral_3005);
			return types;
		}

		if (editPart instanceof Profile3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ElementImport_3009);
			return types;
		}

		if (editPart instanceof ProfileEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Stereotype_2001);
			types.add(UMLElementTypes.Profile_2002);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.ElementImport_2006);
			types.add(UMLElementTypes.Constraint_2008);
			types.add(UMLElementTypes.Comment_2009);
			return types;
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Profile2EditPart) {
			return ((Profile2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ElementImportEditPart) {
			return ((ElementImportEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Profile3EditPart) {
			return ((Profile3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Profile2EditPart) {
			return ((Profile2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ElementImportEditPart) {
			return ((ElementImportEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Profile3EditPart) {
			return ((Profile3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StereotypeEditPart) {
			return ((StereotypeEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EnumerationEditPart) {
			return ((EnumerationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
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
