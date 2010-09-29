package org.eclipse.uml2.diagram.csd.parser.connector;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndToString;
import org.eclipse.uml2.diagram.csd.part.CustomMessages;
import org.eclipse.uml2.diagram.parser.ApplyStrategy;
import org.eclipse.uml2.diagram.parser.BasicApplyStrategy;
import org.eclipse.uml2.diagram.parser.ExternalParserBase;
import org.eclipse.uml2.diagram.parser.ExternalParserException;
import org.eclipse.uml2.diagram.parser.SemanticParserAdapter;
import org.eclipse.uml2.diagram.parser.ExternalToString.WithReferences;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.UMLPackage;

public class ConnectorParser extends SemanticParserAdapter {

	private ConnectorParser(WithReferences viewAndEdit) {		
		super(EMPTY_PARSER_DELEGATE, EMPTY_APPLIER, viewAndEdit);
	}
	
	public static class ROLE_PARSER extends ConnectorParser {
		public ROLE_PARSER(boolean sourceNotTarget) {
			super(new AssociationEndToString.ROLE_VIEW(sourceNotTarget));
		}		
	}
	
	public static class MULTIPLICITY_PARSER extends ConnectorParser {
		public MULTIPLICITY_PARSER(boolean sourceNotTarget) {
			super(new AssociationEndToString.MULTIPLICITY_VIEW(sourceNotTarget));
		}		
	}

	public static class MODIFIERS_PARSER extends ConnectorParser {
		public MODIFIERS_PARSER(boolean sourceNotTarget) {
			super(new AssociationEndToString.MODIFIERS_VIEW(sourceNotTarget));
		}		
	}

	@Override
	protected boolean isAffectingEvent(Object event) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			if ((feature instanceof EStructuralFeature) && UMLPackage.eINSTANCE.getConnector_Type().equals(feature)) {
				return true;
			}
		}
		return super.isAffectingEvent(event);
	}
	
	@Override
	public List getSemanticElementsBeingParsed(EObject element) {
		if (element instanceof Connector) {
			Association a = ((Connector)element).getType();
			if (a != null) {
				return super.getSemanticElementsBeingParsed(a);
			}
		}
		return Collections.EMPTY_LIST;
	}
	
	private static final ExternalParserBase EMPTY_PARSER_DELEGATE = new ExternalParserBase() {
		@Override
		public EClass getSubjectClass() {
            return UMLPackage.eINSTANCE.getAssociation();
		}
		@Override
		public void parse(EObject target, String text) throws ExternalParserException {
			throw new ExternalParserException(CustomMessages.ConnectorParser_parsing_is_not_supported_exception);
		}
	};
	
	private static final ApplyStrategy EMPTY_APPLIER = new BasicApplyStrategy();

}
