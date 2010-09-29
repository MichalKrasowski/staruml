package org.eclipse.uml2.diagram.clazz.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.uml2.diagram.common.commands.ApplyOrUnapplyStereotypeCommand;
import org.eclipse.uml2.diagram.common.part.CreationToolConstants;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * @generated
 */
public class UMLBaseEditHelper extends AbstractEditHelper {

	/**
	 * @generated
	 */
	public static final String EDIT_POLICY_COMMAND = "edit policy command"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ELEMENT_TYPE = "context element type"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	protected IEditHelperAdvice[] getEditHelperAdvice(IEditCommandRequest req) {
		if (req.getParameter(CONTEXT_ELEMENT_TYPE) instanceof IElementType) {
			return ElementTypeRegistry.getInstance().getEditHelperAdvice((IElementType) req.getParameter(CONTEXT_ELEMENT_TYPE));
		}
		return super.getEditHelperAdvice(req);
	}

	/**
	 * @generated
	 */
	protected ICommand getInsteadCommand(IEditCommandRequest req) {
		ICommand epCommand = (ICommand) req.getParameter(EDIT_POLICY_COMMAND);
		req.setParameter(EDIT_POLICY_COMMAND, null);
		ICommand ehCommand = super.getInsteadCommand(req);
		if (epCommand == null) {
			return ehCommand;
		}
		if (ehCommand == null) {
			return epCommand;
		}
		CompositeCommand command = new CompositeCommand(null);
		command.add(epCommand);
		command.add(ehCommand);
		return command;
	}

	/**
	 * @generated
	 */
	protected ICommand getCreateCommand(CreateElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	final protected ICommand getConfigureCommand(ConfigureRequest req) {
		ICommand configureStereotype = getConfigureStereotypeCommand(req);
		ICommand afterConfugure = getAfterConfigureCommand(req);
		if (configureStereotype != null && afterConfugure != null) {
			CompositeCommand result = new CompositeCommand("");
			result.add(configureStereotype);
			result.add(afterConfugure);
			return result;
		}
		if (configureStereotype != null) {
			return configureStereotype;
		}
		if (afterConfugure != null) {
			return afterConfugure;
		}
		return super.getConfigureCommand(req);
	}

	/**
	 * @generated
	 */
	protected ICommand getConfigureStereotypeCommand(ConfigureRequest req) {
		if (req.getElementToConfigure() instanceof Element && req.getParameter(CreationToolConstants.PARAMETER_CONFUGURE_STEREOTYPE) instanceof Stereotype) {
			Element element = (Element) req.getElementToConfigure();
			Stereotype stereo = (Stereotype) req.getParameter(CreationToolConstants.PARAMETER_CONFUGURE_STEREOTYPE);
			ApplyOrUnapplyStereotypeCommand.ApplyOrUnapplyStereotypeRequest request = new ApplyOrUnapplyStereotypeCommand.ApplyOrUnapplyStereotypeRequest(element, stereo, true);
			return new ApplyOrUnapplyStereotypeCommand(request);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected ICommand getAfterConfigureCommand(ConfigureRequest req) {
		return null;
	}

}
