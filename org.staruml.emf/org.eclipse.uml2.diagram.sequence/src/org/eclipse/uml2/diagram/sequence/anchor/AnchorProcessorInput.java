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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineIterator;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;
import org.eclipse.uml2.diagram.sequence.internal.missed.EmptyEnumeration;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;
import org.eclipse.uml2.diagram.sequence.model.edit.SDAnchor;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDEntity;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLineElement;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;


public class AnchorProcessorInput {

	/**
	 * @param ignoreBrackets
	 * 		allow to list brackets, which should not be included in Input model.
	 */
	public AnchorProcessorInput(SDModel interactionEntity, Set<SDBracket> ignoreBrackets) {
		this(interactionEntity, ignoreBrackets, ourNullFactory);
	}

	public AnchorProcessorInput(SDModel interactionEntity, Set<SDBracket> ignoreBrackets, LayoutPropertiesFactory layoutPropertiesFactory) {
		//long time = System.currentTimeMillis();
		myLifelinesEntities = new ArrayList<SDLifeLine>(interactionEntity.getLifelines());
		FillInputSession fillInputSession;
		try {
			fillInputSession = new FillInputSession(myLifelinesEntities, ignoreBrackets, layoutPropertiesFactory);
		} catch (RuntimeException e) {
			throw new SDModelUtil.ModelProblemException("Failed to build AnchorProcessorInput, something wrong with interaction", e);
		}
		myLifelines = fillInputSession.getResultLifelines();

		myCreationDestructionSatisfyConditions = fillInputSession.createCreationDestructionSatisfyCondition();
		myLifelineCreationTops = fillInputSession.getLifelineCreationTops();
		myLifelineDestructionBottoms = fillInputSession.getLifelineDestructionBottoms();

		myLifelineEntity2Index = new HashMap<SDLifeLine, Integer>(myLifelines.size());
		for (int i = 0; i < myLifelinesEntities.size(); i++) {
			SDLifeLine lifelineEntity = myLifelinesEntities.get(i);
			Object res = myLifelineEntity2Index.put(lifelineEntity, new Integer(i));
			if (res != null) {
				throw new RuntimeException("One lifeline is listed twice");
			}
		}

		myIgnoredElements = ignoreBrackets;
		//new Exception("created, took "+(System.currentTimeMillis()-time)+"ms").printStackTrace(System.out);
	}

	public List<SDLifeLine> getLifeLinesEntities() {
		return myLifelinesEntities;
	}

	public List<LifeLine> lifeLinesList() {
		return myLifelines;
	}

	public LifelineSatisfyCondition[] getCreationDestructionSatisfyConditions() {
		return myCreationDestructionSatisfyConditions;
	}

	public LifelineSatisfyCondition[] getCreationDestructionSatisfyConditions(Set<SDLifeLine> essentialLifelines) {
		LifelineSatisfyCondition[] result = myCreationDestructionSatisfyConditions.clone();
		for (int i = 0; i < result.length; i++) {
			if (result[i] == null) {
				continue;
			}
			if (!essentialLifelines.contains(getLifeLinesEntities().get(i))) {
				result[i] = null;
			}
		}
		return result;
	}

	public LifelineElementTraceable[] getLifelineCreationTops() {
		return myLifelineCreationTops;
	}

	public LifelineElementTraceable[] getLifelineDestructionBottoms() {
		return myLifelineDestructionBottoms;
	}

	public int getLifelineIndex(SDLifeLine lifelineEntity) {
		Integer index = (Integer) myLifelineEntity2Index.get(lifelineEntity);
		if (index == null) {
			throw new RuntimeException("Cannot find lifeline in map");
		}
		return index.intValue();
	}

	public LifeLineElement getLifeLineElementBeforePoint(SDAnchor createTarget) throws UnknownElementException {
		if (createTarget.getAnchor() == null) {
			LifelineImpl.BottomElement containerBottomElement = getBottomElementImpl(createTarget.getContainer());
			if (createTarget.isAfterAnchor()) {
				return containerBottomElement.getTopElement();
			} else {
				return containerBottomElement.getPreviousElement();
			}
		} else {
			LifelineImpl.BottomElement anchorBottomElement = getBottomElementImpl(createTarget.getAnchor());
			if (createTarget.isAfterAnchor()) {
				return anchorBottomElement;
			} else {
				return anchorBottomElement.getTopElement().getPreviousElement();
			}
		}
	}

