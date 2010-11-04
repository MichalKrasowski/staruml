package org.star.uml.designer.ui.views.policy;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.action.PMSLoginAction;
import org.star.uml.designer.ui.action.PMSLogoutAction;
import org.star.uml.designer.ui.action.RefactorRenameAction;
import org.star.uml.designer.ui.action.ViewReportAction;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.ClassModelCreateAction;
import org.star.uml.designer.ui.diagram.action.ClassModelInsertAction;
import org.star.uml.designer.ui.diagram.action.ClazzDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.DeleteDiagramAction;
import org.star.uml.designer.ui.diagram.action.DeleteFromModelAction;
import org.star.uml.designer.ui.diagram.action.InterfaceModelCreateAction;
import org.star.uml.designer.ui.diagram.action.PackageModelCreateAction;
import org.star.uml.designer.ui.diagram.action.PackageModelInsertAction;
import org.star.uml.designer.ui.diagram.action.SequenceDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseModelCreateAction;
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
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_7:
				setPolicy_7(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_8:
				setPolicy_8(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_9:
				setPolicy_9(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_10:
				setPolicy_10(actionMap);
			break;
			case GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_11:
				setPolicy_11(actionMap);
			break;
			default:
		}
	}
	/**
	 * 모든 액션을 Disabled 한다.
	 * @param actionMap
	 */
	static void setPolicy_1(HashMap actionMap){
		Iterator ie = actionMap.keySet().iterator();
		while(ie.hasNext()){
			String key = ie.next().toString();
			Action action = (Action)actionMap.get(key);
			action.setEnabled(false);
		}
	}
	/**
	 * 로그인 할 수 있다.
	 * @param actionMap
	 */
	static void setPolicy_2(HashMap actionMap){
		Action action = (Action)actionMap.get(PMSLoginAction.ACTION_TITLE);
		action.setEnabled(true);
	}
	/**
	 * 로그아웃 할 수 있다
	 * @param actionMap
	 */
	static void setPolicy_3(HashMap actionMap){
		Action action = (Action)actionMap.get(PMSLogoutAction.ACTION_TITLE);
		action.setEnabled(true);
	}
	/**
	 * 모델을 생성 할 수 있다.
	 * @param actionMap
	 */
	static void setPolicy_4(HashMap actionMap){
		Action action = (Action)actionMap.get(ActorCreateAction.ACTION_TITLE);
		action.setEnabled(true);
		Action action2 = (Action)actionMap.get(UsecaseModelCreateAction.ACTION_TITLE);
		action2.setEnabled(true);
		Action action3 = (Action)actionMap.get(PackageModelCreateAction.ACTION_TITLE);
		action3.setEnabled(true);
//		Action action4 = (Action)actionMap.get(ClassModelCreateAction.ACTION_TITLE);
//		action4.setEnabled(true);
//		Action action5 = (Action)actionMap.get(InterfaceModelCreateAction.ACTION_TITLE);
//		action5.setEnabled(true);
	}
	
	/**
	 * 모델을 삭제할 수 있다. 모델 이름을 변경할 수 있다.
	 * @param actionMap
	 */
	static void setPolicy_5(HashMap actionMap){
//		Action action2 = (Action)actionMap.get(DeleteFromDiagramAction.ACTION_TITLE);
//		action2.setEnabled(true);
		Action action3 = (Action)actionMap.get(DeleteFromModelAction.ACTION_TITLE);
		action3.setEnabled(true);
		Action action4 = (Action)actionMap.get(RefactorRenameAction.ACTION_TITLE);
		action4.setEnabled(true);
	}
	
	/**
	 * 다이어그램을 삭제할 수 있다. 다이어그램 이름을 변경할 수 있다.
	 * @param actionMap
	 */
	static void setPolicy_6(HashMap actionMap){
		Action action4 = (Action)actionMap.get(RefactorRenameAction.ACTION_TITLE);
		action4.setEnabled(true);
	}
	
	/**
	 * UseCase Diagram를 생성할 수 있다.
	 * @param actionMap
	 */
	static void setPolicy_7(HashMap actionMap){
		Action action = (Action)actionMap.get(UsecaseDiagramCreateAction.ACTION_TITLE);
		action.setEnabled(true);
	}
	
	/**
	 * Sequence Diagram를 생성할 수 있다.
	 * @param actionMap
	 */
	static void setPolicy_8(HashMap actionMap){
		Action action = (Action)actionMap.get(SequenceDiagramCreateAction.ACTION_TITLE);
		action.setEnabled(true);
	}
	
	static void setPolicy_9(HashMap actionMap){
		
	}
	
	static void setPolicy_10(HashMap actionMap){
		
	}
	
	/**
	 * Class Diagram를 생성할 수 있다. 유스케이스 레포트를 볼 수 있다.
	 * @param actionMap
	 */
	static void setPolicy_11(HashMap actionMap){
		Action action = (Action)actionMap.get(ClazzDiagramCreateAction.ACTION_TITLE);
		action.setEnabled(true);
		Action action2 = (Action)actionMap.get(ViewReportAction.ACTION_TITLE);
		action2.setEnabled(true);
	}
}
