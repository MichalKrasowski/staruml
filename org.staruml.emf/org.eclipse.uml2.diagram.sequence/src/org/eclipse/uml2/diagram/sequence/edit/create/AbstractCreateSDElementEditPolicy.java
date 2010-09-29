package org.eclipse.uml2.diagram.sequence.edit.create;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.editpolicies.EObjectAndElementTypeAdapter;
import org.eclipse.uml2.diagram.sequence.edit.parts.InnerMountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionNestedLayoutRequest;
import org.eclipse.uml2.diagram.sequence.edit.policies.OrderedLayoutEditPolicy;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionOperand;


public abstract class AbstractCreateSDElementEditPolicy extends AbstractEditPolicy {
	protected final GraphicalEditPart getHostImpl(){
		return (GraphicalEditPart)getHost();
	}
	
	protected Helper getHelper(CreateSDElementRequest request){
		return new Helper(request);
	}
	
	protected final TransactionalEditingDomain getEditingDomain(){
		return getHostImpl().getEditingDomain();
	}
	
	protected PreferencesHint getPreferencesHint(){
		return getHostImpl().getDiagramPreferencesHint();
	}
	
	protected Command getLayoutCommand(InteractionNestedLayoutRequest request){
		InteractionEditPart interactionEditPart = findInteractionEditPart(getHost());
		if (interactionEditPart == null){
			return null;
		}
		return interactionEditPart.getCommand(request);
	}
	
	protected boolean isValid(Command gefCommand){
		return gefCommand != null && gefCommand.canExecute();
	}

	protected final Command postScheduleLayout(Command gefCommand, Command layoutCommand){
		if (layoutCommand == null){
			return gefCommand;
		}
		
		CompoundCommand result = new CompoundCommand(gefCommand.getLabel());
		
		result.add(gefCommand);
		result.add(layoutCommand);
		return result;
	}
	
	protected final CompositeCommand createMountingLinkCommand(IAdaptable source, IAdaptable target, CreateConnectionViewRequest request){
		CompositeCommand cc = new CompositeCommand("");
		
		CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = request.getConnectionViewDescriptor();
		
		CreateCommand createLink = new CreateCommand(getEditingDomain(), descriptor, getHostImpl().getNotationView().getDiagram());
		SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(getEditingDomain(), "");
		sceCommand.setEdgeAdaptor(descriptor);
		sceCommand.setNewSourceAdaptor(source);
		sceCommand.setNewTargetAdaptor(target);
		
		SetConnectionAnchorsCommand scaCommand = new SetConnectionAnchorsCommand(getEditingDomain(), "");
		scaCommand.setEdgeAdaptor(descriptor);
		
		SetConnectionBendpointsCommand scbCommand = new SetConnectionBendpointsCommand(getEditingDomain());
		scbCommand.setEdgeAdapter(descriptor);
		PointList pointList = new PointList(2);
		pointList.addPoint(new Point(10, 10));
		pointList.addPoint(new Point(90, 90));
		scbCommand.setNewPointList(pointList, new Point(0, 0), new Point(100, 100));
		
		cc.compose(createLink);
		cc.compose(sceCommand);
		cc.compose(scaCommand);
		cc.compose(scbCommand);
		
		return cc;
	}
	
	protected CreateConnectionViewRequest createMountingLinkRequest(){
		return CreateViewRequestFactory.getCreateConnectionRequest(UMLElementTypes.Link_4002, getPreferencesHint());
	}
	
	protected InteractionEditPart findInteractionEditPart(EditPart ep){
		RootEditPart root = ep.getRoot();
		while (ep != root && ep != null){
			if (ep instanceof InteractionEditPart){
				return (InteractionEditPart)ep;
			}
			ep = ep.getParent();
		}
		return null;
	}
	
	protected final LifelineEditPart findLifeLineEditPart(EditPart ep){
		RootEditPart root = ep.getRoot();
		while (ep != root && ep != null){
			if (ep instanceof LifelineEditPart){
				return (LifelineEditPart)ep;
			}
			ep = ep.getParent();
		}
		return null;
	}
	
	public static class Helper {
		private final Request myRequest;
		private final PreferencesHint myPreferencesHint;

		public Helper(CreateSDElementRequest createRequest){
			myRequest = createRequest;
			myPreferencesHint = createRequest.getPreferencesHint();
		}
		
		public Helper(ChangeBoundsRequest request, PreferencesHint preferencesHint){
			myRequest = request;
			myPreferencesHint = preferencesHint;
		}
		
		public PreferencesHint getPreferencesHint() {
			return myPreferencesHint;
		}
		
		public CreateViewAndElementRequest createNodeAndElement(IHintedType elementType){
			ViewAndElementDescriptor descriptor = //
				new ViewAndElementDescriptor( //
					new CreateElementRequestAdapter( //
							new CreateElementRequest(elementType)), Node.class, elementType.getSemanticHint(), getPreferencesHint());
			CreateViewAndElementRequest result = new CreateViewAndElementRequest(descriptor);
			result.setExtendedData(myRequest.getExtendedData());
			result.setLocation(getRequestLocation());
			result.setSize(getRequestSize());
			return result;
		}
		
