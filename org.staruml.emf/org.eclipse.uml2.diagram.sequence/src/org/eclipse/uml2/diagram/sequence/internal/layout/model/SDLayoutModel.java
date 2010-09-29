package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsDiagram;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLinkEnumeration;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNodeEnumeration;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.SDVerticalLayoutInput;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;


/**
 * Stateful model. Data structure to implement layout. Updated from gde events.
 * 
 */
public class SDLayoutModel {
    public SDLayoutModel(AbsDiagram gdeDiagram, boolean readInitialData, LmAlienElement.Factory alienElementfactory, Config diagramConfig, RootElementsGetter interactionEntityGetter) {
        //System.out.println("[SDLayoutModel.SDLayoutModel] debug");
        myGdeDiagram = gdeDiagram;
        myDiagramEntity = gdeDiagram.getInteraction();
        if (myDiagramEntity == null) {
            throw new RuntimeException("Cannot get diagram entity"); //$NON-NLS-1$
        }
        myAlienElementfactory = alienElementfactory;
        if (interactionEntityGetter == null) {
            interactionEntityGetter = new RootElementsGetter() {
                public Interaction getInteractionEntity() {
                    return myDiagramEntity;
                }
                public View getInteractionView() {
                	return myGdeDiagram.getInteractionView();
                }
                public AbsNode getRootNode() {
                    return myGdeDiagram.getRootNode();
                }
            };
        }
        myRootElementsGetter = interactionEntityGetter;
        //myUniqueNameService = UniqueNameService.Util.getService(model);
        
        
        
        myLmOwner = new LmOwnerImpl(diagramConfig);
        
        
        if (readInitialData) {
            initialFill();
        }
        {
            // fake lifeline (very long)            
            LMFakeLifeLine fakeLifeLine = new LMFakeLifeLine(GeometryConstants.Lifeline.MINIMUM_HEIGHT);
            myLifeLinesArray.add(fakeLifeLine);
            
            myTopLineConstraint.getLifeLineElementsList().add(fakeLifeLine.getFirstLifeLineElement());
            fakeLifeLine.getFirstLifeLineElement().setHorizontalConstraint(myTopLineConstraint);
            
            myBottomLineConstraint.getLifeLineElementsList().add(fakeLifeLine.getLastLifeLineElement());
            fakeLifeLine.getLastLifeLineElement().setHorizontalConstraint(myBottomLineConstraint);
        }
    }
    
    public interface Config {
    
    }
    public interface RootElementsGetter {
        Interaction getInteractionEntity();
        View getInteractionView();
        AbsNode getRootNode();
    }
    
    public LmObjectsResolver getLmObjectsResolver() {
        return myLmObjectsResolver;
    }
    
    public SdLayoutModelAddRemoveProcessor newAddRemoveProcessor() {
        if (myAddRemoveElementsProcessor != null) {
            throw new IllegalStateException("Previous AddRemoveProcessor hasn't finished yet"); //$NON-NLS-1$
        }
        myAddRemoveElementsProcessor = new AddRemoveElementsProcessor();
        return myAddRemoveElementsProcessor;
    }
    
    public SDVerticalLayoutInput getSDVerticalLayoutInput() {
        return new SDVerticalLayoutInputImpl(this);
    }
    public List getLifeLinesList() {
        return myLifeLinesArrayImmutable;
    }
    
    public LMFrameContainer getRootFrameContainer() {
        return myRootFramesContainer;
    }
    
    public List getBadElementsList() {
        return myBadElements;
    }
    
    void addBracketToContainer(LMLifeLineBracket lifeLineBracket, LMBracketContainer bracketContainer) {
        bracketContainer.getChildBracketsList().add(lifeLineBracket);
        lifeLineBracket.setContainer(bracketContainer);
    }
    
    public State getState() {
        return myState;
    }
     
    public class State {
        public boolean isConstructionCompleted() {
            return myConstructionCompleted;
        }
        
        void setConstructionCompleted(boolean constructionCompleted) {
            myConstructionCompleted = constructionCompleted;
        }
        
