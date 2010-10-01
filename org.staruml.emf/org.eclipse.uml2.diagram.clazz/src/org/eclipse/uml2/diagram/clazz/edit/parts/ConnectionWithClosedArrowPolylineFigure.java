package org.eclipse.uml2.diagram.clazz.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;


public class ConnectionWithClosedArrowPolylineFigure extends PolylineConnectionEx {
	private IMapMode mapMode;
	/**
	 * @generated
	 */
	public ConnectionWithClosedArrowPolylineFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		this.setFill(true);
		this.setFillXOR(false);
		this.setOutline(true);
		this.setOutlineXOR(false);
		this.setLineWidth(1);
		this.setLineStyle(Graphics.LINE_DASH);
		this.setForegroundColor(ColorConstants.lightGray);

		setTargetDecoration(createTargetDecoration());
	}
	
	/**
	 * @generated
	 */
	private RotatableDecoration createTargetDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		df.setFill(false);
		df.setFillXOR(false);
		df.setOutline(true);
		df.setOutlineXOR(false);
		df.setLineWidth(1);
		df.setLineStyle(Graphics.LINE_SOLID);
		PointList pl = new PointList();
		pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
		pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
		pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
		pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
		df.setTemplate(pl);
		df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
		return df;
	}
	private IMapMode getMapMode()  {
		return mapMode;
	}
}
