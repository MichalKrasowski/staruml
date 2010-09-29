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

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineIterator;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;

class ConstraintsProcessor {

	private static final boolean loggable = false;

	ConstraintsProcessor(final LifeLine[] lifeLines) {
		myLifeLine2lifeLineData = new HashMap<LifeLine, LifelineData>();

		myLifelineDataList = new ArrayList<LifelineData>(lifeLines.length);

		for (int i = 0; i < lifeLines.length; i++) {
			LifelineData lifeLineData = new LifelineData(lifeLines[i]);
			myLifeLine2lifeLineData.put(lifeLines[i], lifeLineData);
			myLifelineDataList.add(lifeLineData);
		}
		myCurrentState = new AbstractList<LifeLineElement>() {

			public LifeLineElement get(int pos) {
				LifelineData lifeLineData = (LifelineData) myLifelineDataList.get(pos);
				return lifeLineData.getCurrentElement();
			}

			public int size() {
				return lifeLines.length;
			}
		};
		new ArrayList<LifeLineElement>(myCurrentState);
	}

	class SatisfyCondition {

		SatisfyCondition(LifelineSatisfyCondition[] lifelineSatisfyConitions) {
			myLifelineSatisfyConditions = lifelineSatisfyConitions;

			for (int i = 0; i < lifelineSatisfyConitions.length; i++) {
				if (lifelineSatisfyConitions[i] == null) {
					continue;
				}
				LifelineData data = (LifelineData) myLifelineDataList.get(i);
				if (data.getLifeLine() != lifelineSatisfyConitions[i].getLifeline()) {
					throw new IllegalArgumentException("Wrong Lifeline of satisfy condition");
				}
			}
		}

		/**
		 * @return index or -1
		 */
		int whichLifelineStepDown() {
			if (myLastCheckedMemory != -1) {
				if (!checkLifelineSatisfying(myLastCheckedMemory)) {
					return myLastCheckedMemory;
				}
			}
			for (int i = 0; i < myLifelineSatisfyConditions.length; i++) {
				if (!checkLifelineSatisfying(i)) {
					myLastCheckedMemory = i;
					return i;
				}
			}
			return -1;
		}

		public String toString() {
			return NLS.bind("SatisfyCondition for {0}", new Object[] { Arrays.asList(myLifelineSatisfyConditions) });
		}

		private boolean checkLifelineSatisfying(int index) {
			LifelineSatisfyCondition lifelineCondition = myLifelineSatisfyConditions[index];
			if (lifelineCondition == null) {
				return true;
			}
			LifelineElementTraceable traceableElement = (LifelineElementTraceable) getCurrentState().get(index);
			if (traceableElement == null) {
				if (loggable) {
					System.out.println("[ConstraintsProcessor.checkLifelineSatisfying] I.e. we even not started processing this lifeline; condition is bad then");
				}
				return false;
			}
			boolean res = lifelineCondition.isSatisfied(traceableElement);

			if (loggable) {
				if (!res) {
					System.out.println(//
							"[ConstraintsProcessor.checkLifelineSatisfying] traceable element " + traceableElement + //
									" with entity " + DebugFormat.debugFormatEntity(traceableElement.getEntityAfterElement()) + //
									" is not satisfying on " + myLifelineDataList.get(index) + //
									" because of " + lifelineCondition);
				}
			}
			return res;
		}

		private int myLastCheckedMemory = -1;

		private final LifelineSatisfyCondition[] myLifelineSatisfyConditions;
	}

	private interface StopSignal {

		StopSignal addAnother(StopSignal stopSignal);
	}

	private interface ProcessingDriver {

		StopSignal shouldResolveConstraintForElement(LifeLineElement constraintedElement, LifelineData initialLifeLineData);

		StopSignal shouldProcessAfterElement(LifeLineElement element);

		void lifelineStopped(LifelineData lifeLineData, StopSignal stopSignal);

		void lifeLineFinished(LifelineData lifeLineData) throws EvaluatingException;

		Todo chooseTodo() throws EvaluatingException;

		void elementFound(LifeLineElement element, LifelineData lifeLineData);

		interface Todo {

			LifelineData getLifeLineData();

			void saveProcessingResult(StopSignal stopSignal) throws EvaluatingException;
		}

	}

