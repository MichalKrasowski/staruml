package org.eclipse.uml2.diagram.sequence.model.builder;

import java.util.HashMap;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDCombinedFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFactory;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionOperand;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDSimpleNode;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDTrace;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.OccurrenceSpecification;


public class SDBuilderTrace implements SDTrace {
	private final HashMap<ExecutionSpecification, SDBehaviorSpec> myExecutionSpecs;
	private final HashMap<Message, SDAbstractMessage> myMessages;
	private final HashMap<Lifeline, SDLifeLine> myLifelines;
	private final HashMap<InteractionFragment, SDFrame> myFrames;
	
	public SDBuilderTrace(){
		myExecutionSpecs = new HashMap<ExecutionSpecification, SDBehaviorSpec>();
		myMessages = new HashMap<Message, SDAbstractMessage>();
		myLifelines = new HashMap<Lifeline, SDLifeLine>();
		myFrames = new HashMap<InteractionFragment, SDFrame>();
	}
	
	void clear(){
		myExecutionSpecs.clear();
		myMessages.clear();
		myLifelines.clear();
	}
	
	public SDGate bindNewGate(Gate umlGate){
		SDGate result = SDFactory.eINSTANCE.createSDGate();
		result.setUmlGate(umlGate);
		return result;
	}
	
	public SDGateMessageEnd bindGateMessageEnd(OccurrenceSpecification umlMessageEnd){
		SDGateMessageEnd result = SDFactory.eINSTANCE.createSDGateMessageEnd();
		result.setUmlMessageEnd(umlMessageEnd);
		return result;
	}
	
	public SDGateMessage bindGateMessage(Message umlMessage){
		SDGateMessage result = SDFactory.eINSTANCE.createSDGateMessage();
		result.setUmlMessage(umlMessage);
		return result;
	}
	
	public SDSimpleNode bindNewSimpleNode(InteractionFragment umlSimpleFragment){
		SDSimpleNode result = SDFactory.eINSTANCE.createSDSimpleNode();
		result.setUmlSimpleFragment(umlSimpleFragment);
		return result;
	}
	
	public SDMountingRegion bindNewMountingRegion(SDFrame frame){
		SDMountingRegion result = SDFactory.eINSTANCE.createSDMountingRegion();
		result.setFrame(frame);
		return result;
	}
	
	public SDLifeLine bindNewLifeline(Lifeline umlLifeline){
		assert umlLifeline != null;
		SDLifeLine result = SDFactory.eINSTANCE.createSDLifeLine();
		result.setUmlLifeline(umlLifeline);
		
		SDLifeLine oldOne = myLifelines.put(umlLifeline, result);
		if (oldOne != null){
			throw new SDBuilderInternalProblem("Only one SDLifeline is expected for :" + umlLifeline + ", old: " + oldOne);
		}
		return result;
	}
	
	public SDExecution bindNewExecution(ExecutionSpecification umlSpec){
		SDExecution result = SDFactory.eINSTANCE.createSDExecution();
		bind(umlSpec, result);
		return result;
	}
	
	public SDInvocation bindNewInvocation(ExecutionSpecification umlSpec){
		SDInvocation result = SDFactory.eINSTANCE.createSDInvocation();
		bind(umlSpec, result);
		return result;
	}
	
	public SDMessage bindNewMessage(Message umlMessage){
		SDMessage result = SDFactory.eINSTANCE.createSDMessage();
		bind(umlMessage, result);
		return result;
	}
	
	public SDGateMessage bindNewGateMessage(Message umlMessage){
		SDGateMessage result = SDFactory.eINSTANCE.createSDGateMessage();
		bind(umlMessage, result);
		return result;
	}
	
	public SDInteractionOperand bindNewInteractionOperand(InteractionOperand umlOperand){
		SDInteractionOperand result = SDFactory.eINSTANCE.createSDInteractionOperand();
		bindFrame(umlOperand, result);
		result.setUmlInteractionOperand(umlOperand);
		return result;
	}
	
	public SDCombinedFragment bindNewCombinedFragment(CombinedFragment umlCombined){
		SDCombinedFragment result = SDFactory.eINSTANCE.createSDCombinedFragment();
		bindFrame(umlCombined, result);
		result.setUmlCombinedFragment(umlCombined);
		return result;
	}

	private void bindFrame(InteractionFragment umlFrame, SDFrame sdFrame){
		checkBindToNull(umlFrame, sdFrame);
		SDFrame oldOne = myFrames.put(umlFrame, sdFrame);
		if (oldOne != null){
			throw new SDBuilderInternalProblem("Only one SDFrame is expected for :" + umlFrame + ", old: " + oldOne + ", new: " + sdFrame);
		}
	}
	
	private void bind(Message umlMessage, SDAbstractMessage sdMessage){
		checkBindToNull(umlMessage, sdMessage);
		SDAbstractMessage oldOne = myMessages.put(umlMessage, sdMessage);
		if (oldOne != null){
			throw new SDBuilderInternalProblem("Only one SDMessage is expected for :" + umlMessage + ", old: " + oldOne + ", new: " + sdMessage);
		}
		sdMessage.setUmlMessage(umlMessage);
	}
	
	private void bind(ExecutionSpecification umlSpec, SDBehaviorSpec sdSpec){
		if (umlSpec == null){
			if (sdSpec instanceof SDExecution){
				throw new SDBuilderInternalProblem("SDExecution should always be backed by uml ExecutionSpec: " + sdSpec);
			}
			//for invocations its probably ok
			return;
		}
		checkBindToNull(umlSpec, sdSpec);

		SDBehaviorSpec oldOne = myExecutionSpecs.put(umlSpec, sdSpec);
		if (oldOne != null){
			//rollback?
			throw new SDBuilderInternalProblem("Only one SDBehaviorSpec is expected for :" + umlSpec + ", old: " + oldOne + ", new: " + sdSpec);
		}
		sdSpec.setUmlExecutionSpec(umlSpec);
	}
	
	public SDBehaviorSpec findBehaviorSpec(ExecutionSpecification umlSpec){
		return myExecutionSpecs.get(umlSpec);
	}
	
	public SDAbstractMessage findMessage(Message umlMessage){
		return myMessages.get(umlMessage);
	}
	
	public SDLifeLine findLifeLine(Lifeline umlLifeline){
		return myLifelines.get(umlLifeline);
	}
	
	public SDCombinedFragment findCombinedFragment(CombinedFragment umlCombinedFragment) {
		return (SDCombinedFragment) myFrames.get(umlCombinedFragment);
	}
	
	public SDInteractionOperand findInteractionOperand(InteractionOperand umlOperand) {
		return (SDInteractionOperand)myFrames.get(umlOperand);
	}
	
	private static void checkBindToNull(Element umlElement, Object sdElement){
		if (sdElement == null){
			throw new SDBuilderInternalProblem("Can't bind to null: " + umlElement);
		}
	}
	
}
