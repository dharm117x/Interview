package com.java.xml;

import java.io.IOException;
import java.util.Date;

import jakarta.xml.bind.JAXBException;

public class JaxbXmlTest {
	public static void main(String[] args) throws JAXBException, IOException {
		Book book = new Book();
		book.setId(1L);
		book.setName("Book1");
		book.setAuthor("Author1");
		book.setDate(new Date());
		
		XMLJaxbUtility.marshal(book);
		
		Book book2 = XMLJaxbUtility.unmarshal();
		System.out.println(book2);
	}
	
	
}
