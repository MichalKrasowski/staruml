package org.eclipse.uml2.diagram.sequence.internal.layout.horizontal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMVisibleFrameWithPentagon;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;


/**
 * 
 */
class LifeLineDressImpl implements LifeLineDress, MissedMethods.DifferentSemanticInArcasAndGMF {
	LifeLineDressImpl(boolean pos) {
        myIgnoreCurrentPos = pos;
    }
	
    public int getLeftMinSpace() {
		return myLeftSide.getMinOffsetWidth();
	}
	public int getRightMinSpace() {
		return myRightSide.getMinOffsetWidth();
	}
    public int getRightSpace() {
        return myRightSide.getOuterOffsetWidth();
    }
    
    public void setMinLeftAndCenter(int minLeft, int center) {
//        System.out.println("[LifeLineDressImpl] setMinLeftAndCenter before " + myLeftSide);
//        System.out.println("[LifeLineDressImpl] setMinLeftAndCenter before " + myRightSide);
        myLeftSide.setLifelinePos(center, !myIgnoreCurrentPos);
        myRightSide.setLifelinePos(center, !myIgnoreCurrentPos);
//        System.out.println("[LifeLineDressImpl] setMinLeftAndCenter after " + myLeftSide);
//        System.out.println("[LifeLineDressImpl] setMinLeftAndCenter after " + myRightSide);
        
        if (!myIgnoreCurrentPos) {
            if (myLeftJustReshaped != null) {
                int currentOffset = myLeftJustReshaped.getCurrentOffset(center);
                myLeftJustReshaped.setOffsetLimit(currentOffset);
                myLeftSide.revalidateOffsets(center);//minimal offset constraints could be broken 
            }
            if (myRightJustReshaped != null) {
                int currentOffset = myRightJustReshaped.getCurrentOffset(center);
                myRightJustReshaped.setOffsetLimit(currentOffset);
                myRightSide.revalidateOffsets(center);//minimal offset constraints could be broken
        }
        }
//        System.out.println("[LifeLineDressImpl] setMinLeftAndCenter reshape " + myLeftSide);
//        System.out.println("[LifeLineDressImpl] setMinLeftAndCenter reshape " + myRightSide);

        myLeftSide.setOuterOffsetLimit(center - minLeft);
    }
    
    public void setMaxRight(int center, int maxRight) {
        myRightSide.setOuterOffsetLimit(maxRight - center);
    }

	public void layout(final int center) {
		//System.out.println("[SDHorizontalLayout.layout] myLeftSpace="+myLeftSpace);
		//System.out.println("[SDHorizontalLayout.layout] myRightSpace="+myRightSpace);
		//System.out.println("[SDHorizontalLayout.layout] myLeftFrames="+myLeftFrames);
		//System.out.println("[SDHorizontalLayout.layout] myRightFrames="+myRightFrames);

		{
			//System.out.println("[LifeLineDressImpl.layout] leftPos = "+leftPos);
			
			PositionSetter leftPositionSetter = new PositionSetter() {
				void setFrameBorderPosition(LMFrame lmFrame, int offset) {
					lmFrame.setLeftBorderPosByLayout(center - offset);
				}

				void setUntiedFramePosition(UntiedFrameHorizontalLayouter untiedFrameLayouter, int outerSizePos) {
					untiedFrameLayouter.layout(center - outerSizePos);
				}
			};
			
			myLeftSide.layout(leftPositionSetter);
		}


		{
			//System.out.println("[LifeLineDressImpl.layout] rightPos = "+rightPos);
			
			PositionSetter rightPositionSetter = new PositionSetter() {
				void setFrameBorderPosition(LMFrame lmFrame, int offset) {
					lmFrame.setRightBorderPosByLayout(center + offset);					
				}
				void setUntiedFramePosition(UntiedFrameHorizontalLayouter untiedFrameLayouter, int outerSizePos) {
					throw new UnsupportedOperationException();
				}
			};
			myRightSide.layout(rightPositionSetter);
		}
	}
    
