package co.staruml.handler;

import co.staruml.core.DiagramControl;
import co.staruml.core.EdgeView;
import co.staruml.core.NodeView;
import co.staruml.core.View;
import co.staruml.graphics.*;

public interface SelectHandlerListener {
	// view selection events
	public void selectView(View view);
	public void deselectView(View view);
	public void selectAdditionalView(View view);
	public void selectArea(int x1, int y1, int x2, int y2);
	public void viewDoubleClicked(DiagramControl diagramControl, Canvas canvas, View view, MouseEvent e);
	// view modification events
	public void moveView(View view, int dx, int dy);
	public void changeViewContainer(View view, int dx, int dy, View containerView);
	public void moveSelectedViews(int dx, int dy);
	public void changeSelectedViewsContainer(int dx, int dy, View containerView);
	public void resizeNode(NodeView node, int left, int top, int right, int bottom);
	public void modifyEdge(EdgeView edge, Points points);
	public void reconnectEdge(EdgeView edge, Points points, View newParticipant, boolean isTailSide);
}
