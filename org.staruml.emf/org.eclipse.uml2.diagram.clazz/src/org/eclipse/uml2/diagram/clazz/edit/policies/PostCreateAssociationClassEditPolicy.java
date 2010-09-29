package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.editpolicies.AbstractPostCreateCommand;
import org.eclipse.uml2.diagram.common.editpolicies.EObjectAndElementTypeAdapter;
import org.eclipse.uml2.uml.AssociationClass;


public class PostCreateAssociationClassEditPolicy extends AbstractEditPolicy {
	public static final String KEY = PostCreateAssociationClassEditPolicy.class.getName() + ":key";
	
	@Override
	public Command getCommand(Request request) {
		if (understandsRequest(request)){
			return getPostCreateCommand((CreateViewAndElementRequest)request);
		}
		return null;
	}
	
	@Override
	public boolean understandsRequest(Request req) {
		if (false == req instanceof CreateViewAndElementRequest){
			return false;
		}
		CreateViewAndElementRequest cvaeReq = (CreateViewAndElementRequest)req;
		CreateElementRequestAdapter requestAdapter = cvaeReq.getViewAndElementDescriptor().getCreateElementRequestAdapter();
		CreateElementRequest semanticRequest = (CreateElementRequest) requestAdapter.getAdapter(CreateElementRequest.class);
		return (semanticRequest.getElementType() == UMLElementTypes.AssociationClass_2007);
	}
	
	private Command getPostCreateCommand(CreateViewAndElementRequest cvaeReq){
		return new ICommandProxy(new PostCreateAssociationClassCommand(getDomain(), cvaeReq, getHostImpl()));
	}
	
	private IGraphicalEditPart getHostImpl(){
		return (IGraphicalEditPart) getHost();
	}
	
	private TransactionalEditingDomain getDomain(){
		return getHostImpl().getEditingDomain();	
	}
	
	/**
	 * We want to explicitly create and correctly place rhomb and connector ()  
	 * @author local_admin
	 *
	 */
	private static class PostCreateAssociationClassCommand extends AbstractPostCreateCommand {
		private static final int ASSOCIATION_CLASS_DEFAULT_WIDTH = 100;
		private static final int ASSOCIATION_CLASS_DEFAULT_HEIGHT = 90;
		private static final int VERTICAL_GAP = 30;
		
		public PostCreateAssociationClassCommand(TransactionalEditingDomain domain, CreateViewAndElementRequest cvaeReq, IGraphicalEditPart hostEditPart){
			super(domain, cvaeReq, hostEditPart, UMLVisualIDRegistry.TYPED_ADAPTER);
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			View createdView = getCreatedView();
			EObject createdEntity = getCreatedEntity();
			
			if (false == createdEntity instanceof AssociationClass){
				return CommandResult.newErrorCommandResult("Association class expected: " + createdEntity);
			}
			AssociationClass newClass = (AssociationClass) createdEntity;
			EObjectAdapter rhombAdapter = new EObjectAndElementTypeAdapter(newClass, UMLElementTypes.AssociationClass_2015);
			View rhombView = ViewService.getInstance().createNode(rhombAdapter, (View)createdView.eContainer(), UMLElementTypes.AssociationClass_2015.getSemanticHint(), ViewUtil.APPEND, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

			Rectangle expectedRectangleBounds = new Rectangle();
			expectedRectangleBounds.setLocation(getRequestLocation());
			if (getRequestSize() != null){
				expectedRectangleBounds.setSize(getRequestSize());
			} else {
				expectedRectangleBounds.setSize(ASSOCIATION_CLASS_DEFAULT_WIDTH, ASSOCIATION_CLASS_DEFAULT_HEIGHT);
			}
			
			if (expectedRectangleBounds.height < 0 || expectedRectangleBounds.width < 0){
				//get canonical form with positive size
				expectedRectangleBounds = new Rectangle(expectedRectangleBounds.getTopLeft(), expectedRectangleBounds.getBottomRight());	
			}
			
			IFigure layoutContainer = getHostEditPart().getContentPane();
			layoutContainer.translateToRelative(expectedRectangleBounds);
			layoutContainer.translateFromParent(expectedRectangleBounds);
			expectedRectangleBounds.translate(layoutContainer.getClientArea().getLocation().getNegated());
			
			Point rhombTopLeft = expectedRectangleBounds.getTop();
			if (rhombTopLeft.y > VERTICAL_GAP + 5){
				rhombTopLeft.translate(0, -VERTICAL_GAP);
			} else {
				rhombTopLeft = expectedRectangleBounds.getBottom();
				rhombTopLeft.translate(0, VERTICAL_GAP);
			}
			setLocation(rhombView, rhombTopLeft);
			return CommandResult.newOKCommandResult();
		}
	}
	
	
}
