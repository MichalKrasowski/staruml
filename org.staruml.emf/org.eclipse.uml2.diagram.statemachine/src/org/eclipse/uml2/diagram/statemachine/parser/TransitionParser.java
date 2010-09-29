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

package org.eclipse.uml2.diagram.statemachine.parser;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.uml2.diagram.common.parser.events.EventParserUtil;
import org.eclipse.uml2.diagram.common.parser.valuespec.ValueSpecificationParserUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class TransitionParser implements IParser {
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return getPrintString(element, flags);
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		EObject adaptedElement = (EObject) element.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(adaptedElement);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransitionHandler handler = new TransitionHandler(newString);
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
		
		ICommand setTriggersCommand = getSetTriggersCommand(adaptedElement, handler.getTriggers());
		if (setTriggersCommand != null) {
			command.compose(setTriggersCommand);
		}
		ICommand setGuardCommand = getSetGuardCommand(adaptedElement, handler.getGuard());
		if (setGuardCommand != null) {
			command.compose(setGuardCommand);
		}
		ICommand setEffectCommand = getSetEffectCommand(adaptedElement, handler.getEffect());
		if (setEffectCommand != null) {
			command.compose(setEffectCommand);
		}
		
		return command;
	}

	public String getPrintString(IAdaptable element, int flags) {
		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if (eObject instanceof Transition) {
			Transition transition = (Transition) eObject;
			StringBuffer printStringBuffer = new StringBuffer(20);
			
			EList<Trigger> triggers = transition.getTriggers();
			for (Iterator<Trigger> triggersIterator = triggers.iterator(); triggersIterator.hasNext();) {
				Trigger trigger = triggersIterator.next();
				printStringBuffer.append(EventParserUtil.getEditString(trigger.getEvent()));
				if (triggersIterator.hasNext()) {
					printStringBuffer.append(',');
				}
			}
			
			Constraint guard = transition.getGuard();
			if (guard != null) {
				ValueSpecification specification = guard.getSpecification();
				if (specification != null) {
					printStringBuffer.append('[');
					printStringBuffer.append(ValueSpecificationParserUtil.getEditString(specification));
					printStringBuffer.append(']');
				}
			}
			
			Behavior effect = transition.getEffect();
			if (effect != null) {
				printStringBuffer.append('/');
				printStringBuffer.append(effect.getLabel());
			}
			
			return printStringBuffer.toString();
		}
		return ""; //$NON-NLS-1$
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			return UMLPackage.eINSTANCE.getTransition_Trigger().equals(feature) ||
				UMLPackage.eINSTANCE.getTransition_Guard().equals(feature) ||
				UMLPackage.eINSTANCE.getTransition_Effect().equals(feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}
	
	private ICommand getSetTriggersCommand(EObject element, List<String> triggerNotations) {
		if (triggerNotations.isEmpty()) {
			return null;
		}
		
		List<Trigger> triggers = new LinkedList<Trigger>();
		for (Iterator<String> triggersIterator = triggerNotations.iterator(); triggersIterator.hasNext();) {
			String triggerNotation = triggersIterator.next();
			Trigger trigger = (Trigger) getTriggerProvider().findElement(element, triggerNotation);
			if (trigger != null) {
				triggers.add(trigger);
			}
		}
		if (triggers.isEmpty()) {
			return null;
		}
		return new SetValueCommand(new SetRequest(element, UMLPackage.eINSTANCE.getTransition_Trigger(), triggers));
	}
	
	private ICommand getSetGuardCommand(EObject element, String guardNotation) {
		if (guardNotation == null) {
			return null;
		}
		
		Constraint guard = (Constraint) getGuardProvider().findElement(element, guardNotation);
		if (guard == null) {
			return null;
		}
		return new SetValueCommand(new SetRequest(element, UMLPackage.eINSTANCE.getTransition_Guard(), guard));
	}
	
	private ICommand getSetEffectCommand(EObject element, String effectNotation) {
		if (effectNotation == null) {
			return null;
		}
		
		Behavior effect = (Behavior) getEffectProvider().findElement(element, effectNotation);
		if (effect == null) {
			return null;
		}
		return new SetValueCommand(new SetRequest(element, UMLPackage.eINSTANCE.getTransition_Effect(), effect));
	}
	
	private ElementProvider getTriggerProvider() {
		if (triggerProvider == null) {
			triggerProvider = new TriggerProvider();
		}
		return triggerProvider;
	}
	
	
	private ElementProvider getGuardProvider() {
		if (guardProvider == null) {
			guardProvider = new GuardProvider();
		}
		return guardProvider;
	}
	
	
	public ElementProvider getEffectProvider() {
		if (effectProvider == null) {
			effectProvider = new BehaviorProvider();
		}
		return effectProvider;
	}
	
	private ElementProvider triggerProvider;
	private ElementProvider guardProvider;
	private ElementProvider effectProvider;
	
	private static class BehaviorProvider extends ElementProvider {
		@Override
		protected boolean isSuitable(Object object) {
			return object instanceof Behavior;
		}
	}
	
	private static class GuardProvider extends ElementProvider {
		@Override
		protected String getDisplayProposal(NamedElement element) {
			if (element instanceof Constraint) {
				ValueSpecification specification = ((Constraint) element).getSpecification();
				if (specification != null) {
					return ValueSpecificationParserUtil.getEditString(specification);
				}
			}
			return super.getDisplayProposal(element);
		}
		
		@Override
		protected boolean isSuitable(Object object) {
			return object instanceof Constraint;
		}
	}
	
	private static class TriggerProvider extends ElementProvider {
		@Override
		protected String getDisplayProposal(NamedElement element) {
			if (element instanceof Trigger) {
				Event event = ((Trigger) element).getEvent();
				if (event != null) {
					return EventParserUtil.getEditString(event);
				}
			}
			return super.getDisplayProposal(element);
		}
		
		@Override
		protected boolean isSuitable(Object object) {
			return object instanceof Trigger;
		}
	}
	
	private static class TransitionHandler {
		public TransitionHandler(String notation) {
			triggers = new LinkedList<String>();
			handle(notation);
		}
		
		public List<String> getTriggers() {
			return triggers;
		}
		
		public String getGuard() {
			return guard;
		}
		
		public String getEffect() {
			return effect;
		}
		
		private void handle(String notation) {
			int effectPosition =  notation.indexOf(EFFECT_SEPARATOR);
			if (effectPosition >= 0) {
				effect = notation.substring(effectPosition + 1);
				notation = notation.substring(0, effectPosition);
			}
			int guardLEPosition = notation.indexOf(GUARD_LEADING_EDGE);
			if (guardLEPosition >= 0) {
				int guardTEPosition = notation.indexOf(GUARD_TRAILING_EDGE); 
				if (guardTEPosition > 0 && guardTEPosition > guardLEPosition) {
					guard = notation.substring(guardLEPosition + 1, guardTEPosition);
					notation = notation.substring(0, guardLEPosition);
				}
			}
			if (notation.length() > 0) {
				StringTokenizer tokenizer = new StringTokenizer(notation, ","); //$NON-NLS-1$
				while (tokenizer.hasMoreElements()) {
					triggers.add(tokenizer.nextToken());
				}
			}
		}
		
		private static final String EFFECT_SEPARATOR = "/"; //$NON-NLS-1$
		private static final String GUARD_LEADING_EDGE = "["; //$NON-NLS-1$
		private static final String GUARD_TRAILING_EDGE = "]"; //$NON-NLS-1$
		
		private List<String> triggers;
		private String guard;
		private String effect;
	}
}