        private boolean myConstructionCompleted = true;
    }
    
    
    
    
    
    
    
    
    private class AddRemoveElementsProcessor implements SdLayoutModelAddRemoveProcessor {
        public boolean processAddedGdeNode(AbsNode gdeNode) {
            assert isProcessorActive();
            //System.out.println("[AddRemoveElementsProcessor] processAddedGdeNode gdeNode = " + gdeNode);
            if (myGdeElement2lmElement.get(gdeNode) != null) {
                /*
                // assert
                Object lmGenObject = myGdeElement2lmElement.get(gdeNode);
                if (lmGenObject instanceof LMLifeLineBracket) {
                    LMLifeLineBracket testLifeLineBracket = (LMLifeLineBracket) lmGenObject;
                    GdeElement parentElement = gdeNode.getParentGdeElement();
                    Object parentContainerX = myGdeElement2lmElement.get(parentElement); 
                    if (parentContainerX != testLifeLineBracket.getContainer()) {
                        throw new RuntimeException(parentContainerX+" != "+testLifeLineBracket.getContainer());
                    }
                }
                */
                return false;
            }
            
            final EObject nodeEntity = gdeNode.getModelEntity();
            
            //System.out.println("[SDLayoutModel.processAddedGdeNode] nodeEntity="+Util.toString(nodeEntity));
            if (nodeEntity == null) {
                return addAlienGdeNode(gdeNode);
            }
            AbsElement parentGdeElement = gdeNode.getParentGdeElement();
            if (myRootElementsGetter.getRootNode().equals(parentGdeElement)) {
                //System.out.println("[SDLayoutModel.processAddedGdeNode] parent -- diagram");
                //if (gdeNode.getProperty(SdLayoutConstants.VIEWMAPPED_AS_ALIEN_SHORTCUT) != null) {
                if (AbsElementPropertyAccess.getInstance().isViewmappedAsAlienShortcut(gdeNode)) {
                    //System.out.println("[SDLayoutModel.processAddedGdeNode] bad note");
                    addBadNode(gdeNode);
                    return true;
                }
                
//                if (myMetainfo.hasMetaclass(nodeEntity, SD20_Lifeline.METACLASS)) {
//                    //System.out.println("[SDLayoutModel.processAddedGdeNode] add lifeline");
//                    addLifeLine(gdeNode, nodeEntity);
//                    return true;
//                } else if (myMetainfo.hasMetaclass(nodeEntity, SD20_Int_Frame.METACLASS)) {
//                    LMFrame lmFrame = addFrame(gdeNode, nodeEntity, null);
//                    return lmFrame != null;
//                } else if (myMetainfo.hasMetaclass(nodeEntity, SD20_Int_InvocationSpecification.METACLASS)) {
//                    LMFoundInvocationOccurence lmFoundInvocationOccurence = addFoundInvocationOccurence(gdeNode, nodeEntity, null);
//                    return lmFoundInvocationOccurence != null;
//                }

                if (nodeEntity instanceof Lifeline) {
                    //System.out.println("[SDLayoutModel.processAddedGdeNode] add lifeline");
                    addLifeLine(gdeNode, nodeEntity);
                    return true;
                } else if (MissedMethods._arcasMetamodelSpecific().isFrame(nodeEntity)) {
                    LMFrame lmFrame = addFrame(gdeNode, nodeEntity, null);
                    return lmFrame != null;
                } else if (MissedMethods._arcasMetamodelSpecific().isFoundMessageInvocation(nodeEntity)) {
                    LMFoundInvocationOccurence lmFoundInvocationOccurence = addFoundInvocationOccurence(gdeNode, nodeEntity, null);
                    return lmFoundInvocationOccurence != null;
                }
                
                return addAlienGdeNode(gdeNode);
            } else {
                //System.out.println("[SDLayoutModel.processAddedGdeNode] should be bracket");
                
                Object parentLmElement;

                {
                    if (parentGdeElement instanceof AbsNode == false) {
                        return addAlienGdeNode(gdeNode);
                    }
                    AbsNode parentGdeNode = (AbsNode) parentGdeElement;
                    parentLmElement = myGdeElement2lmElement.get(parentGdeNode);
                    if (parentLmElement == null) {
                        return addAlienGdeNode(gdeNode);
                    }
                }

                if (parentLmElement instanceof LMBracketContainer) {
                    LMBracketContainer lmBracketContainer = (LMBracketContainer)parentLmElement;

                    LMLifeLineBracket lmLifeLineBracket = lmBracketContainer.createChildBracketInstance(gdeNode, gdeNode.getReference());
                    
                    if (lmLifeLineBracket == null) {
                        return false;
                    }
                    
                    lmBracketContainer.getChildBracketsList().add(lmLifeLineBracket);
                    
                    addPossibleUnorderedContainter(lmBracketContainer);
                    
                    lmLifeLineBracket.setContainer(lmBracketContainer);
                    
                    myGdeElement2lmElement.put(gdeNode, lmLifeLineBracket);
                    //System.out.println("[SDLayoutModel.processAddedGdeNode] PUT "+gdeNode+" "+lmLifeLineBracket);
                    return true;
                } else if (parentLmElement instanceof LMFrame) {
                    
                    LMFrame parentLMFrame = (LMFrame) parentLmElement;
                    
                    return addChildToFrame(parentLMFrame, gdeNode, nodeEntity);
                    
                } else {
                    return addAlienGdeNode(gdeNode);
                }
            }
        }
        private boolean addAlienGdeNode(AbsNode gdeNode) {
            myGdeElement2lmElement.put(gdeNode, myAlienElementfactory.createAlienNode(gdeNode));
            return true;
        }
        
        private LMLifeLine addLifeLine(AbsNode lifeLineNode, EObject lifeLineEntity) {
            //System.out.println("[SDLayoutModel.addLifeLine] debug");
            if (myGdeElement2lmElement.get(lifeLineNode) != null) {
                throw new RuntimeException("Lifeline gde element already added to model: "+lifeLineNode); //$NON-NLS-1$
            }
            
            //TODO: uncomment when getInteractionEntity() result is valid
            if (lifeLineEntity.eContainer() != getInteractionEntity()) {
                addBadNode(lifeLineNode);
                return null;
            }
                    
            LMLifeLine lmLifeLine = new LMLifeLine(lifeLineNode, LmBracketsMetamodel.LIFE_LINE_META_OBJECT, myLmOwner);
            //System.out.println("[SDLayoutModel.addLifeLine] lifeline created");

            myGdeElement2lmElement.put(lifeLineNode, lmLifeLine);
            myLifeLinesArray.add(lmLifeLine);
            
            addPossibleUnorderedContainter(myLifeLinesArray);
            
            if (READ_GDE_CONTENT_MYSELF) {
                readBrackets(lifeLineNode, lmLifeLine, LmBracketsMetamodel.LIFE_LINE_META_OBJECT);
            }
            
            //System.out.println("[SDLayoutModel.addLifeLine] add to constraint");
            myTopLineConstraint.getLifeLineElementsList().add(lmLifeLine.getFirstLifeLineElement());
            lmLifeLine.getFirstLifeLineElement().setHorizontalConstraint(myTopLineConstraint);
            
            myBottomLineConstraint.getLifeLineElementsList().add(lmLifeLine.getLastLifeLineElement());
            lmLifeLine.getLastLifeLineElement().setHorizontalConstraint(myBottomLineConstraint);
            
            return lmLifeLine;
        }

