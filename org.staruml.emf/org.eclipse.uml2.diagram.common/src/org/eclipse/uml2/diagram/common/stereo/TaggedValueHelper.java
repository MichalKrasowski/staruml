package org.eclipse.uml2.diagram.common.stereo;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public interface TaggedValueHelper {
	public boolean isAlive();
	public Element getStereotypeOwner();
	public Stereotype getStereotype();
	//public EObject getRawApplication();
	public void addTaggedValueListener(TaggedValueListener listener);
	public void removeTaggedValueListener(TaggedValueListener listener);

}
