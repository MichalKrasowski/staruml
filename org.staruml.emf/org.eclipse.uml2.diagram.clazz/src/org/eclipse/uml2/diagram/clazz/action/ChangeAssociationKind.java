package org.eclipse.uml2.diagram.clazz.action;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.common.commands.ChangeAssociationKindCommand;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;

public class ChangeAssociationKind extends DiagramAction {
	
	private AggregationKind kind;
	public ChangeAssociationKind(IWorkbenchPage workbenchPage, AggregationKind aggregationKind) {
		super(workbenchPage);
		this.kind = aggregationKind;
		setText(getLabelTable().get(kind));
	}

	@Override
	protected Command getCommand() {
		Association association = getAssociation();
		if (association == null) {
			return UnexecutableCommand.INSTANCE;
		}
		AggregationKind currentKind = AssociationEndConvention.getTargetEnd(association).getAggregation();
		if (currentKind != null && currentKind.getValue() == kind.getValue()) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest request = new ChangeAssociationKindCommand.SetAggregationKindRequest(association, kind);
		SetValueCommand setValueCommand = new SetValueCommand(request);
		return new ICommandProxy(setValueCommand);
	}
	
	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}
	
	private Association getAssociation() {
		ConnectionEditPart editPart = getSelectedEditPart();
		View view = editPart.getNotationView();
		return (view != null) ? (Association)view.getElement() : null;
	}
	
	private ConnectionEditPart getSelectedEditPart() {
		for (Object ob : getSelectedObjects()) {
			if (ob instanceof ConnectionEditPart) {
				return (ConnectionEditPart) ob;
			}
		}
		return null;
	}
	
	
	private Map<AggregationKind, String> getLabelTable() {
		if (oursKindToLabelTable == null) {
			oursKindToLabelTable = new HashMap<AggregationKind, String>();
			oursKindToLabelTable.put(AggregationKind.COMPOSITE_LITERAL, LABEL_COMPOSITE);
			oursKindToLabelTable.put(AggregationKind.NONE_LITERAL, LABEL_NONE);
			oursKindToLabelTable.put(AggregationKind.SHARED_LITERAL, LABEL_SHARED);
		}
		return oursKindToLabelTable;
	}
	private static Map<AggregationKind, String> oursKindToLabelTable;
	private static final String LABEL_NONE=CustomMessages.ChangeAssociationKind_none_action_label;
	private static final String LABEL_COMPOSITE=CustomMessages.ChangeAssociationKind_composite_action_label;
	private static final String LABEL_SHARED=CustomMessages.ChangeAssociationKind_shared_action_label;
}
