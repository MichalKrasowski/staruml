package org.eclipse.uml2.diagram.sequence.frame;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.uml2.diagram.sequence.figures.InvisibleRectangle;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;


public class CombinedFragmentShape extends FrameWithShadeAndPentagon {
	private Label myOperatorLabel;
	private Label myArgumentsLabel;
	
	public CombinedFragmentShape(){
		super();
		setLayoutManager(new XYLayout());
		setForegroundColor(ColorConstants.black);
        getPentagon().setFill(true);
        getPentagon().setLocation(new Point(1, 1));
        getPentagon().setBackgroundColor(ColorConstants.white);
        getPentagon().setContent(formatOperators());
	}
	
    private IFigure formatOperators() {
        InvisibleRectangle result = new InvisibleRectangle();
        result.setLayoutManager(new FlowLayout());
        
        myOperatorLabel = getPentagon().createPentagonLabel();
        myOperatorLabel.setFont(UMLDiagramEditorPlugin.getInstance().getDefaultBoldFont());
        result.add(myOperatorLabel);
        
        myArgumentsLabel = getPentagon().createPentagonLabel();
        myArgumentsLabel.setFont(UMLDiagramEditorPlugin.getInstance().getDefaultFont());
        result.add(myArgumentsLabel);
        
        return result;
    }
    
	public Label getOperatorLabel() {
		return myOperatorLabel;
	}
	
	public Label getArgumentsLabel() {
		return myArgumentsLabel;
	}
	
}
