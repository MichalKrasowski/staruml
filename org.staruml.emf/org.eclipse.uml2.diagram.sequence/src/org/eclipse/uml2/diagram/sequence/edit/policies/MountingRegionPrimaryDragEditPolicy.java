package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;


public class MountingRegionPrimaryDragEditPolicy extends NonResizableEditPolicyEx {
    public EditPart getTargetEditPart(org.eclipse.gef.Request request) {
        if (RequestConstants.REQ_SELECTION.equals(request.getType())) {
            EditPart parent = getHost().getParent();
            return (parent == null) ? null : parent.getTargetEditPart(request);
        } else {
            return super.getTargetEditPart(request);
        }
    }
}
