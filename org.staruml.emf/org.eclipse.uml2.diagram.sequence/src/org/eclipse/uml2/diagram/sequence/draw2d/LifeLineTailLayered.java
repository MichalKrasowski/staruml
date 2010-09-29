package org.eclipse.uml2.diagram.sequence.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;


public class LifeLineTailLayered extends LayeredPane {
	public static final String NORMAL_LAYER = "NormalLayer";
	public static final String SPECIAL_LAYER = "SpecialLayer";
	
	private Layer myNormalLayer;
	private Layer mySpecialLayer;
	private LifeLineTailShape myLifeLineTailShape;
	
	public LifeLineTailLayered(){
		myNormalLayer = new Layer();
		myNormalLayer.setLayoutManager(new StackLayout());

		mySpecialLayer = new Layer();
		mySpecialLayer.setLayoutManager(new XYLayout());
		
		addLayerAfter(mySpecialLayer, SPECIAL_LAYER, null);
		addLayerAfter(myNormalLayer, NORMAL_LAYER, SPECIAL_LAYER);
		
		myLifeLineTailShape = new LifeLineTailShape();
		myNormalLayer.add(myLifeLineTailShape);
	}
	
	
	public Layer getNormalLayer() {
		return myNormalLayer;
	}
	
	
	public Layer getSpecialLayer() {
		return mySpecialLayer;
	}
	
	
	public LifeLineTailShape getLifeLineTailShape() {
		return myLifeLineTailShape;
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
	}
	
	@Override
	protected void paintChildren(Graphics graphics) {
		super.paintChildren(graphics);
	}
}
