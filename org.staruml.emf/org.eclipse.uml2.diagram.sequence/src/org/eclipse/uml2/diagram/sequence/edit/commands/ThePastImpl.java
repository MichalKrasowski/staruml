package org.eclipse.uml2.diagram.sequence.edit.commands;

import java.util.ListIterator;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateLinkCommand;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateParameters;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;


public class ThePastImpl extends org.eclipse.uml2.diagram.sequence.model.edit.InsertFragmentAfter {
	public ThePastImpl(){
		//
	}
	
	public ThePastImpl(U2TCreateParameters createParams){
		this();
		addThePastFromAnchor(createParams);
	}
	
	public ThePastImpl(U2TCreateLinkCommand commandPack){
		this();
		addThePastFromAnchor(commandPack.getSourceParameters());
		addThePastFromAnchor(commandPack.getTargetParameters());
	}
	
	public ListIterator<InteractionFragment> getAfterThePastPosition(Interaction interaction) {
		return getAfterThePastPosition(interaction.getFragments());
	}

	protected void addThePastFromAnchor(U2TCreateParameters params) {
		View anchor = params.getAnchorSibling();
		if (anchor != null && !params.isBeforeNotAfterAnchor()) {
			InteractionFragment semanticAnchor = (InteractionFragment) anchor.getElement();
			fragmentFinished(semanticAnchor);
		}
	}

}
