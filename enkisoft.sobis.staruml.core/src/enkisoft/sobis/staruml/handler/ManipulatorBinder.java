package enkisoft.sobis.staruml.handler;

import enkisoft.sobis.staruml.core.EdgeView;
import enkisoft.sobis.staruml.core.NodeView;
import enkisoft.sobis.staruml.core.View;

public class ManipulatorBinder {
	
	private NodeManipulator nodeManipulator;
	private EdgeManipulator edgeManipulator;
	
	public ManipulatorBinder(SelectHandler selectHandler) {
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
