package org.eclipse.uml2.diagram.sequence.model.builder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;


public class MessageNumbers {
	private final SDBuilder myBuilder;

	public MessageNumbers(SDBuilder builder){
		myBuilder = builder;
	}
	
	public void updateMessageNumbers(){
		List<SDAbstractMessage> orderedSDMessages = orderSDMessages();
		Set<SDAbstractMessage> guard = new HashSet<SDAbstractMessage>();
		
		int rootNumber = 1;
		for (SDAbstractMessage next : orderedSDMessages){
			if (next instanceof SDMessage){
				SDMessage nextMessage = (SDMessage)next;
				if (guard.contains(nextMessage)){
					continue;
				}
				SDMessage firstInChain = findFirstMessageInChain(nextMessage);
				firstInChain.setMessageNumber(String.valueOf(rootNumber++));
				setupMessageNumbersForChain(firstInChain, guard);
			}
		}
	}
	
	private List<SDAbstractMessage> orderSDMessages(){
		Set<Message> matchedUMLMessages = new HashSet<Message>();
		List<SDAbstractMessage> sdMessages = new LinkedList<SDAbstractMessage>();
		
		for (InteractionFragment next : myBuilder.getInteraction().getFragments()){
			if (next instanceof MessageEnd){
				MessageEnd nextMessageEnd = (MessageEnd)next;
				Message umlMessage = nextMessageEnd.getMessage();
				if (umlMessage == null){
					continue;
				}
				if (matchedUMLMessages.contains(umlMessage)){
					continue;
				}
				SDAbstractMessage sdMessage = myBuilder.getSDModel().getUMLTracing().findMessage(umlMessage);
				if (sdMessage == null){
					continue;
				}	
				sdMessages.add(sdMessage);
				matchedUMLMessages.add(umlMessage);
			}
		}
		return sdMessages;
	}

	private SDMessage findFirstMessageInChain(SDMessage message){
		SDInvocation invocation = message.getSource();
		if (invocation.getBracketContainer() instanceof SDLifeLine){
			return message;
		}
		SDExecution containerExecution = (SDExecution)invocation.getBracketContainer();
		return findFirstMessageInChain(containerExecution.getIncomingMessage());
	}
	
	private void setupMessageNumbersForChain(SDMessage current, Set<SDAbstractMessage> guard){
		if (guard.contains(current)){
			return;
		}
		guard.add(current);
		
		SDExecution execution = current.getTarget();
		int index = 1;
		for (SDBracket nextBracket : execution.getBrackets()){
			if (nextBracket instanceof SDInvocation){
				SDInvocation nextInvocation = (SDInvocation)nextBracket;
				SDMessage nextMessage = nextInvocation.getOutgoingMessage();
				nextMessage.setMessageNumber(current.getMessageNumber() + "." + (index++));
				setupMessageNumbersForChain(nextMessage, guard);
			}
		}
	}
	
}
