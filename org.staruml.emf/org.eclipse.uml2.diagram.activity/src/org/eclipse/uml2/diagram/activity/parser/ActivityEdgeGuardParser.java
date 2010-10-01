/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.activity.parser;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.common.parser.ElementProvider;
import org.eclipse.uml2.diagram.common.parser.valuespec.ValueSpecificationParserUtil;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;


public class ActivityEdgeGuardParser implements IParser {
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if (!(eObject instanceof ActivityEdge)) {
			return ""; //$NON-NLS-1$
		}
		ValueSpecification guard = ((ActivityEdge) eObject).getGuard();
		if (guard == null) {
			return ""; //$NON-NLS-1$
		}
		return ValueSpecificationParserUtil.getEditString(guard);
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		ValueSpecification guard = (ValueSpecification) getElementProvider().findElement(adaptToEObject(element), newString);
		if (guard == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return new SetValueCommand(new SetRequest(adaptToEObject(element), 
				UMLPackage.eINSTANCE.getActivityEdge_Guard(), guard));
	}

	public String getPrintString(IAdaptable element, int flags) {
		String editString = getEditString(element, flags);
		if (editString == null || editString.trim().length() == 0) {
			return ""; //$NON-NLS-1$
		}
		StringBuffer printString = new StringBuffer(editString.length() + 2);
		printString.append('[');
		printString.append(editString);
		printString.append(']');
		return printString.toString();
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			return UMLPackage.eINSTANCE.getActivityEdge_Guard().equals(feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}
	
	private ElementProvider getElementProvider() {
		if (elementProvider == null) {
			elementProvider = new ValueSpecificationProvider();
		}
		return elementProvider;
	}
	
	private EObject adaptToEObject(IAdaptable adaptable) {
		return (EObject) adaptable.getAdapter(EObject.class);
	}
	
	private ElementProvider elementProvider;
	
	private static class ValueSpecificationProvider extends ElementProvider {
		@Override
		protected String getDisplayProposal(NamedElement element) {
			if (element instanceof ValueSpecification) {
				return ValueSpecificationParserUtil.getEditString((ValueSpecification) element);
			}
			return super.getDisplayProposal(element);
		}
		
		@Override
		protected boolean isSuitable(Object object) {
			return object instanceof ValueSpecification;
		}
	}
}
