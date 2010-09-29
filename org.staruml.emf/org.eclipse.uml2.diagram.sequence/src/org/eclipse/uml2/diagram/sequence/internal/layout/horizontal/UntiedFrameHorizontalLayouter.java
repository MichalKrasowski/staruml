package org.eclipse.uml2.diagram.sequence.internal.layout.horizontal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMVisibleFrameWithPentagon;


/**
 * 
 */
class UntiedFrameHorizontalLayouter {
	UntiedFrameHorizontalLayouter(Collection untiedFrames) {
		int width = 0;
		for (Iterator it = untiedFrames.iterator(); it.hasNext(); ) {
			LMFrame lmFrame = (LMFrame) it.next();
			int res = processRecusivelyReturnWidth(lmFrame, 0);
			
			if (width < res) {
				width = res;
			}
		}
		
		myWidth = width;
	}
	
	int getWidth() {
		return myWidth;
	}
	
	void layout(int x) {
		//System.out.println("[UntiedFrameHorizontalLayouter.layout]");
		for (int i = mySimpleLayoutersReverseOrder.size() - 1; i>=0; i--) {
			SimpleLayouter simpleLayouter = (SimpleLayouter) mySimpleLayoutersReverseOrder.get(i);
			//System.out.println("[UntiedFrameHorizontalLayouter.layout]  i = "+i);
			simpleLayouter.layout(x);
		}
		//System.out.println("[UntiedFrameHorizontalLayouter.layout] done");
	}
	
	private int processRecusivelyReturnWidth(LMFrame lmFrame, int xOffset) {
		int width = 10;
		if (lmFrame instanceof LMVisibleFrameWithPentagon) {
			LMVisibleFrameWithPentagon frameWithPentagon = (LMVisibleFrameWithPentagon) lmFrame;
			int titleWidth = frameWithPentagon.getPreferredWidth() + 10;
			if (titleWidth > width) {
				width = titleWidth;
			}
		}
		
		List childList = lmFrame.getChildList();
		
		for (int i = 0; i<childList.size(); i++) {
			LMFrame childFrame = (LMFrame) childList.get(i);
			int subWidth = processRecusivelyReturnWidth(childFrame, xOffset + 3) + 5;
			if (width < subWidth) {
				width = subWidth;
			}
		}
		
		SimpleLayouter simpleLayouter = new SimpleLayouter(width, xOffset, lmFrame);
		
		mySimpleLayoutersReverseOrder.add(simpleLayouter);
		
		return width;
	}
	
	private final int myWidth;
	private final List mySimpleLayoutersReverseOrder = new ArrayList();
	
	private static class SimpleLayouter {
		SimpleLayouter(int width, int offset, LMFrame lmFrame) {
			myWidth = width;
			myOffset = offset;
			myLmFrame = lmFrame;
		}
		void layout(int baseX) {
			int x = baseX + myOffset;
			myLmFrame.setLeftBorderPosByLayout(x);
			myLmFrame.setRightBorderPosByLayout(x + myWidth);
		}
		private final int myWidth;
		private int myOffset;
		private final LMFrame myLmFrame;
	}
}
