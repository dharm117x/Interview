package com.java.scjp;

public enum Title {
	MR("Mr"), MS("Ms");

	private final String t;

	Title(String s) {
		this.t = s;
	}

	public String format(String f, String l) {
		return t + " " + f + " " + l;
	}

	public static void main(String[] args) {
		String format = Title.MR.format("DK", "Sharma");
		System.out.println(format);
	}
}
