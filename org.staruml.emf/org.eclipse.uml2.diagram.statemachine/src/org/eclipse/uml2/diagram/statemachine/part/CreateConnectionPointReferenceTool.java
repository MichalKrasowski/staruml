/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.statemachine.part;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.diagram.statemachine.edit.helpers.ConnectionPointReferenceEditHelper;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.State;

public abstract class CreateConnectionPointReferenceTool extends UnspecifiedTypeCreationTool {
	public CreateConnectionPointReferenceTool(IHintedType elementType) {
		super(Collections.singletonList(elementType));
		connectionPoints = new LinkedList<Pseudostate>();
	}
	
	protected abstract PseudostateKind getKind();
	
	@Override
	protected Request createTargetRequest() {
		CreateUnspecifiedTypeRequest request = (CreateUnspecifiedTypeRequest) super.createTargetRequest();
		
		//below is the only way to propagate extended data into IEditCommandRequest#parameters  
		HashMap extendedData = new HashMap();
		extendedData.putAll(request.getExtendedData());
		extendedData.put(ConnectionPointReferenceEditHelper.PARAMETER_CONFIGURE_CONNECTION_POINT_REFERENCE, connectionPoints);
		request.setExtendedData(extendedData);
		return request;
	}
	
	@Override
	protected void executeCurrentCommand() {
		Command currentCommand = getCurrentCommand();
		if (currentCommand == null || !currentCommand.canExecute()) {
			return;
		}
		
		State state = (State) ((View) getTargetEditPart().getModel()).getElement();

		SelectConnectionPointsDialog selectDialog = new SelectConnectionPointsDialog(Display.getCurrent().getActiveShell(), state.getSubmachine(), getKind());
		if (selectDialog.open() == Window.OK) {
			Collection<Pseudostate> selectedConnectionReferences = selectDialog.getSelectedConnectionPoints();
			if (!selectedConnectionReferences.isEmpty()) {
				connectionPoints.addAll(selectedConnectionReferences);
				super.executeCurrentCommand();
			}
		}
	}
	
	private List<Pseudostate> connectionPoints;
}
