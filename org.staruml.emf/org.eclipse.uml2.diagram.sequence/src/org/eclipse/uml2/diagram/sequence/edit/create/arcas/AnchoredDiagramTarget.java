package org.eclipse.uml2.diagram.sequence.edit.create.arcas;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

public class AnchoredDiagramTarget {

	private GraphicalEditPart myContainer;

	private GraphicalEditPart myAnchor;

	private boolean myIsBeforeAnchor = false;

	public AnchoredDiagramTarget(GraphicalEditPart container, GraphicalEditPart anchor, boolean before) {
		if (container == null) {
			throw new IllegalArgumentException("container mustn't be null."); //$NON-NLS-1$
		}
		myContainer = container;
		myAnchor = anchor;
		myIsBeforeAnchor = before;
	}

	public AnchoredDiagramTarget(GraphicalEditPart container) {
		this(container, null, true);
	}

	public AnchoredDiagramTarget(GraphicalEditPart container, Request request) {
		myContainer = container;
		myAnchor = AnchorUtil.getAnchor(request);
		myIsBeforeAnchor = AnchorUtil.isBeforeAnchor(request);
	}

	public GraphicalEditPart getContainer() {
		return myContainer;
	}

	public GraphicalEditPart getAnchor() {
		return myAnchor;
	}
	
	public EObject getSemanticContainer(){
		return myContainer.resolveSemanticElement();
	}
	
	public EObject getSemanticAnchor(){
		return myAnchor == null ? null : myAnchor.resolveSemanticElement();
	}

	public boolean isBeforeAnchor() {
		return myIsBeforeAnchor;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AnchoredDiagramTarget))
			return false;
		AnchoredDiagramTarget target = (AnchoredDiagramTarget) o;
		if (myAnchor == null && target.myAnchor != null)
			return false;
		if (myAnchor != null && !myAnchor.equals(target.myAnchor))
			return false;
		if (myAnchor != null && myIsBeforeAnchor != target.myIsBeforeAnchor)
			return false;
		if (myContainer == null && target.myContainer != null)
			return false;
		if (myContainer != null && !myContainer.equals(target.myContainer))
			return false;
		return true;
	}

	public int hashCode() {
		return hash(myContainer) + hash(myAnchor) + (myIsBeforeAnchor ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode());
	}
	
	public boolean checkSemantic(){
		EObject semanticContainer = myContainer.resolveSemanticElement();
		if (semanticContainer == null){
			return false;
		}
		if (myAnchor != null){
			EObject semanticAnchor = myAnchor.resolveSemanticElement();
			if (semanticAnchor == null){
				return false;
			}
			if (!EcoreUtil.isAncestor(semanticContainer, semanticAnchor)){
				return false;
			}
		}
		return true;
	}

	private static int hash(Object o) {
		return (o == null) ? 0 : o.hashCode();
	}

	public static AnchoredDiagramTarget createTarget(EditPart part, Request request) {
		if (part instanceof GraphicalEditPart) {
			return new AnchoredDiagramTarget((GraphicalEditPart) part, request);
		}
		return null;
	}

}
