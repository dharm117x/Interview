package com.security.php;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class PHPAesEncDec {

	private static final String CIPHER = "AES/CBC/PKCS5Padding";
	static IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]);

	
	public static void main(String[] args) throws Exception {
		String encrypt = encrypt("Hello World", "tHeApAcHe6410111".getBytes());
		System.out.println(encrypt);
		decrypt("8DKatOr+E4osUUaFabramw==", "tHeApAcHe6410111".getBytes());
	}	
	
	public static String encrypt(String plainData, byte[] encodedKey) throws Exception {

		Cipher cipher = Cipher.getInstance(CIPHER);
		Key key = new SecretKeySpec(encodedKey, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
		byte[] doFinal = cipher.doFinal(plainData.getBytes());
		String encData = Base64.getEncoder().encodeToString(doFinal);
		return encData;
	}

	public static String decrypt(String encData, byte[] encodedKey) throws Exception {

		Cipher cipher = Cipher.getInstance(CIPHER);
		Key key = new SecretKeySpec(encodedKey, "AES");
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		byte[] doFinal = cipher.doFinal(Base64.getDecoder().decode(encData));
		String plainData = new String(doFinal);
		System.out.println("DC ::" + plainData);

		return plainData;
	}

}
