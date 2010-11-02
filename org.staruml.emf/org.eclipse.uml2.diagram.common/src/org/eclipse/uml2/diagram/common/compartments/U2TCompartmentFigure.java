package org.eclipse.uml2.diagram.common.compartments;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;


public class U2TCompartmentFigure extends ResizableCompartmentFigure {
	private CenteredLine myTextPane;
	/**
	 * XXX. we will set this flag immediately after super();
	 * This is because super() calls public method that we are going to override. 
	 */
	private boolean myTextPaneReplaced;
	private String myTitle;
	
	public U2TCompartmentFigure(String name, IMapMode mapMode){
		super(name, mapMode);
		
		ConstrainedToolbarLayout withStrecthMinorAxis = new ConstrainedToolbarLayout();
		withStrecthMinorAxis.setStretchMinorAxis(true);
        setLayoutManager(withStrecthMinorAxis);
		int oldTextPaneIndex = getChildren().indexOf(super.getTextPane());
		remove(super.getTextPane());

		myTextPane = new CenteredLine(this);
		myTextPaneReplaced = true;
		add(myTextPane, oldTextPaneIndex);
		
		setTitle(name);
		setBorder(new MarginBorder(0, 0, 0, 0)); //sic
	}
	
	public void setFont(Font f) {
		getTextPane().setFont(f);
	}
	
	public void setFontColor(Color c) {
		//getTextPane().setForegroundColor(c);
	}
	
	@Override
	public Figure getTextPane() {
		if (!myTextPaneReplaced){
			//HACK: this is called from super()
			//we would like to set our textPane instead 
			//but setTextPane() is final in super class
			return super.getTextPane();
		}
		return myTextPane;
	}
	
	@Override
	public void setSelected(boolean b) {
		//ignore, that gray borders are ugly
	}
	
	@Override
	public void setTitle(String title) {
		myTitle = title;
	}
	
	public String getTitleNotNull() {
		return myTitle == null ? StringStatics.BLANK : myTitle;
	}
	
	public Rectangle getTextPaneBounds(){
		return myTextPane.getBounds();
	}
	
	private static class CenteredLine extends Shape {
		private static final int DEFAULT_HEIGHT = 10;
		private final U2TCompartmentFigure myHost;
		private int myLineBorderGap = 0;
		private Label myTextMeasure;
		
		public CenteredLine(U2TCompartmentFigure host){
			myHost = host;
			myTextMeasure = new Label();
			setFill(true);
		}
		
		@Override
		public void setFont(Font f) {
			super.setFont(f);
		}
		
		@Override
        public Dimension getMaximumSize() {
            return new Dimension(Integer.MAX_VALUE, getPreferredSize().width);
        }
		
		@Override
		public Dimension getPreferredSize(int wHint, int hHint) {
			Dimension result = new Dimension(wHint, DEFAULT_HEIGHT);
			String title = myHost.getTitleNotNull();
			if (getFont() != null){
				myTextMeasure.setFont(getFont());
				myTextMeasure.setText(title);
				Dimension textSize = myTextMeasure.getPreferredSize(wHint, hHint);
				result.height = textSize.height;
				if (wHint == SWT.DEFAULT){
					result.width = textSize.width;
				}
			}
			return result; 
		}
		
		@Override
		public Dimension getMinimumSize(int wHint, int hHint) {
			Dimension result = new Dimension(-1, -1);
			String title = myHost.getTitleNotNull();
			if (getFont() != null){
				myTextMeasure.setFont(getFont());
				myTextMeasure.setText(title);
				Dimension textSize = myTextMeasure.getMinimumSize(wHint, hHint);
				result.setSize(textSize);
			}
			return result; 
		}
		
		@Override
		protected void outlineShape(Graphics graphics) {
			graphics.translate(getLocation());
			// draw big horizontal line
			graphics.setLineWidth(getLineWidth());
			graphics.setLineStyle(getLineStyle());
			Rectangle localBounds = getBounds();
			if (localBounds.width > 2 * myLineBorderGap) {
				final int lineY = localBounds.height / 2 - getLineWidth() / 2 + 1;
				graphics.drawLine(myLineBorderGap, lineY, localBounds.width - myLineBorderGap, lineY);
			}
		}
		
		@Override
		protected void fillShape(Graphics graphics) {
			//
		}
		
		public void setLineBorderGap(int lineBorderGap) {
			myLineBorderGap = lineBorderGap;
		}
	}
	
}