	boolean doesInclude(PasteRange pasteRange, SDAnchor createTarget) throws UnknownElementException {
		int beforeTargetPos;

		LifelineImpl lifelineImpl = (LifelineImpl) pasteRange.getRangeLowerElement().getLifeLine();

		if (createTarget.getAnchor() == null) {
			LifelineImpl.BottomElement bottomElement = getBottomElementSecure(createTarget.getContainer(), lifelineImpl);

			if (createTarget.isAfterAnchor()) {
				// after begin of list
				beforeTargetPos = bottomElement.getTopElement().getNumber();
			} else {
				beforeTargetPos = bottomElement.getNumber() - 1;
			}
		} else {
			LifelineImpl.BottomElement anchorBottomElement = getBottomElementSecure(createTarget.getAnchor(), lifelineImpl);

			if (createTarget.isAfterAnchor()) {
				// after begin of list
				beforeTargetPos = anchorBottomElement.getNumber();
			} else {
				beforeTargetPos = anchorBottomElement.getTopElement().getNumber() - 1;
			}
		}

		LifelineImpl.BoundaryElement rangeUpperElement = (LifelineImpl.BoundaryElement) pasteRange.getRangeUpperElement();
		LifelineImpl.BoundaryElement rangeLowerElement = (LifelineImpl.BoundaryElement) pasteRange.getRangeLowerElement();

		return rangeUpperElement.getNumber() <= beforeTargetPos && beforeTargetPos < rangeLowerElement.getNumber();
	}

	boolean doesInclude(PasteRange pasteRange, SDLifeLineElement entity) throws UnknownElementException {
		LifelineImpl.BoundaryElement upperRangeElement = (LifelineImpl.BoundaryElement) pasteRange.getRangeUpperElement();
		LifelineImpl.BoundaryElement lowerRangeElement = (LifelineImpl.BoundaryElement) pasteRange.getRangeLowerElement();

		LifelineImpl.BottomElement bottomEntityElement = getBottomElementSecure(entity, upperRangeElement.getLifelineImpl());
		LifelineImpl.TopElement topEntityElement = bottomEntityElement.getTopElement();

		return upperRangeElement.getNumber() < topEntityElement.getNumber() && lowerRangeElement.getNumber() > bottomEntityElement.getNumber();
	}

	public SDAnchor findTargetByContainer(PasteRange pasteRange, SDBracketContainer container) {
		LifelineImpl.BoundaryElement upperBoundaryElement0 = (LifelineImpl.BoundaryElement) pasteRange.getRangeUpperElement();
		LifelineImpl.BoundaryElement lowerBoundaryElement0 = (LifelineImpl.BoundaryElement) pasteRange.getRangeLowerElement();

		LifelineImpl.BoundaryElement boundaryElement = upperBoundaryElement0;
		while (boundaryElement != lowerBoundaryElement0) {
			if (boundaryElement.isTopNotBottom()) {
				if (boundaryElement.getEntity() == container) {
					return SDAnchor.firstChildFor(container);
				}
			} else {
				SDLifeLineElement afterTheBottomMeansParent = boundaryElement.getEntityAfterElement();
				if (afterTheBottomMeansParent == container) {
					return new SDAnchor(container, (SDBracket)boundaryElement.getEntity(), true);
				}
			}
			boundaryElement = boundaryElement.getNextBoundaryElement();
		}

		return null;
	}

	public LifeLineElement getLifeLineElement(SDLifeLineElement entity, boolean topNotBottom, int lifelineIndex) throws UnknownElementException {
		LifelineImpl.BottomElement bottomElement = getBottomElementImpl(entity);
		if (myLifelines.get(lifelineIndex) != bottomElement.getLifeLine()) {
			throw new RuntimeException("Element found, but on wrong lifeline");
		}
		if (topNotBottom) {
			return bottomElement.getTopElement();
		} else {
			return bottomElement;
		}
	}

	public class InEntityCondition implements LifelineSatisfyCondition {

		public InEntityCondition(SDLifeLineElement entity, boolean isBeforeOk, boolean isInsideOk, boolean isAfterOk) throws UnknownElementException {
			LifelineImpl.BottomElement bottomElement = getBottomElementImpl(entity);
			myLifeLine = bottomElement.getLifeLine();
			final int topPos = bottomElement.getTopElement().getNumber();
			final int bottomPos = bottomElement.getNumber();

			if (isInsideOk) {
				final int topPosPlus = isBeforeOk ? topPos - 1 : topPos;
				final int bottomPosPlus = isAfterOk ? bottomPos + 1 : bottomPos;
				myNumberCondition = new NumberCondition() {

					boolean isSatisfied(int number) {
						return topPosPlus <= number && number < bottomPosPlus;
					}
				};
			} else if (isBeforeOk) {
				if (isAfterOk) {
					myNumberCondition = new NumberCondition() {

						boolean isSatisfied(int number) {
							return topPos - 1 == number || number == bottomPos;
						}
					};
				} else {
					myNumberCondition = new NumberCondition() {

						boolean isSatisfied(int number) {
							return topPos - 1 == number;
						}
					};
				}
			} else {
				if (isAfterOk) {
					myNumberCondition = new NumberCondition() {

						boolean isSatisfied(int number) {
							return number == bottomPos;
						}
					};
				} else {
					throw new IllegalArgumentException("All 3 flags are false");
				}
			}

		}

