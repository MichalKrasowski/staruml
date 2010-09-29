package org.eclipse.uml2.diagram.clazz.action;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification4EditPart;
import org.eclipse.uml2.diagram.clazz.part.Messages;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.actions.ChangeNotationAction;

/**
 * @generated
 */
public class TurnIntoInstanceSpecification4Action extends ChangeNotationAction {

	/**
	 * @generated
	 */
	public static final String ACTION_ID = "set_InstanceSpecification4_notation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static final int NEW_VID = InstanceSpecification4EditPart.VISUAL_ID;

	/**
	 * @generated
	 */
	public TurnIntoInstanceSpecification4Action(IWorkbenchPage workbenchPage, String actionId) {
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
		setText(Messages.TurnIntoInstanceSpecification4Action_text);
		setText(Messages.TurnIntoInstanceSpecification4Action_tooltiptext);
	}

	/**
	 * @generated
	 */
	@Override
	protected String getSemanticHint(GraphicalEditPart editPart) {
		return String.valueOf(NEW_VID);
	}

}
