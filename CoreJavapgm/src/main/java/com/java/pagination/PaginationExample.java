package com.java.pagination;
import java.util.ArrayList;
import java.util.List;

public class PaginationExample {
    public static void main(String[] args) {
        // Create a sample list of data
        List<String> dataList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            dataList.add("Item " + i);
        }

        int pageSize = 10; // Number of items per page
        int totalItems = dataList.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        int currentPage = 2;
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalItems);

        List<String> currentPageItems = dataList.subList(startIndex, endIndex);

        // Print the current page items
        for (String item : currentPageItems) {
            System.out.println(item);
        }

        System.out.println("Page " + currentPage + " of " + totalPages);
    }
}