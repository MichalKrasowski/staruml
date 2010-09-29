package org.eclipse.uml2.diagram.sequence.internal.layout.horizontal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.horizontal.FramesManager.FrameInfo;
import org.eclipse.uml2.diagram.sequence.internal.layout.horizontal.LifeLineHorizontalLayouter.PreparedLayout;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMBadElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFoundInvocationOccurence;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrameContainer;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMLifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMMessage;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SdLayoutModelAccess;


/**
 * 
 */
public class SDHorizontalLayout {
    public SDHorizontalLayout(SdLayoutModelAccess layoutModelAccess) {
	    myLayoutModelAccess = layoutModelAccess;
		
		//Model model = mySDLayout.getDiagramEntity().getModel();
	}
    
    public LifelineCoveringFramesCache getLifelineCoveringFramesCache() {
        return myLifelineCoverinngFramesCache;
    }

    private LifelineCoveringFramesCache myLifelineCoverinngFramesCache;

	//private int myTimeToWorkCounter = 20;
	/**
     * @return rightPos 
	 */
	public int applyConstraints(int leftPos, final boolean fullLayout) {
		//System.out.println("[SDHorizontalLayout.applyConstraints] start layout");
		
		List lmLifelinesNonsortedlList = myLayoutModelAccess.getLayoutModel().getLifeLinesList();
		
		List lifelineLayouters = new ArrayList(lmLifelinesNonsortedlList.size());
		
		for (Iterator it = lmLifelinesNonsortedlList.iterator(); it.hasNext(); ) {
			Object nextLifeLineObject = it.next();
			if (nextLifeLineObject instanceof LMLifeLine == false) {
				continue;
			}
			LMLifeLine lmLifeLine = (LMLifeLine) nextLifeLineObject;
			lifelineLayouters.add(new LifeLineHorizontalLayouter(lmLifeLine));
		}
		Collections.sort(lifelineLayouters, ComparableVerticalElement.COMPARATOR);
		
		final FramesManager framesManager = new FramesManager(myLayoutModelAccess.getLayoutModel().getRootFrameContainer().getChildList());
		
		List preparedLayouts = new ArrayList(lifelineLayouters.size());
		
		List lmMessages = new ArrayList();
		
		for (int i=0; i<lifelineLayouters.size(); i++) {
			LifeLineHorizontalLayouter lifeLineHorizontalLayout = (LifeLineHorizontalLayouter) lifelineLayouters.get(i);
			framesManager.setLifeLineIndex(i);
			LifeLineHorizontalLayouter.PreparedLayout preparedLayout1 = lifeLineHorizontalLayout.scanAndPrepareLayout(framesManager, lmMessages);
			preparedLayouts.add(preparedLayout1);
		}
        
        createNewLifelineCoveringFramesCache: {
            myLifelineCoverinngFramesCache = new LifelineCoveringFramesCache();
            for (Iterator frameInfos = framesManager.frameInfos(); frameInfos.hasNext(); ) {
                FramesManager.FrameInfo next = (FrameInfo)frameInfos.next();
                if (next.getMaxLifeLineIndex() == -1) {
                    continue;
                }
                LMLifeLine leftmost = ((LifeLineHorizontalLayouter) lifelineLayouters.get(next.getMinLifeLineIndex())).getLmLifeline();
                LMLifeLine rightmost = ((LifeLineHorizontalLayouter) lifelineLayouters.get(next.getMaxLifeLineIndex())).getLmLifeline();
                myLifelineCoverinngFramesCache.setFrameOutermostLifelines(next.getLMFrame(), leftmost, rightmost);
            }
        }

		final LifeLineDressImpl [] lifeLineDresses = new LifeLineDressImpl [lifelineLayouters.size()];
		for (int i=0; i<lifeLineDresses.length; i++) {
			lifeLineDresses[i] = new LifeLineDressImpl(fullLayout);
		}
		
        int allLifeLinesLeftPos = GeometryConstants.DIAGRAM_LEFT_BORDER_SPACE + leftPos;

		final List foundMessages = new ArrayList(3);
		{
			final List topUntiedFrames = new ArrayList(0);
			
			class FramesAnalizer {
				public void go() {
					processFrameContainerRecursively(myLayoutModelAccess.getLayoutModel().getRootFrameContainer(), topUntiedFrames);
				}
				private void processFrameContainerRecursively(LMFrameContainer frameContainer, Collection untiedFramesOutput) {
					List lmFramesList = frameContainer.getChildList();
					int leftLifeLineIndex = lifeLineDresses.length;
					int rigthLifeLineIndex = -1;
					
					for (int i=0; i<lmFramesList.size(); i++) {
						LMFrame lmFrame = (LMFrame) lmFramesList.get(i);

						if (lmFrame.hasAnyMountingLinks()) {
							processFrameRecursively(lmFrame);
						} else {
							
							untiedFramesOutput.add(lmFrame);
							
							myLeftIndex = lifeLineDresses.length;
							myRightIndex = -1;
						}
						
						if (myLeftIndex < leftLifeLineIndex) {
							leftLifeLineIndex = myLeftIndex; 
						}
						if (myRightIndex > rigthLifeLineIndex) {
							rigthLifeLineIndex = myRightIndex;
						}
					}
					
					myLeftIndex = leftLifeLineIndex;
					myRightIndex = rigthLifeLineIndex;
					
					collectFoundMessages(frameContainer);
				}
				private void processFrameRecursively(LMFrame lmFrame) {
					FramesManager.FrameInfo frameInfo = framesManager.getFrameInfo(lmFrame);

					List innerUntiedFrames = new ArrayList(0);

                    //_outermost_ frame which has just been reshaped 
                    boolean addAsJustReshaped = false;
                    if (!fullLayout && lmFrame.isJustReshaped() && !myOneJustReshapedFrameAlreadyProcessed) {
                        addAsJustReshaped = true;
                        myOneJustReshapedFrameAlreadyProcessed = true;
                    }

                    processFrameContainerRecursively(lmFrame, innerUntiedFrames);
					
					if (myLeftIndex > frameInfo.getMinLifeLineIndex()) {
						myLeftIndex = frameInfo.getMinLifeLineIndex();
					}
					if (myRightIndex < frameInfo.getMaxLifeLineIndex()) {
						myRightIndex = frameInfo.getMaxLifeLineIndex();
					}
					UntiedFrameHorizontalLayouter untiedFrameLayouter;
					if (innerUntiedFrames.isEmpty()) {
						untiedFrameLayouter = null;
					} else {
						untiedFrameLayouter = new UntiedFrameHorizontalLayouter(innerUntiedFrames);
					}
					
                    
                    int maxLeftBracketOffset = (myLeftIndex == frameInfo.getMinLifeLineIndex()) ? 
                                                frameInfo.getMaxLeftBraketPos() : 0; 
                    int maxRightBracketOffset = (myRightIndex == frameInfo.getMaxLifeLineIndex()) ?
                                                 frameInfo.getMaxRightBraketPos() : 0;
                              
					LifeLineDressImpl.LeftSideFrameWrapper leftSideOnTheSameLifeline = lifeLineDresses[myLeftIndex].addLeftFrame(lmFrame, maxLeftBracketOffset, untiedFrameLayouter, addAsJustReshaped);
                    if (myLeftIndex != myRightIndex) {
                        leftSideOnTheSameLifeline = null;
                    }
					lifeLineDresses[myRightIndex].addRightFrame(lmFrame, maxRightBracketOffset, addAsJustReshaped, leftSideOnTheSameLifeline);
				}
				
				private void collectFoundMessages(LMFrameContainer frameContainer) {
					for (Iterator it = frameContainer.getFoundInvocationsList().iterator(); it.hasNext(); ) {
						LMFoundInvocationOccurence foundInvocationOccurence = (LMFoundInvocationOccurence) it.next();
						foundMessages.addAll(foundInvocationOccurence.getOutgoingLMMessages());
					}
				}
				
				private int myLeftIndex;
				private int myRightIndex;
                
                private boolean myOneJustReshapedFrameAlreadyProcessed = false;
			}
			new FramesAnalizer().go();
			
			if (!topUntiedFrames.isEmpty()) {
				UntiedFrameHorizontalLayouter untiedFrameHorizontalLayouter = new UntiedFrameHorizontalLayouter(topUntiedFrames);
				
				untiedFrameHorizontalLayouter.layout(allLifeLinesLeftPos);
				
				allLifeLinesLeftPos += untiedFrameHorizontalLayouter.getWidth() + GeometryConstants.DIAGRAM_LEFT_BORDER_SPACE;
			}
		}
        
       
		final int farAwayX;
		{
			int posX = allLifeLinesLeftPos;
			for (int i=0; i<preparedLayouts.size(); i++) {
				LifeLineHorizontalLayouter.PreparedLayout preparedLayout1 = (PreparedLayout) preparedLayouts.get(i);
				int currentCenterPos = preparedLayout1.getCurrentCenterPos();
				
				int newCenterPos = posX + Math.max(preparedLayout1.getLeftHalfWidth(), lifeLineDresses[i].getLeftMinSpace());
				
				if (!fullLayout && currentCenterPos > newCenterPos) {
					newCenterPos = currentCenterPos;
				}
				
				preparedLayout1.layout(newCenterPos);
                
                lifeLineDresses[i].setMinLeftAndCenter(posX, newCenterPos);//do it before lifeLineDresses[i].getRightMinSpace()
                
                int maxRightPos = newCenterPos + Math.max(preparedLayout1.getRightHalfWidth(), lifeLineDresses[i].getRightMinSpace());
                if (i+1 < preparedLayouts.size()) {
                    LifeLineHorizontalLayouter.PreparedLayout nextPreparedLayout = (PreparedLayout) preparedLayouts.get(i+1);
                    int nextLifelineMinCurrentLeftPos = nextPreparedLayout.getCurrentCenterPos() - Math.max(nextPreparedLayout.getLeftHalfWidth(), lifeLineDresses[i+1].getLeftMinSpace());
                    maxRightPos = Math.max(maxRightPos, nextLifelineMinCurrentLeftPos-GeometryConstants.SPACE_BETWEEN_LIFE_LINES_HORIZONTAL);
                } else {
                    maxRightPos = Integer.MAX_VALUE;
                }
                
                lifeLineDresses[i].setMaxRight(newCenterPos, maxRightPos);
				lifeLineDresses[i].layout(newCenterPos);
				
                assert lifeLineDresses[i].getRightSpace() <= maxRightPos;
				posX = newCenterPos + Math.max(preparedLayout1.getRightHalfWidth(), lifeLineDresses[i].getRightSpace()) + GeometryConstants.SPACE_BETWEEN_LIFE_LINES_HORIZONTAL;
                
			}
			farAwayX = posX + GeometryConstants.Lifeline.MINIMAL_HORIZONTAL_DISTANCE;
		}
		
		for (Iterator it = lmMessages.iterator(); it.hasNext(); ) {
			LMMessage message = (LMMessage) it.next();
			message.layoutHorizontally(fullLayout);
		}

		for (Iterator it = foundMessages.iterator(); it.hasNext(); ) {
			LMMessage message = (LMMessage) it.next();
			message.layoutHorizontally(fullLayout);
		}

		{
			int badElementXPos = farAwayX;
			for (Iterator it = myLayoutModelAccess.getLayoutModel().getBadElementsList().iterator(); it.hasNext(); ) {
				LMBadElement badElement = (LMBadElement) it.next();
				int width = badElement.layoutAndReturnWidth(badElementXPos);
				badElementXPos += width + 5;
			}
            
            return badElementXPos;
		}
		//System.out.println("[SDHorizontalLayout.applyConstraints] finish layout");
	}

	private final SdLayoutModelAccess myLayoutModelAccess;
}