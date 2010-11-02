package org.eclipse.uml2.diagram.common.async;

import org.eclipse.gef.requests.GroupRequest;

/**
 * This requests is expected to work on semi-synchronized diagrams only.
 * 
 * By default GMF allows target editpart to decide whether the notion 
 * should be deleted from semantic model or diagram only. 
 * 
 * We are extending this behavior by allowing caller to explicitly force one 
 * or another behavior based on request property.
 * 
 * If the container for element is actually in the canonical mode, and request has Kind.NOTATION_ONLY kind, 
 * canonical mode is expected to be switched off in order to allow the expected behavior.
 */
public class AsyncDiagramDeleteRequest extends GroupRequest {
	public static enum Kind {
		NOTATION_ONLY, 
		SEMANTIC_AND_NOTATION, 
		LET_TARGET_DECIDE, 
	}
	
	public static final String REQ_TYPE = AsyncDiagramDeleteRequest.class.getName() + ":delete"; //$NON-NLS-1$
	
	private Kind myKind = Kind.LET_TARGET_DECIDE;
	private boolean myFromKeyboard = false;
	
	public AsyncDiagramDeleteRequest(String type){
		super(type);
	}
	
	public AsyncDiagramDeleteRequest(){
		this(REQ_TYPE);
	}
	
	public Kind getKind() {
		return myKind;
	} 
	
	public void setKind(Kind kind) {
		myKind = kind;
		if (myKind == null){
			myKind = Kind.LET_TARGET_DECIDE;
		}
	}
	
	public boolean isFromKeyboard() {
		return myFromKeyboard;
	}
	
	public void setFromKeyboard(boolean fromKeyboard) {
		myFromKeyboard = fromKeyboard;
	}
	
}
