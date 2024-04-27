package com.java.xml;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtility {

	public static boolean isValid(String xmlPath, String xsdPath) throws IOException, SAXException {
	    Validator validator = initValidator(xsdPath);
	    try {
	        validator.validate(new StreamSource(getFile(xmlPath)));
	        return true;
	    } catch (SAXException e) {
	        return false;
	    }
	}

	public static Validator initValidator(String xsdPath) throws SAXException {
	    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Source schemaFile = new StreamSource(getFile(xsdPath));
	    Schema schema = factory.newSchema(schemaFile);
	    return schema.newValidator();
	}
	
	public static String readXml(String xmlPath) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
        DocumentBuilder builder = factory.newDocumentBuilder(); 
        // Parse the XML file 
        Document document = builder.parse(getFile(xmlPath)); 
        
        NodeList nodeList = document.getElementsByTagName("person"); 
        for (int i = 0; i < nodeList.getLength(); i++) { 
            Node node = nodeList.item(i); 
            System.out.println("Element Content: " + node.getTextContent()); 
        } 
        
        return document.getTextContent();
	}
	
	public static String prettyFormat(String input, int indent) {
	    try {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        transformerFactory.setAttribute("indent-number", indent);
//	        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//	        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
	        
	        Transformer transformer = transformerFactory.newTransformer(); 
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        Source xmlInput = new StreamSource(getFile(input));
	        StringWriter stringWriter = new StringWriter();
	        StreamResult xmlOutput = new StreamResult(stringWriter);
	        transformer.transform(xmlInput, xmlOutput);
	        
	        return xmlOutput.getWriter().toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e); // simple exception handling, please review it
	    }
	}
	public static File getFile(String location) {
	    return new File(XMLUtility.class.getClassLoader().getResource(location).getFile());
	}
	
}
