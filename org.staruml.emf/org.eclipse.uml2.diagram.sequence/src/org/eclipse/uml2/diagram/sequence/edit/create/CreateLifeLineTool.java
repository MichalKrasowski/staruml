package org.eclipse.uml2.diagram.sequence.edit.create;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;


public class CreateLifeLineTool extends CreationTool {
	protected Request createTargetRequest() {
		return new CreateLifeLineRequest(getPreferencesHint());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void selectAddedObject(EditPartViewer viewer, Collection objects) {
		List filtered = new LinkedList();
		for (Object nextCreated : objects){
			if (nextCreated instanceof IAdaptable) {
				View view = (View)((IAdaptable)nextCreated).getAdapter(View.class);
				if (view != null && shouldSelect(view)){
					filtered.add(nextCreated);
				}
			}
		}
		super.selectAddedObject(viewer, filtered);
	}
	
	protected boolean shouldSelect(View view){
		return LifelineEditPart.VISUAL_ID == UMLVisualIDRegistry.getVisualID(view);
	}	
}
