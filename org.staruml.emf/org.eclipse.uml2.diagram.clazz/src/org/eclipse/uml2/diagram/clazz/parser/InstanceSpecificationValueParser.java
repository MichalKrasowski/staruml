package org.eclipse.uml2.diagram.clazz.parser;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class InstanceSpecificationValueParser extends ValueSpecificationParser {

	@Override
	public boolean isAffectingEvent(Object notification, int flags) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			return UMLPackage.eINSTANCE.getInstanceSpecification_Specification().equals(feature) || super.isAffectingEvent(notification, flags);
		}
		return false;
	}

	@Override
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		if (false == element instanceof InstanceSpecification) {
			return Collections.emptyList();
		}
		ValueSpecification spec = ((InstanceSpecification) element).getSpecification();
		return spec == null ? Collections.emptyList() : Collections.singletonList(spec);
	}

	@Override
	protected ValueSpecification getValueSpecification(IAdaptable adaptable) {
		InstanceSpecification is = (InstanceSpecification) adaptable.getAdapter(EObject.class); 
		return is.getSpecification();
	}

}
