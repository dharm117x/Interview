package com.java.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.collections4.map.HashedMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;

public class XMLDomUtility {

	public static Document loadDocument(String filename) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new File("src/main/resources/"+filename));
			doc.getDocumentElement().normalize();
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, List<String>> readXsd(Document document) {
		Map<String, List<String>> map = new HashedMap<>();
		List<String> els= new ArrayList<>();
		List<String> atts= new ArrayList<>();

		try {
			NodeList list = document.getElementsByTagName("xs:element");
			// loop to print data
			for (int i = 0; i < list.getLength(); i++) {
				Element el = (Element) list.item(i);
				els.add(el.getNodeName());
				if (el.hasAttributes()) {
					String name = el.getAttribute("name");
					String type = el.getAttribute("type");
					System.out.println(name + "-----" + type);
				}
			}
			
			NodeList list1 = document.getElementsByTagName("xs:attribute");
			// loop to print data
			for (int i = 0; i < list1.getLength(); i++) {
				Element el = (Element) list1.item(i);
				atts.add(el.getNodeName());
				if (el.hasAttributes()) {
					String name = el.getAttribute("name");
					String type = el.getAttribute("type");
					System.out.println(name + "-----" + type);
				}
			}
			
			map.put("EL", els);
			map.put("AT", atts);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}

	public static String readXml(Document document) {
		try {
			NodeList nodeList = document.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.hasAttributes()) {
					System.out.println("Node name::" + node.getNodeName());
					NamedNodeMap attributes = node.getAttributes();
					for (int j = 0; j < attributes.getLength(); j++) {
						if (attributes.item(j) != null)
							System.out.println(
									attributes.item(j).getNodeName() + "--" + attributes.item(j).getNodeValue());
					}
				}
				System.out.println(node.getNodeName() + "--" + node.getTextContent());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return document.getTextContent();
	}

	public static void createXml(Document doc, String fileName) {
		try (FileOutputStream output = new FileOutputStream(fileName)) {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(output);

			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void print(Document doc) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", 1);
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			transformer.transform(new DOMSource(doc), xmlOutput);
			System.out.println(xmlOutput.getWriter());
		} catch (Exception e) {
			throw new RuntimeException(e); // simple exception handling, please review it
		}
	}

	public static List<SAXParseException> listParsingExceptions(String xsdPath, Document doc) {
		XmlErrorHandler xsdErrorHandler = new XmlErrorHandler();
		try {
			Validator validator = XMLUtility.getSchema(xsdPath).newValidator();
			validator.setErrorHandler(xsdErrorHandler);
			validator.validate(new DOMSource(doc));

			xsdErrorHandler.getExceptions()
					.forEach(e -> System.out.println(String.format("Line number: %s, Column number: %s. %s",
							e.getLineNumber(), e.getColumnNumber(), e.getMessage())));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return xsdErrorHandler.getExceptions();
	}
	
	public static NodeList getNodeList(Document doc, String expression) {
		try {
			XPath xPath = XPathFactory.newInstance().newXPath();
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			return nodeList;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Node getNode(Document doc, String expression) {
		try {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node node = (Node) xPath.compile("//"+expression).evaluate(doc, XPathConstants.NODE);
			return node;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