	private void processLifeLines(ProcessingDriver processingDriver) throws EvaluatingException {
		ProcessLifeLineSession processLifeLineSession = new ProcessLifeLineSession();
		while (true) {
			ProcessingDriver.Todo todo = processingDriver.chooseTodo();
			if (todo == null) {
				break;
			}
			LifelineData lifeLineData = todo.getLifeLineData();
			StopSignal stopSignal = processLifeLineSession.processLifeLine(processingDriver, lifeLineData, null);
			todo.saveProcessingResult(stopSignal);
		}
	}

	private class ProcessLifeLineSession {

		public StopSignal processLifeLine(ProcessingDriver processingDriver, LifelineData lifeLineData, final Object requiredConstraint) throws EvaluatingException {
			if (loggable) {
				System.out.println("[ConstraintsProcessor.processLifeLine] >>> lifeLineData=" + lifeLineData);
				System.out.println("[ConstraintsProcessor.processLifeLine]     requiredConstraint=" + requiredConstraint);
			}

			try {
				if (isLocked(lifeLineData)) {
					if (loggable) {
						System.out.println("[ConstraintsProcessor.processLifeLine] lifeLine is locked: " + lifeLineData);
					}
					throw new EvaluatingException("Lifeline is blocked; probably because of cyclic dependencies in constraints");
				}

				while (lifeLineData.hasNext()) {
					LifeLineElement element = lifeLineData.nextElement();
					if (loggable) {
						System.out.println("[ConstraintsProcessor.processLifeLine] next element: " + element);
					}

					processingDriver.elementFound(element, lifeLineData);

					if (loggable) {
						System.out.println("[ConstraintsProcessor.processLifeLine] lock " + lifeLineData);
					}

					boolean requiredOrderingConstraintFound = false;

					{
						if (loggable) {
							System.out.println("[ConstraintsProcessor.processLifeLine] check 'after' constraints");
						}

						for (Enumeration<OrderingConstraint> orderingConstraintEnum = element.afterConstraints(); orderingConstraintEnum.hasMoreElements();) {
							OrderingConstraint orderingConstraint = orderingConstraintEnum.nextElement();
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] orderingConstraint=" + orderingConstraint);
							}
							if (orderingConstraint == requiredConstraint) {
								if (loggable) {
									System.out.println("[ConstraintsProcessor.processLifeLine] it is required!");
								}
								requiredOrderingConstraintFound = true;
							} else {
								lifeLineData.getFoundAfterConstraintSet().add(orderingConstraint);
							}
						}
						if (requiredOrderingConstraintFound) {
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] required constraint (ordering) met, return");
							}
						}
					}

