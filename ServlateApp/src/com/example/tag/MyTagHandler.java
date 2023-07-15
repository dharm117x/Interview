package com.example.tag;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

public class MyTagHandler extends TagSupport implements DynamicAttributes, TryCatchFinally {

	private static final long serialVersionUID = 1L;

	private String item;
	private Map<String, Object> dynamicAttributes = new HashMap<>();;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();// returns the instance of JspWriter
		try {
			LocalDateTime dateTime = LocalDateTime.now();
			out.println("Start body");
			out.print("<br>Current Time :: " + dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));// printing
			out.print("<br>New Page Item :: " + item);
			out.println("<br>"+dynamicAttributes);
		} catch (Exception e) {
			System.out.println(e);
		}
		return SKIP_BODY;
	}

	@Override
	public int doAfterBody() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<br>After body");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<br>End body");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	
	@Override
	public void doCatch(Throwable arg0) throws Throwable {
		System.out.println("MyTagHandler.doCatch()");
	}

	@Override
	public void doFinally() {
		System.out.println("MyTagHandler.doFinally()");
	}

	@Override
	public void setDynamicAttribute(String arg0, String arg1, Object arg2) throws JspException {
		dynamicAttributes.put(arg1, arg2);
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Map<String, Object> getDynamicAttributes() {
		return dynamicAttributes;
	}

	public void setDynamicAttributes(Map<String, Object> dynamicAttributes) {
		this.dynamicAttributes = dynamicAttributes;
	}

	
}
