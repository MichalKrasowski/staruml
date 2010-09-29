package org.eclipse.uml2.diagram.sequence.internal.layout.horizontal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.horizontal.FramesManager.FrameInfo;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMExecutionOccurence;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMLifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMLifeLineBracket;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMMountingLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMMountingRegion;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMSendMessageEnd;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMSimpleLifeLineBracket;


/**
 * 
 */
class LifeLineHorizontalLayouter implements ComparableVerticalElement {
	LifeLineHorizontalLayouter(LMLifeLine lifeLine) {
		myLMLifeLine = lifeLine;
	}
    
	public int getX() {
		return myLMLifeLine.getGdeNode().getX();
	}

	public int getWidth() {
		return myLMLifeLine.getGdeNode().getWidth();
	}
	
    public boolean hasNoBounds() {
        return !myLMLifeLine.getGdeNode().isUserResized();
    }


    LMLifeLine getLmLifeline() {
        return myLMLifeLine;
    }
    
	PreparedLayout scanAndPrepareLayout(FramesManager frameManager, Collection messagesCollection) {
		PerLifeLineSession perLifeLineSession = new PerLifeLineSession(frameManager, messagesCollection);
		return perLifeLineSession.go();
	}
	
	interface PreparedLayout {
		int getLeftHalfWidth();
		int getRightHalfWidth();
		
		int getCurrentCenterPos();
		
		
		void layout(int centerLinePos);
	}
	
	private final LMLifeLine myLMLifeLine;

	
	private class PerLifeLineSession {
		PerLifeLineSession(FramesManager frameManager, Collection messagesCollection) {
			myFrameManager = frameManager;
			myMessagesCollection = messagesCollection;
		}
		
		
		PreparedLayout go() {
			//System.out.println("[RecursiveLayoutSession.go] ");
			ShiftedBracketInfo lifeLineBracketInfo = new ShiftedBracketInfo(null, null, 0);
			
			//System.out.println("[RecursiveLayoutSession.go] lifeline brackets: "+myLMLifeLine.getChildBracketsList());
			processBracketList(myLMLifeLine.getChildBracketsList().getListView(), 0, false, lifeLineBracketInfo, null);

			adjustRigthHalfWidth(lifeLineBracketInfo.getMaxRightPos());
			
//			adjustLeftHalfWidth(GeometryConstants.Execution.WIDTH/2);
//			adjustRigthHalfWidth(GeometryConstants.Execution.WIDTH/2);

			//System.out.println("[RecursiveLayoutSession.go] bracket info list size: "+myBracketInfoList.size());

			final int headHalfWidth = myLMLifeLine.getHeadNameWidth()/2;
			
			adjustLeftHalfWidth(headHalfWidth);
			adjustRigthHalfWidth(headHalfWidth);

			return new PreparedLayout() {
				public int getLeftHalfWidth() {
					return myLeftHalfWidth;
				}
				public int getRightHalfWidth() {
					return myRightHalfWidth;
				}
				
				public int getCurrentCenterPos() {
					return myLMLifeLine.getGdeNode().getX() + myLeftHalfWidth;
				}

				public void layout(int centerLinePos) {
					myLMLifeLine.setHorizontalPos(centerLinePos, myLeftHalfWidth, myRightHalfWidth, headHalfWidth);
				
					for (int i=0; i<myShiftedBracketInfoList.size(); i++) {
						ShiftedBracketInfo bracketInfo = (ShiftedBracketInfo) myShiftedBracketInfoList.get(i);

						LMLifeLineBracket lifeLineBracket = bracketInfo.getBracket();

						int newPos = centerLinePos + bracketInfo.getOffset() - GeometryConstants.Execution.HORIZONTAL_OFFSET;
						
						//System.out.println("[LifeLineHorizontalLayouter.layout] bracket "+bracketInfo.getBracket());
						//System.out.println("[LifeLineHorizontalLayouter.layout] bracketInfo.getOffset()="+bracketInfo.getOffset());
						//System.out.println("[LifeLineHorizontalLayouter.go] newPos="+newPos);
						//System.out.println("[LifeLineHorizontalLayouter.layout] width="+width);
						
//                        if (bracketInfo.getParentBracketInfo().getMaxRightPos() != bracketInfo.getMaxRightPos()) {
//                            System.out.println("[PerLifeLineSession] go " + bracketInfo.getParentBracketInfo().getMaxRightPos()+" != "+bracketInfo.getMaxRightPos()); //$NON-NLS-1$ //$NON-NLS-2$
//                        }
                        int width = bracketInfo.getWidth();
                        int paintableWidth = GeometryConstants.Execution.WIDTH;
                        
                        lifeLineBracket.getBracketHorizontalLayouter().setHorizontalPositions(newPos, paintableWidth, width);

						lifeLineBracket.setHorizontalPosition(newPos);
						
						//System.out.println("[RecursiveLayoutSession.go] externals: "+gdeNode.isExternalElement());
					}
					for (int i=0; i<myCenteredBracketInfoList.size(); i++) {
						CenteredBracketInfo centeredBracketInfo = (CenteredBracketInfo) myCenteredBracketInfoList.get(i);
						
						//System.out.println("[LifeLineHorizontalLayouter.layout] bracket "+centeredBracketInfo.getBracket());
						
						int width = centeredBracketInfo.getWidth();
						if (width < 20) {
							width = 20;
						}
						
						int x = centeredBracketInfo.getOffset() + centerLinePos - width/2;
						
						
						AbsNode gdeNode = centeredBracketInfo.getBracket().getGdeNode();
						//System.out.println("[LifeLineHorizontalLayouter.layout] current x = "+gdeNode.getX());
						//System.out.println("[LifeLineHorizontalLayouter.layout] current width = "+gdeNode.getWidth());
						gdeNode.setX(x);
						gdeNode.setWidth(width);
						//System.out.println("[LifeLineHorizontalLayouter.layout] new x = "+x);
						//System.out.println("[LifeLineHorizontalLayouter.layout] new width = "+width);
					}
				}
			};
		}
		
