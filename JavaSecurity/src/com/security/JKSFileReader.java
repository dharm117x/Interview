package com.security;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class JKSFileReader {
	public static void main(String[] args) throws Exception {

		PrivateKey privateKey = getPrivateKey("dk.com");
		System.out.println("PK " + privateKey);
		PublicKey publicKey = getPublicKey("dk.com");
		System.out.println("PuK " + publicKey);
	}

	public static PrivateKey getPrivateKey(String alias) throws Exception {
		KeyPair keyPair = loadKeyPair(alias);
		return keyPair.getPrivate();
	}

	public static PublicKey getPublicKey(String alias) throws Exception {
		KeyPair keyPair = loadKeyPair(alias);
		return keyPair.getPublic();
	}

	private static KeyPair loadKeyPair(String alias) throws Exception {
		char[] pass = "changeit".toCharArray();
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		try (InputStream keyStoreData = new FileInputStream("mydomain.jks")) {
			keyStore.load(keyStoreData, pass);
			Key key = keyStore.getKey(alias, pass);
			if (key instanceof PrivateKey) {
				System.out.println("Private Key");
				Certificate certificate = keyStore.getCertificate(alias);
				PublicKey publicKey = certificate.getPublicKey();
				return new KeyPair(publicKey, (PrivateKey) key);
			} else {
				System.out.println("Public key");
			}

		}
		return null;
	}
}
