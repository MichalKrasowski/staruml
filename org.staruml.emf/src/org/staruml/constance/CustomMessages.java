package org.staruml.constance;

import org.eclipse.osgi.util.NLS;

public class CustomMessages {
	static {
		NLS.initializeMessages("custom-messages", CustomMessages.class); //$NON-NLS-1$
	}

	private CustomMessages() {
	}

	public static String TEST;
}
