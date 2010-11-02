/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.parser.stereotype;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.diagram.common.commands.ApplyStereotypeHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;

public class AppliedStereotypeParser implements ISemanticParser {

	private static final String APPLIED_PROFILE = "\u00AB{0}\u00BB"; //$NON-NLS-1$

	protected static final String STEREOTYPE_SEPARATOR = ","; //$NON-NLS-1$
	
	private static final String PLUGIN_ID = "org.eclipse.uml2.diagram.common"; //$NON-NLS-1$

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			if (feature instanceof EStructuralFeature) {
				EStructuralFeature featureImpl = (EStructuralFeature) feature;
				return featureImpl.getName().startsWith(Extension.METACLASS_ROLE_PREFIX);
			}
		}
		return false;
	}

	public List<?> getSemanticElementsBeingParsed(EObject eObject) {
		Element element = (Element) eObject;
		List<EObject> result = new LinkedList<EObject>();
		// result.add(element);
		result.addAll(element.getStereotypeApplications());
		return result;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable subject) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		Element subject = doAdapt(element);
		List<Stereotype> stereos = subject.getAppliedStereotypes();
		if (stereos.isEmpty()) {
			return ""; //$NON-NLS-1$
		}
		StringBuffer result = new StringBuffer();
		for (Stereotype next : stereos) {
			if (result.length() > 0) {
				result.append(STEREOTYPE_SEPARATOR + " "); //$NON-NLS-1$
			}
			result.append(next.getName());
		}
		return result.toString();
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		Element subject = doAdapt(element);
		List<String> toApply = getStereotypesToApply(newString);
		return ApplyStereotypeHelper.getCommand(subject, toApply);
	}

	public String getPrintString(IAdaptable element, int flags) {
		String classifier = getElementLabel(doAdapt(element));
		String editString = getEditString(element, flags);
		if (classifier != null) {
			String result = classifier;
			if (editString != null && editString.length() > 0) {
				result+=STEREOTYPE_SEPARATOR + StringStatics.SPACE + editString;
			}
			return NLS.bind(APPLIED_PROFILE, new Object[] { result });
		}
		return editString == null || editString.length() == 0 ? editString : NLS.bind(APPLIED_PROFILE, new Object[] { editString });
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		Element subject = doAdapt(element);
		List<String> toApply = getStereotypesToApply(editString);
		List<String> applicables = new ArrayList<String>();
		for (Stereotype stereo : subject.getApplicableStereotypes()) {
			applicables.add(stereo.getName());
		}
		for (String str : toApply) {
			if (false == applicables.contains(str)) {
				return new ParserEditStatus(IStatus.ERROR, PLUGIN_ID, ParserEditStatus.UNEDITABLE, "Unknown stereotype: " + str, null); //$NON-NLS-1$
			}
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}

	private static List<String> getStereotypesToApply(String editString) {
		StringTokenizer t = new StringTokenizer(editString, STEREOTYPE_SEPARATOR);
		List<String> toApply = new ArrayList<String>(t.countTokens());
		while (t.hasMoreTokens()) {
			toApply.add(t.nextToken().trim());
		}
		return toApply;
	}
	
	protected String getElementLabel(Element element) {
		return null;
	}

	protected Element doAdapt(IAdaptable adaptable) {
		Element element = (Element) adaptable.getAdapter(EObject.class);
		return element;
	}

}
