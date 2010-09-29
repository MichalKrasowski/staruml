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
public class ComponentEditHelper extends UMLBaseEditHelper {

	@Override
	protected ICommand getMoveCommand(MoveRequest req) {
		ICommand basicMove = super.getMoveCommand(req);
		if (basicMove == null) {
			return null;
		}
		if (false == req.getTargetContainer() instanceof Classifier) {
			//wow???
			return basicMove;
		}

		Classifier subject = (Classifier) req.getTargetContainer();
		final List<UseCase> usecases = new LinkedList<UseCase>(); //we will pass this list into request and modify it inside loop 
		usecases.addAll(subject.getUseCases());
		SetRequest addUsecase = new SetRequest(req.getEditingDomain(), subject, UMLPackage.eINSTANCE.getClassifier_UseCase(), usecases);

		CompositeCommand withResubjects = new CompositeCommand(req.getLabel());
		withResubjects.add(basicMove);
		withResubjects.add(new SetValueCommand(addUsecase));

		for (Object next : req.getElementsToMove().keySet()) {
			EObject nextMoved = (EObject) next;
			if (nextMoved instanceof UseCase) {
				UseCase nextUseCase = (UseCase) nextMoved;
				if (!usecases.contains(nextUseCase)) {
					usecases.add(nextUseCase);
				}
				if (req instanceof MoveRequestWithParentInfo) {
					MoveRequestWithParentInfo reqImpl = (MoveRequestWithParentInfo) req;
					EObject actualContainer = reqImpl.getActualContainer(nextUseCase);
					if (actualContainer instanceof Classifier && actualContainer != subject) {
						Classifier oldSubject = (Classifier) actualContainer;
						List<Classifier> newSubjects = new LinkedList<Classifier>();
						newSubjects.addAll(nextUseCase.getSubjects());
						newSubjects.remove(oldSubject);
						//this command will be executed after the subject.setUseCases(), so we need to add new subject again
						newSubjects.add(subject);
						SetRequest changeSubject = new SetRequest(req.getEditingDomain(), nextUseCase, UMLPackage.eINSTANCE.getUseCase_Subject(), newSubjects);
						withResubjects.add(new SetValueCommand(changeSubject));
					}
				}
			}
		}
		return withResubjects.reduce();
	}
}
