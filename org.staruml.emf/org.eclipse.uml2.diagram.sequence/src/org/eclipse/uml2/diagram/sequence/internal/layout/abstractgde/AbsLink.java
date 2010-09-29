package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde;

import java.awt.Point;

public interface AbsLink extends AbsElement {

    void setLinkPoints(Point[] points);

    AbsElement getSource();

    AbsElement getDestination();

    Point[] getLinkPoints();
}
