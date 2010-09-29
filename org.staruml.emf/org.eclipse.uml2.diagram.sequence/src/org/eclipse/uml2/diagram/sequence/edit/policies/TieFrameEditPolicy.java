package org.eclipse.uml2.diagram.sequence.edit.policies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.handles.RelativeHandleLocator;
import org.eclipse.gef.handles.ResizableHandleKit;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;


public class TieFrameEditPolicy extends SDResizableShapeEditPolicy {
	
	@Override
	protected List<?> createSelectionHandles() {
		setResizeDirections(PositionConstants.NSEW);
		List<Object> result = new LinkedList<Object>();
		addResizeCornerHandles((GraphicalEditPart)getHost(), result);
		return result;
	}
	
    private void addResizeCornerHandles(GraphicalEditPart part, List<Object> output) {
    	ResizableHandleKit.addMoveHandle((GraphicalEditPart)getHost(), output);
        output.add(createExpandFrameHandle(part, PositionConstants.EAST));
        ResizableHandleKit.addHandle(part, output, PositionConstants.EAST);
        
        ResizableHandleKit.addHandle(part, output, PositionConstants.SOUTH_EAST);
        ResizableHandleKit.addHandle(part, output, PositionConstants.SOUTH);
        ResizableHandleKit.addHandle(part, output, PositionConstants.SOUTH_WEST);
        
        output.add(createExpandFrameHandle(part, PositionConstants.WEST));
        ResizableHandleKit.addHandle(part, output, PositionConstants.WEST);
        
        ResizableHandleKit.addHandle(part, output, PositionConstants.NORTH_WEST);
        ResizableHandleKit.addHandle(part, output, PositionConstants.NORTH);
        ResizableHandleKit.addHandle(part, output, PositionConstants.NORTH_EAST);
    }
	
	
	@Override
	protected IFigure createDragSourceFeedbackFigure() {
        Rectangle bounds = getInitialFeedbackBounds();
        StretchHorizontallyRectangle feedback = new StretchHorizontallyRectangle(bounds);
        FigureUtilities.makeGhostShape(feedback);
        feedback.setLineStyle(Graphics.LINE_DOT);
        feedback.setForegroundColor(ColorConstants.white);
        addFeedback(feedback);
        return feedback;
	}
	
    protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
        if (request instanceof TieFrameRequest) {
            StretchHorizontallyRectangle feedback = (StretchHorizontallyRectangle) getDragSourceFeedbackFigure();
            
            PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
            getHostFigure().translateToAbsolute(rect);
            feedback.translateToRelative(rect);
            feedback.setBounds(rect);
            
            Point location = request.getLocation().getCopy();
            feedback.translateToRelative(location);
            
            switch (request.getResizeDirection()) {
                case PositionConstants.WEST :
                    feedback.setLeftCorner(location);
                    break;
                case PositionConstants.EAST :
                    feedback.setRightCorner(location);
                    break;
//                  default :
//                  super.showChangeBoundsFeedback(request);
            }
        } else {
            super.showChangeBoundsFeedback(request);
        }
    }
    
    public void showSourceFeedback(Request request) {
        if (request instanceof TieFrameRequest) {
            showChangeBoundsFeedback((TieFrameRequest)request);
        } else {
            super.showSourceFeedback(request);
        }
    }
    
    public void eraseSourceFeedback(Request request) {
        if (request instanceof TieFrameRequest) {
            eraseChangeBoundsFeedback((TieFrameRequest)request);
        } else {
            super.eraseSourceFeedback(request);
        }
    }

    @Override
	public boolean understandsRequest(Request request) {
        if (request instanceof TieFrameRequest) {
            return true;
        }
        return super.understandsRequest(request);
	}
	
    private ResizeHandle createExpandFrameHandle(GraphicalEditPart owner, int direction) {
        //ResizeHandle handle = new TieFrameHandle(owner, direction, 3);
        ResizeHandle handle = new TieFrameImageHandle(owner, direction, 3); 
        handle.setCursor(Cursors.ARROW);
        handle.setDragTracker(new ExpandFrameDragTracker(owner, direction, handle));
        return handle;
    }
    
    static class StretchHorizontallyRectangle extends Polygon {
        StretchHorizontallyRectangle (Rectangle rectangle) {
            setBounds(rectangle);
        }
        
        public void setLeftCorner(Point location) {
            setPoint(location.getTranslated(0, BIT_HEIGHT) , 1);
            setPoint(location.getTranslated(0, - BIT_HEIGHT) , 2);
        }
        
        public void setRightCorner(Point location) {
            setPoint(location.getTranslated(0, - BIT_HEIGHT) , 5);
            setPoint(location.getTranslated(0, BIT_HEIGHT) , 6);
        }
        
        public void setBounds(Rectangle rectangle) {
            PointList points = new PointList(9);
            rectangle = rectangle.getResized(-1, -1);
            points.setSize(9);
            
            points.setPoint(rectangle.getBottomLeft(), 0);
            points.setPoint(rectangle.getTopLeft(), 1);
            points.setPoint(rectangle.getTopLeft(), 2);
            points.setPoint(rectangle.getTopLeft(), 3);
            
            points.setPoint(rectangle.getTopRight(), 4);
            points.setPoint(rectangle.getTopRight(), 5);
            points.setPoint(rectangle.getTopRight(), 6);
            points.setPoint(rectangle.getBottomRight(), 7);
            
            points.setPoint(rectangle.getBottomLeft(), 8);
            
            setPoints(points);
        }
        
        static final int BIT_HEIGHT = 5;
    }
    
    private static class TieFrameImageHandle extends ResizeHandle {
        public TieFrameImageHandle(GraphicalEditPart owner, int direction, int shift) {
            super(owner, new GdeRelativeHandleLocator(owner.getFigure(), direction, shift), Cursors.getDirectionalCursor(direction));
            assert direction == PositionConstants.EAST || direction == PositionConstants.WEST;
            myResizeDirection = direction;
        }
        
        protected void init() {
            Rectangle imageBounds = new Rectangle(getHandleImage().getBounds());
            imageBounds.expand(imageBounds.width, 0);
            setPreferredSize( imageBounds.getSize());
        }
        
        public void paintFigure(Graphics g) {
            Rectangle r = getBounds().getCopy();
            r.shrink(1, 1);
            
            final int shiftFactor = (myResizeDirection == PositionConstants.EAST) ? 1 : -1;
            g.setForegroundColor(getFillColor());
            g.setLineWidth(1);
            g.setLineStyle(Graphics.LINE_DOT);
            g.drawLine(r.getCenter(), r.getCenter().translate(shiftFactor * r.width/4, 0));
            
            if (myResizeDirection == PositionConstants.EAST) {
                r.x += r.width/4*3;
            }
            g.drawImage(UMLDiagramEditorPlugin.getInstance().getBundledImage("icons/shape-anchor.gif"), r.x , r.y);
        }
        
        private static Image getHandleImage() {
        	return UMLDiagramEditorPlugin.getInstance().getBundledImage("icons/shape-anchor.gif");
        }

        private final int myResizeDirection;
    }
    
    private static class GdeRelativeHandleLocator extends RelativeHandleLocator {
        protected int myLocation;
        private int myShift;

        public GdeRelativeHandleLocator(IFigure reference, int location, int shift) {
            super(reference, location);
            myLocation = location;
            myShift = shift;
        }
        public void relocate(IFigure target) {
            super.relocate(target);
            target.getBounds().x += getXGuide(myLocation) * myShift;
            target.getBounds().y += getYGuide(myLocation) * myShift;
        }
        
        private static int getXGuide(int dir) {
            switch (dir & PositionConstants.EAST_WEST) {
                case PositionConstants.WEST:
                    return -1;
                case PositionConstants.EAST:
                    return 1;
                default:
                    return 0;
            }
        }

        private static int getYGuide(int dir) {
            switch (dir & PositionConstants.NORTH_SOUTH) {
                case PositionConstants.NORTH:
                    return -1;
                case PositionConstants.SOUTH:
                    return 1;
                default:
                    return 0;
            }
        }
        
    }
    
	
}
