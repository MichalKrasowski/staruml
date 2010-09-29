package org.eclipse.uml2.diagram.sequence.edit.create.arcas;

import org.eclipse.emf.ecore.EObject;


class SemanticTarget {
	private final EObject myContainer;
	private final EObject myAnchor;
	private final boolean myAfterAnchor;

	public SemanticTarget(EObject container, EObject anchor, boolean afterAnchor){
		myContainer = container;
		myAnchor = anchor;
		myAfterAnchor = afterAnchor;
	}
	
	public EObject getSemanticContainer(){
		return myContainer;
	}
	
	public EObject getSemanticAnchor(){
		return myAnchor;
	}
	
	public boolean isBeforeAnchor(){
		return !myAfterAnchor;
	}
	
	public boolean isAfterAnchor() {
		return myAfterAnchor;
	}

}
