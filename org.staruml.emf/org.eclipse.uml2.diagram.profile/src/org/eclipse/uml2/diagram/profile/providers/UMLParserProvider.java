package org.eclipse.uml2.diagram.profile.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.parser.imports.ElementImportParser;
import org.eclipse.uml2.diagram.common.parser.imports.ElementImportProvider;
import org.eclipse.uml2.diagram.common.parser.stereotype.ClassifierAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.ProfileAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.valuespec.ConstraintLanguageParser;
import org.eclipse.uml2.diagram.common.parser.valuespec.ValueSpecificationParser;
import org.eclipse.uml2.diagram.profile.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintLanguageEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImport2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationQualifiedNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ImageEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileName2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileStereoEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Stereotype2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeNameEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeStereoEditPart;
import org.eclipse.uml2.diagram.profile.parsers.MessageFormatParser;
import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser stereotypeName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getStereotypeName_5001Parser() {
		if (stereotypeName_5001Parser == null) {
			stereotypeName_5001Parser = createStereotypeName_5001Parser();
		}
		return stereotypeName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStereotypeName_5001Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ProfileAppliedStereotypeParser stereotypeQualifiedName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getStereotypeQualifiedName_5012Parser() {
		if (stereotypeQualifiedName_5012Parser == null) {
			stereotypeQualifiedName_5012Parser = new ProfileAppliedStereotypeParser();
		}
		return stereotypeQualifiedName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser profileName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getProfileName_5003Parser() {
		if (profileName_5003Parser == null) {
			profileName_5003Parser = createProfileName_5003Parser();
		}
		return profileName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProfileName_5003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ProfileAppliedStereotypeParser profileQualifiedName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getProfileQualifiedName_5013Parser() {
		if (profileQualifiedName_5013Parser == null) {
			profileQualifiedName_5013Parser = new ProfileAppliedStereotypeParser();
		}
		return profileQualifiedName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5005Parser() {
		if (enumerationName_5005Parser == null) {
			enumerationName_5005Parser = createEnumerationName_5005Parser();
		}
		return enumerationName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ProfileAppliedStereotypeParser enumerationQualifiedName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationQualifiedName_5011Parser() {
		if (enumerationQualifiedName_5011Parser == null) {
			enumerationQualifiedName_5011Parser = new ProfileAppliedStereotypeParser();
		}
		return enumerationQualifiedName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser profileName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getProfileName_5009Parser() {
		if (profileName_5009Parser == null) {
			profileName_5009Parser = createProfileName_5009Parser();
		}
		return profileName_5009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProfileName_5009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ValueSpecificationParser.ConstraintParser constraintName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5010Parser() {
		if (constraintName_5010Parser == null) {
			constraintName_5010Parser = new ValueSpecificationParser.ConstraintParser();
		}
		return constraintName_5010Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintLanguageParser constraintLanguage_5015Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintLanguage_5015Parser() {
		if (constraintLanguage_5015Parser == null) {
			constraintLanguage_5015Parser = new ConstraintLanguageParser();
		}
		return constraintLanguage_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_5014Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5014Parser() {
		if (commentBody_5014Parser == null) {
			commentBody_5014Parser = createCommentBody_5014Parser();
		}
		return commentBody_5014Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5014Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ValueSpecificationParser.ConstraintParser constraint_3008Parser;

	/**
	 * @generated
	 */
	private IParser getConstraint_3008Parser() {
		if (constraint_3008Parser == null) {
			constraint_3008Parser = new ValueSpecificationParser.ConstraintParser();
		}
		return constraint_3008Parser;
	}

	/**
	 * @generated
	 */
	private IParser image_3010Parser;

	/**
	 * @generated
	 */
	private IParser getImage_3010Parser() {
		if (image_3010Parser == null) {
			image_3010Parser = createImage_3010Parser();
		}
		return image_3010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createImage_3010Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getImage_Location() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stereotype_3003Parser;

	/**
	 * @generated
	 */
	private IParser getStereotype_3003Parser() {
		if (stereotype_3003Parser == null) {
			stereotype_3003Parser = createStereotype_3003Parser();
		}
		return stereotype_3003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStereotype_3003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationLiteral_3005Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationLiteral_3005Parser() {
		if (enumerationLiteral_3005Parser == null) {
			enumerationLiteral_3005Parser = createEnumerationLiteral_3005Parser();
		}
		return enumerationLiteral_3005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationLiteral_3005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser elementImport_3009Parser;

	/**
	 * @generated
	 */
	private IParser getElementImport_3009Parser() {
		if (elementImport_3009Parser == null) {
			elementImport_3009Parser = createElementImport_3009Parser();
		}
		return elementImport_3009Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createElementImport_3009Parser() {
		return new ElementImportParser(new ElementImportProvider() {

			@Override
			protected boolean isSuitable(Object object) {
				return super.isSuitable(object) && !isMetaclass(object);
			}

			private boolean isMetaclass(Object object) {
				return object instanceof org.eclipse.uml2.uml.Class && ((org.eclipse.uml2.uml.Class) object).isMetaclass();
			}

		});
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case StereotypeNameEditPart.VISUAL_ID:
			return getStereotypeName_5001Parser();
		case StereotypeStereoEditPart.VISUAL_ID:
			return getStereotypeQualifiedName_5012Parser();
		case ProfileNameEditPart.VISUAL_ID:
			return getProfileName_5003Parser();
		case ProfileStereoEditPart.VISUAL_ID:
			return getProfileQualifiedName_5013Parser();
		case EnumerationNameEditPart.VISUAL_ID:
			return getEnumerationName_5005Parser();
		case EnumerationQualifiedNameEditPart.VISUAL_ID:
			return getEnumerationQualifiedName_5011Parser();
		case ProfileName2EditPart.VISUAL_ID:
			return getProfileName_5009Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5010Parser();
		case ConstraintLanguageEditPart.VISUAL_ID:
			return getConstraintLanguage_5015Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5014Parser();
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008Parser();
		case ImageEditPart.VISUAL_ID:
			return getImage_3010Parser();
		case Stereotype2EditPart.VISUAL_ID:
			return getStereotype_3003Parser();
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3005Parser();
		case ElementImport2EditPart.VISUAL_ID:
			return getElementImport_3009Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		private final IElementType elementType;

		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
