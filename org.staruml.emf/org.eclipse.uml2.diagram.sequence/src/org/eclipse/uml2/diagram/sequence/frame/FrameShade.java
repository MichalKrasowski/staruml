package org.eclipse.uml2.diagram.sequence.frame;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.TreeSearch;


public class FrameShade extends RectangleFigure {
    private final IFigure myMainFigure;

	public FrameShade(IFigure mainFigure) {
        myMainFigure = mainFigure;
		setOutline(false);
    }
    
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        IFigure figure = super.findFigureAt(x, y, search);
        if (this == figure) {
            return myMainFigure;
        } else {
            return figure;
        }
    }
}

