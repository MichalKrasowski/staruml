package org.eclipse.uml2.diagram.profile.async;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.diagram.common.async.SynchronizeDiagramAction;
import org.eclipse.uml2.diagram.profile.navigator.UMLNavigatorLabelProvider;
import org.eclipse.uml2.diagram.profile.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLProfileSynchronizeDiagramAction extends SynchronizeDiagramAction {

	/**
	 * @generated
	 */
	public UMLProfileSynchronizeDiagramAction() {
		super(UMLDiagramUpdater.TYPED_ADAPTER, UMLVisualIDRegistry.TYPED_ADAPTER, new UMLNavigatorLabelProvider());
	}

	/**
	 * @generated
	 */
	@Override
	protected List<ViewerFilter> createViewerFilters() {
		List<ViewerFilter> result = new ArrayList<ViewerFilter>();
		result.add(new UMLProfileDiagramHeaderFilter());
		return result;
	}
}
