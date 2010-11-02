package org.eclipse.uml2.diagram.common.parser.slot;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.diagram.parser.lookup.Lookup;
import org.eclipse.uml2.diagram.parser.lookup.LookupSuiteImpl;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;

public class SlotLookupSuite extends LookupSuiteImpl {

	public SlotLookupSuite() {
		addLookup(StructuralFeature.class, new StructuralFeatureLookup());
	}

	private static class StructuralFeatureLookup implements Lookup<StructuralFeature> {

		public List<IElementType> getResolutionElementTypes() {
			return Collections.<IElementType> emptyList();
		}

		public StructuralFeature lookup(String name, EObject context) {
			if (name == null || StringStatics.BLANK.equals(name)) {
				return null;
			}
			InstanceSpecification is = ((Slot) context).getOwningInstance();
			for (Classifier c : is.getClassifiers()) {
				for (Property attr : c.getAllAttributes()) {
					if (name.equals(attr.getName())) {
						return attr;
					}
				}
			}
			return null;
		}
	}
}
