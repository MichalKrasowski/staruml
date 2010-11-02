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
import org.star.uml.designer.ui.diagram.action.ModelCreateAction;
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
	public void modelAdd(HashMap requestMap) {
		try{
		ModelCreateAction modelCreateAction = new ModelCreateAction();
		modelCreateAction.setRequestMap(requestMap);
		modelCreateAction.run();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
