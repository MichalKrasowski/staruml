package org.eclipse.uml2.diagram.clazz.part;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.diagram.clazz.async.UMLClassFixedElementsWizard;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * @deprecated use {@link UMLClassFixedElementsWizard} instead
 * This class remains here only to avoid breaking of the public API.
 */
public class NewDiagramForFixedElementsWizard extends UMLClassFixedElementsWizard {
	public NewDiagramForFixedElementsWizard(URI domainModelURI, EObject diagramRoot, PackageableElement[] toSelect, TransactionalEditingDomain editingDomain) {
		super(domainModelURI, diagramRoot, toSelect, editingDomain);
	}
}
