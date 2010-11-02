package org.eclipse.uml2.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.uml2.diagram.common.links.PortOperationsExt;
import org.eclipse.uml2.diagram.common.links.ProvidedInterfaceLink;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

public class ProvidedPortLinkHelper {

	private final EObject mySource;

	private final EObject myTarget;

	public ProvidedPortLinkHelper(AdapterFactoryEditingDomain editingDomain, EObject source, EObject target) {
		mySource = source;
		myTarget = target;
	}

	public void create() {
		Port port = getSource();
		Interface targetInterface = getTarget();
		if (port == null || targetInterface == null) {
			return;
		}
		//we can not modify derived Port#getProvideds() directly,
		//so we will mimic the logic from the PortOperations#getProvideds()
		Type portType = port.getType();
		if (portType == null) {
			port.setType(targetInterface);
			return;
		} 
		if (portType instanceof Classifier) {
			//then it is new Realization for this classifier
			createRealization(port, targetInterface, (Classifier) portType);
		}
		return;
	}
	
	public boolean canCreate() {
		return true;
	}

	public void reorientSource(Port newSource) {
		ProvidedInterfaceLink realization;
		//delete the old link
		if (getTarget().equals(getSource().getType())) {
			getSource().setType(null);
			realization = null;
		} else {
			realization = PortOperationsExt.getProvideds(getSource(), getTarget());
			realization.getRealization().getClients().remove(realization.getSource());
			// if we will not create a link, but just set type, we remove obsolete link
			Type portType = newSource.getType();
			if (portType == null) {
				realization.getRealization().getSuppliers().remove(getTarget());
				if (realization.getRealization().getSuppliers().isEmpty() && realization.getRealization().getClients().isEmpty()) {
					realization.getRealization().destroy();
				}
			} 
		}
		//create a new link
		Type portType = newSource.getType();
		if (portType == null) {
			newSource.setType(getTarget());
			return;
		} 
		if (portType instanceof Classifier) {
			//create new Realization for the classifier
			if (realization == null) {
				createRealization(newSource, getTarget(), (Classifier)portType);
			} else {
				realization.getRealization().getClients().add((Classifier) portType);
			}
		}
	}

	public boolean canReorientSource(Port newSource) {
		return true;
	}
	
	public void reorientTarget(Interface newTarget) {
		Port port = getSource();
		// if old provided interface was described by port type, then we change port type 
		Classifier portType = (Classifier) port.getType();
		if (getTarget().equals(portType)) {
			port.setType(newTarget);
			return ;
		}
		// if old provided interface was described by realization link, then we change target of the link 
		InterfaceRealization dependency = PortOperationsExt.getProvideds(port, getTarget()).getRealization();
		dependency.getSuppliers().remove(getTarget());
		dependency.getSuppliers().add(newTarget);
	}

	public boolean canReorientTarget(Interface newTarget) {
		return true;
	}

	private Realization createRealization(Port port, Interface targetInterface, Classifier portType) {
		Package realizationContainer = null;
		for (EObject element = getSource(); element != null; element = element.eContainer()) {
			if (element instanceof Package) {
				realizationContainer = (Package) element;
				break;
			}
		}
		if (realizationContainer == null) {
			return null;
		}
		Realization realization = UMLFactory.eINSTANCE.createInterfaceRealization();
		realizationContainer.getPackagedElements().add(realization);
		realization.getClients().add(portType);
		realization.getSuppliers().add(targetInterface);
		return realization;
	}

	private Port getSource() {
		return (Port)mySource;
	}

	private Interface getTarget() {
		return (Interface)myTarget;
	}

}
