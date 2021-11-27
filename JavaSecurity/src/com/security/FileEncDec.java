package com.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class FileEncDec {
	
	private static final String ALGORITHAM = "AES/CBC/PKCS5Padding";

	static IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]);

	public static void encryptFile(SecretKey key, File inputFile, File outputFile) throws Exception {

		Cipher cipher = Cipher.getInstance(ALGORITHAM);
		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
		
		FileInputStream inputStream = new FileInputStream(inputFile);
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		byte[] buffer = new byte[64];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			byte[] output = cipher.update(buffer, 0, bytesRead);
			if (output != null) {
				outputStream.write(output);
			}
		}
		byte[] outputBytes = cipher.doFinal();
		if (outputBytes != null) {
			outputStream.write(outputBytes);
		}
		inputStream.close();
		outputStream.close();
	}

	public static void decryptFile(SecretKey key, File inputFile, File outputFile) throws Exception {

		Cipher cipher = Cipher.getInstance(ALGORITHAM);
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		FileInputStream inputStream = new FileInputStream(inputFile);
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		byte[] buffer = new byte[64];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			byte[] output = cipher.update(buffer, 0, bytesRead);
			if (output != null) {
				outputStream.write(output);
			}
		}
		byte[] outputBytes = cipher.doFinal();
		if (outputBytes != null) {
			outputStream.write(outputBytes);
		}
		inputStream.close();
		outputStream.close();
	}
	
}
