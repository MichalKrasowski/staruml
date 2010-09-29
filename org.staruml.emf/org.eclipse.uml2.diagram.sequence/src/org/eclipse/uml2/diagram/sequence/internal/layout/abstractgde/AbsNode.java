package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde;

import java.awt.Dimension;

import org.eclipse.emf.ecore.EObject;


public interface AbsNode extends AbsElement {

	EObject getModelEntity();
	
    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

    AbsElement getParentGdeElement();
    
    

    AbsNodeEnumeration subnodes();

    void setY(int pos);

    int getY();

    int getX();

    void setX(int newPos);


    Dimension getPreferredSize();

    boolean isUserResized();
    
    void markUserResized();

    boolean isExternal();

}
