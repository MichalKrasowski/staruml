package org.eclipse.uml2.diagram.sequence.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDCombinedFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDEntity;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionOperand;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionUse;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDSimpleNode;
import org.eclipse.uml2.diagram.sequence.model.sequenced.util.SDSwitch;
import org.eclipse.uml2.uml.NamedElement;

public class UserFormat extends SDSwitch<String> {
	public static final UserFormat INSTANCE = new UserFormat();

	private static final String UNSET = "<unset>";
	
	public String format(EObject theEObject){
		return doSwitch(theEObject);
	}

	@Override
	public String doSwitch(EObject theEObject) {
		return theEObject == null ? UNSET : super.doSwitch(theEObject);
	}

	@Override
	public String caseSDEntity(SDEntity object) {
		return "Unknown SD entity: " + object;
	}

	@Override
	public String caseSDBehaviorSpec(SDBehaviorSpec object) {
		return "Behavior spec " + safeGetName(object.getUmlExecutionSpec());
	}

	@Override
	public String caseSDLifeLine(SDLifeLine object) {
		return "Lifeline " + safeGetName(object.getUmlLifeline());
	}

	@Override
	public String caseSDAbstractMessage(SDAbstractMessage object) {
		return "Message " + safeGetName(object.getUmlMessage());
	}

	@Override
	public String caseSDModel(SDModel object) {
		return "Interaction " + safeGetName(object.getUmlInteraction());
	}

	@Override
	public String caseSDGate(SDGate object) {
		return "Gate " + safeGetName(object.getUmlGate());
	}

	@Override
	public String caseSDCombinedFragment(SDCombinedFragment object) {
		return "Combined Fragment " + safeGetName(object.getUmlCombinedFragment());
	}

	@Override
	public String caseSDInteractionOperand(SDInteractionOperand object) {
		return "Interaction Operand " + safeGetName(object.getUmlInteractionOperand());
	}

	@Override
	public String caseSDInteractionUse(SDInteractionUse object) {
		return "Interaction Use " + safeGetName(object.getUmlInteractionUse());
	}

	@Override
	public String caseSDMountingRegion(SDMountingRegion object) {
		return "Mounting region for frame " + doSwitch(object.getFrame()) + " at " + doSwitch(object.getCoveredLifeLine());
	}

	@Override
	public String caseSDSimpleNode(SDSimpleNode object) {
		return "Simple node for " + safeGetName(object.getUmlSimpleFragment());
	}

	private static String safeGetName(NamedElement umlElement) {
		return (umlElement == null) ? UNSET : umlElement.getName();
	}

}
