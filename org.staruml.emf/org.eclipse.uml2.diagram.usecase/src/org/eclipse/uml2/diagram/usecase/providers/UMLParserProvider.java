package org.eclipse.uml2.diagram.usecase.providers;

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
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndApplyStrategy;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndParser;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndToString;
import org.eclipse.uml2.diagram.common.parser.imports.ElementImportParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.ClassifierAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.PackageAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.valuespec.ConstraintLanguageParser;
import org.eclipse.uml2.diagram.common.parser.valuespec.ValueSpecificationParser;
import org.eclipse.uml2.diagram.parser.SemanticParserAdapter;
import org.eclipse.uml2.diagram.parser.lookup.LookupSuite;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorName2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorName3EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorStereoEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.AssociationSourceMultiplicityEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.AssociationTargetMultiplicityEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ComponentStereoEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintLanguageEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ConstraintNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.NestedPackageNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.SubjectNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName3EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName4EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseStereoEditPart;
import org.eclipse.uml2.diagram.usecase.parsers.MessageFormatParser;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser packageName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5001Parser() {
		if (packageName_5001Parser == null) {
			packageName_5001Parser = createPackageName_5001Parser();
		}
		return packageName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5001Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private PackageAppliedStereotypeParser packageQualifiedName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getPackageQualifiedName_5016Parser() {
		if (packageQualifiedName_5016Parser == null) {
			packageQualifiedName_5016Parser = new PackageAppliedStereotypeParser();
		}
		return packageQualifiedName_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5002Parser() {
		if (actorName_5002Parser == null) {
			actorName_5002Parser = createActorName_5002Parser();
		}
		return actorName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActorName_5002Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5005Parser() {
		if (actorName_5005Parser == null) {
			actorName_5005Parser = createActorName_5005Parser();
		}
		return actorName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActorName_5005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser actorQualifiedName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getActorQualifiedName_5012Parser() {
		if (actorQualifiedName_5012Parser == null) {
			actorQualifiedName_5012Parser = new ClassifierAppliedStereotypeParser();
		}
		return actorQualifiedName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5003Parser() {
		if (useCaseName_5003Parser == null) {
			useCaseName_5003Parser = createUseCaseName_5003Parser();
		}
		return useCaseName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createUseCaseName_5003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5004Parser() {
		if (useCaseName_5004Parser == null) {
			useCaseName_5004Parser = createUseCaseName_5004Parser();
		}
		return useCaseName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createUseCaseName_5004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser useCaseQualifiedName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseQualifiedName_5013Parser() {
		if (useCaseQualifiedName_5013Parser == null) {
			useCaseQualifiedName_5013Parser = new ClassifierAppliedStereotypeParser();
		}
		return useCaseQualifiedName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5007Parser() {
		if (componentName_5007Parser == null) {
			componentName_5007Parser = createComponentName_5007Parser();
		}
		return componentName_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_5007Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser componentQualifiedName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getComponentQualifiedName_5014Parser() {
		if (componentQualifiedName_5014Parser == null) {
			componentQualifiedName_5014Parser = new ClassifierAppliedStereotypeParser();
		}
		return componentQualifiedName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5008Parser() {
		if (packageName_5008Parser == null) {
			packageName_5008Parser = createPackageName_5008Parser();
		}
		return packageName_5008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5008Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5011Parser() {
		if (constraintName_5011Parser == null) {
			constraintName_5011Parser = createConstraintName_5011Parser();
		}
		return constraintName_5011Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConstraintName_5011Parser() {
		return new ValueSpecificationParser.ConstraintParser();
	}

	/**
	 * @generated
	 */
	private ConstraintLanguageParser constraintLanguage_5017Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintLanguage_5017Parser() {
		if (constraintLanguage_5017Parser == null) {
			constraintLanguage_5017Parser = new ConstraintLanguageParser();
		}
		return constraintLanguage_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_5015Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5015Parser() {
		if (commentBody_5015Parser == null) {
			commentBody_5015Parser = createCommentBody_5015Parser();
		}
		return commentBody_5015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5015Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser elementImport_3001Parser;

	/**
	 * @generated
	 */
	private IParser getElementImport_3001Parser() {
		if (elementImport_3001Parser == null) {
			elementImport_3001Parser = createElementImport_3001Parser();
		}
		return elementImport_3001Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createElementImport_3001Parser() {
		return new ElementImportParser();
	}

	/**
	 * @generated
	 */
	private IParser extensionPoint_3002Parser;

	/**
	 * @generated
	 */
	private IParser getExtensionPoint_3002Parser() {
		if (extensionPoint_3002Parser == null) {
			extensionPoint_3002Parser = createExtensionPoint_3002Parser();
		}
		return extensionPoint_3002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExtensionPoint_3002Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser extensionPoint_3003Parser;

	/**
	 * @generated
	 */
	private IParser getExtensionPoint_3003Parser() {
		if (extensionPoint_3003Parser == null) {
			extensionPoint_3003Parser = createExtensionPoint_3003Parser();
		}
		return extensionPoint_3003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExtensionPoint_3003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5006Parser() {
		if (useCaseName_5006Parser == null) {
			useCaseName_5006Parser = createUseCaseName_5006Parser();
		}
		return useCaseName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createUseCaseName_5006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5009Parser() {
		if (actorName_5009Parser == null) {
			actorName_5009Parser = createActorName_5009Parser();
		}
		return actorName_5009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActorName_5009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5010Parser() {
		if (useCaseName_5010Parser == null) {
			useCaseName_5010Parser = createUseCaseName_5010Parser();
		}
		return useCaseName_5010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createUseCaseName_5010Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6003Parser() {
		if (associationName_6003Parser == null) {
			associationName_6003Parser = createAssociationName_6003Parser();
		}
		return associationName_6003Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6003Parser() {
		return createAssocationMultiplicityParser(false);
	}

	/**
	 * @NOT-GENERATED
	 */
	protected IParser createAssocationMultiplicityParser(boolean sourceNotTarget) {
		LookupSuite lookupSuite = getAssociationLookupSuite();
		return new SemanticParserAdapter(//
				new AssociationEndParser(lookupSuite), //
				new AssociationEndApplyStrategy(sourceNotTarget), //
				new AssociationEndToString.MULTIPLICITY_VIEW(sourceNotTarget) {

					@Override
					protected void appendMultiplicity(StringBuffer result, MultiplicityElement element) {
						appendMultiplicity(result, element, true);
					}
				}, new AssociationEndToString.EDIT(sourceNotTarget) {

					@Override
					protected void appendMultiplicity(StringBuffer result, MultiplicityElement element) {
						appendMultiplicity(result, element, false);
					}
				});
	}

	/**
	 * @NOT-GENERATED
	 */
	private LookupSuite getAssociationLookupSuite() {
		return LookupSuite.NULL_SUITE;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6004Parser() {
		if (associationName_6004Parser == null) {
			associationName_6004Parser = createAssociationName_6004Parser();
		}
		return associationName_6004Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6004Parser() {
		return createAssocationMultiplicityParser(true);
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6005Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6005Parser() {
		if (dependencyName_6005Parser == null) {
			dependencyName_6005Parser = createDependencyName_6005Parser();
		}
		return dependencyName_6005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDependencyName_6005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case PackageNameEditPart.VISUAL_ID:
			return getPackageName_5001Parser();
		case PackageStereo2EditPart.VISUAL_ID:
			return getPackageQualifiedName_5016Parser();
		case ActorNameEditPart.VISUAL_ID:
			return getActorName_5002Parser();
		case ActorName2EditPart.VISUAL_ID:
			return getActorName_5005Parser();
		case ActorStereoEditPart.VISUAL_ID:
			return getActorQualifiedName_5012Parser();
		case UseCaseNameEditPart.VISUAL_ID:
			return getUseCaseName_5003Parser();
		case UseCaseName2EditPart.VISUAL_ID:
			return getUseCaseName_5004Parser();
		case UseCaseStereoEditPart.VISUAL_ID:
			return getUseCaseQualifiedName_5013Parser();
		case SubjectNameEditPart.VISUAL_ID:
			return getComponentName_5007Parser();
		case ComponentStereoEditPart.VISUAL_ID:
			return getComponentQualifiedName_5014Parser();
		case NestedPackageNameEditPart.VISUAL_ID:
			return getPackageName_5008Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5011Parser();
		case ConstraintLanguageEditPart.VISUAL_ID:
			return getConstraintLanguage_5017Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5015Parser();
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3001Parser();
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3002Parser();
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3003Parser();
		case UseCaseName3EditPart.VISUAL_ID:
			return getUseCaseName_5006Parser();
		case ActorName3EditPart.VISUAL_ID:
			return getActorName_5009Parser();
		case UseCaseName4EditPart.VISUAL_ID:
			return getUseCaseName_5010Parser();
		case AssociationTargetMultiplicityEditPart.VISUAL_ID:
			return getAssociationName_6003Parser();
		case AssociationSourceMultiplicityEditPart.VISUAL_ID:
			return getAssociationName_6004Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_6005Parser();
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

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
