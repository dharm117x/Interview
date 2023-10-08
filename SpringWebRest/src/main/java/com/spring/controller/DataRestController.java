package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.ProductBean;

@RestController
public class DataRestController {

	@GetMapping("/products")
	private List<ProductBean> getProducts() {
		List<ProductBean> beans = new ArrayList<ProductBean>();
		ProductBean bean = new ProductBean("1", "P1", "11.12");
		beans.add(bean);
		return beans;
	}
	
	@GetMapping("/download")
	public ResponseEntity<?> downloadFile(@RequestParam String name) throws IOException {
		File file = ResourceUtils.getFile("classpath:files/"+name);
		
		byte[] body = FileUtils.readFileToByteArray(file);
		ResponseEntity<byte[]> entity = ResponseEntity.ok()
				.header("Content-Disposition", "attachment; filename=" + file.getName())
				.contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.contentLength(file.length()).body(body);
		
		return entity;
	}
	
}
