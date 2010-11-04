package org.eclipse.uml2.diagram.profile.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.notation.View;

public class UmlDiagramEditPart extends DiagramEditPart{

	public UmlDiagramEditPart(View diagramView) {
		super(diagramView);
	}
	protected IFigure createFigure() {
		return new DiagramEditPartFigure();
	}
	protected class DiagramEditPartFigure extends BorderItemsAwareFreeFormLayer {
		public DiagramEditPartFigure() {
			setLayoutManager(new FreeformLayout());
			addLayoutListener(LayoutAnimator.getDefault());
			addLayoutListener(new PageBreaksLayoutListener());
			setBorder(new MarginBorder(20));
		}
		public boolean containsPoint(int x, int y) {
			return getBounds().contains(x, y);
		}
		public IFigure findFigureAt(int x, int y, TreeSearch search) {
			if (!isEnabled())
				return null;
			if (!containsPoint(x, y))
				return null;
			if (search.prune(this))
				return null;
			IFigure child = findDescendantAtExcluding(x, y, search);
			if (child != null)
				return child;
			if (search.accept(this))
				return this;
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.draw2d.Figure#validate()
		 */
		public void validate() {				
			super.validate();
			boolean shouldUpdatePageBreakLocation=false;
			if (shouldUpdatePageBreakLocation){
				shouldUpdatePageBreakLocation = false;
				updatePageBreaksLocation();
			}
		}
		@Override
		public void paint(Graphics graphics) {
    		super.paint(graphics);
    		graphics.pushState();
    		graphics.setLineStyle(3);
    		graphics.setForegroundColor(ColorConstants.red);
    		graphics.setBackgroundColor(ColorConstants.blue);
    		Rectangle bounds = getBounds();
    		graphics.drawRectangle(bounds.x+3, bounds.y+3, bounds.width - 4, bounds.height - 4);
    		graphics.popState();
		}
		
	}
	/**
	 * @author mmostafa
	 * PageBreaksLayoutListener Listens to post layout so it can update the page breaks  
	 */
	private class PageBreaksLayoutListener extends LayoutListener.Stub {

		public void postLayout(IFigure container) {
			super.postLayout(container);
			updatePageBreaksLocation();
		}
		
		
	}
}
