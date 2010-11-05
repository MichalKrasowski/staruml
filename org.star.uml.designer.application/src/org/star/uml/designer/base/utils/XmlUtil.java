package org.star.uml.designer.base.utils;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.*;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlUtil {
	/**
     * XML 파일 경로를 넘기고 XML 파일을 String 변환한다.
     * @param filePath
     * @return
     * @throws TransformerException
     */
    public static String getXmlFileToString(String filePath) throws TransformerException{
    	File xmlFile = new File(filePath);
    	StringWriter writer = new StringWriter(); 
		TransformerFactory fac = TransformerFactory.newInstance();
		Transformer x = fac.newTransformer();
		x.transform(new StreamSource(xmlFile), new StreamResult(writer));
		return writer.toString();
    }
    
    /**
     * XML String을 Document 객체로 변환한다.
     * @param filePath
     * @return
     * @throws TransformerException
     * @throws ParserConfigurationException 
     * @throws IOException 
     * @throws SAXException 
     */
    public static Document getStringToDocument(String xml) throws TransformerException, ParserConfigurationException, SAXException, IOException{
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(xml)));
		return document;
    }
    
    /**
     * Document를 파일에 저장한다.
     * @param doc
     * @param filename
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerException
     */
    public static void writeXmlFile(Document doc, String fileFullPath) throws TransformerFactoryConfigurationError, TransformerException {
        Source source = new DOMSource(doc);
        File file = new File(fileFullPath);
        Result result = new StreamResult(file);
        Transformer xformer = TransformerFactory.newInstance().newTransformer();
        xformer.transform(source, result);
    }

}