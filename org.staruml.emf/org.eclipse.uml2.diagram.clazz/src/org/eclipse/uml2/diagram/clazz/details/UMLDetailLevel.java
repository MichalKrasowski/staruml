package org.eclipse.uml2.diagram.clazz.details;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FilteringStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassClassesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassClassesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceClassesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageClassifiersEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageOtherEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;

public abstract class UMLDetailLevel {

	public abstract void init(View view);

	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	public String getLabel() {
		return CustomMessages.UMLDetailLevel_none_detail_level;
	}

	public List<EditElementCommand> getApplyCommands(TransactionalEditingDomain editingDomain, View view) {
		return Collections.emptyList();
	}

	public List<EditElementCommand> getUnapplyCommands(TransactionalEditingDomain editingDomain, View view) {
		return Collections.emptyList();
	}

	public List<View> getAffectedViews(Diagram diagram) {
		ArrayList<View> result = new ArrayList<View>();
		// we use Views as EditPart doesn't return invisible children
		EList<?> classifiers = diagram.getChildren();
		for (Object classifier : classifiers) {
			List<?> compartments = ((View) classifier).getChildren();
			for (Object compartment : compartments) {
				if (isAffected(compartment)) {
					View view = (View) compartment;
					result.add(view);
				}
			}
		}
		return result;
	}

	public boolean isAffected(Object compartment) {
		return compartment instanceof View && oursAffectedVIDs.contains(((View) compartment).getType());
	}

	private static List<String> oursAffectedVIDs = new ArrayList<String>();
	static {
		oursAffectedVIDs.add(String.valueOf(AssociationClassAttributesEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(AssociationClassOperationsEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(AssociationClassClassesEditPart.VISUAL_ID));

		oursAffectedVIDs.add(String.valueOf(ClassAttributesEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(ClassOperationsEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(ClassClassesEditPart.VISUAL_ID));

		oursAffectedVIDs.add(String.valueOf(DataTypeAttributesEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(DataTypeOperationsEditPart.VISUAL_ID));

		oursAffectedVIDs.add(String.valueOf(EnumerationAttributesEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(EnumerationOperationsEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(EnumerationLiteralEditPart.VISUAL_ID));

		oursAffectedVIDs.add(String.valueOf(InterfaceAttributesEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(InterfaceOperationsEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(InterfaceClassesEditPart.VISUAL_ID));

		oursAffectedVIDs.add(String.valueOf(PackageClassifiersEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(PackageOtherEditPart.VISUAL_ID));
	
		oursAffectedVIDs.add(String.valueOf(PrimitiveTypeAttributesEditPart.VISUAL_ID));
		oursAffectedVIDs.add(String.valueOf(PrimitiveTypeOperationsEditPart.VISUAL_ID));
	}

	public EditElementCommand getSetLevelCommand(TransactionalEditingDomain editingDomain, Diagram diagram) {
		List<String> filteringKeys = Collections.singletonList(getId());

		FilteringStyle style = (FilteringStyle) diagram.getStyle(NotationPackage.eINSTANCE.getFilteringStyle());
		SetRequest setKeysRequest;
		if (style == null){
			style = NotationFactory.eINSTANCE.createFilteringStyle();
			style.setFilteringKeys(filteringKeys);
			setKeysRequest = new SetRequest(editingDomain, diagram, NotationPackage.eINSTANCE.getView_Styles(), style);
		} else {
			setKeysRequest = new SetRequest(editingDomain, style, NotationPackage.eINSTANCE.getFilteringStyle_FilteringKeys(), filteringKeys);	
		}
		
		
		return new SetValueCommand(setKeysRequest);
	}

	public String getId() {
		return ""; //$NON-NLS-1$
	}

}
