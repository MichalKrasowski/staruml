/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 */

package org.eclipse.uml2.diagram.profile.parser.extension;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.parser.assist.FixedSetCompletionProcessor;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class RequiredExtensionParser implements ISemanticParser {
	private final static String IS_REQUIRED = "{required}"; //$NON-NLS-1$
	private final static String NOT_REQUIRED = ""; //$NON-NLS-1$
	
	private final static String PROPOSAL_IS_REQUIRED = IS_REQUIRED;
	private final static String PROPOSAL_NOT_REQUIRED = "{}"; //$NON-NLS-1$

	private final FixedSetCompletionProcessor myCompletionProcessor = new FixedSetCompletionProcessor(PROPOSAL_IS_REQUIRED, PROPOSAL_NOT_REQUIRED);	

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		myCompletionProcessor.setContext(doAdapt(element));
		return myCompletionProcessor;
	}
	
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		if (element instanceof Extension == false) {
			return Collections.EMPTY_LIST;
		}
		LinkedList<EObject> result = new LinkedList<EObject>();
		Extension extension = (Extension)element;
		result.add(extension);
		ExtensionEnd parsed = ((ExtensionEnd) extension.getOwnedEnds().get(0));
		result.add(parsed);
		ValueSpecification lower = parsed.getLowerValue();
		if (lower != null) {
			result.add(lower);
		}
		return result;
	}

	public String getEditString(IAdaptable element, int flags) {
		return getIsRequiredString(element, PROPOSAL_NOT_REQUIRED);
	}

	public String getPrintString(IAdaptable element, int flags) {
		return getIsRequiredString(element, NOT_REQUIRED);
	}
	
	private String getIsRequiredString(IAdaptable element, String whenNotRequired){
		Extension elementImport = doAdapt(element);
		return (elementImport != null && elementImport.isRequired()) ? PROPOSAL_IS_REQUIRED : whenNotRequired;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		Extension extension = doAdapt(element);
		boolean isRequired = IS_REQUIRED.equals(newString);
		if (extension.isRequired() == isRequired) {
			return UnexecutableCommand.INSTANCE;
		}
		int value = isRequired ? 1: 0;
		return new SetValueCommand(new SetRequest((ExtensionEnd) extension.getOwnedEnds().get(0), UMLPackage.eINSTANCE.getMultiplicityElement_Lower(), value));
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return isAffectingEvent(listener, 0);
	}

	public boolean isAffectingEvent(Object notification, int flags) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			return UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(feature) || UMLPackage.eINSTANCE.getLiteralInteger_Value().equals(feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}
	
	private Extension doAdapt(IAdaptable adaptable) {
		//CCE intentionally allowed -- should be checked externally
		return (Extension)adaptable.getAdapter(EObject.class);
	}

}
