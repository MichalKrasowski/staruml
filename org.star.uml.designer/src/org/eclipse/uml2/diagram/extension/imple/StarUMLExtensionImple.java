package org.eclipse.uml2.diagram.extension.imple;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.uml2.diagram.common.extension.StarUMLExtension;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class StarUMLExtensionImple implements StarUMLExtension{

	@Override
	public void diagramSave(HashMap map) {
		System.out.println("diagramSave : ");
	}

	@Override
	public void fileSave(HashMap map) {
		System.out.println("fileSave : ");
	}

	@Override
	public void modelAdd(HashMap map) {
		System.out.println("modelAdd : "+map);
		ArrayList newNameList = (ArrayList)map.get(GlobalConstants.NEW_NODE_LIST);
		IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
		Document modelDoc = null;
		try{
			// 파일을 Document로 로드한다.
			String projectPath = rootProject.getLocation().toOSString();
			String modelPath = projectPath+File.separator+"default.uml";
			File xmlFile = new File(modelPath);
	    	StringWriter writer = new StringWriter(); 
			TransformerFactory fac = TransformerFactory.newInstance();
			Transformer x = fac.newTransformer();
			x.transform(new StreamSource(xmlFile), new StreamResult(writer));
			String domStr = writer.toString();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			modelDoc = builder.parse(new InputSource(new StringReader(domStr)));
		}catch(Exception e){
			e.printStackTrace();
		}
		// Document 있는 Element 중  TagName이 "package"를 가져와서 name들을 저장한다.
		NodeList nodeList = modelDoc.getDocumentElement().getElementsByTagName("packagedElement");
		ArrayList newNodeList = new ArrayList();
		for(int i=0; i<nodeList.getLength(); i++){
			String name = nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
			String id = nodeList.item(i).getAttributes().getNamedItem("xmi:id").getNodeValue();
			if(newNameList.contains(name)){
				System.out.println("name :"+name);
				System.out.println("id :"+id);
				ActorCreateAction actorAction = new ActorCreateAction();
			}
		}
	}


}