		private void processBracketList(List subbrackets, int offset, boolean shouldShiftRight, ShiftedBracketInfo parentBracketInfo, FrameInfo currentFrameInfo) {
			int maxRightPos = 0;
            int maxLeftCentered = 0, maxRightCentered = 0;
            
			for (Iterator it = subbrackets.iterator(); it.hasNext(); ) {
				LMLifeLineBracket subBracket1 = (LMLifeLineBracket) it.next();

				if (subBracket1 instanceof LMSimpleLifeLineBracket) {
                    CenteredBracketInfo centeredBracketInfo = processSimpleBracket((LMSimpleLifeLineBracket)subBracket1, parentBracketInfo);
                    maxLeftCentered = StrictMath.max(maxLeftCentered, -centeredBracketInfo.getLeftBorderPos());
                    maxRightCentered = StrictMath.max(maxRightCentered, centeredBracketInfo.getRightBorderPos());
                } else {
					ShiftedBracketInfo subBracketInfo = processBracket(subBracket1, offset, shouldShiftRight, parentBracketInfo);
					if (subBracketInfo.getMaxRightPos() > maxRightPos) {
						maxRightPos = subBracketInfo.getMaxRightPos(); 
					}
				}
                
                subBracket1.updateBracketConsistentState();                
			}
            
            
            if (currentFrameInfo != null) {
                //in case there are no subbrackets we should take into account parent bracket prominence
                int maxRightProminence = Math.max(parentBracketInfo.getMaxRightPos(), Math.max(maxRightPos, maxRightCentered));
                //if this frame lies on an execution then it should be prominent to the left 
                //enough to include left side of the bottommost execution under this frame
                //(this execution lies on a lifeline actually).
                int maxLeftProminence = Math.max(GeometryConstants.Execution.WIDTH - GeometryConstants.Execution.HORIZONTAL_OFFSET, maxLeftCentered);
                
                //if the lifeline's head is inside frame, then make the frame wide enough to contain the head (#28344)
                //here is an assumption that vertical layout has already worked  
                if (currentFrameInfo.getLMFrame().getGdeNode().getY() <= myLMLifeLine.getGdeNode().getY() &&
                    myLMLifeLine.getHeadHeight() <= currentFrameInfo.getLMFrame().getGdeNode().getHeight()) {
                    
                    int headHalfWidth = myLMLifeLine.getHeadNameWidth()/2;
                    maxLeftProminence = Math.max(maxLeftProminence, headHalfWidth);
                    maxRightProminence = Math.max(maxLeftProminence, headHalfWidth);
                }
                
                currentFrameInfo.setMaxBracketPos(myFrameManager.getLifeLineIndex(), maxLeftProminence, maxRightProminence);
            }
            
            
            adjustLeftHalfWidth(maxLeftCentered);
            adjustRigthHalfWidth(maxRightCentered);
            
			parentBracketInfo.adjustMaxRightPos(maxRightPos);
		}
		
