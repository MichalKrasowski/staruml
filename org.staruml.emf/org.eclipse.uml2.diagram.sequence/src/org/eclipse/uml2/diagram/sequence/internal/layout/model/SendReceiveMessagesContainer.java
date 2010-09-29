package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */
class SendReceiveMessagesContainer {
	void addMessage(LMMessage lmMessage) {
		if (lmMessage.isFromSendToReceive()) {
			myCallMessages.add(lmMessage);
		} else {
			myReturnMessages.add(lmMessage);
		}
	}
	void removeMessage(LMMessage lmMessage) {
		if (lmMessage.isFromSendToReceive()) {
			myCallMessages.remove(lmMessage);
		} else {
			myReturnMessages.remove(lmMessage);
		}
	}
	List getCallMessages() {
		return myCallMessages;
	}
	List getReturnMessages() {
		return myReturnMessages;
	}
	
	LMReturnMessage findReturnMessage(LMCallMessage lmCallMessage) {
		LMReceiveMessageEnd lmReceiveMessageEnd = lmCallMessage.getReceiveMessageEnd();
		if (lmReceiveMessageEnd == null) {
			return null;
		}
		for (Iterator it = myReturnMessages.iterator(); it.hasNext(); ) {
			LMReturnMessage lmReturnMessage = (LMReturnMessage) it.next();
			if (lmReturnMessage.getReceiveMessageEnd() == lmReceiveMessageEnd) {
				return lmReturnMessage;
			}
		}
		return null;
	}
	Collection getOutgoingLMMessages(LMSendMessageEnd sendMessageEnd) {
		List result = new ArrayList(1);
		for (int i=0; i<getCallMessages().size(); i++) {
			LMMessage lmMessage1 = (LMMessage) getCallMessages().get(i);
			if (lmMessage1.getSendMessageEnd() == sendMessageEnd) {
				result.add(lmMessage1);
			}
		}
		for (int i=0; i<getReturnMessages().size(); i++) {
			LMMessage lmMessage1 = (LMMessage) getReturnMessages().get(i);
			if (lmMessage1.getSendMessageEnd() == sendMessageEnd) {
				result.add(lmMessage1);
			}
		}
		return result;
	}

	private final List myCallMessages = new ArrayList(1);
	private final List myReturnMessages = new ArrayList(1);
}
