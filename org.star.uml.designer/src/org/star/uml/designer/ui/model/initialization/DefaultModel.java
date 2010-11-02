package org.star.uml.designer.ui.model.initialization;

public class DefaultModel {
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
		xmlBuffer.append("	   <packagedElement xmi:type=\"uml:Package\" xmi:id=\"_VviQ8M3LEd-GMK-em0Iv_Q\"");
		xmlBuffer.append("	           name=\"Default Approach\" star:category=\"pkgRoot\">");
		xmlBuffer.append("             <packagedElement xmi:type=\"uml:Package\" xmi:id=\"_ZV8W8M3LEd-GMK-em0Iv_Q\"");
		xmlBuffer.append("                     name=\"&lt;&lt;analysisModel>>Analysis Model\" star:category=\"rootModel\">");
//		xmlBuffer.append("                     <packagedElement xmi:type=\"uml:Package\" xmi:id=\"_Q_0kEM3MEd-GMK-em0Iv_Q\"");
//		xmlBuffer.append("                             name=\"Sequence Diagram\"/>");
//		xmlBuffer.append("                     <packagedElement xmi:type=\"uml:Package\" xmi:id=\"_SbvvgM3MEd-GMK-em0Iv_Q\"");
//		xmlBuffer.append("                             name=\"Userecase Diagram\"/>");
		xmlBuffer.append("    		   </packagedElement>");
		xmlBuffer.append("	   		   <packagedElement xmi:type=\"uml:Package\" xmi:id=\"_t1wDAM3LEd-GMK-em0Iv_Q\"");
		xmlBuffer.append("	           		   name=\"&lt;&lt;designModel>>Design Model\" star:category=\"rootModel\">");
		xmlBuffer.append("     		   </packagedElement>");
		xmlBuffer.append("	   		   <packagedElement xmi:type=\"uml:Package\" xmi:id=\"_vq0uQM3LEd-GMK-em0Iv_Q\"");
		xmlBuffer.append("	           	       name=\"&lt;&lt;implementationModel>>Implementation Model\" star:category=\"rootModel\">");
//		xmlBuffer.append("	           <packagedElement xmi:type=\"uml:Package\" xmi:id=\"_a0VLEM3MEd-GMK-em0Iv_Q\"");
//		xmlBuffer.append("	                   name=\"Class Diagram\" />");
		xmlBuffer.append("     		   </packagedElement>");
		xmlBuffer.append("	   		   <packagedElement xmi:type=\"uml:Package\" xmi:id=\"_rKc6YM3LEd-GMK-em0Iv_Q\"");
		xmlBuffer.append("	          		   name=\"&lt;&lt;deploymentModel>>Deployment Model\" star:category=\"rootModel\">");
		xmlBuffer.append("     		   </packagedElement>");
		xmlBuffer.append("     </packagedElement>");
		xmlBuffer.append("</uml:Package>");
		xmlStr = xmlBuffer.toString();
		return xmlStr;
	}
}
