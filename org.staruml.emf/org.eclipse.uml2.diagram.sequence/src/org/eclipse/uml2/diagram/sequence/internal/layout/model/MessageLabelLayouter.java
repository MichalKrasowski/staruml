package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;

/**
 * 
 */
public class MessageLabelLayouter {
    public interface MessageLabel {
        boolean isUserResized();
        int getPreferredHeight();
        int getPreferredWidth();
        int getWidth();
        void setY(int y);
        void setX(int x);
    }

    public static void layoutMessageLabelsVertically(AbsLink gdeLink, int yPos) {
        MessageLabel[] labels = getLabels(gdeLink);
        for (int i = 0; i<labels.length; i++) {
            MessageLabel next = labels[i];
            int height = next.getPreferredHeight();
            next.setY(yPos-height);
        }
    }
    
    public static void layoutMessageLabelsHorizontally(AbsLink gdeLink, int startXPos, int endXPos, boolean fullLayout) {
        if (startXPos <= endXPos) {
            int xPos = startXPos;
            MessageLabel[] labels = getLabels(gdeLink);
            for (int i = 0; i<labels.length; i++) {
                MessageLabel next = labels[i];
                final int width;
                if (fullLayout || !next.isUserResized()) {
                    next.setX(xPos);
                    width = next.getPreferredWidth();
                } else {
                    width = next.getWidth();
                }
                xPos += width;
            }
        } else {
            MessageLabel[] labels = getLabels(gdeLink);
            
            int [] widths = new int[labels.length];
            int sumWidth = 0;
            for (int i=0; i<widths.length; i++) {
                MessageLabel next = labels[i];
                final int width;
                if (fullLayout || !next.isUserResized()) {
                    width = next.getPreferredWidth();
                } else {
                    width = next.getWidth();
                }
                widths[i] = width;
                
                sumWidth += widths[i]; 
            }
            
            int xPos = startXPos - sumWidth;
            for (int i=0; i<widths.length; i++) {
                MessageLabel next = labels[i];
                if (fullLayout || !next.isUserResized()) {
                    next.setX(xPos);
                }
                
                xPos += widths[i];
            }
        }
        
    }

    private static MessageLabel[] getLabels(AbsLink absLink) {
        return AbsElementPropertyAccess.getInstance().getLabels(absLink);        
    }
}
