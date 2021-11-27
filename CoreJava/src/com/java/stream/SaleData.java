package com.java.stream;

public class SaleData {
	String month;
	Double amt;
	
	public SaleData(String month, Double amt) {
		this.month = month;
		this.amt = amt;
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
		return "SaleData [month=" + month + ", amt=" + amt + "]";
	}


	
	
}
