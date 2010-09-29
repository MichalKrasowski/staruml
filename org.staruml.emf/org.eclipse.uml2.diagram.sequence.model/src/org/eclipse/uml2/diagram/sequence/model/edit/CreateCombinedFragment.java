package org.eclipse.uml2.diagram.sequence.model.edit;

import java.util.ListIterator;

import org.eclipse.uml2.diagram.sequence.model.builder.SDBuilderTrace;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDCombinedFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrameContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionOperand;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLFactory;


public class CreateCombinedFragment {
	private final SDModel myModel;

	public CreateCombinedFragment(SDModel model){
		myModel = model;
	}
	
	public SDCombinedFragment createCombinedFragment(SDBracketContainer container, SDAnchor anchor, InteractionOperatorKind kind, int operandsCount){
		SDLifeLine sdLifeLine = container.getCoveredLifeLine();
		if (sdLifeLine.getModel() != myModel){
			throw new IllegalArgumentException(//
					"Alien lifeline: " + sdLifeLine + //
					", for sdModel: " + myModel);
		}
		if (anchor != null && anchor.getAnchor().getBracketContainer() != container){
			throw new IllegalArgumentException(//
					"Anchor: " + anchor.getAnchor() + //
					", is not applicable to container: " + container + //
					", actual container is: " + anchor.getAnchor().getBracketContainer());
		}
		
		CreateContainer createContainer = findCreateContainer(container, anchor);
		if (createContainer == null){
			return null;
		}

		CombinedFragment umlCombined = UMLFactory.eINSTANCE.createCombinedFragment();
		umlCombined.getCovereds().add(sdLifeLine.getUmlLifeline());
		umlCombined.setInteractionOperator(kind);

		SDCombinedFragment sdCombined = getTraceImpl().bindNewCombinedFragment(umlCombined);
		sdCombined.getCoveredLifeLines().add(sdLifeLine);
		
		SDMountingRegion sdCombinedMounter = getTraceImpl().bindNewMountingRegion(sdCombined);
		
		for (int i = 0; i < operandsCount; i++){
			InteractionOperand nextUMLOperand = umlCombined.createOperand(null);
			nextUMLOperand.getCovereds().add(sdLifeLine.getUmlLifeline());
			
			SDInteractionOperand nextSDOperand = getTraceImpl().bindNewInteractionOperand(nextUMLOperand);
			sdCombined.getFrames().add(nextSDOperand);
			nextSDOperand.getCoveredLifeLines().add(sdLifeLine);
			
			SDMountingRegion nextOperandMounter = getTraceImpl().bindNewMountingRegion(nextSDOperand);
			sdCombinedMounter.getBrackets().add(nextOperandMounter);
		}
		
		createContainer.getUMLInsertPosition().add(umlCombined);
		createContainer.getSDBracketInsertPosition().add(sdCombinedMounter);
		createContainer.getSDFrameInsertPosition().add(sdCombined);
		
		return sdCombined;
	}
	
	
	private CreateContainer findCreateContainer(SDBracketContainer sdContainer, SDAnchor anchor){
		if (sdContainer instanceof SDLifeLine){
			return new OnLifelineCreateContainer((SDLifeLine)sdContainer, anchor);
		}
		if (sdContainer instanceof SDMountingRegion){
			SDMountingRegion mountingRegion = (SDMountingRegion)sdContainer;
			if (mountingRegion.getFrame() instanceof SDInteractionOperand){
				return new OnInteractionOperandMounterCreateContainer(mountingRegion, anchor);
			}
		}
		return null;
	}
	
	private static interface CreateContainer {
		public ListIterator<InteractionFragment> getUMLInsertPosition();
		public ListIterator<SDFrame> getSDFrameInsertPosition();
		public ListIterator<SDBracket> getSDBracketInsertPosition();
	}
	
	private static abstract class AbstractCreateContainer implements CreateContainer {
		private final SDBracketContainer myBracketContainer;
		private final SDAnchor myAnchor;

		public AbstractCreateContainer(SDBracketContainer bracketContainer, SDAnchor anchor){
			assert bracketContainer == anchor.getAnchor().getBracketContainer();
			myBracketContainer = bracketContainer;
			myAnchor = anchor;
		}
		
		protected boolean isAfterAnchor(){
			return myAnchor != null && !myAnchor.isBeforeNotAfterAnchor();
		}
		
		public ListIterator<SDFrame> getSDFrameInsertPosition() {
			SDFrameContainer frameContainer = getFrameContainer();
			InsertAfter<SDFrame> theFramesPast = new InsertAfter<SDFrame>();
			if (isAfterAnchor()){
				for (SDBracket nextBracketBefore : myBracketContainer.getBrackets()){
					if (nextBracketBefore == myAnchor.getAnchor()){
						break;
					}
					if (nextBracketBefore instanceof SDMountingRegion){
						theFramesPast.considerAsPast(((SDMountingRegion)nextBracketBefore).getFrame());
					}
				}
			}
			return theFramesPast.getAfterThePastPosition(frameContainer.getFrames());
		}
		
		public ListIterator<SDBracket> getSDBracketInsertPosition() {
			InsertAfter<SDBracket> theBracketsPast = new InsertAfter<SDBracket>();
			if (isAfterAnchor()){
				theBracketsPast.considerAsPast(myAnchor.getAnchor());
			}
			return theBracketsPast.getAfterThePastPosition(myBracketContainer.getBrackets());
		}
		
		public ListIterator<InteractionFragment> getUMLInsertPosition() {
			InsertFragmentAfter umlPast = new InsertFragmentAfter();
			if (isAfterAnchor()){
				umlPast.bracketFinished(myAnchor.getAnchor());
			}
			return umlPast.getAfterThePastPosition(getFrameContainer().getFragmentsList());
		}
		
		protected final SDBracketContainer getBracketContainer() {
			return myBracketContainer;
		}
		
		protected final SDAnchor getAnchor() {
			return myAnchor;
		}
		
		protected abstract SDFrameContainer getFrameContainer();
	}
	
	private static class OnLifelineCreateContainer extends AbstractCreateContainer {
		public OnLifelineCreateContainer(SDLifeLine lifeLine, SDAnchor anchor){
			super(lifeLine, anchor);
		}
		
		@Override
		protected SDFrameContainer getFrameContainer() {
			return getLifeline().getModel();
		}
		
		protected final SDLifeLine getLifeline(){
			return (SDLifeLine)getBracketContainer();
		}
	}
	
	private static class OnInteractionOperandMounterCreateContainer extends AbstractCreateContainer {
		public OnInteractionOperandMounterCreateContainer(SDMountingRegion region, SDAnchor anchor){
			super(region, anchor);
			if (false == region.getFrame() instanceof SDInteractionOperand){
				throw new IllegalArgumentException("Only SDInteractionOperand is valid frame with some allowed contents of its mounting regions, " + region);
			}
		}
		
		@Override
		protected SDFrameContainer getFrameContainer() {
			return getSDInteractionOperand();
		}
		
		protected final SDMountingRegion getMountingRegion(){
			return (SDMountingRegion)getBracketContainer();
		}
		
		protected final SDInteractionOperand getSDInteractionOperand(){
			return (SDInteractionOperand)getMountingRegion().getFrame();
		}
	}

	private SDBuilderTrace getTraceImpl(){
		//intentional implementation cast
		return (SDBuilderTrace)myModel.getUMLTracing();
	}

}
