package org.eclipse.uml2.diagram.common.stereo;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.diagram.common.internal.stereo.PackageStereotypeAdapter;
import org.eclipse.uml2.diagram.common.internal.stereo.TaggedValueHelperImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeUtil {

	public static void addStereotypeListener(org.eclipse.uml2.uml.Package umlPackage, StereotypeListener l) {
		addStereotypeListener(umlPackage.eResource(), l);
	}

	public static void addStereotypeListener(Diagram gmfDiagram, StereotypeListener l) {
		EObject umlElement = gmfDiagram.getElement();
		addStereotypeListener(umlElement.eResource(), l);
	}

	public static void addStereotypeListener(Resource semanticResource, StereotypeListener l) {
			PackageStereotypeAdapter real = new PackageStereotypeAdapter(l);
			semanticResource.eAdapters().add(real);
	}

	public static boolean removeStereotypeListener(Resource resource, StereotypeListener l) {
		PackageStereotypeAdapter forListener = null;
		for (Adapter next : resource.eAdapters()) {
			if (next instanceof PackageStereotypeAdapter && ((PackageStereotypeAdapter) next).isForListener(l)) {
				forListener = (PackageStereotypeAdapter) next;
				break;
			}
		}
		if (forListener != null) {
			resource.eAdapters().remove(forListener);
		}
		return forListener != null;
	}

	public static TaggedValueHelper createTaggedValueHelper(Element existingStereotypedElement, Stereotype stereo) {
		return new TaggedValueHelperImpl(existingStereotypedElement, stereo);
	}

}
