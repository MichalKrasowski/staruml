package org.eclipse.uml2.diagram.profile.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7008;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 7007;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem item = (UMLNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return UMLVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
