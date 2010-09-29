package org.eclipse.uml2.diagram.sequence.internal.layout.vertical;

import java.util.Collections;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SdLayoutModelAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.SDVerticalLayoutInput;


/**
 * 
 */
public class SDVerticalLayout {
    public interface Config {
        //boolean useOldVerticalLayout();
		//String useOldLayoutString = myConfig.getProperty("option.sequenceDiagram20.debug.useOldVerticalLayout", null);
    }
    
    
	public SDVerticalLayout(SdLayoutModelAccess layoutModelAccess, Config config) {
		myLayoutModelAccess = layoutModelAccess;
	}
	
    /**
     * @param fullLayout
     * @return bottomPos -- most lower position of elements
     */
	public int doLayout(boolean fullLayout, int topPos) {
		SDVerticalLayoutInput input = myLayoutModelAccess.getLayoutModel().getSDVerticalLayoutInput();
        
        int bottomPos;
        
        if (input.doesContainNonvirtual()) {
            //System.out.println("[SDVerticalLayout.doLayout] BEFORE");
    		//dumpVerticalLayoutInput(input);
    		
    		List lifeLinesList = Collections.list(input.lifeLines());
    		
    		LifeLine [] lifeLines = new LifeLine[lifeLinesList.size()];
    		lifeLinesList.toArray(lifeLines);
    
            bottomPos = new NewLayoutSession(lifeLines, fullLayout, topPos).go();
        } else {
            bottomPos = topPos;
        }
        
        //System.out.println("[SDVerticalLayout.doLayout] AFTER");
        //dumpVerticalLayoutInput(input);
		
		myLayoutModelAccess.getLayoutModel().getRootFrameContainer().layoutVerticallyUtiedFrames(topPos+GeometryConstants.Lifeline.SKIP_LIFELINE_FROM_TOP);
        
        return bottomPos;
	}
	
	private final SdLayoutModelAccess myLayoutModelAccess ;
	
//	private void dumpVerticalLayoutInput(SDVerticalLayoutInput input) {
//		for (Enumeration lifelineEnum = input.lifeLines(); lifelineEnum.hasMoreElements(); ) {
//			int priorityDepth = 0;
//			Lifeline lifeLine = (Lifeline) lifelineEnum.nextElement();
//			System.out.println("[SDVerticalLayout.dumpVerticalLayoutInput] lifeline "+lifeLine); //$NON-NLS-1$
//			
//			for (LifeLineIterator it = lifeLine.iterator(); it.hasNext(); ) {
//				it.nextClueValue();
//				
//				LifeLineElement element = it.nextElement();
//				
//				System.out.println("[SDVerticalLayout.dumpVerticalLayoutInput] element "+element); //$NON-NLS-1$
//                System.out.println("[SDVerticalLayout.dumpVerticalLayoutInput]   "+element.getPointOffset()+" + "+(element.getSize() - element.getPointOffset())+"  constraint: "+element.getHorizontalConstraint()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//                System.out.println("[SDVerticalLayout.dumpVerticalLayoutInput]   "+element.getPosition().getPositionValue()); //$NON-NLS-1$
//				
//				LifeLineElement.Position position = element.getPosition();
//				if (position.isFirstPrioritedPosition()) {
//					System.out.println("[SDVerticalLayout.dumpVerticalLayoutInput] first priorited '{'"); //$NON-NLS-1$
//					priorityDepth ++;
//				}
//				if (position.isLastPrioritedPosition()) {
//					System.out.println("[SDVerticalLayout.dumpVerticalLayoutInput] last priorited  '}'"); //$NON-NLS-1$
//					priorityDepth --;
//				}
//			}
//            System.out.println();
//            System.out.println();
//			if (priorityDepth != 0) {
//				throw new RuntimeException("Priority inconsistence"); //$NON-NLS-1$
//			}
//		}
//	}
}
