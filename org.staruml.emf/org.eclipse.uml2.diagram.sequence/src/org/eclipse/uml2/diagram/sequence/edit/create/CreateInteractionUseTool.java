package org.eclipse.uml2.diagram.sequence.edit.create;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredInteractionUseEditPart;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;


public class CreateInteractionUseTool extends AbstractCreateSDElementTool {
	protected Request createTargetRequest() {
		return new CreateInteractionUseRequest(getPreferencesHint());
	}
	
	protected boolean shouldSelect(View view){
		return LayeredInteractionUseEditPart.VISUAL_ID == UMLVisualIDRegistry.getVisualID(view);
	}	
}
