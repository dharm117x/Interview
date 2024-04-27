package com.java.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class JavaXmlTest {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		//System.out.println(XMLUtility.readXml("person.xml"));
		
		System.out.println(XMLUtility.prettyFormat("person.xml", 2));
		
		listParsingExceptions("full-person.xsd", "person.xml");
	}

	public static List<SAXParseException> listParsingExceptions(String xsdPath, String xmlPath)
			throws IOException, SAXException {
		XmlErrorHandler xsdErrorHandler = new XmlErrorHandler();
		Validator validator = XMLUtility.initValidator(xsdPath);
		validator.setErrorHandler(xsdErrorHandler);
		validator.validate(new StreamSource(XMLUtility.getFile(xmlPath)));
		
		xsdErrorHandler.getExceptions()
				.forEach(e -> System.out.println(String.format("Line number: %s, Column number: %s. %s",
						e.getLineNumber(), e.getColumnNumber(), e.getMessage())));

		return xsdErrorHandler.getExceptions();
	}
}
