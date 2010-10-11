package org.star.uml.designer.ui.model.initialization;

public class DefaultUML {
static String xmlStr;
	
	public static String getXML(){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		xmlBuffer.append("<uml:Package xmi:version=\"2.1\"");
		xmlBuffer.append("     xmlns:xmi=\"http://schema.omg.org/spec/XMI/2.1\" xmlns:uml=\"http://www.eclipse.org/uml2/3.0.0/UML\"");
		xmlBuffer.append("     xmi:id=\"_M9Rvgcu6Ed-CT5UkFwpzXA\" name=\"default\"");
		xmlBuffer.append("     xmlns:star=\"http://startuml.co.kr/startuml\">");
		xmlBuffer.append("     <elementImport xmi:id=\"_M_6MwMu6Ed-CT5UkFwpzXA\">");
		xmlBuffer.append("             <importedElement xmi:type=\"uml:PrimitiveType\"");
		xmlBuffer.append("                     href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#Boolean\"/>");
		xmlBuffer.append("     </elementImport>");
		xmlBuffer.append("     <elementImport xmi:id=\"_NAD9wMu6Ed-CT5UkFwpzXA\">");
		xmlBuffer.append("             <importedElement xmi:type=\"uml:PrimitiveType\"");
		xmlBuffer.append("                     href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#String\"/>");
		xmlBuffer.append("     </elementImport>");
		xmlBuffer.append("     <elementImport xmi:id=\"_NAD9wcu6Ed-CT5UkFwpzXA\">");
		xmlBuffer.append("             <importedElement xmi:type=\"uml:PrimitiveType\"");
		xmlBuffer.append("                     href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#UnlimitedNatural\"/>");
		xmlBuffer.append("     </elementImport>");
		xmlBuffer.append("     <elementImport xmi:id=\"_NAEk0Mu6Ed-CT5UkFwpzXA\">");
		xmlBuffer.append("             <importedElement xmi:type=\"uml:PrimitiveType\"");
		xmlBuffer.append("                     href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#Integer\"/>");
		xmlBuffer.append("     </elementImport>");
		xmlBuffer.append("</uml:Package>");
		xmlStr = xmlBuffer.toString();
		return xmlStr;
	}
}