        private boolean addChildToFrame(LMFrame parentLMFrame, AbsNode gdeNode, EObject nodeEntity) {
            //System.out.println("[SDLayoutModel.processAddedGdeNode] parent is lm frame: "+parentLMFrame);
            if (MissedMethods._arcasMetamodelSpecific().isFrame(nodeEntity)) {
                LMFrame lmFrame = addFrame(gdeNode, nodeEntity, parentLMFrame);
                //System.out.println("[SDLayoutModel.processAddedGdeNode] frame added: "+lmFrame);
                return lmFrame != null;
            } else if (MissedMethods._arcasMetamodelSpecific().isFoundMessageInvocation(nodeEntity)) {
                LMFoundInvocationOccurence lmFoundInvocationOccurence = addFoundInvocationOccurence(gdeNode, nodeEntity, parentLMFrame);
                return lmFoundInvocationOccurence != null;
            } else {
                return addAlienGdeNode(gdeNode);
            }
            
        }
        private LMFrame addFrame(AbsNode frameNode, EObject frameEntity, LMFrame parentFrame) {
            //System.out.println("[SDLayoutModel.addFrame] frameNode="+frameNode);
            //System.out.println("[SDLayoutModel.addFrame] parentFrame="+parentFrame);
            if (myGdeElement2lmElement.get(frameNode) != null) {
                throw new RuntimeException("Frame gde element already added to model: "+frameNode); //$NON-NLS-1$
            }
            if (parentFrame == null && frameEntity.eContainer() != getInteractionEntity()) {
                addBadNode(frameNode);
                return null;
            }
                    
            
            LMFrame lmFrame;

            //System.out.println("[SDLayoutModel.addFrame] trying "+Util.toString(frameEntity));
            
            if (frameEntity instanceof CombinedFragment) {
                lmFrame = new LMCombinedFragment(frameNode);
            } else if (frameEntity instanceof InteractionUse) {
                lmFrame = new LMInteractionOccurence(frameNode);
            } else if (frameEntity instanceof InteractionOperand) {
                lmFrame = new LMInteractionOperand(frameNode);
            } else {
                return null;
            }
            //System.out.println("[SDLayoutModel.addFrame] lmFrame="+lmFrame);
            
            myGdeElement2lmElement.put(frameNode, lmFrame);
        
            if (parentFrame == null) {
                myRootFramesContainer.addChildFrame(lmFrame);
            } else {
                parentFrame.addChildFrame(lmFrame);
            }

            if (READ_GDE_CONTENT_MYSELF) {
                readFrameChildren(frameNode, lmFrame);
            }
            
            return lmFrame;
        }
        
        private void readFrameChildren(AbsNode frameNode, LMFrame lmFrame) {
            for (AbsNodeEnumeration nodeEnum = frameNode.subnodes(); nodeEnum.hasMoreElements(); ) {
                AbsNode nextNode = nodeEnum.nextGdeNode();
                EObject nodeEntity = nextNode.getModelEntity();
                if (nodeEntity != null) {
                    addChildToFrame(lmFrame, nextNode, nodeEntity);
                }
            }
        }
        
        private LMFoundInvocationOccurence addFoundInvocationOccurence(AbsNode invocationNode, EObject invocationEntity, LMFrame parentFrame) {
            //System.out.println("[SDLayoutModel.addFrame] frameNode="+frameNode);
            //System.out.println("[SDLayoutModel.addFrame] parentFrame="+parentFrame);
            if (myGdeElement2lmElement.get(invocationNode) != null) {
                throw new RuntimeException("Found invocation gde element already added to model: "+invocationNode); //$NON-NLS-1$
            }
            if (parentFrame == null && invocationEntity.eContainer() != getInteractionEntity()) {
                addBadNode(invocationNode);
                return null;
            }
            
            LMFoundInvocationOccurence lmFoundInvocationOccurence;

            //System.out.println("[SDLayoutModel.addFrame] trying "+Util.toString(frameEntity));
            
            if (MissedMethods._arcasMetamodelSpecific().isFoundMessageInvocation(invocationEntity)) {
                lmFoundInvocationOccurence = new LMFoundInvocationOccurence(invocationNode, parentFrame);
            } else {
                return null;
            }
            //System.out.println("[SDLayoutModel.addFrame] lmFrame="+lmFrame);
            
            myGdeElement2lmElement.put(invocationNode, lmFoundInvocationOccurence);
        
            if (parentFrame == null) {
                myRootFramesContainer.addChildFoundInvocation(lmFoundInvocationOccurence);
            } else {
                parentFrame.addChildFoundInvocation(lmFoundInvocationOccurence);
            }
            
            return lmFoundInvocationOccurence;
        }
        
