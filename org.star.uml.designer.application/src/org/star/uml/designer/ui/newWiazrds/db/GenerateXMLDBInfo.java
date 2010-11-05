package org.star.uml.designer.ui.newWiazrds.db;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.star.uml.designer.base.utils.XmlUtil;
import org.star.uml.designer.ui.model.initialization.DefaultConnection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GenerateXMLDBInfo {
	File file = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + "/xml/connection.xml");
	public void addConnection(String ConnectionName, String ConnectionType,
		String UserName, String Password, String Driver, String HostName,
		String JDBCPort, String SID, String ServiceName,
		String ConnectionUrl, String DriverClass, String DatabaseType) {
	
		try{
			if(!file.isFile()){
				file.getParentFile().mkdirs();
				file.createNewFile();
				Document doc = XmlUtil.getStringToDocument(DefaultConnection.getXML());
				XmlUtil.writeXmlFile(doc, file.getPath());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Document document = getDocumnetByFile(file);

		Element connectionEL = document.createElement("Connection");
		Element ConnectionNameEL = document.createElement("ConnectionName");
		Element ConnectionTypeEL = document.createElement("ConnectionType");
		Element DatabaseTypeEL = document.createElement("DatabaseType");
		Element ConnectionUrlEL = document.createElement("ConnectionUrl");
		Element UserNameEL = document.createElement("UserName");
		Element PasswordEL = document.createElement("Password");
		Element DriverEL = document.createElement("Driver");
		Element DriverClassEL = document.createElement("DriverClass");
		Element HostNameEL = document.createElement("HostName");
		Element JDBCPortEL = document.createElement("JDBCPort");
		Element SIDEL = document.createElement("SID");
		Element ServiceNameEL = document.createElement("ServiceName");

		ConnectionNameEL.setTextContent(ConnectionName);
		ConnectionTypeEL.setTextContent(ConnectionType);
		DatabaseTypeEL.setTextContent(DatabaseType);
		ConnectionUrlEL.setTextContent(ConnectionUrl);
		UserNameEL.setTextContent(UserName);
		PasswordEL.setTextContent(Password);
		DriverEL.setTextContent(Driver);
		DriverClassEL.setTextContent(DriverClass);
		HostNameEL.setTextContent(HostName);
		JDBCPortEL.setTextContent(JDBCPort);
		SIDEL.setTextContent(SID);
		ServiceNameEL.setTextContent(ServiceName);

		connectionEL.appendChild(ConnectionNameEL);
		connectionEL.appendChild(ConnectionTypeEL);
		connectionEL.appendChild(DatabaseTypeEL);
		connectionEL.appendChild(ConnectionUrlEL);
		connectionEL.appendChild(ConnectionTypeEL);
		connectionEL.appendChild(UserNameEL);
		connectionEL.appendChild(PasswordEL);
		connectionEL.appendChild(DriverEL);
		connectionEL.appendChild(DriverClassEL);
		connectionEL.appendChild(HostNameEL);
		connectionEL.appendChild(JDBCPortEL);
		connectionEL.appendChild(SIDEL);
		connectionEL.appendChild(ServiceNameEL);

		Node ConnectionsEL = document.getElementsByTagName(
				"DatabaseConnections").item(0);
		ConnectionsEL.appendChild(connectionEL);
		
		// Transformer를 통해 XML을 저장한다.
		Source domSource = new DOMSource(document);
		Result result = new StreamResult(file);
		try{
			Transformer xformer = TransformerFactory.newInstance()
					.newTransformer();
			xformer.transform(domSource, result);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public Map<String, Object> getConnections() {
		
		

		
		Document document = null;
		if(file.isFile()){
			document = getDocumnetByFile(file);
		}else{
			try{
				file.getParentFile().mkdirs();
				file.createNewFile();
				Document doc = XmlUtil.getStringToDocument(DefaultConnection.getXML());
				XmlUtil.writeXmlFile(doc, file.getPath());
				document = getDocumnetByFile(file);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		Node database = document.getElementsByTagName("DatabaseConnections").item(0);
				
		
		NodeList connectionNodes = database.getChildNodes();

		List<String> connList = new ArrayList<String>();
		Map<String, Object> conectionMain = new HashMap<String, Object>();
		Map<String, Map<String, String>> conectionList = new HashMap<String, Map<String, String>>();

		for (int i = 0; i < connectionNodes.getLength(); i++) {

			if (connectionNodes.item(i).getNodeName().equals("Connection")) {

				Map<String, String> contents = new HashMap<String, String>();

				Element ConnectionEL = (Element) connectionNodes.item(i);
				Element ConnectionNameEL = (Element) ConnectionEL
						.getElementsByTagName("ConnectionName").item(0);
				Element DatabaseTypeEL = (Element) ConnectionEL
						.getElementsByTagName("DatabaseType").item(0);
				Element ConnectionUrlEL = (Element) ConnectionEL
						.getElementsByTagName("ConnectionUrl").item(0);
				Element ConnectionTypeEL = (Element) ConnectionEL
						.getElementsByTagName("ConnectionType").item(0);
				Element UserNameEL = (Element) ConnectionEL
						.getElementsByTagName("UserName").item(0);
				Element PasswordEL = (Element) ConnectionEL
						.getElementsByTagName("Password").item(0);
				Element DriverEL = (Element) ConnectionEL.getElementsByTagName(
						"Driver").item(0);
				Element DriverClassEL = (Element) ConnectionEL
						.getElementsByTagName("DriverClass").item(0);
				Element HostNameEL = (Element) ConnectionEL
						.getElementsByTagName("HostName").item(0);
				Element JDBCPortEL = (Element) ConnectionEL
						.getElementsByTagName("JDBCPort").item(0);
				Element SIDEL = (Element) ConnectionEL.getElementsByTagName(
						"SID").item(0);
				Element ServiceNameEL = (Element) ConnectionEL
						.getElementsByTagName("ServiceName").item(0);

				if (ConnectionNameEL == null || DatabaseTypeEL == null
						|| ConnectionTypeEL == null || ConnectionUrlEL == null
						|| UserNameEL == null || PasswordEL == null
						|| DriverEL == null || DriverClassEL == null
						|| HostNameEL == null || JDBCPortEL == null) {

					continue;

				}

				contents.put("ConnectionName", ConnectionNameEL
						.getTextContent());
				contents.put("DatabaseType", DatabaseTypeEL.getTextContent());
				contents.put("ConnectionUrl", ConnectionUrlEL.getTextContent());
				contents.put("ConnectionType", ConnectionTypeEL
						.getTextContent());
				contents.put("UserName", UserNameEL.getTextContent());
				contents.put("Password", PasswordEL.getTextContent());
				contents.put("Driver", DriverEL.getTextContent());
				contents.put("DriverClass", DriverClassEL.getTextContent());
				contents.put("HostName", HostNameEL.getTextContent());
				contents.put("JDBCPort", JDBCPortEL.getTextContent());
				contents.put("SID", (SIDEL.getTextContent() == null) ? ""
						: SIDEL.getTextContent());
				contents.put("ServiceName",
						(ServiceNameEL.getTextContent() == null) ? ""
								: ServiceNameEL.getTextContent());

				conectionList.put(ConnectionNameEL.getTextContent(), contents);
				connList.add(ConnectionNameEL.getTextContent());
			}
		}

		conectionMain.put("ConnectionName", connList);
		conectionMain.put("ConnectionList", conectionList);

		return conectionMain;
	}

	public Document getDocumnetByURL(URL fileURL) {
		Document document = null;
		InputStream inputStream = null;
		
		try {
			// XML 사용을 위해 Factory , Builder 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Eclipse에서 커낵션 정보가 들어있는 Plug-in ID를 BundleUtility를 통해 경로를 가져돈다.
			inputStream = fileURL.openStream();
			InputSource src = new InputSource(fileURL.openStream());
			document = builder.parse(src);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return document;
	}
	
	
	public Document getDocumnetByFile(File file) {
		
		Document document = null;
		
		try {
			// XML 사용을 위해 Factory , Builder 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Eclipse에서 커낵션 정보가 들어있는 Plug-in ID를 BundleUtility를 통해 경로를 가져돈다.
			document = builder.parse(file);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return document;
	}

}
