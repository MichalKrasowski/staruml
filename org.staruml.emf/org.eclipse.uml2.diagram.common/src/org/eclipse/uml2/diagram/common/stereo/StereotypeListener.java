package org.eclipse.uml2.diagram.common.stereo;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public interface StereotypeListener {

	public TaggedValueHelper stereotypeApplied(Element owner, Stereotype applied, EObject application);

	public void stereotypeUnapplied(Element owner, Stereotype applied);

}
