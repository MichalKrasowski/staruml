package org.eclipse.uml2.diagram.common.sheet.chooser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.UMLPackage;


public class UMLContainmentFilter extends ViewerFilter {
	private static MetaclassContainmentFilter TEMPLATE_EXCLUDED;
	private static MetaclassContainmentFilter NOTHING_EXCLUDED;
	
	private Set<EClass> myAllowedMetaclasses;
	
	public UMLContainmentFilter(EReference feature, boolean considerUMLTemplates){
		MetaclassContainmentFilter metaFilter = considerUMLTemplates ? getTemplateAwareInstance() : getWithoutTemplatesInstance();
		myAllowedMetaclasses = metaFilter.getAncestorsOrSelf(feature.getEReferenceType());
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object object) {
		if (false == object instanceof Element){
			return true; //we don't care
		}
		Element umlElement = (Element)object;
		if (umlElement instanceof ElementImport){
			umlElement = ((ElementImport)umlElement).getImportedElement();
		}
		return umlElement != null && myAllowedMetaclasses.contains(umlElement.eClass());
	}

	public static MetaclassContainmentFilter getTemplateAwareInstance(){
		if (NOTHING_EXCLUDED == null){
			NOTHING_EXCLUDED = new MetaclassContainmentFilter(UMLPackage.eINSTANCE, Collections.<EReference>emptyList());
		}
		return NOTHING_EXCLUDED;
	}

	public static MetaclassContainmentFilter getWithoutTemplatesInstance(){
		if (TEMPLATE_EXCLUDED == null){
			UMLPackage UML = UMLPackage.eINSTANCE;
			List<EReference> templateRelated = Arrays.asList(new EReference[] {
					UML.getTemplateableElement_TemplateBinding(), 
					UML.getTemplateSignature_OwnedParameter(),
					UML.getTemplateParameter_OwnedParameteredElement(), 
					UML.getTemplateParameter_OwnedDefault(),
			});
			TEMPLATE_EXCLUDED = new MetaclassContainmentFilter(UML, templateRelated);
		}
		return TEMPLATE_EXCLUDED;
	}
	
}
