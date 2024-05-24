package com.java.xml;

import java.util.ArrayList;
import java.util.Map;

public class ContextNode {
	protected String name;
	protected String value;
	protected ArrayList<ContextNode> attributes = new ArrayList<>();
	protected ArrayList<ContextNode> children = new ArrayList<>();
	protected ContextNode parent;
	protected Map<String, String> namespaces;

	public ContextNode(final ContextNode parent, final String name, final String value) {
		this.parent = parent;
		this.name = name;
		this.value = value;
		this.namespaces = parent.namespaces;
	}

	public ContextNode(final Map<String, String> namespaces) {
		this.namespaces = namespaces;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArrayList<ContextNode> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<ContextNode> attributes) {
		this.attributes = attributes;
	}

	public ArrayList<ContextNode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<ContextNode> children) {
		this.children = children;
	}

	public ContextNode getParent() {
		return parent;
	}

	public void setParent(ContextNode parent) {
		this.parent = parent;
	}

	public Map<String, String> getNamespaces() {
		return namespaces;
	}

	public void setNamespaces(Map<String, String> namespaces) {
		this.namespaces = namespaces;
	}

}
