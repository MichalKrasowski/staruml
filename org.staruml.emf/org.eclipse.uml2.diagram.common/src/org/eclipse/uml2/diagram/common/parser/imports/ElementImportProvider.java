package org.eclipse.uml2.diagram.common.parser.imports;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.diagram.common.parser.ElementProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.resource.UMLResource;

public class ElementImportProvider extends ElementProvider {
	private org.eclipse.uml2.uml.Package myContextPackage;
	
	public ElementImportProvider(){
		super();
	}
	
	@Override
	protected List<NamedElement> loadAllElements(ResourceSet resourceSet) {
		preloadLibraries(resourceSet);
		return super.loadAllElements(resourceSet);
	}
	
	@Override
	protected void setContext(EObject context) {
		myContextPackage = null;
		if (context instanceof Element){
			Element element = (Element)context;
			myContextPackage = element.getNearestPackage();
		}
		super.setContext(context);
	}
	
	@Override
	protected String getDisplayProposal(NamedElement element) {
		String result = element.getQualifiedName();
		if (result == null || result.length() == 0){
			result = element.getName();
		}
		return result;
	}
	
	@Override
	protected boolean isSuitable(Object object) {
		if (!super.isSuitable(object)){
			return false;
		}
		PackageableElement next = (PackageableElement)object;
		if (false == next instanceof org.eclipse.uml2.uml.Classifier){
			return false;
		}
		
		//not usefull to add imports to associations and other similar constructs 
		if (next instanceof Relationship){
			return false;
		}
		
		//for now, expliciltly remove metaclasses, too many of them and they seems to be not usefull here
		if (next instanceof org.eclipse.uml2.uml.Class && ((org.eclipse.uml2.uml.Class)next).isMetaclass()){
			return false;
		}
		org.eclipse.uml2.uml.Package pakkage = next.getNearestPackage();
		return pakkage != null && pakkage != myContextPackage;
	}
	
	private void preloadLibraries(ResourceSet resourceSet) {
		resourceSet.getResource(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), true);
	}
	
}
