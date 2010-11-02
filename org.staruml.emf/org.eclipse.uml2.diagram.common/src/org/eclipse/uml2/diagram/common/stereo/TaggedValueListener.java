package org.eclipse.uml2.diagram.common.stereo;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public interface TaggedValueListener {

	public void taggedValueChanged(Element stereotypeOwner, Stereotype stereo, Property metaTaggedValue, Notification raw);

}
