package com.java;

import java.io.File;
import java.net.URI;
import java.nio.file.Paths;

public class FileTest {
public static void main(String[] args) {
 String url = "https://dkshopUS.local:9002/medias/studentDetails.xlsx?context=bWFzdGVyfHN0dWRlbnRzfDM1MzV8YXBwbGljYXRpb24vdm5kLm9wZW54bWxmb3JtYXRzLW9mZmljZWRvY3VtZW50LnNwcmVhZHNoZWV0bWwuc2hlZXR8c3R1ZGVudHMvaDE2L2hlOS84Nzk2NTg0NjA3Nzc0LmJpbnxlYTViZTVlMWM0YWE3YzVlOTI2ZmQ0ZWZmMzVjMjUyYTAyMDVjMWE1YmE0MjU1NDEzMjA2YzYzNjYzOTFlNTI0&attachment=true";
 final File file = Paths.get(URI.create(url)).toFile();
 
 System.out.println(file);
		
}
}
