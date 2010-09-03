package co.staruml.handler;

import org.eclipse.swt.events.KeyEvent;

import co.staruml.core.DiagramControl;
import co.staruml.graphics.*;

public abstract class Handler {

	public abstract void mousePressed(DiagramControl diagramControl, Canvas canvas, MouseEvent e);
	public abstract void mouseReleased(DiagramControl diagramControl, Canvas canvas, MouseEvent e);
	public abstract void mouseDragged(DiagramControl diagramControl, Canvas canvas, MouseEvent e);
	public abstract void mouseMoved(DiagramControl diagramControl, Canvas canvas, MouseEvent e);
	public abstract void keyPressed(DiagramControl diagramControl, Canvas canvas, KeyEvent e);

}
