package com.java.xml;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomSaxHandler extends DefaultHandler {
	// Variables needed to store the required information during the parsing of the
	// XML document.
	private final Deque<String> path = new ArrayDeque<>();
	private final StringBuilder currentValue = new StringBuilder();
	private ContextNode currentNode = null;
	private ContextNode rootNode = null;
	private Map<String, String> currentAttributes;
	private final HashMap<String, String> contextHeader = new HashMap<>();

	@Override
	public void startDocument() throws SAXException {
		System.out.println("CustomSaxHandler.startDocument()");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("CustomSaxHandler.endDocument()");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// Put every XML tag within the stack at the beginning of the XML tag.
		path.push(qName);

		// Reset attributes for every element
		currentAttributes = new HashMap<>();

		// Get the path from Deque as / separated values.
		final String p = path();

		// If the XML tag contains the Namespaces or attributes then add to respective
		// Namespaces Map or Attributes Map.
		if (attributes.getLength() > 0) {
			// Loop over every attribute and add them to respective Map.
			for (int att = 0; att < attributes.getLength(); att++) {
				// If the attributes contain the : then consider them as namespaces.
				if (attributes.getQName(att).contains(":") && attributes.getQName(att).startsWith("xmlns:")) {
					contextHeader.put(attributes.getQName(att).substring(attributes.getQName(att).indexOf(":") + 1),
							attributes.getValue(att));
				} else {
					currentAttributes.put(attributes.getQName(att), attributes.getValue(att).trim());
				}
			}
		}

		if (rootNode == null) {
			rootNode = new ContextNode(contextHeader);
			currentNode = rootNode;
			rootNode.children.add(new ContextNode(rootNode, "type", qName));
		} else if (currentNode != null) {
			ContextNode n = new ContextNode(currentNode, qName, (String) null);
			currentNode.children.add(n);
			currentNode = n;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		currentValue.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		try {
			System.out.println("completed reading");
			System.out.println(rootNode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		rootNode = null;
		// At the end of the XML element tag reset the value for next element.
		currentValue.setLength(0);
		// After completing the particular element reading, remove that element from the
		// stack.
		path.pop();
	}

	private String path() {
		return String.join("/", this.path);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		handleError("Error", e);
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		handleError("Fatal", e);
	}

	@Override
	public void warning(SAXParseException e) throws SAXException {
		handleError("warning", e);
	}

	private void handleError(String type, SAXParseException e) {
		String message = String.format("%s: %s as line %d, column %d", type, e.getMessage(), e.getLineNumber(),
				e.getColumnNumber());
		System.out.println(message);
	}
}
