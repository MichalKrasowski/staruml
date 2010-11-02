package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;


public class NameAndStereotypeBlock extends RectangleFigure {
	private StereotypeLabel2 myStereotypeLabel;
	private WrappingLabel myNameLabel; 
	
	public NameAndStereotypeBlock(){
		setLineWidthFloat(0f);
		setOutline(false);
		setFill(false);
		setLayoutManager(new TopBottomLayout());
		
		myStereotypeLabel = new StereotypeLabel2();
		
		myNameLabel = new WrappingLabel();
		myNameLabel.setAlignment(PositionConstants.CENTER);
		myNameLabel.setBackgroundColor(ColorConstants.yellow);
		
		this.add(myStereotypeLabel, BorderLayout.TOP);
		this.add(myNameLabel, BorderLayout.BOTTOM);
	}
	
	public StereotypeLabel2 getStereotypeLabel() {
		return myStereotypeLabel;
	}
	
	public WrappingLabel getNameLabel() {
		return myNameLabel;
	}
	
	@Override
	public String toString() {
		boolean stereoVisible = getStereotypeLabel().isVisible();
		return "Stereo:" + getStereotypeLabel().getText() + ", [" + stereoVisible + "], Name: " + getNameLabel().getText();   //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public void setNameTextWrap(boolean nameTextWrap) {
		myNameLabel.setTextWrap(nameTextWrap);
	}
	
	/**
	 * Basically it is BorderLayout with 
	 * a) only TOP/BOTTOM children and 
	 * b) tweaked extraction of minimum size, which knows that stereotype label 
	 * may never be hidden during inplace 
	 */
	private static class TopBottomLayout extends AbstractHintLayout { 
		private IFigure top, bottom;
		private int vGap = 5; 
		private int hGap = 0;

		@Override
		protected Dimension calculateMinimumSize(IFigure container, int wHint, int hHint) {
			int minWHint = 0, minHHint = 0;
			if (wHint < 0) {
				minWHint = -1;
			}
			if (hHint < 0) {
				minHHint = -1;
			}
			Insets border = container.getInsets();
			wHint = Math.max(minWHint, wHint - border.getWidth());
			hHint = Math.max(minHHint, hHint - border.getHeight());
			Dimension minSize = new Dimension();
			int middleRowWidth = 0, middleRowHeight = 0;
			int rows = 0, columns = 0;

			if (top != null  && top.isVisible()) {
				Dimension childSize = extractMinimumSize(top, wHint, hHint); //sic
				hHint = Math.max(minHHint, hHint - (childSize.height + vGap));
				minSize.setSize(childSize);
				rows += 1;
			}
			if (bottom != null && bottom.isVisible()) {
				Dimension childSize = extractMinimumSize(bottom, wHint, hHint); //sic
				hHint = Math.max(minHHint, hHint - (childSize.height + vGap));
				minSize.width = Math.max(minSize.width, childSize.width);
				minSize.height += childSize.height;
				rows += 1;
			}

			rows += columns > 0 ? 1 : 0;
			// Add spacing, insets, and the size of the middle row
			minSize.height += middleRowHeight + border.getHeight() + ((rows - 1) * vGap);
			minSize.width = Math.max(minSize.width, middleRowWidth) + border.getWidth() 
							+ ((columns - 1) * hGap);
			
			return minSize;
		}
		
		private Dimension extractMinimumSize(IFigure figure, int wHint, int hHint){
			if (figure instanceof StereotypeLabel2 && ((StereotypeLabel2)figure).isNeverHide()){
				return figure.getPreferredSize(wHint, hHint);
			} 
			return figure.getMinimumSize(wHint, hHint);
		}

		@Override
		protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
			int minWHint = 0, minHHint = 0;
			if (wHint < 0)
				minWHint = -1;
			
			if (hHint < 0)
				minHHint = -1;
			
			Insets border = container.getInsets();
			wHint = Math.max(minWHint, wHint - border.getWidth());
			hHint = Math.max(minHHint, hHint - border.getHeight());
			Dimension prefSize = new Dimension();
			int middleRowWidth = 0, middleRowHeight = 0;
			int rows = 0, columns = 0;

			if (top != null && top.isVisible()) {
				Dimension childSize = top.getPreferredSize(wHint, hHint);
				hHint = Math.max(minHHint, hHint - (childSize.height + vGap));
				prefSize.setSize(childSize);
				rows += 1;
			}
			if (bottom != null && bottom.isVisible()) {
				Dimension childSize = bottom.getPreferredSize(wHint, hHint);
				hHint = Math.max(minHHint, hHint - (childSize.height + vGap));
				prefSize.width = Math.max(prefSize.width, childSize.width);
				prefSize.height += childSize.height;
				rows += 1;
			}

			rows += columns > 0 ? 1 : 0;
			// Add spacing, insets, and the size of the middle row
			prefSize.height += middleRowHeight + border.getHeight() + ((rows - 1) * vGap);
			prefSize.width = Math.max(prefSize.width, middleRowWidth) + border.getWidth() 
							+ ((columns - 1) * hGap);
			
			return prefSize;
		}

		public void layout(IFigure container) {
			Rectangle area = container.getClientArea();
			Rectangle rect = new Rectangle();

			Dimension childSize;
			
			if (top != null && top.isVisible()) {
				childSize = top.getPreferredSize(area.width, -1);
				rect.setLocation(area.x, area.y);
				rect.setSize(childSize);
				rect.width = area.width;
				top.setBounds(rect);
				area.y += rect.height + vGap;
				area.height -= rect.height + vGap;
			}
			if (bottom != null && bottom.isVisible()) {
				childSize = bottom.getPreferredSize(Math.max(area.width, 0), -1);
				rect.setSize(childSize);
				rect.width = area.width;
				rect.setLocation(area.x, area.y + area.height - rect.height);
				bottom.setBounds(rect);
				area.height -= rect.height + vGap;
			}
		}

		@Override
		public void remove(IFigure child) {
			if (top == child) {
				top = null;
			} else if (bottom == child) {
				bottom = null;
			}
		}

		@Override
		public void setConstraint(IFigure child, Object constraint) {
			remove(child);
			super.setConstraint(child, constraint);
			if (constraint == null) {
				return;
			}
			
			switch (((Integer) constraint).intValue()) {
				case PositionConstants.TOP :
					top = child;
					break;
				case PositionConstants.BOTTOM :
					bottom = child;
					break;
				default :
					break;
			}
		}

		public void setHorizontalSpacing(int gap) {
			hGap = gap;
		}

		public void setVerticalSpacing(int gap) {
			vGap = gap;
		}
	}
}