		public LifeLine getLifeline() {
			return myLifeLine;
		}

		public boolean isSatisfied(LifelineElementTraceable beforePointElement) {
			LifelineImpl.BoundaryElement boundaryElement = (LifelineImpl.BoundaryElement) beforePointElement;
			if (boundaryElement.getLifeLine() != myLifeLine) {
				throw new IllegalArgumentException("Wrong lifeline");
			}
			return myNumberCondition.isSatisfied(boundaryElement.getNumber());
		}

		private abstract class NumberCondition {

			abstract boolean isSatisfied(int number);
		}

		private final LifeLine myLifeLine;

		private final NumberCondition myNumberCondition;
	}

	/**
	 * @return null, if pasteRange and destinationBoundary has empty
	 * 	intersection
	 */
	PasteRange getLimitedRange(PasteRange pasteRange, SDEntity destinationBoundary) {
		LifeLineElement upperElement = pasteRange.getRangeUpperElement();
		LifeLineElement lowerElement = pasteRange.getRangeLowerElement();

		LifelineImpl.BoundaryElement upperBoundaryElement0 = (LifelineImpl.BoundaryElement) upperElement;
		LifelineImpl.BoundaryElement lowerBoundaryElement0 = (LifelineImpl.BoundaryElement) lowerElement;

		LifelineImpl.BoundaryElement upperBoundaryElement;
		LifelineImpl.BoundaryElement lowerBoundaryElement;

		if (destinationBoundary == null) {
			upperBoundaryElement = upperBoundaryElement0;
			lowerBoundaryElement = lowerBoundaryElement0;
		} else {

			LifelineImpl.BoundaryElement boundaryElement = upperBoundaryElement0;

			if (SDModelUtil.isNested(upperBoundaryElement0.getEntity(), destinationBoundary)) {
				upperBoundaryElement = upperBoundaryElement0;
			} else {
				while (!boundaryElement.isTopNotBottom() || boundaryElement.getEntity() != destinationBoundary) {
					if (boundaryElement == lowerBoundaryElement0) {
						return null;
					}
					boundaryElement = boundaryElement.getNextBoundaryElement();
				}
				upperBoundaryElement = boundaryElement;
			}

			if (SDModelUtil.isNested(lowerBoundaryElement0.getEntity(), destinationBoundary)) {
				lowerBoundaryElement = lowerBoundaryElement0;
			} else {
				while (boundaryElement.isTopNotBottom() || boundaryElement.getEntity() != destinationBoundary) {
					if (boundaryElement == lowerBoundaryElement0) {
						return null;
					}
					boundaryElement = boundaryElement.getNextBoundaryElement();
				}

				lowerBoundaryElement = boundaryElement;
			}
		}
		return new PasteRange(upperBoundaryElement, lowerBoundaryElement, this);
	}

	public SDAnchor getCreateTargetAfterPoint(LifeLineElement lineElementForAnchor) {
		LifelineImpl.BoundaryElement boundaryElement = (LifelineImpl.BoundaryElement) lineElementForAnchor;

		if (boundaryElement instanceof LifelineImpl.TopElement) {
			SDLifeLineElement containerOrSimple = boundaryElement.getEntity();
			LifelineImpl.BoundaryElement nextElement = boundaryElement.getNextBoundaryElement();

			if (nextElement instanceof LifelineImpl.TopElement) {
				//"next" element can't be a LifeLine
				SDBracket anchor = (SDBracket) nextElement.getEntity();
				return new SDAnchor(anchor.getBracketContainer(), anchor, true);
			} else if (nextElement instanceof LifelineImpl.BottomElement) {
				if (containerOrSimple instanceof SDBracketContainer){
					return SDAnchor.firstChildFor((SDBracketContainer)containerOrSimple);
				} else {
					SDBracket simpleBracket = (SDBracket)containerOrSimple;
					return SDAnchor.after(simpleBracket);
				}
			} else {
				throw new RuntimeException(MessageFormat.format("Bad lifeline element {0}", new Object[] { nextElement }));
			}

		} else if (boundaryElement instanceof LifelineImpl.BottomElement) {
			SDLifeLineElement anchor = boundaryElement.getEntity();
			if (anchor instanceof SDLifeLine){
				throw new RuntimeException("There is nothing after the end of lifeline");
			}
			return SDAnchor.after((SDBracket)anchor);
		} else {
			throw new RuntimeException(MessageFormat.format("Bad lifeline element {0}", new Object[] { boundaryElement }));
		}
	}

	public LifelineSatisfyCondition getAfterEntitySatisfyCondition(SDLifeLineElement entity) throws UnknownElementException {
		final LifelineImpl.BottomElement bottomElement = getBottomElementImpl(entity);

		class AfterEntitySatisfyCondition implements LifelineSatisfyCondition {

			public boolean isSatisfied(LifelineElementTraceable elementTraceable) {
				if (elementTraceable.getLifeLine() != getLifeline()) {
					throw new IllegalArgumentException("Unexpected lifeline");
				}
				return bottomElement.getNumber() <= elementTraceable.getNumber();
			}

			public LifeLine getLifeline() {
				return bottomElement.getLifeLine();
			}
		}

		return new AfterEntitySatisfyCondition();
	}

