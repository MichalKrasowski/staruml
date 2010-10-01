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

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.common.parser.ElementProvider;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;


public class ObjectNodeAttributesParser implements ISemanticParser {
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return isAffectingEvent(notification, 0);
	}

	public List<?> getSemanticElementsBeingParsed(EObject eObject) {
		return Collections.singletonList(eObject);
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if (!(eObject instanceof ObjectNode)) {
			return ""; //$NON-NLS-1$
		}

		ObjectNode objectNode = (ObjectNode) eObject;
			
		StringBuffer result = new StringBuffer();
		ObjectNodeOrderingKind ordering = objectNode.getOrdering();
		if (!ObjectNodeOrderingKind.FIFO_LITERAL.equals(ordering)) {
			result.append(ORDERING_ATTRIBUTE + "="); //$NON-NLS-1$
			result.append(ordering.getName());
		}
		boolean isControlType = objectNode.isControlType();
		if (isControlType) {
			if (result.length() > 0) {
				result.append(',');
			}
			result.append(CONTROL_TYPE_ATTRIBUTE + "=true"); //$NON-NLS-1$
		}
		ValueSpecification upperBounds = objectNode.getUpperBound();
		if (upperBounds != null) {
			if (result.length() > 0) {
				result.append(',');
			}
			result.append(UPPER_BOUND_ATTRIBUTE + "="); //$NON-NLS-1$
			result.append(upperBounds.stringValue()); 
		}
		return result.toString();
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		CompositeCommand resultCommand = new CompositeCommand(StringStatics.BLANK);
		StringTokenizer tokenizer = new StringTokenizer(newString, ","); //$NON-NLS-1$
		while (tokenizer.hasMoreElements()) {
			String token = tokenizer.nextToken();
			int equalityPosition = token.indexOf("="); //$NON-NLS-1$
			String key = token.substring(0, equalityPosition);
			String value = token.substring(equalityPosition + 1);
			if (ORDERING_ATTRIBUTE.equals(key)) {
				resultCommand.add(new SetValueCommand(new SetRequest(adaptToEObject(element), 
						UMLPackage.eINSTANCE.getObjectNode_Ordering(), ObjectNodeOrderingKind.get(value))));
			} else if (CONTROL_TYPE_ATTRIBUTE.equals(key)) {
				resultCommand.add(new SetValueCommand(new SetRequest(adaptToEObject(element), 
						UMLPackage.eINSTANCE.getObjectNode_IsControlType(), Boolean.parseBoolean(value))));
			} else if (UPPER_BOUND_ATTRIBUTE.equals(key)) {
				NamedElement foundElement = getElementProvider().findElement(adaptToEObject(element), value);
				if (foundElement != null && foundElement instanceof ValueSpecification) {
					resultCommand.add(new SetValueCommand(new SetRequest(adaptToEObject(element), 
							UMLPackage.eINSTANCE.getObjectNode_UpperBound(), foundElement)));
				}
			}
		}
		return resultCommand;
	}

	public String getPrintString(IAdaptable element, int flags) {
		StringBuffer result = new StringBuffer(getEditString(element, flags));
		if (result.length() > 0) {
			result.insert(0, '{');
			result.append('}');
		}
		return result.toString();
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			return UMLPackage.eINSTANCE.getObjectNode_Ordering().equals(feature) ||
				UMLPackage.eINSTANCE.getObjectNode_IsControlType().equals(feature) ||
				UMLPackage.eINSTANCE.getObjectNode_UpperBound().equals(feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		StringTokenizer tokenizer = new StringTokenizer(editString, ","); //$NON-NLS-1$
		while (tokenizer.hasMoreElements()) {
			String token = tokenizer.nextToken();
			if (!token.contains("=")) { //$NON-NLS-1$
				return new ParserEditStatus(IStatus.ERROR, PLUGIN_ID, ParserEditStatus.UNEDITABLE, "Equals sign is not found in one of attributes", null);
			}
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}

	private EObject adaptToEObject(IAdaptable adaptable) {
		return (EObject) adaptable.getAdapter(EObject.class);
	}
	
	private ElementProvider getElementProvider() {
		if (elementProvider == null) {
			elementProvider = new ElementProvider();
		}
		return elementProvider;
	}
	
	private static final String ORDERING_ATTRIBUTE = "ordering"; //$NON-NLS-1$
	private static final String CONTROL_TYPE_ATTRIBUTE = "isControlType"; //$NON-NLS-1$
	private static final String UPPER_BOUND_ATTRIBUTE = "upperBound"; //$NON-NLS-1$
	
	private static final String PLUGIN_ID = "org.eclipse.uml2.diagram.activity"; //$NON-NLS-1$

	private ElementProvider elementProvider;
}
