package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;


public interface SDTrace {
	public SDBehaviorSpec findBehaviorSpec(ExecutionSpecification umlSpec);
	public SDAbstractMessage findMessage(Message umlMessage);
	public SDLifeLine findLifeLine(Lifeline umlLifeline);
	public SDCombinedFragment findCombinedFragment(CombinedFragment umlCombinedFragment);
	public SDInteractionOperand findInteractionOperand(InteractionOperand umlOperand);
}
