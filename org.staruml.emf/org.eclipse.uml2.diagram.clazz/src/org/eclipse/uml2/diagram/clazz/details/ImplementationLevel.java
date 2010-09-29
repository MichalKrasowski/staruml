package org.eclipse.uml2.diagram.clazz.details;

import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.common.details.DetailLevelParserOptions;

class ImplementationLevel extends UMLDetailLevel {
	
	@Override
	public void init(View view) {
		// do nothing
	}

	@Override
	public ParserOptions getParserOptions() {
		return DetailLevelParserOptions.OPTION_IMPLEMENTATION;
	}

	@Override
	public String getLabel() {
		return CustomMessages.ImplementationLevel_implementation_label;
	}

	@Override
	public String getId() {
		return ID;
	}

	public static final String ID = "org.eclipse.uml2.diagram.clazz.detail_level_implementation"; //$NON-NLS-1$

}
