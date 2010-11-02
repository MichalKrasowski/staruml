package org.eclipse.uml2.diagram.common.editpolicies;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;


public class UpdateDescriptionRequest extends Request {
	public static final Object TYPE = new Object();
	private final List<Descriptor> myDescriptions;
	
	public UpdateDescriptionRequest(){
		super(TYPE);	
		myDescriptions = new LinkedList<Descriptor>();
	}
	
	public Descriptor registerDescription(IGraphicalEditPart provider, boolean registerSemanticElement){
		Descriptor result = new Descriptor(provider, registerSemanticElement ? provider.resolveSemanticElement() : null);
		myDescriptions.add(result);
		return result;
	}
	
	public List<Descriptor> getDescriptions() {
		return Collections.unmodifiableList(myDescriptions);
	}
	
	public static class Descriptor {
		private final IGraphicalEditPart myProvider;
		private final EObject mySemanticElement;
		private final List<IUpdaterNodeDescriptor> myContainedChildren;
		private final List<IUpdaterLinkDescriptor> myOutgoingLinks;
		private final List<IUpdaterLinkDescriptor> myContainedLinks;

		private Descriptor(IGraphicalEditPart provider, EObject semanticElement){
			myProvider = provider;
			mySemanticElement = semanticElement;
			myContainedChildren = new LinkedList<IUpdaterNodeDescriptor>();
			myOutgoingLinks = new LinkedList<IUpdaterLinkDescriptor>();
			myContainedLinks = new LinkedList<IUpdaterLinkDescriptor>();
		}
		
		public EObject getSemanticElement() {
			return mySemanticElement;
		}
		
		public void addContainedChildren(Collection<?> children){
			for (Object next : children){
				if (next instanceof IUpdaterNodeDescriptor){
					myContainedChildren.add((IUpdaterNodeDescriptor)next);	
				}
			}
		}
		
		public void addContainedLinks(Collection<?> links){
			for (Object next : links){
				if (next instanceof IUpdaterLinkDescriptor){
					myContainedLinks.add((IUpdaterLinkDescriptor)next);	
				}
			}
		}
	
		public void addOutgoingLinks(Collection<?> links){
			for (Object next : links){
				if (next instanceof IUpdaterLinkDescriptor){
					myOutgoingLinks.add((IUpdaterLinkDescriptor)next);	
				}
			}
		}
		
		public boolean isEmpty(){
			return myContainedChildren.isEmpty() && myContainedLinks.isEmpty() && myOutgoingLinks.isEmpty();
		}
		
		public List<IUpdaterNodeDescriptor> getContainedChildren() {
			return Collections.unmodifiableList(myContainedChildren);
		}
		
		public List<IUpdaterLinkDescriptor> getContainedLinks() {
			return Collections.unmodifiableList(myContainedLinks);
		}
		
		public List<IUpdaterLinkDescriptor> getOutgoingLinks() {
			return Collections.unmodifiableList(myOutgoingLinks);
		}
		
		public IGraphicalEditPart getProvider() {
			return myProvider;
		}
		
	}
}
