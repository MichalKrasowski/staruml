package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

public class U2TCreateParametersImpl implements U2TCreateParameters {
	private Point myRelativeLocation;
	private View myParentView;
	private View myAnchorSibling;
	private boolean myIsBeforeAnchor;
	
	public Point getRelativeLocation() {
		return myRelativeLocation;
	}
	
	public void setRelativeLocation(Point relativeLocation) {
		myRelativeLocation = relativeLocation;
	}
	
	public View getAnchorSibling() {
		return myAnchorSibling;
	}
	
	public void setAnchorSibling(View anchorSibling) {
		myAnchorSibling = anchorSibling;
	}
	
	public boolean isBeforeNotAfterAnchor() {
		return myIsBeforeAnchor;
	}
	
	public void setBeforeNotAfterAnchor(boolean isBeforeAnchor) {
		myIsBeforeAnchor = isBeforeAnchor;
	}
	
	public View getParentView() {
		return myParentView;
	}
	
	public void setParentView(View parentView) {
		myParentView = parentView;
	}
	
	public static U2TCreateParametersImpl createFor(IGraphicalEditPart host, CreateRequest request){
		U2TCreateParametersImpl parameters = new U2TCreateParametersImpl(); 
		parameters.setParentView(host.getNotationView());
		
		if (request.getLocation() != null){
			IFigure hostContentPane = host.getContentPane();
			Point origin;
			if (hostContentPane.getLayoutManager() instanceof XYLayout){
				origin = ((XYLayout)hostContentPane.getLayoutManager()).getOrigin(hostContentPane);
			} else {
				origin = hostContentPane.getClientArea().getLocation();	
			}
			Point relativeLocation = new Point(request.getLocation());
			hostContentPane.translateToRelative(relativeLocation);
			relativeLocation.translate(origin.getNegated());
			parameters.setRelativeLocation(relativeLocation);
		}
		
		return parameters;
	}
}