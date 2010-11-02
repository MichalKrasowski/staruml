package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;


public class PartialRectangleFigure extends RectangleFigure {
	private boolean myIsTopShown = true;
	private boolean myIsBottomShown = true;
	private boolean myIsLeftShown = true;
	private boolean myIsRightShown = true;
	
	public PartialRectangleFigure(){
		setLineWidth(1);
		setOutline(true);
		setFill(true);
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		int lineInset = (int)Math.ceil(Math.max(1.0, getLineWidthFloat() / 2.0));
		Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
		r.x += lineInset - 1; 
		r.y += lineInset - 1; 
		r.width -= (lineInset + lineInset) - 1;
		r.height -= (lineInset + lineInset) - 1;
		if (myIsBottomShown && myIsLeftShown && myIsRightShown && myIsTopShown){
			graphics.drawRectangle(r);
			return;
		}
		
		int left = r.x;
		int right = r.x + r.width;
		int top = r.y;
		int bottom = r.y + r.height;
		
		if (myIsTopShown){
			graphics.drawLine(left, top, right, top);
		}
		if (myIsBottomShown){
			graphics.drawLine(left, bottom, right, bottom);
		}
		if (myIsLeftShown){
			graphics.drawLine(left, top, left, bottom);
		}
		if (myIsRightShown){
			graphics.drawLine(right, top, right, bottom);
		}
	}
	
	public void setLeftShown(boolean isLeftShown) {
		if (myIsLeftShown != isLeftShown){
			myIsLeftShown = isLeftShown;
			repaint();
		}
	}
	
	public void setRightShown(boolean isRightShown) {
		if (myIsRightShown != isRightShown){
			myIsRightShown = isRightShown;
			repaint();
		}
	}
	
	public void setTopShown(boolean isTopShown) {
		if (myIsTopShown != isTopShown){
			myIsTopShown = isTopShown;
			repaint();
		}
	}
	
	public void setBottomShown(boolean isBottomShown) {
		if (myIsBottomShown != isBottomShown){
			myIsBottomShown = isBottomShown;
			repaint();
		}
	}
	
}
