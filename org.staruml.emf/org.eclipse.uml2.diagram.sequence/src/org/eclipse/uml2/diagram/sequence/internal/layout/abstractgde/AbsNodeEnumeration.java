package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde;

import java.util.Enumeration;


/**
 * 
 */
public interface AbsNodeEnumeration extends Enumeration {

    AbsNode nextGdeNode();

    boolean hasMoreElements();

}