        LMBadElement.Node addBadNode(AbsNode gdeNode) {
            LMBadElement.Node badNode = new LMBadElement.Node(gdeNode);
            myBadElements.add(badNode);
            myGdeElement2lmElement.put(gdeNode, badNode);
            return badNode;
        }


        
        
        private void readBrackets(AbsNode gdeNode, LMBracketContainer bracketContainer, BracketMetaObject bracketMetaObject) {
            for (AbsNodeEnumeration nodeEnum = gdeNode.subnodes(); nodeEnum.hasMoreElements(); ) {
                AbsNode subNode1 = nodeEnum.nextGdeNode();
                View subNodeReference = subNode1.getReference();
                if (subNodeReference == null) {
                    continue;
                }
                
                BracketMetaObject childMetaObject = bracketMetaObject.getChildBracketMetaObject(subNodeReference);
                if (childMetaObject == null) {
                    continue;
                }
                
                if (myGdeElement2lmElement.get(subNode1) != null) {
                    throw new RuntimeException("GdeNode already added to model"); //$NON-NLS-1$
                }
                LMLifeLineBracket lifeLineBracket = childMetaObject.createChildBracket(subNode1, myLmOwner);
                
                if (lifeLineBracket != null) {
                    addBracketToContainer(lifeLineBracket, bracketContainer);
                    //new Exception("PUT "+subNode1+" "+lifeLineBracket).printStackTrace(System.out);
                    // System.out.println("[SDLayoutModel.readBrackets] PUT "+subNode1+" "+lifeLineBracket);
                    myGdeElement2lmElement.put(subNode1, lifeLineBracket);
                    
                    readBrackets(subNode1, lifeLineBracket, childMetaObject);
                }
                
            }
            
            bracketContainer.reorderAfterReading();
        }
        
