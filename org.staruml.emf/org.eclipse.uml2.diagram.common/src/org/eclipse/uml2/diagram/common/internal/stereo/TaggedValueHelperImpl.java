package org.eclipse.uml2.diagram.common.internal.stereo;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.common.stereo.TaggedValueHelper;
import org.eclipse.uml2.diagram.common.stereo.TaggedValueListener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public class TaggedValueHelperImpl implements TaggedValueHelper {

		private final Element myExistingStereotypedElement;

		private final EObject myRawReference;

		private final Stereotype myStereo;

		public TaggedValueHelperImpl(Element existingStereotypedElement, Stereotype stereo) {
			myExistingStereotypedElement = existingStereotypedElement;
			myStereo = stereo;
			myRawReference = existingStereotypedElement.getStereotypeApplication(stereo);
		}

		public void addTaggedValueListener(TaggedValueListener listener) {
			myRawReference.eAdapters().add(new StereotypeApplicationTaggedValueAdapter(listener));
		}

		public void removeTaggedValueListener(TaggedValueListener l) {
			StereotypeApplicationTaggedValueAdapter forListener = null;
			for (Adapter next : myRawReference.eAdapters()) {
				if (next instanceof StereotypeApplicationTaggedValueAdapter && ((StereotypeApplicationTaggedValueAdapter) next).isForListener(l)) {
					forListener = (StereotypeApplicationTaggedValueAdapter) next;
					break;
				}
			}
			if (forListener != null) {
				myRawReference.eAdapters().remove(forListener);
			}
		}

		public Stereotype getStereotype() {
			return myStereo;
		}

		public Element getStereotypeOwner() {
			return myExistingStereotypedElement;
		}

		public boolean isAlive() {
			return myRawReference != null;
		}

	};
