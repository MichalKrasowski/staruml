package enkisoft.sobis.staruml.handler;

import java.util.*;

import enkisoft.sobis.staruml.core.DiagramControl;
import enkisoft.sobis.staruml.graphics.Canvas;

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

}
