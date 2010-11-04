package org.eclipse.uml2.diagram.component.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.eclipse.uml2.diagram.component.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContents2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContents3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContentsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssemblyConnectorCircleEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssemblyConnectorEndRoleEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassAttributesEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassClassesEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationInnerClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationOperationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationPropertyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassOperationsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentContents2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentContentsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentRequiredEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package4EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageClassifiersEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageImportsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackagePackagesEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortOnClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.component.part.Messages;
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	public UMLNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {

			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {

			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {

			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
			Resource resource = (Resource) it.next();
			resource.unload();
		}
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), PackageEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		/*
		 * Due to plugin.xml restrictions this code will be called only for views representing
		 * shortcuts to this diagram elements created on other diagrams. 
		 */
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement).getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {

		case PackageEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			UMLNavigatorGroup links = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationClassEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortProvidedEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortRequiredEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentRequiredEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssemblyConnectorEndRoleEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case ComponentEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_2001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_2001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContentsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContentsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContentsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContentsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContentsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContentsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(AssemblyConnectorCircleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentRequiredEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Artifact2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Artifact_2002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Artifact_2002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ArtifactContents3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Interface2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Interface_2003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Interface_2003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortProvidedEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortRequiredEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentRequiredEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Class2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_2004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_2004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Package2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_2005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_2005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ElementImportEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Package3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_2006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_2006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackagesEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(Package4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageClassifiersEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageClassifiersEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ClassDiagramNotationClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_2007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_2007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassAttributesEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ClassDiagramNotationPropertyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassOperationsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ClassDiagramNotationOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassClassesEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ClassDiagramNotationInnerClassEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CommentEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_2008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_2008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Component2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_3001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_3001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContents2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContents2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContents2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContents2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContents2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentContents2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(AssemblyConnectorCircleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentRequiredEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PortEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Port_3002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Port_3002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortProvidedEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortRequiredEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssemblyConnectorEndRoleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ArtifactEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Artifact_3003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Artifact_3003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ArtifactContentsEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Artifact3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Artifact_3016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Artifact_3016_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ArtifactContents2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_3004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_3004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case InterfaceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Interface_3005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Interface_3005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortProvidedEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortRequiredEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentRequiredEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PropertyEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Property_3006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Property_3006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssemblyConnectorEndRoleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AssemblyConnectorCircleEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Connector_3015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Connector_3015_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ElementImportEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ElementImport_3007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Package4EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_3008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_3008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Class3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_3009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_3009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Component3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_3010_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_3010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentRequiredEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ClassDiagramNotationPropertyEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Property_3011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Property_3011_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssemblyConnectorEndRoleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ClassDiagramNotationOperationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Operation_3012_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Operation_3012_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ClassDiagramNotationInnerClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_3013_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Class_3013_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PortOnClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Port_3014_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Port_3014_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortProvidedEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortRequiredEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssemblyConnectorEndRoleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case InterfaceRealizationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_InterfaceRealization_4001_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_InterfaceRealization_4001_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationInnerClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PortProvidedEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_PortProvided_4006_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_PortProvided_4006_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PortRequiredEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_PortRequired_4004_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_PortRequired_4004_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ComponentRequiredEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ComponentRequired_4007_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_ComponentRequired_4007_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ConnectorEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Connector_4008_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Connector_4008_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationPropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationPropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case DependencyEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Dependency_4009_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Dependency_4009_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssemblyConnectorCircleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationPropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationOperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationInnerClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssemblyConnectorCircleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationPropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationOperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationInnerClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AssemblyConnectorEndRoleEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConnectorEndRole_4010_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationPropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			return result.toArray();
		}

		case AssociationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Association_4011_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Association_4011_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationInnerClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationInnerClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case CommentAnnotatedElementEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_CommentAnnotatedElement_4012_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_CommentAnnotatedElement_4012_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssemblyConnectorCircleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ElementImportEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Package4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationPropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationOperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ClassDiagramNotationInnerClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PortOnClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent, boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new UMLNavigatorItem((View) it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getForeignShortcuts(Diagram diagram, Object parent) {
		Collection result = new ArrayList();
		for (Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof UMLAbstractNavigatorItem) {
			UMLAbstractNavigatorItem abstractNavigatorItem = (UMLAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
