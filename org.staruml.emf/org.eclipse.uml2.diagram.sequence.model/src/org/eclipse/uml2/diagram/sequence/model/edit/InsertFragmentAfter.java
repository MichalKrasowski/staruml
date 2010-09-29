package org.eclipse.uml2.diagram.sequence.model.edit;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;


public class InsertFragmentAfter extends InsertAfter<InteractionFragment> {
	
	public void executionStarted(SDExecution sdExecution) {
		ExecutionSpecification umlExecution = sdExecution.getUmlExecutionSpec();
		considerAsPast(umlExecution);
		considerAsPast(umlExecution.getStart());

		SDInvocation sdParentInvocation = sdExecution.getInvocation();
		if (sdParentInvocation != null) {
			considerAsPast(sdParentInvocation.getUmlExecutionSpec());
			considerAsPast(sdParentInvocation.getUmlStart());
		}
	}

	public void fragmentFinished(InteractionFragment fragment) {
		considerAsPast(fragment);
		if (fragment instanceof ExecutionSpecification) {
			considerAsPast(((ExecutionSpecification) fragment).getFinish());
		}
	}
	
	public void bracketFinished(SDBracket bracket){
		if (bracket.getBracketContainer() instanceof SDExecution){
			executionStarted((SDExecution)bracket.getBracketContainer());
		}
		if (bracket instanceof SDBehaviorSpec){
			fragmentFinished(((SDBehaviorSpec)bracket).getUmlExecutionSpec());
		}
		if (bracket instanceof SDMountingRegion){
			SDFrame frame = ((SDMountingRegion)bracket).getFrame();
			fragmentFinished(frame.getUmlFragment());
		}
	}

}
