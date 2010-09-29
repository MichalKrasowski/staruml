package org.eclipse.uml2.diagram.deploy.async;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.diagram.common.async.SynchronizeDiagramAction;
import org.eclipse.uml2.diagram.deploy.navigator.UMLNavigatorLabelProvider;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLDeploymentSynchronizeDiagramAction extends SynchronizeDiagramAction {

	/**
	 * @generated
	 */
	public UMLDeploymentSynchronizeDiagramAction() {
		super(UMLDiagramUpdater.TYPED_ADAPTER, UMLVisualIDRegistry.TYPED_ADAPTER, new UMLNavigatorLabelProvider());
	}

	/**
	 * @generated
	 */
	@Override
	protected List<ViewerFilter> createViewerFilters() {
		List<ViewerFilter> result = new ArrayList<ViewerFilter>();
		result.add(new UMLDeploymentDiagramHeaderFilter());
		return result;
	}
}
