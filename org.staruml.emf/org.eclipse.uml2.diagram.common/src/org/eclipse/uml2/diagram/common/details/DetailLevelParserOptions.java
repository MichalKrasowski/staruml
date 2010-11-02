package org.eclipse.uml2.diagram.common.details;

import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;

public interface DetailLevelParserOptions {
	int LEVEL_IMPLEMENTATION = 0;
	int LEVEL_ANALYSIS = 1;
	int LEVEL_DETAILS_SUPPRESSED = 2;

	ParserOptions OPTION_IMPLEMENTATION = new ParserOptions(LEVEL_IMPLEMENTATION);
	ParserOptions OPTION_ANALYSIS = new ParserOptions(LEVEL_ANALYSIS);
	ParserOptions OPTION_DETAILS_SUPPRESSED = new ParserOptions(LEVEL_DETAILS_SUPPRESSED);

}
