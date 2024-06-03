package com.java.xml;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JavaXmlTest {
	public static void main(String[] args) throws XPathExpressionException, SAXException, IOException {

		Document oldDoc = XMLDomUtility.loadDocument("employee2.xml");
		Document xsdDoc = XMLDomUtility.loadDocument("employee.xsd");

		Map<String, List<String>> map = XMLDomUtility.readXsd(xsdDoc);
		List<String> elList = map.get("EL");

		
		String missing= "gender";
		Element missingNode = oldDoc.createElement(missing);
		missingNode.setTextContent("F");
		
		String sibling = findSiblingNode(elList, missing);
		Node siblingNode = XMLDomUtility.getNode(oldDoc, sibling);
		
		NodeList nodeList = XMLDomUtility.getNodeList(oldDoc, "//employee/*");
		
		Node node = XMLDomUtility.getNode(oldDoc, missing);
		if(node ==null) {
			addMissingNode(nodeList, missingNode, siblingNode);
		}
		
		update(oldDoc, "email", "dkumar@gmail.com");
		update(oldDoc, "phone", "11111111111");
		
		XMLDomUtility.print(oldDoc);
	}
	
	private static	String findSiblingNode(List<String> elList, String name) {
		int indexOf = elList.indexOf(name)+1;
		if(indexOf< elList.size())
			return elList.get(indexOf);
		return name;
	}

	private static void addMissingNode(NodeList nodeList, Node missingNode, Node siblingNode) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node.getNodeType()== Node.ELEMENT_NODE) {
				node.getParentNode().insertBefore(missingNode, siblingNode);
			}
		}
	}
	
	public static void update(Document doc, String el, String value) {
		Node oldNode = XMLDomUtility.getNode(doc, el);
		if(oldNode != null) {
			oldNode.setTextContent(value);
		}
	}

}
