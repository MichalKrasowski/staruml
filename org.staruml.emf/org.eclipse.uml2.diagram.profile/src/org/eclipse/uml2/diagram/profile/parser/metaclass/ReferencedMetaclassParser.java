/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.profile.parser.metaclass;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.parser.assist.EObjectCompletionProcessor;
import org.eclipse.uml2.diagram.profile.part.CustomMessages;
import org.eclipse.uml2.diagram.profile.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.UMLPackage;

public class ReferencedMetaclassParser implements ISemanticParser {
	private final MetaclassesList myMetaclassesList = new MetaclassesList();
	private final CompletionProcessor myCompletionProcessor = new CompletionProcessor();
	private final static String NO_METACLASS = CustomMessages.ReferencedMetaclassParser_no_metaclass;

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		myCompletionProcessor.setContext(doAdapt(element));
		return myCompletionProcessor;
	}
	
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			return UMLPackage.eINSTANCE.getElementImport_ImportedElement().equals(feature);
		}
		return false;
	}

	public List<?> getSemanticElementsBeingParsed(EObject element) {
		return Collections.singletonList(element);
	}

	public String getEditString(IAdaptable element, int flags) {
		return getPrintString(element, flags);
	}

	public String getPrintString(IAdaptable element, int flags) {
		ElementImport elementImport = doAdapt(element);
		String result = null;
		if (elementImport != null){
			result = elementImport.getName();
		}
		return result == null ? NO_METACLASS : result;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		org.eclipse.uml2.uml.Class metaclass = findMetaclass(element, newString);
		if (metaclass == null) {
			return UnexecutableCommand.INSTANCE;
		}
		ElementImport elementImport = doAdapt(element);
		if (metaclass.equals(elementImport.getImportedElement())){
			return UnexecutableCommand.INSTANCE;
		}
		return new ReplaceReferencedMetaclassCommand(elementImport, metaclass); 
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		Classifier metaclass = findMetaclass(element, editString);
		if (metaclass == null) {
			return new ParserEditStatus(IStatus.ERROR, UMLDiagramEditorPlugin.ID, ParserEditStatus.UNEDITABLE, "Unknown metaclass: " + editString, null); //$NON-NLS-1$
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}
	
	private org.eclipse.uml2.uml.Class findMetaclass(IAdaptable parserElement, String editString){
		if (editString == null){
			return null;
		}
		editString = editString.trim();
		if (editString.length() == 0){
			return null;
		}
		return myMetaclassesList.findElement(doAdapt(parserElement), editString);
	}
	
	private ElementImport doAdapt(IAdaptable adaptable) {
		//intentionally CCE
		ElementImport elementImport = (ElementImport)adaptable.getAdapter(EObject.class);
		return elementImport;
	}
	
	private class CompletionProcessor extends EObjectCompletionProcessor {
		@Override
		protected Iterable<String> computeContextProposals(EObject context) {
			return myMetaclassesList.getElementNames(context);
		}
	}

}
