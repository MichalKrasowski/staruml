package org.eclipse.uml2.diagram.csd.parser.connector;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.csd.part.CustomMessages;
import org.eclipse.uml2.diagram.parser.assist.FixedSetCompletionProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.icu.text.MessageFormat;


public class ConnectorNameParser implements ISemanticParser {
	private static final MessageFormat CONNECTOR_NAME_FORMAT = new MessageFormat("{0}:{1}");  //$NON-NLS-1$

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			return UMLPackage.eINSTANCE.getConnector_Type().equals(feature) || UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature);
		}
		return false;
	}

	public List<?> getSemanticElementsBeingParsed(EObject eObject) {
		return Collections.singletonList(eObject);
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable subject) {
		Connector c = doAdapt(subject);
		String name = c.getName() == null ? "" : c.getName(); //$NON-NLS-1$
		List<Association> types = getTypeProposals(c);
		LinkedList<String> names = new LinkedList<String>();
		for (Type next : types) {
			names.add(CONNECTOR_NAME_FORMAT.format(new Object[]{name, next.getName()}));
		}
		FixedSetCompletionProcessor cp = new FixedSetCompletionProcessor(names);
		cp.setContext(c);
		return cp;
	}

	public String getEditString(IAdaptable element, int flags) {
		Connector c = doAdapt(element);
		String name = c.getName() == null ? "" : c.getName(); //$NON-NLS-1$
		if (c.getType() == null) {
			return name;
		}
		String type = c.getType().getName();
		return CONNECTOR_NAME_FORMAT.format(new Object[]{name, type});
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		Connector c = doAdapt(element);
		if (c == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (newString == null) {
			return UnexecutableCommand.INSTANCE;
		}
		Association oldType = c.getType();
		String oldName = c.getName() == null ? "" : c.getName(); //$NON-NLS-1$
		List<Association> types = getTypeProposals(c);
		try {
			Object[] parsed;
			if (!newString.contains(":")) { //$NON-NLS-1$
				parsed = new String[]{newString, ""}; //$NON-NLS-1$
			} else {
				parsed = CONNECTOR_NAME_FORMAT.parse(newString);
			}
			String newName = ((String) parsed[0]).trim();
			CompositeCommand cc = new CompositeCommand(CustomMessages.ConnectorNameParser_connector_name_parser_command);
			if (!oldName.equals(newName)) {
				cc.add(new SetValueCommand(new SetRequest(c, UMLPackage.eINSTANCE.getNamedElement_Name(), newName)));
			}
			String newType = ((String) parsed[1]).trim();
			for (Type next : types) {
				if (newType.equals(next.getName()) && !newType.equals(oldType)) {
					cc.add(new SetValueCommand(new SetRequest(c, UMLPackage.eINSTANCE.getConnector_Type(), next)));
					break;
				}
			}
			if (newType.equals("") && !newType.equals(oldType)) { //$NON-NLS-1$
				cc.add(new SetValueCommand(new SetRequest(c, UMLPackage.eINSTANCE.getConnector_Type(), null)));
			}
			return cc;
		} catch (ParseException e) {
		}
		return UnexecutableCommand.INSTANCE;
	}

	public String getPrintString(IAdaptable element, int flags) {
		return getEditString(element, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	private Connector doAdapt(IAdaptable adaptable) {
		return (Connector) adaptable.getAdapter(EObject.class);
	}

	private List<Association> getTypeProposals(Connector c) {
		EObject root = c.eContainer();
		while(root.eContainer() != null) {
			root = root.eContainer();
		}
		if (false == root instanceof org.eclipse.uml2.uml.Package) {
			return Collections.<Association>emptyList();
		}
		List<Association> types = new LinkedList<Association>();
		for (Type next : ((org.eclipse.uml2.uml.Package)root).getOwnedTypes()) {
			if (next instanceof Association) {
				types.add((Association)next);
			}
		}
		return types;
	}

}