					setLocked(lifeLineData, true);
					boolean doNotUnlock = false;
					try {
						StopSignal stopSignal = null;

						{
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] checking 'before' constraints");
							}
							for (Enumeration<OrderingConstraint> orderingConstraintEnum = element.beforeConstraints(); orderingConstraintEnum.hasMoreElements();) {
								OrderingConstraint orderingConstraint = orderingConstraintEnum.nextElement();
								if (loggable) {
									System.out.println("[ConstraintsProcessor.processLifeLine] orderingConstraint=" + orderingConstraint);
								}
								LifeLineElement constraintedElement = orderingConstraint.getBeforeElement();
								LifeLine otherLifeLine = constraintedElement.getLifeLine();

								if (otherLifeLine == lifeLineData.getLifeLine()) {
									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] self-constraint");
									}
									boolean res = lifeLineData.getFoundAfterConstraintSet().remove(orderingConstraint);
									if (!res) {
										throw new EvaluatingException("Cannot find 'before' element of one-lifeline ordering constraint");
									}
									continue;
								}

								LifelineData otherLifeLineData = getLifeLineData(otherLifeLine);
								if (loggable) {
									System.out.println("[ConstraintsProcessor.processLifeLine] constraintedElement=" + constraintedElement + " from " + otherLifeLineData);
								}

								boolean res = otherLifeLineData.getFoundAfterConstraintSet().remove(orderingConstraint);

								if (res) {
									// all OK
									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] 'before' element has been already met on other lifeline");
									}
								} else {
									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] should wait for 'before' element");
									}
									StopSignal subSignal;
									subSignal = processingDriver.shouldResolveConstraintForElement(constraintedElement, lifeLineData);
									if (subSignal != null) {
										if (loggable) {
											System.out.println("[ConstraintsProcessor.processLifeLine] stop resolving on this element (1), subsignal=" + subSignal);
										}
										stopSignal = subSignal.addAnother(stopSignal);
										continue;
									}

									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] processing another lifeline " + otherLifeLineData);
									}
									subSignal = processLifeLine(processingDriver, otherLifeLineData, orderingConstraint);
									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] processing subSignal = " + subSignal);
									}
									if (subSignal != null) {
										if (loggable) {
											System.out.println("[ConstraintsProcessor.processLifeLine] stop resolving on this element (2)");
										}
										stopSignal = subSignal.addAnother(stopSignal);
										continue;
									}
								}
							}

						}

						HorizontalConstraint horizontalConstraint = element.getHorizontalConstraint();
						if (horizontalConstraint != null) {
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] horizontalConstraint=" + horizontalConstraint);
							}

							if (horizontalConstraint == requiredConstraint) {
								if (loggable) {
									System.out.println("[ConstraintsProcessor.processLifeLine] required constraint met, return");
								}
								return null;
							}

							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] starting resolving " + horizontalConstraint.getLifeLineElementsList().size() + " elements");
							}

							List<LifelineData> processedFreeLifelineDatas = new ArrayList<LifelineData>(3);

							for (LifeLineElement constraintedElement : horizontalConstraint.getLifeLineElementsList()) {
								if (element != constraintedElement) {
									LifelineData otherLifeLineData = getLifeLineData(constraintedElement.getLifeLine());
									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] constraintedElement=" + constraintedElement + " from " + otherLifeLineData);
									}

									StopSignal subSignal;
									subSignal = processingDriver.shouldResolveConstraintForElement(constraintedElement, lifeLineData);
									if (subSignal != null) {
										if (loggable) {
											System.out.println("[ConstraintsProcessor.processLifeLine] stop resolving on this element (3) subSignal=" + subSignal);
										}
										stopSignal = subSignal.addAnother(stopSignal);
										continue;
									}

									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] processing another lifeline " + otherLifeLineData);
									}
									subSignal = processLifeLine(processingDriver, otherLifeLineData, horizontalConstraint);
									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] processing subSignal = " + subSignal);
									}
									if (subSignal != null) {
										if (loggable) {
											System.out.println("[ConstraintsProcessor.processLifeLine] stop resolving on this element (4)");
										}
										stopSignal = subSignal.addAnother(stopSignal);
										continue;
									}

									processedFreeLifelineDatas.add(otherLifeLineData);
								}
							}
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] resolving horizontal constraint finished");
							}
							if (stopSignal != null) {
								if (loggable) {
									System.out.println("[ConstraintsProcessor.processLifeLine] some lifelines should be stopped");
								}
								for (int i = 0; i < processedFreeLifelineDatas.size(); i++) {
									LifelineData freeLifeLineData = (LifelineData) processedFreeLifelineDatas.get(i);
									if (loggable) {
										System.out.println("[ConstraintsProcessor.processLifeLine] stop free lifeline " + freeLifeLineData);
									}
									processingDriver.lifelineStopped(freeLifeLineData, stopSignal);
								}
							}
						}

						if (stopSignal != null) {
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] resolving stopped on lifeline " + lifeLineData);
							}
							doNotUnlock = true;

							processingDriver.lifelineStopped(lifeLineData, stopSignal);
							return stopSignal;
						}

						if (requiredOrderingConstraintFound) {
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] required ordering constraint was met, return");
							}
							return null;
						}

					} finally {
						if (!doNotUnlock) {
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] unlock lifeline " + lifeLineData);
							}
							setLocked(lifeLineData, false);
						}
					}

					{
						if (loggable) {
							System.out.println("[ConstraintsProcessor.processLifeLine] ask driver about current element");
						}
						StopSignal stopSignal = processingDriver.shouldProcessAfterElement(element);
						if (stopSignal != null) {
							if (loggable) {
								System.out.println("[ConstraintsProcessor.processLifeLine] stop on this element and lock lifeline " + lifeLineData + " with signal " + stopSignal);
							}
							return stopSignal;
						}
					}
				}
				if (loggable) {
					System.out.println("[ConstraintsProcessor.processLifeLine] lifeLine finished");
				}
				processingDriver.lifeLineFinished(lifeLineData);

				return null;
			} finally {
				if (loggable) {
					System.out.println("[ConstraintsProcessor.processLifeLine] <<<");
				}
			}
		}

		private void setLocked(LifelineData lifeLineData, boolean lock) {
			if (lock) {
				if (!myLockedLifeLineDatas.add(lifeLineData)) {
					throw new RuntimeException("LifeLineData is already locked");
				}
			} else {
				myLockedLifeLineDatas.remove(lifeLineData);
			}
		}

		private boolean isLocked(LifelineData lifeLineData) {
			return myLockedLifeLineDatas.contains(lifeLineData);
		}

		private final Set<LifelineData> myLockedLifeLineDatas = new HashSet<LifelineData>();
	}

	List<LifeLineElement> getCurrentState() {
		return myCurrentState;
	}

	private LifelineData getLifeLineData(LifeLine lifeLine) {
		LifelineData result = (LifelineData) myLifeLine2lifeLineData.get(lifeLine);
		if (result == null) {
			throw new RuntimeException(NLS.bind("Cannot find lifeline data for {0}", new Object[] { lifeLine }));
		}
		return result;
	}

	private static class LifelineData {

		LifelineData(LifeLine lifeLine) {
			myLifeLine = lifeLine;
			myLifeLineIterator = lifeLine.iterator();
		}

		LifeLineElement getCurrentElement() {
			return myCurrentElement;
		}

		LifeLineElement nextElement() {
			myCurrentElement = myLifeLineIterator.nextElement();
			return myCurrentElement;
		}

		boolean hasNext() {
			return myLifeLineIterator.hasNext();
		}

		LifeLine getLifeLine() {
			return myLifeLine;
		}

		public String toString() {
			return "LLData:" + myLifeLine;
		}

		Set<OrderingConstraint> getFoundAfterConstraintSet() {
			return myFoundAfterConstraintSet;
		}

		private final LifeLine myLifeLine;

		private final LifeLineIterator myLifeLineIterator;

		private final Set<OrderingConstraint> myFoundAfterConstraintSet = new HashSet<OrderingConstraint>(5);

		private LifeLineElement myCurrentElement;
	}

	private final Map<LifeLine, LifelineData> myLifeLine2lifeLineData;

	private final List<LifelineData> myLifelineDataList;

	private final List<LifeLineElement> myCurrentState;

	private static class SingleInstanceStopSignal implements StopSignal {

		SingleInstanceStopSignal(String tag) {
			myTag = tag;
		}

		public StopSignal addAnother(StopSignal stopSignal) {
			if (stopSignal != null && stopSignal != this) {
				throw new RuntimeException("Inconsistent stop signal");
			}
			return this;
		}

		public String toString() {
			return myTag;
		}

		private final String myTag;
	};

	static class MultipleElementsProcessor {

		MultipleElementsProcessor(ConstraintsProcessor constraintsProcessor, Collection<LifeLineElement> controlLifelineElementList) {
			myConstraintsProcessor = constraintsProcessor;

			myLifelineElements = new HashSet<LifeLineElement>(controlLifelineElementList.size());
			myMovableLifelineDatas = new HashSet<LifelineData>(myConstraintsProcessor.myLifeLine2lifeLineData.values());
			Set<LifeLine> constraintedLifelines = new HashSet<LifeLine>(controlLifelineElementList.size());
			for (LifeLineElement lifeLineElement : controlLifelineElementList) {
				myLifelineElements.add(lifeLineElement);
				boolean res = constraintedLifelines.add(lifeLineElement.getLifeLine());
				if (!res) {
					throw new RuntimeException(NLS.bind("Lifeline is constrained twice: {0}", new Object[] { lifeLineElement.getLifeLine() }));
				}
			}

			myUnreachedLifelineElements = new HashSet<LifeLineElement>(myLifelineElements);
		}

		void processTo() throws EvaluatingException {
			ProcessingDriver processingDriver = new ProcessToDriver();
			myConstraintsProcessor.processLifeLines(processingDriver);
		}

		void processHolding() throws EvaluatingException {
			ProcessingDriver processingDriver = new ProcessHoldingDriver();
			myConstraintsProcessor.processLifeLines(processingDriver);

			for (LifeLineElement element : myLifelineElements) {
				LifelineData data = myConstraintsProcessor.getLifeLineData(element.getLifeLine());
				// shift forward, to make result range containing of non-equal ends 
				data.nextElement();
			}
		}

		void processTo(SatisfyCondition satisfyCondition) throws EvaluatingException {

			if (loggable) {
				System.out.println("[ConstraintsProcessor.processTo] >>> satisfying");
				System.out.println("[ConstraintsProcessor.processTo] ----------------------------------->");

				System.out.println("[ConstraintsProcessor.processTo] start ProcessToDriver");
				System.out.println("[ConstraintsProcessor.processTo] myLifelineElements=" + myLifelineElements);
			}
			ProcessingDriver processingDriver = new ProcessToDriver();
			myConstraintsProcessor.processLifeLines(processingDriver);

			if (loggable) {
				System.out.println("[ConstraintsProcessor.processTo] start ProcessSatisfyingDriver");
				System.out.println("[ConstraintsProcessor.processTo] satisfyCondition=" + satisfyCondition);
			}

			ProcessSatisfyingDriver processSatisfyingDriver = new ProcessSatisfyingDriver(satisfyCondition);
			myConstraintsProcessor.processLifeLines(processSatisfyingDriver);

			if (loggable) {
				System.out.println("[ConstraintsProcessor.processTo] -----------------------------------<");
				System.out.println("[ConstraintsProcessor.processTo] <<< satisfying");
			}
		}

		private final Set<LifeLineElement> myUnreachedLifelineElements;

		private final Set<LifeLineElement> myLifelineElements;

		private final Set<LifelineData> myMovableLifelineDatas;

		private final ConstraintsProcessor myConstraintsProcessor;

		private abstract class DriverBase implements ProcessingDriver {

			public StopSignal shouldResolveConstraintForElement(LifeLineElement constraintedElement, LifelineData initialLifeLineData) {
				LifelineData data = myConstraintsProcessor.getLifeLineData(constraintedElement.getLifeLine());
				if (myMovableLifelineDatas.contains(data)) {
					return null;
				} else {
					return OTHER_LIFELINE_FIXED_SIGNAL;
				}
			}

			public StopSignal shouldProcessAfterElement(LifeLineElement element) {
				if (myLifelineElements.contains(element)) {
					LifeLine lifeline = element.getLifeLine();
					if (lifeline == myActiveLifeline) {
						if (loggable) {
							System.out.println("[ConstraintsProcessor.shouldProcessAfterElement] on that lifeline");
						}
						return ELEMENT_REACHED_SIGNAL;
					} else {
						return OTHER_LIFELINE_FIXED_SIGNAL;
					}
				} else {
					return null;
				}
			}

			public void elementFound(LifeLineElement element, LifelineData lifeLineData) {
				boolean res = myUnreachedLifelineElements.remove(element);
				if (res) {
					if (loggable) {
						System.out.println("[ConstraintsProcessor.elementFound]  found required element " + element);
					}
					myMovableLifelineDatas.remove(lifeLineData);
				}
			}

			protected void setActiveLifeline(LifeLine activeLifeline) {
				myActiveLifeline = activeLifeline;
			}

			private LifeLine myActiveLifeline;
		}

		private class ProcessToDriver extends DriverBase {

			public void lifeLineFinished(LifelineData lifeLineData) throws EvaluatingException {
				throw new EvaluatingException(NLS.bind("Failed to find required element on lifeline {0}", new Object[] { lifeLineData }));
			}

			public void lifelineStopped(LifelineData lifelineData, StopSignal stopSignal) {
			}

			public Todo chooseTodo() {
				if (myUnreachedLifelineElements.isEmpty()) {
					return null;
				}

				LifeLineElement nextAnchorElement = (LifeLineElement) myUnreachedLifelineElements.iterator().next();
				final LifelineData lifeLineData = myConstraintsProcessor.getLifeLineData(nextAnchorElement.getLifeLine());

				if (loggable) {
					System.out.println("[ProcessToDriver.chooseTodo] starting required lifeline " + lifeLineData + " till element " + nextAnchorElement);
				}
				setActiveLifeline(lifeLineData.getLifeLine());

				return new Todo() {

					public LifelineData getLifeLineData() {
						return lifeLineData;
					}

					public void saveProcessingResult(StopSignal stopSignal) throws CannotAlignElementsException {
						if (stopSignal == OTHER_LIFELINE_FIXED_SIGNAL) {
							throw new CannotAlignElementsException("Failed to keep all control points aligned");
						}
						setActiveLifeline(null);
					}
				};
			}
		}

		private class ProcessHoldingDriver extends DriverBase {

			public void lifeLineFinished(LifelineData lifeLineData) throws EvaluatingException {
			}

			public void lifelineStopped(LifelineData lifelineData, StopSignal stopSignal) {
				myMovableLifelineDatas.remove(lifelineData);
			}

			public Todo chooseTodo() {
				if (myMovableLifelineDatas.isEmpty()) {
					return null;
				}

				final LifelineData lifeLineData = (LifelineData) myMovableLifelineDatas.iterator().next();
				setActiveLifeline(lifeLineData.getLifeLine());

				if (loggable) {
					System.out.println("[ProcessHoldingDriver.chooseTodo] starting movable lifeline " + lifeLineData);
				}

				return new Todo() {

					public LifelineData getLifeLineData() {
						return lifeLineData;
					}

					public void saveProcessingResult(StopSignal stopSignal) {
						setActiveLifeline(null);
					}
				};

			}
		}

		private class ProcessSatisfyingDriver extends DriverBase {

			ProcessSatisfyingDriver(SatisfyCondition satisfyCondition) {
				mySatisfyCondition = satisfyCondition;
			}

			public void lifeLineFinished(LifelineData lifeLineData) throws EvaluatingException {
				throw new EvaluatingException(NLS.bind("Failed to find good location on lifeline {0}", new Object[] { lifeLineData }));
			}

			public void lifelineStopped(LifelineData lifelineData, StopSignal stopSignal) {
			}

			public StopSignal shouldProcessAfterElement(LifeLineElement element) {
				StopSignal superResult = super.shouldProcessAfterElement(element);
				if (superResult != null) {
					return superResult;
				}
				if (element.getLifeLine() == myUnsatisfiedLifelineData.getLifeLine()) {
					return ELEMENT_REACHED_SIGNAL;
				} else {
					return null;
				}
			}

			public Todo chooseTodo() throws EvaluatingException {
				if (loggable) {
					System.out.println("[ConstraintsProcessor.ProcessSatisfyingDriver.chooseTodo] ");
				}
				int unsatisfiedLifelineIndex = mySatisfyCondition.whichLifelineStepDown();
				if (loggable) {
					System.out.println("[ConstraintsProcessor.ProcessSatisfyingDriver.chooseTodo] unsatisfiedLifelineIndex=" + unsatisfiedLifelineIndex);
				}

				if (unsatisfiedLifelineIndex == -1) {
					return null;
				}

				LifelineData unsatisfiedLifelineData = (LifelineData) myConstraintsProcessor.myLifelineDataList.get(unsatisfiedLifelineIndex);

				if (!myMovableLifelineDatas.contains(unsatisfiedLifelineData)) {
					throw new EvaluatingException(NLS.bind("Lifeline condition is not satisfied for {0}, but lifeline is locked by control element", new Object[] { unsatisfiedLifelineData }));
				}

				myUnsatisfiedLifelineData = unsatisfiedLifelineData;

				return new Todo() {

					public LifelineData getLifeLineData() {
						return myUnsatisfiedLifelineData;
					}

					public void saveProcessingResult(StopSignal stopSignal) throws EvaluatingException {
						try {
							if (stopSignal == OTHER_LIFELINE_FIXED_SIGNAL) {
								throw new EvaluatingException(NLS.bind("Failed to find good location on lifeline {0}", new Object[] { myUnsatisfiedLifelineData }));
							}
						} finally {
							myUnsatisfiedLifelineData = null;
						}
					}
				};
			}

			private final SatisfyCondition mySatisfyCondition;

			private LifelineData myUnsatisfiedLifelineData;
		}

		private static final StopSignal OTHER_LIFELINE_FIXED_SIGNAL = new SingleInstanceStopSignal("OTHER_LIFELINE_FIXED_SIGNAL");

		private static final StopSignal ELEMENT_REACHED_SIGNAL = new SingleInstanceStopSignal("ELEMENT_REACHED_SIGNAL");
	}

	static class UnsatisfiedDependencyException extends EvaluatingException {

		private static final long serialVersionUID = 1L;

		protected UnsatisfiedDependencyException() {
			super();
		}

		protected UnsatisfiedDependencyException(String message) {
			super(message);
		}

		protected UnsatisfiedDependencyException(String message, Throwable cause) {
			super(message, cause);
		}

		protected UnsatisfiedDependencyException(Throwable cause) {
			super(cause);
		}
	}
}
