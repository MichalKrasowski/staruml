package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.Collection;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;


/**
 * 
 */
public class LMFoundInvocationOccurence implements LMSendMessageEnd {
	LMFoundInvocationOccurence(AbsNode gdeNode, LMFrame enclosingFrame) {
		myGdeNode = gdeNode;
        myEnclosingFrame = enclosingFrame;
	}
	
	void delete() {
		setContainer(null);
	}
    
    public LMFrame getContainingFrame() {
        return myEnclosingFrame;
    }
	
	public LMFrameContainer getContainer() {
		if (myContainerFriendly == null) {
			return null;
		}
		return myContainerFriendly.getLMFrameContainer();
	}
	
	void setContainer(LMFrameContainer.ContainerFriendly containerFriendly) {
		if (containerFriendly == null) {
			if (myContainerFriendly != null) {
				myContainerFriendly.childRemove(this);
				myContainerFriendly = null;
			}
		} else {
			if (myContainerFriendly != null) {
				throw new IllegalStateException("Parent already set");  //$NON-NLS-1$
			}
			myContainerFriendly = containerFriendly;
		}
	}
	
	public LMReturnMessage findReturnMessage(LMCallMessage lmCallMessage) {
		return myMessagesContainer.findReturnMessage(lmCallMessage);
	}

	public Collection getOutgoingLMMessages() {
		return myMessagesContainer.getOutgoingLMMessages(this);
	}

	public void addMessage(LMMessage lmMessage) {
		myMessagesContainer.addMessage(lmMessage);
	}
	public void removeMessage(LMMessage lmMessage) {
		myMessagesContainer.removeMessage(lmMessage);
	}
	
	public Positioning getPositioning() {
		return myFloatingPositioning;
	}
    
    public void messageIsJustReshaped(LMMessage lmMessage, JustReshapedState justReshapedState) {
    }

    AbsNode getGdeNode() {
        return myGdeNode;
    }

	private final AbsNode myGdeNode;
	private final LMFrame myEnclosingFrame;
	private LMFrameContainer.ContainerFriendly myContainerFriendly;
	private final SendReceiveMessagesContainer myMessagesContainer = new SendReceiveMessagesContainer();
	
	private final LMSendMessageEnd.FloatingPositioning myFloatingPositioning = new FloatingPositioning() {
		public int getXPos() {
			int width = myGdeNode.getPreferredSize().width;
			return myGdeNode.getX() + width/2;
		}
		public void setXPos(int xPos) {
			int width = myGdeNode.getPreferredSize().width;
			int gdeXPos = xPos - width/2;

			int leftBorder;
			int rightBorder;
			
			if (getContainer() instanceof LMFrame) {
				LMFrame containerFrame = (LMFrame) getContainer();
				AbsNode containerFrameGdeNode = containerFrame.getGdeNode();
				leftBorder = containerFrameGdeNode.getX() + 5;
				rightBorder = containerFrameGdeNode.getX() + containerFrameGdeNode.getWidth() - 5;
			} else {
				leftBorder = 5;
				rightBorder = Integer.MAX_VALUE;
			}
			
			if (gdeXPos < leftBorder) {
				gdeXPos = leftBorder;
			}
			if (gdeXPos+width > rightBorder) {
				gdeXPos = rightBorder - width;
			}
			
			myGdeNode.setX(gdeXPos);
		}
		public void setYPos(int yPos) {
			int height = myGdeNode.getPreferredSize().height;
			myGdeNode.setY(yPos - height/2);
		}
	};
}