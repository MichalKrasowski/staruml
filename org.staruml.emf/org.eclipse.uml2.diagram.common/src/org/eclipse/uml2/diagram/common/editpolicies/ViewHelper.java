package org.eclipse.uml2.diagram.common.editpolicies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;


public class ViewHelper {
	private final IVisualIDRegistry myVisualIDRegistry;

	public ViewHelper(IVisualIDRegistry visualIDRegistry){
		myVisualIDRegistry = visualIDRegistry;
	}
	
	public View findChildByType(View view, int visualId) {
		return findByTypeAndElement(view.getChildren(), visualId, null);
	}
	
	public View findChildByType(View view, int visualId, EObject semantic) {
		return findByTypeAndElement(view.getChildren(), visualId, semantic);
	}

	public Edge findOutgoingEdge(Node source, int visualId, EObject semantic){
		return (Edge)findByTypeAndElement(source.getSourceEdges(), visualId, semantic);
	}
	
	public Edge findIncomingEdge(Node source, int visualId, EObject semantic){
		return (Edge)findByTypeAndElement(source.getTargetEdges(), visualId, semantic);
	}
	
	protected View findByTypeAndElement(List<?> views, int visualId, EObject semantic){
		for (Object next : views){
			if (next instanceof View){
				View nextView = (View)next;
				if (myVisualIDRegistry.getVisualID(nextView) != visualId) {
					continue;
				}
				if (semantic == null || semantic.equals(nextView.getElement())){
					return nextView;
				}
			}
		}
		return null;
	}

}
