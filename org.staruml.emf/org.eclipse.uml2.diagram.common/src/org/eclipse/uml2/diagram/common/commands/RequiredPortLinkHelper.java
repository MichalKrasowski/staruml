package org.eclipse.uml2.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.uml2.diagram.common.links.PortOperationsExt;
import org.eclipse.uml2.diagram.common.links.RequiredInterfaceLink;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

public class RequiredPortLinkHelper {
	
	private final AdapterFactoryEditingDomain myEditingDomain;
	private final EObject mySource;
	private final EObject myTarget;
	
	public RequiredPortLinkHelper(AdapterFactoryEditingDomain editingDomain, EObject source, EObject target) {
		myEditingDomain = editingDomain;
		mySource = source;
		myTarget = target;
	}

	public void create() {
		if (getSource() == null || getTarget() == null || getSource().getType() == null) {
			return;
		}
		Type type = getSource().getType();
		if (type instanceof Classifier && !(type instanceof Interface)) {
			Classifier classifier = (Classifier) type;
			classifier.createUsage(getTarget());
		}
	}
	
	public boolean canCreate() {
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		Type type = getSource().getType();
		if (type == null) {
			return false;
		}
		if (false == type instanceof Classifier || (type instanceof Interface)) {
			return false;
		}
		boolean isReadOnly = myEditingDomain.isReadOnly(type.eResource());
		return !isReadOnly;
	}
	
	public void reorientSource(Port newSource) {
		RequiredInterfaceLink link = PortOperationsExt.getRequireds(getSource(), getTarget());
		link.getLink().getClients().remove(link.getSource());
		link.getLink().getClients().add(newSource.getType());
	}

	public boolean canReorientSource(Port newSource) {
		Type type = newSource.getType();
		return (type != null) && (type instanceof Classifier) && (false == type instanceof Interface);
	}
	
	public void reorientTarget(Interface newTarget) {
		RequiredInterfaceLink link = PortOperationsExt.getRequireds(getSource(), getTarget());
		link.getLink().getSuppliers().remove(link.getTarget());
		link.getLink().getSuppliers().add(newTarget);
	}

	public boolean canReorientTarget(Interface newTarget) {
		return true;
	}
	
	private Port getSource() {
		return (Port)mySource;
	}
	
	private Interface getTarget() {
		return (Interface)myTarget;
	}
		
}
