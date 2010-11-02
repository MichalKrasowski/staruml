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
package org.eclipse.uml2.diagram.common.commands;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;


public class RefreshLabelsCommand extends Command {
	private final IGraphicalEditPart myEditPart;
	
	public RefreshLabelsCommand(IGraphicalEditPart ep) {
		myEditPart = ep;
	}
	
	@Override
	public void execute() {
		if (myEditPart instanceof ITextAwareEditPart){
			((ITextAwareEditPart)myEditPart).refresh();
		}
		for (Object nextChildEP : myEditPart.getChildren()){
			if (nextChildEP instanceof ITextAwareEditPart){
				((ITextAwareEditPart)nextChildEP).refresh();
			}
		}
	}
	
	@Override
	public void undo() {
		execute();
	}
	
}