	public LifelineSatisfyCondition getNotEarlierThanTargetSatisfyCondition(SDAnchor createTarget) throws UnknownElementException {
		final LifelineElementTraceable beforeTargetElement = (LifelineElementTraceable) getLifeLineElementBeforePoint(createTarget);

		class NotEarlierThanTargetSatisfyCondition implements LifelineSatisfyCondition {

			public boolean isSatisfied(LifelineElementTraceable elementTraceable) {
				if (elementTraceable.getLifeLine() != getLifeline()) {
					throw new IllegalArgumentException("Unexpected lifeline");
				}
				return beforeTargetElement.getNumber() <= elementTraceable.getNumber();
			}

			public String toString() {
				return MessageFormat.format("NotEarlierThanTargetSatisfyCondition for {0}", new Object[] { beforeTargetElement });
			}

			public LifeLine getLifeline() {
				return beforeTargetElement.getLifeLine();
			}
		}

		return new NotEarlierThanTargetSatisfyCondition();
	}

	public interface ElementLayoutProperties {

		int getPointOffset();

		int getSize();

		LifeLineElement.Position getPosition();
	}

	public interface LayoutPropertiesFactory {

		ElementLayoutProperties createLayoutProperties(SDEntity entity, boolean topNotBottom);
	}

	private static final LayoutPropertiesFactory ourNullFactory = new LayoutPropertiesFactory() {

		public ElementLayoutProperties createLayoutProperties(SDEntity entity, boolean topNotBottom) {
			return null;
		}
	};

	private LifelineImpl.BottomElement getBottomElementSecure(SDLifeLineElement lifeLineElement, LifelineImpl lifeLineImpl) throws UnknownElementException {
		LifelineImpl.BottomElement bottomEntityElement = getBottomElementImpl(lifeLineElement);

		if (lifeLineImpl != bottomEntityElement.getLifelineImpl()) {
			throw new RuntimeException("Entity and paste range are from different lifelines");
		}
		return bottomEntityElement;
	}

	private LifelineImpl.BottomElement getBottomElementImpl(SDLifeLineElement lifeLineElement) throws UnknownElementException {
		assert !myIgnoredElements.contains(lifeLineElement);

		LifelineImpl.BottomElement bottomEntityElement = (LifelineImpl.BottomElement) myLifeLineElement2Bottom.get(lifeLineElement);
		if (bottomEntityElement == null) {
			throw new UnknownElementException(MessageFormat.format("Cannot find lifeline element for entity {0}", new Object[] { DebugFormat.debugFormatEntity(lifeLineElement) }));
		}
		return bottomEntityElement;
	}

	private class FillInputSession {

		FillInputSession(List<SDLifeLine> lifeLinesEntities, Set<SDBracket> ignoreBrackets, LayoutPropertiesFactory layoutPropertiesFactory) {
			//System.out.println("[AnchorProcessorInputImpl.FillInputSession] lifeLinesEntities="+lifeLinesEntities);

			myLayoutPropertiesFactory = layoutPropertiesFactory;

			myResultLifelines = new ArrayList<LifeLine>(lifeLinesEntities.size());
			myIgnoreBrackets = ignoreBrackets;

			List<LifelineImpl.BoundaryElement> lifeLineTopElements = new ArrayList<LifelineImpl.BoundaryElement>(lifeLinesEntities.size());
			List<LifelineImpl.BoundaryElement> lifeLineBottomElements = new ArrayList<LifelineImpl.BoundaryElement>(lifeLinesEntities.size());

			myCreationDestructionCollector = new LifelineCreationDestructionCollector(lifeLinesEntities.size());

			for (SDLifeLine lifeLineEntity : lifeLinesEntities) {
				//System.out.println("[AnchorProcessorInputImpl.FillInputSession] another lifeline "+Util.toString(lifeLineEntity));
				LifelineImpl lifeLineImpl = new LifelineImpl(NLS.bind("<Lifeline{0}>", new Object[] { DebugFormat.debugFormatEntity(lifeLineEntity) }));

				LifelineImpl.BottomElement bottomElement = traverseLifeLine(lifeLineEntity, lifeLineImpl);

				myResultLifelines.add(lifeLineImpl);

				lifeLineTopElements.add(bottomElement.getTopElement());
				lifeLineBottomElements.add(bottomElement);
			}

			for (int i = 0; i < myResolveRunnables.size(); i++) {
				Runnable runnable = (Runnable) myResolveRunnables.get(i);
				runnable.run();
			}

			//HorizontalConstraintImpl topConstraint = 
			new HorizontalConstraintImpl(lifeLineTopElements);
			//HorizontalConstraintImpl bottomConstraint = 
			new HorizontalConstraintImpl(lifeLineBottomElements);
			//System.out.println("[AnchorProcessorInputImpl.FillInputSession] creating top/bottom ("+topConstraint+" "+bottomConstraint+") constrains, sizes: "+lifeLineTopElements.size()+" "+lifeLineBottomElements.size());
		}

