/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland)
 */
package org.eclipse.uml2.diagram.sequence.anchor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.model.edit.SDAnchor;

public class AnchorResolver {

	public ArrayList<PasteRange> getPasteRanges(AnchorProcessorInput anchorProcessorInputImpl, SDAnchor initialCreateTarget) throws EvaluatingException, UnknownElementException {
		return getPasteRanges(anchorProcessorInputImpl, Collections.singletonList(initialCreateTarget));
	}

	public ArrayList<PasteRange> getPasteRanges(AnchorProcessorInput anchorProcessorInputImpl, List<SDAnchor> controlCreateTargets) throws UnknownElementException, EvaluatingException {
		List<LifeLine> lifeLinesList = anchorProcessorInputImpl.lifeLinesList();

		LifeLine[] lifeLinesArray = new LifeLine[lifeLinesList.size()];
		lifeLinesList.toArray(lifeLinesArray);

		ConstraintsProcessor constraintsProcessor = new ConstraintsProcessor(lifeLinesArray);

		ArrayList<LifeLineElement> controlElementList = new ArrayList<LifeLineElement>(controlCreateTargets.size());
		for (SDAnchor createTarget : controlCreateTargets) {
			controlElementList.add(anchorProcessorInputImpl.getLifeLineElementBeforePoint(createTarget));
		}

		ConstraintsProcessor.MultipleElementsProcessor multipleElementsProcessor = new ConstraintsProcessor.MultipleElementsProcessor(constraintsProcessor, controlElementList);

		multipleElementsProcessor.processTo();
		ArrayList<LifeLineElement> pasteRangeUpper = new ArrayList<LifeLineElement>(constraintsProcessor.getCurrentState());

		multipleElementsProcessor.processHolding();
		ArrayList<LifeLineElement> pasteRangeLower = new ArrayList<LifeLineElement>(constraintsProcessor.getCurrentState());

		ArrayList<PasteRange> result = new ArrayList<PasteRange>(pasteRangeUpper.size());

		//System.out.println("[AnchorResolver.getCreateTargets] upper elements : "+pasteRangeUpper);
		//System.out.println("[AnchorResolver.getCreateTargets] lower elements : "+pasteRangeLower);

		LifelineElementTraceable[] creationTops = anchorProcessorInputImpl.getLifelineCreationTops();
		LifelineElementTraceable[] destructionBottoms = anchorProcessorInputImpl.getLifelineDestructionBottoms();

		for (int i = 0; i < pasteRangeUpper.size(); i++) {
			LifelineElementTraceable rangeUpperElement = (LifelineElementTraceable) pasteRangeUpper.get(i);
			LifelineElementTraceable rangeLowerElement = (LifelineElementTraceable) pasteRangeLower.get(i);

			{//intersect with [creation, destruction)
				if (creationTops[i] != null && rangeUpperElement.getNumber() < creationTops[i].getNumber()) {
					rangeUpperElement = creationTops[i];
				}

				if (destructionBottoms[i] != null && destructionBottoms[i].getNumber() <= rangeLowerElement.getNumber()) {
					rangeLowerElement = destructionBottoms[i];
				}

				if (rangeUpperElement.getNumber() > rangeLowerElement.getNumber()) {
					rangeUpperElement = rangeLowerElement;
				}
			}

			PasteRange pasteRange = new PasteRange(rangeUpperElement, rangeLowerElement, anchorProcessorInputImpl);

			result.add(pasteRange);
		}

		return result;
	}

	public class GetCreateTargetsResult {

		private GetCreateTargetsResult(AnchorProcessorInput anchorProcessorInputImpl, ConstraintsProcessor constraintsProcessor, ArrayList<SDAnchor> createTargetsList) {
			myAnchorProcessorInputImpl = anchorProcessorInputImpl;
			myConstraintsProcessor = constraintsProcessor;
			myCreateTargetsList = createTargetsList;
		}

		public ArrayList<SDAnchor> getCreateTargetsList() {
			return myCreateTargetsList;
		}

