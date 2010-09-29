/*
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.csd.parser.collaborationuse;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.csd.part.CustomMessages;
import org.eclipse.uml2.diagram.parser.assist.FixedSetCompletionProcessor;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.icu.text.MessageFormat;

public class CollaborationUseParser implements ISemanticParser {
	
	private static final MessageFormat COLLABORATION_USE_FORMAT = new MessageFormat("{0}:{1}");  //$NON-NLS-1$

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			return UMLPackage.eINSTANCE.getCollaborationUse_Type().equals(feature) || UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature);
		}
		return false;
	}

	public List<?> getSemanticElementsBeingParsed(EObject eObject) {
		return Collections.singletonList(eObject);
	}

	// TODO add types from the loaded resources
	// traverse deep into the nested packages
	public IContentAssistProcessor getCompletionProcessor(IAdaptable subject) {
		CollaborationUse cu = doAdapt(subject);
		String name = cu.getName() == null ? "" : cu.getName(); //$NON-NLS-1$
		List<Type> types = getTypeProposals(cu);
		LinkedList<String> names = new LinkedList<String>();
		for (Type next : types) {
			names.add(COLLABORATION_USE_FORMAT.format(new Object[]{name, next.getName()}));
		}
		FixedSetCompletionProcessor cp = new FixedSetCompletionProcessor(names);
		cp.setContext(cu);
		return cp;
	}

	public String getEditString(IAdaptable element, int flags) {
		CollaborationUse cu = doAdapt(element);
		String name = cu.getName() == null ? "" : cu.getName(); //$NON-NLS-1$
		String type = cu.getType() == null ? "" : cu.getType().getName(); //$NON-NLS-1$
		return COLLABORATION_USE_FORMAT.format(new Object[]{name, type});
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		CollaborationUse cu = doAdapt(element);
		if (cu == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (newString == null) {
			return UnexecutableCommand.INSTANCE;
		}
		Collaboration oldType = cu.getType();
		String oldName = cu.getName() == null ? "" : cu.getName(); //$NON-NLS-1$
		List<Type> types = getTypeProposals(cu);
		try {
			Object[] parsed = COLLABORATION_USE_FORMAT.parse(newString);
			String newName = (String) parsed[0];
			CompositeCommand cc = new CompositeCommand(CustomMessages.CollaborationUseParser_collaboration_use_name_parser_command);
			if (!oldName.equals(newName)) {
				cc.add(new SetValueCommand(new SetRequest(cu, UMLPackage.eINSTANCE.getNamedElement_Name(), newName)));
			}
			if (parsed.length < 2) {
				return cc;
			}
			String newType = (String) parsed[1];
			for (Type next : types) {
				if (newType.equals(next.getName()) && !newType.equals(oldType)) {
					cc.add(new SetValueCommand(new SetRequest(cu, UMLPackage.eINSTANCE.getCollaborationUse_Type(), next)));
					break;
				}
			}
			return cc;
		} catch (ParseException e) {
		}
		return UnexecutableCommand.INSTANCE;
	}

	public String getPrintString(IAdaptable element, int flags) {
		return getEditString(element, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	private CollaborationUse doAdapt(IAdaptable adaptable) {
		CollaborationUse cu = (CollaborationUse) adaptable.getAdapter(EObject.class);
		return cu;
	}

	private List<Type> getTypeProposals(CollaborationUse cu) {
		EObject root = cu.eContainer();
		while(root.eContainer() != null) {
			root = root.eContainer();
		}
		if (false == root instanceof org.eclipse.uml2.uml.Package) {
			return Collections.<Type>emptyList();
		}
		List<Type> types = new LinkedList<Type>();
		for (Type next : ((org.eclipse.uml2.uml.Package)root).getOwnedTypes()) {
			types.add(next);
		}
		return types;
	}

}