		List<LifeLine> getResultLifelines() {
			return myResultLifelines;
		}

		LifelineSatisfyCondition[] createCreationDestructionSatisfyCondition() {
			return myCreationDestructionCollector.createCreationDestructionSatisfyConditions(myResultLifelines);
		}

		LifelineElementTraceable[] getLifelineCreationTops() {
			return myCreationDestructionCollector.getLifelineCreationTops();
		}

		LifelineElementTraceable[] getLifelineDestructionBottoms() {
			return myCreationDestructionCollector.getLifelineDestructionBottoms();
		}

		private LifelineImpl.BottomElement traverseLifeLine(SDLifeLine lifeLine, LifelineImpl lifeLineImpl) {
			final LifelineImpl.TopElement topElement = lifeLineImpl.addTopLifelineElement(lifeLine, myLayoutPropertiesFactory);
			myCreationDestructionCollector.startLifeline(topElement);

			traverseLifeLineBracketChildren(lifeLine.getBrackets().iterator(), lifeLineImpl);

			final LifelineImpl.BottomElement bottomElement = lifeLineImpl.addBottomLifelineElement(topElement, myLayoutPropertiesFactory);
			myCreationDestructionCollector.finishLifeline(bottomElement);

			myLifeLineElement2Bottom.put(lifeLine, bottomElement);

			return bottomElement;
		}

		private void traverseLifeLineElement(SDBracket lifeLineElement, LifelineImpl lifeLineImpl) {
			if (myIgnoreBrackets.contains(lifeLineElement)) {
				return;
			}

			final LifelineImpl.TopElement topElement = lifeLineImpl.addTopLifelineElement(lifeLineElement, myLayoutPropertiesFactory);
			myCreationDestructionCollector.startElement(topElement);

			if (lifeLineElement instanceof SDBracketContainer) {
				SDBracketContainer bracketContainer = (SDBracketContainer) lifeLineElement;
				traverseLifeLineBracketChildren(bracketContainer.getBrackets().iterator(), lifeLineImpl);
			}

			final LifelineImpl.BottomElement bottomElement = lifeLineImpl.addBottomLifelineElement(topElement, myLayoutPropertiesFactory);
			myCreationDestructionCollector.finishElement(bottomElement);

			myLifeLineElement2Bottom.put(lifeLineElement, bottomElement);

			if (lifeLineElement instanceof SDInvocation) {
				final SDExecution destination = ((SDInvocation) lifeLineElement).getReceiveExecution();

				if (destination != null) {
					if (MissedMethods._executionSpecification().isAsynchronousInvocation((SDInvocation) lifeLineElement)) {
						//async
						myResolveRunnables.add(new Runnable() {

							public void run() {
								LifelineImpl.BottomElement executionBottomElement = (LifelineImpl.BottomElement) myLifeLineElement2Bottom.get(destination);
								if (executionBottomElement == null) {
									return;
								}

								LifelineImpl.TopElement executionTopElement = executionBottomElement.getTopElement();

								if (executionTopElement.getLifeLine() == topElement.getLifeLine()) {
									return;
								}

								new OrderingConstraintImpl(topElement, executionTopElement);
							}
						});

					} else {
						//synch
						myResolveRunnables.add(new Runnable() {

							public void run() {
								LifelineImpl.BottomElement executionBottomElement = (LifelineImpl.BottomElement) myLifeLineElement2Bottom.get(destination);
								if (executionBottomElement == null) {
									return;
								}

								LifelineImpl.TopElement executionTopElement = executionBottomElement.getTopElement();

								if (executionTopElement.getLifeLine() == topElement.getLifeLine()) {
									return;
								}

								new HorizontalConstraintImpl(new LifelineImpl.BoundaryElement[] { bottomElement, executionBottomElement });
								new HorizontalConstraintImpl(new LifelineImpl.BoundaryElement[] { topElement, executionTopElement });
							}
						});
					}
				}
			} else if (lifeLineElement instanceof SDMountingRegion) {
				SDFrame combinedFragment = findMountingRegionFrame((SDMountingRegion) lifeLineElement);
				if (combinedFragment != null) {
					List<SDMountingRegion> regions = myFrame2listOfMountingRegions.get(combinedFragment);
					if (regions == null) {
						final ArrayList<SDMountingRegion> createdList = new ArrayList<SDMountingRegion>(3);

						myResolveRunnables.add(new Runnable() {

							public void run() {
								List<LifelineImpl.BoundaryElement> topLifeLineElements = new ArrayList<LifelineImpl.BoundaryElement>(createdList.size());
								List<LifelineImpl.BoundaryElement> bottomLifeLineElements = new ArrayList<LifelineImpl.BoundaryElement>(createdList.size());
								for (int i = 0; i < createdList.size(); i++) {
									SDMountingRegion mountingRegion = (SDMountingRegion) createdList.get(i);
									LifelineImpl.BottomElement mountingRegionBottomElement = (LifelineImpl.BottomElement) myLifeLineElement2Bottom.get(mountingRegion);
									if (mountingRegionBottomElement == null) {
										continue;
									}

									LifelineImpl.TopElement mountingRegionTopElement = mountingRegionBottomElement.getTopElement();

									topLifeLineElements.add(mountingRegionTopElement);
									bottomLifeLineElements.add(mountingRegionBottomElement);
								}

								new HorizontalConstraintImpl(topLifeLineElements);
								new HorizontalConstraintImpl(bottomLifeLineElements);

							}
						});

						myFrame2listOfMountingRegions.put(combinedFragment, createdList);
						regions = createdList;
					}
					regions.add((SDMountingRegion) lifeLineElement);
				}
			}
		}

