package org.eclipse.uml2.diagram.sequence.model.builder;

import java.util.HashMap;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.uml.Lifeline;


public class LifeLineCallStack {
	private final HashMap<Lifeline, SDBracketContainer> myLifeline2Container = new HashMap<Lifeline, SDBracketContainer>();
	
	void clear(){
		myLifeline2Container.clear();
	}
	
	void push(Lifeline lifeline, SDBracketContainer sdContainer){
		if (sdContainer instanceof SDBracket && ((SDBracket)sdContainer).getBracketContainer() == null){
			throw new SDBuilderInternalProblem("SDBracket without container: " + sdContainer);
		}
		myLifeline2Container.put(lifeline, sdContainer);
	}
	
	public SDBracketContainer peek(Lifeline lifeline){
		SDBracketContainer result = myLifeline2Container.get(lifeline);
		if (result == null){
			throw new SDBuilderInternalProblem("No active bracket containers for lifeline: " + lifeline);
		}
		return result;
	}
	
	void pop(Lifeline lifeline){
		SDBracketContainer bottom = myLifeline2Container.remove(lifeline);
		if (bottom == null){
			throw new SDBuilderInternalProblem("No active bracket containers for lifeline: " + lifeline);
		}
		if (bottom instanceof SDLifeLine){
			throw new SDBuilderInternalProblem("Topmost container reached for lifeline: " + lifeline);
		}
		SDBracket bracket = (SDBracket)bottom;
		if (bracket.getBracketContainer() == null){
			throw new SDBuilderInternalProblem("SDBracket without container: " + bracket);
		}
		myLifeline2Container.put(lifeline, bracket.getBracketContainer());
	}
		
}
