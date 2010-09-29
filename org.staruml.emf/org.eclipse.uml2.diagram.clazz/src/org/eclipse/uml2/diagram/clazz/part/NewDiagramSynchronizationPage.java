package org.eclipse.uml2.diagram.clazz.part;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.diagram.clazz.async.UMLClassSynchronizationWizardPage;

/**
 * @deprecated use {@link UMLClassSynchronizationWizardPage} instead. This class
 * 	remains here only to avoid breaking of the public API.
 */
public class NewDiagramSynchronizationPage extends UMLClassSynchronizationWizardPage {

	public NewDiagramSynchronizationPage(String pageName, TransactionalEditingDomain domain) {
		super(pageName, domain);
	}

}