		private void traverseLifeLineBracketChildren(Iterator<SDBracket> childElements, LifelineImpl lifeLineImpl) {
			while (childElements.hasNext()) {
				SDBracket nextBracket = childElements.next();
				traverseLifeLineElement(nextBracket, lifeLineImpl);
			}
		}

		private SDFrame findMountingRegionFrame(SDMountingRegion mountingRegion) {
			return mountingRegion.getFrame();
		}

		private final List<LifeLine> myResultLifelines;

		private final ArrayList<Runnable> myResolveRunnables = new ArrayList<Runnable>();

		private final HashMap<SDFrame, List<SDMountingRegion>> myFrame2listOfMountingRegions = new HashMap<SDFrame, List<SDMountingRegion>>();

		private final Set<SDBracket> myIgnoreBrackets;

		private final LayoutPropertiesFactory myLayoutPropertiesFactory;

		private LifelineCreationDestructionCollector myCreationDestructionCollector;
	}

	private class HorizontalConstraintImpl implements HorizontalConstraint {

		HorizontalConstraintImpl(List<LifelineImpl.BoundaryElement> boundaryElementsList) {
			myLifeLineElementsList = new ArrayList<LifeLineElement>(boundaryElementsList);
			for (LifelineImpl.BoundaryElement boundaryElement : boundaryElementsList) {
				boundaryElement.setHorizontalConstraint(this);
			}
		}

		HorizontalConstraintImpl(LifelineImpl.BoundaryElement[] lifeLineElements) {
			myLifeLineElementsList = Arrays.<LifeLineElement> asList(lifeLineElements);
			for (int i = 0; i < lifeLineElements.length; i++) {
				lifeLineElements[i].setHorizontalConstraint(this);
			}
		}

		public List<LifeLineElement> getLifeLineElementsList() {
			return myLifeLineElementsList;
		}

		public void elementIsResolved(LifeLineElement lifeLineElement) {
		}

		public void elementIsViolated(LifeLineElement lifeLineElement) {
		}

		private final List<LifeLineElement> myLifeLineElementsList;
	}

	private class OrderingConstraintImpl implements OrderingConstraint {

		OrderingConstraintImpl(LifelineImpl.BoundaryElement beforeLifeLineElement, LifelineImpl.BoundaryElement afterLifeLineElement) {
			myBeforeLifeLineElement = beforeLifeLineElement;
			myAfterLifeLineElement = afterLifeLineElement;

			beforeLifeLineElement.addAfterConstraints(this);
			afterLifeLineElement.addBeforeConstraints(this);
		}

		public LifeLineElement getBeforeElement() {
			return myBeforeLifeLineElement;
		}

		public LifeLineElement getAfterElement() {
			return myAfterLifeLineElement;
		}

		public int getMinSlopeValue() {
			return 0;
		}

		public void setInvalid(boolean invalid) {
		}

		private final LifeLineElement myBeforeLifeLineElement;

		private final LifeLineElement myAfterLifeLineElement;
	}

	private final List<LifeLine> myLifelines;

	private final LifelineSatisfyCondition[] myCreationDestructionSatisfyConditions;

	private final LifelineElementTraceable[] myLifelineCreationTops;

	private final LifelineElementTraceable[] myLifelineDestructionBottoms;

	private final HashMap<SDLifeLineElement, LifelineImpl.BottomElement> myLifeLineElement2Bottom = new HashMap<SDLifeLineElement, LifelineImpl.BottomElement>();

	private final List<SDLifeLine> myLifelinesEntities;

	private final Map<SDLifeLine, Integer> myLifelineEntity2Index;

	private final Set<SDBracket> myIgnoredElements;

	private static abstract class LifeLineElementAdapter implements LifeLineElement, LifelineElementTraceable {

