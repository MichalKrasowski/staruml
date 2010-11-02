package org.eclipse.uml2.diagram.common.async;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;

public class ByVisualIDViewerFilter extends ViewerFilter {

	private final int[] myFilteredVisualId;

	private final IVisualIDRegistry myRegistry;

	public ByVisualIDViewerFilter(IVisualIDRegistry registry, int... filteredVisualId) {
		myRegistry = registry;
		myFilteredVisualId = filteredVisualId.clone();
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof SyncModelNode && !isFilteredVisualId((SyncModelNode) element);
	}

	public boolean isFilteredVisualId(SyncModelNode node) {
		View view = node.getSyncModelView();
		int actualId = myRegistry.getVisualID(view);
		for (int nextVisualId : myFilteredVisualId) {
			if (nextVisualId == actualId) {
				return true;
			}
		}
		return false;
	}

}
