package org.eclipse.uml2.diagram.common.genapi;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;


public interface IUpdaterLinkDescriptor extends IUpdaterNodeDescriptor {
	public EObject getSource();

	public EObject getDestination();

	public IAdaptable getSemanticAdapter();

}
