package co.staruml.handler;

import co.staruml.core.EdgeView;
import co.staruml.core.NodeView;
import co.staruml.core.View;

public class ManipulatorBinder {
	
	private NodeManipulator nodeManipulator;
	private EdgeManipulator edgeManipulator;
	
	public ManipulatorBinder(Handler selectHandler) {
		nodeManipulator = new NodeManipulator(selectHandler);
		edgeManipulator = new EdgeManipulator(selectHandler);
	}
	
	public Manipulator bind(View view) {
		if (view instanceof NodeView)
			return nodeManipulator;
		else if (view instanceof EdgeView)
			return edgeManipulator;
		return null;
	}
	
}
