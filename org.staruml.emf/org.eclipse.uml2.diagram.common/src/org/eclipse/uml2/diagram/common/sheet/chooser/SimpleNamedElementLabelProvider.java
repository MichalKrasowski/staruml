package org.eclipse.uml2.diagram.common.sheet.chooser;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;


public class SimpleNamedElementLabelProvider implements ILabelProvider {

	private final ILabelProvider myOriginalLabelProvider;

	public SimpleNamedElementLabelProvider(ILabelProvider originalLabelProvider) {
		myOriginalLabelProvider = originalLabelProvider;

	}

	public Image getImage(Object element) {
		return myOriginalLabelProvider.getImage(element);
	}

	public String getText(Object element) {
		if (element instanceof NamedElement) {
			return ((NamedElement) element).getName();
		}
		return myOriginalLabelProvider.getText(element);
	}

	public void addListener(ILabelProviderListener listener) {
		myOriginalLabelProvider.addListener(listener);
	}

	public void dispose() {
		myOriginalLabelProvider.dispose();
	}

	public boolean isLabelProperty(Object element, String property) {
		return myOriginalLabelProvider.isLabelProperty(element, property);
	}

	public void removeListener(ILabelProviderListener listener) {
		myOriginalLabelProvider.removeListener(listener);
	}

}
