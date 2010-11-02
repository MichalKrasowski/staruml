package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.uml2.diagram.common.draw2d.decoration.AssociationDecoration;


public class AssociationLinkFigureBase extends PolylineConnectionEx {

	public AssociationLinkFigureBase() {
		setSourceDecoration(createSourceDecoration());
		setTargetDecoration(createTargetDecoration());
	}
	
	private RotatableDecoration createSourceDecoration() {
		AssociationDecoration df = new AssociationDecoration();
		return df;
	}

	private RotatableDecoration createTargetDecoration() {
		AssociationDecoration df = new AssociationDecoration();
		return df;
	}

	public AssociationDecoration getTargetDecorationImpl() {
		return (AssociationDecoration) getTargetDecoration();
	}

	public AssociationDecoration getSourceDecorationImpl() {
		return (AssociationDecoration) getSourceDecoration();
	}

}
