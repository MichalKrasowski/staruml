package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.AbstractList;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;


/**
 * 
 */
public class LMCallMessageSynch extends LMCallMessage {
	public LMCallMessageSynch(AbsLink gdeLink) {
		super(gdeLink);
	}
	
	HorizontalConstraintImpl getTopHorizontalConstraint() {
		return myTopHorizontalConstraint;
	}
	HorizontalConstraintImpl getBottomHorizontalConstraint() {
		return myBottomHorizontalConstraint;
	}
	
	void becomeLayoutConstraint(boolean on) {
		if (on) {
	        if (getReceiveVerticalPositioning().canSetMessageAsHorizontalConstraint(this) && getSendVerticalPositioning().canSetMessageAsHorizontalConstraint(this)) {
	        	
	        	switchOnTopHorizontalConstraint(getSendVerticalPositioning(), getReceiveVerticalPositioning());
	        	
	        	getSendVerticalPositioning().setMessageAsHorizontalConstraint(this, true);
	            getReceiveVerticalPositioning().setMessageAsHorizontalConstraint(this, true);
	            

	            LifeLineElement sendBottomLifeLineElement = getSendVerticalPositioning().getBottomLifeLineElement(); 
	            LifeLineElement receiveBottomLifeLineElement = getReceiveVerticalPositioning().getBottomLifeLineElement(); 
				if (sendBottomLifeLineElement != null && receiveBottomLifeLineElement != null) {
		        	switchOnBottomHorizontalConstraint(sendBottomLifeLineElement, receiveBottomLifeLineElement);
				}
	        } else {
                setVerticalConstraintViolationState(true);
				LMSendMessageEnd sendMessageEnd = getSendMessageEnd();
				if (sendMessageEnd == null) {
					return;
				}
				LMReturnMessage returnMessage = sendMessageEnd.findReturnMessage(LMCallMessageSynch.this);
				if (returnMessage != null) {
					returnMessage.setVerticalConstraintViolationState(true);
				}
	        }
		} else {
			switchOffBottomHorizontalConstraint();
			switchOffTopHorizontalConstraint();
        	
			getSendVerticalPositioning().setMessageAsHorizontalConstraint(this, false);
			getReceiveVerticalPositioning().setMessageAsHorizontalConstraint(this, false);
		}
	}
	boolean isLayoutConstraint() {
		return myTopHorizontalConstraint != null;
	}
	
	private void switchOnTopHorizontalConstraint(LMMessageEnd.VerticalConstraintedPositioning sendEndPositioning, LMMessageEnd.VerticalConstraintedPositioning receiveEndPositioning) {
		if (myTopHorizontalConstraint != null) {
			throw new RuntimeException("Top constraint already created"); //$NON-NLS-1$
		}
		myTopHorizontalConstraint = new HorizontalConstraintImpl() {
			protected void setLMMessageViolationState(boolean violated) {
				LMCallMessageSynch.this.setVerticalConstraintViolationState(violated);
			}
		};
		myTopHorizontalConstraint.getConstratintedLifeLineElements().setSendLifeLineElement(sendEndPositioning.getTopLifeLineElement());
		myTopHorizontalConstraint.getConstratintedLifeLineElements().setReceiveLifeLineElement(receiveEndPositioning.getTopLifeLineElement());
	}
	
	private void switchOffTopHorizontalConstraint() {
		myTopHorizontalConstraint = null;
	}
	