    LeftSideFrameWrapper addLeftFrame(LMFrame lmFrame, int maxLeftBracketOffset, UntiedFrameHorizontalLayouter untiedFrameLayouter, boolean addAsJustReshaped) {
		LeftSideFrameWrapper frameWrapper = (LeftSideFrameWrapper)myLeftSide.addFrame(lmFrame, untiedFrameLayouter, maxLeftBracketOffset);
        if (addAsJustReshaped) {
            myLeftJustReshaped = frameWrapper;
        }
        return frameWrapper;
	}
	void addRightFrame(LMFrame lmFrame, int maxRightBracketOffset, boolean addAsJustReshaped, LeftSideFrameWrapper leftSideOnTheSameLifeline) {
        RightSideFrameWrapper frameWrapper = (RightSideFrameWrapper)myRightSide.addFrame(lmFrame, null, maxRightBracketOffset);
        frameWrapper.setLeftSideWrapperOnTheSameLifeline(leftSideOnTheSameLifeline);
        if (addAsJustReshaped) {
            myRightJustReshaped = frameWrapper;
        }
	}
	
    private final boolean myIgnoreCurrentPos;
    private FrameWrapper myLeftJustReshaped;
    private FrameWrapper myRightJustReshaped;
    
	private final OneSide myLeftSide = new LeftSide();
	private final OneSide myRightSide = new RightSide();

	private abstract static class PositionSetter {
		abstract void setFrameBorderPosition(LMFrame lmFrame, int offset);

		abstract void setUntiedFramePosition(UntiedFrameHorizontalLayouter untiedFrameLayouter, int outerSizePos);
	}
	
	private static abstract class OneSide {
		FrameWrapper addFrame(LMFrame lmFrame, UntiedFrameHorizontalLayouter untiedFrameLayouter, int offset) {
			//System.out.println("[LifeLineDressImpl.addFrame] |"+myDebugId+"| lmFrame="+lmFrame);
            ArrayList innerFrames = new ArrayList(myOuterFrameWrappers.size());
			for (Iterator it = myOuterFrameWrappers.iterator(); it.hasNext(); ) {
				FrameWrapper frameWrapper = (FrameWrapper) it.next();
				if (frameWrapper.getLMFrame().getContainer() == lmFrame) {
                    innerFrames.add(frameWrapper);
					//System.out.println("[LifeLineDressImpl.addFrame] |"+myDebugId+"| enclosed frame "+frameWrapper.getLMFrame());
					int offset2 = frameWrapper.getMinOuterOffset();
					//System.out.println("[LifeLineDressImpl.addFrame] |"+myDebugId+"|  offset2 = "+offset2);
					if (offset2 > offset) {
						offset = offset2;
					}
					it.remove();
				}
			}
            
			//System.out.println("[LifeLineDressImpl.addFrame] |"+myDebugId+"| result offset="+offset);
			
			FrameWrapper frameWrapper = createFrameWrapper(lmFrame, offset, untiedFrameLayouter, innerFrames);
            if (innerFrames.isEmpty()) {
                myInnerFrameWrappers.add(frameWrapper);
            }
			
			myOuterFrameWrappers.add(frameWrapper);
			myFrameWrappers.add(frameWrapper);
            return frameWrapper;
		}
        
        abstract FrameWrapper createFrameWrapper(LMFrame frame, int innerElementsMinOffset, UntiedFrameHorizontalLayouter untiedFrameLayouter, ArrayList children);
        
        void setLifelinePos(int lifelinePos, boolean considerCurrentPos) {
            for (int i = 0; i < myInnerFrameWrappers.size(); i++) {
                FrameWrapper frameWrapper =  (FrameWrapper)myInnerFrameWrappers.get(i);
                frameWrapper.setLifelinePos(lifelinePos, considerCurrentPos);
            }
        }
        void revalidateOffsets(int lifelinePos) {
            for (int i = 0; i < myInnerFrameWrappers.size(); i++) {
                FrameWrapper frameWrapper =  (FrameWrapper)myInnerFrameWrappers.get(i);
                frameWrapper.revalidateOffsetsAfterReshape(lifelinePos);
            }
        }
        void setOuterOffsetLimit(int externalPos) {
            for (Iterator it = myOuterFrameWrappers.iterator(); it.hasNext(); ) {
                FrameWrapper frameWrapper =  (FrameWrapper) it.next();
                frameWrapper.setOuterOffsetLimit(externalPos);
            }
        }
        
