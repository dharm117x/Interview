package com.java.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtility {

	public static boolean isValid(String xmlPath, String xsdPath) throws IOException, SAXException {
		Validator validator = getSchema(xsdPath).newValidator();
		try {
			validator.validate(new StreamSource(getFile(xmlPath)));
			return true;
		} catch (SAXException e) {
			return false;
		}
	}

	public static Schema getSchema(String xsdPath) throws SAXException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		return schemaFactory.newSchema(getFile(xsdPath));
	}

	public static String writeXml(String xmlPath)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Document doc = XMLDomUtility.loadDocument(xmlPath);
		Element rootElement = doc.createElement("company");
		doc.appendChild(rootElement);

		Element staff = doc.createElement("staff");
		staff.setAttribute("id", "1001");
		staff.setTextContent("Dkumar");
		rootElement.appendChild(staff);

		NodeList nodeList = doc.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println("Element Content: " + node.getTextContent());
		}

		return doc.getTextContent();
	}

	public static File getFile(String location) {
		return new File(XMLUtility.class.getClassLoader().getResource(location).getFile());
	}

}
