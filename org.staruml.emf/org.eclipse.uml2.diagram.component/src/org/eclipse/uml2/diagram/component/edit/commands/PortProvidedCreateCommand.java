package org.eclipse.uml2.diagram.component.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.diagram.common.commands.ProvidedPortLinkHelper;
import org.eclipse.uml2.diagram.component.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;

/**
 * @generated
 */
public class PortProvidedCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @NOT-generated
	 */
	private final ProvidedPortLinkHelper myCreateLinkHelper;

	/**
	 * @generated NOT
	 */
	public PortProvidedCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		myCreateLinkHelper = new ProvidedPortLinkHelper((AdapterFactoryEditingDomain) getEditingDomain(), source, target);
	}

	/**
	 * @generated
	 */
	public boolean canExecuteGen() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof Port) {
			return false;
		}
		if (target != null && false == target instanceof Interface) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreatePortProvided_4006(getSource(), getTarget());
	}

	/**
	 * @generated NOT
	 */
	public boolean canExecute() {
		return canExecuteGen() && myCreateLinkHelper.canCreate();
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		myCreateLinkHelper.create();
		return CommandResult.newOKCommandResult();
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
	protected Port getSource() {
		return (Port) source;
	}

	/**
	 * @generated
	 */
	protected Interface getTarget() {
		return (Interface) target;
	}
}
