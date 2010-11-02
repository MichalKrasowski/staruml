package org.eclipse.uml2.diagram.common.constraint;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.ValueSpecification;


public class ConstraintUtils {
	
	private static final String OCL_LANGUAGE = "OCL"; //$NON-NLS-1$

	public static String getOCLConstraintBody(Constraint umlConstraint) {
		ValueSpecification s = umlConstraint.getSpecification();
		if (s != null && s instanceof OpaqueExpression) {
			return getOCLBodyFromOpaqueExpression((OpaqueExpression)s);
		}
		return null;
	}

	public static void setOCLConstraintBody(Constraint umlConstraint, String body) {
		ValueSpecification s = umlConstraint.getSpecification();
		if (s != null && s instanceof OpaqueExpression) {
			setOCLBodyToOpaqueExpression((OpaqueExpression)s, body);
		}
	}

	public static String getOCLBodyFromOpaqueExpression(OpaqueExpression e) {
		if (isOCLOpaqueExpression(e)) {
			EList<String> bodies = e.getBodies();
			return bodies.isEmpty() ? null : bodies.get(0);
		}
		return null;
	}

	public static void setOCLBodyToOpaqueExpression(OpaqueExpression e, String body) {
		if (isOCLOpaqueExpression(e)) {
			EList<String> bodies = e.getBodies();
			if (bodies.isEmpty()) {
				bodies.add(body);
			} else {
				bodies.set(0, body);
			}
		}
	}

	public static boolean isOCLOpaqueExpression(OpaqueExpression e) {
		EList<String> lans = e.getLanguages();
		return !lans.isEmpty() && OCL_LANGUAGE.equals(lans.get(0));
	}

}
