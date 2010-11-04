package org.eclipse.uml2.diagram.component.providers;

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
import org.eclipse.uml2.diagram.component.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContents2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContents3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContentsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssemblyConnectorCircleEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentContents2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentContentsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortOnClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.component.part.Messages;
import org.eclipse.uml2.diagram.component.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List<?> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof ComponentEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3002);
			return types;
		}

		if (editPart instanceof Class2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3002);
			return types;
		}

		if (editPart instanceof Package2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ElementImport_3007);
			return types;
		}

		if (editPart instanceof Package3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Package_3008);
			types.add(UMLElementTypes.Class_3009);
			types.add(UMLElementTypes.Component_3010);
			return types;
		}

		if (editPart instanceof ClassDiagramNotationClassEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3014);
			types.add(UMLElementTypes.Property_3011);
			types.add(UMLElementTypes.Operation_3012);
			types.add(UMLElementTypes.Class_3013);
			return types;
		}

		if (editPart instanceof Component2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3002);
			return types;
		}

		if (editPart instanceof ClassEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3002);
			return types;
		}

		if (editPart instanceof ComponentContentsEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Component_3001);
			types.add(UMLElementTypes.Artifact_3003);
			types.add(UMLElementTypes.Class_3004);
			types.add(UMLElementTypes.Interface_3005);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Connector_3015);
			return types;
		}

		if (editPart instanceof ComponentContents2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Component_3001);
			types.add(UMLElementTypes.Artifact_3003);
			types.add(UMLElementTypes.Class_3004);
			types.add(UMLElementTypes.Interface_3005);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Connector_3015);
			return types;
		}

		if (editPart instanceof ArtifactContentsEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Artifact_3016);
			return types;
		}

		if (editPart instanceof ArtifactContents2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Artifact_3016);
			return types;
		}

		if (editPart instanceof ArtifactContents3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Artifact_3016);
			return types;
		}

		if (editPart instanceof PackageEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Component_2001);
			types.add(UMLElementTypes.Artifact_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Class_2004);
			types.add(UMLElementTypes.Package_2006);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Comment_2008);
			return types;
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ClassDiagramNotationClassEditPart) {
			return ((ClassDiagramNotationClassEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Component2EditPart) {
			return ((Component2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Artifact3EditPart) {
			return ((Artifact3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AssemblyConnectorCircleEditPart) {
			return ((AssemblyConnectorCircleEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PortOnClassEditPart) {
			return ((PortOnClassEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ClassDiagramNotationClassEditPart) {
			return ((ClassDiagramNotationClassEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Component2EditPart) {
			return ((Component2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PortEditPart) {
			return ((PortEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Artifact3EditPart) {
			return ((Artifact3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AssemblyConnectorCircleEditPart) {
			return ((AssemblyConnectorCircleEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PortOnClassEditPart) {
			return ((PortOnClassEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ClassDiagramNotationClassEditPart) {
			return ((ClassDiagramNotationClassEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Component2EditPart) {
			return ((Component2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Artifact3EditPart) {
			return ((Artifact3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AssemblyConnectorCircleEditPart) {
			return ((AssemblyConnectorCircleEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PortOnClassEditPart) {
			return ((PortOnClassEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ClassDiagramNotationClassEditPart) {
			return ((ClassDiagramNotationClassEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Component2EditPart) {
			return ((Component2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PortEditPart) {
			return ((PortEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Artifact3EditPart) {
			return ((Artifact3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AssemblyConnectorCircleEditPart) {
			return ((AssemblyConnectorCircleEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PortOnClassEditPart) {
			return ((PortOnClassEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ClassDiagramNotationClassEditPart) {
			return ((ClassDiagramNotationClassEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Component2EditPart) {
			return ((Component2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Artifact3EditPart) {
			return ((Artifact3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ClassEditPart) {
			return ((ClassEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PropertyEditPart) {
			return ((PropertyEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AssemblyConnectorCircleEditPart) {
			return ((AssemblyConnectorCircleEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PortOnClassEditPart) {
			return ((PortOnClassEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
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
