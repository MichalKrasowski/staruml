package org.eclipse.uml2.diagram.csd.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.async.ICanonicalHelper;
import org.eclipse.uml2.diagram.common.conventions.ConnectorEndConvention;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionRequest;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUse2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.csd.links.UMLInterfaceLinkManager;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @NOT-generated
	 */
	@Override
	public void activate() {
		super.activate();
		addListenerFilter("NotationListener_Container" + getDiagram().toString(), this, getDiagram(), NotationPackage.eINSTANCE.getView_PersistedChildren());
	}

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = UMLDiagramUpdater.getSemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((IUpdaterNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			return UMLDiagramUpdater.isShortcutOrphaned(view);
		}
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		int suggestedID = UMLVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement());
		switch (visualID) {
		case CollaborationUse2EditPart.VISUAL_ID:
		case PropertyEditPart.VISUAL_ID:
		case Property2EditPart.VISUAL_ID:
		case OperationEditPart.VISUAL_ID:
		case Class2EditPart.VISUAL_ID:
		case PortEditPart.VISUAL_ID:
		case ElementImportEditPart.VISUAL_ID:
		case Property3EditPart.VISUAL_ID:
		case Port2EditPart.VISUAL_ID:
		case Port3EditPart.VISUAL_ID:
		case SlotEditPart.VISUAL_ID:
			return true;
		case CollaborationEditPart.VISUAL_ID:
		case Package2EditPart.VISUAL_ID:
		case InterfaceEditPart.VISUAL_ID:
		case InstanceSpecificationEditPart.VISUAL_ID:
		case ConstraintEditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			return (visualID != suggestedID) && (suggestedID != Class3EditPart.VISUAL_ID);
		case Class3EditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			return (visualID != suggestedID) && (suggestedID != ClassEditPart.VISUAL_ID);
		}
		return false;
	}

	/**
	 * @generated
	 */
	private void populateViewProperties(View oldView, View newView) {
		if (oldView instanceof Node && newView instanceof Node) {
			Node oldNode = (Node) oldView;
			Node newNode = (Node) newView;
			if (oldNode.getLayoutConstraint() instanceof Location && newNode.getLayoutConstraint() instanceof Location) {
				((Location) newNode.getLayoutConstraint()).setX(((Location) oldNode.getLayoutConstraint()).getX());
				((Location) newNode.getLayoutConstraint()).setY(((Location) oldNode.getLayoutConstraint()).getY());
			}
			if (oldNode.getLayoutConstraint() instanceof Size && newNode.getLayoutConstraint() instanceof Size) {
				((Size) newNode.getLayoutConstraint()).setWidth(((Size) oldNode.getLayoutConstraint()).getWidth());
				((Size) newNode.getLayoutConstraint()).setHeight(((Size) oldNode.getLayoutConstraint()).getHeight());
			}
			if (oldNode.getLayoutConstraint() instanceof Ratio && newNode.getLayoutConstraint() instanceof Ratio) {
				((Ratio) newNode.getLayoutConstraint()).setValue(((Ratio) oldNode.getLayoutConstraint()).getValue());
			}
			newNode.persist();
		}
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		if (myCanonicalHelper.shouldSyncNodes(getNotationView())) {
			createdViews.addAll(refreshSemanticChildren());
		}
		List createdConnectionViews = new LinkedList();
		if (myCanonicalHelper.shouldSyncLinks(getNotationView())) {
			createdConnectionViews.addAll(refreshSemanticConnections());
			createdConnectionViews.addAll(refreshConnections());
		}

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
	}

	/**
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	 * @generated NOT
	 * [215245]Refresh connector when PartWithPort changes
	 */
	private Collection refreshConnections() {
		return refreshConnectionsGen();
		//		Domain2Notation domain2NotationMap = new Domain2Notation();
		//		Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		//		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		//		for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
		//			Edge nextDiagramLink = (Edge) linksIterator.next();
		//			int diagramLinkVisualID = UMLVisualIDRegistry.getVisualID(nextDiagramLink);
		//			if (diagramLinkVisualID == -1) {
		//				if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
		//					linksIterator.remove();
		//				}
		//				continue;
		//			}
		//			EObject diagramLinkObject = nextDiagramLink.getElement();
		//			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
		//			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
		//			for (Iterator LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator.hasNext();) {
		//				UMLLinkDescriptor nextLinkDescriptor = (UMLLinkDescriptor) LinkDescriptorsIterator.next();
		//				if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination()
		//						&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
		//					// START [215245]Refresh connector when PartWithPort changes
		//					if (!nextDiagramLink.getSource().equals(((IGraphicalEditPart) getSourceEditPart(nextLinkDescriptor, domain2NotationMap)).getNotationView())
		//							|| !nextDiagramLink.getTarget().equals(((IGraphicalEditPart) getTargetEditPart(nextLinkDescriptor, domain2NotationMap)).getNotationView())) {
		//						continue;
		//					}
		//					// END [215245]
		//					linksIterator.remove();
		//					LinkDescriptorsIterator.remove();
		//				}
		//			}
		//		}
		//		deleteViews(existingLinks.iterator());
		//		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection refreshConnectionsGen() {
		Domain2Notation domain2NotationMap = new Domain2Notation();
		Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			int diagramLinkVisualID = UMLVisualIDRegistry.getVisualID(nextDiagramLink);
			if (diagramLinkVisualID == -1) {
				if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			//don't remove notation-only links 
			if (isNotationOnlyEdge(nextDiagramLink)) {
				linksIterator.remove();
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			boolean existingLinkRemoved = false;
			for (Iterator LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator.hasNext();) {
				IUpdaterLinkDescriptor nextLinkDescriptor = (IUpdaterLinkDescriptor) LinkDescriptorsIterator.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					if (!existingLinkRemoved) {
						linksIterator.remove();
						existingLinkRemoved = true;
					}
					LinkDescriptorsIterator.remove();
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated NOT
	 */
	private Collection collectAllLinks(View view, Domain2Notation domain2NotationMap) {
		if (view instanceof Diagram) {
			return new UMLInterfaceLinkManager(collectAllLinksGen(view, domain2NotationMap)).getFilteredLinkDescriptors();
		}
		return collectAllLinksGen(view, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection collectAllLinksGen(View view, Domain2Notation domain2NotationMap) {
		if (UMLVisualIDRegistry.isShortcutDescendant(view)) {
			return collectLinksOutgoingFromShortcut(view, domain2NotationMap);
		}
		Collection result = new LinkedList();
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_1000ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CollaborationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCollaboration_2005ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ClassEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getClass_2006ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Package2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_2003ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Class3EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getClass_2007ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case InterfaceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInterface_2009ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case InstanceSpecificationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInstanceSpecification_2011ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ConstraintEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_2012ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CommentEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComment_2013ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CollaborationUse2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCollaborationUse_3002ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case PropertyEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getProperty_3007ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Property2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getProperty_3008ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case OperationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOperation_3009ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Class2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getClass_3010ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case PortEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPort_3011ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ElementImportEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getElementImport_3004ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Property3EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getProperty_3014ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Port2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPort_3016ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Port3EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPort_3017ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case SlotEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getSlot_3015ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ConnectorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConnector_4005ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case DependencyEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDependency_4006ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case InterfaceRealizationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInterfaceRealization_4007ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case UsageEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getUsage_4008ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case AssociationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAssociation_4011ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case AssociationInstanceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getSlot_4015ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection createConnections(Collection linkDescriptors, Domain2Notation domain2NotationMap) {
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
			final IUpdaterLinkDescriptor nextLinkDescriptor = (IUpdaterLinkDescriptor) linkDescriptorsIterator.next();
			EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor, domain2NotationMap);
			EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor, domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), UMLVisualIDRegistry
					.getType(nextLinkDescriptor.getVisualID()), ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private EditPart getSourceEditPartGen(IUpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getSource(), domain2NotationMap);
	}

	/**
	 * @generated NOT
	 */
	private EditPart getSourceEditPart(IUpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		if (ConnectorEditPart.VISUAL_ID == descriptor.getVisualID() && ConnectorEndConvention.getSourceEnd((Connector) descriptor.getModelElement()).getPartWithPort() != null) {
			// [209651] Connector link goes to duplicate Port on the boundary of a Part
			return getHintedChildEditPart(ConnectorEndConvention.getSourceEnd((Connector) descriptor.getModelElement()).getPartWithPort(), descriptor.getSource(), domain2NotationMap,
					Port2EditPart.VISUAL_ID);
		}
		return getSourceEditPartGen(descriptor, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private EditPart getTargetEditPartGen(IUpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getDestination(), domain2NotationMap);
	}

	/**
	 * @generated NOT
	 */
	private EditPart getTargetEditPart(IUpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		if (ConnectorEditPart.VISUAL_ID == descriptor.getVisualID() && ConnectorEndConvention.getTargetEnd((Connector) descriptor.getModelElement()).getPartWithPort() != null) {
			// [209651] Connector link goes to duplicate Port on the boundary of a Part
			return getHintedChildEditPart(ConnectorEndConvention.getTargetEnd((Connector) descriptor.getModelElement()).getPartWithPort(), descriptor.getDestination(), domain2NotationMap,
					Port2EditPart.VISUAL_ID);
		}
		return getTargetEditPartGen(descriptor, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	protected final EditPart getHintedEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap, int hintVisualId) {
		View view = (View) domain2NotationMap.getHinted(domainModelElement, UMLVisualIDRegistry.getType(hintVisualId));
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isNotationOnlyEdge(Edge edge) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection<IUpdaterLinkDescriptor> collectLinksOutgoingFromShortcut(View view, Domain2Notation domain2NotationMap) {
		EditPart ep = (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		if (false == ep instanceof IGraphicalEditPart) {
			return Collections.emptyList();
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) ep;
		UpdateDescriptionRequest request = new UpdateDescriptionRequest();
		//we are not using the result command -- each editpart from the tree 
		//is required to push data into the request
		editPart.getCommand(request);

		Set<IUpdaterLinkDescriptor> linksToFromShortcuts = new HashSet<IUpdaterLinkDescriptor>();
		for (UpdateDescriptionRequest.Descriptor next : request.getDescriptions()) {
			linksToFromShortcuts.addAll(next.getContainedLinks());
			linksToFromShortcuts.addAll(next.getOutgoingLinks());

			if (next.getSemanticElement() != null) {
				domain2NotationMap.put(next.getSemanticElement(), next.getProvider().getNotationView());
			}

		}

		return linksToFromShortcuts;
	}

	/**
	 * @NOT-generated
	 */
	protected final EditPart getHintedChildEditPart(EObject parent, EObject domainModelElement, Domain2Notation domain2NotationMap, int hintVisualId) {
		View view = (View) domain2NotationMap.getHintedChild(parent, domainModelElement, UMLVisualIDRegistry.getType(hintVisualId));
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private static class Domain2Notation {

		/**
		 * @generated
		 */
		private final HashMap myMap = new HashMap();

		/**
		 * @generated
		 */
		public boolean containsDomainElement(EObject domainElement) {
			return myMap.containsKey(domainElement);
		}

		/**
		 * @generated
		 */
		public boolean containsKey(EObject domainElement) {
			return containsDomainElement(domainElement);
		}

		/**
		 * @generated
		 */
		public void put(EObject domainElement, View view) {
			Object viewOrList = myMap.get(domainElement);
			if (viewOrList instanceof View) {
				myMap.remove(domainElement);
				List<View> list = new LinkedList<View>();
				list.add((View) viewOrList);
				myMap.put(domainElement, list);
				list.add(view);
			} else if (viewOrList instanceof List) {
				((List) viewOrList).add(view);
			} else {
				myMap.put(domainElement, view);
			}
		}

		/**
		 * @generated
		 */
		public View get(EObject domainEObject) {
			Object viewOrList = myMap.get(domainEObject);
			if (viewOrList instanceof View) {
				return (View) viewOrList;
			}
			if (viewOrList instanceof List) {
				// preferring not-shortcut to shortcut -- important for cases when links arr to/from 
				// the element that is additionally shortcutted to the same diagram
				for (Object next : (List) viewOrList) {
					View nextView = (View) next;
					if (nextView.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
						return nextView;
					}
				}
				return (View) ((List) viewOrList).get(0);
			}
			return null;
		}

		/**
		 * @generated
		 */
		public View getHinted(EObject domainEObject, String hint) {
			if (hint == null) {
				return get(domainEObject);
			}
			Object viewOrList = myMap.get(domainEObject);
			if (viewOrList instanceof View) {
				//no choice, will return what we have
				return (View) viewOrList;
			}
			if (viewOrList instanceof List) {
				for (Object next : (List) viewOrList) {
					View nextView = (View) next;
					if (hint.equals(nextView.getType())) {
						return nextView;
					}
				}
				//hint not found -- return what we have
				return (View) ((List) viewOrList).get(0);
			}
			return null;
		}

		/**
		 * @NOT-generated
		 */
		public View getHintedChild(EObject parent, EObject domainEObject, String hint) {
			if (domainEObject == null) {
				return null;
			}
			if (hint == null) {
				return get(domainEObject);
			}
			View parentView = get(parent);
			if (parentView == null) {
				return null;
			}
			EList children = parentView.getChildren();
			for (Object child : children) {
				View nextView = (View) child;
				if (domainEObject.equals(nextView.getElement()) && hint.equals(nextView.getType())) {
					return nextView;
				}
			}
			return null;
		}

	}

	/**
	 * @generated
	 */
	private View getNotationView() {
		return (View) getHost().getModel();
	}

	/**
	 * @generated
	 */
	private final ICanonicalHelper myCanonicalHelper = ICanonicalHelper.IMPLEMENTATION;

	/**
	 * @generated
	 */
	@Override
	protected String getFactoryHint(IAdaptable elementAdapter) {
		EObject domainModelElment = (EObject) elementAdapter.getAdapter(EObject.class);
		View containerView = ((IGraphicalEditPart) getHost()).getNotationView();
		int hint = UMLVisualIDRegistry.getNodeVisualID(containerView, domainModelElment);
		return (hint != -1) ? UMLVisualIDRegistry.getType(hint) : super.getFactoryHint(elementAdapter);
	}
}
