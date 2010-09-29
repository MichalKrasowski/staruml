package org.eclipse.uml2.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeListener;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.uml2.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.uml2.diagram.sequence.figures.ExecutionSpecificationShape;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.UMLPackage;


public class BehaviorExecutionColorVisualEffect extends AbstractEditPolicy implements NodeListener, NotificationListener {
	private final Set<Message> myMessagesToListen = new HashSet<Message>();
	
	@Override
	public void activate() {
		super.activate();
		refreshEffect();
		getHostImpl().addNodeListener(this);
		for (Object next : getHostImpl().getTargetConnections()){
			hookConnection((ConnectionEditPart) next);
		}
	}
	
	@Override
	public void deactivate() {
		getHostImpl().removeNodeListener(this);
		ArrayList<Message> messages = new ArrayList<Message>(myMessagesToListen);
		for (Message next : messages){
			getDiagramEventBroker().removeNotificationListener(next, this);
		}
		myMessagesToListen.clear();
		super.deactivate();
	}
	
	public void refreshEffect() {
		refreshEffect(null);
	}
	
	public void refreshEffect(ConnectionEditPart toBeRemoved) {
		refreshColorScheme_(toBeRemoved);
		refreshCross();
	}
	
	private void refreshCross(){
		boolean isDestruction = MissedMethods._executionSpecification().isDestruction(getHostImpl().getNotationView());
		getHostFigure().setCrossVisible(isDestruction);
	}
	
	private void refreshColorScheme_(ConnectionEditPart toBeRemoved) {
		boolean isRoot = hasOutgoingMessages(toBeRemoved) && !hasIncomingMessages(toBeRemoved);
		IFigure figure = getHostImpl().getPrimaryShape();
		if (isRoot){
			figure.setBackgroundColor(ColorConstants.lightGray);
			figure.setForegroundColor(ColorConstants.darkGray);
		} else {
			figure.setBackgroundColor(ColorConstants.white);
			figure.setForegroundColor(ColorConstants.black);
		}
	}

	private BehaviorExecutionSpecificationEditPart getHostImpl(){
		return (BehaviorExecutionSpecificationEditPart)getHost();
	}
	
	private boolean hasIncomingMessages(ConnectionEditPart toBeRemoved){
		BehaviorExecutionSpecificationEditPart host = getHostImpl();
		List<?> targetConnections = host.getTargetConnections();
		return containsMessageEditParts(targetConnections, toBeRemoved);
	}

	private boolean hasOutgoingMessages(ConnectionEditPart toBeRemoved){
		BehaviorExecutionSpecificationEditPart host = getHostImpl();
		List<?> sourceConnections = host.getSourceConnections();
		return containsMessageEditParts(sourceConnections, toBeRemoved);
	}

	private boolean containsMessageEditParts(List<?> connections, ConnectionEditPart toBeRemoved){
		for (Object next : connections){
			if (next == toBeRemoved){
				continue;
			}
			if (next instanceof MessageEditPart){
				MessageEditPart nextMessageEditPart = (MessageEditPart)next;
				Message message = (Message)nextMessageEditPart.resolveSemanticElement();
				if (message != null && message.getMessageSort() != MessageSort.REPLY_LITERAL){
					return true;
				}
			}
		}
		return false;
	}

	public void removingSourceConnection(ConnectionEditPart connection, int index) {
		refreshEffect(connection);
	}

	public void removingTargetConnection(ConnectionEditPart connection, int index) {
		refreshEffect(connection);
		unhookConnection(connection);
	}

	public void sourceConnectionAdded(ConnectionEditPart connection, int index) {
		refreshEffect(null);
	}

	public void targetConnectionAdded(ConnectionEditPart connection, int index) {
		refreshEffect(null);
		hookConnection(connection);
	}
	
	private ExecutionSpecificationShape getHostFigure(){
		return getHostImpl().getPrimaryShape();
	}
	
	private void hookConnection(ConnectionEditPart ep){
		if (ep instanceof MessageEditPart){
			MessageEditPart messageEP = (MessageEditPart)ep;
			Message message = (Message) messageEP.resolveSemanticElement();
			if (!myMessagesToListen.contains(message)){
				getDiagramEventBroker().addNotificationListener(message, UMLPackage.eINSTANCE.getMessage_MessageSort(), this);
				myMessagesToListen.add(message);
			}
		}
	}
	
	private void unhookConnection(ConnectionEditPart ep){
		if (ep instanceof MessageEditPart){
			MessageEditPart messageEP = (MessageEditPart)ep;
			Message message = (Message) messageEP.resolveSemanticElement();
			getDiagramEventBroker().removeNotificationListener(message, this);
			myMessagesToListen.remove(message);
		}
	}
	
	public void notifyChanged(Notification notification) {
		if (notification.getFeature() == UMLPackage.eINSTANCE.getMessage_MessageSort()){
			refreshCross();
		}
	}
	
	private DiagramEventBroker getDiagramEventBroker(){
		return DiagramEventBroker.getInstance(getHostImpl().getEditingDomain());
	}
	
	
	
}
