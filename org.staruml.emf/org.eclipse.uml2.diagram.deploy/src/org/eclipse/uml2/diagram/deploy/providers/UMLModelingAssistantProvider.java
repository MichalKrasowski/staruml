package org.eclipse.uml2.diagram.deploy.providers;

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
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contents2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contents3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contentsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecification2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Device2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceDevicecontents2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceDevicecontentsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironment2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Node2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.deploy.part.Messages;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List<?> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof Package2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ElementImport_3001);
			return types;
		}

		if (editPart instanceof ExecutionEnvironmentEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Artifact_3006);
			return types;
		}

		if (editPart instanceof DeploymentSpecificationEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Property_3003);
			return types;
		}

		if (editPart instanceof DeploymentSpecification2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Property_3003);
			return types;
		}

		if (editPart instanceof ExecutionEnvironment2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Artifact_3006);
			return types;
		}

		if (editPart instanceof DeviceDevicecontentsEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Device_3004);
			types.add(UMLElementTypes.Artifact_3002);
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
			types.add(UMLElementTypes.Node_3007);
			return types;
		}

		if (editPart instanceof DeviceDevicecontents2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Device_3004);
			types.add(UMLElementTypes.Artifact_3002);
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
			types.add(UMLElementTypes.Node_3007);
			return types;
		}

		if (editPart instanceof ArtifactArtifactFigure_contentsEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
			return types;
		}

		if (editPart instanceof ArtifactArtifactFigure_contents2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
			return types;
		}

		if (editPart instanceof ArtifactArtifactFigure_contents3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
			return types;
		}

		if (editPart instanceof PackageEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Node_2004);
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.DeploymentSpecification_2007);
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
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof NodeEditPart) {
			return ((NodeEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Device2EditPart) {
			return ((Device2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Artifact4EditPart) {
			return ((Artifact4EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DeploymentSpecification2EditPart) {
			return ((DeploymentSpecification2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ExecutionEnvironment2EditPart) {
			return ((ExecutionEnvironment2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Node2EditPart) {
			return ((Node2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof NodeEditPart) {
			return ((NodeEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Device2EditPart) {
			return ((Device2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Artifact4EditPart) {
			return ((Artifact4EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			return ((DeploymentSpecification2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ExecutionEnvironment2EditPart) {
			return ((ExecutionEnvironment2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Node2EditPart) {
			return ((Node2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof NodeEditPart) {
			return ((NodeEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Device2EditPart) {
			return ((Device2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Artifact4EditPart) {
			return ((Artifact4EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DeploymentSpecification2EditPart) {
			return ((DeploymentSpecification2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ExecutionEnvironment2EditPart) {
			return ((ExecutionEnvironment2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Node2EditPart) {
			return ((Node2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof NodeEditPart) {
			return ((NodeEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Device2EditPart) {
			return ((Device2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Artifact4EditPart) {
			return ((Artifact4EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			return ((DeploymentSpecification2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ExecutionEnvironment2EditPart) {
			return ((ExecutionEnvironment2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Node2EditPart) {
			return ((Node2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof NodeEditPart) {
			return ((NodeEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Artifact2EditPart) {
			return ((Artifact2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DeploymentSpecificationEditPart) {
			return ((DeploymentSpecificationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Device2EditPart) {
			return ((Device2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Artifact4EditPart) {
			return ((Artifact4EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DeploymentSpecification2EditPart) {
			return ((DeploymentSpecification2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ExecutionEnvironment2EditPart) {
			return ((ExecutionEnvironment2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Node2EditPart) {
			return ((Node2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
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
