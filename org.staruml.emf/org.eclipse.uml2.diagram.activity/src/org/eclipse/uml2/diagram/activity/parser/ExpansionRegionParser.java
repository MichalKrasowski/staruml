/*
 * Copyright (c) 2008 Borland Software Corporation
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
import org.eclipse.uml2.uml.ExpansionKind;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.UMLPackage;


public class ExpansionRegionParser  implements IParser {
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if (eObject instanceof ExpansionRegion) {
			ExpansionKind mode = ((ExpansionRegion) eObject).getMode();
			return mode.getLiteral();
		}
		return ""; //$NON-NLS-1$
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		ExpansionKind mode = ExpansionKind.get(newString);
		if (mode == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return new SetValueCommand(new SetRequest(adaptToEObject(element), 
				UMLPackage.eINSTANCE.getExpansionRegion_Mode(), mode));
	}

	public String getPrintString(IAdaptable element, int flags) {
		StringBuffer result = new StringBuffer(getEditString(element, flags));
		if (result.length() > 0) {
			result.insert(0, "\u00AB"); //$NON-NLS-1$
			result.append("\u00BB"); //$NON-NLS-1$
		}
		return result.toString();
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			return UMLPackage.eINSTANCE.getExpansionRegion_Mode().equals(feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		if (ExpansionKind.get(editString) == null) {
			return ParserEditStatus.UNEDITABLE_STATUS;
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}

	private EObject adaptToEObject(IAdaptable adaptable) {
		return (EObject) adaptable.getAdapter(EObject.class);
	}
}
