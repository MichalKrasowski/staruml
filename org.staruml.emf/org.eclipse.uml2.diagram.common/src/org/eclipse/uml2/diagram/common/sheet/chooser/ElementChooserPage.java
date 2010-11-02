package org.eclipse.uml2.diagram.common.sheet.chooser;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface ElementChooserPage {

	List<?> getSelection();

	void setSelection(List<?> selection);

	Control createControl(Composite parent);

	void addDoubleClickListener(IDoubleClickListener l);

	void addSelectionListener(ISelectionChangedListener l);

	interface Validator {

		EObject validate(Object object);
	}
}