		void layout(PositionSetter positionSetter) {
			//System.out.println("[LifeLineDressImpl.layout] |"+myDebugId+"| ");
			
			// reverse order: move outer frames first
			for (int i=myFrameWrappers.size()-1; i>=0; i--) {
				FrameWrapper frameWrapper = (FrameWrapper) myFrameWrappers.get(i);
				//System.out.println("[LifeLineDressImpl.layout] |"+myDebugId+"| frame="+frameWrapper.getLMFrame()+", offset="+frameWrapper.getOffset());
				positionSetter.setFrameBorderPosition(frameWrapper.getLMFrame(), frameWrapper.getPreferredOffset());
				
				UntiedFrameHorizontalLayouter untiedFrameLayouter = frameWrapper.getUntiedFrameLayouter();
				if (untiedFrameLayouter != null) {
					positionSetter.setUntiedFramePosition(untiedFrameLayouter, frameWrapper.getPreferredOffset() - GeometryConstants.Frames.UNTIED_FRAME_OUTER_SPACE_HORIZONTAL);
				}
			}
		}
		
		int getMinOffsetWidth() {
			int offset = 0;
			for (Iterator it = myOuterFrameWrappers.iterator(); it.hasNext(); ) {
				FrameWrapper frameWrapper = (FrameWrapper) it.next();
				int offset2 = frameWrapper.getMinOuterOffset();
				if (offset2 > offset) {
					offset = offset2;
				}
			}
			return offset;
		}
        
        int getOuterOffsetWidth() {
            int offset = 0;
            for (Iterator it = myOuterFrameWrappers.iterator(); it.hasNext(); ) {
                FrameWrapper frameWrapper = (FrameWrapper) it.next();
                int offset2 = frameWrapper.getPreferredOuterOffset();
                if (offset2 > offset) {
                    offset = offset2;
                }
            }
            return offset;
        }
        
        public String toString() {
            StringBuffer result = new StringBuffer(); 
            for(Iterator it = myOuterFrameWrappers.iterator(); it.hasNext(); ) {
                FrameWrapper next = (FrameWrapper)it.next();
                result.append(next.treeToString("")); //$NON-NLS-1$
            }
            return result.toString();
        }
		
		private final List myOuterFrameWrappers = new LinkedList();
		private final List myFrameWrappers = new ArrayList();
        private final List myInnerFrameWrappers = new ArrayList(); 
	}
    
    private static class RightSide extends OneSide {
        FrameWrapper createFrameWrapper(LMFrame frame, int offset, UntiedFrameHorizontalLayouter untiedFrameLayouter, ArrayList children) {
            return new RightSideFrameWrapper(frame, offset, untiedFrameLayouter, children);
        }
        
        public String toString() {
            return "<RightSide: \n"+super.toString()+"\n>"; //$NON-NLS-1$ //$NON-NLS-2$
        }
    }
    
    private static class LeftSide extends OneSide {
        FrameWrapper createFrameWrapper(LMFrame frame, int offset, UntiedFrameHorizontalLayouter untiedFrameLayouter, ArrayList children) {
            return new LeftSideFrameWrapper(frame, offset, untiedFrameLayouter, children);
        }
        
        public String toString() {
            return "<LeftSide: \n"+super.toString()+"\n>"; //$NON-NLS-1$ //$NON-NLS-2$
        }
    }
	
	private abstract static class FrameWrapper {
        FrameWrapper(LMFrame frame, int offset, UntiedFrameHorizontalLayouter untiedFrameLayouter, ArrayList children) {
			myLMFrame = frame;
			myInnerElementsMinimalOffset = offset;
			myUntiedFrameLayouter = untiedFrameLayouter;
            {
                int innerSpace = myLMFrame.getInnerHorizontalPadding();
                if (myUntiedFrameLayouter != null) {
                    innerSpace += myUntiedFrameLayouter.getWidth() + 2*GeometryConstants.Frames.UNTIED_FRAME_OUTER_SPACE_HORIZONTAL;
                }
                myFrameInnerAdditionalSpace = innerSpace;
            }
            myPreferredOffset = myInnerElementsMinimalOffset + myFrameInnerAdditionalSpace;
            
            {
                myChildren = children;
                for (int i = 0; i<children.size(); i++) {
                    ((FrameWrapper) children.get(i)).setParent(this);
                }
            }
		}
        LMFrame getLMFrame() {
			return myLMFrame;
		}
		int getMinOuterOffset() {
			return myInnerElementsMinimalOffset + myFrameInnerAdditionalSpace + getOuterAdditionalSpace();
		}
        int getPreferredOffset() {
            return myPreferredOffset;
        }
        int getPreferredOuterOffset() {
            return myPreferredOffset + getOuterAdditionalSpace();
        }
        private int getOuterAdditionalSpace() {
            return myLMFrame.getOuterHorizontalPadding();
        }
		UntiedFrameHorizontalLayouter getUntiedFrameLayouter() {
			return myUntiedFrameLayouter;
		}
        
