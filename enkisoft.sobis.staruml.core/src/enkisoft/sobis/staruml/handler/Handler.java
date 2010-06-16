package enkisoft.sobis.staruml.handler;

import enkisoft.sobis.staruml.core.DiagramControl;
import enkisoft.sobis.staruml.graphics.*;

public abstract class Handler {

	public abstract void mousePressed(DiagramControl diagramControl, Canvas canvas, MouseEvent e);
	public abstract void mouseReleased(DiagramControl diagramControl, Canvas canvas, MouseEvent e);
	public abstract void mouseDragged(DiagramControl diagramControl, Canvas canvas, MouseEvent e);
	public abstract void mouseMoved(DiagramControl diagramControl, Canvas canvas, MouseEvent e);

}
