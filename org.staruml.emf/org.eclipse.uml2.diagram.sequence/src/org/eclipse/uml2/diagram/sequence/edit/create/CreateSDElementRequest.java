package org.eclipse.uml2.diagram.sequence.edit.create;

import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;

public abstract class CreateSDElementRequest extends CreateRequest {
	private final PreferencesHint myPreferencesHint;

	public CreateSDElementRequest(PreferencesHint preferencesHint){
		myPreferencesHint = preferencesHint;
	}
	
	public PreferencesHint getPreferencesHint() {
		return myPreferencesHint;
	}
    
}
