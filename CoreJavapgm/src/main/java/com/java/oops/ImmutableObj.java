package com.java.oops;

import java.util.Collections;
import java.util.Date;
import java.util.List;

//Immutable obj Thread safe-once created its state never change
public class ImmutableObj {

	private final String name;
	private final Date dob;
	private final List<String> data;

	public ImmutableObj(String name, Date dob, List<String> data) {
		this.name = name;
		this.dob = dob;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public Date getDob() {
//		return dob;// mutable
		return (Date)dob.clone();
	}

	public List<String> getData() {
//		return data;// mutable
		return Collections.unmodifiableList(data); // can't update throw UnsupportedOperationException
	}

	@Override
	public String toString() {
		return "MyImmutableObj [name=" + name + ", dob=" + dob + ", data=" + data + "]";
	}

}
