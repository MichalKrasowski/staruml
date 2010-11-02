package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;


public class XYLayoutEditPolicyWithMovableLabels extends XYLayoutEditPolicy {
	/** 
	 * We additionally allow to move label's editparts from compartments to containers with XY-layout 
	 */
	protected Command createAddCommand(EditPart child, Object constraint) {
		if ( (child instanceof ShapeEditPart || isPureLabelEditPart(child) )&& constraint instanceof Rectangle) {
			Rectangle rect = (Rectangle) constraint;
			
	 		ICommand boundsCommand = 
	 			new SetBoundsCommand(((IGraphicalEditPart) child).getEditingDomain(),
	 				DiagramUIMessages.SetLocationCommand_Label_Resize,
	 				new EObjectAdapter((View) child.getModel()),
					rect.getTopLeft()); 
			return new ICommandProxy(boundsCommand);
		}
		return null;
	}

	private boolean isPureLabelEditPart(EditPart child) {
		return child instanceof ITextAwareEditPart && child instanceof IGraphicalEditPart;
	}

}