        public boolean processAddedGdeLink(AbsLink gdeLink) {
            assert isProcessorActive();
            
            //System.out.println("[SDLayoutModel.processAddedLink] gdeLink="+gdeLink);
            if (myGdeElement2lmElement.get(gdeLink) != null) {
                //throw new RuntimeException("GdeLink already added"); //$NON-NLS-1$
            	return false;
            }
            
            if (MissedMethods._arcasMetamodelSpecific().isAlienLink(gdeLink)) {
                return addedAlienLink(gdeLink);
            }
            
            if (MissedMethods._arcasMetamodelSpecific().isMessageLink(gdeLink)) {
            	//EObject linkEntity = gdeLink.getModelEntity();
                //System.out.println("[SDLayoutModel.processAddedLink] should be message");
                AbsElement gdeSource = gdeLink.getSource();
                AbsElement gdeDestination = gdeLink.getDestination();
                
                Object sourceLMObject = myGdeElement2lmElement.get(gdeSource);
                Object destinationLMObject = myGdeElement2lmElement.get(gdeDestination);
                
                boolean isCallMessage;
                LMReceiveMessageEnd lmReceiveMessageEnd;
                LMSendMessageEnd lmSendMessageEnd; 
                //System.out.println("[SDLayoutModel.processAddedLink] trying source/destination");
                if (destinationLMObject instanceof LMReceiveMessageEnd && sourceLMObject instanceof LMSendMessageEnd) {
                    isCallMessage = true;
                    lmReceiveMessageEnd = (LMReceiveMessageEnd) destinationLMObject;
                    lmSendMessageEnd = (LMSendMessageEnd) sourceLMObject;
                } else if (sourceLMObject instanceof LMReceiveMessageEnd && destinationLMObject instanceof LMSendMessageEnd) {
                    isCallMessage = false;
                    lmReceiveMessageEnd = (LMReceiveMessageEnd) sourceLMObject;
                    lmSendMessageEnd = (LMSendMessageEnd) destinationLMObject;
                } else {
                    //System.out.println("[SDLayoutModel.processAddedLink] didn't matched");
                    return false;
                }
                
                LMMessage lmMessage;

                LMMessageEnd.Positioning sendPositioning = lmSendMessageEnd.getPositioning(); 
                LMMessageEnd.Positioning receivePositioning = lmReceiveMessageEnd.getPositioning(); 
                
                if (sendPositioning instanceof LMMessageEnd.FloatingPositioning) {
                    //System.out.println("[SDLayoutModel.processAddedLink] send is floating");
                    
                    LMMessageEnd.FloatingPositioning floatingPositioning = (LMMessageEnd.FloatingPositioning)sendPositioning;
                    if (receivePositioning instanceof LMReceiveMessageEnd.HorizontalPositioning == false) {
                        //System.out.println("[SDLayoutModel.processAddedLink] bad receive positioning");
                        return false;
                    }
                    LMReceiveMessageEnd.HorizontalPositioning receiveHorizontalPositioning = (LMReceiveMessageEnd.HorizontalPositioning)receivePositioning;
                    
                    LMFoundMessage foundMessage = new LMFoundMessage(gdeLink, isCallMessage); 
                    
                    foundMessage.setSendMessageEnd(lmSendMessageEnd, floatingPositioning);
                    foundMessage.setReceiveMessageEnd(lmReceiveMessageEnd, receiveHorizontalPositioning);
                    
                    lmMessage = foundMessage;
                    //System.out.println("[SDLayoutModel.processAddedLink] found message created");
                } else {
                    if (sendPositioning instanceof LMSendMessageEnd.HorizontalPositioning == false) {
                        return false;
                    }
                    if (receivePositioning instanceof LMReceiveMessageEnd.HorizontalPositioning == false) {
                        return false;
                    }
                    
                    boolean isAsynchronous = MissedMethods._arcasMetamodelSpecific().isAsynchonousMessage(gdeLink);
                    
                    LMSendMessageEnd.HorizontalPositioning sendHorizontalPositioning = (LMSendMessageEnd.HorizontalPositioning)sendPositioning;
                    LMReceiveMessageEnd.HorizontalPositioning receiveHorizontalPositioning = (LMReceiveMessageEnd.HorizontalPositioning)receivePositioning;
                    
                    if (sendHorizontalPositioning.getLifeLine() == receiveHorizontalPositioning.getLifeLine() && receiveHorizontalPositioning.getLifeLine() != null) {
                        LMSelfMessage selfMessage = new LMSelfMessage(gdeLink, isCallMessage, isAsynchronous);
                        
                        LMMessageEnd.VerticalConstraintedPositioning sendVerticalPositioning = (LMMessageEnd.VerticalConstraintedPositioning)sendPositioning;
                        LMMessageEnd.VerticalConstraintedPositioning receiveVerticalPositioning = (LMMessageEnd.VerticalConstraintedPositioning)receivePositioning;
                        
                        selfMessage.setSendMessageEnd(lmSendMessageEnd, sendVerticalPositioning, sendHorizontalPositioning);
                        selfMessage.setReceiveMessageEnd(lmReceiveMessageEnd, receiveVerticalPositioning, receiveHorizontalPositioning);
                        
                        lmMessage = selfMessage;
                    } else {
                        if (isCallMessage) {
                            if (sendPositioning instanceof LMMessageEnd.VerticalConstraintedPositioning == false) {
                                return false;
                            }
                            if (receivePositioning instanceof LMMessageEnd.VerticalConstraintedPositioning == false) {
                                return false;
                            }
                            LMMessageEnd.VerticalConstraintedPositioning sendVerticalPositioning = (LMMessageEnd.VerticalConstraintedPositioning)sendPositioning;
                            LMMessageEnd.VerticalConstraintedPositioning receiveVerticalPositioning = (LMMessageEnd.VerticalConstraintedPositioning)receivePositioning;
                            
                            LMCallMessage lmCallMessage;
                            
                            if (isAsynchronous) {
                                lmCallMessage = new LMCallMessageAsynch(gdeLink);
                            } else {
                                lmCallMessage = new LMCallMessageSynch(gdeLink);
                            }
                            
                            lmCallMessage.setSendMessageEnd(lmSendMessageEnd, sendVerticalPositioning, sendHorizontalPositioning);
                            lmCallMessage.setReceiveMessageEnd(lmReceiveMessageEnd, receiveVerticalPositioning, receiveHorizontalPositioning);
                            
                            lmMessage = lmCallMessage;
                        } else {
                            LMReturnMessage lmReturnMessage = new LMReturnMessage(gdeLink, MissedMethods._arcasMetamodelSpecific().isAsynchonousMessage(gdeLink)); 
                            
                            lmReturnMessage.setSendMessageEnd(lmSendMessageEnd, sendHorizontalPositioning);
                            lmReturnMessage.setReceiveMessageEnd(lmReceiveMessageEnd, receiveHorizontalPositioning);
                            
                            lmMessage = lmReturnMessage;
                        }
                    }
                }
                
                //System.out.println("[SDLayoutModel.processAddedLink] lmMessage = "+lmMessage);
                
                lmReceiveMessageEnd.addMessage(lmMessage);
                lmSendMessageEnd.addMessage(lmMessage);
                //System.out.println("[SDLayoutModel.processAddedLink] lmSendMessageEnd="+lmSendMessageEnd);
                //System.out.println("[SDLayoutModel.processAddedLink] lmReceiveMessageEnd="+lmReceiveMessageEnd);
                
                lmMessage.becomeLayoutConstraint(true);
                
                myGdeElement2lmElement.put(gdeLink, lmMessage);
                
                return true;
            } else if (MissedMethods._arcasMetamodelSpecific().isMountingLink(gdeLink)) {
                //System.out.println("[SDLayoutModel.processAddedLink] mounting link found : "+gdeLink);
                AbsElement gdeSource = gdeLink.getSource();
                AbsElement gdeDestination = gdeLink.getDestination();
                
                Object sourceLMObject = myGdeElement2lmElement.get(gdeSource);
                Object destinationLMObject = myGdeElement2lmElement.get(gdeDestination);
                
                if (sourceLMObject instanceof LMMountingRegion == false) {
                    //System.out.println("[SDLayoutModel.processAddedLink] problem 1");
                    return false;
                }
                if (destinationLMObject instanceof LMFrame == false) {
                    //System.out.println("[SDLayoutModel.processAddedLink] problem 2");
                    return false; 
                }
                LMMountingRegion sourceMoutingPoint = (LMMountingRegion) sourceLMObject;
                LMFrame destinationFrame = (LMFrame) destinationLMObject;

                if (sourceMoutingPoint.getMountingLink() != null) {
                    addBadLink(gdeLink);
                    return true;
                }
                
                LMMountingLink mountingLink = new LMMountingLink(gdeLink);
                
                mountingLink.setMountingRegion(sourceMoutingPoint);
                mountingLink.setFrame(destinationFrame);
                sourceMoutingPoint.setMountLink(mountingLink);
                destinationFrame.addMountingLink(mountingLink);
                
                myGdeElement2lmElement.put(gdeLink, mountingLink);
                //System.out.println("[SDLayoutModel.processAddedLink] created");

                return true;            
            } else {
                return addedAlienLink(gdeLink);
            }
        }
        boolean addedAlienLink(AbsLink gdeLink) {
            myGdeElement2lmElement.put(gdeLink, myAlienElementfactory.createAlienLink(gdeLink));
            return true;
        }
        
        
        LMBadElement.Link addBadLink(AbsLink gdeLink) {
            LMBadElement.Link badLink = new LMBadElement.Link(gdeLink);
            myBadElements.add(badLink);
            myGdeElement2lmElement.put(gdeLink, badLink);
            return badLink;
        }

