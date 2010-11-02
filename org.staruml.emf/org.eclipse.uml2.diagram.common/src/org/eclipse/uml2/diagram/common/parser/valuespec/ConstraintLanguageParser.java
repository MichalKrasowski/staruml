/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.parser.valuespec;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class ConstraintLanguageParser implements ISemanticParser {
	private static final Set<EStructuralFeature> ourFeatures; 
	static {
		HashSet<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getConstraint_Specification());
		features.add(UMLPackage.eINSTANCE.getOpaqueExpression_Language());
		ourFeatures = Collections.unmodifiableSet(features);
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return isAffectingEvent(notification, 0);
	}

	public boolean isAffectingEvent(Object notification, int flags) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			return ourFeatures.contains(feature);
		}
		return false;
	}

	public List<?> getSemanticElementsBeingParsed(EObject element) {
		if (false == element instanceof Constraint) {
			return Collections.emptyList();
		}
		ValueSpecification spec = ((Constraint) element).getSpecification();
		return spec == null ? Collections.emptyList() : Collections.singletonList(spec);
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		ValueSpecification specification = getValueSpecification(element);
		if (specification == null) {
			return StringStatics.BLANK;
		}
		UMLSwitch<String> valueSwitch = new UMLSwitch<String>() {

			@Override
			public String caseOpaqueExpression(OpaqueExpression object) {
				EList<String> lans = object.getLanguages();
				if (!lans.isEmpty()) {
					return lans.get(0);
				}
				return StringStatics.BLANK;
			}

			@Override
			public String defaultCase(EObject object) {
				return StringStatics.BLANK;
			}

		};
		return valueSwitch.doSwitch(specification);
	}

	public ICommand getParseCommand(IAdaptable element, final String newString, int flags) {
		final ValueSpecification vs = getValueSpecification(element);
		if (vs == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (newString == null) {
			return UnexecutableCommand.INSTANCE;
		}
		UMLSwitch<ICommand> valueSwitch = new UMLSwitch<ICommand>() {

			@Override
			public ICommand caseOpaqueExpression(OpaqueExpression object) {
				List<String> language;
				if (newString == null || "".equals(newString)) { //$NON-NLS-1$
					language = Collections.emptyList();
				} else {
					language = Collections.singletonList(newString);
				}
				return new SetValueCommand(new SetRequest(vs, UMLPackage.eINSTANCE.getOpaqueExpression_Language(), language));
			}

			@Override
			public ICommand defaultCase(EObject object) {
				return UnexecutableCommand.INSTANCE;
			}

		};

		return valueSwitch.doSwitch(vs);
	}

	public String getPrintString(IAdaptable element, int flags) {
		String str = getEditString(element, flags);
		if (str != null && !"".equals(str)) { //$NON-NLS-1$
			return String.format("{%1$s}", str); //$NON-NLS-1$
		}
		return str;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	protected ValueSpecification getValueSpecification(IAdaptable adaptable) {
		Constraint is = (Constraint) adaptable.getAdapter(EObject.class);
		return is.getSpecification();
	}

}
