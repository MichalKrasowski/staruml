package org.eclipse.uml2.diagram.clazz.providers;

import java.util.Collection;

import org.eclipse.uml2.diagram.clazz.expressions.UMLAbstractExpression;
import org.eclipse.uml2.diagram.clazz.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_Package_2002(Package instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'package\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPackage()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_2001(Class instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Class\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getClass_()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_AssociationClass_2007(AssociationClass instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'AssociationClass\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getAssociationClass()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_DataType_2004(DataType instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'DataType\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getDataType()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_PrimitiveType_2005(PrimitiveType instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'PrimitiveType\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPrimitiveType()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Enumeration_2003(Enumeration instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Enumeration\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getEnumeration()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Interface_2010(Interface instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Interface\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getInterface()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Constraint_2006(Constraint instance) {
		try {
			OpaqueExpression newInstance_0_0 = UMLFactory.eINSTANCE.createOpaqueExpression();

			instance.setSpecification(newInstance_0_0);
			;
			Object value_0_0_0 = UMLOCLFactory.getExpression("\'OCL\'", UMLPackage.eINSTANCE.getOpaqueExpression()).evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getLanguages().clear();
				newInstance_0_0.getLanguages().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getLanguages().add((String) value_0_0_0);
			}
			Object value_0_0_1 = UMLOCLFactory.getExpression("\'true\'", UMLPackage.eINSTANCE.getOpaqueExpression()).evaluate(newInstance_0_0);
			if (value_0_0_1 instanceof Collection) {
				newInstance_0_0.getBodies().clear();
				newInstance_0_0.getBodies().addAll(((Collection) value_0_0_1));
			} else {
				newInstance_0_0.getBodies().add((String) value_0_0_1);
			}

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InstanceSpecification_2008(InstanceSpecification instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Object\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getInstanceSpecification()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Dependency_2009(Dependency instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'dependency\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getDependency()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Interface_2013(Interface instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Interface\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getInterface()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Package_2016(Package instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'package\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPackage()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InstanceSpecification_2017(InstanceSpecification instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Object\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getInstanceSpecification()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Package_3006(Package instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'package\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPackage()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_3007(Class instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Class\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getClass_()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_DataType_3008(DataType instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'DataType\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getDataType()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_PrimitiveType_3009(PrimitiveType instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'PrimitiveType\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPrimitiveType()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Enumeration_3011(Enumeration instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Enumeration\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getEnumeration()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_AssociationClass_3012(AssociationClass instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'AssociationClass\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getAssociationClass()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Interface_3041(Interface instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Interface\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getInterface()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InstanceSpecification_3013(InstanceSpecification instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'instanceSpecification\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getInstanceSpecification()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3001(Property instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("AggregationKind::composite", UMLPackage.eINSTANCE.getProperty()).evaluate(instance);

			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getAggregationKind());
			instance.setAggregation((AggregationKind) value_0);
			Object value_1 = UMLOCLFactory
					.getExpression(
							" let base : String = \'property\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getProperty()).evaluate(instance);
			instance.setName((String) value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3002(Operation instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'operation\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getOperation()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_3003(Class instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Class\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getClass_()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Port_3025(Port instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("AggregationKind::composite", UMLPackage.eINSTANCE.getPort()).evaluate(instance);

			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getAggregationKind());
			instance.setAggregation((AggregationKind) value_0);
			Object value_1 = UMLOCLFactory
					.getExpression(
							" let base : String = \'port\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPort()).evaluate(instance);
			instance.setName((String) value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3019(Property instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("AggregationKind::composite", UMLPackage.eINSTANCE.getProperty()).evaluate(instance);

			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getAggregationKind());
			instance.setAggregation((AggregationKind) value_0);
			Object value_1 = UMLOCLFactory
					.getExpression(
							" let base : String = \'property\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getProperty()).evaluate(instance);
			instance.setName((String) value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3020(Operation instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'operation\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getOperation()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3014(Property instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("AggregationKind::composite", UMLPackage.eINSTANCE.getProperty()).evaluate(instance);

			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getAggregationKind());
			instance.setAggregation((AggregationKind) value_0);
			Object value_1 = UMLOCLFactory
					.getExpression(
							" let base : String = \'property\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getProperty()).evaluate(instance);
			instance.setName((String) value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3015(Operation instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'operation\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getOperation()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3021(Property instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("AggregationKind::composite", UMLPackage.eINSTANCE.getProperty()).evaluate(instance);

			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getAggregationKind());
			instance.setAggregation((AggregationKind) value_0);
			Object value_1 = UMLOCLFactory
					.getExpression(
							" let base : String = \'property\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getProperty()).evaluate(instance);
			instance.setName((String) value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3022(Operation instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'operation\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getOperation()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_EnumerationLiteral_3016(EnumerationLiteral instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'enumerationLiteral\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getEnumerationLiteral()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3023(Property instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("AggregationKind::composite", UMLPackage.eINSTANCE.getProperty()).evaluate(instance);

			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getAggregationKind());
			instance.setAggregation((AggregationKind) value_0);
			Object value_1 = UMLOCLFactory
					.getExpression(
							" let base : String = \'property\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getProperty()).evaluate(instance);
			instance.setName((String) value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3024(Operation instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'operation\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getOperation()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3028(Property instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("AggregationKind::composite", UMLPackage.eINSTANCE.getProperty()).evaluate(instance);

			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getAggregationKind());
			instance.setAggregation((AggregationKind) value_0);
			Object value_1 = UMLOCLFactory
					.getExpression(
							" let base : String = \'property\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getProperty()).evaluate(instance);
			instance.setName((String) value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3029(Operation instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'operation\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getOperation()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_3030(Class instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Class\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getClass_()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Package_3032(Package instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'package\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPackage()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_3033(Class instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Class\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getClass_()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Enumeration_3034(Enumeration instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Enumeration\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getEnumeration()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InstanceSpecification_3035(InstanceSpecification instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'Object\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getInstanceSpecification()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_DataType_3036(DataType instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'DataType\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getDataType()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_PrimitiveType_3037(PrimitiveType instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'PrimitiveType\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPrimitiveType()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}
}
