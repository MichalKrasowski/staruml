package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Color;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.viewmap.InvocationViewmapOptions;


/**
 * 
 */
public class LMInvocationOccurence extends LMGenCallOccurence implements LMSendMessageEnd {
    LMInvocationOccurence(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner) {
		super(gdeBracketNode, bracketMetaObject, lmOwner);
	}
    
    protected boolean getLMMessageEndSourceNotDestination(LMMessage lmMessage) {
		return lmMessage.isFromSendToReceive();
	}
	
	public LMReturnMessage findReturnMessage(LMCallMessage lmCallMessage) {
		LMReceiveMessageEnd lmReceiveMessageEnd = lmCallMessage.getReceiveMessageEnd();
		if (lmReceiveMessageEnd == null) {
			return null;
		}
		for (Iterator it = getBottomBoundaryLifeLineElement().getLMMesssagesList().iterator(); it.hasNext(); ) {
			LMReturnMessage lmReturnMessage = (LMReturnMessage) it.next();
			if (lmReturnMessage.getReceiveMessageEnd() == lmReceiveMessageEnd) {
				return lmReturnMessage;
			}
		}
		return null;
	}
	
	public Collection getOutgoingLMMessages() {
		final List callMessages = getTopBoundaryLifeLineElement().getLMMesssagesList(); 
		final List returnMessages = getBottomBoundaryLifeLineElement().getLMMesssagesList();
		final int firstListSize = callMessages.size();
		final int secondListSize = returnMessages.size();
		return new AbstractList() {
			public Object get(int pos) {
				if (pos < firstListSize) {
					return callMessages.get(pos);
				} else {
					return returnMessages.get(pos - firstListSize);
				}
			}
			public int size() {
				return firstListSize + secondListSize; 
			}
		};
	}
	
	public LMMessageEnd.Positioning getPositioning() {
		return myPositioningImpl;
	}
    
    
    protected String getDebugId() {
        EObject nodeEntity = getGdeNode().getModelEntity();
        return "Invocation-"+nodeEntity; //$NON-NLS-1$
    }
	

	private final PositioningImpl myPositioningImpl = new PositioningImpl();

    private class PositioningImpl extends PositioningGen implements LMSendMessageEnd.HorizontalPositioning {
		public int getSendEndXPos(boolean toRightNotLeft) {
			int x = getGdeNode().getX();
            InvocationViewmapOptions invocationViewmapOptions = AbsElementPropertyAccess.getInstance().getInvocationViewmapOptions(getGdeNode());
            boolean messageGoesFromCenter = !invocationViewmapOptions.isInvocationVisible() && invocationViewmapOptions.isOnLifeline();
            if (messageGoesFromCenter) {
                return x + GeometryConstants.Execution.WIDTH/2;
            } else if (toRightNotLeft) {
				return  x + GeometryConstants.Execution.WIDTH;
			} else {
				return x;
			}
		}
		
		public int getSendMiddleXPos() {
			return getGdeNode().getX() + GeometryConstants.Execution.WIDTH;
		}
	}
    
    Color setErrorDisplayColor(Color color) {
        Color oldColor = getGdeNode().getBackground();
        getGdeNode().setBackground(color);
        return oldColor;
    }
}
