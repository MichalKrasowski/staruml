/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.usecase.edit.helpers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.diagram.common.editpolicies.MoveRequestWithParentInfo;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;

/**
 * @generated
 */
public class PackageEditHelper extends UMLBaseEditHelper {

	@Override
	protected ICommand getMoveCommand(MoveRequest req) {
		ICommand basicMove = super.getMoveCommand(req);
		if (basicMove == null) {
			return null;
		}
		if (false == req instanceof MoveRequestWithParentInfo) {
			return basicMove;
		}
		MoveRequestWithParentInfo reqImpl = (MoveRequestWithParentInfo) req;
		CompositeCommand withResubjects = new CompositeCommand(req.getLabel());
		withResubjects.add(basicMove);
		for (Object next : req.getElementsToMove().keySet()) {
			EObject nextMoved = (EObject) next;
			if (nextMoved instanceof UseCase) {
				UseCase useCase = (UseCase) nextMoved;
				EObject actualContainer = reqImpl.getActualContainer(useCase);
				if (actualContainer instanceof Classifier && useCase.getSubjects().contains(actualContainer)) {
					List<Classifier> newSubjects = new LinkedList<Classifier>();
					newSubjects.addAll(useCase.getSubjects());
					newSubjects.remove((Classifier) actualContainer);

					SetRequest resetSubject = new SetRequest(req.getEditingDomain(), useCase, UMLPackage.eINSTANCE.getUseCase_Subject(), newSubjects);
					withResubjects.add(new SetValueCommand(resetSubject));
				}
			}
		}
		return withResubjects.reduce();
	}
}
