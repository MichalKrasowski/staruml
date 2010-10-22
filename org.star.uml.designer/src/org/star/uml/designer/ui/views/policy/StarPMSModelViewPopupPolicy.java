package org.star.uml.designer.ui.views.policy;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.action.PMSLoginAction;
import org.star.uml.designer.ui.action.PMSLogoutAction;

public class StarPMSModelViewPopupPolicy {
	
	public static void applyPolicy(int policy,HashMap actionMap){
		switch(policy){
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_1:
				setPolicy_1(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_2:
				setPolicy_2(actionMap);
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
	static void setPolicy_2(HashMap actionMap){
		Action action = (Action)actionMap.get(PMSLoginAction.ACTION_TITLE);
		action.setEnabled(true);
	}
	static void setPolicy_3(HashMap actionMap){
		Action action = (Action)actionMap.get(PMSLogoutAction.ACTION_TITLE);
		action.setEnabled(true);
	}
}
