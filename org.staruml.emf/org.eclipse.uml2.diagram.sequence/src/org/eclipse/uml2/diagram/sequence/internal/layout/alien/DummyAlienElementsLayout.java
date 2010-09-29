package org.eclipse.uml2.diagram.sequence.internal.layout.alien;

import java.awt.Dimension;
import java.util.Collection;

/*
 * [U2T] temporary replacement for AlienElementsLayout
 */
public class DummyAlienElementsLayout implements IAlienElementsLayout {
	public Dimension fullLayout(int alienElementsAreaLeft, int alienElementsAreaTop) {
		System.out.println("DummyAlienElementsLayout.fullLayout()");
		return new Dimension(50, 50);
	}
	
	public Dimension layoutReshaped(Collection reshapedGdeElements, int clientAreaLeft, int clientAreaTop) {
		System.out.println("DummyAlienElementsLayout.layoutReshaped()");
		return new Dimension(50, 50);
	}
}
