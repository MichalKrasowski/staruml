package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;
import org.eclipse.uml2.uml.ExecutionSpecification;


/**
 * 
 */
public class LMExecutionOccurence extends LMGenCallOccurence implements LMReceiveMessageEnd {
    LMExecutionOccurence(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner) {
		super(gdeBracketNode, bracketMetaObject, lmOwner);
        myIsFoundMessageHidden = isHideFoundMessage(gdeBracketNode);
        
        myIsCreationInModel = isCreation(gdeBracketNode);
        myIsDestructionInModel = isDestruction(gdeBracketNode);
	}
    
    
    boolean isCreationInModel() {
        return myIsCreationInModel;
    }

    boolean isDestructionInModel() {
        return myIsDestructionInModel;
    }
    
    LMLifeLineBracket getDestructionCandidateInCallOccurence() {
        if (isDestructionInModel()) {
            return this;
        }
        return super.getDestructionCandidateInCallOccurence();
    }
    
	public LMMessageEnd.Positioning getPositioning() {
		return myPositioningImpl;
	}
    
	protected boolean getLMMessageEndSourceNotDestination(LMMessage lmMessage) {
		return !lmMessage.isFromSendToReceive();
	}
	
	protected int getTopOutSpace() {
        if (isCreationInLayout()) {
            return super.getTopOutSpace() + getLifeLine().getHeadHeight()/2;
        }
        
		List callMessagesList = getToplMessagesList();
		if (!callMessagesList.isEmpty()) {
			if (callMessagesList.get(0) instanceof LMSelfMessage) {
				return GeometryConstants.Execution.VERTICAL_TOP_OUT_SPACE_FOR_SELF_INVOKED;
			}
		}
		return super.getTopOutSpace();
	}
    protected int getTopInSpace() {
        if (isCreationInLayout()) {
            return super.getTopInSpace() + getLifeLine().getHeadHeight()/2;
        }
        return super.getTopInSpace();
    }
    protected void setBracketTopPos(int pos) {
        if (isCreationInLayout()) {
            LMLifeLine lifeLine = getLifeLine();
            lifeLine.setLifeLineGdeTopPos(pos - lifeLine.getHeadHeight()/2);
            
            pos += lifeLine.getHeadHeight()/2 -1;//1 is line width
        }
        super.setBracketTopPos(pos);
    }
    
	protected boolean isMessageTopNotBottom(LMMessage lmMessage) {
		if (lmMessage instanceof LMReturnMessage) {
			LMReturnMessage returnMessage = (LMReturnMessage) lmMessage;
			if (returnMessage.isAsynchronous()) {
				return true;
			}
		} else if (lmMessage instanceof LMSelfMessage) {
            LMSelfMessage selfMessage = (LMSelfMessage) lmMessage;
            if (!selfMessage.isFromSendToReceive() && selfMessage.isAsynchronous()) {
                return true;
            }
        }
		return super.isMessageTopNotBottom(lmMessage);
	}
	
	private final PositioningImpl myPositioningImpl = new PositioningImpl();
    private final boolean myIsFoundMessageHidden;
    private final boolean myIsCreationInModel;
    private final boolean myIsDestructionInModel;
    private LMLifeLine myCreatedLifeline;
    private LMLifeLine myDestructedLifeline;

	private class PositioningImpl extends PositioningGen implements LMReceiveMessageEnd.HorizontalPositioning {
		public int getReceiveMiddleXPos() {
			return getGdeNode().getX() + GeometryConstants.Execution.WIDTH; 
		}