		public ArrayList<SDAnchor> calculateAsynchTargets(LifelineSatisfyCondition[] satisfyingContainers) throws UnknownElementException, EvaluatingException {
			return getAsynchTargets(myAnchorProcessorInputImpl, myConstraintsProcessor, satisfyingContainers);
		}

		private final ConstraintsProcessor myConstraintsProcessor;

		private final ArrayList<SDAnchor> myCreateTargetsList;

		private final AnchorProcessorInput myAnchorProcessorInputImpl;
	}

	/**
	 * @param satisfyingContainers
	 * 		contains Entities, in which result create targets should be
	 */
	public GetCreateTargetsResult getCreateTargets(AnchorProcessorInput anchorProcessorInputImpl, List<SDAnchor> controlCreateTargets,
			final LifelineSatisfyCondition[] lifelineSatisfyConditions) throws UnknownElementException, EvaluatingException {
		List<LifeLine> lifeLinesList = anchorProcessorInputImpl.lifeLinesList();

		final LifeLine[] lifeLinesArray = new LifeLine[lifeLinesList.size()];
		lifeLinesList.toArray(lifeLinesArray);

		ConstraintsProcessor constraintsProcessor = new ConstraintsProcessor(lifeLinesArray);

		ArrayList<LifeLineElement> controlElementList = new ArrayList<LifeLineElement>(controlCreateTargets.size());
		for (SDAnchor createTarget : controlCreateTargets) {
			controlElementList.add(anchorProcessorInputImpl.getLifeLineElementBeforePoint(createTarget));
		}

		ConstraintsProcessor.MultipleElementsProcessor multipleElementsProcessor = new ConstraintsProcessor.MultipleElementsProcessor(constraintsProcessor, controlElementList);

		ConstraintsProcessor.SatisfyCondition satisfyCondition = constraintsProcessor.new SatisfyCondition(lifelineSatisfyConditions);

		multipleElementsProcessor.processTo(satisfyCondition);

		ArrayList<SDAnchor> result = new ArrayList<SDAnchor>(lifeLinesArray.length);

		//System.out.println("[AnchorResolver.getCreateTargets] upper elements : "+pasteRangeUpper);
		//System.out.println("[AnchorResolver.getCreateTargets] lower elements : "+pasteRangeLower);

		for (int i = 0; i < lifeLinesArray.length; i++) {
			LifeLineElement lifeLineElement = (LifeLineElement) constraintsProcessor.getCurrentState().get(i);
			SDAnchor createTarget = anchorProcessorInputImpl.getCreateTargetAfterPoint(lifeLineElement);
			result.add(createTarget);
		}

		return new GetCreateTargetsResult(anchorProcessorInputImpl, constraintsProcessor, result);
	}

	private ArrayList<SDAnchor> getAsynchTargets(AnchorProcessorInput anchorProcessorInputImpl, ConstraintsProcessor constraintsProcessor, LifelineSatisfyCondition[] lifelineSatisfyConditions)
			throws UnknownElementException, EvaluatingException {
		ConstraintsProcessor.SatisfyCondition satisfyCondition = constraintsProcessor.new SatisfyCondition(lifelineSatisfyConditions);

		ConstraintsProcessor.MultipleElementsProcessor multipleElementsProcessor = new ConstraintsProcessor.MultipleElementsProcessor(constraintsProcessor, Collections.<LifeLineElement> emptyList());

		multipleElementsProcessor.processTo(satisfyCondition);

		int size = constraintsProcessor.getCurrentState().size();

		ArrayList<SDAnchor> result = new ArrayList<SDAnchor>(size);

		for (int i = 0; i < size; i++) {
			LifeLineElement lifeLineElement = (LifeLineElement) constraintsProcessor.getCurrentState().get(i);
			SDAnchor createTarget = anchorProcessorInputImpl.getCreateTargetAfterPoint(lifeLineElement);
			result.add(createTarget);
		}

		return result;
	}
}
