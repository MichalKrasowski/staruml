package org.eclipse.uml2.diagram.csd.async;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.diagram.common.async.SynchronizeDiagramAction;
import org.eclipse.uml2.diagram.csd.navigator.UMLNavigatorLabelProvider;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLCompositeStructuresSynchronizeDiagramAction extends SynchronizeDiagramAction {

	/**
	 * @generated
	 */
	public UMLCompositeStructuresSynchronizeDiagramAction() {
		super(UMLDiagramUpdater.TYPED_ADAPTER, UMLVisualIDRegistry.TYPED_ADAPTER, new UMLNavigatorLabelProvider());
	}

	/**
	 * @generated
	 */
	@Override
	protected List<ViewerFilter> createViewerFilters() {
		List<ViewerFilter> result = new ArrayList<ViewerFilter>();
		result.add(new UMLCompositeStructuresDiagramHeaderFilter());
		return result;
	}
}
