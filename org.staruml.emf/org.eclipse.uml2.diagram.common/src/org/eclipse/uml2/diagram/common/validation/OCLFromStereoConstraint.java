package org.eclipse.uml2.diagram.common.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OCL.Helper;
import org.eclipse.uml2.diagram.common.constraint.ConstraintUtils;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

public class OCLFromStereoConstraint extends AbstractModelConstraint {

	final private OCL myOCL = org.eclipse.ocl.uml.OCL.newInstance();

	@Override
	public IStatus validate(IValidationContext ctx) {
		Element selected = (Element) ctx.getTarget();
		Helper oclHelper = myOCL.createOCLHelper();
		for (Stereotype stereo : selected.getApplicableStereotypes()) {
			oclHelper.setContext(stereo);
			for (Constraint c : getConstraints(stereo)) {
				try {
					boolean success = runConstraintOn(oclHelper, selected, c);
					if (!success) {
						String name = (selected instanceof NamedElement)? ((NamedElement)selected).getName(): StringStatics.BLANK;
						return ctx.createFailureStatus(name, stereo.getName(), c.getName());
					}
				} catch (ParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	private boolean runConstraintOn(Helper oclHelper, Element selected, Constraint umlConstraint) throws ParserException {
		String body = ConstraintUtils.getOCLConstraintBody(umlConstraint);
		if (body == null) {
			return true;
		}
		Constraint constraint = oclHelper.createInvariant(body);
		return myOCL.check(selected, constraint);
	}

	private static final List<Constraint> getConstraints(EObject stereotype) {
		LinkedList<Constraint> result = new LinkedList<Constraint>();
		for (EObject next : getReferencingObjects(stereotype)) {
			if (isConstraintFor(next, stereotype)) {
				result.add((Constraint) next);
			}
		}
		return result;
	}

	private static boolean isConstraintFor(EObject constraint, EObject constrainedElement) {
		return constraint instanceof Constraint && ((Constraint) constraint).getConstrainedElements().contains(constrainedElement);
	}

	private static final List<EObject> getReferencingObjects(EObject target) {
		LinkedList<EObject> result = new LinkedList<EObject>();
		Collection<EStructuralFeature.Setting> settings = CrossReferencer.find(target.eResource().getContents()).get(target);
		if (settings == null) {
			return Collections.emptyList();
		}
		for (Setting setting : settings) {
			result.add(setting.getEObject());
		}
		return result;
	}

}