        void setLifelinePos(int lifelinePos, boolean considerCurrentPos) {
            recalculatePreferredOffset(lifelinePos, considerCurrentPos);
        }
        
        void revalidateOffsetsAfterReshape(int lifelinePos) {
            recalculatePreferredOffset(lifelinePos, false);
        }
        
        private void recalculatePreferredOffset(int lifelinePos, final boolean considerCurrentOffset) {
            myInnerElementsMinimalOffset = recalculateMinInnerOffset(lifelinePos);
            int minPreferredOffset = recalculateMinPreferredOffset(lifelinePos);
            myPreferredOffset = Math.max(myPreferredOffset, minPreferredOffset);
            if (considerCurrentOffset) {
                int currentOffset = getCurrentOffset(lifelinePos);
                myPreferredOffset = Math.max(myPreferredOffset, currentOffset);
            }
            if (myParent != null) {
                myParent.recalculatePreferredOffset(lifelinePos, considerCurrentOffset);
            }
        }
        
        int getCurrentOffset(int lifelinePos) {
             if (isJustCreated(myLMFrame)) {
                 return 0; 
            } else {
                return getPreviousOffset(lifelinePos);
            }
        }
        
        abstract int getPreviousOffset(int lifelinePos);
        
        int recalculateMinInnerOffset(int lifelinePos) {
            int result = myInnerElementsMinimalOffset;
            for (int i = 0; i < myChildren.size(); i++) {
                FrameWrapper frameWrapper = (FrameWrapper)myChildren.get(i);
                result = Math.max(result, frameWrapper.getMinOuterOffset());
            }
            return result; 
        }
        
        int recalculateMinPreferredOffset(int lifelinePos) {
            int offset = myInnerElementsMinimalOffset;
            for (int i = 0; i < myChildren.size(); i++) {
                FrameWrapper frameWrapper = (FrameWrapper)myChildren.get(i);
                offset = Math.max(offset, frameWrapper.getPreferredOuterOffset());
            }
            return offset + myFrameInnerAdditionalSpace; 
        }
        
        void setOuterOffsetLimit(int maxOffset) {
            setOffsetLimit(maxOffset-getOuterAdditionalSpace());
        }
        
        void setOffsetLimit(int maxOffset) {
            if (myPreferredOffset > maxOffset) {
                myPreferredOffset = maxOffset;
                
                final int innerMaxOffset = maxOffset - myFrameInnerAdditionalSpace; 
                for (int i = 0; i < myChildren.size(); i++) {
                    FrameWrapper frameWrapper = (FrameWrapper)myChildren.get(i);
                    frameWrapper.setOuterOffsetLimit(innerMaxOffset);
                }
            }
        }
        
        private void setParent(FrameWrapper parent) {
            myParent = parent;
        }
        
        String treeToString(String margin) {
            StringBuffer result = new StringBuffer();
            result.append(margin).append(this.toString()).append("\n"); //$NON-NLS-1$
            margin += "    "; //$NON-NLS-1$
            for (int i = 0; i<myChildren.size(); i++) {
                result.append(((FrameWrapper)myChildren.get(i)).treeToString(margin));
            }
            return result.toString();
        }
        
        public String toString() {
            return "LMFame: "+myLMFrame.getGdeNode().getModelEntity().eClass().getName()+"; minInnerOffset = "+myInnerElementsMinimalOffset+"; preferredOffset = "+myPreferredOffset+ //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                   "; current bounds = "+myLMFrame.getGdeNode().getX()+", "+myLMFrame.getGdeNode().getY()+", "+myLMFrame.getGdeNode().getWidth()+", "+myLMFrame.getGdeNode().getHeight(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        }
        
        private FrameWrapper myParent;
        private final ArrayList myChildren;
        
		protected final LMFrame myLMFrame;
        private final UntiedFrameHorizontalLayouter myUntiedFrameLayouter;
        private final int myFrameInnerAdditionalSpace;
        
		protected int myInnerElementsMinimalOffset;
        private int myPreferredOffset;
	}
    
