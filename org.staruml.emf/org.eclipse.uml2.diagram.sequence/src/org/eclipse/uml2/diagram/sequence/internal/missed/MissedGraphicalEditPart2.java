package org.eclipse.uml2.diagram.sequence.internal.missed;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethodsImpl.MissedGraphicalEditPartImpl;



public class MissedGraphicalEditPart2 extends MissedGraphicalEditPartImpl {
	private boolean myLogSetBounds = false;
	private boolean myLogGetBounds = false;
	
	public void setLogGetBounds(boolean debugGetBounds) {
		myLogGetBounds = debugGetBounds;
	}
	
	public void setLogSetBounds(boolean debugSetBounds) {
		myLogSetBounds = debugSetBounds;
	}
	
	public Rectangle getBounds(IGraphicalEditPart nodeEP) {
		Rectangle notationModelResult = new Rectangle();
		Node view = (Node) nodeEP.getNotationView();
		LayoutConstraint constraint = view.getLayoutConstraint();
		if (constraint instanceof Location){
			notationModelResult.x = ((Location)constraint).getX();
			notationModelResult.y = ((Location)constraint).getY();
		}
		if (constraint instanceof Size){
			notationModelResult.height = ((Size)constraint).getHeight();
			notationModelResult.width = ((Size)constraint).getWidth();
		}
		
//		Rectangle absoluteResult = notationModelResult;
//		IFigure actualContainer = nodeEP.getFigure().getParent();
//		if (actualContainer.getLayoutManager() instanceof XYLayout){
//			XYLayout layout = (XYLayout)actualContainer.getLayoutManager();
//			Point origin = layout.getOrigin(actualContainer);
//			absoluteResult = notationModelResult.getTranslated(origin);
//		}
		
		Point origin = collectParentOrigin(view, new Point(0, 0));
		
//		Rectangle figureResult = nodeEP.getFigure().getBounds().getCopy();
//		System.err.println("<<<GetBounds: " + nodeEP.toString() + ":" + absoluteResult);
//		if (!absoluteResult.equals(figureResult)){
//			System.err.println("<<<     \t\t (figure bounds:) " + nodeEP.toString() + ":" + figureResult);
//		}

		Rectangle absoluteResult = notationModelResult.getTranslated(origin);
		if (nodeEP instanceof BehaviorExecutionSpecificationEditPart){
			logGetBounds("<<<MissedGraphicalEditPartImpl.getBounds(): for : nodeEP: " + nodeEP);
			logGetBounds("---- notation : = " + notationModelResult);
			logGetBounds("---- Origin: " + origin);
			logGetBounds("---- Result: " + absoluteResult);
		} 

		return absoluteResult;
	}
	
	private static Point collectParentOrigin(View view, Point output){
		if (false == view.eContainer() instanceof Node){
			return output;
		}
		Node parent = (Node) view.eContainer();
		if (parent instanceof Diagram){
			return output;
		}
		LayoutConstraint constraint = parent.getLayoutConstraint();
		if (constraint instanceof Location){
			Location location = (Location)constraint;
			output.translate(location.getX(), location.getY());
		}
		return collectParentOrigin(parent, output);
	}
	
	public void setBounds(IGraphicalEditPart nodeEP, Rectangle bounds) {
		if (nodeEP instanceof BehaviorExecutionSpecificationEditPart){
			logSetBounds(">>>SetBounds(): for : " + nodeEP + ",\n\t bounds: " + bounds);	
		}
		if (nodeEP.getParent() == null) {
			return;
		}
		if (bounds == null) {
			bounds = new Rectangle(0, 0, -1, -1);
		}
		
		Point origin = collectParentOrigin(nodeEP.getNotationView(), new Point(0, 0));
		Rectangle local = bounds.getTranslated(origin.getNegated());
		if (nodeEP instanceof BehaviorExecutionSpecificationEditPart){
			logSetBounds(">>>     origin: " + origin);
			logSetBounds(">>>     local result: " + local);
		}
		
		Node view = (Node) nodeEP.getNotationView();
		LayoutConstraint constraint = view.getLayoutConstraint();
		if (constraint instanceof Location){
			Location location = (Location)constraint;
			if (location.getX() != local.x){
				location.setX(local.x);	
			}
			if (location.getY() != local.y){
				location.setY(local.y);	
			}
		}
		if (constraint instanceof Size){
			Size size = (Size)constraint;
			if (size.getHeight() != local.height){
				size.setHeight(local.height);
			}
			if (size.getWidth() != local.width){
				size.setWidth(local.width);
			}
		}
	}
	
	private void logSetBounds(String text){
		if (myLogSetBounds){
			System.err.println(text);
		}
	}

	private void logGetBounds(String text){
		if (myLogGetBounds){
			System.err.println(text);
		}
	}

}
