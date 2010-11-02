/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.parser.events;

import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.parser.valuespec.ValueSpecificationParserUtil;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class EventParserUtil {
	public static String getEditString(Event event) {
		UMLSwitch<String> eventSwitch = new UMLSwitch<String>() {
			@Override
			public String caseCallEvent(CallEvent callEvent) {
				String name = callEvent.getName();
				if (name == null) {
					return super.caseCallEvent(callEvent);
				}
				return name;
			}
			
			@Override
			public String caseSignalEvent(SignalEvent signalEvent) {
				String name = signalEvent.getName();
				if (name == null) {
					return super.caseSignalEvent(signalEvent);
				}
				return name;
			}
			
			@Override
			public String caseAnyReceiveEvent(AnyReceiveEvent anyReceiveEvent) {
				return Messages.EventParser_any_receive_event_denotation;
			}
			
			@Override
			public String caseTimeEvent(TimeEvent timeEvent) {
				StringBuffer timeEventDenotation = new StringBuffer();
				if (timeEvent.isRelative()) {
					timeEventDenotation.append(Messages.EventParser_time_event_relative_denotation_prefix);
				} else {
					timeEventDenotation.append(Messages.EventParser_time_event_absolute_denotation_prefix);
				}
				timeEventDenotation.append('(');
				TimeExpression when = timeEvent.getWhen();
				if (when != null) {
					timeEventDenotation.append(ValueSpecificationParserUtil.getEditString(when));
				}
				timeEventDenotation.append(')');
				return timeEventDenotation.toString();
			}
			
			@Override
			public String caseChangeEvent(ChangeEvent changeEvent) {
				StringBuffer changeEventDenotation = new StringBuffer();
				changeEventDenotation.append(Messages.EventParser_change_event_denotation_prefix);
				changeEventDenotation.append('(');
				ValueSpecification changeExpression = changeEvent.getChangeExpression();
				if (changeExpression != null) {
					changeEventDenotation.append(ValueSpecificationParserUtil.getEditString(changeExpression));
				}
				changeEventDenotation.append(')');
				return changeEventDenotation.toString();
			}
		};
		return eventSwitch.doSwitch(event);
	}
}
