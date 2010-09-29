package org.eclipse.uml2.diagram.sequence.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.uml2.diagram.common.draw2d.FillingBorderLayout;


public class InteractionShapeBase extends RectangleFigure {
    public InteractionShapeBase() {
    	setLineWidth(1);
        setLayoutManager(new FillingBorderLayout());
        myPentagonPane = new Figure();
        //myPentagonPane.setFont(f);
        //myPentagonPane.setBackgroundColor(ColorConstants.red);
        //myPentagonPane.setOpaque(true);
        
        myPentagonPane.setLayoutManager(new FlowLayout());
        myPentagonPane.add(myPentagon);

        add(myPentagonPane, FillingBorderLayout.TOP);
    }
    
    public void setPentagonContent(IFigure figure) {
        myPentagon.setContent(figure);
    }
    
    protected IFigure getPentagonPane() {
        return myPentagonPane;
    }
    
    private final IFigure myPentagonPane;
    private final Pentagon myPentagon = new Pentagon();
}
