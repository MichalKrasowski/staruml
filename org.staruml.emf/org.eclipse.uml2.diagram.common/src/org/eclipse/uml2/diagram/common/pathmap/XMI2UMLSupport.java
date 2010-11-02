package org.eclipse.uml2.diagram.common.pathmap;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.resource.CMOF2UMLExtendedMetaData;
import org.eclipse.uml2.uml.resource.CMOF2UMLResource;
import org.eclipse.uml2.uml.resource.UML212UMLResource;
import org.eclipse.uml2.uml.resource.UML22UMLExtendedMetaData;
import org.eclipse.uml2.uml.resource.UML22UMLResource;
import org.eclipse.uml2.uml.resource.XMI212UMLResource;
import org.eclipse.uml2.uml.resource.XMI2UMLExtendedMetaData;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;

public class XMI2UMLSupport {

	public static void enableXMI2UMLSupport(ResourceSet resourceSet) {
		Map<String, Object> contentTypeToFactoryMap = resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap();

		contentTypeToFactoryMap.put(UML22UMLResource.UML2_CONTENT_TYPE_IDENTIFIER, UML22UMLResource.Factory.INSTANCE);
		contentTypeToFactoryMap.put(UML212UMLResource.UML_2_1_0_CONTENT_TYPE_IDENTIFIER, UML212UMLResource.Factory.INSTANCE);
		contentTypeToFactoryMap.put(XMI2UMLResource.UML_CONTENT_TYPE_IDENTIFIER, XMI2UMLResource.Factory.INSTANCE);
		contentTypeToFactoryMap.put(XMI212UMLResource.UML_2_1_1_CONTENT_TYPE_IDENTIFIER, XMI212UMLResource.Factory.INSTANCE);
		contentTypeToFactoryMap.put(XMI212UMLResource.UML_2_1_CONTENT_TYPE_IDENTIFIER, XMI212UMLResource.Factory.INSTANCE);
		contentTypeToFactoryMap.put(CMOF2UMLResource.CMOF_CONTENT_TYPE_IDENTIFIER, CMOF2UMLResource.Factory.INSTANCE);

		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();

		uriMap.putAll(UML22UMLExtendedMetaData.getURIMap());
		uriMap.putAll(XMI2UMLExtendedMetaData.getURIMap());
		uriMap.putAll(CMOF2UMLExtendedMetaData.getURIMap());

	}

}
