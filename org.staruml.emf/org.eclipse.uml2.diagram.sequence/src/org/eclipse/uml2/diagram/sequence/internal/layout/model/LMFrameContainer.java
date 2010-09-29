package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;

/**
 * 
 */
public class LMFrameContainer {
	
	void addChildFrame(LMFrame childFrame) {
		childFrame.setContainer(mySelfFriendly);
		myChildFrames.add(childFrame);
	}
	public List getChildList() {
		if (myUnmodifiableChildList == null) {
			myUnmodifiableChildList = Collections.unmodifiableList(myChildFrames);
		}
		return myUnmodifiableChildList;
	}
	
	void addChildFoundInvocation(LMFoundInvocationOccurence foundInvocationOccurence) {
		foundInvocationOccurence.setContainer(mySelfFriendly);
		myChildFoundInvocations.add(foundInvocationOccurence);
	}
	public List getFoundInvocationsList() {
		if (myUnmodifiableFoundInvocationsList == null) {
			myUnmodifiableFoundInvocationsList = Collections.unmodifiableList(myChildFoundInvocations);
		}
		return myUnmodifiableFoundInvocationsList;
	}
	
	
	interface ContainerFriendly {
		void childRemove(LMFrame lmFrame);
		void childRemove(LMFoundInvocationOccurence lmFoundInvocationOccurence);
		LMFrameContainer getLMFrameContainer();
	}
	
	private ContainerFriendly mySelfFriendly = new ContainerFriendly() {
		public void childRemove(LMFrame lmFrame) {
			boolean result = myChildFrames.remove(lmFrame);
			if (!result) {
				throw new RuntimeException("Can't remove child"); //$NON-NLS-1$
			}
		}
		public void childRemove(LMFoundInvocationOccurence lmFoundInvocationOccurence) {
			boolean result = myChildFoundInvocations.remove(lmFoundInvocationOccurence);
			if (!result) {
				throw new RuntimeException("Can't remove child"); //$NON-NLS-1$
			}
		}
		public LMFrameContainer getLMFrameContainer() {
			return LMFrameContainer.this;
		}
	};
	private final List myChildFrames = new ArrayList(3);
	private List myUnmodifiableChildList = null;
	
	private final List myChildFoundInvocations = new ArrayList(3);
	private List myUnmodifiableFoundInvocationsList = null;

	public void layoutVerticallyUtiedFrames(int y) {
		for (int i=0; i<myChildFrames.size(); i++) {
			LMFrame frame1 = (LMFrame) myChildFrames.get(i);
			if (frame1.hasAnyMountingLinks()) {
				continue;
			}
			
			y += UntiedFrameVerticalLayouter.layoutAndReturnHeight(frame1, y) + 10;
		}
	}
	
	private static class UntiedFrameVerticalLayouter {
		static int layoutAndReturnHeight(LMFrame lmFrame, final int y) {
			lmFrame.setTopBorderPos(y);
            int yPos = y + lmFrame.getTopInnerPadding();
			
			List childList = lmFrame.getChildList();
			for (int i=0; i<childList.size(); i++) {
				LMFrame childFrame = (LMFrame) childList.get(i);

				yPos += childFrame.getOuterHorizontalPadding();
				int childHeight = layoutAndReturnHeight(childFrame, yPos);
				
				yPos += childHeight;
				yPos += childFrame.getOuterHorizontalPadding();
			}
            
			yPos += lmFrame.getBottomInnerPadding();
            
            
            int minHeight = GeometryConstants.Frames.UNTIED_FRAME_MIN_HEIGHT;
            if (lmFrame instanceof LMVisibleFrameWithPentagon && childList.isEmpty()) {
                LMVisibleFrameWithPentagon visibleFrameWithPentagon = (LMVisibleFrameWithPentagon) lmFrame;
                minHeight = Math.max(minHeight, visibleFrameWithPentagon.getPreferredHeight());
            }
             
            if (yPos < y + minHeight) {
                yPos = y + minHeight;
            }
            
			
			lmFrame.setBottomBorderPos(yPos);
			
			return yPos - y;  
		}
	}
}
