package co.staruml.handler;

import java.util.*;

import org.eclipse.swt.events.KeyEvent;

import co.staruml.core.DiagramControl;
import co.staruml.graphics.Canvas;


public class HandlerGroup extends Handler {

	private Vector<Handler> handlers;

	public HandlerGroup() {
		handlers = new Vector<Handler>();
	}
	
	public void addHandler(Handler handler) {
		handlers.add(handler);
	}
	
	public void removeHandler(Handler handler) {
		handlers.remove(handler);
	}
	
	public void mouseDragged(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
	}

	public void mouseMoved(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
	}

	public void mousePressed(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
	}

	public void mouseReleased(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
	}

	@Override
	public void keyPressed(DiagramControl diagramControl, Canvas canvas,
			KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
