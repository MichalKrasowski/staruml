package org.eclipse.uml2.diagram.usecase.action;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.common.actions.ChangeNotationAction;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorAsRectangleEditPart;
import org.eclipse.uml2.diagram.usecase.part.Messages;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class TurnIntoActorAsRectangleAction extends ChangeNotationAction {

	/**
	 * @generated
	 */
	public static final String ACTION_ID = "set_ActorAsRectangle_notation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static final int NEW_VID = ActorAsRectangleEditPart.VISUAL_ID;

	/**
	 * @generated
	 */
	public TurnIntoActorAsRectangleAction(IWorkbenchPage workbenchPage, String actionId) {
		super(workbenchPage, actionId);
	}

	/**
	 * @generated
	 */
	@Override
	public void refresh() {
		super.refresh();
		setChecked(calculateChecked());
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		GraphicalEditPart ep = getSelectedEditPart();
		return (ep == null) ? false : UMLVisualIDRegistry.getVisualID(ep.getNotationView()) != NEW_VID;
	}

	/**
	 * @generated
	 */
	public boolean calculateChecked() {
		GraphicalEditPart ep = getSelectedEditPart();
		return (ep == null) ? false : UMLVisualIDRegistry.getVisualID(ep.getNotationView()) == NEW_VID;
	}

	/**
	 * @generated
	 */
	@Override
	protected void updateText() {
		setText(Messages.TurnIntoActorAsRectangleAction_text);
		setText(Messages.TurnIntoActorAsRectangleAction_tooltiptext);
	}

	/**
	 * @generated
	 */
	@Override
	protected String getSemanticHint(GraphicalEditPart editPart) {
		return String.valueOf(NEW_VID);
	}

}
