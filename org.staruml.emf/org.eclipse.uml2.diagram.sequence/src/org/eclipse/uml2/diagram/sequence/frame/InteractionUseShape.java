package org.eclipse.uml2.diagram.sequence.frame;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.uml2.diagram.common.layered.MultiLayeredContainer;
import org.eclipse.uml2.diagram.sequence.draw2d.layouts.CenteringLayout;
import org.eclipse.uml2.diagram.sequence.draw2d.layouts.FillingBorderLayout;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMInteractionOccurence;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;



public class InteractionUseShape extends FrameWithPentagon implements LMInteractionOccurence.InteractionUseLayouter {
	private static final Border TEXT_MARGIN = new MarginBorder(0,5,0,5);
	private Label myReferencedInteractionSignatureLabel;
	private Label myPentagonLabel;

	public InteractionUseShape() {
        myPentagonLabel = new Label();
        myPentagonLabel.setFont(UMLDiagramEditorPlugin.getInstance().getDefaultBoldFont());
        getPentagon().setContent(myPentagonLabel);
        
        setFill(true);
        setLayoutManager(new FillingBorderLayout());
        setMinimumSize(new Dimension(8,8)); //CR#18073 : all frame constraints should be processed by Sd layout
        
        IFigure labelContainer = new Figure();
        labelContainer.setLayoutManager(new CenteringLayout());
        add(labelContainer, FillingBorderLayout.CENTER);
        
        myReferencedInteractionSignatureLabel = new Label();
        myReferencedInteractionSignatureLabel.setFont(UMLDiagramEditorPlugin.getInstance().getDefaultBoldFont());
        myReferencedInteractionSignatureLabel.setForegroundColor(ColorConstants.black);
        myReferencedInteractionSignatureLabel.setBorder(TEXT_MARGIN);
        myReferencedInteractionSignatureLabel.setLabelAlignment(PositionConstants.CENTER);
        labelContainer.add(myReferencedInteractionSignatureLabel);
        
        getMultilayeredSupportImpl().setLayerToFigure(MultiLayeredContainer.FOREGROUND_LAYER, this);
        getMultilayeredSupportImpl().setLayerToContentPane(MultiLayeredContainer.FOREGROUND_LAYER, this);
    }
	
	public Label getPentagonLabel() {
		return myPentagonLabel;
	}
	
	protected void setPentagonLabelText(String text){
		myPentagonLabel.setText(text);
		getPentagon().updateToPreferredSize();
	}
    
	public Label getReferencedInteractionSignatureLabel() {
		return myReferencedInteractionSignatureLabel;
	}
    
}