	private void switchOnBottomHorizontalConstraint(LifeLineElement sendLifeLineElement, LifeLineElement receiveLifeLineElement) {
		if (myBottomHorizontalConstraint != null) {
			throw new RuntimeException("Bottom constraint already created"); //$NON-NLS-1$
		}
		myBottomHorizontalConstraint = new HorizontalConstraintImpl() {
			protected void setLMMessageViolationState(boolean violated) {
				LMSendMessageEnd sendMessageEnd = getSendMessageEnd();
				if (sendMessageEnd == null) {
					return;
				}
				LMReturnMessage returnMessage = sendMessageEnd.findReturnMessage(LMCallMessageSynch.this);
				if (returnMessage != null) {
					returnMessage.setVerticalConstraintViolationState(violated);
				}
			}
		};
		myBottomHorizontalConstraint.getConstratintedLifeLineElements().setSendLifeLineElement(sendLifeLineElement);
		myBottomHorizontalConstraint.getConstratintedLifeLineElements().setReceiveLifeLineElement(receiveLifeLineElement);
	}
	private void switchOffBottomHorizontalConstraint() {
		myBottomHorizontalConstraint = null;
	}
	
	
	
	
	private abstract class HorizontalConstraintImpl implements HorizontalConstraint {
		
		public void elementIsResolved(LifeLineElement lifeLineElement) {
			if (lifeLineElement==myConstraintedElements.getExecutionLifeLineElement()) {
				myExecutionViolated = false;
			} else {
				myInteractionViolated = false;
			}
			updateViolationState();
		}
		public void elementIsViolated(LifeLineElement lifeLineElement) {
			//System.out.println("[LMMessage.elementIsViolated] lifeLineElement="+lifeLineElement);
			if (lifeLineElement==myConstraintedElements.getExecutionLifeLineElement()) {
				myExecutionViolated = true;
			} else {
				myInteractionViolated = true;
			}
			updateViolationState();
		}
		public List getLifeLineElementsList() {
			//LifeLineElement executionLifeLineElement = myConstraintedElements.getExecutionLifeLineElement();
			//if (executionLifeLineElement != null) {
			//	executionLifeLineElement.getLifeLine();
			//}
			//LifeLineElement invocationLifeLineElement = myConstraintedElements.getInvocationLifeLineElement();
			//if (invocationLifeLineElement != null) {
			//	invocationLifeLineElement.getLifeLine();
			//}
			
			return myConstraintedElements;
		}
		ConstratintedLifeLineElements getConstratintedLifeLineElements() {
			return myConstraintedElements;
		}
		private void updateViolationState() {
			boolean violatedNow = myExecutionViolated || myInteractionViolated;
			setLMMessageViolationState(violatedNow);
		}
		
		protected abstract void setLMMessageViolationState(boolean violated);
		
		private ConstratintedLifeLineElements myConstraintedElements = new ConstratintedLifeLineElements();
		
		private boolean myExecutionViolated = false;
		private boolean myInteractionViolated = false;
	}
	
	private HorizontalConstraintImpl myTopHorizontalConstraint;
	private HorizontalConstraintImpl myBottomHorizontalConstraint;
	
	
	private static class ConstratintedLifeLineElements extends AbstractList {
		public Object get(int pos) {
			switch (pos) {
				case 0: return getExecutionLifeLineElement();
				case 1: return getInvocationLifeLineElement();
			}
			throw new IndexOutOfBoundsException(pos+", size=2"); //$NON-NLS-1$
		}
		public int size() {
			return 2;
		}
		LifeLineElement getExecutionLifeLineElement() {
			return myExecutionLifeLineElement;
		}
		void setReceiveLifeLineElement(LifeLineElement executionLifeLineElement) {
			myExecutionLifeLineElement = executionLifeLineElement;
		}
		LifeLineElement getInvocationLifeLineElement() {
			return myInvocationLifeLineElement;
		}
		void setSendLifeLineElement(LifeLineElement invocationLifeLineElement) {
			myInvocationLifeLineElement = invocationLifeLineElement;
		}
		
		void setLifeLineElement(LifeLineElement lifeLineElement, boolean invocationNotExecution) {
			if (invocationNotExecution) {
				setSendLifeLineElement(lifeLineElement);
			} else {
				setReceiveLifeLineElement(lifeLineElement);
			}
		}
		
		private LifeLineElement myExecutionLifeLineElement;
		private LifeLineElement myInvocationLifeLineElement;
	}
}
