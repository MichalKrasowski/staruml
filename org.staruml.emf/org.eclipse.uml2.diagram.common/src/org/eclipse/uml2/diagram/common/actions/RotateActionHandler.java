/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.actions;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.diagram.common.Messages;

public class RotateActionHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		DiagramDocumentEditor editor = (DiagramDocumentEditor)HandlerUtil.getActiveEditorChecked(event);
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (false == selection instanceof IStructuredSelection){
			return null;
		}
		List<?> editParts = ((IStructuredSelection)selection).toList();
		
		TransactionalEditingDomain domain = editor.getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(domain, Messages.RotateAction_rotate_command);
		for (Object nextEditPart : editParts){
			if (nextEditPart instanceof ShapeNodeEditPart){
				cc.add(rotate((ShapeNodeEditPart)nextEditPart));
			}
		}
		
		if (cc.canExecute()){
			editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(cc.reduce()));
		}

		return null;
	}
	
	private SetBoundsCommand rotate(ShapeNodeEditPart selectedElement) {
		Dimension size = selectedElement.getSize();

		int x = (Integer) selectedElement.getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X());
		int y = (Integer) selectedElement.getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y());

		Rectangle rectangle = new Rectangle(x + size.width / 2 - size.height / 2, y - size.width / 2 + size.height / 2, size.height, size.width);
		SetBoundsCommand result = new SetBoundsCommand(selectedElement.getEditingDomain(), Messages.RotateAction_rotate_command, new EObjectAdapter(selectedElement.getNotationView()), rectangle);
		return result;
	}
	
}
