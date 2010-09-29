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
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDEntity;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionOperand;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLineElement;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;

/**
 * Helpers to be moved to SDModel operations
 */
public class SDModelUtil {

	public static class AlienElementException extends Exception {

		private static final long serialVersionUID = 1L;

		public AlienElementException() {
			super();
		}

		public AlienElementException(String message) {
			super(message);
		}

		public AlienElementException(String message, Throwable cause) {
			super(message, cause);
		}

		public AlienElementException(Throwable cause) {
			super(cause);
		}
	}

	public static class ModelProblemException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public ModelProblemException() {
			super();
		}

		public ModelProblemException(String message) {
			super(message);
		}

		public ModelProblemException(String message, Throwable cause) {
			super(message, cause);
		}

		public ModelProblemException(Throwable cause) {
			super(cause);
		}
	}

	public static class NoInteractionException extends ModelProblemException {

		private static final long serialVersionUID = 1L;

		NoInteractionException() {
			super();
		}

		NoInteractionException(String message) {
			super(message);
		}

		NoInteractionException(String message, Throwable cause) {
			super(message, cause);
		}

		NoInteractionException(Throwable cause) {
			super(cause);
		}
	}

	public static SDLifeLine findEnclosingLifeline2(SDLifeLineElement lifeLineElement) throws AlienElementException {
		SDLifeLine lifeLine = lifeLineElement.getCoveredLifeLine();
		if (lifeLine == null) {
			throw new AlienElementException("Element is not contained on lifeline " + lifeLineElement);
		}
		return lifeLine;
	}

	public static SDModel findEnclosingInteraction2(final SDLifeLineElement lifeLineElement) throws AlienElementException {
		SDModel result = findEnclosingLifeline2(lifeLineElement).getModel();
		if (result == null) {
			throw new AlienElementException("Element is on lifeline but not contained in interaction " + lifeLineElement);
		}
		return result;
	}

	/**
	 * @deprecated use getParentLifeLineElement instead
	 */
	public static SDEntity getParent(SDEntity entity) {
		EObject container = entity.eContainer();
		if (container instanceof SDEntity) {
			return (SDEntity) container;
		}
		throw new IllegalArgumentException("Parent of SDEntity " + entity + " is " + container);
	}

	/**
	 * XXX: move to SDModel op
	 */
	public static SDLifeLineElement getParentLifeLineElement(SDLifeLineElement lifeLineElement) {
		if (lifeLineElement instanceof SDLifeLine) {
			throw new IllegalArgumentException("LifeLines have no parents");
		}
		if (lifeLineElement == null) {
			throw new NullPointerException();
		}

		if (false == lifeLineElement instanceof SDBracket) {
			throw new ClassCastException("SDLifelineElement should be either bracket or lifeline: " + lifeLineElement);
		}
		return ((SDBracket) lifeLineElement).getBracketContainer();
	}

	public static boolean isNested(SDEntity entity1, SDEntity entity2) {
		return isNested(entity1, entity2, true);
	}

	public static boolean isNested(SDEntity entity1, final SDEntity entity2, boolean strict) {
		if (entity1 == entity2) {
			return !strict;
		}
		EObject container = entity1.eContainer();
		while (container instanceof SDEntity) {
			if (entity2 == container) {
				return true;
			}
			container = container.eContainer();
		}
		return false;
	}

	public static boolean canContainMountingRegions(SDEntity entity) {
		return entity instanceof SDBracketContainer;
	}

	public static boolean isNoElementsMountingRegion(SDEntity entity) {
		if (entity instanceof SDMountingRegion) {
			SDMountingRegion region = (SDMountingRegion) entity;
			return !(region.getFrame() instanceof SDInteractionOperand);
		}
		return false;
	}

	public static SDBracketContainer skipMountingRegions(final SDLifeLineElement element) throws AlienElementException {
		if (element == null) {
			throw new AlienElementException("element is not attached");
		}
		if (element instanceof SDMountingRegion) {
			SDLifeLineElement container = ((SDMountingRegion) element).getBracketContainer();
			return skipMountingRegions(container);
		}
		if (element instanceof SDLifeLine) {
			return (SDLifeLine) element;
		}
		if (element instanceof SDBehaviorSpec) {
			return (SDBehaviorSpec) element;
		}
		throw new AlienElementException("Wrond enclosing element: " + element);
	}

	public static void collectAncestorsUntilLifeline(SDLifeLineElement lifeLineElement, Collection<SDLifeLineElement> result) throws AlienElementException {
		if (false == lifeLineElement instanceof LifeLine) {
			SDLifeLineElement ancestor = getParentLifeLineElement(lifeLineElement);
			if (ancestor == null) {
				throw new AlienElementException("Element is not contained on lifeline " + lifeLineElement);
			}
			collectAncestorsUntilLifeline(ancestor, result);
		}
		result.add(lifeLineElement);
	}

	public static ArrayList<SDFrame> getEnclosingFramesForBracket(SDLifeLineElement lifeLineElement) throws AlienElementException {
		ArrayList<SDFrame> result = new ArrayList<SDFrame>();
		fillEnclosingFrames(lifeLineElement, result);
		return result;
	}

	/**
	 * Inner frames first
	 */
	static void fillEnclosingFrames(SDLifeLineElement lifeLineElement, List<SDFrame> output) throws AlienElementException {
		if (lifeLineElement instanceof SDLifeLine) {
			return;
		}
		if (lifeLineElement instanceof SDMountingRegion) {
			SDFrame frame = ((SDMountingRegion) lifeLineElement).getFrame();
			if (frame != null) {
				collectEnclosingFrames(frame, output);
				return;
			} else {
				throw new AlienElementException("Mounting region without a frame: " + lifeLineElement);
			}
		}
		SDLifeLineElement parent = getParentLifeLineElement(lifeLineElement);
		if (parent == null) {
			throw new AlienElementException("Cannot find enclosing lifeline for element");
		}
		fillEnclosingFrames(parent, output);
	}

	public static List<SDFrame> collectEnclosingFrames(SDFrame sdFrame, List<SDFrame> output) throws AlienElementException {
		SDFrame current = sdFrame;
		output.add(current);
		while (current.getFrameContainer() instanceof SDFrame) {
			current = (SDFrame) current.getFrameContainer();
			output.add(current);
		}
		if (current.getFrameContainer() == null) {
			throw new AlienElementException("Frame is not attached to interaction");
		}
		return output;
	}

	public static SDExecution findEnclosingExecution(SDLifeLineElement lifeLineElement) throws AlienElementException {
		if (lifeLineElement instanceof SDLifeLine) {
			return null;
		}
		if (lifeLineElement instanceof SDExecution) {
			return (SDExecution) lifeLineElement;
		}
		SDLifeLineElement parent = getParentLifeLineElement(lifeLineElement);
		if (parent == null) {
			throw new AlienElementException("LifelineElement is not attached to lifeline");
		}
		return findEnclosingExecution(parent);
	}
	
	public static boolean isAsynchonousMessage(SDAbstractMessage sdMessage) throws AlienElementException {
		Message umlMessage = sdMessage.getUmlMessage();
		if (umlMessage == null){
			throw new AlienElementException("SDMessage without a UMLMessage: " + sdMessage);
		}
		return isAsynchonousMessageSort(umlMessage.getMessageSort());
	}
	
	public static boolean isAsynchonousMessageSort(MessageSort messageSort) {
		return MessageSort.ASYNCH_CALL_LITERAL.equals(messageSort) || MessageSort.ASYNCH_SIGNAL_LITERAL.equals(messageSort);
	}
	
}
