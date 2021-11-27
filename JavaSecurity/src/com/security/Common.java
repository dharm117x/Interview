package com.security;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Common {

	public static String fileReader(String filePath) throws IOException {
		return new String(Files.readAllBytes(new File(filePath).toPath()), Charset.defaultCharset());
	}

	public static SecretKey getKeyFromPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		return secret;
	}
	
	public static SecretKey generateKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(256);
		return keyGenerator.generateKey();
	}
	

	public static String genratesignature(String data, String privateKey) throws Exception {
		Signature signature = Signature.getInstance("SHA256WITHRSA");
		signature.initSign(readPrivateKey(new File(privateKey)));
		signature.update(data.getBytes());
		byte[] sign = signature.sign();
		return Base64.getEncoder().encodeToString(sign);
	}
	
	public static boolean verifySign(String newData, String givenSign, String publicKey) throws Exception {
		Signature signature = Signature.getInstance("SHA256WITHRSA");
		signature.initVerify(readPublicKey(new File(publicKey)));
		signature.update(newData.getBytes());
		byte[] decodeSign = Base64.getDecoder().decode(givenSign);
		boolean sign = signature.verify(decodeSign);
		return sign;
		
	}
	public static Key getPrivateKey(String filePath) throws IOException {
		File file = new File(filePath);
		String pkey = new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());
		return null;
	}
	
	public static RSAPublicKey readPublicKey(File file) throws Exception {
	    String key = new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());

	    String publicKeyPEM = key
	      .replace("-----BEGIN PUBLIC KEY-----", "")
	      .replaceAll("\n", "")
	      .replace("-----END PUBLIC KEY-----", "");

	    byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);

	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
	    return (RSAPublicKey) keyFactory.generatePublic(keySpec);
	}
	
	public static RSAPrivateKey readPrivateKey(File file) throws Exception {
	    String key = new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());

	    String privateKeyPEM = key
	      .replace("-----BEGIN RSA PRIVATE KEY-----", "")
	      .replaceAll("\n", "")
	      .replace("-----END RSA PRIVATE KEY-----", "");

	    byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);

	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
	    return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
	}
}
