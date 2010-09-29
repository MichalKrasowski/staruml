package org.eclipse.uml2.diagram.sequence.edit.policies;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;


public class InteractionNestedLayoutRequest extends Request {
	public static final String REQ_TYPE = InteractionNestedLayoutRequest.class.getCanonicalName();
	private final List<IAdaptable> myViewAdapters = new LinkedList<IAdaptable>();
	private final List<IGraphicalEditPart> myReshapedElements = new LinkedList<IGraphicalEditPart>();
	private int mySessionsCount = 1;
	private boolean myTotalLayout;
	
	public InteractionNestedLayoutRequest(){
		setType(REQ_TYPE);
	}
	
	public void requestTotalLayout(){
		myTotalLayout = true;
	}
	
	public boolean isTotalLayout(){
		return myTotalLayout;
	}
	
	public void addViewAdapters(Collection<?> adapters){
		for (Object next : adapters){
			addViewAdapter((IAdaptable)next);
		}
	}
	
	public void addReshapedElement(IGraphicalEditPart ep){
		if (ep != null){
			myReshapedElements.add(ep);
		}
	}
	
	/*
	 * [U2T]
	 */
	public void setRepeatSessionsCount(int count){
		mySessionsCount = count;
	}
	
	public int getSessionsCount() {
		return mySessionsCount;
	}
	
	public void addViewAdapter(IAdaptable adapter){
		myViewAdapters.add(adapter);
	}
	
	public Iterable<IAdaptable> getViewAdapters(){
		return myViewAdapters;
	}
	
	public Iterable<IGraphicalEditPart> getReshapedElements(){
		return myReshapedElements;
	}
	
	
}
