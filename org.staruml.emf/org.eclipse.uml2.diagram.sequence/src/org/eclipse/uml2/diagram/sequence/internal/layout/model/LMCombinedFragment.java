package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;


/**
 * 
 */
public class LMCombinedFragment extends LMVisibleFrameWithPentagon {
	LMCombinedFragment(AbsNode gdeNode) {
		super(gdeNode);

		/*
		Map.Entry [] entries = {
				new SdElementProblemDataAdapter.Entry("sd20_incosistent_fragment") {
					public Object getValue() {
						if (myHasColorBeforeViolated == null) {
							return null;
						}
						return "Fragment is inconsistent";
					}
				},
				//new Map.Entry
			}; 
		
		SdElementProblemData elementProblemData = new SdElementProblemDataAdapter(Arrays.asList(entries));
		gdeNode.setProperty(SdElementProblemData.GDE_ELEMENT_PROPERTY_NAME, elementProblemData);
		*/
	}
	
	public void checkConsistancy() {
		super.checkConsistancy();
		checkInteractionOperands();
	}
	
	public int getInnerHorizontalPadding() {
		return 0;
	}
	public int getOuterHorizontalPadding() {
		return GeometryConstants.Frames.COMBINED_FRAGMENT_OUTER_SPACE_HORIZONTAL;
	}
    
    public int getTopInnerPadding() {
        return GeometryConstants.Frames.FIRST_INTERATCTION_OPERAND_TOP_OFFSET;
    }

	protected void setX(int x) {
		super.setX(x);
		for (Iterator it = getChildList().iterator(); it.hasNext(); ) {
			LMFrame childFrame = (LMFrame) it.next();
			if (childFrame instanceof LMInteractionOperand) {
				childFrame.setX(x + GeometryConstants.Frames.INTERATCTION_OPERAND_OUTER_SPACE_HORIZONTAL);
			}
		}
	}
	protected void setWidth(int width) {
		super.setWidth(width);
		if (width < 0) {
			width = 0;
		}
		for (Iterator it = getChildList().iterator(); it.hasNext(); ) {
			LMFrame childFrame = (LMFrame) it.next();
			if (childFrame instanceof LMInteractionOperand) {
				childFrame.setWidth(width - 2*GeometryConstants.Frames.INTERATCTION_OPERAND_OUTER_SPACE_HORIZONTAL);
			}
		}
	}
	
	private void checkInteractionOperands() {
		try {
            List operandList = new ArrayList(getChildList().size());
			for (Iterator it = getChildList().iterator(); it.hasNext(); ) {
				LMFrame lmFrame = (LMFrame) it.next();
				if (lmFrame instanceof LMInteractionOperand == false) {
					throw new IncorrectInteractionOperand("'CombinedFragment' contains frame other than 'InteractionOperand'"); //$NON-NLS-1$
				}
				
				LMInteractionOperand interactionOperand = (LMInteractionOperand) lmFrame;
				if (interactionOperand.getMountingLinksList().size() != getMountingLinksList().size()) {
					throw new IncorrectInteractionOperand("'InteractionOperand' tied to wrong number of lifelines"); //$NON-NLS-1$
				}
				operandList.add(lmFrame);
			}
			
			for (Enumeration mountLinksEnum = mountingLinks(); mountLinksEnum.hasMoreElements(); ) {
				LMMountingLink mountingLink1 = (LMMountingLink) mountLinksEnum.nextElement();
				
				LMMountingRegion region1 = mountingLink1.getMountingRegion();
				if (region1 == null) {
					continue;
				}
                LmBracketsList childBracketsList = region1.getChildBracketsList();
                if (operandList.size() != childBracketsList.size()) {
                    throw new IncorrectInteractionOperand("Number of 'MountingRegion's on lifeline differs from number of 'InteractionOperands's"); //$NON-NLS-1$
                }
				int operandIndex = 0;
                for (Iterator it = childBracketsList.iterator(); it.hasNext(); ) {
					LMLifeLineBracket subBracket = (LMLifeLineBracket) it.next();
					if (subBracket instanceof LMMountingRegion == false) {
						throw new IncorrectInteractionOperand("'MountingRegion' on lifeline contains bracket other than 'MountingRegion'"); //$NON-NLS-1$
					}
					LMMountingRegion region2 = (LMMountingRegion) subBracket;
					LMMountingLink mountingLink2 = region2.getMountingLink();
					if (mountingLink2 == null) {
						throw new IncorrectInteractionOperand("'MountingRegion' on lifeline contains sub-'MountingRegion' with no 'MountingLink'"); //$NON-NLS-1$
					}
					LMFrame lmFrame2 = mountingLink2.getFrame();
					if (lmFrame2 == null) {
						throw new IncorrectInteractionOperand("'MountingRegion' on lifeline contains sub-'MountingRegion' with broken 'MountingLink'"); //$NON-NLS-1$
					}
					if (lmFrame2 instanceof LMInteractionOperand == false) {
						throw new IncorrectInteractionOperand("'MountingRegion' on lifeline contains sub-'MountingRegion' tied to some frame other than 'InteractionOperand'"); //$NON-NLS-1$
					}
					LMInteractionOperand interactionOperand = (LMInteractionOperand) lmFrame2;
					
					if (operandList.get(operandIndex) != interactionOperand) {
                        if (operandList.contains(interactionOperand)) {
                            throw new IncorrectInteractionOperand("'MountingRegion' #"+operandIndex+" on lifeline refers to wrong 'InteractionOperand'"); //$NON-NLS-1$ //$NON-NLS-2$
                        } else {
                            throw new IncorrectInteractionOperand("'MountingRegion' on lifeline contains sub-'MountingRegion' tied to some alien 'InteractionOperand'"); //$NON-NLS-1$
                        }
					}
                    
                    operandIndex++;
				}
			}
			
			invalidateCombinedFragment(null);
		} catch (IncorrectInteractionOperand e) {
			invalidateCombinedFragment(e);
		}
	}
	
	private void invalidateCombinedFragment(IncorrectInteractionOperand explanation) {
		if (explanation == null && myHasColorBeforeViolated != null) {
			getGdeNode().setForeground(myHasColorBeforeViolated);
			myHasColorBeforeViolated = null;
		} else if (explanation != null && myHasColorBeforeViolated == null) {
			myHasColorBeforeViolated = getGdeNode().getForeground();
			getGdeNode().setForeground(explanation.getErrorColor());
		}
	}
	
    /**
     *  So far this exception has been used for debug purpose only.
     * 
     * 
     */
	private static class IncorrectInteractionOperand extends Exception {
        IncorrectInteractionOperand(String message) { this(message, Color.RED); }
        IncorrectInteractionOperand(String message, Color errorColor) { this(message, null, errorColor); }
        
        private IncorrectInteractionOperand(String message, Throwable cause, Color errorColor) { 
            super(message, cause);
            myErrorColor = errorColor;
        }
        
        Color getErrorColor() {
            return myErrorColor;
        } 
        
        private final Color myErrorColor;
	}
	
	private Color myHasColorBeforeViolated = null;

	protected int getPentagonOffset() {
		return 1;
	}
}
