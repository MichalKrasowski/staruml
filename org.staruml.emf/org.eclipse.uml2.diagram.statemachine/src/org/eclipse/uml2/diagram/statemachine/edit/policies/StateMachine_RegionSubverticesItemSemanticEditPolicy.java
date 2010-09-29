package org.eclipse.uml2.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.statemachine.edit.commands.ChoicePseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.DeepHistoryPseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.FinalStateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.ForkPseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.InitialPseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.JoinPseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.JunctionPseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.ShallowHistoryPseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.SimpleStateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.State2CreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.SubmachineStateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.TerminatePseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class StateMachine_RegionSubverticesItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateMachine_RegionSubverticesItemSemanticEditPolicy() {
		super(UMLElementTypes.Region_3013);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.State_3001 == req.getElementType()) {
			return getGEFWrapper(new SimpleStateCreateCommand(req));
		}
		if (UMLElementTypes.State_3012 == req.getElementType()) {
			return getGEFWrapper(new State2CreateCommand(req));
		}
		if (UMLElementTypes.State_3016 == req.getElementType()) {
			return getGEFWrapper(new SubmachineStateCreateCommand(req));
		}
		if (UMLElementTypes.FinalState_3003 == req.getElementType()) {
			return getGEFWrapper(new FinalStateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3004 == req.getElementType()) {
			return getGEFWrapper(new InitialPseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3005 == req.getElementType()) {
			return getGEFWrapper(new ShallowHistoryPseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3006 == req.getElementType()) {
			return getGEFWrapper(new DeepHistoryPseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3007 == req.getElementType()) {
			return getGEFWrapper(new ForkPseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3008 == req.getElementType()) {
			return getGEFWrapper(new JoinPseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3009 == req.getElementType()) {
			return getGEFWrapper(new JunctionPseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3010 == req.getElementType()) {
			return getGEFWrapper(new ChoicePseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3011 == req.getElementType()) {
			return getGEFWrapper(new TerminatePseudostateCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
