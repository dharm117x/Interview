package com.java.xml;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class XMLJaxbUtility<T> {
	
	public static void marshal(Book book) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Book.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(book, new File("./book.xml"));
	}

	public static Book  unmarshal() throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Book.class);
		return (Book) context.createUnmarshaller().unmarshal(new FileReader("./book.xml"));
	}

}
