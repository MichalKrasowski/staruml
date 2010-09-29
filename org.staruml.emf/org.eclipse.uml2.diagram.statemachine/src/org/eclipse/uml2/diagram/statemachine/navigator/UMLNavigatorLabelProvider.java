package org.eclipse.uml2.diagram.statemachine.navigator;

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
import org.eclipse.uml2.diagram.statemachine.edit.parts.ChoicePseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CompositeStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CompositeStateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.DeepHistoryPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.DoActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryConnectionPointReferenceEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryConnectionPointReferenceNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryPointPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryPointPseudostateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitConnectionPointReferenceEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitConnectionPointReferenceNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitPointPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitPointPseudostateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ForkPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.InitialPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.InternalTransitionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.JoinPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.JunctionPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ShallowHistoryPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SimpleStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SimpleStateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine_RegionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.State_RegionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SubmachineStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SubmachineStateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TerminatePseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.statemachine.providers.UMLParserProvider;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;

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
		case StateMachineEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?StateMachine", UMLElementTypes.StateMachine_2005); //$NON-NLS-1$
		case StateMachine_RegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Region", UMLElementTypes.Region_3013); //$NON-NLS-1$
		case SimpleStateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?State", UMLElementTypes.State_3001); //$NON-NLS-1$
		case EntryActivityEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Behavior", UMLElementTypes.Behavior_3019); //$NON-NLS-1$
		case ExitActivityEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Behavior", UMLElementTypes.Behavior_3020); //$NON-NLS-1$
		case DoActivityEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Behavior", UMLElementTypes.Behavior_3021); //$NON-NLS-1$
		case CompositeStateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?State", UMLElementTypes.State_3012); //$NON-NLS-1$
		case State_RegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Region", UMLElementTypes.Region_3002); //$NON-NLS-1$
		case SubmachineStateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?State", UMLElementTypes.State_3016); //$NON-NLS-1$
		case EntryConnectionPointReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ConnectionPointReference", UMLElementTypes.ConnectionPointReference_3017); //$NON-NLS-1$
		case ExitConnectionPointReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ConnectionPointReference", UMLElementTypes.ConnectionPointReference_3018); //$NON-NLS-1$
		case InternalTransitionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Transition", UMLElementTypes.Transition_3022); //$NON-NLS-1$
		case FinalStateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?FinalState", UMLElementTypes.FinalState_3003); //$NON-NLS-1$
		case InitialPseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3004); //$NON-NLS-1$
		case ShallowHistoryPseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3005); //$NON-NLS-1$
		case DeepHistoryPseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3006); //$NON-NLS-1$
		case ForkPseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3007); //$NON-NLS-1$
		case JoinPseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3008); //$NON-NLS-1$
		case JunctionPseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3009); //$NON-NLS-1$
		case ChoicePseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3010); //$NON-NLS-1$
		case TerminatePseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3011); //$NON-NLS-1$
		case EntryPointPseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3014); //$NON-NLS-1$
		case ExitPointPseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3015); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Transition", UMLElementTypes.Transition_4001); //$NON-NLS-1$
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
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_2005Text(view);
		case StateMachine_RegionEditPart.VISUAL_ID:
			return getRegion_3013Text(view);
		case SimpleStateEditPart.VISUAL_ID:
			return getState_3001Text(view);
		case EntryActivityEditPart.VISUAL_ID:
			return getBehavior_3019Text(view);
		case ExitActivityEditPart.VISUAL_ID:
			return getBehavior_3020Text(view);
		case DoActivityEditPart.VISUAL_ID:
			return getBehavior_3021Text(view);
		case CompositeStateEditPart.VISUAL_ID:
			return getState_3012Text(view);
		case State_RegionEditPart.VISUAL_ID:
			return getRegion_3002Text(view);
		case SubmachineStateEditPart.VISUAL_ID:
			return getState_3016Text(view);
		case EntryConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3017Text(view);
		case ExitConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3018Text(view);
		case InternalTransitionEditPart.VISUAL_ID:
			return getTransition_3022Text(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3003Text(view);
		case InitialPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3004Text(view);
		case ShallowHistoryPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3005Text(view);
		case DeepHistoryPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3006Text(view);
		case ForkPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3007Text(view);
		case JoinPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3008Text(view);
		case JunctionPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3009Text(view);
		case ChoicePseudostateEditPart.VISUAL_ID:
			return getPseudostate_3010Text(view);
		case TerminatePseudostateEditPart.VISUAL_ID:
			return getPseudostate_3011Text(view);
		case EntryPointPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3014Text(view);
		case ExitPointPseudostateEditPart.VISUAL_ID:
			return getPseudostate_3015Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
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
	private String getStateMachine_2005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StateMachine_2005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StateMachineNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRegion_3013Text(View view) {
		Region domainModelElement = (Region) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_3001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.State_3001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(SimpleStateNameEditPart.VISUAL_ID));
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
	private String getBehavior_3019Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Behavior_3019, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(EntryActivityEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBehavior_3020Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Behavior_3020, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ExitActivityEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBehavior_3021Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Behavior_3021, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(DoActivityEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_3012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.State_3012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CompositeStateNameEditPart.VISUAL_ID));
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
	private String getRegion_3002Text(View view) {
		Region domainModelElement = (Region) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_3016Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.State_3016, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(SubmachineStateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConnectionPointReference_3017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ConnectionPointReference_3017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(EntryConnectionPointReferenceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConnectionPointReference_3018Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ConnectionPointReference_3018, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExitConnectionPointReferenceNameEditPart.VISUAL_ID));
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
	private String getTransition_3022Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Transition_3022, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(InternalTransitionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFinalState_3003Text(View view) {
		FinalState domainModelElement = (FinalState) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3004Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
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
	private String getPseudostate_3005Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
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
	private String getPseudostate_3006Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
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
	private String getPseudostate_3007Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3008Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3009Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
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
	private String getPseudostate_3010Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
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
	private String getPseudostate_3011Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
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
	private String getPseudostate_3014Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Pseudostate_3014, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(EntryPointPseudostateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3015Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Pseudostate_3015, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExitPointPseudostateNameEditPart.VISUAL_ID));
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
	private String getTransition_4001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Transition_4001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(TransitionNameEditPart.VISUAL_ID));
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
