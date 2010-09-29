package org.eclipse.uml2.diagram.usecase.providers;

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
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorAsRectangleEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.DiagramHeaderEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.InnerUseCaseEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.NestedPackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageFramecontentsEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.SubjectEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.SubjectUsecasesEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseAsClassEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseinPackageEditPart;
import org.eclipse.uml2.diagram.usecase.part.Messages;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List<?> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof DiagramHeaderEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ElementImport_3001);
			return types;
		}

		if (editPart instanceof UseCaseEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ExtensionPoint_3002);
			return types;
		}

		if (editPart instanceof UseCaseAsClassEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ExtensionPoint_3003);
			return types;
		}

		if (editPart instanceof InnerUseCaseEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ExtensionPoint_3002);
			return types;
		}

		if (editPart instanceof UseCaseinPackageEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ExtensionPoint_3002);
			return types;
		}

		if (editPart instanceof SubjectUsecasesEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.UseCase_3004);
			return types;
		}

		if (editPart instanceof PackageFramecontentsEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Actor_3005);
			types.add(UMLElementTypes.UseCase_3006);
			return types;
		}

		if (editPart instanceof PackageEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Actor_2002);
			types.add(UMLElementTypes.Actor_2005);
			types.add(UMLElementTypes.UseCase_2003);
			types.add(UMLElementTypes.UseCase_2004);
			types.add(UMLElementTypes.Component_2006);
			types.add(UMLElementTypes.Package_2007);
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
		if (sourceEditPart instanceof DiagramHeaderEditPart) {
			return ((DiagramHeaderEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ActorAsRectangleEditPart) {
			return ((ActorAsRectangleEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UseCaseAsClassEditPart) {
			return ((UseCaseAsClassEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SubjectEditPart) {
			return ((SubjectEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof NestedPackageEditPart) {
			return ((NestedPackageEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InnerUseCaseEditPart) {
			return ((InnerUseCaseEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UseCaseinPackageEditPart) {
			return ((UseCaseinPackageEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof DiagramHeaderEditPart) {
			return ((DiagramHeaderEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ActorAsRectangleEditPart) {
			return ((ActorAsRectangleEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UseCaseAsClassEditPart) {
			return ((UseCaseAsClassEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SubjectEditPart) {
			return ((SubjectEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof NestedPackageEditPart) {
			return ((NestedPackageEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InnerUseCaseEditPart) {
			return ((InnerUseCaseEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UseCaseinPackageEditPart) {
			return ((UseCaseinPackageEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof DiagramHeaderEditPart) {
			return ((DiagramHeaderEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ActorAsRectangleEditPart) {
			return ((ActorAsRectangleEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UseCaseAsClassEditPart) {
			return ((UseCaseAsClassEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SubjectEditPart) {
			return ((SubjectEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof NestedPackageEditPart) {
			return ((NestedPackageEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InnerUseCaseEditPart) {
			return ((InnerUseCaseEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UseCaseinPackageEditPart) {
			return ((UseCaseinPackageEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof DiagramHeaderEditPart) {
			return ((DiagramHeaderEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ActorAsRectangleEditPart) {
			return ((ActorAsRectangleEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UseCaseAsClassEditPart) {
			return ((UseCaseAsClassEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SubjectEditPart) {
			return ((SubjectEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof NestedPackageEditPart) {
			return ((NestedPackageEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InnerUseCaseEditPart) {
			return ((InnerUseCaseEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UseCaseinPackageEditPart) {
			return ((UseCaseinPackageEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof DiagramHeaderEditPart) {
			return ((DiagramHeaderEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ActorAsRectangleEditPart) {
			return ((ActorAsRectangleEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UseCaseAsClassEditPart) {
			return ((UseCaseAsClassEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SubjectEditPart) {
			return ((SubjectEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof NestedPackageEditPart) {
			return ((NestedPackageEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InnerUseCaseEditPart) {
			return ((InnerUseCaseEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UseCaseinPackageEditPart) {
			return ((UseCaseinPackageEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
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
