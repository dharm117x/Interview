package com.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import net.oauth.signature.pem.PEMReader;

public class PemFileReader {
	private static final String RSA = "RSA";
	
	public static void main(String[] args) throws GeneralSecurityException, IOException {
		PublicKey pubKey = getPublicKey("public_key.pem");
		System.out.println(""+pubKey);
	}
	
	public static PublicKey getPublicKey(String publicKeyFilename) throws GeneralSecurityException, IOException {
		PEMReader reader = new PEMReader(publicKeyFilename);
		byte[] bytes = reader.getDerBytes();
		PublicKey pubKey;

		if (PEMReader.PUBLIC_X509_MARKER.equals(reader.getBeginMarker())) {
			KeySpec keySpec = new X509EncodedKeySpec(bytes);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			pubKey = fac.generatePublic(keySpec);
		} else if (PEMReader.CERTIFICATE_X509_MARKER.equals(reader.getBeginMarker())) {
			pubKey = getPublicKeyFromDerCert(bytes);
		} else {
			throw new IOException(
					"Invalid PEM fileL: Unknown marker for " + " public key or cert " + reader.getBeginMarker());
		}
		return pubKey;
	}

	private static PublicKey getPublicKeyFromDerCert(byte[] certObject) throws GeneralSecurityException {
		CertificateFactory fac = CertificateFactory.getInstance("X509");
		ByteArrayInputStream in = new ByteArrayInputStream(certObject);
		X509Certificate cert = (X509Certificate) fac.generateCertificate(in);
		return cert.getPublicKey();
	}

	public static PrivateKey getPrivateKey(String privateKeyFileName) throws GeneralSecurityException, IOException {
		PEMReader reader = new PEMReader(privateKeyFileName);
		byte[] bytes = reader.getDerBytes();
		PrivateKey privateKey;
		java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		if (PEMReader.PRIVATE_PKCS1_MARKER.equals(reader.getBeginMarker())) {
			KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
			KeyFactory fac = KeyFactory.getInstance(RSA);
			privateKey = fac.generatePrivate(keySpec);
		} else if (PEMReader.PRIVATE_PKCS1_MARKER.equals(reader.getBeginMarker())) {
			KeySpec keySpec = new X509EncodedKeySpec(bytes);
			KeyFactory fac = KeyFactory.getInstance(RSA);
			privateKey = fac.generatePrivate(keySpec);
		} else {
			throw new IOException(
					"Invalid PEM fileL: Unknown marker for " + " public key or cert " + reader.getBeginMarker());
		}

		return privateKey;
	}
}
