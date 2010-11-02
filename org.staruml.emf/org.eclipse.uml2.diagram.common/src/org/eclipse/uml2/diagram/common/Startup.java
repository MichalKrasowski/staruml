package org.eclipse.uml2.diagram.common;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.IStartup;
import org.eclipse.uml2.diagram.common.validation.UML2ToolsValidator;
import org.eclipse.uml2.uml.UMLPackage;

public class Startup implements IStartup {

	public void earlyStartup() {
		EValidator.Registry.INSTANCE.put(UMLPackage.eINSTANCE, new UML2ToolsValidator());
	}

}