        public boolean processRemovedGdeNode(AbsNode gdeNode) {
            assert isProcessorActive();
            //System.out.println("[SDLayoutModel.processRemovedGdeNode] gdeNode="+gdeNode);
            Object lmObject = myGdeElement2lmElement.get(gdeNode); 
            //System.out.println("[SDLayoutModel.processRemovedGdeNode] lmObject="+lmObject);
            if (lmObject == null) {
                return false;
            }
            if (lmObject instanceof LMLifeLine) {
                LMLifeLine lmLifeLine = (LMLifeLine) lmObject;
                removeLifeLine(lmLifeLine);
                return true;
            } else if (lmObject instanceof LMFrame) {
                LMFrame lmFrame = (LMFrame) lmObject;
                removeFrame(lmFrame);
                return true;
            } else if (lmObject instanceof LMFoundInvocationOccurence) {
                LMFoundInvocationOccurence lmFoundInvocationOccurence = (LMFoundInvocationOccurence) lmObject;
                removeFoundInvocationOccurence(lmFoundInvocationOccurence);
                return true;
            } else if (lmObject instanceof LMLifeLineBracket) {
                LMLifeLineBracket bracket1 = (LMLifeLineBracket) lmObject;
                LMBracketContainer container = bracket1.getContainer();
                if (container == null) {
                    throw new RuntimeException("Container is null"); //$NON-NLS-1$
                }
                removeBracket(bracket1);
                container.getChildBracketsList().remove(bracket1);
                return true;
            } else if (lmObject instanceof LMBadElement.Node) {
                LMBadElement.Node badNode = (LMBadElement.Node)lmObject;
                removeBadElement(badNode);
                return true;
            } else if (lmObject instanceof LmAlienElement) {
                LmAlienElement alienElement = (LmAlienElement) lmObject;
                alienElement.dispose();
                myGdeElement2lmElement.remove(gdeNode);
                return true;
            } else {
                throw new RuntimeException("Remove "+lmObject+": unknown element"); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        private void removeLifeLine(LMLifeLine lmLifeLine) {
            if (!lmLifeLine.getChildBracketsList().isEmpty()) {
                for (Iterator it=lmLifeLine.getChildBracketsList().iterator(); it.hasNext(); ) {
                    LMLifeLineBracket bracket1 = (LMLifeLineBracket) it.next();
                    removeBracket(bracket1);
                }
                lmLifeLine.getChildBracketsList().removeAll();
            }
            myTopLineConstraint.getLifeLineElementsList().remove(lmLifeLine.getFirstLifeLineElement());
            lmLifeLine.getFirstLifeLineElement().setHorizontalConstraint(null);
            
            myBottomLineConstraint.getLifeLineElementsList().remove(lmLifeLine.getLastLifeLineElement());
            lmLifeLine.getLastLifeLineElement().setHorizontalConstraint(null);

            AbsNode lifeLineNode = lmLifeLine.getGdeNode();
            myGdeElement2lmElement.remove(lifeLineNode);
            myLifeLinesArray.remove(lmLifeLine);
            
            addPossibleUnorderedContainter(myLifeLinesArray);
        }
        
        private void removeFrame(LMFrame lmFrame) {
            disposeFrameBranch(lmFrame);
            lmFrame.delete();
        }
        private void disposeFrameBranch(LMFrame lmFrame) {
            List lmMountingLinks = Collections.list(lmFrame.mountingLinks());
            for (Iterator it = lmMountingLinks.iterator(); it.hasNext(); ) {
                LMMountingLink mountingLink1 = (LMMountingLink) it.next();
                removeMountingLink(mountingLink1);
            }
            
            AbsNode combinedFragmentNode = lmFrame.getGdeNode();
            myGdeElement2lmElement.remove(combinedFragmentNode);
        }
        
        private void removeFoundInvocationOccurence(LMFoundInvocationOccurence lmFoundInvocationOccurence) {
            lmFoundInvocationOccurence.delete();
            myGdeElement2lmElement.remove(lmFoundInvocationOccurence.getGdeNode());
        }
        
        private void removeBracket(LMLifeLineBracket lifeLineBracket) {
            if (!lifeLineBracket.getChildBracketsList().isEmpty()) {
                for (Iterator it=lifeLineBracket.getChildBracketsList().iterator(); it.hasNext(); ) {
                    LMLifeLineBracket bracket1 = (LMLifeLineBracket) it.next();
                    removeBracket(bracket1);
                }
                lifeLineBracket.getChildBracketsList().removeAll();
            }
            if (lifeLineBracket instanceof LMGenCallOccurence) {
                LMGenCallOccurence lmGenCallOccurence = (LMGenCallOccurence) lifeLineBracket; 
                List topLinks = lmGenCallOccurence.getTopBoundaryLifeLineElement().getLMMesssagesList();
                List bottomLinks = lmGenCallOccurence.getBottomBoundaryLifeLineElement().getLMMesssagesList();
        
                if (!topLinks.isEmpty()) {
                    //System.out.println("[AddRemoveElementsProcessor] removeBracket " + topLinks); //$NON-NLS-1$
                    throw new RuntimeException("still there are messages: "+topLinks); //$NON-NLS-1$
                }
                if (!bottomLinks.isEmpty()) {
                    //System.out.println("[AddRemoveElementsProcessor] removeBracket " + topLinks); //$NON-NLS-1$
                    throw new RuntimeException("still there are messages: "+bottomLinks); //$NON-NLS-1$
                }
//                ArrayList messagesToRemove = new ArrayList(topLinks.size()+bottomLinks.size());
//                messagesToRemove.addAll(topLinks);
//                messagesToRemove.addAll(bottomLinks);
//
//                for (int i=0; i<messagesToRemove.size(); i++) {
//                    LMMessage lmMessage = (LMMessage) messagesToRemove.get(i);
//                    removeMessageLink(lmMessage);
//                }
            } else if (lifeLineBracket instanceof LMMountingRegion) {
                LMMountingRegion mountingPoint = (LMMountingRegion) lifeLineBracket;
                LMMountingLink mountingLink = mountingPoint.getMountingLink();
                if (mountingLink != null) {
                    removeMountingLink(mountingLink);
                }
            }
            
            AbsNode bracketNode = lifeLineBracket.getGdeNode();
            myGdeElement2lmElement.remove(bracketNode);
            lifeLineBracket.setContainer(null);
        }
        
        public boolean processRemovedGdeLink(AbsLink gdeLink) {
            assert isProcessorActive();
            
            //System.out.println("[SDLayoutModel.processRemovedGdeLink] gdeLink="+gdeLink);
            Object lmElement = myGdeElement2lmElement.get(gdeLink); 
            //System.out.println("[SDLayoutModel.processRemovedGdeLink] lmElement="+lmElement);
            if (lmElement == null) {
                return false;
            }
            if (lmElement instanceof LMMessage) {
                LMMessage lmMessage = (LMMessage) lmElement;
                removeMessageLink(lmMessage);
                return true;
            } else if (lmElement instanceof LMMountingLink){
                removeMountingLink((LMMountingLink)lmElement);
                return true;
            } else if (lmElement instanceof LMBadElement.Link) {
                removeBadElement((LMBadElement.Link)lmElement);
                return true;
            } else if (lmElement instanceof LmAlienElement) {
                LmAlienElement alienElement = (LmAlienElement) lmElement;
                alienElement.dispose();
                
                myGdeElement2lmElement.remove(gdeLink);
                return true;
            } else {
                throw new RuntimeException("Remove "+lmElement+": todo"); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        private void removeMessageLink(LMMessage lmMessage) {
            //System.out.println("[SDLayoutModel.removeMessageLink] lmMessage="+lmMessage);
            if (lmMessage == null) {
                throw new IllegalArgumentException("lmMessage=null"); //$NON-NLS-1$
            }
            if (lmMessage.isLayoutConstraint()) {
                lmMessage.becomeLayoutConstraint(false);
            }
            
            lmMessage.getReceiveMessageEnd().removeMessage(lmMessage);
            lmMessage.getSendMessageEnd().removeMessage(lmMessage);
            lmMessage.resetReceiveMessageEnd();
            lmMessage.resetSendMessageEnd();
            
            myGdeElement2lmElement.remove(lmMessage.getGdeLink());
        }
        
        private void removeMountingLink(LMMountingLink lmMountingLink) {
            lmMountingLink.getFrame().removeMountingLink(lmMountingLink);
            lmMountingLink.getMountingRegion().setMountLink(null);
            lmMountingLink.setFrame(null);
            lmMountingLink.setMountingRegion(null);
            
            myGdeElement2lmElement.remove(lmMountingLink.getGdeLink());
        }
        private void removeBadElement(LMBadElement badElement) {
            boolean res = myBadElements.remove(badElement);
            if (!res) {
                throw new RuntimeException("Cannot delete bad element from list"); //$NON-NLS-1$
            }
            myGdeElement2lmElement.remove(badElement.getGdeElement());
        }

        
        private void addPossibleUnorderedContainter(SelfReorderable bracketContainer) {
            myPossibleUnorderedContainers.add(bracketContainer);
        }
        
        public void finish() {
            assert isProcessorActive();
            
            try {
                for (Iterator<SelfReorderable> it = myPossibleUnorderedContainers.iterator(); it.hasNext(); ) {
                	SelfReorderable bracketContainer = it.next();
    
                    bracketContainer.reorderChildElements();
                }
                
                myPossibleUnorderedContainers.clear();
                
                updateLifelineCreationDestruction();
            } finally {
                myAddRemoveElementsProcessor = null;
            }
        }
        
        private void updateLifelineCreationDestruction() {
            for (Iterator it = myLifeLinesArray.listIterator(1); it.hasNext();) {
                LMLifeLine lifeLine = (LMLifeLine) it.next();
                lifeLine.updateCreationDestruction();
            }
        }
        private boolean isProcessorActive() {
            return myAddRemoveElementsProcessor == this;
        }
        
        private Set<SelfReorderable> myPossibleUnorderedContainers = new HashSet<SelfReorderable>();
    }
    
    
    private void initialFill() {
        myState.setConstructionCompleted(false);
        try {
            SdLayoutModelAddRemoveProcessor addRemoveElementsProcessor = newAddRemoveProcessor();
   
            
            //System.out.println("[SDLayoutModel.initialFill] INITIAL FILL");
            List allNodes = new ArrayList();
            for (AbsNodeEnumeration nodeEnum = myRootElementsGetter.getRootNode().subnodes(); nodeEnum.hasMoreElements(); ) {
                AbsNode subNode1 = nodeEnum.nextGdeNode();
                readNodesRecursively(subNode1, allNodes);
            }
            
            for (int i = 0; i<allNodes.size(); i++) {
                AbsNode subNode1 = (AbsNode) allNodes.get(i);
                addRemoveElementsProcessor.processAddedGdeNode(subNode1);
            }
            for (AbsLinkEnumeration linkEnum = myGdeDiagram.links(); linkEnum.hasMoreElements(); ) {
                AbsLink gdeLink1 = linkEnum.nextGdeLink();
                addRemoveElementsProcessor.processAddedGdeLink(gdeLink1);
            }
            
            addRemoveElementsProcessor.finish();
        } finally {
            myState.setConstructionCompleted(true);
        }
    }
    
    private void readNodesRecursively(AbsNode absNode, Collection collection) {
        collection.add(absNode);
        for (AbsNodeEnumeration nodeEnum = absNode.subnodes(); nodeEnum.hasMoreElements(); ) {
            AbsNode subNode1 = nodeEnum.nextGdeNode();
            readNodesRecursively(subNode1, collection);
        }
    }
    
    private Interaction getInteractionEntity() {
        return myRootElementsGetter.getInteractionEntity();
    }
    
    private final Map myGdeElement2lmElement = new HashMap();
    private final Interaction myDiagramEntity;
    private final AbsDiagram myGdeDiagram;
    
    //private final UniqueNameService myUniqueNameService;
    /**
     * First element must be LMFakeLifeline
     */
    private final LifelinesArray myLifeLinesArray = new LifelinesArray();
    private final LMFrameContainer myRootFramesContainer = new LMFrameContainer();
    private final List myLifeLinesArrayImmutable = Collections.unmodifiableList(myLifeLinesArray);
    private final List myBadElements = new ArrayList();
    private final State myState = new State();
    private final LmObjectsResolver myLmObjectsResolver = new LmObjectsResolver() {
        public Object getLmObject(AbsElement gdeElement) {
            return myGdeElement2lmElement.get(gdeElement);
        } 
    };
    private AddRemoveElementsProcessor myAddRemoveElementsProcessor = null;
    private final RootElementsGetter myRootElementsGetter;
    
    private final LmOwner myLmOwner;
    
    private final LmAlienElement.Factory myAlienElementfactory;


    private static class LmOwnerImpl implements LmOwner {
        LmOwnerImpl(Config config) {
            //myReorderAgainstModel = Boolean.TRUE.toString().equals(ideConfig.getProperty(REORDER_AGAINST_MODEL_NOT_GDE, null));
            myReorderAgainstModel = true;
        }

        public boolean reorderAgainstModelNotGde() {
            return myReorderAgainstModel;
        }
        
        private final boolean myReorderAgainstModel;
        
        //private static String REORDER_AGAINST_MODEL_NOT_GDE = "option.sequenceDiagram20.debug.reorderAgainstModelNotGde";
    }
    

    private final HorizontalConstraintImpl myTopLineConstraint = new HorizontalConstraintImpl("topline"); //$NON-NLS-1$
    private final HorizontalConstraintImpl myBottomLineConstraint = new HorizontalConstraintImpl("bottomline"); //$NON-NLS-1$
    
    
    private static class HorizontalConstraintImpl implements HorizontalConstraint {
        HorizontalConstraintImpl(String debugName) {
            myDebugName = debugName;
        }
        ArrayList getModifiableElementsList() {
            return myLifeLineElementsList;
        }
        public List getLifeLineElementsList() {
            return myLifeLineElementsList;
        }
        public void elementIsResolved(LifeLineElement lifeLineElement) {
        }
        public void elementIsViolated(LifeLineElement lifeLineElement) {
        }
        public String toString() {
            return "[HorizontalConstraintImpl:"+myDebugName+/*":"+myLifeLineElementsList+*/"]"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        private final ArrayList myLifeLineElementsList = new ArrayList();
        private final String myDebugName;
    }
    
    private class LifelinesArray extends ArrayList implements SelfReorderable {

		public void reorderChildElements() {
			List allButFirstList = this.subList(1, size());
			List<Integer> oldIndexes = SdLayoutUtil.getReorderAgainstModel(allButFirstList, myRootElementsGetter.getInteractionView());
			SdLayoutUtil.reorderList(oldIndexes, allButFirstList);
		}
    }
    
    /**
     * This property controls, if layout model should itself read children of added node. It doesn't seem to be necessary, but it did in Trinity. 
     */
    private final static boolean READ_GDE_CONTENT_MYSELF = false;
}