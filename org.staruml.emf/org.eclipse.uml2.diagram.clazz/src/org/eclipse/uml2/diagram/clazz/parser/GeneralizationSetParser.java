package org.eclipse.uml2.diagram.clazz.parser;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.uml2.diagram.parser.assist.FixedSetCompletionProcessor;
import org.eclipse.uml2.uml.UMLPackage;

public class GeneralizationSetParser extends MessageFormatParser {

	private static final String COMPLETE = "complete"; //$NON-NLS-1$

	private static final String INCOMPLETE = "incomplete"; //$NON-NLS-1$

	private static final String DISJOINT = "disjoint"; //$NON-NLS-1$

	private static final String OVERLAPPING = "overlapping"; //$NON-NLS-1$

	private static final EAttribute[] features = new EAttribute[] {
		UMLPackage.eINSTANCE.getGeneralizationSet_IsCovering(),
		UMLPackage.eINSTANCE.getGeneralizationSet_IsDisjoint(),
	};

	public GeneralizationSetParser() {
		super(features);
		setViewPattern("{0}, {1}"); //$NON-NLS-1$
		setEditPattern("{0}, {1}"); //$NON-NLS-1$
	}
	
	@Override
	protected Object getValue(EObject element, EAttribute feature) {
		Object value = element.eGet(feature);
		if (UMLPackage.eINSTANCE.getGeneralizationSet_IsCovering().equals(feature)) {
			return Boolean.TRUE.equals(value) ? COMPLETE : INCOMPLETE;
		}
		if (UMLPackage.eINSTANCE.getGeneralizationSet_IsDisjoint().equals(feature)) {
			return Boolean.TRUE.equals(value) ? DISJOINT : OVERLAPPING;
		}
		return super.getValue(element, feature);
	}
	
	@Override
	protected Object getValidNewValue(EAttribute feature, Object value) {
		if (UMLPackage.eINSTANCE.getGeneralizationSet_IsCovering().equals(feature)) {
			return COMPLETE.equals(value);
		}
		if (UMLPackage.eINSTANCE.getGeneralizationSet_IsDisjoint().equals(feature)) {
			return DISJOINT.equals(value);
		}
		return super.getValidNewValue(feature, value);
	}
	
	@Override
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return new FixedSetCompletionProcessor(COMPLETE, INCOMPLETE, DISJOINT, OVERLAPPING);
	}
}
