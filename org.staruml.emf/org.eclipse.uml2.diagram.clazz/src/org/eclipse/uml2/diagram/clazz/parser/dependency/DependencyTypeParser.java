/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 */

package org.eclipse.uml2.diagram.clazz.parser.dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.clazz.edit.commands.ChangeDependencyTypeCommand;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.parser.assist.FixedSetCompletionProcessor;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class DependencyTypeParser implements ISemanticParser {
	private final static String NOT_APPLICABLE = CustomMessages.DependencyTypeParser_not_applicable;
	private final static String LABEL_DEPENDENCY_SHORT = ""; //$NON-NLS-1$
	private final static String LABEL_DEPENDENCY_FULL = "dependency"; //$NON-NLS-1$
	private final static String LABEL_ABSTRACTION = "abstraction"; //$NON-NLS-1$
	private final static String LABEL_USAGE = "usage"; //$NON-NLS-1$
	private final static String LABEL_SUBSTITUTION = "substitute";	 //$NON-NLS-1$
	
	private final ViewSwitch myViewSwitch = new ViewSwitch();
	private final EditSwitch myEditSwitch = new EditSwitch();
	private HashMap<String, EClass> myEditStringToType;

	private final FixedSetCompletionProcessor myCompletionProcessor = new FixedSetCompletionProcessor(
			LABEL_DEPENDENCY_FULL, LABEL_ABSTRACTION, LABEL_SUBSTITUTION, LABEL_USAGE);	

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		myCompletionProcessor.setContext(doAdapt(element));
		return myCompletionProcessor;
	}
	
	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		if (element instanceof Dependency == false) {
			return Collections.emptyList();
		}
		ArrayList<EObject> result = new ArrayList<EObject>();
		result.add(element);
		result.add(element.eContainer());
		return result;
	}

	public String getEditString(IAdaptable element, int flags) {
		EObject dependency = doAdapt(element);
		return (dependency == null) ? NOT_APPLICABLE : getEditSwitch().doSwitch(dependency);
	}

	public String getPrintString(IAdaptable element, int flags) {
		EObject subject = doAdapt(element);
		return (subject == null) ? NOT_APPLICABLE : getViewSwitch().doSwitch(subject);
	}
	
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		EObject dependency = doAdapt(element);
		if (dependency == null) {
			return UnexecutableCommand.INSTANCE;
		}
		EClass type = getType(newString);
		if (dependency.eClass().equals(type)){
			return IdentityCommand.INSTANCE;
		}
		
		//XXX: adapter to EditPart is more logical here, see #158795
		ConnectionEditPart editPart = getSelectedEditPart();
		if (type == null || editPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return new CommandProxy(new ChangeDependencyTypeCommand(editPart, type));
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return isAffectingEvent(notification, 0);
	}

	public boolean isAffectingEvent(Object notification, int flags) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			return UMLPackage.eINSTANCE.getPackage_PackagedElement().equals(feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return getType(editString) == null ? ParserEditStatus.UNEDITABLE_STATUS : ParserEditStatus.EDITABLE_STATUS;
	}
	
	private EObject doAdapt(IAdaptable adaptable) {
		return (EObject)adaptable.getAdapter(EObject.class);
	}

	private EClass getType(String newString) {
		if (newString == null){
			newString = ""; //$NON-NLS-1$
		}
		newString = newString.trim();
		return getEditStringToTypeTable().get(newString);
	}

	private ConnectionEditPart getSelectedEditPart() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
		if (selection instanceof IStructuredSelection == false) {
			return null;
		}
		EditPart selected = ((EditPart) ((IStructuredSelection)selection).getFirstElement());
		if (selected instanceof LabelEditPart) {
			selected = selected.getParent();
		}
		return (selected instanceof ConnectionEditPart) ? (ConnectionEditPart)selected : null;
	}
	
	@SuppressWarnings("serial")
	private HashMap<String, EClass> getEditStringToTypeTable() {
		if (myEditStringToType == null) {
			myEditStringToType = new HashMap<String, EClass>(){
				@Override
				public EClass put(String key, EClass value) {
					EClass result = super.put(key, value);
					super.put(NLS.bind(QUOTE_FORMAT, new Object[]{key}), value);
					return result;
				}
			};
			myEditStringToType.put(LABEL_DEPENDENCY_FULL, UMLPackage.eINSTANCE.getDependency());
			myEditStringToType.put(LABEL_DEPENDENCY_SHORT, UMLPackage.eINSTANCE.getDependency());
			myEditStringToType.put(LABEL_ABSTRACTION, UMLPackage.eINSTANCE.getAbstraction());
			myEditStringToType.put(LABEL_SUBSTITUTION, UMLPackage.eINSTANCE.getSubstitution());
			myEditStringToType.put(LABEL_USAGE, UMLPackage.eINSTANCE.getUsage());
		}
		return myEditStringToType;
	}
	
	private UMLSwitch<String> getViewSwitch(){
		return myViewSwitch;
	}

	private UMLSwitch<String> getEditSwitch(){
		return myEditSwitch;
	}
	
	private static class EditSwitch extends UMLSwitch<String> {
		@Override
		public String defaultCase(EObject object) {
			return NOT_APPLICABLE;
		}

		@Override
		public String caseDependency(Dependency object) {
			return LABEL_DEPENDENCY_FULL;
		}
		
		@Override
		public String caseAbstraction(Abstraction object) {
			return quote(LABEL_ABSTRACTION);
		}
		
		@Override
		public String caseUsage(Usage object) {
			return quote(LABEL_USAGE);
		}
		
		@Override
		public String caseSubstitution(Substitution object) {
			return quote(LABEL_SUBSTITUTION);
		}
		
		protected String quote(String text){
			return text;
		}
	}
	
	private static class ViewSwitch extends EditSwitch {
		@Override
		protected String quote(String text) {
			 return NLS.bind(QUOTE_FORMAT, new Object[]{text});
		}
		
		@Override
		public String caseDependency(Dependency object) {
			return LABEL_DEPENDENCY_SHORT;
		}
	}
	
	private static final String QUOTE_FORMAT = "\u00AB{0}\u00BB"; //$NON-NLS-1$

}
