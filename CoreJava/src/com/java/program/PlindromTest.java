package com.java.program;

public class PlindromTest {
public static void main(String[] args) {
	numberTest(141);
	stringTest("ASSA");
}

//141 141
private static void numberTest(int number) {
	int orig = number;
	int revs = 0;
	while (number>0) {
		revs= revs *10 + number%10;
		number= number/10;
	}

	if(orig == revs) {
		System.out.println("YES");
	}else {
		System.out.println("NO");
	}
	
}

//ASA ASA
private static void stringTest(String str) {
	char[] array = str.toCharArray();
	char[] revc= new char[array.length];
	String revs= "";
	for (int i = array.length-1, j=0; i >=0 ; i--,j++) {
		revc[j]= array[i];
		revs = array[i] + revs;
	}
	
	System.out.println("Reves::"+revs);
	
	String string = new String(revc);

	if(str.equals(string)) {
		System.out.println("YES");
	}else {
		System.out.println("NO");
	}
}

}
