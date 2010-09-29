package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.Collection;

/**
 * 
 */
public interface LMSendMessageEnd extends LMMessageEnd {
	LMReturnMessage findReturnMessage(LMCallMessage message);

	Collection getOutgoingLMMessages();

	interface HorizontalPositioning extends OnLifeLinePositioning {
		int getSendEndXPos(boolean toRightNotLeft);
		int getSendMiddleXPos();
	}
	
}
