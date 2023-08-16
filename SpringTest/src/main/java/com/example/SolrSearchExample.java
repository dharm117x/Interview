 package com.example;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class SolrSearchExample {

    public static void main(String[] args) {
        // Solr server URL
        String solrUrl = "http://localhost:8983/solr/products";

        // Create a SolrClient instance
        SolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();

        // Create a SolrQuery instance for the search
        SolrQuery query = new SolrQuery();
//        query.setQuery("text_field:search term"); // Replace with your field name and search term
        query.setQuery("id:*"); // Replace with your field name and search term

        // Execute the search
        try {
            QueryResponse response = solrClient.query(query);
            SolrDocumentList results = response.getResults();

            // Process and display search results
            System.out.println("Total Results: " + results.getNumFound());
            for (int i = 0; i < results.size(); i++) {
                System.out.println("Result " + (i + 1) + ": " + results.get(i));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the SolrClient
            try {
                solrClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
