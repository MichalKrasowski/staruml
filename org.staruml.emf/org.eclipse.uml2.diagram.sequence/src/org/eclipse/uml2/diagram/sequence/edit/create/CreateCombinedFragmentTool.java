package org.eclipse.uml2.diagram.sequence.edit.create;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredCombinedFragmentEditPart;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;


public class CreateCombinedFragmentTool extends AbstractCreateSDElementTool {
	protected Request createTargetRequest() {
		return new CreateCombinedFragmentRequest(getPreferencesHint());
	}
	
	protected boolean shouldSelect(View view){
		return LayeredCombinedFragmentEditPart.VISUAL_ID == UMLVisualIDRegistry.getVisualID(view);
	}	
}
