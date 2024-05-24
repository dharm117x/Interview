package com.java.xml;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "name", "date" })
public class Book {
	private Long id;
	private String name;
	private String author;
	private Date date;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(Long id, String name, String author, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.date = date;
	}

	@XmlAttribute
	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "title")
	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", date=" + date + "]";
	}
	
}