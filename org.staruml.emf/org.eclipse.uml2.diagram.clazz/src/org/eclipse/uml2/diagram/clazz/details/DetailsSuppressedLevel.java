package org.eclipse.uml2.diagram.clazz.details;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.common.details.DetailLevelParserOptions;

class DetailsSuppressedLevel extends UMLDetailLevel {

	@Override
	public void init(View view) {
		ViewUtil.setPropertyValue(view, NotationPackage.eINSTANCE.getView_Visible(), NotationPackage.eINSTANCE.getView(), false);
	}

	@Override
	public List<EditElementCommand> getApplyCommands(TransactionalEditingDomain editingDomain, View view) {
		List<EditElementCommand> result = new ArrayList<EditElementCommand>(1);
		SetRequest setVisibilityRequest = new SetRequest(editingDomain, view, NotationPackage.eINSTANCE.getView_Visible(), false);
		result.add(new SetValueCommand(setVisibilityRequest));
		return result;
	}

	@Override
	public List<EditElementCommand> getUnapplyCommands(TransactionalEditingDomain editingDomain, View view) {
		List<EditElementCommand> result = new ArrayList<EditElementCommand>(1);
		SetRequest setVisibilityRequest = new SetRequest(editingDomain, view, NotationPackage.eINSTANCE.getView_Visible(), true);
		result.add(new SetValueCommand(setVisibilityRequest));
		return result;
	}

	@Override
	public ParserOptions getParserOptions() {
		return DetailLevelParserOptions.OPTION_DETAILS_SUPPRESSED;
	}

	@Override
	public String getLabel() {
		return CustomMessages.DetailsSuppressedLevel_details_suppressed_label;
	}

	@Override
	public String getId() {
		return ID;
	}

	public static final String ID = "org.eclipse.uml2.diagram.clazz.detail_level_suppressed"; //$NON-NLS-1$

}
