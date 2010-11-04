package org.eclipse.uml2.diagram.component.async;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.diagram.common.async.SynchronizeDiagramAction;
import org.eclipse.uml2.diagram.component.navigator.UMLNavigatorLabelProvider;
import org.eclipse.uml2.diagram.component.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLComponentSynchronizeDiagramAction extends SynchronizeDiagramAction {

	/**
	 * @generated
	 */
	public UMLComponentSynchronizeDiagramAction() {
		super(UMLDiagramUpdater.TYPED_ADAPTER, UMLVisualIDRegistry.TYPED_ADAPTER, new UMLNavigatorLabelProvider());
	}

	/**
	 * @generated
	 */
	@Override
	protected List<ViewerFilter> createViewerFilters() {
		List<ViewerFilter> result = new ArrayList<ViewerFilter>();
		result.add(new UMLComponentDiagramHeaderFilter());
		return result;
	}
}
