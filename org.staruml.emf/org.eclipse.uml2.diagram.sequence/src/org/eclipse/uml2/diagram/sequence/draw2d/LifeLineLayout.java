package org.eclipse.uml2.diagram.sequence.draw2d;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

public class LifeLineLayout extends AbstractLayout /*implements LMLifeLine.DetailsLayouter */{

	public int getHeadPreferredWidth() {
		return myHead.getPreferredSize().width;
	}

	public int getHeadPreferredHeight() {
		return myHead.getPreferredSize().height;
	}

	public int getHeadTopPos() {
		return myHead.getBounds().y;
	}

	public void setHorizontalPositions(int centerRelativePos, int headHalfWidth) {
		myCenterRelativePos = centerRelativePos;
		myHeadHalfWidth = headHalfWidth;
		myHead.revalidate();

		myTail.setLineRelativeX(centerRelativePos);
		myTail.revalidate();
	}

	public int getCenterRelativePos() {
		return myCenterRelativePos;
	}

	public int getHeadHalfWidth() {
		return myHeadHalfWidth;
	}

	//------------------------------------------------------

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

		Dimension headSize = myHead.getPreferredSize(wHint, hHint);
		hHint = Math.max(minHHint, hHint - headSize.height);
		prefSize.setSize(headSize);

		Dimension tailSize = myTail.getPreferredSize(wHint, hHint);
		prefSize.height += tailSize.height;
		prefSize.width = Math.max(prefSize.width, tailSize.width);

		return prefSize.expand(border.getWidth(), border.getHeight());
	}

	public void layout(IFigure container) {
		Rectangle area = container.getClientArea();

		Rectangle headBounds = new Rectangle(area);
		headBounds.translate(myCenterRelativePos - myHeadHalfWidth, 0);
		headBounds.width = 2 * myHeadHalfWidth;
		Dimension headPreferredSize = myHead.getPreferredSize(headBounds.width, -1);
		headBounds.height = headPreferredSize.height;
		myHead.setBounds(headBounds);

		area.y += headBounds.height;
		area.height -= headBounds.height;
		myTail.setBounds(area);
	}

	public void setConstraint(IFigure child, Object constraint) {
		if (child instanceof LifeLineTailShape) {
			myTail = (LifeLineTailShape) child;
		} else if (myHead == null) {
			myHead = child;
		} else {
			throw new IllegalArgumentException();
		}
		super.setConstraint(child, constraint);
	}

	private IFigure myHead;

	private LifeLineTailShape myTail;

	private int myCenterRelativePos;

	private int myHeadHalfWidth;
}
