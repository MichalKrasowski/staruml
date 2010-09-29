package org.eclipse.uml2.diagram.clazz.details;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Filtering;
import org.eclipse.gmf.runtime.notation.FilteringStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.common.details.DetailLevelParserOptions;

class AnalysisLevel extends UMLDetailLevel {

	@Override
	public void init(View view) {
		List<String> filteringKeys = new ArrayList<String>(1);
		filteringKeys.add(UMLDetailLevelService.FILTER_BY_VISIBILITY);
		ViewUtil.setPropertyValue(view, NotationPackage.eINSTANCE.getFilteringStyle_Filtering(), NotationPackage.eINSTANCE.getFilteringStyle(), Filtering.AUTOMATIC_LITERAL);
		ViewUtil.setPropertyValue(view, NotationPackage.eINSTANCE.getFilteringStyle_FilteringKeys(), NotationPackage.eINSTANCE.getFilteringStyle(), filteringKeys);
	}

	@Override
	public List<EditElementCommand> getApplyCommands(TransactionalEditingDomain editingDomain, View view) {
		FilteringStyle style = (FilteringStyle) view.getStyle(NotationPackage.eINSTANCE.getFilteringStyle());
		List<EditElementCommand> result = new ArrayList<EditElementCommand>(2);
		
		SetRequest setFilteringRequest = new SetRequest(editingDomain, style, NotationPackage.eINSTANCE.getFilteringStyle_Filtering(), Filtering.AUTOMATIC_LITERAL);
		result.add(new SetValueCommand(setFilteringRequest));

		List<String> filteringKeys = new ArrayList<String>(1);
		filteringKeys.add(UMLDetailLevelService.FILTER_BY_VISIBILITY);
		SetRequest setKeysRequest = new SetRequest(editingDomain, style, NotationPackage.eINSTANCE.getFilteringStyle_FilteringKeys(), filteringKeys);
		result.add(new SetValueCommand(setKeysRequest));
		return result;
	}

	@Override
	public List<EditElementCommand> getUnapplyCommands(TransactionalEditingDomain editingDomain, View view) {
		FilteringStyle style = (FilteringStyle) view.getStyle(NotationPackage.eINSTANCE.getFilteringStyle());
		List<EditElementCommand> result = new ArrayList<EditElementCommand>(1);

		SetRequest setFilteringRequest = new SetRequest(editingDomain, style, NotationPackage.eINSTANCE.getFilteringStyle_Filtering(), Filtering.NONE_LITERAL);
		result.add(new SetValueCommand(setFilteringRequest));

		return result;
	}

	@Override
	public ParserOptions getParserOptions() {
		return DetailLevelParserOptions.OPTION_ANALYSIS;
	}

	@Override
	public String getLabel() {
		return CustomMessages.AnalysisLevel_analysis_label;
	}
	
	@Override
	public String getId() {
		return ID;
	}

	public static final String ID = "org.eclipse.uml2.diagram.clazz.detail_level_analysis"; //$NON-NLS-1$

}
