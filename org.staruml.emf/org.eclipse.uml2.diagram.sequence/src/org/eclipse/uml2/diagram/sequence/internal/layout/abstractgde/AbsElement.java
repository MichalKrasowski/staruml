package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde;

import java.awt.Color;

import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 */
public interface AbsElement {
    void setForeground(Color color);
    Color getForeground();

    void setBackground(Color color);
    Color getBackground();
    
    View getReference();
}
