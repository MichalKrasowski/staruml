/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDSwitch.java,v 1.1 2010/09/24 00:18:38 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.diagram.sequence.model.sequenced.*;

import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage
 * @generated
 */
public class SDSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SDPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDSwitch() {
		if (modelPackage == null) {
			modelPackage = SDPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SDPackage.SD_ENTITY: {
				SDEntity sdEntity = (SDEntity)theEObject;
				T result = caseSDEntity(sdEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_MODEL: {
				SDModel sdModel = (SDModel)theEObject;
				T result = caseSDModel(sdModel);
				if (result == null) result = caseSDFrameContainer(sdModel);
				if (result == null) result = caseSDEntity(sdModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_GATE: {
				SDGate sdGate = (SDGate)theEObject;
				T result = caseSDGate(sdGate);
				if (result == null) result = caseSDEntity(sdGate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_BACKED_BY_FRAGMENT: {
				SDBackedByFragment sdBackedByFragment = (SDBackedByFragment)theEObject;
				T result = caseSDBackedByFragment(sdBackedByFragment);
				if (result == null) result = caseSDEntity(sdBackedByFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_LIFE_LINE_ELEMENT: {
				SDLifeLineElement sdLifeLineElement = (SDLifeLineElement)theEObject;
				T result = caseSDLifeLineElement(sdLifeLineElement);
				if (result == null) result = caseSDEntity(sdLifeLineElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_BRACKET_CONTAINER: {
				SDBracketContainer sdBracketContainer = (SDBracketContainer)theEObject;
				T result = caseSDBracketContainer(sdBracketContainer);
				if (result == null) result = caseSDLifeLineElement(sdBracketContainer);
				if (result == null) result = caseSDEntity(sdBracketContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_BRACKET: {
				SDBracket sdBracket = (SDBracket)theEObject;
				T result = caseSDBracket(sdBracket);
				if (result == null) result = caseSDLifeLineElement(sdBracket);
				if (result == null) result = caseSDBackedByFragment(sdBracket);
				if (result == null) result = caseSDEntity(sdBracket);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_LIFE_LINE: {
				SDLifeLine sdLifeLine = (SDLifeLine)theEObject;
				T result = caseSDLifeLine(sdLifeLine);
				if (result == null) result = caseSDBracketContainer(sdLifeLine);
				if (result == null) result = caseSDLifeLineElement(sdLifeLine);
				if (result == null) result = caseSDEntity(sdLifeLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_BEHAVIOR_SPEC: {
				SDBehaviorSpec sdBehaviorSpec = (SDBehaviorSpec)theEObject;
				T result = caseSDBehaviorSpec(sdBehaviorSpec);
				if (result == null) result = caseSDBracket(sdBehaviorSpec);
				if (result == null) result = caseSDBracketContainer(sdBehaviorSpec);
				if (result == null) result = caseSDLifeLineElement(sdBehaviorSpec);
				if (result == null) result = caseSDBackedByFragment(sdBehaviorSpec);
				if (result == null) result = caseSDEntity(sdBehaviorSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_MOUNTING_REGION: {
				SDMountingRegion sdMountingRegion = (SDMountingRegion)theEObject;
				T result = caseSDMountingRegion(sdMountingRegion);
				if (result == null) result = caseSDBracket(sdMountingRegion);
				if (result == null) result = caseSDBracketContainer(sdMountingRegion);
				if (result == null) result = caseSDLifeLineElement(sdMountingRegion);
				if (result == null) result = caseSDBackedByFragment(sdMountingRegion);
				if (result == null) result = caseSDEntity(sdMountingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_FRAME: {
				SDFrame sdFrame = (SDFrame)theEObject;
				T result = caseSDFrame(sdFrame);
				if (result == null) result = caseSDFrameContainer(sdFrame);
				if (result == null) result = caseSDBackedByFragment(sdFrame);
				if (result == null) result = caseSDEntity(sdFrame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_INTERACTION_USE: {
				SDInteractionUse sdInteractionUse = (SDInteractionUse)theEObject;
				T result = caseSDInteractionUse(sdInteractionUse);
				if (result == null) result = caseSDFrame(sdInteractionUse);
				if (result == null) result = caseSDFrameContainer(sdInteractionUse);
				if (result == null) result = caseSDBackedByFragment(sdInteractionUse);
				if (result == null) result = caseSDEntity(sdInteractionUse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_COMBINED_FRAGMENT: {
				SDCombinedFragment sdCombinedFragment = (SDCombinedFragment)theEObject;
				T result = caseSDCombinedFragment(sdCombinedFragment);
				if (result == null) result = caseSDFrame(sdCombinedFragment);
				if (result == null) result = caseSDFrameContainer(sdCombinedFragment);
				if (result == null) result = caseSDBackedByFragment(sdCombinedFragment);
				if (result == null) result = caseSDEntity(sdCombinedFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_INTERACTION_OPERAND: {
				SDInteractionOperand sdInteractionOperand = (SDInteractionOperand)theEObject;
				T result = caseSDInteractionOperand(sdInteractionOperand);
				if (result == null) result = caseSDFrame(sdInteractionOperand);
				if (result == null) result = caseSDFrameContainer(sdInteractionOperand);
				if (result == null) result = caseSDBackedByFragment(sdInteractionOperand);
				if (result == null) result = caseSDEntity(sdInteractionOperand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_FRAME_CONTAINER: {
				SDFrameContainer sdFrameContainer = (SDFrameContainer)theEObject;
				T result = caseSDFrameContainer(sdFrameContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_EXECUTION: {
				SDExecution sdExecution = (SDExecution)theEObject;
				T result = caseSDExecution(sdExecution);
				if (result == null) result = caseSDBehaviorSpec(sdExecution);
				if (result == null) result = caseSDBracket(sdExecution);
				if (result == null) result = caseSDBracketContainer(sdExecution);
				if (result == null) result = caseSDLifeLineElement(sdExecution);
				if (result == null) result = caseSDBackedByFragment(sdExecution);
				if (result == null) result = caseSDEntity(sdExecution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_INVOCATION: {
				SDInvocation sdInvocation = (SDInvocation)theEObject;
				T result = caseSDInvocation(sdInvocation);
				if (result == null) result = caseSDBehaviorSpec(sdInvocation);
				if (result == null) result = caseSDBracket(sdInvocation);
				if (result == null) result = caseSDBracketContainer(sdInvocation);
				if (result == null) result = caseSDLifeLineElement(sdInvocation);
				if (result == null) result = caseSDBackedByFragment(sdInvocation);
				if (result == null) result = caseSDEntity(sdInvocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_ABSTRACT_MESSAGE: {
				SDAbstractMessage sdAbstractMessage = (SDAbstractMessage)theEObject;
				T result = caseSDAbstractMessage(sdAbstractMessage);
				if (result == null) result = caseSDEntity(sdAbstractMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_MESSAGE: {
				SDMessage sdMessage = (SDMessage)theEObject;
				T result = caseSDMessage(sdMessage);
				if (result == null) result = caseSDAbstractMessage(sdMessage);
				if (result == null) result = caseSDEntity(sdMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_GATE_MESSAGE: {
				SDGateMessage sdGateMessage = (SDGateMessage)theEObject;
				T result = caseSDGateMessage(sdGateMessage);
				if (result == null) result = caseSDAbstractMessage(sdGateMessage);
				if (result == null) result = caseSDEntity(sdGateMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_GATE_MESSAGE_END: {
				SDGateMessageEnd sdGateMessageEnd = (SDGateMessageEnd)theEObject;
				T result = caseSDGateMessageEnd(sdGateMessageEnd);
				if (result == null) result = caseSDBracket(sdGateMessageEnd);
				if (result == null) result = caseSDLifeLineElement(sdGateMessageEnd);
				if (result == null) result = caseSDBackedByFragment(sdGateMessageEnd);
				if (result == null) result = caseSDEntity(sdGateMessageEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDPackage.SD_SIMPLE_NODE: {
				SDSimpleNode sdSimpleNode = (SDSimpleNode)theEObject;
				T result = caseSDSimpleNode(sdSimpleNode);
				if (result == null) result = caseSDBracket(sdSimpleNode);
				if (result == null) result = caseSDLifeLineElement(sdSimpleNode);
				if (result == null) result = caseSDBackedByFragment(sdSimpleNode);
				if (result == null) result = caseSDEntity(sdSimpleNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDEntity(SDEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDModel(SDModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDGate(SDGate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Backed By Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Backed By Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDBackedByFragment(SDBackedByFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Life Line Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Life Line Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDLifeLineElement(SDLifeLineElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bracket Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bracket Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDBracketContainer(SDBracketContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bracket</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bracket</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDBracket(SDBracket object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Life Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Life Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDLifeLine(SDLifeLine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDBehaviorSpec(SDBehaviorSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mounting Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mounting Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDMountingRegion(SDMountingRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Frame</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Frame</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDFrame(SDFrame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Use</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Use</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDInteractionUse(SDInteractionUse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Combined Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Combined Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDCombinedFragment(SDCombinedFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Operand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Operand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDInteractionOperand(SDInteractionOperand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Frame Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Frame Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDFrameContainer(SDFrameContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDExecution(SDExecution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDInvocation(SDInvocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDAbstractMessage(SDAbstractMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDMessage(SDMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gate Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gate Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDGateMessage(SDGateMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gate Message End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gate Message End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDGateMessageEnd(SDGateMessageEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDSimpleNode(SDSimpleNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML State Invariant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML State Invariant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLStateInvariant(StateInvariant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Interaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Interaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLInteraction(Interaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLPackage(org.eclipse.uml2.uml.Package object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Lifeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Lifeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLLifeline(Lifeline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Occurrence Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Occurrence Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLOccurrenceSpecification(OccurrenceSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLMessage(Message object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Duration Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Duration Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLDurationConstraint(DurationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Interaction Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Interaction Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLInteractionFragment(InteractionFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Execution Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Execution Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLExecutionSpecification(ExecutionSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Gate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Gate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLGate(Gate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Interaction Use</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Interaction Use</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLInteractionUse(InteractionUse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Interaction Operand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Interaction Operand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLInteractionOperand(InteractionOperand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Combined Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Combined Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLCombinedFragment(CombinedFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDTrace(SDTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SDSwitch
