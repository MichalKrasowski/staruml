/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDPackageImpl.java,v 1.1 2010/09/24 00:18:37 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBackedByFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDCombinedFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDEntity;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFactory;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrameContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionOperand;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionUse;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLineElement;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDSimpleNode;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDTrace;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDPackageImpl extends EPackageImpl implements SDPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdGateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdBackedByFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdLifeLineElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdBracketContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdBracketEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdLifeLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdBehaviorSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdMountingRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdFrameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdInteractionUseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdCombinedFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdInteractionOperandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdFrameContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdExecutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdInvocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdAbstractMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdGateMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdGateMessageEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdSimpleNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlStateInvariantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlInteractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlLifelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlOccurrenceSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlDurationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlInteractionFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlExecutionSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlGateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlInteractionUseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlInteractionOperandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlCombinedFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdTraceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SDPackageImpl() {
		super(eNS_URI, SDFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SDPackage init() {
		if (isInited) return (SDPackage)EPackage.Registry.INSTANCE.getEPackage(SDPackage.eNS_URI);

		// Obtain or create and register package
		SDPackageImpl theSDPackage = (SDPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SDPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SDPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSDPackage.createPackageContents();

		// Initialize created meta-data
		theSDPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSDPackage.freeze();

		return theSDPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDEntity() {
		return sdEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDModel() {
		return sdModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDModel_UmlInteraction() {
		return (EReference)sdModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDModel_Lifelines() {
		return (EReference)sdModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDModel_Messages() {
		return (EReference)sdModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDModel_Gates() {
		return (EReference)sdModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDGate() {
		return sdGateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDGate_UmlGate() {
		return (EReference)sdGateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDBackedByFragment() {
		return sdBackedByFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDLifeLineElement() {
		return sdLifeLineElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDBracketContainer() {
		return sdBracketContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDBracketContainer_Brackets() {
		return (EReference)sdBracketContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDBracket() {
		return sdBracketEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDBracket_BracketContainer() {
		return (EReference)sdBracketEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDLifeLine() {
		return sdLifeLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDLifeLine_UmlLifeline() {
		return (EReference)sdLifeLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDLifeLine_Model() {
		return (EReference)sdLifeLineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDBehaviorSpec() {
		return sdBehaviorSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDBehaviorSpec_UmlExecutionSpec() {
		return (EReference)sdBehaviorSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDBehaviorSpec_UmlStart() {
		return (EReference)sdBehaviorSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDBehaviorSpec_UmlFinish() {
		return (EReference)sdBehaviorSpecEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDMountingRegion() {
		return sdMountingRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDMountingRegion_Frame() {
		return (EReference)sdMountingRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDFrame() {
		return sdFrameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDFrame_FrameContainer() {
		return (EReference)sdFrameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDFrame_Regions() {
		return (EReference)sdFrameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDFrame_CoveredLifeLines() {
		return (EReference)sdFrameEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDInteractionUse() {
		return sdInteractionUseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDInteractionUse_UmlInteractionUse() {
		return (EReference)sdInteractionUseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDCombinedFragment() {
		return sdCombinedFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDCombinedFragment_UmlCombinedFragment() {
		return (EReference)sdCombinedFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDInteractionOperand() {
		return sdInteractionOperandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDInteractionOperand_UmlInteractionOperand() {
		return (EReference)sdInteractionOperandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDFrameContainer() {
		return sdFrameContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDFrameContainer_Frames() {
		return (EReference)sdFrameContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDFrameContainer_FragmentsList() {
		return (EReference)sdFrameContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDExecution() {
		return sdExecutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDExecution_Invocation() {
		return (EReference)sdExecutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDExecution_IncomingMessage() {
		return (EReference)sdExecutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDInvocation() {
		return sdInvocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDInvocation_ReceiveExecution() {
		return (EReference)sdInvocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDInvocation_OutgoingMessage() {
		return (EReference)sdInvocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDAbstractMessage() {
		return sdAbstractMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDAbstractMessage_UmlMessage() {
		return (EReference)sdAbstractMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDAbstractMessage_Model() {
		return (EReference)sdAbstractMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDAbstractMessage_MessageNumber() {
		return (EAttribute)sdAbstractMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDMessage() {
		return sdMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDMessage_Source() {
		return (EReference)sdMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDMessage_Target() {
		return (EReference)sdMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDGateMessage() {
		return sdGateMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDGateMessage_FromNotToGate() {
		return (EAttribute)sdGateMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDGateMessage_Gate() {
		return (EReference)sdGateMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDGateMessage_NormalEnd() {
		return (EReference)sdGateMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDGateMessageEnd() {
		return sdGateMessageEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDGateMessageEnd_UmlMessageEnd() {
		return (EReference)sdGateMessageEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDGateMessageEnd_IsStartNotFinish() {
		return (EAttribute)sdGateMessageEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDSimpleNode() {
		return sdSimpleNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDSimpleNode_UmlSimpleFragment() {
		return (EReference)sdSimpleNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLConstraint() {
		return umlConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLStateInvariant() {
		return umlStateInvariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLInteraction() {
		return umlInteractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLPackage() {
		return umlPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLLifeline() {
		return umlLifelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLOccurrenceSpecification() {
		return umlOccurrenceSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLMessage() {
		return umlMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLDurationConstraint() {
		return umlDurationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLInteractionFragment() {
		return umlInteractionFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLExecutionSpecification() {
		return umlExecutionSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLGate() {
		return umlGateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLInteractionUse() {
		return umlInteractionUseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLInteractionOperand() {
		return umlInteractionOperandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLCombinedFragment() {
		return umlCombinedFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDTrace() {
		return sdTraceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDFactory getSDFactory() {
		return (SDFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sdEntityEClass = createEClass(SD_ENTITY);

		sdModelEClass = createEClass(SD_MODEL);
		createEReference(sdModelEClass, SD_MODEL__UML_INTERACTION);
		createEReference(sdModelEClass, SD_MODEL__LIFELINES);
		createEReference(sdModelEClass, SD_MODEL__MESSAGES);
		createEReference(sdModelEClass, SD_MODEL__GATES);

		sdGateEClass = createEClass(SD_GATE);
		createEReference(sdGateEClass, SD_GATE__UML_GATE);

		sdBackedByFragmentEClass = createEClass(SD_BACKED_BY_FRAGMENT);

		sdLifeLineElementEClass = createEClass(SD_LIFE_LINE_ELEMENT);

		sdBracketContainerEClass = createEClass(SD_BRACKET_CONTAINER);
		createEReference(sdBracketContainerEClass, SD_BRACKET_CONTAINER__BRACKETS);

		sdBracketEClass = createEClass(SD_BRACKET);
		createEReference(sdBracketEClass, SD_BRACKET__BRACKET_CONTAINER);

		sdLifeLineEClass = createEClass(SD_LIFE_LINE);
		createEReference(sdLifeLineEClass, SD_LIFE_LINE__UML_LIFELINE);
		createEReference(sdLifeLineEClass, SD_LIFE_LINE__MODEL);

		sdBehaviorSpecEClass = createEClass(SD_BEHAVIOR_SPEC);
		createEReference(sdBehaviorSpecEClass, SD_BEHAVIOR_SPEC__UML_EXECUTION_SPEC);
		createEReference(sdBehaviorSpecEClass, SD_BEHAVIOR_SPEC__UML_START);
		createEReference(sdBehaviorSpecEClass, SD_BEHAVIOR_SPEC__UML_FINISH);

		sdMountingRegionEClass = createEClass(SD_MOUNTING_REGION);
		createEReference(sdMountingRegionEClass, SD_MOUNTING_REGION__FRAME);

		sdFrameEClass = createEClass(SD_FRAME);
		createEReference(sdFrameEClass, SD_FRAME__FRAME_CONTAINER);
		createEReference(sdFrameEClass, SD_FRAME__REGIONS);
		createEReference(sdFrameEClass, SD_FRAME__COVERED_LIFE_LINES);

		sdInteractionUseEClass = createEClass(SD_INTERACTION_USE);
		createEReference(sdInteractionUseEClass, SD_INTERACTION_USE__UML_INTERACTION_USE);

		sdCombinedFragmentEClass = createEClass(SD_COMBINED_FRAGMENT);
		createEReference(sdCombinedFragmentEClass, SD_COMBINED_FRAGMENT__UML_COMBINED_FRAGMENT);

		sdInteractionOperandEClass = createEClass(SD_INTERACTION_OPERAND);
		createEReference(sdInteractionOperandEClass, SD_INTERACTION_OPERAND__UML_INTERACTION_OPERAND);

		sdFrameContainerEClass = createEClass(SD_FRAME_CONTAINER);
		createEReference(sdFrameContainerEClass, SD_FRAME_CONTAINER__FRAMES);
		createEReference(sdFrameContainerEClass, SD_FRAME_CONTAINER__FRAGMENTS_LIST);

		sdExecutionEClass = createEClass(SD_EXECUTION);
		createEReference(sdExecutionEClass, SD_EXECUTION__INVOCATION);
		createEReference(sdExecutionEClass, SD_EXECUTION__INCOMING_MESSAGE);

		sdInvocationEClass = createEClass(SD_INVOCATION);
		createEReference(sdInvocationEClass, SD_INVOCATION__RECEIVE_EXECUTION);
		createEReference(sdInvocationEClass, SD_INVOCATION__OUTGOING_MESSAGE);

		sdAbstractMessageEClass = createEClass(SD_ABSTRACT_MESSAGE);
		createEReference(sdAbstractMessageEClass, SD_ABSTRACT_MESSAGE__UML_MESSAGE);
		createEReference(sdAbstractMessageEClass, SD_ABSTRACT_MESSAGE__MODEL);
		createEAttribute(sdAbstractMessageEClass, SD_ABSTRACT_MESSAGE__MESSAGE_NUMBER);

		sdMessageEClass = createEClass(SD_MESSAGE);
		createEReference(sdMessageEClass, SD_MESSAGE__SOURCE);
		createEReference(sdMessageEClass, SD_MESSAGE__TARGET);

		sdGateMessageEClass = createEClass(SD_GATE_MESSAGE);
		createEAttribute(sdGateMessageEClass, SD_GATE_MESSAGE__FROM_NOT_TO_GATE);
		createEReference(sdGateMessageEClass, SD_GATE_MESSAGE__GATE);
		createEReference(sdGateMessageEClass, SD_GATE_MESSAGE__NORMAL_END);

		sdGateMessageEndEClass = createEClass(SD_GATE_MESSAGE_END);
		createEReference(sdGateMessageEndEClass, SD_GATE_MESSAGE_END__UML_MESSAGE_END);
		createEAttribute(sdGateMessageEndEClass, SD_GATE_MESSAGE_END__IS_START_NOT_FINISH);

		sdSimpleNodeEClass = createEClass(SD_SIMPLE_NODE);
		createEReference(sdSimpleNodeEClass, SD_SIMPLE_NODE__UML_SIMPLE_FRAGMENT);

		umlConstraintEClass = createEClass(UML_CONSTRAINT);

		umlStateInvariantEClass = createEClass(UML_STATE_INVARIANT);

		umlInteractionEClass = createEClass(UML_INTERACTION);

		umlPackageEClass = createEClass(UML_PACKAGE);

		umlLifelineEClass = createEClass(UML_LIFELINE);

		umlOccurrenceSpecificationEClass = createEClass(UML_OCCURRENCE_SPECIFICATION);

		umlMessageEClass = createEClass(UML_MESSAGE);

		umlDurationConstraintEClass = createEClass(UML_DURATION_CONSTRAINT);

		umlInteractionFragmentEClass = createEClass(UML_INTERACTION_FRAGMENT);

		umlExecutionSpecificationEClass = createEClass(UML_EXECUTION_SPECIFICATION);

		umlGateEClass = createEClass(UML_GATE);

		umlInteractionUseEClass = createEClass(UML_INTERACTION_USE);

		umlInteractionOperandEClass = createEClass(UML_INTERACTION_OPERAND);

		umlCombinedFragmentEClass = createEClass(UML_COMBINED_FRAGMENT);

		sdTraceEClass = createEClass(SD_TRACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sdModelEClass.getESuperTypes().add(this.getSDFrameContainer());
		sdModelEClass.getESuperTypes().add(this.getSDEntity());
		sdGateEClass.getESuperTypes().add(this.getSDEntity());
		sdBackedByFragmentEClass.getESuperTypes().add(this.getSDEntity());
		sdLifeLineElementEClass.getESuperTypes().add(this.getSDEntity());
		sdBracketContainerEClass.getESuperTypes().add(this.getSDLifeLineElement());
		sdBracketEClass.getESuperTypes().add(this.getSDLifeLineElement());
		sdBracketEClass.getESuperTypes().add(this.getSDBackedByFragment());
		sdLifeLineEClass.getESuperTypes().add(this.getSDBracketContainer());
		sdBehaviorSpecEClass.getESuperTypes().add(this.getSDBracket());
		sdBehaviorSpecEClass.getESuperTypes().add(this.getSDBracketContainer());
		sdMountingRegionEClass.getESuperTypes().add(this.getSDBracket());
		sdMountingRegionEClass.getESuperTypes().add(this.getSDBracketContainer());
		sdFrameEClass.getESuperTypes().add(this.getSDFrameContainer());
		sdFrameEClass.getESuperTypes().add(this.getSDBackedByFragment());
		sdFrameEClass.getESuperTypes().add(this.getSDEntity());
		sdInteractionUseEClass.getESuperTypes().add(this.getSDFrame());
		sdCombinedFragmentEClass.getESuperTypes().add(this.getSDFrame());
		sdInteractionOperandEClass.getESuperTypes().add(this.getSDFrame());
		sdExecutionEClass.getESuperTypes().add(this.getSDBehaviorSpec());
		sdInvocationEClass.getESuperTypes().add(this.getSDBehaviorSpec());
		sdAbstractMessageEClass.getESuperTypes().add(this.getSDEntity());
		sdMessageEClass.getESuperTypes().add(this.getSDAbstractMessage());
		sdGateMessageEClass.getESuperTypes().add(this.getSDAbstractMessage());
		sdGateMessageEndEClass.getESuperTypes().add(this.getSDBracket());
		sdSimpleNodeEClass.getESuperTypes().add(this.getSDBracket());

		// Initialize classes and features; add operations and parameters
		initEClass(sdEntityEClass, SDEntity.class, "SDEntity", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sdModelEClass, SDModel.class, "SDModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDModel_UmlInteraction(), this.getUMLInteraction(), null, "umlInteraction", null, 1, 1, SDModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDModel_Lifelines(), this.getSDLifeLine(), this.getSDLifeLine_Model(), "lifelines", null, 0, -1, SDModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDModel_Messages(), this.getSDAbstractMessage(), this.getSDAbstractMessage_Model(), "messages", null, 0, -1, SDModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDModel_Gates(), this.getSDGate(), null, "gates", null, 0, -1, SDModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(sdModelEClass, this.getSDTrace(), "getUMLTracing", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sdGateEClass, SDGate.class, "SDGate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDGate_UmlGate(), this.getUMLGate(), null, "umlGate", null, 0, 1, SDGate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdBackedByFragmentEClass, SDBackedByFragment.class, "SDBackedByFragment", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(sdBackedByFragmentEClass, this.getUMLInteractionFragment(), "getUmlFragment", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sdLifeLineElementEClass, SDLifeLineElement.class, "SDLifeLineElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(sdLifeLineElementEClass, this.getSDLifeLine(), "getCoveredLifeLine", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sdBracketContainerEClass, SDBracketContainer.class, "SDBracketContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDBracketContainer_Brackets(), this.getSDBracket(), this.getSDBracket_BracketContainer(), "brackets", null, 0, -1, SDBracketContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdBracketEClass, SDBracket.class, "SDBracket", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDBracket_BracketContainer(), this.getSDBracketContainer(), this.getSDBracketContainer_Brackets(), "bracketContainer", null, 1, 1, SDBracket.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdLifeLineEClass, SDLifeLine.class, "SDLifeLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDLifeLine_UmlLifeline(), this.getUMLLifeline(), null, "umlLifeline", null, 1, 1, SDLifeLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDLifeLine_Model(), this.getSDModel(), this.getSDModel_Lifelines(), "model", null, 1, 1, SDLifeLine.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdBehaviorSpecEClass, SDBehaviorSpec.class, "SDBehaviorSpec", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDBehaviorSpec_UmlExecutionSpec(), this.getUMLExecutionSpecification(), null, "umlExecutionSpec", null, 0, 1, SDBehaviorSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDBehaviorSpec_UmlStart(), this.getUMLOccurrenceSpecification(), null, "umlStart", null, 0, 1, SDBehaviorSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDBehaviorSpec_UmlFinish(), this.getUMLOccurrenceSpecification(), null, "umlFinish", null, 0, 1, SDBehaviorSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdMountingRegionEClass, SDMountingRegion.class, "SDMountingRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDMountingRegion_Frame(), this.getSDFrame(), this.getSDFrame_Regions(), "frame", null, 1, 1, SDMountingRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sdMountingRegionEClass, this.getSDMountingRegion(), "findMountingRegionForSubFrame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDFrame(), "subFrame", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sdFrameEClass, SDFrame.class, "SDFrame", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDFrame_FrameContainer(), this.getSDFrameContainer(), this.getSDFrameContainer_Frames(), "frameContainer", null, 1, 1, SDFrame.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDFrame_Regions(), this.getSDMountingRegion(), this.getSDMountingRegion_Frame(), "regions", null, 0, -1, SDFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDFrame_CoveredLifeLines(), this.getSDLifeLine(), null, "coveredLifeLines", null, 0, -1, SDFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(sdFrameEClass, this.getSDMountingRegion(), "findRegionForUmlLifeLine", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUMLLifeline(), "umlLifeline", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sdFrameEClass, this.getSDMountingRegion(), "findRegionForSDLifeLine", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDLifeLine(), "sdLifeline", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sdInteractionUseEClass, SDInteractionUse.class, "SDInteractionUse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDInteractionUse_UmlInteractionUse(), this.getUMLInteractionUse(), null, "umlInteractionUse", null, 0, 1, SDInteractionUse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdCombinedFragmentEClass, SDCombinedFragment.class, "SDCombinedFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDCombinedFragment_UmlCombinedFragment(), this.getUMLCombinedFragment(), null, "umlCombinedFragment", null, 0, 1, SDCombinedFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdInteractionOperandEClass, SDInteractionOperand.class, "SDInteractionOperand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDInteractionOperand_UmlInteractionOperand(), this.getUMLInteractionOperand(), null, "umlInteractionOperand", null, 0, 1, SDInteractionOperand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdFrameContainerEClass, SDFrameContainer.class, "SDFrameContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDFrameContainer_Frames(), this.getSDFrame(), this.getSDFrame_FrameContainer(), "frames", null, 0, -1, SDFrameContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDFrameContainer_FragmentsList(), this.getUMLInteractionFragment(), null, "fragmentsList", null, 0, -1, SDFrameContainer.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sdExecutionEClass, SDExecution.class, "SDExecution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDExecution_Invocation(), this.getSDInvocation(), this.getSDInvocation_ReceiveExecution(), "invocation", null, 1, 1, SDExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDExecution_IncomingMessage(), this.getSDMessage(), this.getSDMessage_Target(), "incomingMessage", null, 1, 1, SDExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdInvocationEClass, SDInvocation.class, "SDInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDInvocation_ReceiveExecution(), this.getSDExecution(), this.getSDExecution_Invocation(), "receiveExecution", null, 1, 1, SDInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDInvocation_OutgoingMessage(), this.getSDMessage(), this.getSDMessage_Source(), "outgoingMessage", null, 1, 1, SDInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdAbstractMessageEClass, SDAbstractMessage.class, "SDAbstractMessage", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDAbstractMessage_UmlMessage(), this.getUMLMessage(), null, "umlMessage", null, 0, 1, SDAbstractMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDAbstractMessage_Model(), this.getSDModel(), this.getSDModel_Messages(), "model", null, 1, 1, SDAbstractMessage.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSDAbstractMessage_MessageNumber(), ecorePackage.getEString(), "messageNumber", null, 0, 1, SDAbstractMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdMessageEClass, SDMessage.class, "SDMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDMessage_Source(), this.getSDInvocation(), this.getSDInvocation_OutgoingMessage(), "source", null, 0, 1, SDMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDMessage_Target(), this.getSDExecution(), this.getSDExecution_IncomingMessage(), "target", null, 0, 1, SDMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdGateMessageEClass, SDGateMessage.class, "SDGateMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSDGateMessage_FromNotToGate(), ecorePackage.getEBoolean(), "fromNotToGate", "false", 0, 1, SDGateMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDGateMessage_Gate(), this.getSDGate(), null, "gate", null, 0, 1, SDGateMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDGateMessage_NormalEnd(), this.getSDGateMessageEnd(), null, "normalEnd", null, 0, 1, SDGateMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdGateMessageEndEClass, SDGateMessageEnd.class, "SDGateMessageEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDGateMessageEnd_UmlMessageEnd(), this.getUMLOccurrenceSpecification(), null, "umlMessageEnd", null, 0, 1, SDGateMessageEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSDGateMessageEnd_IsStartNotFinish(), ecorePackage.getEBoolean(), "isStartNotFinish", "true", 0, 1, SDGateMessageEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sdSimpleNodeEClass, SDSimpleNode.class, "SDSimpleNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDSimpleNode_UmlSimpleFragment(), this.getUMLInteractionFragment(), null, "umlSimpleFragment", null, 0, 1, SDSimpleNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlConstraintEClass, Constraint.class, "UMLConstraint", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlStateInvariantEClass, StateInvariant.class, "UMLStateInvariant", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlInteractionEClass, Interaction.class, "UMLInteraction", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlPackageEClass, org.eclipse.uml2.uml.Package.class, "UMLPackage", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlLifelineEClass, Lifeline.class, "UMLLifeline", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlOccurrenceSpecificationEClass, OccurrenceSpecification.class, "UMLOccurrenceSpecification", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlMessageEClass, Message.class, "UMLMessage", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlDurationConstraintEClass, DurationConstraint.class, "UMLDurationConstraint", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlInteractionFragmentEClass, InteractionFragment.class, "UMLInteractionFragment", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlExecutionSpecificationEClass, ExecutionSpecification.class, "UMLExecutionSpecification", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlGateEClass, Gate.class, "UMLGate", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlInteractionUseEClass, InteractionUse.class, "UMLInteractionUse", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlInteractionOperandEClass, InteractionOperand.class, "UMLInteractionOperand", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlCombinedFragmentEClass, CombinedFragment.class, "UMLCombinedFragment", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(sdTraceEClass, SDTrace.class, "SDTrace", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SDPackageImpl
