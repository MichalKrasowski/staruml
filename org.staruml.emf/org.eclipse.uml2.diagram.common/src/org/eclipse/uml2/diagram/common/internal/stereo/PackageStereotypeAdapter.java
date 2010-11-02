package org.eclipse.uml2.diagram.common.internal.stereo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.diagram.common.stereo.StereotypeListener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

public class PackageStereotypeAdapter extends AdapterImpl {

	private final StereotypeListener myListener;

	public PackageStereotypeAdapter(StereotypeListener listener) {
		myListener = listener;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		if (newTarget == null) {
			for (EObject application : getStereotypeApplications(getTarget())) {
				disconnectFromStereotypeApplication(application);
			}
		}
		if (newTarget != null) {
			for (EObject application : getStereotypeApplications(newTarget)) {
				connectToStereotypeApplication(application);
			}
		}
		super.setTarget(newTarget);
	}

	private List<EObject> getStereotypeApplications(Object target) {
		if (target instanceof Resource) {
			Package pakkage = getPackage((Resource)target);
			Resource resource = (Resource) target;
			List<EObject> result = new LinkedList<EObject>();
			for (EObject o: resource.getContents()) {
				if (isStereotypeApplication(pakkage, o)) {
					result.add(o);
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	public boolean isForListener(StereotypeListener that) {
		return myListener == that;
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (Notification.ADD == notification.getEventType()) {
			Object newValue = notification.getNewValue();
			if (newValue != null && newValue instanceof EObject) {
				EObject application = (EObject) newValue;
				if (isStereotypeApplication(application)) {
					connectToStereotypeApplication(application);
				}
			}
		}
		if (Notification.REMOVE == notification.getEventType()) {
			Object oldValue = notification.getOldValue();
			if (oldValue != null && oldValue instanceof EObject) {
				EObject application = (EObject) oldValue;
				if (isStereotypeApplication(application)) {
					disconnectFromStereotypeApplication(application);
				}
			}
		}
	}

	private boolean isStereotypeApplication(EObject application) {
		org.eclipse.uml2.uml.Package pakkage = getPackage((Resource)getTarget());
		return isStereotypeApplication(pakkage, application);
	}
	private Package getPackage(Resource resource) {
		return (Package) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
	}

	private boolean isStereotypeApplication(Package pakkage, EObject application) {
		EList<Profile> profiles = pakkage.getAllAppliedProfiles();
		EPackage ePackage = application.eClass().getEPackage();
		return profiles.contains(UMLUtil.getProfile(ePackage));
	}

	private void connectToStereotypeApplication(EObject newEObject) {
		newEObject.eAdapters().add(new StereotypeApplicationAdapter(myListener));
	}

	private void disconnectFromStereotypeApplication(EObject newEObject) {
		StereotypeApplicationAdapter forListener = null;
		for (Adapter next : newEObject.eAdapters()) {
			if (next instanceof StereotypeApplicationAdapter && ((StereotypeApplicationAdapter) next).isForListener(myListener)) {
				forListener = (StereotypeApplicationAdapter) next;
				break;
			}
		}
		if (forListener != null) {
			newEObject.eAdapters().remove(forListener);
		}
	}

	private static class StereotypeApplicationAdapter extends AdapterImpl {

		private final StereotypeListener myListener;

		public StereotypeApplicationAdapter(StereotypeListener listener) {
			myListener = listener;
		}

		public boolean isForListener(StereotypeListener that) {
			return myListener == that;
		}

		@Override
		public void notifyChanged(Notification notification) {
			if (Notification.SET == notification.getEventType() && notification.getFeature() instanceof EStructuralFeature) {
				EStructuralFeature feature = ((EStructuralFeature) notification.getFeature());
				if (feature.getName() != null && feature.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
					EObject application = (EObject) getTarget();
					Object newValue = notification.getNewValue();
					if (newValue != null && newValue instanceof Element) {
						myListener.stereotypeApplied((Element) newValue, UMLUtil.getStereotype(application), application);
					}
					Object oldValue = notification.getOldValue();
					if (oldValue != null) {
						myListener.stereotypeUnapplied((Element) oldValue, UMLUtil.getStereotype(application));
					}
				}
			}
		}
	}

}
