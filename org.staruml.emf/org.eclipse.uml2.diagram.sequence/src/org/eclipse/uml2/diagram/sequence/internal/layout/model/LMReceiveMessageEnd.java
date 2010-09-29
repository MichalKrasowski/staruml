package org.eclipse.uml2.diagram.sequence.internal.layout.model;

/**
 * 
 */
public interface LMReceiveMessageEnd extends LMMessageEnd {
	interface HorizontalPositioning extends OnLifeLinePositioning {
		int getReceiveEndXPos(boolean toRightNotLeft);
		int getReceiveMiddleXPos();

        /**
         * It is different from call link x pos for creation message
         */
        int getReceiveEndXPosForSynchReturnNotCallLink(boolean toRightNotLeft);
    }
    
}
