package org.eclipse.uml2.diagram.common.internal.stereo;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.diagram.common.stereo.TaggedValueListener;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

public class StereotypeApplicationTaggedValueAdapter extends AdapterImpl {

	private final TaggedValueListener myListener;

	public StereotypeApplicationTaggedValueAdapter(TaggedValueListener listener) {
		myListener = listener;
	}

	public boolean isForListener(TaggedValueListener that) {
		return myListener == that;
	}

	@Override
	public void notifyChanged(Notification notification) {
		System.out.println(notification);
		if (Notification.SET == notification.getEventType() && notification.getFeature() instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
			EObject stereotypeApplication = (EObject) getTarget();
			Stereotype stereo = UMLUtil.getStereotype(stereotypeApplication);
			Property originalProperty = findOriginalProperty(stereo, feature);
			myListener.taggedValueChanged(UMLUtil.getBaseElement(stereotypeApplication), stereo, originalProperty, notification);
		}
		if ((Notification.ADD == notification.getEventType() || Notification.ADD_MANY == notification.getEventType()) && notification.getFeature() instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
			EObject stereotypeApplication = (EObject) getTarget();
			Stereotype stereo = UMLUtil.getStereotype(stereotypeApplication);
			Property originalProperty = findOriginalProperty(stereo, feature);
			myListener.taggedValueChanged(UMLUtil.getBaseElement(stereotypeApplication), stereo, originalProperty, notification);
		}
		if ((Notification.REMOVE == notification.getEventType()) && notification.getFeature() instanceof EStructuralFeature) {
			// Notification.REMOVE_MANY is called on any property change
			EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
			EObject stereotypeApplication = (EObject) getTarget();
			Stereotype stereo = UMLUtil.getStereotype(stereotypeApplication);
			Property originalProperty = findOriginalProperty(stereo, feature);
			myListener.taggedValueChanged(UMLUtil.getBaseElement(stereotypeApplication), stereo, originalProperty, notification);
		}
	}

	private Property findOriginalProperty(Stereotype stereo, EStructuralFeature feature) {
		for (Property p : stereo.getAllAttributes()) {
			if (feature.getName().equals(p.getName())) {
				return p;
			}
		}
		return null;
	}

}
