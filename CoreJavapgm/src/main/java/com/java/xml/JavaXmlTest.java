package com.java.xml;

import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class JavaXmlTest {
	public static void main(String[] args) throws XPathExpressionException, SAXException, IOException {
		
		Document doc = XMLDomUtility.loadDocument("message.xml");
		NodeList nodeList = XMLDomUtility.getNodeList(doc, "//message/*");
		
		Element p = doc.createElement("newNode"); 
		Text a = doc.createTextNode("value"); 
		p.appendChild(a);
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			node.getParentNode().insertBefore(p, nodeList.item(0));
			
			if(node.getNodeType()== Node.ELEMENT_NODE) {
				Element el = (Element) node;
				System.out.println(el.getTagName());
			}
		}
		update(doc, "s_name");
		create(doc, "one");
		
		XMLDomUtility.print(doc);
	}

	public static void create(Document doc, String node) {
		Element element = doc.getDocumentElement();
		NodeList nodeList = element.getElementsByTagName("message");
		
		if(XMLDomUtility.getNode(doc, node) == null) {
			Element newChild = doc.createElement(node);
			element.appendChild(newChild);
		}
	}

	
	public static void update(Document doc, String el) {
		Node oldNode = XMLDomUtility.getNode(doc, el);
		if(oldNode != null) {
			oldNode.setTextContent("Dkumar Sharma");
		}
	}
	
	
}
