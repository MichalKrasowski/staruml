package org.eclipse.uml2.diagram.common.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

public class NewDiagramPropertyTester extends PropertyTester {

	private static final String PROPERTY_IS_PACKAGE = "isPackage"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (PROPERTY_IS_PACKAGE.equals(property)) {
			return isPackage(receiver);
		}
		return false;
	}

	private static boolean isPackage(Object object) {
		EObject element = null;
		if (object instanceof IGraphicalEditPart) {
			element = ((IGraphicalEditPart) object).getNotationView().getElement();
		}
		if (object instanceof EObject) {
			element = (EObject) element;
		}
		return (element != null) && (element instanceof org.eclipse.uml2.uml.Package);
	}

}
