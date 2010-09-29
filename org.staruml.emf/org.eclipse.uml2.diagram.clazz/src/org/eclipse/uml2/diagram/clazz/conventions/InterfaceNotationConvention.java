package org.eclipse.uml2.diagram.clazz.conventions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;


public class InterfaceNotationConvention {
	
	public static boolean needsAlternativeNotation(ConnectionEditPart editPart) {
		Edge edge = (Edge)editPart.getModel();
		return isAlternativeNotation(edge.getSource()) || isAlternativeNotation(edge.getTarget());
	}
	
	public static boolean isAlternativeNotation(View view) {
		return Interface2EditPart.VISUAL_ID == UMLVisualIDRegistry.getVisualID(view);
	}
	
	public static boolean hasAlternativeNotation(View view) {
		int VID = UMLVisualIDRegistry.getVisualID(view);
		return Interface2EditPart.VISUAL_ID == VID || InterfaceEditPart.VISUAL_ID == VID;
	}
}
