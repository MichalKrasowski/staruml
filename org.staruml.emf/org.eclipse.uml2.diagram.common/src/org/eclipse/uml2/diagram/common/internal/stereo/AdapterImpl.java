package org.eclipse.uml2.diagram.common.internal.stereo;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class AdapterImpl implements Adapter {

	private Notifier myTarget = null;

	public Notifier getTarget() {
		return myTarget;
	}

	public void notifyChanged(Notification notification) {

	}

	public void setTarget(Notifier newTarget) {
		myTarget = newTarget;
	}

	public void unsetTarget(Notifier oldTarget) {
		if (myTarget == oldTarget) {
			setTarget(null);
		}
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

}
