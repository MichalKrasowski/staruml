package org.eclipse.uml2.diagram.clazz.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClass2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassRhombEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataType2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataType3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Enumeration2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Enumeration3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageAsFrameContents2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageAsFrameContentsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageAsFrameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveType2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveType3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.uml2.diagram.clazz.part.Messages;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List<?> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof Package2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Package_3006);
			types.add(UMLElementTypes.Class_3007);
			types.add(UMLElementTypes.DataType_3008);
			types.add(UMLElementTypes.PrimitiveType_3009);
			types.add(UMLElementTypes.Enumeration_3011);
			types.add(UMLElementTypes.AssociationClass_3012);
			types.add(UMLElementTypes.Interface_3041);
			types.add(UMLElementTypes.InstanceSpecification_3013);
			return types;
		}

		if (editPart instanceof Class2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3025);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Property_3001);
			types.add(UMLElementTypes.Operation_3002);
			types.add(UMLElementTypes.Class_3003);
			return types;
		}

		if (editPart instanceof AssociationClass2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Property_3019);
			types.add(UMLElementTypes.Operation_3020);
			types.add(UMLElementTypes.Class_3003);
			return types;
		}

		if (editPart instanceof DataType2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Property_3014);
			types.add(UMLElementTypes.Operation_3015);
			return types;
		}

		if (editPart instanceof PrimitiveType2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Property_3021);
			types.add(UMLElementTypes.Operation_3022);
			return types;
		}

		if (editPart instanceof Enumeration2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.EnumerationLiteral_3016);
			types.add(UMLElementTypes.Property_3023);
			types.add(UMLElementTypes.Operation_3024);
			return types;
		}

		if (editPart instanceof InstanceSpecification2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Slot_3017);
			return types;
		}

		if (editPart instanceof Interface2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Property_3028);
			types.add(UMLElementTypes.Operation_3029);
			types.add(UMLElementTypes.Class_3030);
			return types;
		}

		if (editPart instanceof Package4EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.ElementImport_3031);
			return types;
		}

		if (editPart instanceof InstanceSpecification4EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.LiteralInteger_3039);
			types.add(UMLElementTypes.LiteralString_3038);
			types.add(UMLElementTypes.Expression_3040);
			return types;
		}

		if (editPart instanceof Class5EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Port_3025);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Property_3001);
			types.add(UMLElementTypes.Operation_3002);
			types.add(UMLElementTypes.Class_3003);
			return types;
		}

		if (editPart instanceof Enumeration3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.EnumerationLiteral_3016);
			types.add(UMLElementTypes.Property_3023);
			types.add(UMLElementTypes.Operation_3024);
			return types;
		}

		if (editPart instanceof InstanceSpecification3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Slot_3017);
			return types;
		}

		if (editPart instanceof DataType3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Property_3014);
			types.add(UMLElementTypes.Operation_3015);
			return types;
		}

		if (editPart instanceof PrimitiveType3EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Property_3021);
			types.add(UMLElementTypes.Operation_3022);
			return types;
		}

		if (editPart instanceof PackageAsFrameContentsEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.InstanceSpecification_3035);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			return types;
		}

		if (editPart instanceof PackageAsFrameContents2EditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.InstanceSpecification_3035);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			return types;
		}

		if (editPart instanceof PackageEditPart) {
			List<IElementType> types = new ArrayList<IElementType>();
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Constraint_2006);
			types.add(UMLElementTypes.InstanceSpecification_2008);
			types.add(UMLElementTypes.Dependency_2009);
			types.add(UMLElementTypes.GeneralizationSet_2012);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.InstanceSpecification_2017);
			types.add(UMLElementTypes.Comment_2018);
			return types;
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AssociationClass2EditPart) {
			return ((AssociationClass2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataType2EditPart) {
			return ((DataType2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PrimitiveType2EditPart) {
			return ((PrimitiveType2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Enumeration2EditPart) {
			return ((Enumeration2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InstanceSpecification2EditPart) {
			return ((InstanceSpecification2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DependencyEditPart) {
			return ((DependencyEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof GeneralizationSetEditPart) {
			return ((GeneralizationSetEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Package4EditPart) {
			return ((Package4EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AssociationClassRhombEditPart) {
			return ((AssociationClassRhombEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PackageAsFrameEditPart) {
			return ((PackageAsFrameEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InstanceSpecification4EditPart) {
			return ((InstanceSpecification4EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Package6EditPart) {
			return ((Package6EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Class5EditPart) {
			return ((Class5EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Enumeration3EditPart) {
			return ((Enumeration3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InstanceSpecification3EditPart) {
			return ((InstanceSpecification3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataType3EditPart) {
			return ((DataType3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PrimitiveType3EditPart) {
			return ((PrimitiveType3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			return ((AssociationClass2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataType2EditPart) {
			return ((DataType2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			return ((PrimitiveType2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			return ((Enumeration2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			return ((InstanceSpecification2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DependencyEditPart) {
			return ((DependencyEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			return ((GeneralizationSetEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Package4EditPart) {
			return ((Package4EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			return ((AssociationClassRhombEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			return ((PackageAsFrameEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			return ((InstanceSpecification4EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PortEditPart) {
			return ((PortEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Package6EditPart) {
			return ((Package6EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Class5EditPart) {
			return ((Class5EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			return ((Enumeration3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			return ((InstanceSpecification3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataType3EditPart) {
			return ((DataType3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			return ((PrimitiveType3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AssociationClass2EditPart) {
			return ((AssociationClass2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataType2EditPart) {
			return ((DataType2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PrimitiveType2EditPart) {
			return ((PrimitiveType2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Enumeration2EditPart) {
			return ((Enumeration2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InstanceSpecification2EditPart) {
			return ((InstanceSpecification2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DependencyEditPart) {
			return ((DependencyEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof GeneralizationSetEditPart) {
			return ((GeneralizationSetEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Package4EditPart) {
			return ((Package4EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AssociationClassRhombEditPart) {
			return ((AssociationClassRhombEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PackageAsFrameEditPart) {
			return ((PackageAsFrameEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InstanceSpecification4EditPart) {
			return ((InstanceSpecification4EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Package6EditPart) {
			return ((Package6EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Class5EditPart) {
			return ((Class5EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Enumeration3EditPart) {
			return ((Enumeration3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InstanceSpecification3EditPart) {
			return ((InstanceSpecification3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataType3EditPart) {
			return ((DataType3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PrimitiveType3EditPart) {
			return ((PrimitiveType3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			return ((AssociationClass2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			return ((DataType2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			return ((PrimitiveType2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			return ((Enumeration2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			return ((InstanceSpecification2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DependencyEditPart) {
			return ((DependencyEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			return ((GeneralizationSetEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Package4EditPart) {
			return ((Package4EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			return ((AssociationClassRhombEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			return ((PackageAsFrameEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			return ((InstanceSpecification4EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PortEditPart) {
			return ((PortEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Package6EditPart) {
			return ((Package6EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Class5EditPart) {
			return ((Class5EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			return ((Enumeration3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			return ((InstanceSpecification3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			return ((DataType3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			return ((PrimitiveType3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof Package2EditPart) {
			return ((Package2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Class2EditPart) {
			return ((Class2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AssociationClass2EditPart) {
			return ((AssociationClass2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataType2EditPart) {
			return ((DataType2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PrimitiveType2EditPart) {
			return ((PrimitiveType2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Enumeration2EditPart) {
			return ((Enumeration2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InstanceSpecification2EditPart) {
			return ((InstanceSpecification2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DependencyEditPart) {
			return ((DependencyEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof GeneralizationSetEditPart) {
			return ((GeneralizationSetEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Interface2EditPart) {
			return ((Interface2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Package4EditPart) {
			return ((Package4EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AssociationClassRhombEditPart) {
			return ((AssociationClassRhombEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PackageAsFrameEditPart) {
			return ((PackageAsFrameEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InstanceSpecification4EditPart) {
			return ((InstanceSpecification4EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RedefinableTemplateSignatureEditPart) {
			return ((RedefinableTemplateSignatureEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Package6EditPart) {
			return ((Package6EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Class5EditPart) {
			return ((Class5EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Enumeration3EditPart) {
			return ((Enumeration3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InstanceSpecification3EditPart) {
			return ((InstanceSpecification3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataType3EditPart) {
			return ((DataType3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PrimitiveType3EditPart) {
			return ((PrimitiveType3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
