package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde;

import java.util.Enumeration;


/**
 * 
 */
public interface AbsLinkEnumeration extends Enumeration {

    boolean hasMoreElements();

    AbsLink nextGdeLink();

}
