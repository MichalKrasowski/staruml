package org.star.uml.designer.ui.views.policy;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.action.PMSLoginAction;
import org.star.uml.designer.ui.action.PMSLogoutAction;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.DeleteDiagramAction;
import org.star.uml.designer.ui.diagram.action.DeleteFromDiagramAction;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;

public class StarPMSModelViewPopupPolicy {
	
	public static void applyPolicy(int policy,HashMap actionMap){
		switch(policy){
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_1:
				setPolicy_1(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_2:
				setPolicy_2(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_3:
				setPolicy_3(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_4:
				setPolicy_4(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_5:
				setPolicy_5(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_6:
				setPolicy_6(actionMap);
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
	
	static void setPolicy_4(HashMap actionMap){
		Action action = (Action)actionMap.get(ActorCreateAction.ACTION_TITLE);
		action.setEnabled(true);
		Action action2 = (Action)actionMap.get(UsecaseDiagramCreateAction.ACTION_TITLE);
		action2.setEnabled(true);
	}
	
	static void setPolicy_5(HashMap actionMap){
		Action action2 = (Action)actionMap.get(DeleteFromDiagramAction.ACTION_TITLE);
		action2.setEnabled(true);
	}
	
	static void setPolicy_6(HashMap actionMap){
		Action action2 = (Action)actionMap.get(DeleteDiagramAction.ACTION_TITLE);
		action2.setEnabled(true);
	}
}
