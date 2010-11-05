package org.star.uml.designer.ui.model.initialization;

public class DefaultConnection {
static String xmlStr;
	
	public static String getXML(){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		xmlBuffer.append("    <ConnectionRoot xmlns:sobis=\"http://sobis.enkisoft.co.kr\" targetNamespace=\"http://sobis.enkisoft.co.kr\">");
		xmlBuffer.append("        <DatabaseConnections>");
		xmlBuffer.append("        </DatabaseConnections>");
		xmlBuffer.append("    </ConnectionRoot>");
		xmlStr = xmlBuffer.toString();
		return xmlStr;
	}
}
