package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Interaction;


/**
 * 
 */
public interface AbsDiagram {
    AbsNode getRootNode();
    AbsNode getInteractionAbsNode();

    AbsLinkEnumeration links();

    Interaction getInteraction();
    View getInteractionView();
    //Entity getModelDiagramEntity();
}
