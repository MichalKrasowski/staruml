package org.star.uml.designer.ui.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.star.uml.designer.ui.views.StarPMSModelView;

public class ClassDiagramCreateAction  implements IViewActionDelegate{
	public final String Action_ID = "ClassDiagramCreateAction";
	public final String Action_URI = "org.star.uml.designer.ui.action.ClassDiagramCreateAction";
	public final String Action_Title ="ClassDiagram CreateAction";
	private StarPMSModelView view;
    private IStructuredSelection sel;
	@Override
	public void init(IViewPart view) {
		this.view = (StarPMSModelView)view;
		
	}

	@Override
	public void run(IAction action) {
		System.out.println("ClassDiagram CreateAction ~~!!!");
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		sel = (IStructuredSelection)selection;
		
	}
}