package org.eclipse.uml2.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_AcceptEventActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_AcceptTimeEventActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_ActivityFinalNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_AddStructuralFeatureValueActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_CallBehaviorActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_CallOperationActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_CentralBufferNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_CreateObjectActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_DataStoreNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_DecisionNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_FlowFinalNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_ForkNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_InputPinCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_JoinNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_OpaqueActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_OutputPinCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_PinCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNode_StructuredActivityNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */

public class ActivityPartition_ExpansionRegionNodeCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActivityPartition_ExpansionRegionNodeCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.ExpansionRegion_3085);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.StructuredActivityNode_3009 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_StructuredActivityNodeCreateCommand(req));
		}
		if (UMLElementTypes.OpaqueAction_3011 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_OpaqueActionCreateCommand(req));
		}
		if (UMLElementTypes.AcceptEventAction_3012 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_AcceptEventActionCreateCommand(req));
		}
		if (UMLElementTypes.AcceptEventAction_3013 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_AcceptTimeEventActionCreateCommand(req));
		}
		if (UMLElementTypes.ActivityFinalNode_3014 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_ActivityFinalNodeCreateCommand(req));
		}
		if (UMLElementTypes.DecisionNode_3015 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_DecisionNodeCreateCommand(req));
		}
		if (UMLElementTypes.FlowFinalNode_3016 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_FlowFinalNodeCreateCommand(req));
		}
		if (UMLElementTypes.Pin_3017 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_PinCreateCommand(req));
		}
		if (UMLElementTypes.CreateObjectAction_3018 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_CreateObjectActionCreateCommand(req));
		}
		if (UMLElementTypes.CallBehaviorAction_3019 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_CallBehaviorActionCreateCommand(req));
		}
		if (UMLElementTypes.CallOperationAction_3020 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_CallOperationActionCreateCommand(req));
		}
		if (UMLElementTypes.ForkNode_3021 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_ForkNodeCreateCommand(req));
		}
		if (UMLElementTypes.JoinNode_3022 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_JoinNodeCreateCommand(req));
		}
		if (UMLElementTypes.AddStructuralFeatureValueAction_3023 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_AddStructuralFeatureValueActionCreateCommand(req));
		}
		if (UMLElementTypes.DataStoreNode_3024 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_DataStoreNodeCreateCommand(req));
		}
		if (UMLElementTypes.CentralBufferNode_3025 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_CentralBufferNodeCreateCommand(req));
		}
		if (UMLElementTypes.InputPin_3054 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_InputPinCreateCommand(req));
		}
		if (UMLElementTypes.OutputPin_3055 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNode_OutputPinCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
