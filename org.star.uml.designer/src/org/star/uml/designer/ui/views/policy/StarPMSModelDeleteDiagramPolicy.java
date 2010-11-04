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
import org.star.uml.designer.ui.diagram.action.ClazzDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.DeleteDiagramAction;
import org.star.uml.designer.ui.diagram.action.DeleteFromModelAction;
import org.star.uml.designer.ui.diagram.action.PackageModelCreateAction;
import org.star.uml.designer.ui.diagram.action.PackageModelInsertAction;
import org.star.uml.designer.ui.diagram.action.SequenceDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseModelCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;

public class StarPMSModelDeleteDiagramPolicy {
	
	public static void applyPolicy(int policy,HashMap actionMap){
		switch(policy){
			case GlobalConstants.StarPMSModelDeleteDiagramPolicy.POLICY_1:
				setPolicy_1(actionMap);
			break;
			default:
		}
	}
	/**
	 * 모든 액션을 Disabled 한다.
	 * @param actionMap
	 */
	static void setPolicy_1(HashMap actionMap){
		Action action = (Action)actionMap.get(DeleteDiagramAction.ACTION_TITLE);
		action.setEnabled(true);
	}
}
