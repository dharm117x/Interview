package com.security;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesEncDec {

	private static final String AES_GCM_NO_PADDING = "AES/GCM/NoPadding";

	public static void main(String[] args) throws Exception {
		
 		
		String encData = "7R1mgth28ygRx+s0+6WrUhWacb4EKOVwOTn+";
		byte[] encodedKey = Base64.getDecoder().decode("lBn9fKURMSgicTP1lXcVwrTNCaxTu9oILfgXwyh/AuM");
		decrypt(encData, encodedKey);
	}
	
	public static String encrypt(String plainData, byte[] encodedKey ) throws Exception {

		Cipher cipher = Cipher.getInstance(AES_GCM_NO_PADDING);
		Key key = new SecretKeySpec(encodedKey, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(128, new byte[16]));
		byte[] doFinal = cipher.doFinal(plainData.getBytes());
		String encData = Base64.getEncoder().encodeToString(doFinal);
		System.out.println("EC::" + encData);
		
		return encData;
	}

	public static String decrypt(String encData, byte[] encodedKey) throws Exception {

		Cipher cipher = Cipher.getInstance(AES_GCM_NO_PADDING);
		Key key = new SecretKeySpec(encodedKey, "AES");

		cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(128, new byte[16]));
		byte[] doFinal = cipher.doFinal(Base64.getDecoder().decode(encData));
		String plainData = new String(doFinal);
		System.out.println("DC ::" + plainData);

		return plainData;
	}

}