		public CreateViewRequest postCreateViewNode(final IHintedType viewType, final CreateViewAndElementRequest semanticRequest){
			IAdaptable elementAdapter = semanticRequest.getViewAndElementDescriptor().getElementAdapter();
			return postCreateViewNode(viewType, elementAdapter);
		}
		
		public CreateViewRequest postCreateViewNode(final IHintedType viewType, IAdaptable elementAdapter){
			if (elementAdapter.getAdapter(IElementType.class) != viewType){
				elementAdapter = new SameElementDifferentTypeAdapter(elementAdapter, viewType);
			}
			int position = ViewUtil.APPEND; //XXX
			ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(//
					elementAdapter, Node.class, viewType.getSemanticHint(), position, getPreferencesHint());
			CreateViewRequest result = new CreateViewRequest(descriptor);
			result.setExtendedData(myRequest.getExtendedData());
			result.setLocation(getRequestLocation());
			result.setSize(getRequestSize());
			return result;
		}
		
		private Point getRequestLocation(){
			if (myRequest instanceof CreateRequest){
				return ((CreateRequest)myRequest).getLocation();
			}
			if (myRequest instanceof ChangeBoundsRequest){
				return ((ChangeBoundsRequest)myRequest).getLocation();
			}
			throw new IllegalStateException();
		}
		
		private Dimension getRequestSize(){
			if (myRequest instanceof CreateRequest){
				return ((CreateRequest)myRequest).getSize();
			}
			if (myRequest instanceof ChangeBoundsRequest){
				return null;
			}
			throw new IllegalStateException();
		}
		
	}
	
	private static class SameElementDifferentTypeAdapter implements IAdaptable {
		private final IAdaptable mySemanticAdapter;
		private final IElementType myDesiredType;

		public SameElementDifferentTypeAdapter(IAdaptable semanticAdapter, IElementType desiredType){
			mySemanticAdapter = semanticAdapter;
			myDesiredType = desiredType;
		}
		
		@SuppressWarnings("unchecked")
		public Object getAdapter(Class adapter) {
			if (IElementType.class.isAssignableFrom(adapter)){
				return myDesiredType;
			}
			return mySemanticAdapter.getAdapter(adapter);
		}
	}
	
	public static class Helper2 {
		private final PreferencesHint myPreferencesHint;

		public Helper2(PreferencesHint hint){
			myPreferencesHint = hint;
		}
		
		public Node createNode(View container, Element semanticChild, int visualId, OrderedLayoutEditPolicy.AnchoredSibling anchor){
			int index = ViewUtil.APPEND;
			if (anchor != null){
				int anchorIndex = container.getChildren().indexOf(anchor.getSiblingView());
				if (anchorIndex > -1){
					index = anchorIndex;
					if (!anchor.isBeforeNotAfterAnchor()){
						index += 1;
					}
				}
			}
			IElementType elementType = UMLElementTypes.getElementType(visualId);
			return ViewService.getInstance().createNode(//
					new EObjectAndElementTypeAdapter(semanticChild, elementType), 
					container, //
					UMLVisualIDRegistry.getType(visualId), //
					index, //
					myPreferencesHint);
		}	
		
		public Edge createMountingLink(View fromMountingRegion, View toFrame){
			boolean innerNotTopLevel = toFrame.getElement() instanceof InteractionOperand;
			
			IElementType linkType = innerNotTopLevel ? UMLElementTypes.Link_4003 : UMLElementTypes.Link_4002;
			int visualId = innerNotTopLevel ? InnerMountingLinkEditPart.VISUAL_ID : MountingLinkEditPart.VISUAL_ID;
			
			Edge result = ViewService.getInstance().createEdge(//
					linkType, 
					fromMountingRegion.getDiagram(), 
					UMLVisualIDRegistry.getType(visualId),
					ViewUtil.APPEND, 
					true, 
					myPreferencesHint);
			
			result.setSource(fromMountingRegion);
			result.setTarget(toFrame);
			if (result.getSourceAnchor() == null){
				IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
				anchor.setId("");
				result.setSourceAnchor(anchor);
			}
			if (result.getTargetAnchor() == null){
				IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
				anchor.setId("");
				result.setTargetAnchor(anchor);
			}
			if (result.getBendpoints() == null){
				RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
				result.setBendpoints(bendpoints);
			}
			
			return result;
		}	
	}
	
	protected static class GEFAwareCompositeCommand extends CompositeTransactionalCommand {
		public GEFAwareCompositeCommand(TransactionalEditingDomain domain, String label){
			super(domain, label);
		}
		
		public void add(Command gefCommand){
			if (gefCommand instanceof ICommandProxy){
				ICommand iCommand = ((ICommandProxy)gefCommand).getICommand();
				add(iCommand);
				return;
			}
			if (gefCommand instanceof CompoundCommand){
				CompoundCommand gefCompound = (CompoundCommand)gefCommand;
				for (Object next : gefCompound.getCommands()){
					Command nextSubCommand = (Command)next;
					add(nextSubCommand);
				}
				return;
			}
			throw new IllegalArgumentException("Can't unwrap: " + gefCommand);
		}
	}
}