		public void optimizeSize() {
			//do nothing by default
		}

		public HorizontalConstraint getHorizontalConstraint() {
			return myHorizontalConstraint;
		}

		void setHorizontalConstraint(HorizontalConstraint horizontalConstraint) {
			if (myHorizontalConstraint != null && horizontalConstraint != null) {
				throw new IllegalStateException("Horizontal constraint is already set");
			}
			myHorizontalConstraint = horizontalConstraint;
		}

		void addBeforeConstraints(OrderingConstraint orderingConstraint) {
			if (myBeforeConstraintList == null) {
				myBeforeConstraintList = new ArrayList<OrderingConstraint>();
			}
			myBeforeConstraintList.add(orderingConstraint);
		}

		void addAfterConstraints(OrderingConstraint orderingConstraint) {
			if (myAfterConstraintList == null) {
				myAfterConstraintList = new ArrayList<OrderingConstraint>();
			}
			myAfterConstraintList.add(orderingConstraint);
		}

		public Enumeration<OrderingConstraint> beforeConstraints() {
			if (myBeforeConstraintList == null) {
				return EmptyEnumeration.getEnumeration();
			} else {
				return Collections.enumeration(myBeforeConstraintList);
			}
		}

		public Enumeration<OrderingConstraint> afterConstraints() {
			if (myAfterConstraintList == null) {
				return EmptyEnumeration.getEnumeration();
			} else {
				return Collections.enumeration(myAfterConstraintList);
			}
		}

		private HorizontalConstraint myHorizontalConstraint;

		private List<OrderingConstraint> myBeforeConstraintList = null;

		private List<OrderingConstraint> myAfterConstraintList = null;
	}

	private class LifelineImpl implements LifeLine {

		LifelineImpl(String name) {
			myName = name;
		}

		public LifeLineIterator iterator() {
			return new LifeLineIterator() {

				public Integer nextClueValue() {
					return NULL_CLUE;
				}

				public LifeLineElement nextElement() {
					try {
						return myCurrentElement;
					} finally {
						myCurrentElement = myCurrentElement.nextElement;
					}
				}

				public boolean hasNext() {
					return myCurrentElement != null;
				}

				private BoundaryElement myCurrentElement = myFirstElement;
			};
		}

		TopElement addTopLifelineElement(SDLifeLineElement entity, LayoutPropertiesFactory layoutPropertiesFactory) {
			TopElement result = new TopElement(entity, mySize, layoutPropertiesFactory.createLayoutProperties(entity, true));
			addElementToList(result);
			return result;
		}

		BottomElement addBottomLifelineElement(TopElement topElement, LayoutPropertiesFactory layoutPropertiesFactory) {
			BottomElement result = new BottomElement(topElement, mySize, layoutPropertiesFactory.createLayoutProperties(topElement.getEntity(), false));
			addElementToList(result);
			return result;
		}

		BoundaryElement getPreviousElement(BoundaryElement boundaryElement) {
			return boundaryElement.prevElement;
		}

		public String toString() {
			return MessageFormat.format("LL\'{0}\'", new Object[] { myName });
		}

		private void addElementToList(BoundaryElement boundaryElement) {
			if (myLastElement == null) {
				myLastElement = boundaryElement;
				myFirstElement = boundaryElement;
				boundaryElement.prevElement = null;
				boundaryElement.nextElement = null;
			} else {
				boundaryElement.prevElement = myLastElement;
				boundaryElement.nextElement = null;
				myLastElement.nextElement = boundaryElement;
				myLastElement = boundaryElement;
			}
			mySize++;
		}

		private BoundaryElement myFirstElement = null;

		private BoundaryElement myLastElement = null;

		private int mySize = 0;

		private final String myName;

		private abstract class BoundaryElement extends LifeLineElementAdapter {

			BoundaryElement(int number, ElementLayoutProperties elementLayoutProperties) {
				myNumber = number;
				myElementLayoutProperties = elementLayoutProperties;
			}

			public LifeLine getLifeLine() {
				return LifelineImpl.this;
			}

			public LifelineImpl getLifelineImpl() {
				return LifelineImpl.this;
			}

			public abstract boolean isTopNotBottom();

			abstract SDLifeLineElement getEntity();

			public LifelineElementTraceable getPreviousElement() {
				return this.prevElement;
			}

			public LifelineElementTraceable getNextElement() {
				return this.nextElement;
			}

			public BoundaryElement getPreviousBoundaryElement() {
				return this.prevElement;
			}

			public BoundaryElement getNextBoundaryElement() {
				return this.nextElement;
			}

			public int getNumber() {
				return myNumber;
			}

			public int getPointOffset() {
				return myElementLayoutProperties.getPointOffset();
			}

			public int getSize() {
				return myElementLayoutProperties.getSize();
			}

			public Position getPosition() {
				return myElementLayoutProperties.getPosition();
			}

			BoundaryElement nextElement;

			BoundaryElement prevElement;

