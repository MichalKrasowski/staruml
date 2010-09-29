package org.eclipse.uml2.diagram.clazz.action;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.details.UMLDetailLevel;
import org.eclipse.uml2.diagram.clazz.details.UMLDetailLevelService;

public class ChangeDetailLevel extends DiagramAction {

	private UMLDetailLevel myNewLevel;

	public ChangeDetailLevel(IWorkbenchPage workbenchPage, UMLDetailLevel level) {
		super(workbenchPage);
		myNewLevel = level;
		setText(level.getLabel());
	}
	
	@Override
	public void refresh() {
		super.refresh();
		setChecked(calculateChecked());
	}
	
	@Override
	protected boolean calculateEnabled() {
		DiagramEditPart diagram = getDiagramEditPart();
		if (diagram == null || diagram.getDiagramView() == null) {
			return false;
		}
		return UMLDetailLevelService.getLevel(diagram.getDiagramView()) != myNewLevel && super.calculateEnabled();
	}
	
	@Override
	protected Command getCommand() {
		CompoundCommand result = new CompoundCommand();
		DiagramEditPart diagramEditPart = getDiagramEditPart();
		Diagram diagram = diagramEditPart.getDiagramView();		
		TransactionalEditingDomain editingDomain = diagramEditPart.getEditingDomain();
		
		UMLDetailLevel oldLevel = UMLDetailLevelService.getLevel(diagram);
		List<View> affectedViews = oldLevel.getAffectedViews(diagram);
		for (View affected: affectedViews) {
			for (EditElementCommand command: oldLevel.getUnapplyCommands(editingDomain, affected)) {
				result.add(new ICommandProxy(command));
			}
		}
		affectedViews = myNewLevel.getAffectedViews(diagram);
		for (View affected: affectedViews) {
			for (EditElementCommand command: myNewLevel.getApplyCommands(editingDomain, affected)) {
				result.add(new ICommandProxy(command));
			}
		}
		result.add(new ICommandProxy(myNewLevel.getSetLevelCommand(editingDomain, diagram)));
		return result;
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	private boolean calculateChecked() {
		DiagramEditPart diagram = getDiagramEditPart();
		if (diagram == null || diagram.getDiagramView() == null) {
			return false;
		}
		return UMLDetailLevelService.getLevel(diagram.getDiagramView()) == myNewLevel;
	}

}
