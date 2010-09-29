package org.eclipse.uml2.diagram.sequence.internal.layout.alien;

import java.awt.Dimension;
import java.util.Collection;

/*
 * [U2T] 
 */
public interface IAlienElementsLayout {
	public Dimension layoutReshaped(Collection reshapedGdeElements, int clientAreaLeft, int clientAreaTop);
	public Dimension fullLayout(int alienElementsAreaLeft, int alienElementsAreaTop);
}
