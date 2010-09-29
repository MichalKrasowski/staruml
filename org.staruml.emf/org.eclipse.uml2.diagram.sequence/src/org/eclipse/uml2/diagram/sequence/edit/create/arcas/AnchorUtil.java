package org.eclipse.uml2.diagram.sequence.edit.create.arcas;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

class AnchorUtil {

	public static final String REQUEST_KEY_ANCHOR = AnchorUtil.class.getCanonicalName() + ".anchor";
	public static final String REQUEST_KEY_IS_BEFORE_ANCHOR = AnchorUtil.class.getCanonicalName() + ".isBeforeAnchor";

	public static GraphicalEditPart getAnchor(Request request) {
		return (GraphicalEditPart) request.getExtendedData().get(REQUEST_KEY_ANCHOR);
	}

	/**
	 * @return <code>true</code> if editpart should be placed before anchor; <code>false</code> otherwise.
	 */
	public static boolean isBeforeAnchor(Request request) {
		Boolean b = (Boolean) request.getExtendedData().get(REQUEST_KEY_IS_BEFORE_ANCHOR);
		return b == null ? false : b.booleanValue();
	}
	
	
}
