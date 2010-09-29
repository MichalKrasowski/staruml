package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

public interface OrderedLayoutEditPolicy {
	public AnchoredSibling findAnchoredSibling(Point relativeLocation);
	
	public final static class AnchoredSibling {
		private final View mySiblingView;
		private final boolean myBeforeNotAfterAnchor;
		
		public AnchoredSibling(View siblingView, boolean isBeforeNotAfterAnchor){
			mySiblingView = siblingView;
			myBeforeNotAfterAnchor = isBeforeNotAfterAnchor;
		}
		
		public View getSiblingView(){
			return mySiblingView;
		}
		
		public boolean isBeforeNotAfterAnchor(){
			return myBeforeNotAfterAnchor;
		}	
		
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder("[AnchoredSibling]: ");
			if (isBeforeNotAfterAnchor()){
				result.append("before: ");
			} else {
				result.append("after: ");
			}
			if (getSiblingView() != null){
				EObject entity = getSiblingView().getElement();
				result.append(String.valueOf(entity));
				result.append(", ");
			} 
			result.append("View: ").append(getSiblingView());
			return result.toString();
		}
	}
}
