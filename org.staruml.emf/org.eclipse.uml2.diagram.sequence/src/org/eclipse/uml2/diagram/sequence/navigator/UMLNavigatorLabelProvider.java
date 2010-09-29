package org.eclipse.uml2.diagram.sequence.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.diagram.sequence.edit.parts.ActionExecutionLabelEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.CombinedFragmentInteractionOperatorEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.CombinedFragmentMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InnerMountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionOperandMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionUseMountingRegionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionUseSignatureEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredCombinedFragmentEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredInteractionUseEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredOperandEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.StateInvariantLabelEditPart;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.sequence.providers.UMLParserProvider;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */

public class UMLNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof UMLNavigatorItem && !isOwnView(((UMLNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_1000); //$NON-NLS-1$
		case InteractionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Interaction", UMLElementTypes.Interaction_2001); //$NON-NLS-1$
		case GateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Gate", UMLElementTypes.Gate_3005); //$NON-NLS-1$
		case LayeredInteractionUseEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InteractionUse", UMLElementTypes.InteractionUse_3007); //$NON-NLS-1$
		case LayeredCombinedFragmentEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CombinedFragment", UMLElementTypes.CombinedFragment_3008); //$NON-NLS-1$
		case LayeredOperandEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InteractionOperand", UMLElementTypes.InteractionOperand_3009); //$NON-NLS-1$
		case LifelineEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Lifeline", UMLElementTypes.Lifeline_3001); //$NON-NLS-1$
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ActionExecutionSpecification", UMLElementTypes.ActionExecutionSpecification_3002); //$NON-NLS-1$
		case StateInvariantEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?StateInvariant", UMLElementTypes.StateInvariant_3003); //$NON-NLS-1$
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?BehaviorExecutionSpecification", UMLElementTypes.BehaviorExecutionSpecification_3004); //$NON-NLS-1$
		case InteractionUseMountingRegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InteractionUse", UMLElementTypes.InteractionUse_3006); //$NON-NLS-1$
		case CombinedFragmentMountingRegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CombinedFragment", UMLElementTypes.CombinedFragment_3010); //$NON-NLS-1$
		case InteractionOperandMountingRegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InteractionOperand", UMLElementTypes.InteractionOperand_3011); //$NON-NLS-1$
		case MessageEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Message", UMLElementTypes.Message_4001); //$NON-NLS-1$
		case MountingLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?TopLevelMountingLinkFigure", UMLElementTypes.Link_4002); //$NON-NLS-1$
		case InnerMountingLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?org.eclipse.uml2.diagram.sequence.draw2d.InvisiblePolylineConnection", UMLElementTypes.Link_4003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UMLDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && UMLElementTypes.isKnownElementType(elementType)) {
			image = UMLElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000Text(view);
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_2001Text(view);
		case GateEditPart.VISUAL_ID:
			return getGate_3005Text(view);
		case LayeredInteractionUseEditPart.VISUAL_ID:
			return getInteractionUse_3007Text(view);
		case LayeredCombinedFragmentEditPart.VISUAL_ID:
			return getCombinedFragment_3008Text(view);
		case LayeredOperandEditPart.VISUAL_ID:
			return getInteractionOperand_3009Text(view);
		case LifelineEditPart.VISUAL_ID:
			return getLifeline_3001Text(view);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getActionExecutionSpecification_3002Text(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getStateInvariant_3003Text(view);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getBehaviorExecutionSpecification_3004Text(view);
		case InteractionUseMountingRegionEditPart.VISUAL_ID:
			return getInteractionUse_3006Text(view);
		case CombinedFragmentMountingRegionEditPart.VISUAL_ID:
			return getCombinedFragment_3010Text(view);
		case InteractionOperandMountingRegionEditPart.VISUAL_ID:
			return getInteractionOperand_3011Text(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_4001Text(view);
		case MountingLinkEditPart.VISUAL_ID:
			return getLink_4002Text(view);
		case InnerMountingLinkEditPart.VISUAL_ID:
			return getLink_4003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_1000Text(View view) {
		Package domainModelElement = (Package) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteraction_2001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Interaction_2001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InteractionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGate_3005Text(View view) {
		Gate domainModelElement = (Gate) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteractionUse_3007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InteractionUse_3007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InteractionUseSignatureEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCombinedFragment_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CombinedFragment_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CombinedFragmentInteractionOperatorEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteractionOperand_3009Text(View view) {
		InteractionOperand domainModelElement = (InteractionOperand) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLifeline_3001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Lifeline_3001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionExecutionSpecification_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActionExecutionSpecification_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActionExecutionLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStateInvariant_3003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StateInvariant_3003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StateInvariantLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBehaviorExecutionSpecification_3004Text(View view) {
		BehaviorExecutionSpecification domainModelElement = (BehaviorExecutionSpecification) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteractionUse_3006Text(View view) {
		InteractionUse domainModelElement = (InteractionUse) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCombinedFragment_3010Text(View view) {
		CombinedFragment domainModelElement = (CombinedFragment) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteractionOperand_3011Text(View view) {
		InteractionOperand domainModelElement = (InteractionOperand) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_4001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_4001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(MessageNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLink_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLink_4003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

}
