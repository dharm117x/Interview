package com.spring.controller;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beans.ProductBean;

@Controller
@RequestMapping("/solr")
public class SolrController {

	@Autowired
	SolrClient solr;
	
	@GetMapping("/setup")
	private String setup() throws SolrServerException, IOException {
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "123456");
		document.addField("name", "Kenmore Dishwasher");
		document.addField("price", "599.99");
		solr.add(document);
		solr.commit();
		
		solr.addBean( new ProductBean("888", "Apple iPhone 6s", "299.99") );
		solr.commit();
		
		return "setup done";
	}
	
	
	@GetMapping("/search")
	public void search() throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		query.set("q", "price:599.99");
		QueryResponse response = solr.query(query);

		SolrDocumentList docList = response.getResults();

		for (SolrDocument doc : docList) {
			System.out.println("ID: "+ doc.getFieldValue("id"));
			System.out.println("Price: "+ doc.getFieldValue("price"));
		}
	}
	
	@GetMapping("/delete/{id}")
	public void deleteById(@PathVariable String id) throws SolrServerException, IOException {
		solr.deleteById(id);
		solr.commit();
		SolrQuery query = new SolrQuery();
		query.set("q", "id:"+id);
		QueryResponse response = solr.query(query);
		SolrDocumentList docList = response.getResults();
		System.out.println(docList);
	}
	
	
}
