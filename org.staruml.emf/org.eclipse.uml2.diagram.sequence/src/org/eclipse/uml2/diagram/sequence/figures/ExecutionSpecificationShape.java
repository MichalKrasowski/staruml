package org.eclipse.uml2.diagram.sequence.figures;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.editparts.NeedsParentEditPart;
import org.eclipse.uml2.diagram.common.layered.MultiLayeredContainer;
import org.eclipse.uml2.diagram.common.layered.MultilayeredFigure;
import org.eclipse.uml2.diagram.common.layered.MultilayeredSupport;
import org.eclipse.uml2.diagram.common.layered.MultilayeredSupportImpl;


public class ExecutionSpecificationShape extends LifelineBracketContainerShape implements MultilayeredFigure, NeedsParentEditPart {
    private final MultilayeredSupportImpl myMultilayeredSupport;
    private final CrossFigure myCrossFigure;
    
    public ExecutionSpecificationShape(){
		setFill(true);
		setOpaque(false);
		setOutline(true);
    	
    	myMultilayeredSupport = new MultilayeredSupportImpl();
        myMultilayeredSupport.setLayerToFigure(MultiLayeredContainer.MIDDLE_LAYER, this);
        myMultilayeredSupport.setLayerToContentPane(MultiLayeredContainer.MIDDLE_LAYER, this);

        myCrossFigure = new CrossFigure(this);
        myMultilayeredSupport.setLayerToFigure(MultiLayeredContainer.FOREGROUND_LAYER, myCrossFigure);
        myMultilayeredSupport.setLayerToContentPane(MultiLayeredContainer.FOREGROUND_LAYER, myCrossFigure);
        
        //myCrossFigure.setVisible(false);
    }
    
    public void hookParentEditPart(GraphicalEditPart parentEditPart) {
    	myMultilayeredSupport.setParentFromParentEditPart(parentEditPart);
    }
    
    public MultilayeredSupport getMultilayeredSupport() {
    	return myMultilayeredSupport;
    }
    
    public void setForegroundColor(Color fg) {
        super.setForegroundColor(fg);
        if (myCrossFigure != null) {
            myCrossFigure.setForegroundColor(fg);
        }
    }
    
    public void setCrossVisible(boolean visible){
    	myCrossFigure.setVisible(visible);
    }

    @Override
    protected void layout() {
        super.layout();
        if (myCrossFigure != null) {
            myCrossFigure.revalidate();
        }
    }
    

}
