package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;

public abstract class AbstractPostCreateCommand extends AbstractTransactionalCommand {

	private final CreateRequest myCreateRequest;
	
	private final ViewAndElementAccess myViewAndElementAccess;
	
	private final ViewHelper myViewHelper;

	private final IGraphicalEditPart myHostEditPart;

	public AbstractPostCreateCommand(TransactionalEditingDomain domain, CreateViewAndElementRequest cvaeReq, IGraphicalEditPart hostEditPart, IVisualIDRegistry visualIDRegistry) {
		super(domain, null, getWorkspaceFiles(hostEditPart.getNotationView()));
		myCreateRequest = cvaeReq;
		myViewAndElementAccess = new CVAEAccess(cvaeReq);
		myHostEditPart = hostEditPart;
		myViewHelper = new ViewHelper(visualIDRegistry);
	}
	
	protected PreferencesHint getPreferencesHint(){
		return getHostEditPart().getDiagramPreferencesHint();
	}

	protected IGraphicalEditPart getHostEditPart() {
		return myHostEditPart;
	}
	
	protected Point getRequestLocation(){
		return myCreateRequest.getLocation();
	}
	
	protected CreateRequest getCreateRequest() {
		return myCreateRequest;
	}
	
	protected Dimension getRequestSize(){
		return myCreateRequest.getSize();
	}

	protected View getCreatedView() {
		return myViewAndElementAccess.getCreatedView();
	}

	protected EObject getCreatedEntity() {
		return myViewAndElementAccess.getCreatedEntity();
	}
	
	protected ViewAndElementAccess getViewAndElementAccess(){
		return myViewAndElementAccess;
	}

	protected View findChildByType(View view, int visualId) {
		return myViewHelper.findChildByType(view, visualId);
	}
	
	protected Edge findOutgoingEdge(Node source, int visualId, EObject semantic){
		return myViewHelper.findOutgoingEdge(source, visualId, semantic);
	}
	
	protected Edge findIncomingEdge(Node source, int visualId, EObject semantic){
		return myViewHelper.findIncomingEdge(source, visualId, semantic);
	}
	
	protected static void setLocation(View view, Point location) {
		if (view == null || location == null) {
			return;
		}
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X(), new Integer(location.x));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y(), new Integer(location.y));
	}

	protected static void setSize(View view, Dimension size) {
		if (view == null || size == null) {
			return;
		}
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width(), new Integer(size.width));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height(), new Integer(size.height));
	}
	
	public static interface ViewAndElementAccess {
		public View getCreatedView();
		public EObject getCreatedEntity();
	}
	
	private static class CVAEAccess implements ViewAndElementAccess {
		private final CreateViewAndElementRequest myCvaeReq;

		public CVAEAccess(CreateViewAndElementRequest request) {
			myCvaeReq = request;
		}
		
		private CreateElementRequestAdapter getSemanticRequestAdapter() {
			return myCvaeReq.getViewAndElementDescriptor().getCreateElementRequestAdapter();
		}

		public CreateElementRequest getSemanticRequest() {
			return (CreateElementRequest) getSemanticRequestAdapter().getAdapter(CreateElementRequest.class);
		}

		public View getCreatedView() {
			return (View) myCvaeReq.getViewAndElementDescriptor().getAdapter(View.class);
		}

		public EObject getCreatedEntity() {
			return (EObject) getSemanticRequestAdapter().getAdapter(EObject.class);
		}
	}
	
	

}
