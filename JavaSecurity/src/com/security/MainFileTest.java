package com.security;

import java.io.File;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MainFileTest {
public static void main(String[] args) throws Exception {
	byte[] secretKey = Common.generateKey().getEncoded();
	
	SecretKey key = new SecretKeySpec(secretKey, "AES");
	FileEncDec.encryptFile(key, new File("./inputFile.txt"), new File("./outputFile.txt"));
	FileEncDec.decryptFile(key, new File("./outputFile.txt"), new File("./newOutputFile.txt"));
}
}