			private final int myNumber;

			private final ElementLayoutProperties myElementLayoutProperties;
		}

		private class TopElement extends BoundaryElement {

			TopElement(SDLifeLineElement entity, int number, ElementLayoutProperties elementLayoutProperties) {
				super(number, elementLayoutProperties);
				myEntity = entity;
			}

			public boolean isTopNotBottom() {
				return true;
			}

			SDLifeLineElement getEntity() {
				return myEntity;
			}

			public String toString() {
				return MessageFormat.format("[TopOf({0}){1}]", new Object[] { DebugFormat.debugFormatEntity(getEntity()), getNumber() });
			}

			public SDLifeLineElement getEntityAfterElement() {
				return myEntity;
			}

			private final SDLifeLineElement myEntity;
		}

		private class BottomElement extends BoundaryElement {

			BottomElement(TopElement topElement, int number, ElementLayoutProperties elementLayoutProperties) {
				super(number, elementLayoutProperties);
				myTopElement = topElement;
			}

			public boolean isTopNotBottom() {
				return false;
			}

			SDLifeLineElement getEntity() {
				return myTopElement.getEntity();
			}

			TopElement getTopElement() {
				return myTopElement;
			}

			public SDLifeLineElement getEntityAfterElement() {
				if (getEntity() instanceof SDLifeLine){
					return null;
				}
				SDBracket bracket = (SDBracket) getEntity();
				return bracket.getBracketContainer();
			}

			public String toString() {
				return MessageFormat.format("[BottomOf({0}){1}]", new Object[] { DebugFormat.debugFormatEntity(getEntity()), getNumber() });
			}

			private final TopElement myTopElement;
		}
	}

	private static class LifelineCreationDestructionCollector {

		LifelineCreationDestructionCollector(int lifelineCount) {
			myLifelineCreation = new LifelineImpl.TopElement[lifelineCount];
			myLifelineDestruction = new LifelineImpl.BottomElement[lifelineCount];
		}

		void startLifeline(LifelineImpl.TopElement lifelineTop) {
			myCurrentLifelineIndex++;
		}

		void finishLifeline(LifelineImpl.BottomElement lifelineBottom) {
		}

		void startElement(LifelineImpl.TopElement topElement) {
			if (myLifelineCreation[myCurrentLifelineIndex] != null) {
				return;
			}

			SDEntity entity = topElement.getEntity();

			if (entity instanceof SDExecution && MissedMethods._executionSpecification().isCreation((SDExecution) entity)) {
				myLifelineCreation[myCurrentLifelineIndex] = topElement;
			}
		}

		void finishElement(LifelineImpl.BottomElement bottomElement) {
			SDEntity entity = bottomElement.getEntity();
			if (entity instanceof SDExecution && MissedMethods._executionSpecification().isDestruction((SDExecution) entity)) {
				myLifelineDestruction[myCurrentLifelineIndex] = bottomElement;
			}
		}

		LifelineElementTraceable[] getLifelineCreationTops() {
			return myLifelineCreation;
		}

		LifelineElementTraceable[] getLifelineDestructionBottoms() {
			return myLifelineDestruction;
		}

		LifelineSatisfyCondition[] createCreationDestructionSatisfyConditions(List<LifeLine> lifeilneImplList) {
			LifelineSatisfyCondition[] result = new LifelineSatisfyCondition[lifeilneImplList.size()];

			class NoElementsBeforeCreationOrAfterDestruction implements LifelineSatisfyCondition {

				NoElementsBeforeCreationOrAfterDestruction(LifelineImpl lifeline, LifelineImpl.TopElement creation, LifelineImpl.BottomElement destruction) {
					myLifeline = lifeline;
					myCreation = creation;
					myDestruction = destruction;
				}

				public boolean isSatisfied(LifelineElementTraceable elementTraceable) {
					if (myCreation != null) {
						if (elementTraceable.getNumber() < myCreation.getNumber()) {
							return false;
						}
					}
					if (myDestruction != null) {
						if (myDestruction.getNumber() <= elementTraceable.getNumber()) {
							return false;
						}
					}
					return true;
				}

				public LifeLine getLifeline() {
					return myLifeline;
				}

				private final LifelineImpl myLifeline;

				private final LifelineImpl.TopElement myCreation;

				private final LifelineImpl.BottomElement myDestruction;
			}

			for (int i = 0; i < myLifelineCreation.length; i++) {
				if (myLifelineCreation[i] != null || myLifelineDestruction[i] != null) {
					result[i] = new NoElementsBeforeCreationOrAfterDestruction((LifelineImpl) lifeilneImplList.get(i), myLifelineCreation[i], myLifelineDestruction[i]);
				}
			}

			return result;
		}

		private final LifelineImpl.TopElement[] myLifelineCreation;

		private final LifelineImpl.BottomElement[] myLifelineDestruction;

		private int myCurrentLifelineIndex = -1;
	}
}
