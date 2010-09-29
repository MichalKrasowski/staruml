package org.eclipse.uml2.diagram.sequence.frame;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMInteractionOperand;

public class InteractionOperandShape extends FrameWithShadeAndPentagon {
	private final DelimitLineLayouterImpl myDelimitLineLayouter = new DelimitLineLayouterImpl();
	
	public InteractionOperandShape () {
		super();
		setPentagonVisible(false);
		setLineStyle(Graphics.LINE_DASH);
		setOpaque(false);
		setFill(false);
	}
	
	public void setPentagonVisible(boolean pentagonVisible){
		getPentagon().setVisible(pentagonVisible);
	}

	public DelimitLineLayouterImpl getDelimitLineLayouter() {
		return myDelimitLineLayouter;
	}

	protected void outlineShape(Graphics graphics) {
		if (getLineWidth() == 0) {
			return;
		}
		Rectangle bounds = getBounds();
		graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight());
	}
        
//        Shape getTopDelimiter() {
//            return myDelimiter;
//        }
//        private final Delimiter myDelimiter = new Delimiter(); 
//        
//        static class Delimiter extends LineShape /*RectangleFigure*/ implements LMInteractionOperand.DelimitLineLayouter {
//            Delimiter () {
//                setLineWidth(0);
//                Rectangle bounds = getBounds().getCopy();
//                bounds.height = 0;
//                setBounds(bounds);
//                setLineStyle(Graphics.LINE_DASH);
//                
//                setBackgroundColor(ColorConstants.green);
//                setForegroundColor(ColorConstants.blue);
//            }
//            
//            public void paint(Graphics graphics) {
//                super.paint(graphics);
//            }
//            
//            public void setX(int x) {
//                Rectangle bounds = getBounds().getCopy();
//                bounds.x = x;
//                setBounds(bounds);
//            }
//            
//            public void setY(int y) {
//                Rectangle bounds = getBounds().getCopy();
//                bounds.y = y;
//                setBounds(bounds);
//            }
//            
//            public void setHeight(int height) {
//                setLineWidth(height);
//            }
//            
//            public void setWidth(int width) {
//                Rectangle bounds = getBounds().getCopy();
//                bounds.width = width;
//                setBounds(bounds);
//            }
//        }

    private class DelimitLineLayouterImpl  implements LMInteractionOperand.DelimitLineLayouter  {
        public void setX(int x) {
        	//
		}

		public void setY(int pos) {
			//
		}

		public void setHeight(int height) {
			setLineWidth(height);
		}

		public void setWidth(int width) {
			//
		}
    }
}
