package com.security;

import java.util.Base64;

import javax.crypto.Cipher;

public class RsaEncDec {
	
	public static void main(String[] args) throws Exception {
		String encrypt = encrypt("Hello Java World", "./public_key.pem");
		System.out.println("EC::" + encrypt);
		encrypt = Common.fileReader("./data.txt");
		String decrypt = decrypt(encrypt, "./private_key.pem");
		System.out.println(decrypt);
	}

	public static String encrypt(String plainData, String publicKeyPath) throws Exception {
		
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, PemFileReader.getPublicKey(publicKeyPath));
		byte[] doFinal = cipher.doFinal(plainData.getBytes());
		String encData = Base64.getEncoder().encodeToString(doFinal);
		
		return encData;
	}


	public static String decrypt(String encData, String privateKeyPath) throws Exception {

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, PemFileReader.getPrivateKey(privateKeyPath));
		byte[] doFinal = cipher.doFinal(Base64.getDecoder().decode(encData));
		String plainData = new String(doFinal);

		return plainData;
	}
	
	public static String encryptWithJks(String plainData, String aliasPublic) throws Exception {
		
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, JKSFileReader.getPublicKey(aliasPublic));
		byte[] doFinal = cipher.doFinal(plainData.getBytes());
		String encData = Base64.getEncoder().encodeToString(doFinal);
		
		return encData;
	}

	public static String decryptWithJks(String encData, String aliasPrivate) throws Exception {

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, JKSFileReader.getPrivateKey(aliasPrivate));
		byte[] doFinal = cipher.doFinal(Base64.getDecoder().decode(encData));
		String plainData = new String(doFinal);

		return plainData;
	}
	
	
	
}
