package org.eclipse.uml2.diagram.sequence.internal.layout.horizontal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame;

/**
 * 
 */
class FramesManager {
	FramesManager(List lmRootFramesList) {
//		myRootFramesList = lmRootFramesList;
		myLMFrame2frameInfo = new HashMap(lmRootFramesList.size());
		
		createFrameInfos(lmRootFramesList);
	}
	
	public Iterator frameInfos() {
		return myLMFrame2frameInfo.values().iterator();
    }
    
	int getLifeLineIndex() {
		return myLifeLineIndex;
	}
	void setLifeLineIndex(int index) {
		myLifeLineIndex = index;
	}
	public FrameInfo frameReferenceStarted(LMFrame lmFrame) {
		FrameInfo frameInfo = getFrameInfo(lmFrame);
		frameInfo.tieToLifeLine(myLifeLineIndex);
        return frameInfo;
	}
	public void frameReferenceFinished(LMFrame lmFrame) {
		lmFrame.checkConsistancy();
	}
	
	public FrameInfo getFrameInfo(LMFrame lmFrame) {
		FrameInfo result = (FrameInfo) myLMFrame2frameInfo.get(lmFrame);
		if (result == null) {
			throw new RuntimeException("Unknown frame"); //$NON-NLS-1$
		}
		return result;
	}
	
    boolean isCurrentLifelineOutermost(FrameInfo info) {
        return myLifeLineIndex == info.getMinLifeLineIndex() || myLifeLineIndex == info.getMaxLifeLineIndex();
    }
    
	private void createFrameInfos(List lmFramesList) {
		for (int i=0; i<lmFramesList.size(); i++) {
			LMFrame lmFrame = (LMFrame) lmFramesList.get(i);
			
			myLMFrame2frameInfo.put(lmFrame, new FrameInfo(lmFrame));
			createFrameInfos(lmFrame.getChildList());
		}
	}
	/*
	public void processUntiedFrames() {
		for (int i=0; i<myRootFramesList.size(); i++) {
			LMFrame frame1 = (LMFrame) myRootFramesList.get(i);
			FrameInfo frameInfo = getFrameInfo(frame1);
			if (frameInfo.getMaxLifeLineIndex() == -1) {
				nextLifeLine();
				processUntiedFramesRecursively(frameInfo);
			}
		}
	}
	private void processUntiedFramesRecursively(FrameInfo frameInfo) {
		frameInfo.tieToLifeLine(myLifeLineIndex);
		List childFramesList = frameInfo.getLMFrame().getChildList();
		for (int i=0; i<childFramesList.size(); i++) {
			LMFrame childFrame = (LMFrame) childFramesList.get(i);
			FrameInfo childFrameInfo = getFrameInfo(childFrame);
			processUntiedFramesRecursively(childFrameInfo);
		}
	}
	*/
	
	private int myLifeLineIndex;
	private Map myLMFrame2frameInfo;
//	private final List myRootFramesList;
	
	static class FrameInfo {
		FrameInfo(LMFrame lmFrame) {
			myLMFrame = lmFrame;
		}
		
		LMFrame getLMFrame() {
			return myLMFrame;
		}
        
        void setMaxBracketPos(int lifeline, int maxLeftBraketPos, int maxRightBraketPos) {
            if (myMinLifeLineIndex == lifeline) {
                myMaxLeftBraketPos = maxLeftBraketPos;
            } 
            if (myMaxLifeLineIndex == lifeline) {
                myMaxRightBraketPos = maxRightBraketPos;
            }
        }
        int getMaxLeftBraketPos() {
            return myMaxLeftBraketPos;
        }
        int getMaxRightBraketPos() {
            return myMaxRightBraketPos;
        } 
        
        private int myMaxLeftBraketPos;
        private int myMaxRightBraketPos;
        
		void tieToLifeLine(int lifeLineIndex) {
			if (myMaxLifeLineIndex == -1) {
				myMaxLifeLineIndex = lifeLineIndex;
				myMinLifeLineIndex = lifeLineIndex;
			} else {
				if (myMaxLifeLineIndex < lifeLineIndex) {
					myMaxLifeLineIndex = lifeLineIndex;
                    myMaxRightBraketPos = 0;
				}
				if (myMinLifeLineIndex > lifeLineIndex) {
					myMinLifeLineIndex = lifeLineIndex;
                    myMaxLeftBraketPos = 0;
				}
			}
		}
		int getMaxLifeLineIndex() {
			return myMaxLifeLineIndex;
		}
		int getMinLifeLineIndex() {
			return myMinLifeLineIndex;
		}
		public String toString() {
			return "<FrameInfo:hasParent="+(myParentFrameInfo!=null) //$NON-NLS-1$
				+":myMaxLifeLineIndex="+myMaxLifeLineIndex+":myMinLifeLineIndex="+myMinLifeLineIndex //$NON-NLS-1$ //$NON-NLS-2$
				+">"; //$NON-NLS-1$
		}		
		
		
		
		private final LMFrame myLMFrame;
		private FrameInfo myParentFrameInfo = null;
		private int myMaxLifeLineIndex = -1; 
		private int myMinLifeLineIndex = -1;
	}
}