package com.example.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UN");
	
	public static EntityManagerFactory getEMFactory() {
		return emf;
	}
	
}
