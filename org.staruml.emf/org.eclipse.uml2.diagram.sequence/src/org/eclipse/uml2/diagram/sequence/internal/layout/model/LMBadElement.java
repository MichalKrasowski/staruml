package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Color;
import java.awt.Point;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;


/**
 * 
 */
public abstract class LMBadElement {
	public abstract int layoutAndReturnWidth(int xPos);
	
	abstract AbsElement getGdeElement();
	
	static class Node extends LMBadElement {
		Node(AbsNode gdeNode) {
			myGdeNode = gdeNode;
		}
		public int layoutAndReturnWidth(int xPos) {
			myGdeNode.setBackground(PROBLEM_COLOR);
            if (myGdeNode.getWidth() < GeometryConstants.BadElement.MIN_WIDTH) {
                myGdeNode.setWidth(GeometryConstants.BadElement.MIN_WIDTH);
            }
            if (myGdeNode.getHeight() < GeometryConstants.BadElement.MIN_HEIGHT) {
                myGdeNode.setHeight(GeometryConstants.BadElement.MIN_HEIGHT);
            }
			return myGdeNode.getWidth();
		}
		AbsElement getGdeElement() {
			return myGdeNode;
		}
		private final AbsNode myGdeNode;
        
        static final Color PROBLEM_COLOR = new Color(233,60,50); 
	}
	static class Link extends LMBadElement {
		Link(AbsLink gdeLink) {
			myGdeLink = gdeLink;
		}
		public int layoutAndReturnWidth(int xPos) {
			myGdeLink.setForeground(Color.RED);
			myGdeLink.setLinkPoints(new Point [] {new Point(xPos+5, 10), new Point(xPos+5, 200)} );
			return 10;
		}
		AbsElement getGdeElement() {
			return myGdeLink;
		}
		private final AbsLink myGdeLink;
	}
}
