package com.java.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLSaxUtility {
	public static void main(String[] args) {
		readXML("employee.xml");
	}

	public static String readXML(String xmlPath) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);

			SAXParser saxParser = factory.newSAXParser();
			//EmployeeHandler handler = new EmployeeHandler();
			CustomSaxHandler handler = new CustomSaxHandler();
			saxParser.parse(new File("src/main/resources/" + xmlPath), handler);

//			handler.getEmps().forEach(c -> {System.out.println(c);});
			return xmlPath;
		} catch (Exception e) {
		}

		return null;
	}

}
