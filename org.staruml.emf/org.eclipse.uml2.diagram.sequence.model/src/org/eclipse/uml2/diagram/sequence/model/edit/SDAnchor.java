package org.eclipse.uml2.diagram.sequence.model.edit;

import java.util.List;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;

public class SDAnchor {

	private final SDBracketContainer myContainer;

	private final SDBracket myAnchor;

	private final boolean myIsBeforeNotAfterAnchor;

	public SDAnchor(SDBracketContainer container, SDBracket anchor, boolean isBeforeNotAfterAnchor) {
		myContainer = container;
		myAnchor = anchor;
		myIsBeforeNotAfterAnchor = isBeforeNotAfterAnchor;
	}

	public boolean isBeforeNotAfterAnchor() {
		return myIsBeforeNotAfterAnchor;
	}

	public boolean isAfterAnchor() {
		return !myIsBeforeNotAfterAnchor;
	}

	public boolean isFirstElement() {
		return myIsBeforeNotAfterAnchor && myAnchor == null;
	}

	public SDBracket getAnchor() {
		return myAnchor;
	}

	public SDBracketContainer getContainer() {
		return myContainer;
	}

	public static SDAnchor after(SDBracket bracket) {
		return new SDAnchor(bracket.getBracketContainer(), bracket, false);
	}

	public static SDAnchor firstChildFor(SDBracketContainer container) {
		return new SDAnchor(container, null, true);
	}

	public static SDAnchor lastChildFor(SDBracketContainer container) {
		List<SDBracket> brackets = container.getBrackets();
		return brackets.isEmpty() ? firstChildFor(container) : after(brackets.get(brackets.size() - 1));
	}
	
}
