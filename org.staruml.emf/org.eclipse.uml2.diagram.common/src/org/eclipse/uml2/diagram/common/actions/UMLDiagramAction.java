/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class UMLDiagramAction extends AbstractHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IGraphicalEditPart ep = getSelectedEditPart(event);
		if (ep == null) {
			return null;
		}
		Command command = getCommand(ep);
		if (command != null && command.canExecute()) {
			ep.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		} 
		return null;
	}

	protected IGraphicalEditPart getSelectedEditPart(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		assert diagramEditor instanceof DiagramEditor;
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof IGraphicalEditPart) {
				return (IGraphicalEditPart) structuredSelection.getFirstElement();
			}
		}
		return null;
	}

	protected abstract Command getCommand(IGraphicalEditPart ep);

}
