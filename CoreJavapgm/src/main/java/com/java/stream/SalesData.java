package com.java.stream;

public class SalesData {
	String cat;
	String month;
	Double amt;

	public SalesData() {
	}
	
	public SalesData(String month, Double amt) {
		this.month = month;
		this.amt = amt;
	}

	public SalesData(String cat, String month, Double amt) {
		this.cat = cat;
		this.month = month;
		this.amt = amt;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "SalesData [cat=" + cat + ", month=" + month + ", amt=" + amt + "]";
	}
	
}
