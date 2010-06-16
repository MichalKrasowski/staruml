package enkisoft.sobis.staruml.handler;

import enkisoft.sobis.staruml.core.EdgeView;
import enkisoft.sobis.staruml.core.NodeView;
import enkisoft.sobis.staruml.core.View;
import enkisoft.sobis.staruml.graphics.*;

public interface SelectHandlerListener {
	// view selection events
	public void selectView(View view);
	public void deselectView(View view);
	public void selectAdditionalView(View view);
	public void selectArea(int x1, int y1, int x2, int y2);
	public void viewDoubleClicked(View view);
	// view modification events
	public void moveView(View view, int dx, int dy);
	public void changeViewContainer(View view, int dx, int dy, View containerView);
	public void moveSelectedViews(int dx, int dy);
	public void changeSelectedViewsContainer(int dx, int dy, View containerView);
	public void resizeNode(NodeView node, int left, int top, int right, int bottom);
	public void modifyEdge(EdgeView edge, Points points);
	public void reconnectEdge(EdgeView edge, Points points, View newParticipant, boolean isTailSide);
}
