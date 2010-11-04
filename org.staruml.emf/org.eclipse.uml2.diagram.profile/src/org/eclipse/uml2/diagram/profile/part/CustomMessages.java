package org.eclipse.uml2.diagram.profile.part;

import org.eclipse.osgi.util.NLS;

public class CustomMessages extends NLS {

	private static final String BUNDLE_NAME = "custom-messages"; //$NON-NLS-1$

	public static String DefineProfileAction_define_action;

	public static String DefineProfileAction_define_profile_command;

	public static String DefineProfileAction_indefined;

	public static String DefineProfileAction_redefine_action;

	public static String DefineProfileItemProvider_profile_group;

	public static String DefineProfileItemProvider_profile_menu;

	public static String ReferencedMetaclassParser_no_metaclass;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, CustomMessages.class);
	}

	private CustomMessages() {
	}
}
