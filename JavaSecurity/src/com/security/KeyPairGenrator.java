package com.security;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KeyPairGenrator {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		KeyPair keyPair = keyGen.genKeyPair();

		byte[] publicKey = keyPair.getPublic().getEncoded();
		String encodeToString = Base64.getEncoder().encodeToString(publicKey);
		System.out.println(encodeToString);

		genrateFile(encodeToString,"public_key.pem");
		
		byte[] privateKey = keyPair.getPrivate().getEncoded();

		System.out.println("---------");
		String encodeToString2 = Base64.getEncoder().encodeToString(privateKey);
		System.out.println();
		genrateFile(encodeToString2,"private_key.pem");
		
	}

	private static void genrateFile(String encodeToString, String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName)) {
			fos.write(encodeToString.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
