package org.star.uml.designer.base.constance;

import org.eclipse.osgi.util.NLS;

public class CustomMessages {
	static {
		NLS.initializeMessages("custom-messages", CustomMessages.class); //$NON-NLS-1$
	}

	private CustomMessages() {
	}

	public static String TEST;
	public static String LOGIN_SQL;
	public static String PROJECT_LIST_SQL;
	public static String PROJECT_UPDATE_SQL;
	public static String DIAGRAM_UPDATE_SQL;
	public static String ANALYSIS_INSERT;
	public static String ANALYSIS_UPDATE_SQL;
}