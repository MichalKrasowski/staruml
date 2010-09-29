package org.eclipse.uml2.diagram.sequence.edit.commands;

import java.text.MessageFormat;
import java.util.ListIterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateLinkCommand;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateParameters;
import org.eclipse.uml2.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.sequence.model.SDModelAccess;
import org.eclipse.uml2.diagram.sequence.model.builder.SDBuilder;
import org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDTrace;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.providers.ElementInitializers;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class MessageCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	private final Interaction container;

	/**
	 * @generated 
	 */
	public MessageCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		container = deduceContainer(source, target);
	}

	/**
	 * @generated NOT
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && !isValidEnd(source)) {
			return false;
		}
		if (target != null && !isValidEnd(target)) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (null == getContainer()) {
			return false;
		}

		if (source == target) {
			return false; //self links don't supported for now
		}

		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateMessage_4001(getContainer(), getSource(), getTarget());
	}

	private BehaviorExecutionSpecification createBehaviorExecutionSpecification(Interaction interaction, Lifeline lifeline, int nameIndex, boolean forSource) {
		String prefix = forSource ? "invocation-" : "execution-";
		String withIndex = prefix + nameIndex + "-";

		ThePastImpl thePast = new ThePastImpl(U2TCreateLinkCommand.getFromRequest(getRequest()));
		ListIterator<InteractionFragment> listPosition = thePast.getAfterThePastPosition(interaction);

		MessageOccurrenceSpecification start = doCreateMessageOccurrence(listPosition, withIndex + "start");
		BehaviorExecutionSpecification result = doCreateBehaviorExecution(listPosition, withIndex + "body");
		MessageOccurrenceSpecification finish = doCreateMessageOccurrence(listPosition, withIndex + "finish");

		setupBehaviorSpec(result, start, finish, lifeline);

		return result;
	}

	private BehaviorExecutionSpecification[] createBehaviorExecutionSpecificationsPair(Interaction interaction, Lifeline sourceLL, Lifeline targetLL, int messageIndex,
			ListIterator<InteractionFragment> listPosition) {
		String invocationPrefix = "invocation-" + messageIndex + "-";
		String executionPrefix = "execution-" + messageIndex + "-";

		MessageOccurrenceSpecification invocationStart = doCreateMessageOccurrence(listPosition, invocationPrefix + "start");
		MessageOccurrenceSpecification executionStart = doCreateMessageOccurrence(listPosition, executionPrefix + "start");

		BehaviorExecutionSpecification invocation = doCreateBehaviorExecution(listPosition, invocationPrefix + "body");
		BehaviorExecutionSpecification execution = doCreateBehaviorExecution(listPosition, executionPrefix + "body");

		MessageOccurrenceSpecification executionFinish = doCreateMessageOccurrence(listPosition, executionPrefix + "finish");
		MessageOccurrenceSpecification invocationFinish = doCreateMessageOccurrence(listPosition, invocationPrefix + "finish");

		setupBehaviorSpec(invocation, invocationStart, invocationFinish, sourceLL);
		setupBehaviorSpec(execution, executionStart, executionFinish, targetLL);

		return new BehaviorExecutionSpecification[] { invocation, execution };
	}

	private void setupBehaviorSpec(BehaviorExecutionSpecification spec, MessageOccurrenceSpecification start, MessageOccurrenceSpecification finish, Lifeline lifeline) {
		setSingleCovered(spec, lifeline);
		setSingleCovered(start, lifeline);
		setSingleCovered(finish, lifeline);

		spec.setStart(start);
		spec.setFinish(finish);
	}

	private void setSingleCovered(InteractionFragment fragment, Lifeline lifeline) {
		if (!fragment.getCovereds().contains(lifeline)) {
			fragment.getCovereds().add(lifeline);
		}
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		Interaction interaction = getContainer();
		int count = interaction.getMessages().size() + 1;

		Element diagramSource = getSource();
		Element diagramTarget = getTarget();
		MessageEnd domainSource;
		MessageEnd domainTarget;

		BehaviorExecutionSpecification sourceInvocation = null;
		BehaviorExecutionSpecification targetExecution = null;

		if (diagramSource instanceof Gate && diagramTarget instanceof Lifeline) {
			domainSource = (Gate) diagramSource;
			targetExecution = createBehaviorExecutionSpecification(interaction, (Lifeline) diagramTarget, count, false);
			domainTarget = (MessageOccurrenceSpecification) targetExecution.getStart();
		} else if (diagramTarget instanceof Gate && diagramSource instanceof Lifeline) {
			domainTarget = (Gate) diagramTarget;
			sourceInvocation = createBehaviorExecutionSpecification(interaction, (Lifeline) diagramSource, count, true);
			domainSource = (MessageOccurrenceSpecification) sourceInvocation.getStart();
		} else if (diagramTarget instanceof Lifeline && diagramSource instanceof Lifeline) {
			Lifeline sourceLL = (Lifeline) diagramSource;
			Lifeline targetLL = (Lifeline) diagramTarget;

			ThePastImpl thePast = createThePast();
			ListIterator<InteractionFragment> position = thePast.getAfterThePastPosition(interaction);

			BehaviorExecutionSpecification[] pair = createBehaviorExecutionSpecificationsPair(interaction, sourceLL, targetLL, count, position);
			sourceInvocation = pair[0];
			targetExecution = pair[1];

			domainSource = (MessageOccurrenceSpecification) sourceInvocation.getStart();
			domainTarget = (MessageOccurrenceSpecification) targetExecution.getStart();
		} else if (diagramSource instanceof BehaviorExecutionSpecification && diagramTarget instanceof Lifeline) {
			BehaviorExecutionSpecification parentExecution = (BehaviorExecutionSpecification) diagramSource;
			Lifeline sourceLL = parentExecution.getCovereds().get(0);
			Lifeline targetLL = (Lifeline) diagramTarget;

			SDBuilder sdBuilder = new SDBuilder(sourceLL.getInteraction());
			SDBehaviorSpec sdExecution = sdBuilder.getSDModel().getUMLTracing().findBehaviorSpec(parentExecution);
			if (false == sdExecution instanceof SDExecution) {
				//XXX : canExecute!
				throw new IllegalArgumentException("SDExecution expected: " + sdExecution);
			}

			ThePastImpl thePast = createThePast();
			thePast.executionStarted((SDExecution) sdExecution);

			ListIterator<InteractionFragment> position = thePast.getAfterThePastPosition(interaction);
			BehaviorExecutionSpecification[] pair = createBehaviorExecutionSpecificationsPair(interaction, sourceLL, targetLL, count, position);

			sourceInvocation = pair[0];
			targetExecution = pair[1];
			domainSource = (MessageOccurrenceSpecification) sourceInvocation.getStart();
			domainTarget = (MessageOccurrenceSpecification) targetExecution.getStart();
		} else if (diagramSource instanceof BehaviorExecutionSpecification && diagramTarget instanceof BehaviorExecutionSpecification) {
			BehaviorExecutionSpecification parentExecution = (BehaviorExecutionSpecification) diagramSource;
			BehaviorExecutionSpecification diagramTargetImpl = (BehaviorExecutionSpecification) diagramTarget;
			Lifeline sourceLL = parentExecution.getCovereds().get(0);
			Lifeline targetLL = diagramTargetImpl.getCovereds().get(0);

			SDTrace sdTracing = new SDBuilder(sourceLL.getInteraction()).getSDModel().getUMLTracing();
			SDBehaviorSpec sdSourceExecution = sdTracing.findBehaviorSpec(parentExecution);
			if (false == sdSourceExecution instanceof SDExecution) {
				//XXX
				throw new IllegalArgumentException("SDExecution expected as source: " + sdSourceExecution);
			}
			SDBehaviorSpec sdTargetInvocation = sdTracing.findBehaviorSpec(diagramTargetImpl);
			if (false == sdTargetInvocation instanceof SDInvocation) {
				throw new IllegalArgumentException("SDInvocation expected as target: " + sdSourceExecution);
			}

			ThePastImpl thePast = createThePast();
			thePast.executionStarted((SDExecution) sdSourceExecution);

			ListIterator<InteractionFragment> position = thePast.getAfterThePastPosition(interaction);
			BehaviorExecutionSpecification[] pair = createBehaviorExecutionSpecificationsPair(interaction, sourceLL, targetLL, count, position);

			sourceInvocation = pair[0];
			targetExecution = pair[1];
			domainSource = (MessageOccurrenceSpecification) sourceInvocation.getStart();
			domainTarget = (MessageOccurrenceSpecification) targetExecution.getStart();
		} else {
			throw new UnsupportedOperationException("Message between this elements can't be created: from: " + getSource() + " to: " + getTarget());
		}

		Message newElement = null;
		if (domainSource != null && domainTarget != null) {
			newElement = interaction.createMessage("");
			interaction.getMessages().add(newElement);
			newElement.setSendEvent(domainSource);
			newElement.setReceiveEvent(domainTarget);

			domainSource.setMessage(newElement);
			domainTarget.setMessage(newElement);
		}

		ElementInitializers.init_Message_4001(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		createAdditionalViews(sourceInvocation, targetExecution, newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

	private View createBehaviorExecutionView(View sourceView, EObject behaviorExecution, int position, Point relativeLocation) {
		int visualID = UMLVisualIDRegistry.getNodeVisualID(sourceView, behaviorExecution);
		Node result = ViewService.getInstance().createNode(//
				new EObjectAdapter(behaviorExecution), sourceView, UMLVisualIDRegistry.getType(visualID), position, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		if (relativeLocation != null) {
			if (result.getLayoutConstraint() == null) {
				result.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
			}
			ViewUtil.setStructuralFeatureValue(result, NotationPackage.eINSTANCE.getLocation_Y(), Integer.valueOf(relativeLocation.y));
			ViewUtil.setStructuralFeatureValue(result, NotationPackage.eINSTANCE.getLocation_X(), Integer.valueOf(10));
		}

		return result;
	}

	private View createBehaviorExecutionView(U2TCreateParameters createParams, EObject behaviorExecution, int position) {
		return createBehaviorExecutionView(createParams.getParentView(), behaviorExecution, position, createParams.getRelativeLocation());
	}

	private void createAdditionalViews(BehaviorExecutionSpecification sourceInvocation, BehaviorExecutionSpecification targetExecution, Message message) {
		if (message == null) {
			return;
		}
		U2TCreateLinkCommand linkCreationPack = U2TCreateLinkCommand.getFromRequest(getRequest());
		if (linkCreationPack == null || linkCreationPack.getSourceParameters() == null || linkCreationPack.getTargetParameters() == null) {
			return;
		}

		SDModelStorageStyle sdModelAccessor = SDModelAccess.findSDModelAccessor(linkCreationPack.getSourceParameters().getParentView());
		if (sdModelAccessor != null) {
			sdModelAccessor.invalidateModel();
		}

		assert sourceInvocation == null || message.getSendEvent() == sourceInvocation.getStart();
		assert targetExecution == null || message.getReceiveEvent() == targetExecution.getStart();

		View invocationView = null;
		if (sourceInvocation != null) {
			if (message.getSendEvent() != sourceInvocation.getStart()) {
				throw new IllegalStateException(MessageFormat.format(//
						"Invocation: {0}, \n start: {1}, message: {2}, sendEvent {3}", //
						new Object[] { sourceInvocation, sourceInvocation.getStart(), message, message.getSendEvent() }));
			}
			U2TCreateParameters sourceParams = linkCreationPack.getSourceParameters();
			int sourceViewIndex = findAnchoredViewPosition(sourceParams);
			invocationView = createBehaviorExecutionView(sourceParams, sourceInvocation, sourceViewIndex);

			linkCreationPack.getSetConnectionEndsCommand().setNewSourceAdaptor(new EObjectAdapter(invocationView));
		}

		if (targetExecution != null) {
			if (message.getReceiveEvent() != targetExecution.getStart()) {
				throw new IllegalStateException(MessageFormat.format(//
						"Execution: {0}, \n start: {1}, message: {2}, receiveEvent {3}", //
						new Object[] { targetExecution, targetExecution.getStart(), message, message.getReceiveEvent() }));

			}

			U2TCreateParameters targetParams = linkCreationPack.getTargetParameters();
			final View executionView;
			if (sourceInvocation.getCovereds().get(0) == targetExecution.getCovereds().get(0)) {
				//for self message the target should be create inside the just created source, and ViewUtil.APPEND is good enough position
				executionView = createBehaviorExecutionView(invocationView, targetExecution, ViewUtil.APPEND, new Point(10, 10));
			} else {
				int targetViewIndex = findAnchoredViewPosition(targetParams);
				executionView = createBehaviorExecutionView(targetParams, targetExecution, targetViewIndex);
			}
			linkCreationPack.getSetConnectionEndsCommand().setNewTargetAdaptor(new EObjectAdapter(executionView));
		}
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Message newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected Element getSource() {
		return (Element) source;
	}

	/**
	 * @generated
	 */
	protected Element getTarget() {
		return (Element) target;
	}

	/**
	 * @generated
	 */
	public Interaction getContainer() {
		return container;
	}

	/**
	 * Default approach is to traverse ancestors of the source to find instance of container.
	 * Modify with appropriate logic.
	 * @generated
	 */
	private static Interaction deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element.eContainer()) {
			if (element instanceof Interaction) {
				return (Interaction) element;
			}
		}
		return null;
	}

	private boolean isValidEnd(EObject diagramEnd) {
		if (diagramEnd instanceof Gate) {
			return true;
		}
		if (diagramEnd instanceof Lifeline) {
			return true;
		}
		if (diagramEnd instanceof BehaviorExecutionSpecification) {
			return ((BehaviorExecutionSpecification) diagramEnd).getCovereds().size() == 1;
		}
		return false;
	}

	private static MessageOccurrenceSpecification doCreateMessageOccurrence(ListIterator<InteractionFragment> position, String name) {
		MessageOccurrenceSpecification result = UMLFactory.eINSTANCE.createMessageOccurrenceSpecification();
		if (name != null) {
			result.setName(name);
		}
		position.add(result);
		return result;
	}

	private static BehaviorExecutionSpecification doCreateBehaviorExecution(ListIterator<InteractionFragment> position, String name) {
		BehaviorExecutionSpecification result = UMLFactory.eINSTANCE.createBehaviorExecutionSpecification();
		if (name != null) {
			result.setName(name);
		}
		position.add(result);
		return result;
	}

	private int findAnchoredViewPosition(U2TCreateParameters sourceParams) {
		int viewPosition = ViewUtil.APPEND;
		if (sourceParams.getAnchorSibling() != null) {
			View anchor = sourceParams.getAnchorSibling();
			int anchorPos = sourceParams.getParentView().getChildren().indexOf(anchor);
			if (anchorPos > 0) {
				viewPosition = anchorPos;
				if (!sourceParams.isBeforeNotAfterAnchor()) {
					viewPosition++;
				}
			}
		}
		return viewPosition;
	}

	private ThePastImpl createThePast() {
		return new ThePastImpl(U2TCreateLinkCommand.getFromRequest(getRequest()));
	}

}
