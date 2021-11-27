package com.security;

import java.io.File;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class MainPhpTest {
	public static final String KEY_ALGORITHM1 = "RSA/ECB/PKCS1Padding"; 
	public static final String KEY_ALGORITHM = "RSA/NONE/NoPadding"; 

	static {
//		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}
	public static void main(String[] args) throws Exception {

		String encrypt = "F1QmxcKvfSGVY0z7QnR1KtwAOABtEkMh61AyslEP69kzXl+9eul7y5aa49RX2+qhG1DSnCgckHT+mxkF6v/JpQWPXpmDX4tyTryDcrWZbv3dvmSYw6Y2DVcRRYGnNtpa/vf0+Q/PVkpzz552fqWCTrenEwPQxVgkFHfzafm86qE9LhmPVYKjI3nwnrK2sc5jtzjbGuFXwMuKm351gT1DFp3xjYcf7BB2r0/f5s6PTYer2ZK1tkGu6ZOjNom2m+tEgW2amCKkAuYEaZb4QGwKf0pfeROhl+uDrqbusbb/rajSoG+49cHl/TVbhRE6X+3O17JT/knXMxgP59pqwsYr0A==";

		RSAPrivateKey readPrivateKey = Common.readPrivateKey(new File("./private_key.pem"));
		RSAPublicKey readPublicKey = Common.readPublicKey(new File("./public_key.pem"));
		
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM, "BC");
		cipher.init(Cipher.DECRYPT_MODE, readPrivateKey);
		byte[] encryptedData = Base64.getDecoder().decode(encrypt);
		byte[] doFinal = cipher.doFinal(encryptedData);
		String string = new String(doFinal, "UTF-8");
		System.out.println("DC: " + string);

	}
}
