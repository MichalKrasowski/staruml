package org.eclipse.uml2.diagram.usecase.async;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.diagram.common.async.SynchronizeDiagramAction;
import org.eclipse.uml2.diagram.usecase.navigator.UMLNavigatorLabelProvider;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLUseCaseSynchronizeDiagramAction extends SynchronizeDiagramAction {

	/**
	 * @generated
	 */
	public UMLUseCaseSynchronizeDiagramAction() {
		super(UMLDiagramUpdater.TYPED_ADAPTER, UMLVisualIDRegistry.TYPED_ADAPTER, new UMLNavigatorLabelProvider());
	}

	/**
	 * @generated
	 */
	@Override
	protected List<ViewerFilter> createViewerFilters() {
		List<ViewerFilter> result = new ArrayList<ViewerFilter>();
		result.add(new UMLUseCaseDiagramHeaderFilter());
		return result;
	}
}
