package com.security;

public class MainTest {
public static void main(String[] args) throws Exception {
//	byte[] secretKey = Common.generateKey().getEncoded();
//	Map<String, String> encrypt = AesEncDec.encrypt("Hello", secretKey, null);
//	String string = encrypt.get("data");
//	System.out.println(string);
//	
//	AesEncDec.decrypt(string, secretKey, null);
//	
	
//	String encrypt2 = RsaEncDec.encrypt("Hello", "./public_key.pem");
//	System.out.println(encrypt2);
//	String decrypt = RsaEncDec.decrypt(encrypt2, "./private_key.pem");
//	System.out.println(decrypt);
	
	String encrypt3 = RsaEncDec.encryptWithJks("Hello", "dk.com");
	System.out.println("EC "+encrypt3);
	String decrypt3 = RsaEncDec.decryptWithJks(encrypt3, "dk.com");
	System.out.println("DC "+decrypt3);
	
	
	
	String genratesignature = Common.genratesignature("Hello World", "./private_key.pem");
	boolean verifySign = Common.verifySign("Hello World", genratesignature, "./public_key.pem");
	System.out.println("Sign verify :: " + verifySign);
}
}
