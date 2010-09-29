package org.eclipse.uml2.diagram.clazz.action;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.edit.commands.ChangeDependencyTypeCommand;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;

public class ChangeDependencyType extends DiagramAction {

	EClass dependencyType;

	public ChangeDependencyType(IWorkbenchPage workbenchPage, EClass type, String actionId) {
		super(workbenchPage);
		setId(actionId);
		dependencyType = type;
	}

	@Override
	public void init() {
		super.init();
		setText(dependencyType.getInstanceTypeName());
		setImageDescriptor(UMLElementTypes.getImageDescriptor(UMLElementTypes.getElement(UMLElementTypes.Interface_2010)));
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean calculateEnabled() {
		return super.calculateEnabled() && dependencyType != null && false == dependencyType.equals(getDependencyType());
	}

	@Override
	protected Command getCommand() {
		ConnectionEditPart editPart = getSelectedEditPart();
		if (editPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompoundCommand command = new CompoundCommand();
		ChangeDependencyTypeCommand changeTypeCommand = new ChangeDependencyTypeCommand(getSelectedEditPart(), dependencyType, getPreferencesHint());
		command.add(changeTypeCommand);
		Command selectCommand = new SelectEditPartCommand(getDiagramGraphicalViewer(), changeTypeCommand.getElementDescriptor());
		command.add(selectCommand);
		return command;
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	private ConnectionEditPart getSelectedEditPart() {
		for (Object ob : getSelectedObjects()) {
			if (ob instanceof ConnectionEditPart) {
				return (ConnectionEditPart) ob;
			}
		}
		return null;
	}

	private EClass getDependencyType() {
		ConnectionEditPart editPart = getSelectedEditPart();
		if (editPart == null) {
			return null;
		}
		View view = (View) editPart.getModel();
		if (view == null) {
			return null;
		}
		return view.getElement().eClass();
	}
	
	private static class SelectEditPartCommand extends Command {

		private EditPartViewer viewer;

		private ConnectionViewDescriptor descriptor;

		SelectEditPartCommand(EditPartViewer viewer, ConnectionViewDescriptor descriptor) {
			this.viewer = viewer;
			this.descriptor = descriptor;
		}

		@Override
		public void execute() {
			super.execute();
			EditPart editPart = getEditPart();
			if (viewer == null || editPart == null) {
				return;
			}
			viewer.setSelection(new StructuredSelection(Collections.singletonList(editPart)));
		}

		private EditPart getEditPart() {
			View view = (View) descriptor.getAdapter(View.class);
			EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(view);
			return editPart;
		}
	}
}
