package com.java;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.java.utility.Utility;

public class RegexTest {
	public static void main(String[] args) throws IOException {
		String plainPassword = "aaaAaa123\\";
		Properties pr = Utility.properties();
		System.out.println(pr.getProperty("server"));
		
		
		Map<String, String> map = new HashMap<>();
		map.put("p1", pr.getProperty("p1"));
		map.put("p2", pr.getProperty("p2"));
		map.put("p3", pr.getProperty("p3"));
		map.put("p4", pr.getProperty("p4"));
		map.put("p5", pr.getProperty("p5"));

		for (Entry<String, String> entry : map.entrySet()) {
			if (plainPassword.matches(entry.getValue())) {
				System.out.println("ok."+entry.getKey()+" -> "+entry.getValue());
			}else {
				System.out.println("notok."+entry.getKey()+" -> "+entry.getValue());
			}

		}

	}
}
