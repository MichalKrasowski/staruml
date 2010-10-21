package org.star.uml.designer.ui.views.policy;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.star.uml.designer.base.constance.GlobalConstants;

public class StarPMSModelViewPopupPolicy {
	
	public static void applyPolicy(int policy,HashMap actionMap){
		switch(policy){
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_1:
				setPolicy_1(actionMap);
			break;
			default:
		}
	}
	
	static void setPolicy_1(HashMap actionMap){
		Iterator ie = actionMap.keySet().iterator();
		while(ie.hasNext()){
			String key = ie.next().toString();
			Action action = (Action)actionMap.get(key);
			action.setEnabled(false);
		}
	}
}
