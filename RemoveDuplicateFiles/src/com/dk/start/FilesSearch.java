package com.dk.start;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FilesSearch {
	static{
		System.setProperty("-DXmx", "1G");
	}

	static Map<String, Integer> map = new HashMap<>();
	static int c=0;
public static void main(String[] args) {
	printAllFileName("E:/PHOTOS/Birthday");
	System.out.println("MAP-->"+map);
}

private static void printAllFileName(String path) {
	File dirPath = new File(path);
	File[] listFiles = dirPath.listFiles();
	for (File file : listFiles) {
		if(file.isDirectory()) {
			System.out.println("--------------DIRACTORY-----------------"+file.getName());
			 printAllFileName(file.getAbsolutePath()); 
		}else {
			if(!map.containsKey(file.getName())) {
				map.put(file.getName(), c);
			}else {
				int v =map.get(file.getName());
				map.put(file.getName(), v+1);
			}
			System.out.println(file.getAbsolutePath());
		}
	}
}
}
