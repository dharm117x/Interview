package com.java.xml;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class JavaXsltTest {
	public static void main(String[] args) {
		Source xmlSource = new StreamSource("src/main/resources/employee.xml");
		Source xsltSource = new StreamSource("src/main/resources/employee.xslt");

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer(xsltSource);
			StreamResult result = new StreamResult("output.html");
			transformer.transform(xmlSource, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		System.out.println("XSLT transformation completed successfully.");
	}
}
