package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;


public class PackageFrameFigure extends RectangleFigure {
	private final Pentagon myPentagon;
	private final RectangleFigure myContentPane;
	private final Label myKindLabel;
	private final Label myNameLabel;
	private final ToolbarLayout myContentsLayout;

	public PackageFrameFigure(){
		setLineWidth(1);
		setOutline(true);
		setFill(true);
		
		setLayoutManager(new DontStretchTopBorderLayout());
		
		myPentagon = new Pentagon();
		myContentPane = new RectangleFigure();
		myContentPane.setOutline(false);
		myContentPane.setFill(false);
		myContentPane.setOpaque(false);
		myContentPane.setLayoutManager(new StackLayout());
		
		IFigure pentagonContents = new Figure();
		myContentsLayout = new ToolbarLayout();
		myContentsLayout.setStretchMinorAxis(true);
		myContentsLayout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		myContentsLayout.setSpacing(10);
		myContentsLayout.setVertical(false);
		
		pentagonContents.setLayoutManager(myContentsLayout);
		
		myKindLabel = new Label();
		myNameLabel = new Label();
		
		pentagonContents.add(myKindLabel);
		pentagonContents.add(myNameLabel);
		myPentagon.setContent(pentagonContents);
		
		this.add(myPentagon, BorderLayout.TOP);
		this.add(myContentPane, BorderLayout.CENTER);
	}
	
	public void setKindLabelText(String text){
		getKindLabel().setText(text == null ? StringStatics.BLANK : text);
	}
	
	public void setKindLabelVisible(boolean visible){
		myKindLabel.setVisible(visible);
	}
	
	public void setLabelsSpacing(int spacing){
		if (myContentsLayout.getSpacing() != spacing){
			myContentsLayout.setSpacing(spacing);
			revalidate();
		}
	}
	
	public Label getKindLabel() {
		return myKindLabel;
	}
	
	public RectangleFigure getContentPane(){
		return myContentPane;
	}
	
	public Label getNameLabel() {
		return myNameLabel;
	}
	
	private static class Pentagon extends Shape {
	    public static final int BIT_SIZE = 5;

	    public Pentagon () {
	    	setLineWidth(1);
	        setLayoutManager(new FillingBorderLayout());
	    }
	    
	    protected void fillShape(Graphics graphics) {
	        graphics.fillPolygon(getPoints(getOutlineBounds(this).shrink(1, 1)));
	    }

	    protected void outlineShape(Graphics graphics) {
	        graphics.drawPolyline(getPoints(getOutlineBounds(this)));
	    }

	    public void setContent(IFigure content) {
	        content.setBorder(new MarginBorder(0, BIT_SIZE, 2, BIT_SIZE));
	        add(content, FillingBorderLayout.CENTER);
	    }
	    
	    protected PointList getPoints(Rectangle rect) {           
	        PointList points = new PointList(6);
	        
	        points.addPoint(rect.x, rect.y);
	        points.addPoint(rect.x + rect.width, rect.y);
	        if (BIT_SIZE > rect.height || BIT_SIZE > rect.width) {
	            points.addPoint(rect.x + rect.width, rect.y + rect.height);
	            //assert false;
	        } else {
	            points.addPoint(rect.x + rect.width, rect.y + rect.height - BIT_SIZE);
	            points.addPoint(rect.x + rect.width - BIT_SIZE, rect.y + rect.height);
	        }
	        points.addPoint(rect.x, rect.y + rect.height);
	        return points;
	    }
	    
		private static Rectangle getOutlineBounds(Shape shape) {
			Rectangle b = new Rectangle(shape.getBounds());
			final int lineWidth = shape.getLineWidth();
			final int lineOffset = lineWidth / 2;
			b.x += lineOffset;
			b.y += lineOffset;
			b.width -= lineWidth;
			b.height -= lineWidth;
			return b;
		}
	}
	
	private static class DontStretchTopBorderLayout extends BorderLayout {
		private IFigure myTop;
		
		@Override
		public void setConstraint(IFigure child, Object constraint) {
			super.setConstraint(child, constraint);
			if (constraint instanceof Number && ((Number)constraint).intValue() == PositionConstants.TOP){
				myTop = child;
			}
		}
		
		@Override
		public void remove(IFigure child) {
			super.remove(child);
			if (child == myTop){
				myTop = null;
			}
		}
		
		@Override
		public void layout(IFigure container) {
			super.layout(container);
			if (myTop != null && myTop.isVisible()) {
				Dimension childSize = myTop.getPreferredSize(container.getClientArea().width, -1);
				myTop.getBounds().width = Math.min(childSize.width, myTop.getBounds().width);
			}
		}
	}
	

}
