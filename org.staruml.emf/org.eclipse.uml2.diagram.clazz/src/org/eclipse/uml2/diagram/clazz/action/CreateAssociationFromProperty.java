package org.eclipse.uml2.diagram.clazz.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.edit.commands.CreateAssociationViewCommand;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property7EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

public class CreateAssociationFromProperty extends DiagramAction {

	private static final String DISABLED_TEXT = CustomMessages.CreateAssociationFromProperty_disabled_text;

	private final Property myOtherEnd;

	public CreateAssociationFromProperty(IWorkbenchPage workbenchPage, Property sourceEnd) {
		super(workbenchPage);
		myOtherEnd = sourceEnd;
	}
	
	@Override
	public void refresh() {
		super.refresh();
		updateText();
	}

	public CreateAssociationFromProperty(IWorkbenchPage workbenchPage) {
		this(workbenchPage, null);
	}

	private void updateText() {
		setText(DISABLED_TEXT);
		if (myOtherEnd != null) {
			String labelFormat = "{0}: {1}"; //$NON-NLS-1$
			setText(NLS.bind(labelFormat, new Object[]{myOtherEnd.getClass_().getName(), myOtherEnd.getName()}));
			return;
		}
		GraphicalEditPart propertyEditPart = getSelectedPropertyEditPart();
		if (propertyEditPart != null) {
			Property property = (Property) propertyEditPart.getNotationView().getElement();
			if (property.getType() != null){
				setText(property.getType().getName());
			}
		}
	}

	@Override
	protected Command getCommand() {
		GraphicalEditPart propertyEditPart = getSelectedPropertyEditPart();
		if (propertyEditPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		
		GraphicalEditPart conjugatedEditPart = null;
		if (myOtherEnd != null) {
			conjugatedEditPart = (GraphicalEditPart) propertyEditPart.findEditPart(propertyEditPart.getRoot().getContents(), myOtherEnd);
		}
		
		TransactionalEditingDomain domain = propertyEditPart.getEditingDomain();
		CompositeTransactionalCommand emfCommand = new CompositeTransactionalCommand(domain, CustomMessages.CreateAssociationFromProperty_create_association_command);
		
		Property property = (Property) propertyEditPart.getNotationView().getElement();
		Type associationSource = property.getClass_();
		Type associationTarget = property.getType();

		CreateRelationshipRequest semanticRequest = new CreateRelationshipRequest(associationSource, associationTarget, UMLElementTypes.Association_4005);
		emfCommand.add(new CreateAssociationCommand(semanticRequest, myOtherEnd, property));
		
		if (myOtherEnd != null && AggregationKind.COMPOSITE_LITERAL == property.getAggregation()){
			SetRequest fixOtherEndAggregation = new SetRequest(propertyEditPart.getEditingDomain(), //
					myOtherEnd, UMLPackage.eINSTANCE.getProperty_Aggregation(), AggregationKind.NONE_LITERAL); 
			emfCommand.add(new SetValueCommand(fixOtherEndAggregation));
		}
		
		emfCommand.add(new DeleteCommand(propertyEditPart.getNotationView()));
		if (conjugatedEditPart != null){
			emfCommand.add(new DeleteCommand(conjugatedEditPart.getNotationView()));
		}
		
		//first semantic changes in single transaction, then notation changes 
		CompoundCommand result = new CompoundCommand();
		result.add(new ICommandProxy(emfCommand));
		if (((GraphicalEditPart)propertyEditPart.getParent()).isCanonical()){
			result.add(new CreateAssociationViewCommand(propertyEditPart, associationSource, associationTarget, semanticRequest, getPreferencesHint()));
		}
		return result;
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// superclass realization is too heavy-weight in the simpliest cases
		GraphicalEditPart propertyEditPart = getSelectedPropertyEditPart();
		if (propertyEditPart == null) {
			return false;
		}
		Property property = (Property) propertyEditPart.getNotationView().getElement();
		Type associationTarget = property.getType();
		if (associationTarget == null) {
			return false;
		}
		return super.isEnabled();
	}

	private static class CreateAssociationCommand extends CreateRelationshipCommand {
		private final Property myTargetEnd;
		private Property mySourceEnd;

		public CreateAssociationCommand(CreateRelationshipRequest request, Property sourceEnd, Property targetEnd) {
			super(request);
			mySourceEnd = sourceEnd;
			myTargetEnd = targetEnd;
		}

		@Override
		protected EObject doDefaultElementCreation() {
			Type sourceType = (Type) getSource();
			
			Package pakkage = sourceType.getNearestPackage();
			Association association = (Association) pakkage.createOwnedType(null, UMLPackage.Literals.ASSOCIATION);
			
			if (mySourceEnd == null){
				mySourceEnd = association.createOwnedEnd(null, sourceType);
			} 
			association.getMemberEnds().add(mySourceEnd);
			association.getMemberEnds().add(myTargetEnd);
			
			return association;
		}
	}

	private GraphicalEditPart getSelectedPropertyEditPart() {
		for (Object next : getSelectedObjects()) {
			if (oursPropertyEditParts.contains(next.getClass())) {
				return (GraphicalEditPart) next;
			}
		}
		return null;
	}

	private static final List<Class<?>> oursPropertyEditParts = new ArrayList<Class<?>>();
	static {
		oursPropertyEditParts.add(PropertyEditPart.class);
		oursPropertyEditParts.add(Property2EditPart.class);
		oursPropertyEditParts.add(Property3EditPart.class);
		oursPropertyEditParts.add(Property4EditPart.class);
		oursPropertyEditParts.add(Property5EditPart.class);
		oursPropertyEditParts.add(Property6EditPart.class);
		oursPropertyEditParts.add(Property7EditPart.class);
	}
}
