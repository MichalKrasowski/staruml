package org.eclipse.uml2.diagram.csd.part;

import org.eclipse.osgi.util.NLS;

public class CustomMessages extends NLS {

	private static final String BUNDLE_NAME = "custom-messages"; //$NON-NLS-1$

	public static String CollaborationUseParser_collaboration_use_name_parser_command;

	public static String ConnectorNameParser_connector_name_parser_command;

	public static String ConnectorParser_parsing_is_not_supported_exception;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, CustomMessages.class);
	}

	private CustomMessages() {
	}
}