		private CenteredBracketInfo processSimpleBracket(LMSimpleLifeLineBracket bracket, ShiftedBracketInfo parentBracketInfo) {
			CenteredBracketInfo centeredBracketInfo = new CenteredBracketInfo(bracket, parentBracketInfo.getOffset());
			addCenteredBracketInfo(centeredBracketInfo);
            return centeredBracketInfo;
		}
		private ShiftedBracketInfo processBracket(LMLifeLineBracket bracket, int offset, boolean shouldShiftRight, ShiftedBracketInfo parentBracketInfo) {
			//System.out.println("[RecursiveLayoutSession.processBracket] >>> "+bracket);
			if (bracket instanceof LMExecutionOccurence) {
				if (shouldShiftRight && ! ((LMExecutionOccurence) bracket).hasNoDuration()) {
					offset += GeometryConstants.Execution.HORIZONTAL_OFFSET;
				}
                shouldShiftRight = ! ((LMExecutionOccurence) bracket).hasNoDuration();
                //shouldShiftRight = true;
            }
			
			ShiftedBracketInfo shiftedBracketInfo = new ShiftedBracketInfo(bracket, parentBracketInfo, offset);
            shiftedBracketInfo.adjustMaxRightPos(offset - GeometryConstants.Execution.HORIZONTAL_OFFSET + GeometryConstants.Execution.WIDTH);
			
			addShiftedBracketInfo(shiftedBracketInfo);
			
			if (bracket instanceof LMSendMessageEnd) {
				LMSendMessageEnd sendMessageEnd = (LMSendMessageEnd) bracket;
				collectLMMessages(sendMessageEnd);
			}

			LMFrame mountedFrame = null;

			if (bracket instanceof LMMountingRegion) {
				LMMountingRegion mountingRegion = (LMMountingRegion) bracket;
				LMMountingLink mountingLink = mountingRegion.getMountingLink();
				//System.out.println("[RecursiveLayoutSession.processBracket] mounting link="+mountingLink);
				if (mountingLink != null) {
					mountedFrame = mountingLink.getFrame();
					//System.out.println("[RecursiveLayoutSession.processBracket] mountedFrame="+mountedFrame);
				}
			}
			
            FrameInfo frameInfo = null;
			if (mountedFrame != null) {
                frameInfo = myFrameManager.frameReferenceStarted(mountedFrame);
			}
			

			try {
				
				processBracketList(bracket.getChildBracketsList().getListView(), offset, shouldShiftRight, shiftedBracketInfo, frameInfo);
				
			} finally {
				if (mountedFrame != null) {
					myFrameManager.frameReferenceFinished(mountedFrame);
				}
			}
			
			//System.out.println("[RecursiveLayoutSession.processBracket] <<<");
			return shiftedBracketInfo;
		}
		
		private void collectLMMessages(LMSendMessageEnd sendMessageEnd) {
			Collection outgoingMessages = sendMessageEnd.getOutgoingLMMessages();
			//System.out.println("[RecursiveLayoutSession.processBracket] outgoing messages: "+outgoingMessages+" from "+sendMessageEnd); 
			myMessagesCollection.addAll(outgoingMessages);
		}
		
		private void addShiftedBracketInfo(ShiftedBracketInfo shiftedBracketInfo) {
			myShiftedBracketInfoList.add(shiftedBracketInfo);
		}
		private void addCenteredBracketInfo(CenteredBracketInfo centeredBracketInfo) {
			myCenteredBracketInfoList.add(centeredBracketInfo);
		}
		
		private void adjustLeftHalfWidth(int leftHalfWidth) {
			if (myLeftHalfWidth < leftHalfWidth) {
				myLeftHalfWidth = leftHalfWidth;
			}
		}
		private void adjustRigthHalfWidth(int rigthHalfWidth) {
			if (myRightHalfWidth < rigthHalfWidth) {
				myRightHalfWidth = rigthHalfWidth;
			}
		}

		private final FramesManager myFrameManager;
		private final Collection myMessagesCollection;
		private final List myShiftedBracketInfoList = new ArrayList();
		private final List myCenteredBracketInfoList = new ArrayList();
		private int myLeftHalfWidth = 0;
		private int myRightHalfWidth = 0;
	}
	private static class ShiftedBracketInfo {
		ShiftedBracketInfo(LMLifeLineBracket lmLifeLineBracket, ShiftedBracketInfo parentBracketInfo, int offset) {
			myBracket = lmLifeLineBracket;
			myParentBracketInfo = parentBracketInfo;
			myMaxRightPos = 0;
			myOffset = offset;
		}
		
		public ShiftedBracketInfo getParentBracketInfo() {
			return myParentBracketInfo;
		}

		public LMLifeLineBracket getBracket() {
			return myBracket;
		}

		int getOffset() {
			return myOffset;
		}

		private final LMLifeLineBracket myBracket;
		private final ShiftedBracketInfo myParentBracketInfo;
		private final int myOffset;
		private int myMaxRightPos;
		
        int getWidth() {
            return myMaxRightPos - (myOffset - GeometryConstants.Execution.HORIZONTAL_OFFSET); 
        }
        
		int getMaxRightPos() {
			return myMaxRightPos;
		}
		
		void adjustMaxRightPos(int rightPos) {
			if (myMaxRightPos < rightPos) {
				myMaxRightPos = rightPos;
			}
		}
	}
	
	private static class CenteredBracketInfo {
		CenteredBracketInfo(LMSimpleLifeLineBracket simpleLifeLineBracket, int offset) {
			mySimpleLifeLineBracket = simpleLifeLineBracket;
			myOffset = offset;
		}

		public int getLeftBorderPos() {
			return myOffset - getWidth() / 2;
		}

		public int getRightBorderPos() {
			return myOffset + getWidth() / 2;
		}

		int getWidth() {
			return mySimpleLifeLineBracket.getPreferedWidth();
		}
		int getOffset() {
			return myOffset;
		}
		
		LMSimpleLifeLineBracket getBracket() {
			return mySimpleLifeLineBracket;
		}
		
		
		private final LMSimpleLifeLineBracket mySimpleLifeLineBracket;
		private final int myOffset;
	}
}
