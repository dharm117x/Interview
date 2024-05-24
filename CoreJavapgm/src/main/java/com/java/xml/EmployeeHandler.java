package com.java.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeHandler extends DefaultHandler {

	List<Employee> emps;
	Employee emp = null;
	StringBuilder currText = null;

	public List<Employee> getEmps() {
		return emps;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currText = new StringBuilder();
		if (qName.equalsIgnoreCase("employee")) {
			emp = new Employee();
			if (emps == null) {
				emps = new ArrayList<>();
			}
			emp.id = attributes.getValue("id");
			emp.isEmployed = attributes.getValue("is_employed");

		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (emp != null) {
			switch (qName) {
			case "employee":
				emps.add(emp);
				break;
			case "name":
				emp.name = currText.toString();
				break;
			case "email":
				emp.email = currText.toString();
				break;
			case "phone":
				emp.phone = currText.toString();
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		currText.append(new String(ch, start, length));
	}

}
