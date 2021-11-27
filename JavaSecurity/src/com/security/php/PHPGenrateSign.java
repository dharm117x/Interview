package com.security.php;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class PHPGenrateSign {

	public static void main(String[] args) {
		String string = generateSignature("hello");
		System.out.println(string.equals("rrZnatvohJjKhKhQLoy21p6LF5E="));
	}
	
	
	static String generateSignature (String data) {
		String encoded = "";
		String type = "HmacSHA1";	
		try {
			byte[] key = ("KEY").getBytes("UTF-8");
			byte[] Sequence = data.getBytes("UTF-8");
			Mac HMAC = Mac.getInstance(type);
			SecretKeySpec secretKey = new SecretKeySpec(key, type);
			HMAC.init(secretKey);
			byte[] Hash = HMAC.doFinal(Sequence);
			encoded = Base64.getEncoder().encodeToString(Hash);

		} catch (Exception e) {
			e.printStackTrace();
		}
	    return encoded;
	}
}
