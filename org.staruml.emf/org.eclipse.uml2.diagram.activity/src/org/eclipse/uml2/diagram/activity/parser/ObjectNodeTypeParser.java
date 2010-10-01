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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.common.parser.ElementProvider;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


public class ObjectNodeTypeParser implements IParser {
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getPrintString(IAdaptable element, int flags) {
		return getEditString(element, flags);
	}

	public String getEditString(IAdaptable element, int flags) {
		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if (eObject instanceof ObjectNode) {
			StringBuffer printStringBuffer = new StringBuffer(20);
			ObjectNode objectNode = (ObjectNode) eObject;
			printStringBuffer.append(objectNode.getName());
			Type type = objectNode.getType();
			if (type != null && type instanceof NamedElement) {
				String typeName = ((NamedElement) type).getName();
				if (typeName != null && typeName.length() > 0) {
					printStringBuffer.append(NAME_TYPE_SEPARATOR);
					printStringBuffer.append(typeName);
				}
			}
			return printStringBuffer.toString();
		}
		return ""; //$NON-NLS-1$
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			return UMLPackage.eINSTANCE.getTypedElement_Type().equals(feature) ||
			UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		int equalityPosition = newString.indexOf(NAME_TYPE_SEPARATOR);
		if (equalityPosition == -1) {
			return getSetNameCommand(element, newString);
		}
		String name = newString.substring(0, equalityPosition);
		String type = newString.substring(equalityPosition + 1);

		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
		command.compose(getSetNameCommand(element, name));
		if (type != null) {
			ICommand setTypeCommand = getSetTypeCommand(element, type);
			if (setTypeCommand != null) {
				command.compose(setTypeCommand);
			}
		}
		return command;
	}

	private ICommand getSetNameCommand(EObject element, String name) {
		SetRequest request = new SetRequest(element, UMLPackage.eINSTANCE.getNamedElement_Name(), name);
		return new SetValueCommand(request);
	}

	private ICommand getSetTypeCommand(EObject element, String type) {
		Type typedElement = (Type) getElementProvider().findElement(element, type);
		if (typedElement == null) {
			return null;
		}
		SetRequest request = new SetRequest(element, UMLPackage.eINSTANCE.getTypedElement_Type(), typedElement);
		return new SetValueCommand(request);
	}
	
	private ElementProvider getElementProvider() {
		if (elementProvider == null) {
			elementProvider = new TypeElementProvider();
		}
		return elementProvider;
	}

	private static final String NAME_TYPE_SEPARATOR = ":"; //$NON-NLS-1$
	
	private ElementProvider elementProvider; 
	
	private static class TypeElementProvider extends ElementProvider {
		@Override
		protected boolean isSuitable(Object object) {
			return object instanceof Type;
		}		
	}
}
