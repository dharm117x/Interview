package com.example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import com.github.axet.vget.VGet;

public class YVideoDownload {
public static void main(String[] args) throws MalformedURLException {
	URL source = new URL("https://www.youtube.com/watch?v=_2IYkJ8Qt1g");
	File target = new File("D:/programs/data/asd.mp4");
	VGet v = new VGet(source, target );
	v.download();
}
}
