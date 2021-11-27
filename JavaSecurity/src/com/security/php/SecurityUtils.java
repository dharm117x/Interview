package com.security.php;


import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;

import com.security.Common;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.File;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
* @author hp
*/
public class SecurityUtils {
	// string name of the encryption algorithm
	public static final String ALGORITHM = "RSA";
	 // string Encryption Padding name
	public static final String PADDING = "RSA/NONE/NoPadding";
	 // string holding the name of the security provider
	public static final String PROVIDER = "BC";
	 // private key
	 public static final String PRIVATE_KEY = "private String";
	 // public
	 public static final String PUBLIC_KEY = "Public Key string";


	 public static void main(String[] args) throws Exception {
		String encrypt = encrypt("Hello World");
		System.out.println(encrypt);
	}
	 
	/**
	  * Private
	  * The string RSA encryption
	 *
	 * @param text
	 * @return
	 * @throws Exception 
	 */
	public static String encrypt(String text) throws Exception {
		RSAPublicKey readPublicKey = Common.readPublicKey(new File("./public_key.pem"));
		
		String cipherTextBase64 = "";
		try {
//			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decode(PRIVATE_KEY));
//			PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
//			
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", PROVIDER);
			cipher.init(Cipher.ENCRYPT_MODE, readPublicKey);
			byte[] cipherText = cipher.doFinal(text.getBytes());
			cipherTextBase64 = Base64.encode(cipherText);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return cipherTextBase64;
	}

	/**
	  * Public Key
	  * The string to decrypt RSA
	 *
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static String decrypt(String str) throws Exception {
		RSAPrivateKey readPrivateKey = Common.readPrivateKey(new File("./private_key.pem"));
		
		byte[] dectyptedText = null;
		try {
			BASE64Decoder base64Decoder= new BASE64Decoder();
			byte[] buffer= base64Decoder.decodeBuffer(PUBLIC_KEY);
			KeyFactory keyFactory= KeyFactory.getInstance("RSA");
			X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);

			PublicKey publickey=keyFactory.generatePublic(keySpec);
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, publickey);
			byte[] text = Base64.decode(str);
			dectyptedText = cipher.doFinal(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(dectyptedText);
	}
}