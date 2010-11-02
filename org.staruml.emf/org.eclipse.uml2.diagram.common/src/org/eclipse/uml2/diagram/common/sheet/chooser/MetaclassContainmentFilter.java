package org.eclipse.uml2.diagram.common.sheet.chooser;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;


public class MetaclassContainmentFilter {
	private static final boolean DEBUG = Boolean.FALSE.booleanValue();
	private final EPackage myMetamodel;
	private final EPackageRegistry myRegistry;
	private final Map<EClass, Set<EClass>> myAncestorsOrSelfMap;
	private final List<EReference> myContainments;
	
	public MetaclassContainmentFilter(EPackage metamodel){
		this(metamodel, Collections.<EReference>emptyList());
	}
	
	public MetaclassContainmentFilter(EPackage metamodel, List<EReference> excludedContainments){
		myMetamodel = metamodel;
		myRegistry = myMetamodel == UMLPackage.eINSTANCE ? EPackageRegistry.getUML() : new EPackageRegistry(myMetamodel);
		myAncestorsOrSelfMap = new HashMap<EClass, Set<EClass>>();
		myContainments = Collections.unmodifiableList(loadContainments(myMetamodel, excludedContainments));
	}
	
	private static List<EReference> loadContainments(EPackage metamodel, List<EReference> excludedContainments) {
		List<EReference> result = new LinkedList<EReference>();
		for (EClassifier nextClassifier : metamodel.getEClassifiers()){
			if (nextClassifier instanceof EClass){
				for (EStructuralFeature next : ((EClass)nextClassifier).getEStructuralFeatures()){
					if (next instanceof EReference){
						EReference reference = (EReference)next;
						if (excludedContainments.contains(reference)){
							continue;
						}
						if (reference.isContainment() && !reference.isDerived()){
							result.add(reference);
						}
					}
				}
			}
		}
		return result;
	}

	public Set<EClass> getAncestorsOrSelf(EClass eClass){
		if (eClass.getEPackage() != myMetamodel){
			throw new IllegalArgumentException("Alien class: " + eClass + ", Expected metamodel: " + myMetamodel + ", Actual metamodel: " + eClass.getEPackage()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		Set<EClass> result = myAncestorsOrSelfMap.get(eClass);
		if (result == null){
			result = loadAncestorsOrSelf(eClass);
			myAncestorsOrSelfMap.put(eClass, result);
		}
		return result;
	}
	
	private Set<EClass> loadAncestorsOrSelf(EClass eClass){
		HashSet<EClass> result = new HashSet<EClass>();
		result.add(eClass);
		debugAdding(eClass, null);

		result.addAll(myRegistry.getSubTypes(eClass));
		debugAddingSubtypes(eClass);
		
		boolean scopeChanged = true;
		while(scopeChanged){
			scopeChanged = false;
			for (EReference containment : myContainments){
				EClass owner = containment.getEContainingClass();
				if (result.contains(owner)){
					continue;
				}
				if (isCompatible(containment, result)){
					if (result.add(owner)){
						scopeChanged = true;
						debugAdding(owner, containment);

						result.addAll(myRegistry.getSubTypes(owner));
						debugAddingSubtypes(owner);
					}
				}
			}
		}
		return result;
	}
	
	private boolean isCompatible(EReference containment, Set<EClass> subtypesClosure) {
		if (containment.getEType() instanceof EClass){
			EClass type = (EClass) containment.getEType();
			if (subtypesClosure.contains(type)){
				return true;
			}

			Set<EClass> allSubtypesForType = myRegistry.getSubTypes(type);
			if (!allSubtypesForType.isEmpty()){
				for (EClass next : subtypesClosure){
					if (allSubtypesForType.contains(next)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private void debugAdding(EClass owner, EReference containment){
		if (DEBUG){
			System.out.print("Adding: " + owner.getName()); //$NON-NLS-1$
			if (containment != null){
				System.out.println(", due to: " + containment.getEContainingClass().getName() + "#" + containment.getName() + ":" + containment.getEType().getName()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				System.out.println(", as root"); //$NON-NLS-1$
			}
		}
	}
	
	private void debugAddingSubtypes(EClass owner){
		if (!DEBUG){
			return;
		}
		Set<EClass> ownerSubtypes = myRegistry.getSubTypes(owner);
		if (!ownerSubtypes.isEmpty()){
			System.out.println("\t processing subtypes: "); //$NON-NLS-1$
			for (EClass subtype : ownerSubtypes){
				System.out.println("\t Adding: subtype: " + subtype.getName()); //$NON-NLS-1$
			}
		}
	}
	
	private static class EPackageRegistry {
		private static EPackageRegistry UML_INSTANCE;
		private final Map<EClass, Set<EClass>> mySubTypesMap = new HashMap<EClass, Set<EClass>>();
		
		public EPackageRegistry(EPackage metamodel){
			for (EClassifier next : metamodel.getEClassifiers()){
				if (next instanceof EClass){
					registerSuperTypes((EClass)next);
				}
			}
		}
		
		public Set<EClass> getSubTypes(EClass eClass){
			Set<EClass> result = mySubTypesMap.get(eClass);
			return result == null ? Collections.<EClass>emptySet() : result;
		}
		
		private void registerSuperTypes(EClass eClass){
			for (EClass nextSuper : eClass.getEAllSuperTypes()){
				if (nextSuper.getEPackage() != eClass.getEPackage()){
					continue;
				}
				Set<EClass> registry = mySubTypesMap.get(nextSuper);
				if (registry == null){
					registry = new HashSet<EClass>();
					mySubTypesMap.put(nextSuper, registry);
				}
				registry.add(eClass);
			}
		}
		
		public static EPackageRegistry getUML(){
			if (UML_INSTANCE == null){
				UML_INSTANCE = new EPackageRegistry(UMLPackage.eINSTANCE);
			}
			return UML_INSTANCE;
		}
	}
	
}