    static class RightSideFrameWrapper extends FrameWrapper {
        RightSideFrameWrapper(LMFrame frame, int offset, UntiedFrameHorizontalLayouter untiedFrameLayouter, ArrayList children) {
            super(frame, offset, untiedFrameLayouter, children);
        }

        int getPreviousOffset(int lifelinePos) {
            int frameRightPos = myLMFrame.getGdeNode().getX() + myLMFrame.getGdeNode().getWidth();  
            return  frameRightPos - lifelinePos;
        }
        
        protected int recalculateMinInnerOffset(int lifelinePos) {
            int result = super.recalculateMinInnerOffset(lifelinePos);
            return stretchToPentagon(result, lifelinePos);
        }
        
        protected int recalculateMinPreferredOffset(int lifelinePos) {
            int result = super.recalculateMinPreferredOffset(lifelinePos);
            return stretchToPentagon(result, lifelinePos);
        }
        
        private int stretchToPentagon(int currentOffset, int lifelinePos) {
            if (myLMFrame instanceof LMVisibleFrameWithPentagon) {
                int pentagonWidth = ((LMVisibleFrameWithPentagon) myLMFrame).getMinimumWidth();
                int minOffset;
                if (myLeftSideWrapperOnTheSameLifeline == null) {
                    int minPos = myLMFrame.getGdeNode().getX() + pentagonWidth;
                    minOffset = minPos - lifelinePos;
                } else {
                    minOffset = pentagonWidth - myLeftSideWrapperOnTheSameLifeline.getPreferredOffset();
                }
                minOffset += GeometryConstants.Frames.PENTAGON_MIN_RIGHT_OUTER_SPACE;
                return Math.max(currentOffset, minOffset);
            } else {
                return currentOffset;
            }
        }
        
        public String toString() {
            return "<RightSideFrameWrapper: "+super.toString()+">"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        void setLeftSideWrapperOnTheSameLifeline(LeftSideFrameWrapper leftSideWrapperOnTheSameLifeline) {
            myLeftSideWrapperOnTheSameLifeline = leftSideWrapperOnTheSameLifeline;
        }
        
        /**
         * To determine left pos of frame with pentagon after left side layout.
         */
        private LeftSideFrameWrapper myLeftSideWrapperOnTheSameLifeline;
    }

    static class LeftSideFrameWrapper extends FrameWrapper {
        LeftSideFrameWrapper(LMFrame frame, int offset, UntiedFrameHorizontalLayouter untiedFrameLayouter, ArrayList children) {
            super(frame, offset, untiedFrameLayouter, children);
        }
        
        int recalculateMinInnerOffset(int lifelinePos) {
            return myInnerElementsMinimalOffset;
        }
        
        int getPreviousOffset(int lifelinePos) {
            return lifelinePos - myLMFrame.getGdeNode().getX();
        }
        public String toString() {
            return "<LeftSideFrameWrapper: "+super.toString()+">"; //$NON-NLS-1$ //$NON-NLS-2$
        }
    }
    
    /**
     * @return true if element has just been added to diagram and its position must be updated
     */
    static boolean isJustCreated(LMFrame frame) {
    	MissedMethods.DifferentSemanticInArcasAndGMF marker = null;
//    	  [U2T] in Arcas was: 
//        Rectangle bounds = ViewOptionsAccessor.getBounds(frame.getGdeNode().getReference());
//        return  bounds == null || bounds.width == 0;

    	View reference = frame.getGdeNode().getReference();
    	if (false == reference instanceof Node){
    		//strange
    		return false;
    	}
    	LayoutConstraint notationConstraint = ((Node)reference).getLayoutConstraint();
    	if (notationConstraint == null) {
    		return true;
    	}
    	if (notationConstraint instanceof Size){
    		return !((Size)notationConstraint).eIsSet(NotationPackage.eINSTANCE.getSize_Width());
    	}
    	return false;
    }
}