		public int getReceiveEndXPos(boolean toRightNotLeft) {
            if (isCreationInLayout()) {
                return getLifeLine().getCreationReceiveEndXPos(toRightNotLeft);
            }
            
            int x = getGdeNode().getX();
            if (hasNoDuration()) {
                //if execution has no duration then it has no child, hence each call occurrence containing this execution must be visible 
                LMGenCallOccurence containingCallOccurence = getContainer().getContainingCallOccurence();
                if (containingCallOccurence == null) {
                    return x + GeometryConstants.Execution.WIDTH/2;
                } else if (containingCallOccurence instanceof LMInvocationOccurence) {
                    LMInvocationOccurence invocation = (LMInvocationOccurence) containingCallOccurence;
                    if (! invocation.getToplMessagesList().isEmpty()) {
                        LMMessage callMessage = (LMMessage) invocation.getToplMessagesList().get(0);
                        //if self message
                        if (callMessage.getReceiveMessageEnd() == LMExecutionOccurence.this) {
                            LMSendMessageEnd.HorizontalPositioning sendPositioning = (LMSendMessageEnd.HorizontalPositioning) invocation.getPositioning();
                            return sendPositioning.getSendEndXPos(toRightNotLeft);
                        }
                    }
                }
            }
            
			if (toRightNotLeft) {
				return x + GeometryConstants.Execution.WIDTH; 
			} else {
				return x; 
			}
		}
        
        public int getReceiveEndXPosForSynchReturnNotCallLink(boolean toRightNotLeft) {
            if (isCreationInLayout() && !hasNoDuration()) {
                int pos = getGdeNode().getX();
                if (toRightNotLeft) {
                    pos += GeometryConstants.Execution.WIDTH;
                }
                return pos;
            }
            return getReceiveEndXPos(toRightNotLeft);
        }
	}
    
    protected int getBracketTopPos() {
        if (isCreationInLayout()) {
            int y = getGdeNode().getY();
            if  (y!=0) {
                return y - getLifeLine().getHeadHeight()/2 + 1;//1 is line width
            }
        }
        
        int result = super.getBracketTopPos();
        if (result == 0) {
            for (Iterator it = getChildBracketsList().iterator(); it.hasNext(); ) {
                LMLifeLineBracket nextBracket = (LMLifeLineBracket) it.next();
                if (nextBracket instanceof LMGenCallOccurence) {
                    LMGenCallOccurence genCallOccurence = (LMGenCallOccurence) nextBracket;
                    result = genCallOccurence.getBracketTopPos();
                    if (result != 0) {
                    	break;
                    }
                }
            }
        }
        return result;
    }
    protected String getDebugId() {
        EObject nodeEntity = getGdeNode().getModelEntity();
        return "Execution-"+nodeEntity; //$NON-NLS-1$
    }

    protected boolean calculateIsBracketConsistent() {
        return super.calculateIsBracketConsistent() && isCreationDestructionConsistent();
    }
    
    private boolean isCreationDestructionConsistent() {
        return isCreationInLayout() == isCreationInModel() 
            && isDestructionInLayout() == isDestructionInModel();
    }

    Color setErrorDisplayColor(Color color) {
        Color oldColor = getGdeNode().getForeground();
        getGdeNode().setForeground(color);
        return oldColor;
    }
    
    protected boolean isIncomingOutgoingMessagesOK() {
        return myIsFoundMessageHidden || super.isIncomingOutgoingMessagesOK();
    }

    private boolean isCreationInLayout() {
        return myCreatedLifeline != null;
    }

    void setCreatedLifeline(LMLifeLine lifeLine) {
        myCreatedLifeline = lifeLine;
    }

    private boolean isDestructionInLayout() {
        return myDestructedLifeline != null;
    }

    void setDestructedLifeline(LMLifeLine lifeLine) {
        myDestructedLifeline = lifeLine;
    }

    private static boolean isHideFoundMessage(AbsNode absNode){
    	View reference = absNode.getReference();
    	return reference != null && 
    		MissedMethods._executionSpecification().isHideFoundMessage(reference);
    }
    
    private static boolean isDestruction(AbsNode absNode){
    	View reference = absNode.getReference();
    	return reference != null && 
    		MissedMethods._executionSpecification().isDestruction(reference);
    }
    
    private static boolean isCreation(AbsNode absNode){
    	View reference = absNode.getReference();
    	return reference != null && 
    		MissedMethods._executionSpecification().isCreation(reference);
    }

}
